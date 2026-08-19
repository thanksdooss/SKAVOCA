// SKAVOCA Application Constants
export const STORAGE_KEYS = {
  AUTH_SESSION: "skavoca_auth_session_v1",
  USER_PROFILE: "skavoca_profile",
  USER_PROGRESS: "skavoca_user_progress",
  CUSTOM_WORDS: "skavoca_custom_words",
  AI_FEEDBACK_CACHE: "skavoca_ai_feedback_cache_v3"
};

export const RPG_TIERS = [
  { level: 1, name: "코딩 노비", minXp: 0, maxXp: 300, icon: "🧹", color: "#64748b" },
  { level: 2, name: "주니어 개발자", minXp: 300, maxXp: 1000, icon: "🌱", color: "#10b981" },
  { level: 3, name: "시니어 개발자", minXp: 1000, maxXp: 2500, icon: "⚡", color: "#3b82f6" },
  { level: 4, name: "테크 리드", minXp: 2500, maxXp: 5000, icon: "🚀", color: "#8b5cf6" },
  { level: 5, name: "전설의 CTO", minXp: 5000, maxXp: 99999, icon: "👑", color: "#f59e0b" }
];
