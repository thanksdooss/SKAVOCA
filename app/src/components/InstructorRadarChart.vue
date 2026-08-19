<template>
  <div class="instructor-analytics-grid">
    <!-- Left: Radar Chart & Overview -->
    <div class="chart-card">
      <div class="card-header">
        <h3>📊 9개 교재별 교육생 평균 숙련도 분석</h3>
        <span class="cohort-badge">SKALA 4기 (35명 수강)</span>
      </div>

      <!-- SVG Radar Chart -->
      <div class="radar-container">
        <svg viewBox="0 0 400 400" class="radar-svg">
          <!-- Background Grid Polygons -->
          <polygon
            v-for="level in [0.2, 0.4, 0.6, 0.8, 1.0]"
            :key="level"
            :points="getPolygonPoints(level)"
            class="radar-grid"
          />

          <!-- Axis Lines -->
          <line
            v-for="(course, i) in courses"
            :key="i"
            :x1="center"
            :y1="center"
            :x2="getPoint(i, 1.0).x"
            :y2="getPoint(i, 1.0).y"
            class="radar-axis"
          />

          <!-- Data Area Polygon -->
          <polygon :points="dataPoints" class="radar-data-area" />
          <polyline :points="dataPointsClosed" class="radar-data-line" />

          <!-- Axis Labels -->
          <text
            v-for="(course, i) in courses"
            :key="'label-' + i"
            :x="getLabelPoint(i).x"
            :y="getLabelPoint(i).y"
            class="radar-label"
            text-anchor="middle"
          >
            {{ course.shortName }} ({{ course.score }}%)
          </text>
        </svg>
      </div>

      <div class="chart-legend">
        <span class="legend-item"><span class="dot high"></span> 숙련도 양호 (75%+)</span>
        <span class="legend-item"><span class="dot medium"></span> 보통 (50~75%)</span>
        <span class="legend-item"><span class="dot low"></span> 보강 필요 (50% 미만)</span>
      </div>
    </div>

    <!-- Right: Top Difficult Words & Recommendations -->
    <div class="table-card">
      <div class="card-header">
        <h3>🚨 집중 취약 어휘 TOP 10 (보강 추천)</h3>
        <button class="export-btn" @click="exportReport">📥 리포트 다운로드</button>
      </div>

      <div class="difficult-table-wrapper">
        <table class="difficult-table">
          <thead>
            <tr>
              <th>순위</th>
              <th>용어명</th>
              <th>교재 과목</th>
              <th>평균 EF</th>
              <th>오답률</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(item, idx) in difficultWords" :key="item.term">
              <td class="rank-td">{{ idx + 1 }}</td>
              <td class="term-td">
                <strong>{{ item.term }}</strong>
                <span class="pronounce">{{ item.pronunciationKr }}</span>
              </td>
              <td>{{ item.courseName }}</td>
              <td><span class="ef-badge">{{ item.ef.toFixed(2) }}</span></td>
              <td><span class="fail-badge">{{ item.failRate }}%</span></td>
            </tr>
          </tbody>
        </table>
      </div>

      <!-- Instructor AI Advisory Tip -->
      <div class="instructor-tip">
        <div class="tip-title">💡 교수자 맞춤 보강 가이드 (AI 분석)</div>
        <p class="tip-text">
          현재 4기 교육생들은 <strong>8주차 MSA/쿠버네티스 인프라 명령어(`kubectl`)</strong>와 <strong>7주차 Spring DTO 계층 분리 개념</strong>에서 가장 심각한 인지 부하를 겪고 있습니다. 차주 수업 시작 전 <strong>10분 미니 보강</strong>을 진행할 것을 강력히 권장합니다.
        </p>
      </div>
    </div>
  </div>
</template>

<script setup>
import { computed } from "vue";
import { useLearningStore } from "../stores/useLearningStore.js";
import { CURRICULUM_COURSES } from "../data/curriculumData.js";

const store = useLearningStore();

const center = 200;
const radius = 130;

const courses = computed(() => {
  return CURRICULUM_COURSES.map(course => {
    const courseWords = store.words.filter(w => w.courseId === course.id);
    let totalEf = 0;
    let count = 0;
    courseWords.forEach(w => {
      const prog = store.progressMap[w.wordId];
      if (prog) {
        totalEf += prog.easinessFactor;
        count++;
      }
    });
    const avgEf = count > 0 ? (totalEf / count) : 1.3;
    let score = Math.round(((avgEf - 1.3) / 1.2) * 100);
    score = Math.max(0, Math.min(100, score));
    if (count === 0) score = 0;

    const shortName = course.name.split(" ")[0] + " " + course.name.split(" ")[1];
    return { shortName, score };
  });
});

const difficultWords = computed(() => {
  const allReviewed = store.words
    .map(w => {
      const prog = store.progressMap[w.wordId];
      return {
        ...w,
        ef: prog ? prog.easinessFactor : 2.5,
        totalLapses: prog ? prog.totalLapses : 0
      };
    })
    .filter(w => store.progressMap[w.wordId]);

  allReviewed.sort((a, b) => a.ef - b.ef);

  return allReviewed.slice(0, 10).map(w => {
    const course = CURRICULUM_COURSES.find(c => c.id === w.courseId);
    let failRate = 100 - ((w.ef - 1.3) / 1.2 * 100);
    failRate = Math.max(0, Math.min(100, failRate)).toFixed(1);

    return {
      term: w.term,
      pronunciationKr: w.pronunciationKr,
      courseName: course ? course.name : "Unknown",
      ef: w.ef,
      failRate: failRate
    };
  });
});

function getPoint(index, ratio) {
  const angle = (Math.PI * 2 / courses.value.length) * index - Math.PI / 2;
  return {
    x: center + radius * ratio * Math.cos(angle),
    y: center + radius * ratio * Math.sin(angle)
  };
}

function getLabelPoint(index) {
  const angle = (Math.PI * 2 / courses.value.length) * index - Math.PI / 2;
  const labelRadius = radius + 24;
  return {
    x: center + labelRadius * Math.cos(angle),
    y: center + labelRadius * Math.sin(angle) + 4
  };
}

function getPolygonPoints(level) {
  return courses.value
    .map((_, i) => {
      const pt = getPoint(i, level);
      return `${pt.x},${pt.y}`;
    })
    .join(" ");
}

const dataPoints = computed(() => {
  return courses.value
    .map((c, i) => {
      const pt = getPoint(i, c.score / 100);
      return `${pt.x},${pt.y}`;
    })
    .join(" ");
});

const dataPointsClosed = computed(() => {
  if (!courses.value.length) return "";
  const first = getPoint(0, courses.value[0].score / 100);
  return `${dataPoints.value} ${first.x},${first.y}`;
});

function exportReport() {
  alert("SKALA 4기 IT 어휘 취약점 분석 리포트(PDF/CSV)가 생성되었습니다.");
}
</script>

<style scoped>
.instructor-analytics-grid {
  display: grid;
  grid-template-columns: 1fr 1.2fr;
  gap: 1.5rem;
}

.chart-card, .table-card {
  background: #1e293b;
  border: 1px solid rgba(255, 255, 255, 0.1);
  border-radius: 18px;
  padding: 1.5rem;
  display: flex;
  flex-direction: column;
  gap: 1.25rem;
}

.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.card-header h3 {
  font-size: 1.05rem;
  font-weight: 800;
  color: #f8fafc;
  margin: 0;
}

.cohort-badge {
  font-size: 0.75rem;
  background: rgba(37, 99, 235, 0.2);
  border: 1px solid rgba(37, 99, 235, 0.4);
  color: #60a5fa;
  padding: 0.2rem 0.5rem;
  border-radius: 6px;
  font-weight: 700;
}

.export-btn {
  background: rgba(255, 255, 255, 0.08);
  border: 1px solid rgba(255, 255, 255, 0.15);
  color: #e2e8f0;
  font-size: 0.8rem;
  font-weight: 600;
  padding: 0.35rem 0.75rem;
  border-radius: 8px;
  cursor: pointer;
}

.radar-container {
  display: flex;
  justify-content: center;
  align-items: center;
}

.radar-svg {
  width: 100%;
  max-width: 360px;
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
  fill: rgba(56, 189, 248, 0.25);
  stroke: none;
}

.radar-data-line {
  fill: none;
  stroke: #38bdf8;
  stroke-width: 2.5;
}

.radar-label {
  fill: #94a3b8;
  font-size: 10px;
  font-weight: 700;
}

.chart-legend {
  display: flex;
  justify-content: center;
  gap: 1rem;
  font-size: 0.75rem;
  color: #94a3b8;
}

.legend-item {
  display: flex;
  align-items: center;
  gap: 0.3rem;
}

.dot {
  width: 8px;
  height: 8px;
  border-radius: 50%;
}

.dot.high { background: #10b981; }
.dot.medium { background: #f59e0b; }
.dot.low { background: #ef4444; }

.difficult-table-wrapper {
  overflow-x: auto;
}

.difficult-table {
  width: 100%;
  border-collapse: collapse;
  font-size: 0.85rem;
}

.difficult-table th {
  text-align: left;
  padding: 0.6rem 0.5rem;
  color: #64748b;
  border-bottom: 1px solid rgba(255, 255, 255, 0.08);
  font-weight: 700;
}

.difficult-table td {
  padding: 0.6rem 0.5rem;
  border-bottom: 1px solid rgba(255, 255, 255, 0.04);
  color: #cbd5e1;
}

.rank-td {
  font-weight: 800;
  color: #f59e0b;
}

.term-td {
  display: flex;
  flex-direction: column;
}

.term-td strong {
  color: #f8fafc;
}

.pronounce {
  font-size: 0.72rem;
  color: #94a3b8;
}

.ef-badge {
  background: rgba(239, 68, 68, 0.15);
  color: #f87171;
  padding: 0.15rem 0.4rem;
  border-radius: 4px;
  font-weight: 700;
}

.fail-badge {
  color: #ef4444;
  font-weight: 800;
}

.instructor-tip {
  background: rgba(245, 158, 11, 0.08);
  border: 1px solid rgba(245, 158, 11, 0.25);
  border-radius: 12px;
  padding: 1rem;
  display: flex;
  flex-direction: column;
  gap: 0.4rem;
}

.tip-title {
  color: #f59e0b;
  font-size: 0.88rem;
  font-weight: 800;
}

.tip-text {
  font-size: 0.85rem;
  color: #cbd5e1;
  line-height: 1.5;
  margin: 0;
}

@media (max-width: 900px) {
  .instructor-analytics-grid {
    grid-template-columns: 1fr;
  }
}
</style>
