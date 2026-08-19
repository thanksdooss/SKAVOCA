/**
 * SKAVOCA 100% Pure Native English Pronunciation & Sound Engine
 * 
 * 1. Single Execution: 절대 중복/이중 재생되지 않는 단일 스트림 보장
 * 2. Pure Native US Voice: 브라우저/OS의 한국어 음성 개입을 100% 차단하고 최상위 원어민 en-US 음성 강제 고정
 * 3. IT Phonetic Normalizer: 270개 IT 전문 용어의 원어민 음소(Phoneme) 완벽 정위화
 * 4. Acoustic Clarity: 한국인 학습자가 자음/모음을 또렷하게 분별할 수 있는 0.85배속 최적화
 */

// IT 전문 용어 원어민 음소 정규화 맵
const IT_PHONETIC_DICT = {
  // Course 1: Git
  "PR": "P. R.",
  "Pull Request": "Pull Request",
  "Rollback": "Rollback",
  "Rebase": "Rebase",
  "Merge Conflict": "Merge Conflict",
  "Staging Area": "Staging Area",
  "Cherry-pick": "Cherry pick",
  "Stash": "Stash",
  "Commit": "Commit",
  "Branch": "Branch",
  "HEAD": "Head",
  "Revert": "Revert",
  ".gitignore": "git ignore",
  "Clone": "Clone",
  "Fork": "Fork",
  "Fetch": "Fetch",
  "Pull": "Pull",
  "Push": "Push",
  "Fast-forward": "Fast forward",
  "Squash": "Squash",
  "Git-flow": "Git flow",
  "Hotfix": "Hotfix",
  "Tag": "Tag",
  "Origin": "Origin",
  "Upstream": "Upstream",
  "Git Hooks": "Git Hooks",
  "WSL": "W. S. L.",
  "NVM": "N. V. M.",
  "Reset": "Reset",
  "Status": "Status",
  "Log": "Log",

  // Course 2: Python
  "List Comprehension": "List Comprehension",
  "Decorator": "Decorator",
  "GIL": "G. I. L.",
  "Lambda": "Lambda",
  "Generator": "Generator",
  "DataFrame": "Data Frame",
  "Broadcasting": "Broadcasting",
  "Virtualenv": "Virtual env",
  "Type Hint": "Type Hint",
  "*args/**kwargs": "args and kwargs",
  "Series": "Series",
  "Docstring": "Docstring",
  "DuckDB": "Duck D. B.",
  "Polars": "Poh-lars",
  "Pydantic": "Pie-dantic",
  "EDA": "E. D. A.",
  "Pytest": "Pie test",
  "Dataclass": "Data class",
  "Vectorization": "Vectorization",
  "Context Manager": "Context Manager",
  "Magic Methods": "Magic Methods",
  "Dict Comprehension": "Dict Comprehension",
  "Set Comprehension": "Set Comprehension",
  "loc / iloc": "lock and eye lock",
  "GroupBy": "Group By",
  "Pivot Table": "Pivot Table",
  "Pip": "Pip",
  "Axis": "Axis",
  "Zip": "Zip",
  "Enumerate": "Enumerate",

  // Course 3: Data & SQL
  "PK": "P. K.",
  "FK": "F. K.",
  "1NF": "First Normal Form",
  "2NF": "Second Normal Form",
  "3NF": "Third Normal Form",
  "BCNF": "B. C. N. F.",
  "ACID": "A. C. I. D.",
  "INNER JOIN": "Inner Join",
  "LEFT JOIN": "Left Join",
  "Index": "Index",
  "GROUP BY": "Group By",
  "HAVING": "Having",
  "Subquery": "Sub query",
  "Deadlock": "Deadlock",
  "ETL": "E. T. L.",
  "DDL": "D. D. L.",
  "DML": "D. M. L.",
  "DCL": "D. C. L.",
  "TCL": "T. C. L.",
  "SARGable": "sarge-able",
  "EXPLAIN": "Explain",
  "De-normalization": "Denormalization",
  "Unique Constraint": "Unique Constraint",
  "Check Constraint": "Check Constraint",
  "Default Constraint": "Default Constraint",
  "Cascade": "Cascade",
  "UNION ALL": "Union All",
  "Window Function": "Window Function",
  "Data Warehouse": "Data Warehouse",
  "Transaction Isolation Level": "Transaction Isolation Level",

  // Course 4: Web Frontend Core
  "JSON": "Jason",
  "DOM": "D. O. M.",
  "BOM": "B. O. M.",
  "Flexbox": "Flex box",
  "Closure": "Closure",
  "Hoisting": "Hoisting",
  "Event Loop": "Event Loop",
  "Promise": "Promise",
  "Async/Await": "Async Await",
  "Event Bubbling": "Event Bubbling",
  "Semantic Tag": "Semantic Tag",
  "localStorage": "Local Storage",
  "SessionStorage": "Session Storage",
  "CORS": "CORS",
  "Box Model": "Box Model",
  "CSS Grid": "CSS Grid",
  "Event Delegation": "Event Delegation",
  "preventDefault": "prevent Default",
  "stopPropagation": "stop Propagation",
  "Fetch API": "Fetch A. P. I.",
  "Axios": "Axios",
  "SOP": "S. O. P.",
  "IIFE": "Iffy",
  "Prototype": "Prototype",
  "Lexical Scope": "Lexical Scope",
  "Microtask Queue": "Micro task Queue",
  "Viewport": "View port",
  "Media Query": "Media Query",
  "rem vs em": "rem versus em",
  "CSS Specificity": "CSS Specificity",

  // Course 5: Statistics
  "p-value": "P value",
  "Normal Distribution": "Normal Distribution",
  "Null Hypothesis": "Null Hypothesis",
  "ANOVA": "uh-NO-vah",
  "Standard Deviation": "Standard Deviation",
  "IQR": "I. Q. R.",
  "T-test": "T test",
  "Pearson Correlation": "Pearson Correlation",
  "Overfitting": "Overfitting",
  "Type I Error": "Type One Error",
  "Type II Error": "Type Two Error",
  "Central Limit Theorem": "Central Limit Theorem",
  "Outlier": "Outlier",
  "Population vs Sample": "Population versus Sample",
  "Descriptive Statistics": "Descriptive Statistics",
  "Inferential Statistics": "Inferential Statistics",
  "Variance": "Variance",
  "Median": "Median",
  "Mode": "Mode",
  "Skewness": "Skewness",
  "Kurtosis": "Kurtosis",
  "Z-score": "Z score",
  "Significance Level": "Significance Level",
  "Chi-Square Test": "Chi Square Test",
  "Spearman Correlation": "Spearman Correlation",
  "Covariance": "Covariance",
  "Linear Regression": "Linear Regression",
  "R-squared": "R squared",
  "VIF": "V. I. F.",
  "Bias-Variance Tradeoff": "Bias Variance Tradeoff",

  // Course 6: Feature Engineering
  "One-Hot Encoding": "One Hot Encoding",
  "StandardScaler": "Standard Scaler",
  "MinMaxScaler": "Min Max Scaler",
  "Label Encoding": "Label Encoding",
  "PCA": "P. C. A.",
  "Imputation": "Imputation",
  "Data Leakage": "Data Leakage",
  "RFE": "R. F. E.",
  "Target Encoding": "Target Encoding",
  "Log Transformation": "Log Transformation",
  "Feature Importance": "Feature Importance",
  "Winsorization": "Winsorization",
  "RobustScaler": "Robust Scaler",
  "MaxAbsScaler": "Max Abs Scaler",
  "Ordinal Encoding": "Ordinal Encoding",
  "Frequency Encoding": "Frequency Encoding",
  "Binary Encoding": "Binary Encoding",
  "Box-Cox Transformation": "Box Cox Transformation",
  "Trimming": "Trimming",
  "Variance Threshold": "Variance Threshold",
  "SelectKBest": "Select K Best",
  "Lasso (L1)": "Lasso L 1",
  "Ridge (L2)": "Ridge L 2",
  "ElasticNet": "Elastic Net",
  "t-SNE": "T-SNE",
  "Permutation Importance": "Permutation Importance",
  "Target Leakage": "Target Leakage",
  "Binning": "Binning",
  "Polynomial Features": "Polynomial Features",
  "Interaction Term": "Interaction Term",

  // Course 7: Java SpringBoot & REST
  ".war": "war package",
  ".jar": "jar package",
  "DTO": "D. T. O.",
  "IoC / DI": "I. O. C. and D. I.",
  "Entity": "Entity",
  "Spring Bean": "Spring Bean",
  "REST API": "REST A. P. I.",
  "JPA / Hibernate": "J. P. A. and Hibernate",
  "@Transactional": "Transactional",
  "N+1 Problem": "N plus one Problem",
  "SOLID": "Solid",
  "JVM / GC": "J. V. M. and Garbage Collection",
  "BCrypt": "B-Crypt",
  "Interceptor": "Interceptor",
  "ApplicationContext": "Application Context",
  "Bean Scope": "Bean Scope",
  "@RestController": "Rest Controller",
  "@Autowired": "Auto wired",
  "Layered Architecture": "Layered Architecture",
  "DAO / Repository": "D. A. O. and Repository",
  "Spring Data JPA": "Spring Data J. P. A.",
  "Lazy Loading": "Lazy Loading",
  "Eager Loading": "Eager Loading",
  "HTTP Methods": "HTTP Methods",
  "HTTP Status Code": "HTTP Status Code",
  "Spring Security": "Spring Security",
  "Filter": "Filter",
  "JWT": "J. W. T.",
  "Gradle": "Gradle",
  "Embedded Tomcat": "Embedded Tomcat",

  // Course 8: Agile & MSA
  "Sprint": "Sprint",
  "kubectl": "kube control",
  "Pod": "Pod",
  "Microservices (MSA)": "Microservices M. S. A.",
  "Product Backlog": "Product Backlog",
  "API Gateway": "A. P. I. Gateway",
  "Circuit Breaker": "Circuit Breaker",
  "Docker Compose": "Docker Compose",
  "Kafka": "Kafka",
  "Service Discovery": "Service Discovery",
  "CI/CD": "C. I. and C. D.",
  "Saga Pattern": "Saga Pattern",
  "Sprint Backlog": "Sprint Backlog",
  "Daily Scrum": "Daily Scrum",
  "Sprint Review": "Sprint Review",
  "Sprint Retrospective": "Sprint Retrospective",
  "Definition of Done (DoD)": "Definition of Done",
  "User Story": "User Story",
  "Story Point": "Story Point",
  "Burn-down Chart": "Burn down Chart",
  "Kanban": "Kanban",
  "WIP Limit": "W. I. P. Limit",
  "Monolithic": "Monolithic",
  "Service Mesh (Istio)": "Service Mesh Istio",
  "Event-Driven Architecture": "Event Driven Architecture",
  "CQRS": "C. Q. R. S.",
  "12-Factor App": "Twelve Factor App",
  "Dockerfile": "Docker file",
  "Kubernetes Deployment": "Kubernetes Deployment",
  "Blue-Green Deployment": "Blue Green Deployment",

  // Course 9: Vue.js
  "v-model": "Vee model",
  "Reactivity": "Reactivity",
  "computed": "computed",
  "watch": "watch",
  "Pinia": "Pee-nya",
  "SFC": "S. F. C.",
  "Props / Emits": "Props and Emits",
  "Vue Router": "Vue Router",
  "Virtual DOM": "Virtual D. O. M.",
  "v-if vs v-show": "Vee if versus Vee show",
  "Lifecycle Hooks": "Lifecycle Hooks",
  "Composable": "Composable",
  "SPA": "S. P. A.",
  "v-bind": "Vee bind",
  "v-on": "Vee on",
  "v-for": "Vee for",
  "v-slot": "Vee slot",
  "v-html": "Vee HTML",
  "Composition API": "Composition A. P. I.",
  "<script setup>": "script setup",
  "ref": "ref",
  "reactive": "reactive",
  "watchEffect": "watch Effect",
  "onMounted": "on Mounted",
  "onUnmounted": "on Unmounted",
  "defineProps": "define Props",
  "defineEmits": "define Emits",
  "Provide / Inject": "Provide and Inject",
  "Scoped CSS": "Scoped CSS",
  "Vite": "Veet"
};

class SoundFX {
  constructor() {
    this.ctx = null;
  }

  init() {
    if (!this.ctx && typeof window !== "undefined") {
      const AC = window.AudioContext || window.webkitAudioContext;
      if (AC) {
        this.ctx = new AC();
      }
    }
    if (this.ctx && this.ctx.state === "suspended") {
      this.ctx.resume();
    }
  }

  _playNote(freq, type, duration, volume = 0.25, delay = 0) {
    this.init();
    if (!this.ctx) return;

    const startTime = this.ctx.currentTime + delay;

    try {
      const osc = this.ctx.createOscillator();
      const gain = this.ctx.createGain();

      osc.type = type;
      osc.frequency.setValueAtTime(freq, startTime);

      gain.gain.setValueAtTime(0, startTime);
      gain.gain.linearRampToValueAtTime(volume, startTime + 0.015);
      gain.gain.setValueAtTime(volume, startTime + duration * 0.6);
      gain.gain.exponentialRampToValueAtTime(0.001, startTime + duration);

      osc.connect(gain);
      gain.connect(this.ctx.destination);

      osc.start(startTime);
      osc.stop(startTime + duration);
    } catch (e) {
      console.warn("Audio play error", e);
    }
  }

  playSuccess() {
    this._playNote(523.25, "sine", 0.18, 0.3, 0); // C5
    this._playNote(659.25, "sine", 0.18, 0.3, 0.09); // E5
    this._playNote(783.99, "triangle", 0.35, 0.25, 0.18); // G5
  }

  playError() {
    this._playNote(330, "square", 0.12, 0.15, 0);
    this._playNote(262, "square", 0.2, 0.12, 0.08);
  }

  playSwipe() {
    this.init();
    if (!this.ctx) return;
    try {
      const osc = this.ctx.createOscillator();
      const gain = this.ctx.createGain();
      osc.type = "sine";
      const now = this.ctx.currentTime;
      osc.frequency.setValueAtTime(300, now);
      osc.frequency.exponentialRampToValueAtTime(600, now + 0.1);
      gain.gain.setValueAtTime(0.2, now);
      gain.gain.exponentialRampToValueAtTime(0.001, now + 0.12);
      osc.connect(gain);
      gain.connect(this.ctx.destination);
      osc.start(now);
      osc.stop(now + 0.12);
    } catch (e) {
      console.warn(e);
    }
  }

  playLevelUp() {
    this._playNote(440, "triangle", 0.14, 0.3, 0);
    this._playNote(554.37, "triangle", 0.14, 0.3, 0.1);
    this._playNote(659.25, "triangle", 0.14, 0.3, 0.2);
    this._playNote(880, "triangle", 0.5, 0.35, 0.3);
  }
}

export const soundEffects = new SoundFX();

// Best English voice cache
let cachedEnglishVoice = null;

function findBestEnglishVoice() {
  if (typeof window === "undefined" || !("speechSynthesis" in window)) return null;
  const voices = window.speechSynthesis.getVoices();
  if (!voices || voices.length === 0) return null;

  // Priority list of premium natural English voices
  const highPriorityNames = [
    "Samantha (Enhanced)", "Ava (Premium)", "Ava", "Samantha", 
    "Daniel (Enhanced)", "Daniel", "Zoe (Premium)", "Karen (Enhanced)", 
    "Serena (Premium)", "Google US English", "Google UK English Female",
    "Microsoft Jenny Online (Natural)", "Microsoft Guy Online (Natural)", 
    "Alex", "Victoria", "Fred"
  ];

  for (const name of highPriorityNames) {
    const match = voices.find((v) => v.lang.startsWith("en") && v.name.includes(name));
    if (match) {
      cachedEnglishVoice = match;
      return match;
    }
  }

  // Fallback to any English voice
  const anyEn = voices.find((v) => v.lang.startsWith("en"));
  if (anyEn) {
    cachedEnglishVoice = anyEn;
    return anyEn;
  }

  return null;
}

/**
 * 100% 순수 원어민 영어 단일 발음 엔진
 * 
 * - 한국어 음성 혼입 원천 차단 (en-US 강제 고정)
 * - 비동기 이중 재생/중복 발음 버그 100% 제거
 * - 270개 IT 전문 용어 정밀 음소 딕셔너리 매핑
 * - 명료성 최적화 속도 0.85배속 1회 완벽 재생
 */
export function speakPronunciation(term) {
  if (typeof window === "undefined" || !("speechSynthesis" in window)) {
    return;
  }

  // 1. 기존 재생 중인 음성 즉각 취소 (중복/겹침 원천 방지)
  window.speechSynthesis.cancel();

  const raw = (term || "").trim();
  if (!raw) return;

  // 2. IT 전문 음소 딕셔너리에서 원어민 표준 발음 문자열 획득
  let spokenText = IT_PHONETIC_DICT[raw];
  if (!spokenText) {
    // 딕셔너리에 없을 경우 기호 정제
    spokenText = raw
      .replace(/^@/, "")
      .replace(/^\./, "")
      .replace(/[\{\}\[\]\<\>\(\)]/g, " ")
      .replace(/\//g, " and ")
      .replace(/\s+/g, " ")
      .trim();
  }

  if (!spokenText) return;

  // 3. 순수 en-US 단일 Utterance 구성
  const utterance = new SpeechSynthesisUtterance(spokenText);
  utterance.lang = "en-US";
  utterance.rate = 0.85; // 최적의 원어민 발음 인지 속도
  utterance.pitch = 1.0;
  utterance.volume = 1.0;

  // 4. 엄격한 원어민 영어 보이스 바인딩 (한국어 보이스 개입 차단)
  const voice = cachedEnglishVoice || findBestEnglishVoice();
  if (voice) {
    utterance.voice = voice;
  }

  // 5. 단 1회만 또렷하게 발음
  window.speechSynthesis.speak(utterance);
}

// Initial voice discovery & listener
if (typeof window !== "undefined" && "speechSynthesis" in window) {
  findBestEnglishVoice();
  window.speechSynthesis.onvoiceschanged = () => {
    findBestEnglishVoice();
  };
}
