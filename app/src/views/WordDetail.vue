<template>
  <div class="word-detail-view" v-if="word">
    <div class="header-area">
      <button class="back-btn" @click="router.back()">← 뒤로가기</button>
      <div class="course-badge" :style="{ background: getCourseColor(word.courseId) + '33', color: getCourseColor(word.courseId) }">
        {{ getCourseIcon(word.courseId) }} 코스 {{ word.courseId }}
      </div>
    </div>

    <div class="main-card">
      <div class="term-section">
        <h1 class="term">{{ word.term }}</h1>
        <p class="full-term" v-if="word.fullTerm && word.fullTerm !== word.term">{{ word.fullTerm }}</p>
        <span class="badge diff-badge" :class="word.difficulty.toLowerCase()">{{ word.difficulty }}</span>
      </div>

      <div class="pronunciation-section">
        <span class="pronunciation-kr">🇰🇷 {{ word.pronunciationKr }}</span>
        <button class="tts-btn" @click="playTTS(word.term)">🔊 발음 듣기</button>
      </div>

      <div class="content-section">
        <h3 class="section-title"><span class="icon">📖</span> 의미</h3>
        <div class="meaning-card">
          <p>{{ word.easyMeaning }}</p>
        </div>
      </div>

      <div class="content-section">
        <h3 class="section-title"><span class="icon">💡</span> 예문</h3>
        <div class="context-card">
          <p v-html="highlightTerm(word.contextSentence, word.term)"></p>
        </div>
      </div>

      <div class="content-section" v-if="word.distractors && word.distractors.length">
        <h3 class="section-title"><span class="icon">🔍</span> 오답/혼동 어휘 노트</h3>
        <div class="distractor-list">
          <div class="distractor-item" v-for="d in word.distractors" :key="d.term">
            <span class="distractor-term">{{ d.term }}</span>
            <span class="distractor-feedback">{{ d.feedback }}</span>
          </div>
        </div>
      </div>

      <div class="content-section" v-if="progress">
        <h3 class="section-title"><span class="icon">📊</span> 학습 현황</h3>
        <div class="stats-grid">
          <div class="stat-box">
            <span class="stat-value">{{ progress.repetitions }}</span>
            <span class="stat-label">반복 횟수</span>
          </div>
          <div class="stat-box">
            <span class="stat-value">{{ progress.easeFactor.toFixed(2) }}</span>
            <span class="stat-label">난이도 지수</span>
          </div>
          <div class="stat-box">
            <span class="stat-value">{{ progress.totalReviews || 0 }}</span>
            <span class="stat-label">총 복습</span>
          </div>
          <div class="stat-box">
            <span class="stat-value">{{ nextReviewDate }}</span>
            <span class="stat-label">다음 복습</span>
          </div>
        </div>
      </div>

      <div class="action-buttons">
        <button class="learn-btn" @click="startLearningWord">이 단어로 학습 시작하기</button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, computed, onMounted } from 'vue';
import { useRouter } from 'vue-router';
import { useLearningStore } from '../stores/useLearningStore.js';
import { CURRICULUM_COURSES, INITIAL_WORDS } from '../data/curriculumData.js';
import { speakPronunciation } from '../services/ttsService.js';
import { api } from '../services/apiClient.js';

const props = defineProps({
  wordId: {
    type: String,
    required: true
  }
});

const router = useRouter();
const store = useLearningStore();

const word = ref(null);
const progress = ref(null);

onMounted(async () => {
  const numericId = Number(props.wordId);
  try {
    // Try to fetch from API first
    const res = await api.getWordDetail(numericId);
    word.value = res.data.word || res.data;
    progress.value = res.data.progress || null;
  } catch (error) {
    // Fallback to local data
    word.value = INITIAL_WORDS.find(w => w.wordId === numericId) || store.words.find(w => w.wordId === numericId) || null;
    progress.value = null;
  }
});

const nextReviewDate = computed(() => {
  if (!progress.value || !progress.value.nextReviewTime) return '-';
  const d = new Date(progress.value.nextReviewTime);
  return d.toLocaleDateString();
});

function getCourseColor(courseId) {
  const course = CURRICULUM_COURSES.find(c => c.id === courseId);
  return course ? course.color : '#94a3b8';
}

function getCourseIcon(courseId) {
  const course = CURRICULUM_COURSES.find(c => c.id === courseId);
  return course ? course.icon : '📚';
}

function playTTS(term) {
  speakPronunciation(term);
}

function highlightTerm(sentence, term) {
  if (!sentence) return '';
  return sentence.replace(/{{(.*?)}}/g, '<span class="highlight-word">$1</span>');
}

function startLearningWord() {
  if (word.value) {
    store.startLearningSession([word.value]);
    router.push({ name: 'learn' });
  }
}
</script>

<style scoped>
.word-detail-view {
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
  padding: 1.5rem 0;
  max-width: 800px;
  margin: 0 auto;
}

.header-area {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.back-btn {
  background: transparent;
  border: none;
  color: #94a3b8;
  font-size: 1rem;
  font-weight: 600;
  cursor: pointer;
  padding: 0.5rem 0;
}

.back-btn:hover {
  color: #f8fafc;
}

.course-badge {
  font-size: 0.85rem;
  font-weight: 700;
  padding: 0.4rem 0.8rem;
  border-radius: 8px;
}

.main-card {
  background: #1e293b;
  border: 1px solid rgba(255, 255, 255, 0.08);
  border-radius: 16px;
  padding: 2rem;
  display: flex;
  flex-direction: column;
  gap: 2rem;
}

.term-section {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  gap: 0.5rem;
}

.term {
  font-size: 2.5rem;
  font-weight: 900;
  margin: 0;
  color: #f8fafc;
}

.full-term {
  font-size: 1.1rem;
  color: #94a3b8;
  margin: 0;
}

.badge {
  font-size: 0.8rem;
  font-weight: 700;
  padding: 0.3rem 0.6rem;
  border-radius: 6px;
  margin-top: 0.5rem;
}

.diff-badge.easy { background: rgba(16, 185, 129, 0.2); color: #34d399; }
.diff-badge.medium { background: rgba(245, 158, 11, 0.2); color: #fbbf24; }
.diff-badge.hard { background: rgba(239, 68, 68, 0.2); color: #f87171; }

.pronunciation-section {
  display: flex;
  align-items: center;
  gap: 1rem;
  background: rgba(255, 255, 255, 0.03);
  padding: 1rem;
  border-radius: 12px;
}

.pronunciation-kr {
  font-size: 1.1rem;
  color: #cbd5e1;
  font-weight: 600;
}

.tts-btn {
  background: rgba(56, 189, 248, 0.1);
  color: #38bdf8;
  border: 1px solid rgba(56, 189, 248, 0.2);
  padding: 0.5rem 1rem;
  border-radius: 8px;
  font-weight: 600;
  cursor: pointer;
  transition: all 0.2s;
}

.tts-btn:hover {
  background: rgba(56, 189, 248, 0.2);
}

.section-title {
  font-size: 1.1rem;
  color: #f8fafc;
  margin: 0 0 1rem 0;
  display: flex;
  align-items: center;
  gap: 0.5rem;
}

.meaning-card, .context-card {
  background: rgba(255, 255, 255, 0.03);
  padding: 1.5rem;
  border-radius: 12px;
  border: 1px solid rgba(255, 255, 255, 0.05);
}

.meaning-card p, .context-card p {
  margin: 0;
  font-size: 1.1rem;
  line-height: 1.6;
  color: #e2e8f0;
}

:deep(.highlight-word) {
  color: #38bdf8;
  font-weight: 700;
  background: rgba(56, 189, 248, 0.15);
  padding: 0.1rem 0.3rem;
  border-radius: 4px;
}

.distractor-list {
  display: flex;
  flex-direction: column;
  gap: 0.8rem;
}

.distractor-item {
  background: rgba(239, 68, 68, 0.05);
  border: 1px solid rgba(239, 68, 68, 0.1);
  padding: 1rem;
  border-radius: 10px;
  display: flex;
  flex-direction: column;
  gap: 0.4rem;
}

.distractor-term {
  font-weight: 700;
  color: #f87171;
  font-size: 1.05rem;
}

.distractor-feedback {
  color: #cbd5e1;
  font-size: 0.95rem;
  line-height: 1.4;
}

.stats-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(120px, 1fr));
  gap: 1rem;
}

.stat-box {
  background: rgba(255, 255, 255, 0.03);
  border: 1px solid rgba(255, 255, 255, 0.05);
  padding: 1rem;
  border-radius: 10px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  gap: 0.5rem;
}

.stat-value {
  font-size: 1.5rem;
  font-weight: 800;
  color: #10b981;
}

.stat-label {
  font-size: 0.8rem;
  color: #94a3b8;
}

.action-buttons {
  margin-top: 1rem;
  display: flex;
  justify-content: flex-end;
}

.learn-btn {
  background: #2563eb;
  color: white;
  border: none;
  padding: 1rem 2rem;
  border-radius: 12px;
  font-size: 1.1rem;
  font-weight: 700;
  cursor: pointer;
  transition: all 0.2s;
  width: 100%;
}

.learn-btn:hover {
  background: #1d4ed8;
  transform: translateY(-2px);
}

@media (max-width: 768px) {
  .term {
    font-size: 2rem;
  }
}
</style>
