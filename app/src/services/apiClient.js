// SKAVOCA API Client - Axios-based HTTP client with JWT auto-injection
import axios from "axios";
import { STORAGE_KEYS } from "../constants.js";

const API_BASE_URL = import.meta.env.VITE_API_URL || "http://localhost:8080";

const apiClient = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    "Content-Type": "application/json",
  },
  timeout: 10000,
});

// Request interceptor: auto-inject JWT token
apiClient.interceptors.request.use(
  (config) => {
    try {
      const session = JSON.parse(localStorage.getItem(STORAGE_KEYS.AUTH_SESSION) || "{}");
      if (session.accessToken) {
        config.headers.Authorization = `Bearer ${session.accessToken}`;
      }
    } catch (e) {
      // ignore parse errors
    }
    return config;
  },
  (error) => Promise.reject(error)
);

// Response interceptor: handle 401 unauthorized
apiClient.interceptors.response.use(
  (response) => response,
  (error) => {
    if (error.response?.status === 401) {
      // Token expired - could trigger re-login flow
      console.warn("[SKAVOCA API] Unauthorized - token may be expired");
    }
    return Promise.reject(error);
  }
);

// API service functions
export const api = {
  // Auth
  signup: (data) => apiClient.post("/api/v1/auth/register", data),
  login: (data) => apiClient.post("/api/v1/auth/login", data),

  // Learning
  getTodayDeck: () => apiClient.get("/api/v1/learning/today"),
  submitAnswer: (data) => apiClient.post("/api/v1/learning/submit-answer", data),

  // AI Feedback
  explainDistractor: (data) => apiClient.post("/api/v1/ai/explain-distractor", data),

  // Gamification
  getLeague: (cohort) => apiClient.get(`/api/v1/gamification/league?cohort=${cohort}`),
  getProfile: () => apiClient.get("/api/v1/gamification/profile"),

  // Admin
  getDifficultWords: (cohort = 4, limit = 10) =>
    apiClient.get(`/api/v1/admin/analytics/difficult-words?cohort=${cohort}&limit=${limit}`),
  createWord: (data) => apiClient.post("/api/v1/admin/words", data),
  bulkUploadWords: (words) => apiClient.post('/api/v1/admin/words/bulk-upload', words),

  // Catalog
  getCourses: () => apiClient.get('/api/v1/catalog/courses'),
  getCourseWords: (courseId) => apiClient.get(`/api/v1/catalog/courses/${courseId}/words`),

  // Words (for detail view)
  getWordDetail: (wordId) => apiClient.get(`/api/v1/words/${wordId}`),
  getWordsByCourse: (courseId) => apiClient.get(`/api/v1/words?courseId=${courseId}`),
};

export default apiClient;
