import { defineStore } from "pinia";
import confetti from "canvas-confetti";
import { soundEffects } from "../services/ttsService.js";
import { RPG_TIERS } from "../constants.js";
import { api } from "../services/apiClient.js";

export const useGamificationStore = defineStore("gamification", {
  state: () => ({
    nickname: "학습자",
    cohort: 4,
    xp: 0,
    streakDays: 0,
    lastActiveDate: new Date().toISOString(),
    leagueTier: "브론즈",
    peers: []
  }),

  getters: {
    currentTier: (state) => {
      for (let i = RPG_TIERS.length - 1; i >= 0; i--) {
        if (state.xp >= RPG_TIERS[i].minXp) {
          return RPG_TIERS[i];
        }
      }
      return RPG_TIERS[0];
    },

    nextTier: (state) => {
      const currentIdx = RPG_TIERS.findIndex((t) => t.level === state.currentTier.level);
      return currentIdx < RPG_TIERS.length - 1 ? RPG_TIERS[currentIdx + 1] : null;
    },

    tierProgressPercent: (state) => {
      const current = state.currentTier;
      const next = state.nextTier;
      if (!next) return 100;
      const progress = ((state.xp - current.minXp) / (next.minXp - current.minXp)) * 100;
      return Math.min(100, Math.max(0, Math.round(progress)));
    },

    myLeagueRank: (state) => {
      const myWeekly = state.xp % 3000;
      const all = [...state.peers, { rank: 0, nickname: `${state.nickname} (나)`, weeklyXp: myWeekly, isMe: true }];
      all.sort((a, b) => b.weeklyXp - a.weeklyXp);
      const myIdx = all.findIndex((p) => p.isMe);
      return myIdx + 1;
    },

    sortedLeaderboard: (state) => {
      const myWeekly = state.xp % 3000;
      const all = [
        ...state.peers.map((p) => ({ ...p, isMe: false })),
        {
          nickname: `${state.nickname} (나)`,
          tier: state.currentTier.name,
          weeklyXp: myWeekly,
          streak: state.streakDays,
          icon: state.currentTier.icon,
          isMe: true
        }
      ];
      all.sort((a, b) => b.weeklyXp - a.weeklyXp);
      return all.map((item, idx) => ({ ...item, rank: idx + 1 }));
    }
  },

  actions: {
    async fetchProfile() {
      try {
        const { data } = await api.getProfile();
        
        const oldTierLevel = this.currentTier.level;
        
        // Update state
        this.nickname = data.nickname || this.nickname;
        this.cohort = data.cohort || this.cohort;
        this.xp = data.xp || 0;
        this.streakDays = data.streakDays || 0;
        this.leagueTier = data.leagueTier || this.leagueTier;
        
        const newTierLevel = this.currentTier.level;

        // Celebrate if level up
        if (newTierLevel > oldTierLevel) {
          soundEffects.playLevelUp();
          confetti({
            particleCount: 120,
            spread: 70,
            origin: { y: 0.6 }
          });
        }
      } catch (err) {
        console.error("Failed to fetch gamification profile", err);
      }
    },

    addXp(amount) {
      // Stub out direct XP modification as it's now handled by the backend
      // We will instead re-fetch the profile to get the latest XP and level up
      this.fetchProfile();
    }
  }
});
