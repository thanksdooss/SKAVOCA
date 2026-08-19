<template>
  <div class="app-root">
    <!-- Sticky Top Navigation (always shown) -->
    <HeaderNav />

    <!-- Main Dynamic View Container (vue-router) -->
    <main class="main-container">
      <router-view />
    </main>

    <!-- Mobile Bottom Tab Navigation (only when authenticated) -->
    <nav class="bottom-tab-bar" v-if="authStore.isAuthenticated">
      <button
        :class="['btab', { active: currentRouteName === 'home' }]"
        @click="navigateTo('home')"
      >
        <span class="btab-icon">🏠</span>
        <span class="btab-label">홈</span>
      </button>
      <button
        :class="['btab', { active: currentRouteName === 'catalog' }]"
        @click="navigateTo('catalog')"
      >
        <span class="btab-icon">📚</span>
        <span class="btab-label">단어장</span>
      </button>
      <button
        :class="['btab btab-main', { active: currentRouteName === 'learn' }]"
        @click="startLearning"
      >
        <span class="btab-icon-main">⚡</span>
      </button>
      <button
        :class="['btab', { active: currentRouteName === 'stats' }]"
        @click="navigateTo('stats')"
      >
        <span class="btab-icon">📊</span>
        <span class="btab-label">리포트</span>
      </button>
      <button
        :class="['btab', { active: currentRouteName === 'review' }]"
        @click="startReview"
      >
        <span class="btab-icon">🎴</span>
        <span class="btab-label">복습</span>
      </button>
    </nav>

    <!-- Login Modal (always available regardless of auth state) -->
    <LoginModal />
  </div>
</template>

<script setup>
import { computed, onMounted } from "vue";
import { useRouter, useRoute } from "vue-router";
import { useLearningStore } from "./stores/useLearningStore.js";
import { useGamificationStore } from "./stores/useGamificationStore.js";
import { useAuthStore } from "./stores/useAuthStore.js";
import HeaderNav from "./components/HeaderNav.vue";
import LoginModal from "./components/LoginModal.vue";

const router = useRouter();
const route = useRoute();
const store = useLearningStore();
const gameStore = useGamificationStore();
const authStore = useAuthStore();

const currentRouteName = computed(() => route.name);

function navigateTo(name) {
  router.push({ name });
}

function startLearning() {
  store.startLearningSession();
  router.push({ name: "learn" });
}

function startReview() {
  store.startReviewSession();
  router.push({ name: "review" });
}

onMounted(() => {
  // Initialization handled by authStore and dashboard fetch
});
</script>

<style scoped>
.app-root {
  min-height: 100vh;
  background: #0b1120;
  color: #f8fafc;
  display: flex;
  flex-direction: column;
  padding-bottom: 70px; /* space for mobile bottom tab */
}

.main-container {
  flex: 1;
  max-width: 1200px;
  width: 100%;
  margin: 0 auto;
  padding: 0 1.5rem 3rem;
}

/* ═══════ Mobile Bottom Tab Bar ═══════ */
.bottom-tab-bar {
  display: none; /* hidden on desktop */
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0;
  z-index: 200;
  background: rgba(15, 23, 42, 0.95);
  backdrop-filter: blur(12px);
  border-top: 1px solid rgba(255, 255, 255, 0.08);
  padding: 0.4rem 0.5rem 0.55rem;
  justify-content: space-around;
  align-items: center;
}

.btab {
  background: none;
  border: none;
  color: #64748b;
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 0.15rem;
  font-size: 0.68rem;
  font-weight: 600;
  cursor: pointer;
  padding: 0.25rem 0.5rem;
  border-radius: 8px;
  transition: color 0.15s;
  min-width: 48px;
}

.btab.active {
  color: #38bdf8;
}

.btab-icon {
  font-size: 1.25rem;
  line-height: 1;
}

.btab-label {
  font-size: 0.65rem;
}

/* Prominent center button */
.btab-main {
  position: relative;
  top: -12px;
}

.btab-icon-main {
  font-size: 1.5rem;
  background: #2563eb;
  width: 48px;
  height: 48px;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  box-shadow: 0 4px 14px rgba(37, 99, 235, 0.5);
}

.btab-main.active .btab-icon-main {
  background: #1d4ed8;
}

@media (max-width: 768px) {
  .bottom-tab-bar {
    display: flex;
  }
  .app-root {
    padding-bottom: 72px;
  }
}
</style>
