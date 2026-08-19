import { defineStore } from "pinia";
import { INITIAL_WORDS } from "../data/curriculumData.js";
import { soundEffects } from "../services/ttsService.js";
import { useGamificationStore } from "./useGamificationStore.js";
import { STORAGE_KEYS } from "../constants.js";
import { api } from "../services/apiClient.js";
import { evaluateAnswerMatch } from "../services/levenshtein.js";
import { sm2Engine, inferQualityScore } from "../services/sm2Engine.js";

// Fisher-Yates shuffle for randomizing card order
function shuffleArray(arr) {
  for (let i = arr.length - 1; i > 0; i--) {
    const j = Math.floor(Math.random() * (i + 1));
    [arr[i], arr[j]] = [arr[j], arr[i]];
  }
  return arr;
}

// Get user-specific localStorage key for progress isolation
function getUserProgressKey() {
  try {
    const saved = localStorage.getItem(STORAGE_KEYS.AUTH_SESSION);
    if (saved) {
      const session = JSON.parse(saved);
      if (session.userId) return `skavoca_progress_${session.userId}`;
    }
  } catch(e) {}
  return 'skavoca_progress_guest';
}

export const useLearningStore = defineStore("learning", {
  state: () => {
    let customWords = [];
    try {
      const customData = localStorage.getItem(STORAGE_KEYS.CUSTOM_WORDS);
      if (customData) {
        customWords = JSON.parse(customData);
      }
    } catch(e) { console.warn(e); }

    // Restore progress from localStorage (SM-2, per-user isolated)
    let savedProgress = {};
    try {
      const saved = localStorage.getItem(getUserProgressKey());
      if (saved) savedProgress = JSON.parse(saved);
    } catch(e) { console.warn(e); }

    return {
      words: [...INITIAL_WORDS, ...customWords],
      progressMap: savedProgress,
      activeSession: {
        items: [],
        currentIndex: 0,
        startTime: null,
        hintCount: 0,
        typoCount: 0,
        isCompleted: false
      }
    };
  },

  getters: {
    dueWords: (state) => {
      const now = new Date();
      return state.words.filter((word) => {
        const progress = state.progressMap[word.wordId];
        if (!progress) return true; // Unlearned new word
        return new Date(progress.nextPracticeDate) <= now;
      });
    },

    weakWords: (state) => {
      return state.words
        .map((word) => {
          const p = state.progressMap[word.wordId] || { easinessFactor: 2.5, totalLapses: 0 };
          return { ...word, progress: p };
        })
        .filter((w) => w.progress.easinessFactor <= 1.8 || w.progress.totalLapses > 0)
        .sort((a, b) => a.progress.easinessFactor - b.progress.easinessFactor);
    },

    currentSessionWord: (state) => {
      if (!state.activeSession.items.length) return null;
      return state.activeSession.items[state.activeSession.currentIndex] || null;
    }
  },

  actions: {
    async fetchProgress() {
      try {
        // Fetch today's deck or progress data
        const { data } = await api.getTodayDeck();
        if (data && data.progressMap) {
          this.progressMap = data.progressMap;
        } else if (Array.isArray(data)) {
          const map = {};
          data.forEach(item => {
            if (item.wordId && item.progress) map[item.wordId] = item.progress;
            else if (item.wordId) map[item.wordId] = item; // fallback
          });
          this.progressMap = map;
        }
      } catch (e) {
        console.error("Failed to fetch progress from API", e);
      }
    },

    saveCustomWords() {
      try {
        const customWords = this.words.filter(w => w.wordId >= 1000);
        if (customWords.length > 0) {
          localStorage.setItem(STORAGE_KEYS.CUSTOM_WORDS, JSON.stringify(customWords));
        }
      } catch(e) { console.warn(e); }
    },

    awardFeedbackXp() {
      const gameStore = useGamificationStore();
      // XP is managed by backend, but we can do optimistic update if needed or rely on profile fetch
      gameStore.addXp(5);
    },

    startLearningSession(customWords = null) {
      const targetList = customWords || (this.dueWords.length > 0 ? this.dueWords : this.words);
      this.activeSession = {
        items: shuffleArray([...targetList]),
        currentIndex: 0,
        startTime: Date.now(),
        hintCount: 0,
        typoCount: 0,
        isCompleted: false
      };
    },

    startReviewSession() {
      this.activeSession = {
        items: shuffleArray([...this.words]),
        currentIndex: 0,
        startTime: Date.now(),
        hintCount: 0,
        typoCount: 0,
        isCompleted: false
      };
    },

    async submitAnswer(userInput) {
      const word = this.currentSessionWord;
      if (!word) return { status: "ERROR" };

      const responseTimeSec = Math.max(1, (Date.now() - this.activeSession.startTime) / 1000);
      
      try {
        const { data } = await api.submitAnswer({
          wordId: word.wordId,
          userInput,
          responseTimeSec,
          hintCount: this.activeSession.hintCount,
          typoCount: this.activeSession.typoCount
        });

        // Map backend field name "resultType" → frontend "status"
        const status = data.resultType || data.status || "ERROR";

        // Update local progress from algorithmMetrics
        if (data.algorithmMetrics) {
          const nextDate = new Date();
          nextDate.setDate(nextDate.getDate() + (data.algorithmMetrics.newInterval || 1));
          this.progressMap[word.wordId] = {
            easinessFactor: data.algorithmMetrics.newEf,
            intervalDays: data.algorithmMetrics.newInterval,
            repetitions: data.algorithmMetrics.repetitions,
            nextPracticeDate: nextDate.toISOString(),
            lastReviewedAt: new Date().toISOString(),
          };
          this._persistProgressMap();
        }

        if (status === "CORRECT") {
          soundEffects.playSuccess();
        } else if (status === "TYPO_WARNING") {
          this.activeSession.typoCount += 1;
        } else if (status === "INCORRECT") {
          soundEffects.playError();
          this.activeSession.items.push(word);
        }

        return {
          status,
          word,
          correctTerm: data.correctTerm || word.term,
          message: data.message,
          feedback: data.feedback,
          isAiGenerated: !!data.feedback,
          similarity: data.similarity,
          isCanonicalMatch: data.isCorrect,
        };
      } catch (err) {
        console.error("Answer submission failed, using local fallback", err);
        // Local fallback with full SM-2 support (using static imports)
        const matchResult = evaluateAnswerMatch(userInput, word);

        if (matchResult.isCorrect) {
          soundEffects.playSuccess();
          // Apply SM-2 locally for correct answers
          const quality = inferQualityScore(true, responseTimeSec, this.activeSession.hintCount, this.activeSession.typoCount);
          const currentProgress = this.progressMap[word.wordId] || {};
          const newProgress = sm2Engine.calculateNextReview(currentProgress, quality);
          this.progressMap[word.wordId] = newProgress;
          this._persistProgressMap();
          return { status: "CORRECT", word };
        } else if (matchResult.isTypo) {
          this.activeSession.typoCount += 1;
          return {
            status: "TYPO_WARNING",
            message: "앗, 오타인가요? 거의 맞았습니다! 철자를 다시 확인해 보세요! ✍️",
          };
        } else {
          soundEffects.playError();
          this.activeSession.items.push(word);
          // Apply SM-2 locally for incorrect answers (quality = 0)
          const currentProgress = this.progressMap[word.wordId] || {};
          const newProgress = sm2Engine.calculateNextReview(currentProgress, 0);
          this.progressMap[word.wordId] = newProgress;
          this._persistProgressMap();
          return {
            status: "INCORRECT",
            word,
            correctTerm: word.term,
            feedback: {
              correctConcept: `${word.term} : ${word.easyMeaning}`,
              practicalTip: word.contextSentence
                ? word.contextSentence.replace(/\{\{/g, '').replace(/\}\}/g, '')
                : `${word.term}의 의미와 사용 맥락을 반복 학습해 보세요.`,
              isDynamic: true,
            },
            isAiGenerated: false,
          };
        }
      }
    },

    nextQuestion() {
      this.activeSession.currentIndex += 1;
      this.activeSession.startTime = Date.now();
      this.activeSession.hintCount = 0;
      this.activeSession.typoCount = 0;

      if (this.activeSession.currentIndex >= this.activeSession.items.length) {
        this.activeSession.isCompleted = true;
      }
    },

    useHint() {
      this.activeSession.hintCount += 1;
    },

    // Optimistic UI for Tinder Swipe Cards
    async rateCardOptimistic(wordId, quality) {
      soundEffects.playSwipe();
      
      const word = this.words.find(w => w.wordId === wordId);
      if (word) {
        const userInput = quality >= 3 ? word.term : "wrong_swipe";
        try {
          const { data } = await api.submitAnswer({
            wordId: wordId,
            userInput: userInput,
            responseTimeSec: 2,
            hintCount: 0,
            typoCount: 0
          });
          if (data.algorithmMetrics) {
            this.progressMap[wordId] = {
              easinessFactor: data.algorithmMetrics.newEf,
              intervalDays: data.algorithmMetrics.newInterval,
              repetitions: data.algorithmMetrics.repetitions,
            };
          }
        } catch(e) {
          console.error("Swipe rating failed, continuing locally", e);
        }
      }

      this.activeSession.currentIndex += 1;
      if (this.activeSession.currentIndex >= this.activeSession.items.length) {
        this.activeSession.isCompleted = true;
      }
    },

    _persistProgressMap() {
      try {
        localStorage.setItem(getUserProgressKey(), JSON.stringify(this.progressMap));
      } catch(e) { console.warn('Failed to persist progress', e); }
    },

    // Call when user logs in/out to reload the correct user's progress
    reloadUserProgress() {
      try {
        const saved = localStorage.getItem(getUserProgressKey());
        this.progressMap = saved ? JSON.parse(saved) : {};
      } catch(e) {
        this.progressMap = {};
      }
    }
  }
});
