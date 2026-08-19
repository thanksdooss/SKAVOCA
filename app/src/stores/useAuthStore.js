import { defineStore } from "pinia";
import { api } from "../services/apiClient.js";
import { STORAGE_KEYS } from "../constants.js";
import { useGamificationStore } from "./useGamificationStore.js";
import { useLearningStore } from "./useLearningStore.js";

export const DEMO_ACCOUNTS = [
  {
    userId: 1,
    email: "skala_student@skala.ai",
    nickname: "김스칼라",
    cohort: 4,
    role: "ROLE_STUDENT",
    tier: "시니어 개발자",
    xp: 1420,
    streakDays: 7,
    avatar: "👨‍💻",
    description: "SKALA 4기 정규 수강생 (열공 모드)"
  },
  {
    userId: 2,
    email: "instructor_lead@skala.ai",
    nickname: "박리더 강사",
    cohort: 4,
    role: "ROLE_INSTRUCTOR",
    tier: "전설의 CTO",
    xp: 8900,
    streakDays: 45,
    avatar: "👨‍🏫",
    description: "SKALA 풀스택/클라우드 전임 교수진"
  },
  {
    userId: 3,
    email: "junior_dev@skala.ai",
    nickname: "이신입",
    cohort: 4,
    role: "ROLE_STUDENT",
    tier: "코딩 노비",
    xp: 150,
    streakDays: 2,
    avatar: "🌱",
    description: "SKALA 4기 신규 입학생 (기초 다지기)"
  }
];

export const useAuthStore = defineStore("auth", {
  state: () => {
    // Load persisted session from localStorage
    let session = null;
    try {
      const saved = localStorage.getItem(STORAGE_KEYS.AUTH_SESSION);
      if (saved) {
        const parsed = JSON.parse(saved);
        // Only accept sessions with a valid JWT accessToken
        if (parsed && parsed.accessToken) {
          session = parsed;
        } else {
          // Clear stale data from old demo account system
          localStorage.removeItem(STORAGE_KEYS.AUTH_SESSION);
        }
      }
    } catch (e) {
      localStorage.removeItem(STORAGE_KEYS.AUTH_SESSION);
    }
    
    return {
      user: session ? {
        userId: session.userId,
        email: session.email,
        nickname: session.nickname,
        role: session.role,
        tier: session.tier,
        cohort: session.cohort || 4,
      } : null,
      accessToken: session?.accessToken || null,
      refreshToken: session?.refreshToken || null,
      isLoading: false,
      error: null,
      authModalOpen: false
    };
  },
  
  getters: {
    isAuthenticated: (state) => !!state.accessToken && !!state.user,
    isInstructor: (state) => state.user?.role === "ROLE_INSTRUCTOR",
    currentNickname: (state) => state.user?.nickname || "학습자",
    userNickname: (state) => state.user?.nickname || "학습자",
    userCohort: (state) => state.user?.cohort || 4,
    userAvatar: (state) => "👨‍💻", // or dynamically based on role
    currentUser: (state) => state.user,
  },
  
  actions: {
    openAuthModal() {
      this.authModalOpen = true;
    },

    closeAuthModal() {
      this.authModalOpen = false;
    },

    async signup(email, password, nickname, cohort = 4) {
      this.isLoading = true;
      this.error = null;
      try {
        const { data } = await api.signup({ email, password, nickname, cohort });
        this._setSession(data);
        // Load fresh progress for new user
        const learningStore = useLearningStore();
        learningStore.reloadUserProgress();
        return { success: true };
      } catch (err) {
        this.error = err.response?.data?.message || "회원가입에 실패했습니다.";
        return { success: false, message: this.error };
      } finally {
        this.isLoading = false;
      }
    },
    
    async login(email, password) {
      this.isLoading = true;
      this.error = null;
      try {
        const { data } = await api.login({ email, password });
        this._setSession(data);
        
        // Sync Gamification Store
        const gameStore = useGamificationStore();
        gameStore.nickname = data.nickname;
        gameStore.cohort = data.cohort;

        // Reload user-specific progress data
        const learningStore = useLearningStore();
        learningStore.reloadUserProgress();
        
        return { success: true };
      } catch (err) {
        this.error = err.response?.data?.message || "로그인에 실패했습니다.";
        return { success: false, message: this.error };
      } finally {
        this.isLoading = false;
      }
    },
    
    logout() {
      this.user = null;
      this.accessToken = null;
      this.refreshToken = null;
      localStorage.removeItem(STORAGE_KEYS.AUTH_SESSION);
      // Clear in-memory progress so next user starts fresh
      try {
        const learningStore = useLearningStore();
        learningStore.progressMap = {};
      } catch(e) {}
    },
    
    _setSession(data) {
      this.accessToken = data.accessToken;
      this.refreshToken = data.refreshToken;
      this.user = {
        userId: data.userId,
        email: data.email,
        nickname: data.nickname,
        role: data.role,
        tier: data.tier,
        cohort: data.cohort || 4,
      };
      localStorage.setItem(STORAGE_KEYS.AUTH_SESSION, JSON.stringify({
        accessToken: data.accessToken,
        refreshToken: data.refreshToken,
        userId: data.userId,
        email: data.email,
        nickname: data.nickname,
        role: data.role,
        tier: data.tier,
        cohort: data.cohort,
      }));
    },
  },
});
