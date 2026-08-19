<template>
  <div class="profile-setup">
    <div class="profile-card">
      <div class="brand">
        <span class="logo-icon">🥑</span>
        <h1>SKAVOCA</h1>
      </div>
      <p class="subtitle">SKALA 통합 계정으로 로그인해주세요.</p>

      <button @click="openLogin" class="submit-btn">로그인 / 회원가입 시작하기 ➔</button>
    </div>
  </div>
</template>

<script setup>
import { watch, onMounted } from 'vue';
import { useAuthStore } from '../stores/useAuthStore.js';
import { useRouter } from 'vue-router';

const authStore = useAuthStore();
const router = useRouter();

function openLogin() {
  authStore.openAuthModal();
}

// If already authenticated (e.g. page refresh with valid token), go home immediately
onMounted(() => {
  if (authStore.isAuthenticated) {
    router.replace({ name: 'home' });
  }
});

watch(() => authStore.isAuthenticated, (newVal) => {
  if (newVal) {
    router.replace({ name: 'home' });
  }
});
</script>

<style scoped>
.profile-setup {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 70vh;
}

.profile-card {
  background: #1e293b;
  border: 1px solid rgba(255, 255, 255, 0.1);
  border-radius: 20px;
  padding: 3rem 2.5rem;
  width: 100%;
  max-width: 480px;
  box-shadow: 0 20px 40px rgba(0, 0, 0, 0.3);
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
}

.brand {
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 0.75rem;
}

.logo-icon {
  font-size: 2rem;
  color: #f7df1e;
}

.brand h1 {
  font-size: 2.2rem;
  font-weight: 900;
  color: #f8fafc;
  margin: 0;
  letter-spacing: -1px;
}

.subtitle {
  text-align: center;
  color: #94a3b8;
  margin-top: -0.5rem;
  margin-bottom: 1rem;
}

.setup-form {
  display: flex;
  flex-direction: column;
  gap: 1.25rem;
}

.form-group {
  display: flex;
  flex-direction: column;
  gap: 0.5rem;
}

label {
  font-size: 0.9rem;
  font-weight: 700;
  color: #f1f5f9;
}

input[type="text"],
select {
  background: rgba(0, 0, 0, 0.2);
  border: 1px solid rgba(255, 255, 255, 0.15);
  color: #f8fafc;
  padding: 0.85rem 1rem;
  border-radius: 12px;
  font-size: 1rem;
  outline: none;
  transition: border-color 0.2s;
}

input[type="text"]:focus,
select:focus {
  border-color: #38bdf8;
}

.radio-options {
  display: flex;
  gap: 1rem;
}

.radio-label {
  display: flex;
  align-items: center;
  gap: 0.5rem;
  background: rgba(0, 0, 0, 0.2);
  border: 1px solid rgba(255, 255, 255, 0.15);
  padding: 0.85rem 1.2rem;
  border-radius: 12px;
  cursor: pointer;
  flex: 1;
  justify-content: center;
  transition: all 0.2s;
}

.radio-label:has(input:checked) {
  border-color: #38bdf8;
  background: rgba(56, 189, 248, 0.1);
  color: #38bdf8;
}

input[type="radio"] {
  display: none;
}

.submit-btn {
  background: #2563eb;
  color: white;
  border: none;
  padding: 1rem;
  border-radius: 12px;
  font-size: 1.1rem;
  font-weight: 800;
  cursor: pointer;
  margin-top: 1rem;
  transition: background 0.2s;
}

.submit-btn:hover {
  background: #1d4ed8;
}
</style>
