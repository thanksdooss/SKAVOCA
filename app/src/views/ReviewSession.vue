<template>
  <div class="review-session-container">
    <!-- Header -->
    <div class="session-header">
      <button class="exit-btn" @click="router.push({ name: 'home' })">✕ 종료</button>
      <div class="header-title">
        <span>🎴 플래시카드 복습</span>
      </div>
      <div class="counter-badge">
        {{ store.activeSession.currentIndex + 1 }} / {{ store.activeSession.items.length }}
      </div>
    </div>

    <!-- Active Card -->
    <div class="review-body" v-if="currentWord && !store.activeSession.isCompleted">
      <TinderSwipeCard :card="currentWord" @rate="handleRate" />
    </div>

    <!-- Completed Screen -->
    <div class="completed-card" v-if="store.activeSession.isCompleted">
      <div class="trophy-anim">🎯</div>
      <h2>플래시카드 복습 완료!</h2>
      <p>Anki Fuzzing 알고리즘(±10% 분산)에 따라 복습 주기가 분산 배치되었습니다.</p>

      <button class="finish-btn" @click="router.push({ name: 'home' })">
        대시보드로 돌아가기
      </button>
    </div>
  </div>
</template>

<script setup>
import { computed } from "vue";
import { useLearningStore } from "../stores/useLearningStore.js";
import TinderSwipeCard from "../components/TinderSwipeCard.vue";
import confetti from "canvas-confetti";
import { useRouter } from "vue-router";

const store = useLearningStore();
const router = useRouter();

const currentWord = computed(() => store.currentSessionWord);

function handleRate({ wordId, quality }) {
  store.rateCardOptimistic(wordId, quality);
  if (store.activeSession.isCompleted) {
    confetti({ particleCount: 120, spread: 70 });
  }
}
</script>

<style scoped>
.review-session-container {
  max-width: 480px;
  margin: 1.5rem auto;
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 1.5rem;
}

.session-header {
  width: 100%;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.exit-btn {
  background: transparent;
  border: none;
  color: #94a3b8;
  font-size: 1.1rem;
  font-weight: 700;
  cursor: pointer;
}

.header-title {
  font-size: 0.95rem;
  font-weight: 800;
  color: #f8fafc;
}

.counter-badge {
  font-size: 0.8rem;
  font-weight: 700;
  color: #38bdf8;
  background: rgba(56, 189, 248, 0.1);
  padding: 0.2rem 0.6rem;
  border-radius: 20px;
}

.review-body {
  width: 100%;
  display: flex;
  justify-content: center;
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
  width: 100%;
}

.trophy-anim {
  font-size: 4rem;
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
