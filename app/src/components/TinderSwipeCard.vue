<template>
  <div class="tinder-wrapper">
    <div
      v-if="card"
      :class="['tinder-card', { 'anim-left': flyDirection === 'left', 'anim-right': flyDirection === 'right' }]"
      :style="cardStyle"
      @mousedown.prevent="startDrag"
      @touchstart.prevent="startDrag"
    >
      <!-- Swipe Overlay Indicators -->
      <div class="badge-overlay like-overlay" :style="{ opacity: likeOpacity }">
        기억함 👍
      </div>
      <div class="badge-overlay nope-overlay" :style="{ opacity: nopeOpacity }">
        다시보기 🔄
      </div>

      <!-- Card Top Badge -->
      <div class="card-course-badge">
        <span>{{ getCourseName(card?.courseId) }}</span>
        <span class="diff-tag">{{ card?.difficulty }}</span>
      </div>

      <!-- Main Term & Phonetics -->
      <div class="card-main">
        <h2 class="card-term">{{ card.term }}</h2>
        <div class="card-phonetic">
          <span>🔊 {{ card.pronunciationKr }}</span>
          <button class="mini-audio-btn" @click.stop="playAudio">듣기</button>
        </div>
      </div>

      <!-- Card Divider -->
      <div class="card-divider"></div>

      <!-- Easy Meaning & Context -->
      <div class="card-body">
        <p class="card-meaning">"{{ card.easyMeaning }}"</p>
        <div class="card-example">
          <span class="ex-label">실무 문맥:</span>
          <span class="ex-text">{{ cleanSentence(card.contextSentence) }}</span>
        </div>
      </div>

      <!-- Bottom Gesture Guide -->
      <div class="card-hint">
        <span class="hint-left">👈 좌로 밀기: 모름</span>
        <span class="hint-divider">|</span>
        <span class="hint-right">우로 밀기: 앎 👉</span>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, computed, onBeforeUnmount } from "vue";
import { speakPronunciation } from "../services/ttsService.js";
import { CURRICULUM_COURSES } from "../data/curriculumData.js";

const props = defineProps({
  card: { type: Object, default: null }
});

function getCourseName(courseId) {
  const c = CURRICULUM_COURSES.find((item) => item.id === courseId);
  return c ? c.name : "IT 전문 어휘";
}

const emit = defineEmits(["rate"]);

const startX = ref(0);
const startY = ref(0);
const currentX = ref(0);
const currentY = ref(0);
const isDragging = ref(false);
const flyDirection = ref(null);

const deltaX = computed(() => (isDragging.value ? currentX.value - startX.value : 0));
const deltaY = computed(() => (isDragging.value ? currentY.value - startY.value : 0));

const cardStyle = computed(() => {
  if (flyDirection.value) return {};
  if (!isDragging.value) return { transform: "translate3d(0, 0, 0) rotate(0deg)" };

  const rotate = deltaX.value * 0.06;
  const moveY = Math.min(0, deltaY.value * 0.15); // slight upward lift
  return {
    transform: `translate3d(${deltaX.value}px, ${moveY}px, 0) rotate(${rotate}deg)`,
    transition: "none"
  };
});

const likeOpacity = computed(() => {
  if (deltaX.value <= 0) return 0;
  return Math.min(1, deltaX.value / 100);
});

const nopeOpacity = computed(() => {
  if (deltaX.value >= 0) return 0;
  return Math.min(1, Math.abs(deltaX.value) / 100);
});

function cleanSentence(s) {
  if (!s) return "";
  return s.replace(/\{\{(.*?)\}\}/g, "$1");
}

function playAudio() {
  if (props.card) {
    speakPronunciation(props.card.term);
  }
}

function getClientPos(e) {
  if (e.touches && e.touches.length > 0) {
    return { x: e.touches[0].clientX, y: e.touches[0].clientY };
  }
  return { x: e.clientX, y: e.clientY };
}

function startDrag(e) {
  if (flyDirection.value) return;
  isDragging.value = true;
  const pos = getClientPos(e);
  startX.value = pos.x;
  startY.value = pos.y;
  currentX.value = pos.x;
  currentY.value = pos.y;

  window.addEventListener("mousemove", onDrag, { passive: false });
  window.addEventListener("touchmove", onDrag, { passive: false });
  window.addEventListener("mouseup", endDrag);
  window.addEventListener("touchend", endDrag);
}

function onDrag(e) {
  if (!isDragging.value) return;
  e.preventDefault();
  const pos = getClientPos(e);
  currentX.value = pos.x;
  currentY.value = pos.y;
}

function endDrag() {
  if (!isDragging.value) return;
  isDragging.value = false;

  window.removeEventListener("mousemove", onDrag);
  window.removeEventListener("touchmove", onDrag);
  window.removeEventListener("mouseup", endDrag);
  window.removeEventListener("touchend", endDrag);

  const threshold = 80;
  const dx = currentX.value - startX.value;

  if (dx > threshold) {
    triggerFling("right", 4);
  } else if (dx < -threshold) {
    triggerFling("left", 0);
  }
  // If below threshold, card snaps back (no action)
}

function triggerFling(direction, quality) {
  flyDirection.value = direction;
  setTimeout(() => {
    emit("rate", { wordId: props.card.wordId, quality });
    flyDirection.value = null;
    // Reset positions
    startX.value = 0;
    startY.value = 0;
    currentX.value = 0;
    currentY.value = 0;
  }, 250);
}

onBeforeUnmount(() => {
  window.removeEventListener("mousemove", onDrag);
  window.removeEventListener("touchmove", onDrag);
  window.removeEventListener("mouseup", endDrag);
  window.removeEventListener("touchend", endDrag);
});
</script>

<style scoped>
.tinder-wrapper {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
  max-width: 440px;
  position: relative;
}

.tinder-card {
  width: 100%;
  min-height: 380px;
  background: linear-gradient(145deg, #1e293b, #0f172a);
  border: 1px solid rgba(255, 255, 255, 0.12);
  border-radius: 20px;
  padding: 1.5rem;
  box-shadow: 0 20px 35px -10px rgba(0, 0, 0, 0.5);
  display: flex;
  flex-direction: column;
  position: relative;
  cursor: grab;
  user-select: none;
  -webkit-user-select: none;
  touch-action: none;
  transition: transform 0.3s cubic-bezier(0.175, 0.885, 0.32, 1.275);
  will-change: transform;
}

.tinder-card:active {
  cursor: grabbing;
}

.badge-overlay {
  position: absolute;
  top: 1.5rem;
  padding: 0.5rem 1.25rem;
  border-radius: 8px;
  font-weight: 900;
  font-size: 1.3rem;
  pointer-events: none;
  z-index: 10;
  letter-spacing: 1px;
}

.like-overlay {
  right: 1.5rem;
  border: 3px solid #10b981;
  color: #10b981;
  background: rgba(16, 185, 129, 0.1);
  transform: rotate(12deg);
}

.nope-overlay {
  left: 1.5rem;
  border: 3px solid #ef4444;
  color: #ef4444;
  background: rgba(239, 68, 68, 0.1);
  transform: rotate(-12deg);
}

.card-course-badge {
  display: flex;
  justify-content: space-between;
  align-items: center;
  font-size: 0.8rem;
  font-weight: 700;
  color: #38bdf8;
}

.diff-tag {
  background: rgba(255, 255, 255, 0.08);
  padding: 0.2rem 0.5rem;
  border-radius: 4px;
  color: #94a3b8;
  font-size: 0.72rem;
}

.card-main {
  margin: 1.25rem 0 0.75rem;
  text-align: center;
}

.card-term {
  font-size: 2.2rem;
  font-weight: 900;
  letter-spacing: -0.5px;
  margin: 0;
  color: #f8fafc;
}

.card-phonetic {
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 0.5rem;
  margin-top: 0.4rem;
  color: #94a3b8;
  font-size: 0.95rem;
}

.mini-audio-btn {
  background: rgba(56, 189, 248, 0.15);
  border: 1px solid rgba(56, 189, 248, 0.3);
  color: #38bdf8;
  font-size: 0.75rem;
  font-weight: 700;
  padding: 0.15rem 0.5rem;
  border-radius: 4px;
  cursor: pointer;
}

.card-divider {
  height: 1px;
  background: rgba(255, 255, 255, 0.08);
  margin: 0.75rem 0;
}

.card-body {
  flex: 1;
  display: flex;
  flex-direction: column;
  gap: 0.75rem;
}

.card-meaning {
  font-size: 0.98rem;
  line-height: 1.5;
  color: #e2e8f0;
  margin: 0;
}

.card-example {
  background: rgba(255, 255, 255, 0.03);
  border-radius: 8px;
  padding: 0.6rem 0.8rem;
  font-size: 0.85rem;
  line-height: 1.4;
  color: #94a3b8;
}

.ex-label {
  color: #38bdf8;
  font-weight: 700;
  display: block;
  margin-bottom: 0.15rem;
}

.card-hint {
  text-align: center;
  font-size: 0.78rem;
  color: #64748b;
  margin-top: auto;
  font-weight: 600;
  display: flex;
  justify-content: center;
  gap: 0.75rem;
  padding-top: 0.75rem;
}

.hint-left { color: #f87171; }
.hint-right { color: #34d399; }
.hint-divider { color: #475569; }

.anim-left {
  transform: translate3d(-150%, -30px, 0) rotate(-25deg) !important;
  opacity: 0;
  transition: all 0.25s ease-in !important;
}

.anim-right {
  transform: translate3d(150%, -30px, 0) rotate(25deg) !important;
  opacity: 0;
  transition: all 0.25s ease-in !important;
}
</style>
