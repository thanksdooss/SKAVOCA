<template>
  <div class="main-dashboard">
    <!-- Top Hero Banner: RPG Tier & Streak -->
    <div class="hero-banner">
      <div class="hero-content">
        <div class="tier-pill" :style="{ borderColor: gameStore.currentTier.color }">
          <span>{{ gameStore.currentTier.icon }}</span>
          <span>{{ gameStore.currentTier.name }} (Lv.{{ gameStore.currentTier.level }})</span>
        </div>
        <h1 class="hero-title">안녕하세요, {{ gameStore.nickname }}님!</h1>
        <p class="hero-subtitle">
          단어들을 학습하고 <strong>다이아 리그 승급</strong>에 도전하세요!
        </p>

        <!-- Tier EXP Bar -->
        <div class="exp-bar-wrapper">
          <div class="exp-meta">
            <span>EXP {{ gameStore.xp }} / {{ gameStore.nextTier ? gameStore.nextTier.minXp : 99999 }}</span>
            <span v-if="gameStore.nextTier">다음 승급까지 {{ gameStore.nextTier.minXp - gameStore.xp }} EXP</span>
            <span v-else>최고 티어 달성!</span>
          </div>
          <div class="exp-bar-track">
            <div class="exp-bar-fill" :style="{ width: gameStore.tierProgressPercent + '%' }"></div>
          </div>
        </div>
      </div>

      <!-- Quick Stats Card -->
      <div class="quick-stats-card">
        <div class="stat-box">
          <span class="stat-num">{{ Object.keys(store.progressMap).length }}</span>
          <span class="stat-label">오늘 학습한 단어 수</span>
        </div>
        <div class="stat-box">
          <span class="stat-num">{{ store.words.length }}</span>
          <span class="stat-label">총 IT 어휘 수</span>
        </div>
        <div class="stat-box">
          <span class="stat-num">{{ gameStore.streakDays }}일</span>
          <span class="stat-label">연속 학습일</span>
        </div>
      </div>
    </div>

    <!-- Main Grid: CTA + Courses + Leaderboard -->
    <div class="dashboard-grid">
      <!-- Left Column -->
      <div class="grid-left">
        <!-- Daily Fast Learning Deck CTA -->
        <div class="deck-cta-card">
          <div class="deck-info">
            <div class="deck-badge">⚡ 빠른 문제 풀기</div>
            <h2 class="deck-title">오늘의 맞춤 큐레이션 세션</h2>
            <p class="deck-desc">
              문맥 빈칸 채우기와 실시간 AI 피드백으로 빠른 학습!
            </p>
          </div>
          <button class="start-session-btn" @click="() => { store.startLearningSession(); router.push({ name: 'learn' }); }">
            <span>빠른 문제 풀기</span>
            <span class="btn-arrow">➔</span>
          </button>
        </div>

        <!-- Flashcard Review Deck CTA -->
        <div class="review-cta-card">
          <div class="deck-info">
            <div class="deck-badge review-badge">🎴 스와이프 학습 모드</div>
            <h2 class="deck-title">플래시카드 복습 세션</h2>
            <p class="deck-desc">
              좌(다시보기) ↔ 우(기억함) 스와이프로 <strong>270개</strong> 어휘를 반복 학습!
            </p>
          </div>
          <button class="start-review-btn" @click="() => { store.startReviewSession(); router.push({ name: 'review' }); }">
            <span>스와이프 학습 모드</span>
            <span class="btn-arrow">➔</span>
          </button>
        </div>

        <!-- Course Catalogs Grid -->
        <div class="courses-section">
          <div class="section-header">
            <h3>📚 SKALA 과목별로 학습하기</h3>
            <span class="view-all-text">전체 9개 과목</span>
          </div>
          <div class="courses-grid">
            <div
              v-for="course in courses"
              :key="course.id"
              class="course-card"
              @click="startCourseSession(course.id)"
            >
              <div class="course-icon" :style="{ background: course.color + '22', color: course.color }">
                {{ course.icon }}
              </div>
              <div class="course-meta">
                <span class="course-name">{{ course.name }}</span>
                <div class="course-prog-bar">
                  <div class="prog-fill" :style="{ width: getCourseProgress(course.id) + '%', background: course.color }"></div>
                </div>
              </div>
              <span class="prog-text">{{ getCourseProgress(course.id) }}%</span>
            </div>
          </div>
        </div>

        <!-- Weak Words Quick Deck -->
        <div class="weak-words-section" v-if="store.weakWords.length > 0">
          <div class="section-header">
            <h3>🚨 나의 취약 어휘 (SM-2 EF 하위)</h3>
            <button class="weak-btn" @click="() => { store.startLearningSession(store.weakWords); router.push({ name: 'learn' }); }">
              모아풀기 ({{ store.weakWords.length }}개) ➔
            </button>
          </div>
          <div class="weak-list">
            <div v-for="w in store.weakWords.slice(0, 3)" :key="w.wordId" class="weak-chip">
              <span class="warn-dot">!</span>
              <span class="term-name">{{ w.term }}</span>
              <span class="pronounce-name">({{ w.pronunciationKr }})</span>
              <span class="ef-tag">EF {{ w.progress.easinessFactor }}</span>
            </div>
          </div>
        </div>
      </div>

      <!-- Right Column: Leaderboard -->
      <div class="grid-right">
        <CohortLeaderboard />
      </div>
    </div>
  </div>
</template>

<script setup>
import { onMounted } from "vue";
import { useLearningStore } from "../stores/useLearningStore.js";
import { useGamificationStore } from "../stores/useGamificationStore.js";
import { CURRICULUM_COURSES } from "../data/curriculumData.js";
import CohortLeaderboard from "../components/CohortLeaderboard.vue";
import { useRouter } from 'vue-router';

const store = useLearningStore();
const router = useRouter();
const gameStore = useGamificationStore();
const courses = CURRICULUM_COURSES;

onMounted(() => {
  gameStore.fetchProfile();
  store.fetchProgress();
});

function getCourseProgress(courseId) {
  const courseWords = store.words.filter((w) => w.courseId === courseId);
  if (!courseWords.length) return 0;
  const reviewed = courseWords.filter((w) => store.progressMap[w.wordId]);
  return Math.round((reviewed.length / courseWords.length) * 100);
}

function startCourseSession(courseId) {
  const courseWords = store.words.filter((w) => w.courseId === courseId);
  if (courseWords.length) {
    store.startLearningSession(courseWords);
    router.push({ name: 'learn' });
  }
}
</script>

<style scoped>
.main-dashboard {
  display: flex;
  flex-direction: column;
  gap: 1.75rem;
  padding: 1.5rem 0;
}

.hero-banner {
  background: linear-gradient(135deg, #1e293b, #0f172a);
  border: 1px solid rgba(255, 255, 255, 0.1);
  border-radius: 20px;
  padding: 1.75rem 2rem;
  display: flex;
  justify-content: space-between;
  align-items: center;
  gap: 2rem;
}

.hero-content {
  flex: 1;
  display: flex;
  flex-direction: column;
  gap: 0.5rem;
}

.tier-pill {
  display: inline-flex;
  align-items: center;
  gap: 0.4rem;
  font-size: 0.82rem;
  font-weight: 800;
  background: rgba(255, 255, 255, 0.05);
  border: 1px solid;
  padding: 0.25rem 0.75rem;
  border-radius: 20px;
  width: fit-content;
  color: #f8fafc;
}

.hero-title {
  font-size: 1.65rem;
  font-weight: 900;
  color: #f8fafc;
  margin: 0;
  letter-spacing: -0.5px;
}

.hero-subtitle {
  font-size: 0.95rem;
  color: #94a3b8;
  margin: 0;
}

.exp-bar-wrapper {
  margin-top: 0.5rem;
  max-width: 440px;
  display: flex;
  flex-direction: column;
  gap: 0.35rem;
}

.exp-meta {
  display: flex;
  justify-content: space-between;
  font-size: 0.75rem;
  font-weight: 700;
  color: #38bdf8;
}

.exp-bar-track {
  height: 8px;
  background: rgba(255, 255, 255, 0.08);
  border-radius: 6px;
  overflow: hidden;
}

.exp-bar-fill {
  height: 100%;
  background: linear-gradient(90deg, #38bdf8, #818cf8);
  border-radius: 6px;
  transition: width 0.4s ease;
}

.quick-stats-card {
  display: flex;
  gap: 1.5rem;
  background: rgba(255, 255, 255, 0.03);
  border: 1px solid rgba(255, 255, 255, 0.08);
  padding: 1.25rem 1.75rem;
  border-radius: 16px;
}

.stat-box {
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
}

.stat-num {
  font-size: 1.6rem;
  font-weight: 900;
  color: #f8fafc;
}

.stat-label {
  font-size: 0.75rem;
  color: #94a3b8;
  font-weight: 600;
}

.dashboard-grid {
  display: grid;
  grid-template-columns: 1.5fr 1fr;
  gap: 1.75rem;
}

.grid-left {
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
}

.deck-cta-card {
  background: linear-gradient(135deg, #1d4ed8, #2563eb);
  border-radius: 18px;
  padding: 1.5rem 1.75rem;
  color: white;
  display: flex;
  justify-content: space-between;
  align-items: center;
  gap: 1rem;
  box-shadow: 0 10px 25px -5px rgba(37, 99, 235, 0.4);
}

.deck-badge {
  font-size: 0.75rem;
  font-weight: 800;
  background: rgba(255, 255, 255, 0.2);
  padding: 0.2rem 0.55rem;
  border-radius: 6px;
  width: fit-content;
  margin-bottom: 0.4rem;
}

.deck-title {
  font-size: 1.3rem;
  font-weight: 800;
  margin: 0;
}

.deck-desc {
  font-size: 0.88rem;
  opacity: 0.9;
  margin: 0.25rem 0 0;
}

.start-session-btn {
  background: white;
  color: #1d4ed8;
  border: none;
  font-size: 0.95rem;
  font-weight: 800;
  padding: 0.85rem 1.35rem;
  border-radius: 12px;
  cursor: pointer;
  display: flex;
  align-items: center;
  gap: 0.5rem;
  white-space: nowrap;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
  transition: all 0.2s;
}

.start-session-btn:hover {
  transform: translateY(-2px);
  box-shadow: 0 6px 18px rgba(0, 0, 0, 0.25);
}

.review-cta-card {
  background: linear-gradient(135deg, #047857, #10b981);
  border-radius: 18px;
  padding: 1.5rem 1.75rem;
  color: white;
  display: flex;
  justify-content: space-between;
  align-items: center;
  gap: 1rem;
  box-shadow: 0 10px 25px -5px rgba(16, 185, 129, 0.4);
}

.review-badge {
  background: rgba(255, 255, 255, 0.2);
}

.start-review-btn {
  background: white;
  color: #047857;
  border: none;
  font-size: 0.95rem;
  font-weight: 800;
  padding: 0.85rem 1.35rem;
  border-radius: 12px;
  cursor: pointer;
  display: flex;
  align-items: center;
  gap: 0.5rem;
  white-space: nowrap;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
  transition: all 0.2s;
}

.start-review-btn:hover {
  transform: translateY(-2px);
  box-shadow: 0 6px 18px rgba(0, 0, 0, 0.25);
}

.courses-section {
  display: flex;
  flex-direction: column;
  gap: 1rem;
}

.section-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.section-header h3 {
  font-size: 1.1rem;
  font-weight: 800;
  color: #f8fafc;
  margin: 0;
}

.view-all-text {
  font-size: 0.8rem;
  color: #64748b;
  font-weight: 600;
}

.courses-grid {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 0.85rem;
}

.course-card {
  background: #1e293b;
  border: 1px solid rgba(255, 255, 255, 0.08);
  border-radius: 12px;
  padding: 0.85rem 1rem;
  display: flex;
  align-items: center;
  gap: 0.75rem;
  cursor: pointer;
  transition: all 0.15s ease;
}

.course-card:hover {
  background: #273549;
  border-color: rgba(255, 255, 255, 0.2);
  transform: translateY(-2px);
}

.course-icon {
  width: 38px;
  height: 38px;
  border-radius: 10px;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 1.25rem;
}

.course-meta {
  flex: 1;
  display: flex;
  flex-direction: column;
  gap: 0.35rem;
  min-width: 0;
}

.course-name {
  font-size: 0.82rem;
  font-weight: 700;
  color: #f1f5f9;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

.course-prog-bar {
  height: 4px;
  background: rgba(255, 255, 255, 0.1);
  border-radius: 4px;
  overflow: hidden;
}

.prog-fill {
  height: 100%;
  border-radius: 4px;
}

.prog-text {
  font-size: 0.75rem;
  font-weight: 700;
  color: #94a3b8;
}

.weak-words-section {
  background: rgba(239, 68, 68, 0.05);
  border: 1px solid rgba(239, 68, 68, 0.2);
  border-radius: 16px;
  padding: 1.25rem;
  display: flex;
  flex-direction: column;
  gap: 0.85rem;
}

.weak-btn {
  background: rgba(239, 68, 68, 0.15);
  border: 1px solid rgba(239, 68, 68, 0.3);
  color: #f87171;
  font-size: 0.75rem;
  font-weight: 700;
  padding: 0.3rem 0.65rem;
  border-radius: 6px;
  cursor: pointer;
}

.weak-list {
  display: flex;
  gap: 0.6rem;
  flex-wrap: wrap;
}

.weak-chip {
  display: flex;
  align-items: center;
  gap: 0.4rem;
  background: rgba(0, 0, 0, 0.3);
  padding: 0.4rem 0.75rem;
  border-radius: 8px;
  font-size: 0.82rem;
}

.warn-dot {
  color: #ef4444;
  font-weight: 900;
}

.term-name {
  color: #f8fafc;
  font-weight: 700;
}

.pronounce-name {
  color: #94a3b8;
  font-size: 0.75rem;
}

.ef-tag {
  font-size: 0.7rem;
  background: rgba(239, 68, 68, 0.2);
  color: #fca5a5;
  padding: 0.1rem 0.35rem;
  border-radius: 4px;
}

@media (max-width: 960px) {
  .hero-banner {
    flex-direction: column;
    align-items: flex-start;
  }
  .dashboard-grid {
    grid-template-columns: 1fr;
  }
  .courses-grid {
    grid-template-columns: repeat(2, 1fr);
  }
}
</style>
