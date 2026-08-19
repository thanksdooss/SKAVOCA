<template>
  <div class="modal-backdrop" v-if="authStore.authModalOpen" @mousedown="onBackdropMouseDown" @mouseup="onBackdropMouseUp">
    <div class="login-card" @mousedown.stop @mouseup.stop>
      <button class="close-btn" @click="authStore.closeAuthModal">✕</button>

      <!-- Logo & Header -->
      <div class="auth-header">
        <div class="auth-logo">🥑 SKAVOCA</div>
        <h2 class="auth-title">SKALA 학습자 & 강사 통합 로그인</h2>
        <p class="auth-desc">SK Ai Leader Academy 정규 교육과정 계정으로 접속하세요.</p>
      </div>

      <!-- Tabs -->
      <div class="auth-tabs">
        <button 
          :class="['tab-btn', { active: activeTab === 'login' }]"
          @click="activeTab = 'login'"
        >로그인</button>
        <button 
          :class="['tab-btn', { active: activeTab === 'signup' }]"
          @click="activeTab = 'signup'"
        >회원가입</button>
      </div>

      <!-- Error Message -->
      <div v-if="authStore.error" class="error-msg">
        {{ authStore.error }}
      </div>

      <!-- Login Form -->
      <form v-if="activeTab === 'login'" class="auth-form" @submit.prevent="handleLogin">
        <div class="input-group">
          <label>이메일 주소</label>
          <input
            v-model="loginForm.email"
            type="email"
            placeholder="skala_student@skala.ai"
            required
            :disabled="authStore.isLoading"
          />
        </div>
        <div class="input-group">
          <label>비밀번호</label>
          <input
            v-model="loginForm.password"
            type="password"
            placeholder="••••••••"
            required
            :disabled="authStore.isLoading"
          />
        </div>
        <button type="submit" class="submit-auth-btn" :disabled="authStore.isLoading || isLockedOut">
          <span v-if="isLockedOut">🔒 {{ lockoutRemaining }}초 후 재시도</span>
          <span v-else-if="authStore.isLoading">로그인 중...</span>
          <span v-else>로그인 ➔</span>
        </button>
      </form>

      <!-- Signup Form -->
      <form v-if="activeTab === 'signup'" class="auth-form" @submit.prevent="handleSignup">
        <div class="input-group">
          <label>이메일 주소</label>
          <input
            v-model="signupForm.email"
            type="email"
            placeholder="skala_student@skala.ai"
            required
            :disabled="authStore.isLoading"
          />
        </div>
        <div class="input-group">
          <label>비밀번호</label>
          <input
            v-model="signupForm.password"
            type="password"
            placeholder="••••••••"
            required
            :disabled="authStore.isLoading"
          />
        </div>
        <div class="input-group">
          <label>닉네임</label>
          <input
            v-model="signupForm.nickname"
            type="text"
            placeholder="예: 김스칼라"
            required
            :disabled="authStore.isLoading"
          />
        </div>
        <div class="input-group">
          <label>SKALA 기수</label>
          <select v-model="signupForm.cohort" required :disabled="authStore.isLoading">
            <option :value="1">1기</option>
            <option :value="2">2기</option>
            <option :value="3">3기</option>
            <option :value="4">4기</option>
            <option :value="5">5기</option>
          </select>
        </div>
        <button type="submit" class="submit-auth-btn" :disabled="authStore.isLoading">
          <span v-if="authStore.isLoading">가입 중...</span>
          <span v-else>회원가입 완료 ➔</span>
        </button>
      </form>
    </div>
  </div>
</template>

<script setup>
import { ref, computed } from "vue";
import { useAuthStore } from "../stores/useAuthStore.js";
import { useRouter } from "vue-router";

const authStore = useAuthStore();
const router = useRouter();

const activeTab = ref("login");
const backdropMouseDown = ref(false);

function onBackdropMouseDown(e) {
  // Only register if the mousedown happened directly on the backdrop
  if (e.target === e.currentTarget) {
    backdropMouseDown.value = true;
  }
}

function onBackdropMouseUp(e) {
  // Only close if both mousedown AND mouseup were on the backdrop
  if (backdropMouseDown.value && e.target === e.currentTarget) {
    authStore.closeAuthModal();
  }
  backdropMouseDown.value = false;
}

const loginForm = ref({
  email: "",
  password: ""
});

const signupForm = ref({
  email: "",
  password: "",
  nickname: "",
  cohort: 4
});

// Login attempt limiting
const loginAttempts = ref(0);
const lockoutUntil = ref(null);
const lockoutRemaining = ref(0);
let lockoutTimer = null;

const isLockedOut = computed(() => {
  return lockoutUntil.value && lockoutRemaining.value > 0;
});

function startLockoutTimer() {
  lockoutTimer = setInterval(() => {
    const remaining = Math.ceil((lockoutUntil.value - Date.now()) / 1000);
    if (remaining <= 0) {
      lockoutRemaining.value = 0;
      lockoutUntil.value = null;
      loginAttempts.value = 0;
      clearInterval(lockoutTimer);
    } else {
      lockoutRemaining.value = remaining;
    }
  }, 1000);
}

async function handleLogin() {
  if (isLockedOut.value) return;
  if (!loginForm.value.email || !loginForm.value.password) return;
  
  const res = await authStore.login(loginForm.value.email, loginForm.value.password);
  if (res.success) {
    loginAttempts.value = 0;
    loginForm.value.email = "";
    loginForm.value.password = "";
    authStore.closeAuthModal();
    router.replace({ name: 'home' });
  } else {
    loginAttempts.value++;
    if (loginAttempts.value >= 5) {
      lockoutUntil.value = Date.now() + 30000; // 30 seconds
      lockoutRemaining.value = 30;
      startLockoutTimer();
      authStore.error = `로그인 5회 실패. ${lockoutRemaining.value}초 후 다시 시도해 주세요.`;
    }
  }
}

async function handleSignup() {
  if (!signupForm.value.email || !signupForm.value.password || !signupForm.value.nickname) return;
  const res = await authStore.signup(
    signupForm.value.email, 
    signupForm.value.password, 
    signupForm.value.nickname, 
    signupForm.value.cohort
  );
  if (res.success) {
    signupForm.value.email = "";
    signupForm.value.password = "";
    signupForm.value.nickname = "";
    authStore.closeAuthModal();
    router.replace({ name: 'home' });
  }
}
</script>

<style scoped>
.modal-backdrop {
  position: fixed;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
  z-index: 9999;
  background: rgba(0, 0, 0, 0.75);
  backdrop-filter: blur(8px);
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 1rem;
  overflow-y: auto;
  animation: fadeIn 0.2s ease-out;
}

.login-card {
  position: relative;
  width: 100%;
  max-width: 420px;
  background: #0f172a;
  border: 1px solid rgba(255, 255, 255, 0.12);
  border-radius: 24px;
  padding: 2rem 2.2rem;
  box-shadow: 0 25px 50px -12px rgba(0, 0, 0, 0.7);
  display: flex;
  flex-direction: column;
  gap: 1.25rem;
  animation: popIn 0.25s cubic-bezier(0.16, 1, 0.3, 1);
}

.close-btn {
  position: absolute;
  top: 1.25rem;
  right: 1.25rem;
  background: rgba(255, 255, 255, 0.08);
  border: none;
  color: #94a3b8;
  width: 32px;
  height: 32px;
  border-radius: 50%;
  cursor: pointer;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 0.9rem;
  transition: all 0.15s;
}

.close-btn:hover {
  background: rgba(255, 255, 255, 0.2);
  color: white;
}

.auth-header {
  text-align: center;
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 0.3rem;
}

.auth-logo {
  font-size: 1.6rem;
  font-weight: 900;
  color: #10b981;
  letter-spacing: -0.5px;
}

.auth-title {
  font-size: 1.2rem;
  font-weight: 800;
  color: #f8fafc;
  margin: 0;
}

.auth-desc {
  font-size: 0.82rem;
  color: #94a3b8;
  margin: 0;
}

.auth-tabs {
  display: flex;
  background: rgba(255,255,255,0.05);
  border-radius: 12px;
  padding: 0.3rem;
  margin-top: 0.5rem;
}

.tab-btn {
  flex: 1;
  background: transparent;
  border: none;
  color: #94a3b8;
  padding: 0.6rem;
  border-radius: 8px;
  font-size: 0.9rem;
  font-weight: 700;
  cursor: pointer;
  transition: all 0.2s;
}

.tab-btn.active {
  background: #1e293b;
  color: white;
  box-shadow: 0 2px 8px rgba(0,0,0,0.2);
}

.error-msg {
  background: rgba(239, 68, 68, 0.15);
  color: #ef4444;
  padding: 0.75rem;
  border-radius: 8px;
  font-size: 0.85rem;
  font-weight: 600;
  text-align: center;
}

.auth-form {
  display: flex;
  flex-direction: column;
  gap: 0.85rem;
}

.input-group {
  display: flex;
  flex-direction: column;
  gap: 0.3rem;
}

.input-group label {
  font-size: 0.78rem;
  font-weight: 600;
  color: #cbd5e1;
}

.input-group input, .input-group select {
  background: rgba(15, 23, 42, 0.8);
  border: 1px solid rgba(255, 255, 255, 0.12);
  border-radius: 10px;
  padding: 0.65rem 0.85rem;
  color: #f8fafc;
  font-size: 0.9rem;
  outline: none;
  transition: border-color 0.15s;
}

.input-group input:focus, .input-group select:focus {
  border-color: #10b981;
}

.input-group input:disabled, .input-group select:disabled {
  opacity: 0.6;
  cursor: not-allowed;
}

.submit-auth-btn {
  background: linear-gradient(135deg, #10b981, #059669);
  color: white;
  border: none;
  font-size: 0.95rem;
  font-weight: 700;
  padding: 0.8rem;
  border-radius: 12px;
  cursor: pointer;
  box-shadow: 0 4px 14px rgba(16, 185, 129, 0.35);
  transition: all 0.15s;
  margin-top: 0.4rem;
}

.submit-auth-btn:hover:not(:disabled) {
  transform: translateY(-2px);
  box-shadow: 0 6px 18px rgba(16, 185, 129, 0.45);
}

.submit-auth-btn:disabled {
  opacity: 0.7;
  cursor: not-allowed;
}

@keyframes fadeIn {
  from { opacity: 0; }
  to { opacity: 1; }
}

@keyframes popIn {
  from { opacity: 0; transform: scale(0.95); }
  to { opacity: 1; transform: scale(1); }
}
</style>
