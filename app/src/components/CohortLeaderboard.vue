<template>
  <div class="leaderboard-card">
    <div class="lb-header">
      <div class="lb-title-group">
        <span class="lb-trophy">🏆</span>
        <h3 class="lb-title">실시간 주간 리그전</h3>
      </div>
      <span class="league-badge">{{ displayLeagueTier }}</span>
    </div>

    <div class="promotion-info">
      <span class="promo-icon">🚀</span>
      <div class="promo-text-wrap">
        <div class="promo-main">상위 2명 <strong>다이아 리그</strong> 승급 예정</div>
        <div class="promo-sub">(일요일 자정 마감)</div>
      </div>
    </div>

    <div class="lb-list">
      <div
        v-for="user in leaderboard"
        :key="user.nickname"
        :class="['lb-row', { 'is-me': user.isMe, 'promoted-row': user.rank <= 2 }]"
      >
        <div class="rank-col">
          <span v-if="user.rank === 1">🥇</span>
          <span v-else-if="user.rank === 2">🥈</span>
          <span v-else-if="user.rank === 3">🥉</span>
          <span v-else class="rank-num">{{ user.rank }}</span>
        </div>

        <div class="user-col">
          <span class="user-icon">{{ user.icon || '🌱' }}</span>
          <div class="user-meta">
            <span class="name">{{ user.nickname }}</span>
            <span class="streak-tag">🔥 {{ user.streak || 5 }}일 연속</span>
          </div>
        </div>

        <div class="xp-col">
          <span class="xp-amount">{{ user.weeklyXp.toLocaleString() }} XP</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, computed, onMounted } from "vue";
import { useGamificationStore } from "../stores/useGamificationStore.js";
import { api } from "../services/apiClient.js";

const gameStore = useGamificationStore();
const leaderboard = ref([]);

const displayLeagueTier = computed(() => {
  return (gameStore.leagueTier || "브론즈").replace(/\s*리그$/, "");
});

onMounted(async () => {
  try {
    const cohort = gameStore.cohort || 4;
    const { data } = await api.getLeague(cohort);
    if (Array.isArray(data)) {
      leaderboard.value = data;
    } else if (data && Array.isArray(data.leaderboard)) {
      leaderboard.value = data.leaderboard;
    } else {
      leaderboard.value = gameStore.sortedLeaderboard;
    }
  } catch (err) {
    console.error("Failed to fetch league data", err);
    leaderboard.value = gameStore.sortedLeaderboard;
  }
});
</script>

<style scoped>
.leaderboard-card {
  background: #1e293b;
  border: 1px solid rgba(255, 255, 255, 0.1);
  border-radius: 16px;
  padding: 1.25rem;
  display: flex;
  flex-direction: column;
  gap: 1rem;
}

.lb-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.lb-title-group {
  display: flex;
  align-items: center;
  gap: 0.5rem;
}

.lb-trophy {
  font-size: 1.25rem;
}

.lb-title {
  font-size: 1.05rem;
  font-weight: 800;
  color: #f8fafc;
  margin: 0;
}

.league-badge {
  background: linear-gradient(135deg, #f59e0b, #d97706);
  color: white;
  font-size: 0.75rem;
  font-weight: 800;
  padding: 0.2rem 0.6rem;
  border-radius: 20px;
}

.promotion-info {
  background: rgba(56, 189, 248, 0.08);
  border: 1px solid rgba(56, 189, 248, 0.2);
  padding: 0.55rem 0.75rem;
  border-radius: 8px;
  font-size: 0.8rem;
  color: #38bdf8;
  display: flex;
  align-items: flex-start;
  gap: 0.5rem;
}

.promo-icon {
  font-size: 1rem;
  line-height: 1.3;
}

.promo-text-wrap {
  display: flex;
  flex-direction: column;
  gap: 0.15rem;
}

.promo-main {
  line-height: 1.3;
}

.promo-sub {
  font-size: 0.72rem;
  color: #7dd3fc;
  opacity: 0.85;
  line-height: 1.2;
}

.lb-list {
  display: flex;
  flex-direction: column;
  gap: 0.4rem;
}

.lb-row {
  display: flex;
  align-items: center;
  padding: 0.6rem 0.8rem;
  border-radius: 10px;
  background: rgba(255, 255, 255, 0.02);
  transition: all 0.15s;
}

.lb-row:hover {
  background: rgba(255, 255, 255, 0.05);
}

.lb-row.is-me {
  background: rgba(37, 99, 235, 0.15);
  border: 1px solid rgba(37, 99, 235, 0.4);
}

.lb-row.promoted-row {
  border-left: 3px solid #10b981;
}

.rank-col {
  width: 32px;
  font-size: 1rem;
  font-weight: 800;
  display: flex;
  align-items: center;
}

.rank-num {
  color: #94a3b8;
}

.user-col {
  flex: 1;
  display: flex;
  align-items: center;
  gap: 0.6rem;
}

.user-icon {
  font-size: 1.1rem;
}

.user-meta {
  display: flex;
  flex-direction: column;
}

.user-meta .name {
  font-size: 0.9rem;
  font-weight: 700;
  color: #f1f5f9;
}

.streak-tag {
  font-size: 0.72rem;
  color: #fb923c;
}

.xp-col {
  font-weight: 800;
  color: #38bdf8;
  font-size: 0.9rem;
}
</style>
