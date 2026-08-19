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
        // AFK 보정: 60초 초과 시 최대 60초로 클램핑 (자리 비움 방어)
        const clampedTimeSec = Math.min(responseTimeSec, 60);
        // Local fallback with confusion detection + SM-2
        const matchResult = evaluateAnswerMatch(userInput, word, this.words);

        if (matchResult.isCorrect) {
          soundEffects.playSuccess();
          const quality = inferQualityScore(true, clampedTimeSec, this.activeSession.hintCount, this.activeSession.typoCount);
          const currentProgress = this.progressMap[word.wordId] || {};
          const newProgress = sm2Engine.calculateNextReview(currentProgress, quality);
          this.progressMap[word.wordId] = newProgress;
          this._persistProgressMap();
          // XP 경제학: 오늘 이미 푼 단어는 +0, 신규/복습 대기는 +20, 장기 방어는 +50
          const xpReward = this._calculateXpReward(word.wordId, currentProgress);
          if (xpReward > 0) {
            const gameStore = useGamificationStore();
            gameStore.addXp(xpReward);
          }
          return { status: "CORRECT", word };
        } else if (matchResult.isConfusion) {
          // 혼동 오답: 다른 IT 용어와 혼동 → 오답 분석 모달 트리거
          soundEffects.playError();
          this.activeSession.items.push(word);
          const currentProgress = this.progressMap[word.wordId] || {};
          const newProgress = sm2Engine.calculateNextReview(currentProgress, 0);
          this.progressMap[word.wordId] = newProgress;
          this._persistProgressMap();
          return {
            status: "INCORRECT",
            word,
            correctTerm: word.term,
            isConfusion: true,
            confusedWith: matchResult.confusedWith,
            feedback: {
              correctConcept: `${word.term} : ${word.easyMeaning}`,
              practicalTip: `'${matchResult.confusedWith}'와(과) '${word.term}'은(는) 서로 다른 개념입니다. ${word.contextSentence ? word.contextSentence.replace(/\{\{/g, '').replace(/\}\}/g, '') : ''}`,
              isDynamic: true,
            },
            isAiGenerated: false,
          };
        } else if (matchResult.isTypo) {
          this.activeSession.typoCount += 1;
          return {
            status: "TYPO_WARNING",
            message: "앗, 오타인가요? 거의 맞았습니다! 철자를 다시 확인해 보세요! ✍️",
          };
        } else {
          soundEffects.playError();
          this.activeSession.items.push(word);
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
    },

    /**
     * XP 경제학: 망각 곡선 비례 경험치 + 어뷰징 방지
     * - 오늘 이미 푼 단어 반복: +0 XP (어뷰징 차단)
     * - 신규/복습 대기 단어 정답: +20 XP
     * - 복습 주기 14일 이상 장기 기억 방어: +50 XP (잭팟)
     * - 일일 최대 1,000 XP 상한
     */
    _calculateXpReward(wordId, prevProgress) {
      const today = new Date().toDateString();
      // 일일 학습 기록 초기화
      if (!this._todayXpLog || this._todayXpLog.date !== today) {
        this._todayXpLog = { date: today, totalXp: 0, answeredWords: new Set() };
      }
      // 일일 상한 체크
      if (this._todayXpLog.totalXp >= 1000) return 0;
      // 오늘 이미 푼 단어 → +0 (어뷰징 차단)
      if (this._todayXpLog.answeredWords.has(wordId)) return 0;
      this._todayXpLog.answeredWords.add(wordId);

      let reward = 20; // 기본 보상
      // 장기 기억 방어 잭팟: 복습 주기 14일 이상
      if (prevProgress && prevProgress.intervalDays >= 14) {
        reward = 50;
      }
      // 일일 상한 초과 방지
      reward = Math.min(reward, 1000 - this._todayXpLog.totalXp);
      this._todayXpLog.totalXp += reward;
      return reward;
    }
  }
});
