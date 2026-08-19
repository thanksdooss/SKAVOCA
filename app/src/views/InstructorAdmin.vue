<template>
  <div class="instructor-admin-container">
    <!-- Header -->
    <div class="admin-header">
      <div>
        <h2>👨‍🏫 SKALA 4기 교수자 전용 통계 & 어휘 관리</h2>
        <p class="admin-sub">데이터 기반 맞춤형 보강 강의 설계 및 W3C SSML 발음 기호 튜닝</p>
      </div>
      <div class="admin-profile">
        <span class="inst-tag">교수자: 권기창 강사님</span>
        <button class="add-word-btn" @click="showAddModal = true">+ 신규 단어/SSML 등록</button>
      </div>
    </div>

    <!-- Analytics Section (Radar Chart & Top 10) -->
    <InstructorRadarChart />

    <!-- SSML Audio Lab & Word Dictionary Management -->
    <div class="ssml-lab-card">
      <div class="card-header">
        <h3>🎙️ W3C SSML 실시간 발음 튜닝 연구소 (Google Cloud TTS 테스트)</h3>
        <span class="badge-tag">개발자 실무 발음 강제 주입</span>
      </div>

      <div class="ssml-playground">
        <div class="playground-inputs">
          <div class="input-group">
            <label>용어 원형 (Term)</label>
            <input v-model="testTerm" placeholder="예: kubectl, yaml, nginx" />
          </div>
          <div class="input-group">
            <label>한국어 권장 발음 표기</label>
            <input v-model="testPronounceKr" placeholder="예: 쿠브씨티엘, 야믈" />
          </div>
          <div class="input-group full-width">
            <label>SSML 태그 명세 (&lt;phoneme&gt;)</label>
            <textarea
              v-model="testSsml"
              rows="2"
              placeholder='<speak><phoneme alphabet="x-sampa" ph="kjub-si-ti-El">kubectl</phoneme></speak>'
            ></textarea>
          </div>
        </div>

        <div class="playground-actions">
          <button class="test-sound-btn" @click="testAudioSynthesis">
            🔊 SSML 음성 합성 테스트 (즉시 듣기)
          </button>
          <span class="info-note">✓ 등록 시 AWS S3에 1회 사전 렌더링되어 0.1초 캐시로 서빙됩니다.</span>
        </div>
      </div>
    </div>

    <!-- Word Seeding Management Modal -->
    <div class="modal-backdrop" v-if="showAddModal" @click.self="showAddModal = false">
      <div class="modal-content">
        <h3>✨ 신규 IT 어휘 & 맞춤 예문 등록</h3>
        <form @submit.prevent="addNewWord">
          <div class="form-row">
            <label>소속 교재 과목</label>
            <select v-model="newWordForm.courseId" required>
              <option v-for="c in courses" :key="c.id" :value="c.id">{{ c.name }}</option>
            </select>
          </div>
          <div class="form-row">
            <label>용어 원형</label>
            <input v-model="newWordForm.term" required placeholder="예: WebSocket" />
          </div>
          <div class="form-row">
            <label>한국어 권장 발음</label>
            <input v-model="newWordForm.pronunciationKr" required placeholder="예: 웹소켓" />
          </div>
          <div class="form-row">
            <label>비전공자 맞춤 쉬운 뜻풀이</label>
            <textarea v-model="newWordForm.easyMeaning" required rows="2"></textarea>
          </div>
          <div class="form-row">
            <label>문맥 빈칸 예문 (정답은 &#123;&#123;단어&#125;&#125;로 묶기)</label>
            <input v-model="newWordForm.contextSentence" required placeholder="클라이언트와 서버가 실시간 양방향 통신을 할 때 {{WebSocket}}을 사용한다." />
          </div>

          <div class="modal-actions">
            <button type="button" class="cancel-btn" @click="showAddModal = false">취소</button>
            <button type="submit" class="save-btn">S3 오디오 사전 생성 & 저장 ➔</button>
          </div>
        </form>
      </div>
    </div>

    <!-- Notification Toast -->
    <div class="toast-notification" v-if="toastMessage">
      {{ toastMessage }}
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useLearningStore } from "../stores/useLearningStore.js";
import { CURRICULUM_COURSES } from "../data/curriculumData.js";
import { speakPronunciation } from "../services/ttsService.js";
import { api } from "../services/apiClient.js";
import InstructorRadarChart from "../components/InstructorRadarChart.vue";

const store = useLearningStore();
const courses = CURRICULUM_COURSES;

const testTerm = ref("kubectl");
const testPronounceKr = ref("쿠브씨티엘");
const testSsml = ref('<speak><phoneme alphabet="x-sampa" ph="kjub-k@n-troUl">kubectl</phoneme></speak>');

const showAddModal = ref(false);
const newWordForm = ref({
  courseId: 8,
  term: "",
  pronunciationKr: "",
  easyMeaning: "",
  contextSentence: ""
});

const toastMessage = ref("");
function showToast(msg) {
  toastMessage.value = msg;
  setTimeout(() => {
    toastMessage.value = "";
  }, 3000);
}

function testAudioSynthesis() {
  speakPronunciation(testTerm.value);
}

async function addNewWord() {
  const newId = 1000 + store.words.length + 1;
  const wordObj = {
    wordId: newId,
    courseId: newWordForm.value.courseId,
    term: newWordForm.value.term,
    fullTerm: newWordForm.value.term,
    pronunciationKr: newWordForm.value.pronunciationKr,
    pronunciationSsml: `<speak>${newWordForm.value.term}</speak>`,
    easyMeaning: newWordForm.value.easyMeaning,
    contextSentence: newWordForm.value.contextSentence,
    difficulty: "MEDIUM",
    distractors: []
  };

  // Try API first, fallback to local
  try {
    await api.createWord({
      courseId: newWordForm.value.courseId,
      term: newWordForm.value.term,
      fullTerm: newWordForm.value.term,
      pronunciationKr: newWordForm.value.pronunciationKr,
      easyMeaning: newWordForm.value.easyMeaning,
      contextSentence: newWordForm.value.contextSentence,
    });
    showToast(`✅ '${newWordForm.value.term}' 단어가 서버에 등록되었습니다!`);
  } catch(e) {
    console.warn("API word creation failed, saving locally", e);
    showToast(`'${newWordForm.value.term}' 단어가 로컬에 등록되었습니다.`);
  }

  store.words.push(wordObj);
  store.saveCustomWords();
  showAddModal.value = false;
  
  // reset form
  newWordForm.value = {
    courseId: 8,
    term: "",
    pronunciationKr: "",
    easyMeaning: "",
    contextSentence: ""
  };
}
</script>

<style scoped>
.instructor-admin-container {
  display: flex;
  flex-direction: column;
  gap: 1.75rem;
  padding: 1.5rem 0;
}

.admin-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background: #1e293b;
  border: 1px solid rgba(255, 255, 255, 0.1);
  padding: 1.25rem 1.75rem;
  border-radius: 18px;
}

.admin-header h2 {
  font-size: 1.3rem;
  font-weight: 800;
  color: #f8fafc;
  margin: 0;
}

.admin-sub {
  font-size: 0.85rem;
  color: #94a3b8;
  margin: 0.25rem 0 0;
}

.admin-profile {
  display: flex;
  align-items: center;
  gap: 1rem;
}

.inst-tag {
  font-size: 0.85rem;
  font-weight: 700;
  color: #60a5fa;
  background: rgba(37, 99, 235, 0.15);
  padding: 0.35rem 0.75rem;
  border-radius: 8px;
}

.add-word-btn {
  background: #2563eb;
  color: white;
  border: none;
  font-size: 0.85rem;
  font-weight: 700;
  padding: 0.5rem 1rem;
  border-radius: 10px;
  cursor: pointer;
  box-shadow: 0 4px 12px rgba(37, 99, 235, 0.3);
}

.ssml-lab-card {
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

.badge-tag {
  font-size: 0.75rem;
  background: rgba(56, 189, 248, 0.15);
  color: #38bdf8;
  padding: 0.2rem 0.5rem;
  border-radius: 4px;
  font-weight: 700;
}

.ssml-playground {
  display: flex;
  flex-direction: column;
  gap: 1rem;
}

.playground-inputs {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 1rem;
}

.input-group {
  display: flex;
  flex-direction: column;
  gap: 0.35rem;
}

.input-group.full-width {
  grid-column: span 2;
}

.input-group label {
  font-size: 0.78rem;
  font-weight: 700;
  color: #94a3b8;
}

.input-group input, .input-group textarea, select {
  background: rgba(0, 0, 0, 0.3);
  border: 1px solid rgba(255, 255, 255, 0.12);
  border-radius: 8px;
  padding: 0.55rem 0.75rem;
  color: #f8fafc;
  font-size: 0.88rem;
  outline: none;
  font-family: inherit;
}

.input-group input:focus, .input-group textarea:focus, select:focus {
  border-color: #38bdf8;
}

.playground-actions {
  display: flex;
  align-items: center;
  gap: 1rem;
}

.test-sound-btn {
  background: #0284c7;
  color: white;
  border: none;
  font-size: 0.9rem;
  font-weight: 700;
  padding: 0.65rem 1.25rem;
  border-radius: 10px;
  cursor: pointer;
}

.info-note {
  font-size: 0.8rem;
  color: #10b981;
}

.modal-backdrop {
  position: fixed;
  inset: 0;
  background: rgba(0, 0, 0, 0.7);
  backdrop-filter: blur(6px);
  z-index: 300;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 1rem;
}

.modal-content {
  background: #0f172a;
  border: 1px solid rgba(255, 255, 255, 0.15);
  border-radius: 20px;
  padding: 2rem;
  width: 100%;
  max-width: 520px;
  display: flex;
  flex-direction: column;
  gap: 1.25rem;
}

.modal-content h3 {
  font-size: 1.2rem;
  color: #f8fafc;
  margin: 0;
}

form {
  display: flex;
  flex-direction: column;
  gap: 0.85rem;
}

.form-row {
  display: flex;
  flex-direction: column;
  gap: 0.35rem;
}

.form-row label {
  font-size: 0.8rem;
  font-weight: 700;
  color: #94a3b8;
}

.modal-actions {
  display: flex;
  justify-content: flex-end;
  gap: 0.75rem;
  margin-top: 0.5rem;
}

.cancel-btn {
  background: transparent;
  border: 1px solid rgba(255, 255, 255, 0.1);
  color: #94a3b8;
  padding: 0.6rem 1rem;
  border-radius: 8px;
  cursor: pointer;
}

.save-btn {
  background: #2563eb;
  color: white;
  border: none;
  font-weight: 700;
  padding: 0.6rem 1.25rem;
  border-radius: 8px;
  cursor: pointer;
}

.toast-notification {
  position: fixed;
  bottom: 2rem;
  left: 50%;
  transform: translateX(-50%);
  background: #10b981;
  color: white;
  padding: 0.75rem 1.5rem;
  border-radius: 12px;
  font-weight: 700;
  box-shadow: 0 4px 12px rgba(16, 185, 129, 0.4);
  z-index: 1000;
  animation: slideUp 0.3s ease;
}

@keyframes slideUp {
  from {
    opacity: 0;
    transform: translate(-50%, 20px);
  }
  to {
    opacity: 1;
    transform: translate(-50%, 0);
  }
}
</style>
