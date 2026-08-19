<template>
  <div class="learn-session-container">
    <!-- Session Header -->
    <div class="session-header">
      <button class="exit-btn" @click="router.push({ name: 'home' })">✕ 종료</button>

      <div class="session-progress-wrapper">
        <div class="progress-bar">
          <div class="progress-fill" :style="{ width: progressPercent + '%' }"></div>
        </div>
        <span class="progress-text">
          {{ store.activeSession.currentIndex + 1 }} / {{ store.activeSession.items.length }}
        </span>
      </div>

      <div class="session-timer">
        ⏱ {{ elapsedSeconds }}초
      </div>
    </div>

    <!-- Active Card Arena -->
    <div class="session-body" v-if="currentWord && !store.activeSession.isCompleted">
      <div :class="['cloze-card', { 'correct-pulse': isCorrectPulse }]">
        <!-- Course Origin Badge -->
        <div class="course-origin-badge">
          <span>📖 {{ getCourseName(currentWord.courseId) }}</span>
          <span class="diff-badge">{{ currentWord.difficulty }}</span>
        </div>

        <!-- Context Sentence with Cloze Slot -->
        <div class="sentence-box">
          <span class="prefix-text">{{ parsedCloze.prefix }}</span>
          <span class="cloze-slot">
            <input
              ref="inputRef"
              v-model="userInputValue"
              type="text"
              :class="['slot-input', { 'has-typo': isTypoToast }]"
              :placeholder="hintText || `${parsedCloze.targetTerm.length}글자 입력`"
              @keyup.enter="handleCheckAnswer"
              autocomplete="off"
              spellcheck="false"
              autofocus
            />
          </span>
          <span class="suffix-text">{{ parsedCloze.suffix }}</span>
        </div>

        <!-- Levenshtein Typo Grace Toast -->
        <div class="typo-toast" v-if="isTypoToast">
          <span class="typo-icon">⚠️</span>
          <span>{{ typoMessage }}</span>
        </div>

        <!-- Clean Audio & Mode Controls (No Spoiler Text!) -->
        <div class="audio-control-bar">
          <button class="listen-audio-btn" @click="handlePlayPronunciationHint">
            🔊 발음 힌트 듣기 <span class="hint-tag">(음성 힌트)</span>
          </button>

          <!-- Block Hint Toggle -->
          <button
            :class="['block-hint-btn', { active: inputMode === 'blocks' }]"
            @click="inputMode = inputMode === 'blocks' ? 'keyboard' : 'blocks'"
          >
            🧩 블록 조립 힌트 {{ inputMode === 'blocks' ? 'ON' : '' }}
          </button>
        </div>

        <!-- Word Blocks Assembly Component (Optional Helper) -->
        <WordBlocks
          v-if="inputMode === 'blocks'"
          :blocks="parsedCloze.scrambledBlocks"
          v-model="userInputValue"
          @submit="handleCheckAnswer"
        />

        <!-- Card Footer Actions: Hint & Submit -->
        <div class="card-footer-actions">
          <button class="hint-btn" @click="handleUseHint" :disabled="hintLevel >= 1">
            💡 {{ hintLevel === 0 ? '첫 글자 힌트' : `첫 글자: '${parsedCloze.targetTerm[0]}'` }}
          </button>

          <button
            class="submit-action-btn"
            :disabled="!userInputValue.trim()"
            @click="handleCheckAnswer"
          >
            정답 확인 (Enter) ➔
          </button>
        </div>
      </div>
    </div>

    <!-- Completed Celebration Screen -->
    <div class="completed-card" v-if="store.activeSession.isCompleted">
      <div class="trophy-anim">🎉</div>
      <h2>오늘의 세션 학습 완료!</h2>
      <p>SuperMemo-2 분산 반복 알고리즘에 따라 복습 일정이 스케줄링되었습니다.</p>

      <div class="reward-summary">
        <div class="r-box">
          <span class="r-val">+120 XP</span>
          <span class="r-label">경험치 획득</span>
        </div>
        <div class="r-box">
          <span class="r-val">{{ store.activeSession.items.length }}개</span>
          <span class="r-label">마스터 어휘</span>
        </div>
      </div>

      <button class="finish-btn" @click="router.push({ name: 'home' })">
        대시보드로 돌아가기
      </button>
    </div>

    <!-- Bottom Sheet Error Modal (Duolingo Style with Pronunciation Revealed) -->
    <BottomSheetFeedback
      :is-open="isErrorModalOpen"
      :user-input="lastSubmittedInput"
      :correct-term="errorFeedbackData.correctTerm"
      :feedback-text="errorFeedbackData.feedback"
      :is-ai-generated="errorFeedbackData.isAiGenerated"
      :pronunciation-kr="currentWord?.pronunciationKr"
      @close="closeErrorModal"
      @play-audio="playAudioDirect"
    />
  </div>
</template>

<script setup>
import { ref, computed, watch, onMounted, onUnmounted } from "vue";
import { useLearningStore } from "../stores/useLearningStore.js";
import { parseClozeSentence } from "../services/clozeParser.js";
import { speakPronunciation } from "../services/ttsService.js";
import { CURRICULUM_COURSES } from "../data/curriculumData.js";
import WordBlocks from "../components/WordBlocks.vue";
import BottomSheetFeedback from "../components/BottomSheetFeedback.vue";
import confetti from "canvas-confetti";
import { useRouter } from "vue-router";

const store = useLearningStore();
const router = useRouter();

const userInputValue = ref("");
const inputMode = ref("keyboard"); // Default to Active Recall Typing!
const inputRef = ref(null);

const isCorrectPulse = ref(false);
const isTypoToast = ref(false);
const typoMessage = ref("");

const isErrorModalOpen = ref(false);
const lastSubmittedInput = ref("");
const errorFeedbackData = ref({});

const hintLevel = ref(0);
const elapsedSeconds = ref(0);
let timerInterval = null;

const currentWord = computed(() => store.currentSessionWord);

const parsedCloze = computed(() => {
  if (!currentWord.value) return { prefix: "", targetTerm: "", suffix: "", scrambledBlocks: [] };
  return parseClozeSentence(currentWord.value.contextSentence);
});

const progressPercent = computed(() => {
  if (!store.activeSession.items.length) return 0;
  return Math.round(((store.activeSession.currentIndex) / store.activeSession.items.length) * 100);
});

const hintText = computed(() => {
  if (hintLevel.value >= 1 && parsedCloze.value.targetTerm) {
    return `첫 글자: '${parsedCloze.value.targetTerm[0]}' (${parsedCloze.value.targetTerm.length}자리)`;
  }
  return "";
});

watch(currentWord, () => {
  userInputValue.value = "";
  hintLevel.value = 0;
  isTypoToast.value = false;
  elapsedSeconds.value = 0;
  if (inputRef.value) {
    setTimeout(() => inputRef.value?.focus(), 50);
  }
});

onMounted(() => {
  timerInterval = setInterval(() => {
    elapsedSeconds.value += 1;
  }, 1000);
});

onUnmounted(() => {
  if (timerInterval) clearInterval(timerInterval);
});

function getCourseName(courseId) {
  const c = CURRICULUM_COURSES.find((item) => item.id === courseId);
  return c ? c.name : "IT 전문 어휘";
}

function handlePlayPronunciationHint() {
  store.useHint(); // Record telemetry hint usage
  playAudioDirect();
}

function playAudioDirect() {
  if (currentWord.value) {
    speakPronunciation(currentWord.value.term);
  }
}

function handleUseHint() {
  if (hintLevel.value === 0) {
    hintLevel.value = 1;
    store.useHint();
  }
}

async function handleCheckAnswer() {
  if (!userInputValue.value.trim()) return;

  const result = await store.submitAnswer(userInputValue.value);

  if (result.status === "CORRECT") {
    // 0.3s MalheBoca snappy auto-advance!
    isCorrectPulse.value = true;
    playAudioDirect();

    setTimeout(() => {
      isCorrectPulse.value = false;
      inputMode.value = 'keyboard';
      store.nextQuestion();
      if (store.activeSession.isCompleted) {
        confetti({ particleCount: 150, spread: 80 });
      }
    }, 320);
  } else if (result.status === "TYPO_WARNING") {
    // Levenshtein fuzzy match grace warning
    isTypoToast.value = true;
    typoMessage.value = result.message;
  } else if (result.status === "INCORRECT") {
    // Open Duolingo Bottom Sheet Modal with AI comparison explanation & reveal pronunciation
    lastSubmittedInput.value = userInputValue.value;
    errorFeedbackData.value = result;
    isErrorModalOpen.value = true;
  }
}

function closeErrorModal() {
  isErrorModalOpen.value = false;
  inputMode.value = 'keyboard';
  store.awardFeedbackXp(); // +5 EXP for reviewing feedback
  store.nextQuestion();
}
</script>

<style scoped>
.learn-session-container {
  max-width: 680px;
  margin: 1.5rem auto;
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
}

.session-header {
  display: flex;
  align-items: center;
  gap: 1rem;
}

.exit-btn {
  background: transparent;
  border: none;
  color: #94a3b8;
  font-size: 1.1rem;
  font-weight: 700;
  cursor: pointer;
}

.session-progress-wrapper {
  flex: 1;
  display: flex;
  align-items: center;
  gap: 0.75rem;
}

.progress-bar {
  flex: 1;
  height: 10px;
  background: rgba(255, 255, 255, 0.08);
  border-radius: 6px;
  overflow: hidden;
}

.progress-fill {
  height: 100%;
  background: linear-gradient(90deg, #10b981, #38bdf8);
  border-radius: 6px;
  transition: width 0.3s ease;
}

.progress-text {
  font-size: 0.82rem;
  font-weight: 700;
  color: #94a3b8;
  min-width: 40px;
}

.session-timer {
  font-size: 0.82rem;
  font-weight: 700;
  color: #38bdf8;
  background: rgba(56, 189, 248, 0.1);
  padding: 0.25rem 0.6rem;
  border-radius: 20px;
}

.cloze-card {
  background: #1e293b;
  border: 2px solid rgba(255, 255, 255, 0.1);
  border-radius: 22px;
  padding: 2rem 2.25rem;
  display: flex;
  flex-direction: column;
  gap: 1.25rem;
  box-shadow: 0 20px 40px -10px rgba(0, 0, 0, 0.5);
  transition: all 0.25s ease;
}

.correct-pulse {
  border-color: #10b981 !important;
  background: rgba(16, 185, 129, 0.15) !important;
  transform: scale(1.02);
}

.course-origin-badge {
  display: flex;
  justify-content: space-between;
  align-items: center;
  font-size: 0.82rem;
  font-weight: 700;
  color: #38bdf8;
}

.diff-badge {
  background: rgba(255, 255, 255, 0.08);
  color: #94a3b8;
  padding: 0.15rem 0.5rem;
  border-radius: 4px;
  font-size: 0.72rem;
}

.sentence-box {
  font-size: 1.35rem;
  line-height: 1.7;
  color: #f8fafc;
  font-weight: 600;
  word-break: keep-all;
}

.cloze-slot {
  display: inline-block;
  vertical-align: middle;
  margin: 0 0.4rem;
}

.slot-input {
  background: rgba(0, 0, 0, 0.4);
  border: 2px solid #38bdf8;
  border-radius: 10px;
  color: #38bdf8;
  font-size: 1.35rem;
  font-weight: 900;
  text-align: center;
  padding: 0.35rem 0.85rem;
  min-width: 140px;
  outline: none;
  transition: all 0.15s;
}

.slot-input:focus {
  border-color: #60a5fa;
  box-shadow: 0 0 15px rgba(56, 189, 248, 0.4);
}

.slot-input.has-typo {
  border-color: #f59e0b;
}

.typo-toast {
  background: rgba(245, 158, 11, 0.15);
  border: 1px solid rgba(245, 158, 11, 0.4);
  color: #f59e0b;
  padding: 0.6rem 0.85rem;
  border-radius: 8px;
  font-size: 0.85rem;
  font-weight: 700;
  display: flex;
  align-items: center;
  gap: 0.4rem;
}

.audio-control-bar {
  display: flex;
  align-items: center;
  justify-content: space-between;
  background: rgba(255, 255, 255, 0.03);
  border-radius: 10px;
  padding: 0.6rem 0.85rem;
  flex-wrap: wrap;
  gap: 0.5rem;
}

.listen-audio-btn {
  background: transparent;
  border: none;
  color: #38bdf8;
  font-size: 0.85rem;
  font-weight: 700;
  cursor: pointer;
  display: flex;
  align-items: center;
  gap: 0.4rem;
}

.hint-tag {
  font-size: 0.72rem;
  color: #64748b;
}

.block-hint-btn {
  background: transparent;
  border: 1px solid rgba(255, 255, 255, 0.1);
  color: #94a3b8;
  font-size: 0.78rem;
  font-weight: 600;
  padding: 0.3rem 0.7rem;
  border-radius: 6px;
  cursor: pointer;
  transition: all 0.15s ease;
}

.block-hint-btn.active {
  background: rgba(56, 189, 248, 0.15);
  border-color: #38bdf8;
  color: #38bdf8;
  font-weight: 700;
}

.card-footer-actions {
  display: flex;
  gap: 0.75rem;
  margin-top: 0.5rem;
}

.hint-btn {
  background: rgba(255, 255, 255, 0.05);
  border: 1px solid rgba(255, 255, 255, 0.1);
  color: #f59e0b;
  font-size: 0.9rem;
  font-weight: 700;
  padding: 0.8rem 1.25rem;
  border-radius: 12px;
  cursor: pointer;
}

.hint-btn:hover:not(:disabled) {
  background: rgba(245, 158, 11, 0.15);
}

.submit-action-btn {
  flex: 1;
  background: #2563eb;
  color: white;
  border: none;
  font-size: 1rem;
  font-weight: 800;
  padding: 0.85rem;
  border-radius: 12px;
  cursor: pointer;
  box-shadow: 0 4px 14px rgba(37, 99, 235, 0.4);
  transition: all 0.2s;
}

.submit-action-btn:hover:not(:disabled) {
  background: #1d4ed8;
  transform: translateY(-2px);
}

.submit-action-btn:disabled {
  opacity: 0.4;
  cursor: not-allowed;
}

.completed-card {
  background: #1e293b;
  border: 1px solid rgba(255, 255, 255, 0.1);
  border-radius: 22px;
  padding: 3rem 2rem;
  text-align: center;
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 1rem;
}

.trophy-anim {
  font-size: 4rem;
}

.reward-summary {
  display: flex;
  gap: 1.5rem;
  margin: 1rem 0;
}

.r-box {
  background: rgba(255, 255, 255, 0.04);
  border: 1px solid rgba(255, 255, 255, 0.08);
  padding: 1rem 1.5rem;
  border-radius: 14px;
  display: flex;
  flex-direction: column;
}

.r-val {
  font-size: 1.5rem;
  font-weight: 900;
  color: #38bdf8;
}

.r-label {
  font-size: 0.8rem;
  color: #94a3b8;
}

.finish-btn {
  background: #2563eb;
  color: white;
  border: none;
  font-size: 1rem;
  font-weight: 800;
  padding: 0.85rem 2rem;
  border-radius: 12px;
  cursor: pointer;
}
</style>
