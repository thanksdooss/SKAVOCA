<template>
  <div class="course-catalog">
    <div class="header-section">
      <h1 class="page-title">어휘 카탈로그</h1>
      <p class="page-subtitle">SKALA 교육과정의 모든 어휘를 탐색하고 학습하세요.</p>
    </div>

    <!-- Search Bar -->
    <div class="search-bar">
      <span class="search-icon">🔍</span>
      <input 
        type="text" 
        v-model="searchQuery" 
        placeholder="단어, 발음, 뜻으로 검색해보세요..." 
      />
    </div>

    <!-- Course Filters -->
    <div class="filter-section">
      <button 
        class="filter-btn" 
        :class="{ active: selectedCourseId === null }"
        @click="selectedCourseId = null"
      >
        전체보기
      </button>
      <button 
        v-for="course in courses" 
        :key="course.id" 
        class="filter-btn"
        :class="{ active: selectedCourseId === course.id }"
        :style="{ '--accent-color': course.color }"
        @click="selectedCourseId = course.id"
      >
        {{ course.icon }} {{ course.name }}
      </button>
    </div>

    <!-- Start Course Learning CTA (Visible when a specific course is selected) -->
    <div v-if="selectedCourseId && courseWords.length > 0" class="course-action-card">
      <div class="course-action-info">
        <h3>{{ selectedCourse.name }} 집중 학습</h3>
        <p>이 코스의 어휘 {{ courseWords.length }}개를 바로 학습 시작할 수 있습니다.</p>
      </div>
      <button class="start-btn" @click="startLearning(selectedCourseId)">
        학습 시작하기 ➔
      </button>
    </div>

    <!-- Words List -->
    <div class="words-grid">
      <div 
        v-for="word in filteredWords" 
        :key="word.wordId" 
        class="word-card"
        @click="goToWordDetail(word.wordId)"
      >
        <div class="word-header">
          <div class="word-main">
            <span class="term">{{ word.term }}</span>
            <span class="pronunciation">{{ word.pronunciationKr }}</span>
          </div>
          <div class="badges">
            <span class="badge diff-badge" :class="word.difficulty.toLowerCase()">{{ word.difficulty }}</span>
            <span class="badge course-badge" :style="{ background: getCourseColor(word.courseId) + '33', color: getCourseColor(word.courseId) }">
              {{ getCourseIcon(word.courseId) }} 코스 {{ word.courseId }}
            </span>
          </div>
        </div>
        
        <p class="easy-meaning">{{ word.easyMeaning }}</p>
      </div>
    </div>
    
    <div v-if="filteredWords.length === 0" class="no-results">
      검색 결과가 없습니다.
    </div>
  </div>
</template>

<script setup>
import { ref, computed } from 'vue';
import { useLearningStore } from '../stores/useLearningStore.js';
import { CURRICULUM_COURSES, INITIAL_WORDS } from '../data/curriculumData.js';
import { useRouter } from 'vue-router';
import { normalizeCanonical, calculateLevenshteinDistance } from '../services/levenshtein.js';

const store = useLearningStore();
const router = useRouter();
const courses = CURRICULUM_COURSES;
const allWords = INITIAL_WORDS;

const searchQuery = ref('');
const selectedCourseId = ref(null);

const selectedCourse = computed(() => {
  return courses.find(c => c.id === selectedCourseId.value);
});

const courseWords = computed(() => {
  if (!selectedCourseId.value) return [];
  return allWords.filter(w => w.courseId === selectedCourseId.value);
});

/**
 * 한글 초성 추출
 */
const CHOSUNG = ['ㄱ','ㄲ','ㄴ','ㄷ','ㄸ','ㄹ','ㅁ','ㅂ','ㅃ','ㅅ','ㅆ','ㅇ','ㅈ','ㅉ','ㅊ','ㅋ','ㅌ','ㅍ','ㅎ'];
function extractChosung(str) {
  if (!str) return '';
  return [...str].map(ch => {
    const code = ch.charCodeAt(0) - 0xAC00;
    if (code >= 0 && code <= 11171) return CHOSUNG[Math.floor(code / 588)];
    return ch;
  }).join('');
}

function isChosungQuery(query) {
  return /^[ㄱ-ㅎ]+$/.test(query);
}

/**
 * Fuzzy search: normalizeCanonical로 공백/하이픈/대소문자 정규화 후
 * 1차 부분 문자열 매칭, 2차 초성 검색, 3차 Levenshtein 유사도 매칭
 */
function fuzzyMatch(text, query) {
  if (!text || !query) return false;
  const normText = normalizeCanonical(text);
  const normQuery = normalizeCanonical(query);
  // 1차: 정규화된 부분 문자열 매칭
  if (normText.includes(normQuery)) return true;
  // 2차: 초성 검색 (ㅋㅂㄴ → 쿠버네티스)
  if (isChosungQuery(query.trim())) {
    const textChosung = extractChosung(text);
    if (textChosung.includes(query.trim())) return true;
  }
  // 3차: Levenshtein 유사도 매칭
  if (normQuery.length >= 2) {
    const words = text.toLowerCase().split(/[\s\-_/.,]+/).filter(Boolean);
    for (const w of words) {
      const { similarity } = calculateLevenshteinDistance(normalizeCanonical(w), normQuery);
      if (similarity >= 0.6) return true;
    }
    // 전체 문자열과도 비교
    const { similarity } = calculateLevenshteinDistance(normText, normQuery);
    if (similarity >= 0.6) return true;
  }
  return false;
}

const filteredWords = computed(() => {
  let result = allWords;

  // Filter by course
  if (selectedCourseId.value) {
    result = result.filter(w => w.courseId === selectedCourseId.value);
  }

  // Filter by fuzzy search query
  if (searchQuery.value.trim()) {
    const q = searchQuery.value.trim();
    result = result.filter(w =>
      fuzzyMatch(w.term, q) ||
      fuzzyMatch(w.fullTerm, q) ||
      fuzzyMatch(w.pronunciationKr, q) ||
      fuzzyMatch(w.easyMeaning, q)
    );
  }

  return result;
});

function getCourseColor(courseId) {
  const course = courses.find(c => c.id === courseId);
  return course ? course.color : '#94a3b8';
}

function getCourseIcon(courseId) {
  const course = courses.find(c => c.id === courseId);
  return course ? course.icon : '📚';
}

function goToWordDetail(wordId) {
  router.push({ name: 'wordDetail', params: { wordId } });
}

function startLearning(courseId) {
  const wordsToLearn = allWords.filter(w => w.courseId === courseId);
  if (wordsToLearn.length) {
    store.startLearningSession(wordsToLearn);
    router.push({ name: 'learn' });
  }
}
</script>

<style scoped>
.course-catalog {
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
  padding: 1.5rem 0;
}

.header-section {
  margin-bottom: 0.5rem;
}

.page-title {
  font-size: 1.8rem;
  font-weight: 900;
  margin: 0 0 0.25rem 0;
  color: #f8fafc;
}

.page-subtitle {
  color: #94a3b8;
  margin: 0;
}

.search-bar {
  display: flex;
  align-items: center;
  background: #1e293b;
  border: 1px solid rgba(255, 255, 255, 0.1);
  padding: 0.75rem 1.25rem;
  border-radius: 12px;
  gap: 0.75rem;
}

.search-icon {
  font-size: 1.2rem;
  opacity: 0.6;
}

.search-bar input {
  flex: 1;
  background: none;
  border: none;
  color: #f8fafc;
  font-size: 1rem;
  outline: none;
}

.search-bar input::placeholder {
  color: #64748b;
}

.filter-section {
  display: flex;
  flex-wrap: wrap;
  gap: 0.5rem;
}

.filter-btn {
  background: #1e293b;
  border: 1px solid rgba(255, 255, 255, 0.1);
  color: #94a3b8;
  padding: 0.5rem 1rem;
  border-radius: 20px;
  font-size: 0.85rem;
  font-weight: 600;
  cursor: pointer;
  transition: all 0.2s;
}

.filter-btn:hover {
  background: #273549;
  color: #f8fafc;
}

.filter-btn.active {
  background: var(--accent-color, #2563eb);
  color: white;
  border-color: transparent;
}

.course-action-card {
  background: linear-gradient(135deg, rgba(37, 99, 235, 0.1), rgba(56, 189, 248, 0.1));
  border: 1px solid rgba(56, 189, 248, 0.2);
  border-radius: 16px;
  padding: 1.25rem 1.5rem;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.course-action-info h3 {
  margin: 0 0 0.25rem 0;
  font-size: 1.1rem;
  color: #f8fafc;
}

.course-action-info p {
  margin: 0;
  font-size: 0.85rem;
  color: #94a3b8;
}

.start-btn {
  background: #2563eb;
  color: white;
  border: none;
  padding: 0.75rem 1.25rem;
  border-radius: 10px;
  font-weight: 700;
  cursor: pointer;
  transition: background 0.2s;
}

.start-btn:hover {
  background: #1d4ed8;
}

.words-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(340px, 1fr));
  gap: 1rem;
}

.word-card {
  background: #1e293b;
  border: 1px solid rgba(255, 255, 255, 0.08);
  border-radius: 16px;
  padding: 1.25rem;
  cursor: pointer;
  transition: all 0.2s;
}

.word-card:hover {
  border-color: rgba(255, 255, 255, 0.2);
  transform: translateY(-2px);
}

.word-header {
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  margin-bottom: 0.75rem;
}

.word-main {
  display: flex;
  flex-direction: column;
  gap: 0.25rem;
}

.term {
  font-size: 1.3rem;
  font-weight: 800;
  color: #f8fafc;
}

.pronunciation {
  font-size: 0.85rem;
  color: #94a3b8;
}

.badges {
  display: flex;
  flex-direction: column;
  gap: 0.4rem;
  align-items: flex-end;
}

.badge {
  font-size: 0.7rem;
  font-weight: 700;
  padding: 0.2rem 0.5rem;
  border-radius: 6px;
}

.diff-badge.easy { background: rgba(16, 185, 129, 0.2); color: #34d399; }
.diff-badge.medium { background: rgba(245, 158, 11, 0.2); color: #fbbf24; }
.diff-badge.hard { background: rgba(239, 68, 68, 0.2); color: #f87171; }

.easy-meaning {
  margin: 0;
  font-size: 0.95rem;
  line-height: 1.4;
  color: #cbd5e1;
}

.expanded-content {
  margin-top: 1rem;
  animation: fadeIn 0.2s ease;
}

.divider {
  height: 1px;
  background: rgba(255, 255, 255, 0.1);
  margin: 1rem 0;
}

.detail-section {
  margin-bottom: 1rem;
}

.detail-section:last-child {
  margin-bottom: 0;
}

.detail-section h4 {
  margin: 0 0 0.35rem 0;
  font-size: 0.75rem;
  color: #64748b;
  text-transform: uppercase;
  letter-spacing: 0.5px;
}

.detail-section p {
  margin: 0;
  font-size: 0.9rem;
  color: #e2e8f0;
  line-height: 1.5;
}

:deep(.highlight) {
  color: #38bdf8;
  font-weight: 700;
  background: rgba(56, 189, 248, 0.15);
  padding: 0 0.2rem;
  border-radius: 4px;
}

.no-results {
  text-align: center;
  padding: 3rem;
  color: #64748b;
  font-size: 1.1rem;
  background: #1e293b;
  border-radius: 16px;
  border: 1px dashed rgba(255, 255, 255, 0.1);
}

@keyframes fadeIn {
  from { opacity: 0; transform: translateY(-5px); }
  to { opacity: 1; transform: translateY(0); }
}

@media (max-width: 768px) {
  .words-grid {
    grid-template-columns: 1fr;
  }
  .course-action-card {
    flex-direction: column;
    text-align: center;
    gap: 1rem;
  }
}
</style>
