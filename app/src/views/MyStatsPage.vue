<template>
  <div class="stats-page-container">
    <!-- Header -->
    <div class="stats-header">
      <h2>📊 나의 학습 분석 & 개발자 성장 리포트</h2>
    </div>

    <!-- M-2: Profile Card -->
    <div class="profile-card">
      <div class="profile-main">
        <div class="profile-avatar" :style="{ borderColor: gameStore.currentTier.color }">
          {{ gameStore.currentTier.icon }}
        </div>
        <div class="profile-info">
          <div class="user-cohort-tag">SKALA {{ gameStore.cohort || 4 }}기</div>
          <h3 class="nickname">{{ gameStore.nickname }}님</h3>
          <p class="tier-name" :style="{ color: gameStore.currentTier.color }">
            {{ gameStore.currentTier.name }} ({{ gameStore.xp }} XP)
          </p>
        </div>
        <div class="profile-stats">
          <div class="stat-badge">
            <span class="stat-icon">🏆</span>
            <div class="stat-text">
              <span class="stat-label">현재 리그</span>
              <span class="stat-val">{{ gameStore.leagueTier }}</span>
            </div>
          </div>
          <div class="stat-badge">
            <span class="stat-icon">🔥</span>
            <div class="stat-text">
              <span class="stat-label">학습일</span>
              <span class="stat-val">{{ gameStore.streakDays }}일 연속</span>
            </div>
          </div>
        </div>
      </div>
      <div class="badges-section">
        <div class="badge-item" :class="{ earned: gameStore.streakDays >= 7 }">
          <span class="b-icon">🔥</span>
          <span class="b-name">7일 연속 학습</span>
        </div>
        <div class="badge-item" :class="{ earned: Object.keys(store.progressMap).length >= 10 }">
          <span class="b-icon">🧠</span>
          <span class="b-name">10 어휘 마스터</span>
        </div>
        <div class="badge-item" :class="{ earned: retentionRate >= 80 }">
          <span class="b-icon">🎯</span>
          <span class="b-name">원샷 마스터</span>
        </div>
      </div>
    </div>

    <!-- M-2: Radar Chart & League Widget -->
    <div class="stats-two-col">
      <!-- 9-Course Radar Chart -->
      <div class="stat-card">
        <div class="card-title">🕸️ 과목별 학습 숙련도 (EF 기반)</div>
        <p class="stat-desc">각 교재별 학습한 어휘의 평균 Easiness Factor를 분석한 방사형 차트입니다.</p>
        
        <div class="radar-container">
          <svg viewBox="0 0 400 400" class="radar-svg">
            <polygon
              v-for="level in [0.2, 0.4, 0.6, 0.8, 1.0]"
              :key="'grid-'+level"
              :points="getPolygonPoints(level)"
              class="radar-grid"
            />
            <line
              v-for="(course, i) in courseData"
              :key="'axis-'+i"
              :x1="center"
              :y1="center"
              :x2="getPoint(i, 1.0).x"
              :y2="getPoint(i, 1.0).y"
              class="radar-axis"
            />
            <polygon :points="radarDataPoints" class="radar-data-area" />
            <polyline :points="radarDataPointsClosed" class="radar-data-line" />
            <text
              v-for="(course, i) in courseData"
              :key="'label-'+i"
              :x="getLabelPoint(i).x"
              :y="getLabelPoint(i).y"
              class="radar-label"
              text-anchor="middle"
            >
              {{ course.shortName }}
            </text>
          </svg>
        </div>
      </div>

      <!-- League Details Widget -->
      <div class="stat-card">
        <div class="card-title-row">
          <div class="card-title">🏆 주간 리그 현황</div>
          <span class="league-rank-badge">현재 {{ gameStore.myLeagueRank }}위</span>
        </div>
        <div class="league-info">
          <div class="league-msg promotion">
            <span class="msg-icon">🔼</span> 상위 20% (1~2위) 달성 시 <strong>다이아몬드 리그</strong> 승급!
          </div>
          <div class="league-msg demotion" v-if="gameStore.myLeagueRank > 6">
            <span class="msg-icon">🔽</span> 하위 20% 주의! 학습을 진행하여 방어하세요.
          </div>
        </div>

        <div class="mini-leaderboard">
          <div
            v-for="user in topLeaderboard"
            :key="user.nickname"
            class="lb-item"
            :class="{ 'is-me': user.isMe }"
          >
            <div class="lb-left">
              <span class="lb-rank">{{ user.rank }}</span>
              <span class="lb-icon">{{ user.icon }}</span>
              <span class="lb-name">{{ user.nickname }}</span>
            </div>
            <div class="lb-right">
              <span class="lb-xp">{{ user.weeklyXp }} XP</span>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- RPG Tier Progression Roadmap -->
    <div class="tier-roadmap-card">
      <div class="card-title">🗺️ 개발자 성장 RPG 티어 로드맵</div>
      <div class="roadmap-steps">
        <div
          v-for="tier in tiers"
          :key="tier.level"
          :class="['step-item', { active: tier.level === gameStore.currentTier.level, completed: tier.level < gameStore.currentTier.level }]"
        >
          <div class="step-icon-wrap" :style="{ borderColor: tier.color }">
            <span class="step-icon">{{ tier.icon }}</span>
          </div>
          <span class="step-name">{{ tier.name }}</span>
          <span class="step-xp">{{ tier.minXp }} XP~</span>
        </div>
      </div>
    </div>

    <!-- M-3: Dynamic Forgetting Curve & Weak Words -->
    <div class="stats-two-col">
      <!-- Forgetting Curve Defense Graph -->
      <div class="stat-card">
        <div class="card-title">📉 에빙하우스 망각 곡선 방어 현황</div>
        <p class="stat-desc">
          현재까지 학습한 <strong>{{ totalReviewed }}개</strong>의 어휘 중 평균 기억 유지율은 <strong>{{ retentionRate.toFixed(1) }}%</strong> 입니다.
        </p>

        <div class="curve-chart-box">
          <svg viewBox="0 0 360 180" class="curve-svg">
            <line x1="40" y1="20" x2="340" y2="20" stroke="rgba(255,255,255,0.05)" />
            <line x1="40" y1="80" x2="340" y2="80" stroke="rgba(255,255,255,0.05)" />
            <line x1="40" y1="140" x2="340" y2="140" stroke="rgba(255,255,255,0.05)" />

            <!-- Natural Forgetting Curve -->
            <path
              d="M 40 20 Q 80 120 340 150"
              fill="none"
              stroke="#ef4444"
              stroke-width="2"
              stroke-dasharray="4 4"
            />

            <!-- Dynamic Defense Curve -->
            <path
              :d="dynamicDefensePath"
              fill="none"
              stroke="#00d2ff"
              stroke-width="3"
            />

            <text x="34" y="25" fill="#94a3b8" font-size="10" text-anchor="end">100%</text>
            <text x="34" y="85" fill="#94a3b8" font-size="10" text-anchor="end">50%</text>
            <text x="34" y="145" fill="#94a3b8" font-size="10" text-anchor="end">0%</text>
            <text x="50" y="170" fill="#64748b" font-size="10">1일차</text>
            <text x="170" y="170" fill="#64748b" font-size="10">6일차</text>
            <text x="310" y="170" fill="#64748b" font-size="10">15일차</text>
          </svg>
        </div>

        <div class="curve-legend">
          <span class="c-item"><span class="c-line red"></span> 자연 망각 (미복습)</span>
          <span class="c-item"><span class="c-line cyan"></span> SKAVOCA 방어율 {{ retentionRate.toFixed(0) }}%</span>
        </div>
      </div>

      <!-- Weak Words Deck -->
      <div class="stat-card">
        <div class="card-title-row">
          <div class="card-title">🚨 나의 취약 어휘 오답 노트</div>
          <div style="display: flex; gap: 0.5rem;">
            <button
              class="review-all-btn emergency-btn"
              v-if="extremelyWeakWords.length > 0"
              @click="() => { store.startLearningSession(extremelyWeakWords); router.push({ name: 'learn' }); }"
              style="background: #ef4444;"
            >
              🚨 취약 어휘 모아풀기 ➔
            </button>
            <button
              class="review-all-btn"
              v-if="store.weakWords.length > 0"
              @click="() => { store.startLearningSession(store.weakWords); router.push({ name: 'learn' }); }"
            >
              전체 모아풀기 ➔
            </button>
          </div>
        </div>

        <div class="weak-words-table-wrap" v-if="store.weakWords.length > 0">
          <div v-for="w in store.weakWords" :key="w.wordId" class="weak-item-row">
            <div class="weak-main">
              <span class="w-term">{{ w.term }}</span>
              <span class="w-meaning">{{ w.easyMeaning }}</span>
            </div>
            <div class="weak-stats">
              <span class="w-ef">EF {{ w.progress.easinessFactor.toFixed(2) }}</span>
              <span class="w-lapses">{{ w.progress.totalLapses }}회 오답</span>
            </div>
          </div>
        </div>
        <div class="empty-weak" v-else>
          <span class="check-icon">✨</span>
          <p>취약 어휘가 없습니다! 모든 학습을 완벽히 방어하고 있습니다.</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { computed } from "vue";
import { useLearningStore } from "../stores/useLearningStore.js";
import { useGamificationStore } from "../stores/useGamificationStore.js";
import { RPG_TIERS } from "../constants.js";
import { CURRICULUM_COURSES } from "../data/curriculumData.js";
import { useRouter } from "vue-router";

const store = useLearningStore();
const router = useRouter();
const gameStore = useGamificationStore();
const tiers = RPG_TIERS;

const extremelyWeakWords = computed(() => {
  return store.words
    .map(w => {
      const prog = store.progressMap[w.wordId];
      return {
        ...w,
        progress: prog || { easinessFactor: 2.5, totalLapses: 0 }
      };
    })
    .filter(w => w.progress.easinessFactor <= 1.7)
    .sort((a, b) => a.progress.easinessFactor - b.progress.easinessFactor);
});

// --- M-3: Dynamic Forgetting Curve Stats ---
const totalReviewed = computed(() => Object.keys(store.progressMap).length);
const retentionRate = computed(() => {
  if (totalReviewed.value === 0) return 0;
  let retained = 0;
  for (const key in store.progressMap) {
    const p = store.progressMap[key];
    // “기억함” 판정: EF 2.0 이상이고 최소 1회 이상 성공 복습(repetitions >= 1)
    if (p.easinessFactor >= 2.0 && (p.repetitions || 0) >= 1) retained++;
  }
  return (retained / totalReviewed.value) * 100;
});

// Calculate a dynamic path based on retention rate
const dynamicDefensePath = computed(() => {
  // Base path: M 40 20 Q 70 80 90 20 Q 140 70 170 20 Q 240 60 270 20 L 340 25
  const rate = retentionRate.value;
  // If rate is 100%, dips are very small (Y goes to 30)
  // If rate is 0%, dips go down to 140
  const dipY1 = 20 + ((100 - rate) / 100) * 100; 
  const dipY2 = 20 + ((100 - rate) / 100) * 90;
  const dipY3 = 20 + ((100 - rate) / 100) * 80;
  const endY = 20 + ((100 - rate) / 100) * 50;

  return `M 40 20 Q 70 ${dipY1} 90 20 Q 140 ${dipY2} 170 20 Q 240 ${dipY3} 270 20 L 340 ${endY}`;
});

// --- M-2: Radar Chart Calculations ---
const center = 200;
const radius = 130;

const courseData = computed(() => {
  return CURRICULUM_COURSES.map(course => {
    // Find words for this course
    const courseWords = store.words.filter(w => w.courseId === course.id);
    let totalScore = 0;
    let reviewedCount = 0;
    
    courseWords.forEach(w => {
      const prog = store.progressMap[w.wordId];
      if (prog) {
        reviewedCount++;
        // map EF (1.3 to 2.5) to a score (0 to 1)
        let score = (prog.easinessFactor - 1.3) / 1.2;
        score = Math.max(0, Math.min(1, score)); // clamp 0~1
        totalScore += score;
      }
    });

    const avgRatio = reviewedCount > 0 ? (totalScore / reviewedCount) : 0;
    
    // Short name extraction (e.g., "1. Git 이해 및 활용" -> "1. Git")
    const shortName = course.name.split(" ")[0] + " " + course.name.split(" ")[1];

    return {
      ...course,
      shortName,
      ratio: avgRatio || 0.1 // Give a tiny minimum so the chart isn't invisible
    };
  });
});

function getPoint(index, ratio) {
  const angle = (Math.PI * 2 / courseData.value.length) * index - Math.PI / 2;
  return {
    x: center + radius * ratio * Math.cos(angle),
    y: center + radius * ratio * Math.sin(angle)
  };
}

function getLabelPoint(index) {
  const angle = (Math.PI * 2 / courseData.value.length) * index - Math.PI / 2;
  const labelRadius = radius + 30;
  return {
    x: center + labelRadius * Math.cos(angle),
    y: center + labelRadius * Math.sin(angle) + 4
  };
}

function getPolygonPoints(level) {
  return courseData.value
    .map((_, i) => {
      const pt = getPoint(i, level);
      return `${pt.x},${pt.y}`;
    })
    .join(" ");
}

const radarDataPoints = computed(() => {
  return courseData.value
    .map((c, i) => {
      const pt = getPoint(i, c.ratio);
      return `${pt.x},${pt.y}`;
    })
    .join(" ");
});

const radarDataPointsClosed = computed(() => {
  if (!courseData.value.length) return "";
  const first = getPoint(0, courseData.value[0].ratio);
  return `${radarDataPoints.value} ${first.x},${first.y}`;
});

// --- M-2: League Mini Leaderboard ---
// Get top 3 + me (if not in top 3)
const topLeaderboard = computed(() => {
  const all = gameStore.sortedLeaderboard;
  let top3 = all.slice(0, 3);
  const myRank = gameStore.myLeagueRank;
  
  // Ensure "me" is included if not in top 3
  if (myRank > 3) {
    const me = all.find(u => u.isMe);
    if (me) top3.push(me);
  }
  return top3;
});

</script>

<style scoped>
.stats-page-container {
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
  padding: 1.5rem 0;
}

.stats-header h2 {
  font-size: 1.4rem;
  font-weight: 800;
  color: #f8fafc;
  margin: 0;
}

/* Profile Card */
.profile-card {
  background: #1e293b;
  border: 1px solid rgba(255, 255, 255, 0.1);
  border-radius: 18px;
  padding: 1.5rem 2rem;
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
}

.profile-main {
  display: flex;
  align-items: center;
  gap: 1.5rem;
}

.profile-avatar {
  width: 72px;
  height: 72px;
  border-radius: 50%;
  background: rgba(255, 255, 255, 0.05);
  border: 3px solid;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 2rem;
}

.profile-info {
  display: flex;
  flex-direction: column;
  gap: 0.2rem;
  flex: 1;
}

.user-cohort-tag {
  font-size: 0.75rem;
  background: rgba(255, 255, 255, 0.08);
  padding: 0.2rem 0.6rem;
  border-radius: 12px;
  color: #94a3b8;
  font-weight: 700;
  align-self: flex-start;
}

.nickname {
  margin: 0;
  font-size: 1.3rem;
  color: #f8fafc;
  font-weight: 800;
}

.tier-name {
  margin: 0;
  font-size: 0.9rem;
  font-weight: 700;
}

.profile-stats {
  display: flex;
  gap: 1rem;
}

.stat-badge {
  display: flex;
  align-items: center;
  gap: 0.5rem;
  background: rgba(0,0,0,0.2);
  padding: 0.75rem 1rem;
  border-radius: 12px;
}

.stat-icon {
  font-size: 1.5rem;
}

.stat-text {
  display: flex;
  flex-direction: column;
}

.stat-label {
  font-size: 0.7rem;
  color: #94a3b8;
}

.stat-val {
  font-size: 0.95rem;
  color: #f8fafc;
  font-weight: 800;
}

.badges-section {
  display: flex;
  gap: 1rem;
  padding-top: 1.5rem;
  border-top: 1px dashed rgba(255, 255, 255, 0.1);
}

.badge-item {
  display: flex;
  align-items: center;
  gap: 0.4rem;
  background: rgba(255, 255, 255, 0.03);
  padding: 0.4rem 0.8rem;
  border-radius: 20px;
  opacity: 0.4;
  filter: grayscale(100%);
  border: 1px solid rgba(255, 255, 255, 0.1);
}

.badge-item.earned {
  opacity: 1;
  filter: grayscale(0%);
  background: rgba(37, 99, 235, 0.15);
  border-color: rgba(37, 99, 235, 0.4);
}

.b-icon {
  font-size: 1.1rem;
}

.b-name {
  font-size: 0.8rem;
  font-weight: 700;
  color: #f8fafc;
}

/* Two Col */
.stats-two-col {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 1.5rem;
}

.stat-card {
  background: #1e293b;
  border: 1px solid rgba(255, 255, 255, 0.1);
  border-radius: 18px;
  padding: 1.5rem;
  display: flex;
  flex-direction: column;
  gap: 1rem;
}

.card-title-row {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.card-title {
  font-size: 1.05rem;
  font-weight: 800;
  color: #f8fafc;
}

.stat-desc {
  font-size: 0.85rem;
  color: #94a3b8;
  margin: 0;
  line-height: 1.4;
}

/* Radar Chart */
.radar-container {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 1rem;
}

.radar-svg {
  width: 100%;
  max-width: 320px;
}

.radar-grid {
  fill: none;
  stroke: rgba(255, 255, 255, 0.08);
  stroke-dasharray: 3, 3;
}

.radar-axis {
  stroke: rgba(255, 255, 255, 0.08);
}

.radar-data-area {
  fill: rgba(37, 99, 235, 0.25);
  stroke: none;
}

.radar-data-line {
  fill: none;
  stroke: #3b82f6;
  stroke-width: 2.5;
}

.radar-label {
  fill: #94a3b8;
  font-size: 11px;
  font-weight: 700;
}

/* League Widget */
.league-rank-badge {
  background: #f59e0b;
  color: #fff;
  font-size: 0.75rem;
  font-weight: 800;
  padding: 0.2rem 0.6rem;
  border-radius: 12px;
}

.league-info {
  display: flex;
  flex-direction: column;
  gap: 0.5rem;
  background: rgba(0,0,0,0.2);
  padding: 1rem;
  border-radius: 12px;
  font-size: 0.85rem;
}

.league-msg {
  display: flex;
  align-items: center;
  gap: 0.4rem;
}

.league-msg.promotion {
  color: #60a5fa;
}

.league-msg.demotion {
  color: #f87171;
}

.mini-leaderboard {
  display: flex;
  flex-direction: column;
  gap: 0.5rem;
  margin-top: 0.5rem;
}

.lb-item {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0.6rem 0.8rem;
  border-radius: 8px;
  background: rgba(255, 255, 255, 0.03);
}

.lb-item.is-me {
  background: rgba(37, 99, 235, 0.15);
  border: 1px solid rgba(37, 99, 235, 0.3);
}

.lb-left {
  display: flex;
  align-items: center;
  gap: 0.75rem;
}

.lb-rank {
  font-weight: 800;
  color: #94a3b8;
  width: 20px;
}

.lb-item.is-me .lb-rank {
  color: #60a5fa;
}

.lb-icon {
  font-size: 1.2rem;
}

.lb-name {
  color: #f8fafc;
  font-weight: 700;
  font-size: 0.9rem;
}

.lb-xp {
  font-size: 0.85rem;
  color: #cbd5e1;
  font-weight: 700;
}

/* Tier Roadmap */
.tier-roadmap-card {
  background: #1e293b;
  border: 1px solid rgba(255, 255, 255, 0.1);
  border-radius: 18px;
  padding: 1.5rem 2rem;
  display: flex;
  flex-direction: column;
  gap: 1.25rem;
}

.roadmap-steps {
  display: grid;
  grid-template-columns: repeat(5, 1fr);
  gap: 1rem;
}

.step-item {
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
  gap: 0.35rem;
  opacity: 0.45;
  transition: all 0.2s;
}

.step-item.active {
  opacity: 1;
  transform: scale(1.05);
}

.step-item.completed {
  opacity: 0.85;
}

.step-icon-wrap {
  width: 48px;
  height: 48px;
  border-radius: 50%;
  background: rgba(255, 255, 255, 0.05);
  border: 2px solid;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 1.4rem;
}

.step-name {
  font-size: 0.85rem;
  font-weight: 800;
  color: #f8fafc;
}

.step-xp {
  font-size: 0.72rem;
  color: #94a3b8;
}

/* Curve Chart */
.curve-chart-box {
  background: rgba(0, 0, 0, 0.25);
  border-radius: 12px;
  padding: 1rem 0.5rem;
}

.curve-svg {
  width: 100%;
}

.curve-legend {
  display: flex;
  gap: 1rem;
  font-size: 0.75rem;
  color: #94a3b8;
}

.c-item {
  display: flex;
  align-items: center;
  gap: 0.35rem;
}

.c-line {
  width: 16px;
  height: 3px;
  border-radius: 2px;
}

.c-line.red { background: #ef4444; }
.c-line.cyan { background: #00d2ff; }

/* Weak Words */
.review-all-btn {
  background: #2563eb;
  color: white;
  border: none;
  font-size: 0.8rem;
  font-weight: 700;
  padding: 0.35rem 0.75rem;
  border-radius: 6px;
  cursor: pointer;
}

.weak-words-table-wrap {
  display: flex;
  flex-direction: column;
  gap: 0.5rem;
  max-height: 260px;
  overflow-y: auto;
}

.weak-item-row {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background: rgba(255, 255, 255, 0.03);
  padding: 0.6rem 0.8rem;
  border-radius: 8px;
  border: 1px solid rgba(255, 255, 255, 0.05);
}

.weak-main {
  display: flex;
  flex-direction: column;
  gap: 0.15rem;
  max-width: 70%;
}

.w-term {
  font-weight: 800;
  color: #f8fafc;
  font-size: 0.9rem;
}

.w-meaning {
  font-size: 0.75rem;
  color: #94a3b8;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

.weak-stats {
  display: flex;
  flex-direction: column;
  align-items: flex-end;
  gap: 0.15rem;
}

.w-ef {
  font-size: 0.72rem;
  background: rgba(239, 68, 68, 0.2);
  color: #f87171;
  padding: 0.1rem 0.35rem;
  border-radius: 4px;
  font-weight: 700;
}

.w-lapses {
  font-size: 0.72rem;
  color: #ef4444;
}

.empty-weak {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  padding: 2rem;
  text-align: center;
  color: #94a3b8;
  gap: 0.5rem;
}

.check-icon {
  font-size: 2rem;
}

@media (max-width: 900px) {
  .stats-two-col {
    grid-template-columns: 1fr;
  }
  .roadmap-steps {
    grid-template-columns: repeat(3, 1fr);
  }
  .profile-main {
    flex-direction: column;
    text-align: center;
  }
  .user-cohort-tag {
    align-self: center;
  }
}
</style>
