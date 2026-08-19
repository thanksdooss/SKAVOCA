<template>
  <header class="header-nav">
    <div class="nav-container">
      <!-- Brand Logo -->
      <div class="brand" @click="router.push({ name: 'home' })">
        <span class="brand-title">SKAVOCA</span>
      </div>

      <!-- Center Nav Tabs (authenticated only) -->
      <nav class="nav-tabs" v-if="authStore.isAuthenticated">
        <button
          :class="['tab-btn', { active: currentRoute === 'home' }]"
          @click="router.push({ name: 'home' })"
        >
          🏠 홈
        </button>
        <button
          :class="['tab-btn', { active: currentRoute === 'catalog' }]"
          @click="router.push({ name: 'catalog' })"
        >
          📚 단어장
        </button>
        <button
          :class="['tab-btn', { active: currentRoute === 'learn' }]"
          @click="goLearn"
        >
          ⚡ 문제풀기
        </button>
        <button
          :class="['tab-btn', { active: currentRoute === 'review' }]"
          @click="goReview"
        >
          🎴 스와이프
        </button>
        <button
          :class="['tab-btn', { active: currentRoute === 'stats' }]"
          @click="router.push({ name: 'stats' })"
        >
          📊 리포트
        </button>
        <button
          v-if="authStore.isInstructor"
          :class="['tab-btn', 'admin-btn', { active: currentRoute === 'instructor' }]"
          @click="router.push({ name: 'instructor' })"
        >
          👨‍🏫 교수자
        </button>
      </nav>

      <!-- Right: Gamification & Auth (authenticated) -->
      <div class="user-status" v-if="authStore.isAuthenticated">
        <!-- Streak -->
        <div class="status-chip streak-chip" title="연속 학습 중!">
          <span class="fire-icon">🔥</span>
          <span class="chip-val">{{ gameStore.streakDays }}일</span>
        </div>

        <!-- RPG Tier -->
        <div
          class="status-chip tier-chip"
          :style="{ borderColor: gameStore.currentTier.color }"
          @click="router.push({ name: 'stats' })"
          title="클릭 시 성장 로드맵으로 이동"
        >
          <span class="tier-icon">{{ gameStore.currentTier.icon }}</span>
          <span class="tier-name">{{ gameStore.currentTier.name }}</span>
          <span class="xp-val">{{ gameStore.xp }} XP</span>
        </div>

        <!-- Auth / Profile Switcher Button -->
        <button class="auth-profile-btn" @click="authStore.openAuthModal" title="계정 전환 및 로그인">
          <span class="profile-avatar">{{ authStore.userAvatar }}</span>
          <span class="profile-name">{{ authStore.userNickname }}</span>
          <span class="role-pill" v-if="authStore.isInstructor">교수자</span>
          <span class="switch-icon">⇄</span>
        </button>
      </div>

      <!-- Right: Login button (unauthenticated) -->
      <div class="user-status" v-else>
        <button class="auth-profile-btn" @click="authStore.openAuthModal" title="로그인">
          <span class="profile-avatar">🔐</span>
          <span class="profile-name">로그인</span>
        </button>
      </div>
    </div>
  </header>
</template>

<script setup>
import { computed } from "vue";
import { useRouter, useRoute } from "vue-router";
import { useLearningStore } from "../stores/useLearningStore.js";
import { useGamificationStore } from "../stores/useGamificationStore.js";
import { useAuthStore } from "../stores/useAuthStore.js";

const router = useRouter();
const route = useRoute();
const store = useLearningStore();
const gameStore = useGamificationStore();
const authStore = useAuthStore();

const currentRoute = computed(() => route.name);

function goLearn() {
  store.startLearningSession();
  router.push({ name: "learn" });
}

function goReview() {
  store.startReviewSession();
  router.push({ name: "review" });
}
</script>

<style scoped>
.header-nav {
  position: sticky;
  top: 0;
  z-index: 100;
  background: rgba(15, 23, 42, 0.85);
  backdrop-filter: blur(12px);
  border-bottom: 1px solid rgba(255, 255, 255, 0.08);
  padding: 0.75rem 0;
}

.nav-container {
  max-width: 1200px;
  width: 100%;
  margin: 0 auto;
  padding: 0 1.5rem;
  display: flex;
  align-items: center;
  justify-content: space-between;
  gap: 1rem;
}

.brand {
  display: flex;
  align-items: center;
  gap: 0.5rem;
  cursor: pointer;
  user-select: none;
}

.logo-badge {
  background: linear-gradient(135deg, #e11d48, #ea580c);
  color: white;
  font-weight: 900;
  font-size: 0.85rem;
  padding: 0.2rem 0.45rem;
  border-radius: 6px;
  letter-spacing: -0.5px;
}

.brand-title {
  font-weight: 800;
  font-size: 1.25rem;
  letter-spacing: -0.5px;
  background: linear-gradient(135deg, #38bdf8, #818cf8);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
}

.cohort-tag {
  background: rgba(56, 189, 248, 0.15);
  color: #38bdf8;
  font-size: 0.72rem;
  font-weight: 700;
  padding: 0.15rem 0.45rem;
  border-radius: 4px;
  border: 1px solid rgba(56, 189, 248, 0.3);
}

.nav-tabs {
  display: flex;
  align-items: center;
  gap: 0.4rem;
  background: rgba(30, 41, 59, 0.5);
  padding: 0.25rem 0.35rem;
  border-radius: 12px;
  border: 1px solid rgba(255, 255, 255, 0.05);
}

.tab-btn {
  background: transparent;
  border: none;
  color: #94a3b8;
  font-weight: 600;
  font-size: 0.8rem;
  padding: 0.4rem 0.6rem;
  border-radius: 8px;
  cursor: pointer;
  transition: all 0.2s cubic-bezier(0.16, 1, 0.3, 1);
  display: flex;
  align-items: center;
  gap: 0.25rem;
  white-space: nowrap;
}

.tab-btn:hover {
  color: #f1f5f9;
  background: rgba(255, 255, 255, 0.05);
}

.tab-btn.active {
  background: #3b82f6;
  color: white;
  font-weight: 700;
  box-shadow: 0 2px 8px rgba(59, 130, 246, 0.4);
}

.admin-btn {
  background: rgba(245, 158, 11, 0.1);
  color: #f59e0b;
}

.admin-btn.active {
  background: #f59e0b;
  color: #0f172a;
}

.user-status {
  display: flex;
  align-items: center;
  gap: 0.65rem;
}

.status-chip {
  display: flex;
  align-items: center;
  gap: 0.35rem;
  padding: 0.35rem 0.65rem;
  border-radius: 20px;
  font-size: 0.82rem;
  font-weight: 700;
  background: rgba(30, 41, 59, 0.6);
  border: 1px solid rgba(255, 255, 255, 0.1);
  cursor: pointer;
  transition: transform 0.15s;
}

.status-chip:hover {
  transform: translateY(-1px);
}

.streak-chip {
  color: #f97316;
}

.tier-chip {
  color: #f1f5f9;
  border-width: 1.5px;
}

.xp-val {
  color: #fbbf24;
  font-size: 0.75rem;
  background: rgba(251, 191, 36, 0.15);
  padding: 0.1rem 0.35rem;
  border-radius: 6px;
}

.auth-profile-btn {
  display: flex;
  align-items: center;
  gap: 0.45rem;
  background: rgba(16, 185, 129, 0.12);
  border: 1px solid rgba(16, 185, 129, 0.35);
  padding: 0.35rem 0.75rem;
  border-radius: 20px;
  cursor: pointer;
  color: #f1f5f9;
  font-size: 0.82rem;
  font-weight: 700;
  transition: all 0.15s;
}

.auth-profile-btn:hover {
  background: rgba(16, 185, 129, 0.25);
  border-color: #10b981;
  transform: translateY(-1px);
}

.profile-avatar {
  font-size: 1rem;
}

.profile-name {
  color: #10b981;
}

.role-pill {
  font-size: 0.68rem;
  background: #f59e0b;
  color: #0f172a;
  padding: 0.1rem 0.35rem;
  border-radius: 4px;
  font-weight: 800;
}

.switch-icon {
  font-size: 0.75rem;
  color: #94a3b8;
  margin-left: 0.1rem;
}

@media (max-width: 900px) {
  .nav-tabs {
    display: none;
  }
}
</style>
