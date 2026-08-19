<template>
  <div class="bottom-sheet-backdrop" v-if="isOpen" @click.self="$emit('close')">
    <div :class="['bottom-sheet', { shake: isShaking }]">
      <!-- Sheet Handle -->
      <div class="sheet-handle"></div>

      <!-- Header Result -->
      <div class="sheet-header">
        <div class="header-top-row">
          <div class="error-badge">❌ 오답 분석 피드백</div>
          <span class="ai-model-tag" v-if="isAiGenerated">✨ AI 튜터 실시간 분석</span>
          <span class="curated-tag" v-else>🎯 교재 정밀 매핑 해설</span>
        </div>
        <div class="terms-comparison">
          <div class="comp-box wrong-box">
            <span class="label">내가 입력한 오답</span>
            <span class="val">{{ userInput }}</span>
          </div>
          <div class="arrow">➔</div>
          <div class="comp-box correct-box">
            <span class="label">실제 정답</span>
            <span class="val">{{ correctTerm }}</span>
          </div>
        </div>
      </div>

      <!-- AI Structured Comparison Explanation Card -->
      <div class="explanation-card">
        <div class="ai-header">
          <span class="ai-sparkle">🤖</span>
          <span class="ai-title">AI 튜터의 오답 분석</span>
        </div>

        <!-- Section 1: Correct Concept Breakdown -->
        <div class="feedback-section concept-section" v-if="getConceptText()">
          <div class="section-badge badge-green">📌 정답 개념 핵심 정의</div>
          <p class="section-body">{{ getConceptText() }}</p>
        </div>

        <!-- Section 2: Practical Real-World Tip -->
        <div class="feedback-section tip-section" v-if="getTipText()">
          <div class="section-badge badge-blue">💡 예문을 통해 기억하기</div>
          <p class="section-body">{{ getTipText() }}</p>
        </div>
      </div>

      <!-- Pronunciation Audio -->
      <div class="audio-strip">
        <span class="phonetic-text">🔊 정답 실무 발음: <strong>{{ pronunciationKr || correctTerm }}</strong></span>
        <button class="listen-btn" @click="$emit('play-audio')">
          ▶ 소리 듣기
        </button>
      </div>

      <!-- Action Footer -->
      <div class="sheet-footer">
        <button class="continue-btn" @click="$emit('close')">
          이해했습니다 (계속 학습) ➔
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, watch } from "vue";

const props = defineProps({
  isOpen: { type: Boolean, default: false },
  userInput: { type: String, default: "" },
  correctTerm: { type: String, default: "" },
  feedbackText: { type: [String, Object], default: "" },
  isAiGenerated: { type: Boolean, default: false },
  pronunciationKr: { type: String, default: "" }
});

const emit = defineEmits(["close", "play-audio"]);

const isShaking = ref(false);

watch(
  () => props.isOpen,
  (val) => {
    if (val) {
      isShaking.value = true;
      setTimeout(() => {
        isShaking.value = false;
      }, 500);
    }
  }
);

function getContrastText() {
  if (typeof props.feedbackText === "object" && props.feedbackText !== null) {
    return props.feedbackText.contrast || props.feedbackText.conceptDiff || "";
  }
  return props.feedbackText || "정답과 입력하신 단어 간의 역할 차이를 확인하세요.";
}

function getConceptText() {
  if (typeof props.feedbackText === "object" && props.feedbackText !== null) {
    return props.feedbackText.correctConcept || props.feedbackText.definition || "";
  }
  return "";
}

function getTipText() {
  if (typeof props.feedbackText === "object" && props.feedbackText !== null) {
    return props.feedbackText.practicalTip || "";
  }
  return "";
}
</script>

<style scoped>
.bottom-sheet-backdrop {
  position: fixed;
  inset: 0;
  background: rgba(0, 0, 0, 0.7);
  backdrop-filter: blur(8px);
  z-index: 200;
  display: flex;
  align-items: flex-end;
  justify-content: center;
  animation: fadeIn 0.2s ease-out;
}

.bottom-sheet {
  width: 100%;
  max-width: 640px;
  max-height: 88vh;
  overflow-y: auto;
  background: #0f172a;
  border-top: 2px solid #ef4444;
  border-radius: 24px 24px 0 0;
  padding: 1.5rem 1.75rem 2rem;
  box-shadow: 0 -10px 40px rgba(0, 0, 0, 0.6);
  animation: slideUp 0.25s cubic-bezier(0.16, 1, 0.3, 1);
  display: flex;
  flex-direction: column;
  gap: 1.1rem;
}

.shake {
  animation: slideUp 0.25s cubic-bezier(0.16, 1, 0.3, 1),
             shakeEffect 0.35s 0.25s ease-in-out;
}

.sheet-handle {
  width: 44px;
  height: 5px;
  background: rgba(255, 255, 255, 0.25);
  border-radius: 4px;
  margin: 0 auto;
}

.sheet-header {
  display: flex;
  flex-direction: column;
  gap: 0.75rem;
}

.header-top-row {
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.error-badge {
  color: #ef4444;
  font-weight: 800;
  font-size: 1.15rem;
  letter-spacing: -0.5px;
}

.ai-model-tag {
  font-size: 0.72rem;
  background: rgba(56, 189, 248, 0.15);
  color: #38bdf8;
  border: 1px solid rgba(56, 189, 248, 0.3);
  padding: 0.2rem 0.5rem;
  border-radius: 6px;
  font-weight: 600;
}

.curated-tag {
  font-size: 0.72rem;
  background: rgba(16, 185, 129, 0.15);
  color: #10b981;
  border: 1px solid rgba(16, 185, 129, 0.3);
  padding: 0.2rem 0.5rem;
  border-radius: 6px;
  font-weight: 600;
}

.terms-comparison {
  display: flex;
  align-items: center;
  gap: 0.75rem;
}

.comp-box {
  flex: 1;
  display: flex;
  flex-direction: column;
  padding: 0.65rem 0.9rem;
  border-radius: 12px;
}

.wrong-box {
  background: rgba(239, 68, 68, 0.12);
  border: 1px solid rgba(239, 68, 68, 0.35);
}

.wrong-box .val {
  color: #ef4444;
  text-decoration: line-through;
  font-weight: 800;
  font-size: 1.15rem;
}

.correct-box {
  background: rgba(16, 185, 129, 0.12);
  border: 1px solid rgba(16, 185, 129, 0.35);
}

.correct-box .val {
  color: #10b981;
  font-weight: 800;
  font-size: 1.15rem;
}

.comp-box .label {
  font-size: 0.72rem;
  color: #94a3b8;
  font-weight: 600;
}

.arrow {
  color: #64748b;
  font-weight: 800;
}

.explanation-card {
  background: rgba(30, 41, 59, 0.7);
  border: 1px solid rgba(255, 255, 255, 0.1);
  border-radius: 16px;
  padding: 1.1rem 1.25rem;
  display: flex;
  flex-direction: column;
  gap: 0.85rem;
}

.ai-header {
  display: flex;
  align-items: center;
  gap: 0.45rem;
  padding-bottom: 0.5rem;
  border-bottom: 1px solid rgba(255, 255, 255, 0.08);
}

.ai-title {
  font-size: 0.92rem;
  font-weight: 700;
  color: #38bdf8;
}

.feedback-section {
  display: flex;
  flex-direction: column;
  gap: 0.3rem;
  background: rgba(15, 23, 42, 0.6);
  padding: 0.75rem 0.9rem;
  border-radius: 10px;
}

.contrast-section {
  border-left: 3px solid #f59e0b;
}

.concept-section {
  border-left: 3px solid #10b981;
}

.tip-section {
  border-left: 3px solid #38bdf8;
}

.section-badge {
  font-size: 0.74rem;
  font-weight: 700;
  color: #fbbf24;
}

.badge-green {
  color: #34d399;
}

.badge-blue {
  color: #60a5fa;
}

.section-body {
  font-size: 0.9rem;
  line-height: 1.55;
  color: #e2e8f0;
  margin: 0;
}

.audio-strip {
  display: flex;
  align-items: center;
  justify-content: space-between;
  background: rgba(56, 189, 248, 0.06);
  border: 1px dashed rgba(56, 189, 248, 0.3);
  padding: 0.65rem 1rem;
  border-radius: 12px;
}

.phonetic-text {
  font-size: 0.85rem;
  color: #94a3b8;
}

.phonetic-text strong {
  color: #f8fafc;
}

.listen-btn {
  background: #0284c7;
  border: none;
  color: white;
  font-size: 0.82rem;
  font-weight: 700;
  padding: 0.4rem 0.85rem;
  border-radius: 8px;
  cursor: pointer;
  transition: all 0.15s;
}

.listen-btn:hover {
  background: #0369a1;
  transform: translateY(-1px);
}

.continue-btn {
  width: 100%;
  background: #ef4444;
  color: white;
  border: none;
  font-size: 1rem;
  font-weight: 700;
  padding: 0.9rem;
  border-radius: 14px;
  cursor: pointer;
  box-shadow: 0 4px 14px rgba(239, 68, 68, 0.4);
  transition: all 0.2s;
}

.continue-btn:hover {
  background: #dc2626;
  transform: translateY(-2px);
}

@keyframes slideUp {
  from { transform: translateY(100%); }
  to { transform: translateY(0); }
}

@keyframes fadeIn {
  from { opacity: 0; }
  to { opacity: 1; }
}

@keyframes shakeEffect {
  10%, 90% { transform: translate3d(-2px, 0, 0); }
  20%, 80% { transform: translate3d(4px, 0, 0); }
  30%, 50%, 70% { transform: translate3d(-6px, 0, 0); }
  40%, 60% { transform: translate3d(6px, 0, 0); }
}
</style>
