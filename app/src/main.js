import { createApp } from "vue";
import { createPinia } from "pinia";
import App from "./App.vue";
import router from "./router/index.js";
import "./style.css";

// 무료 호스팅 서버는 일정 시간 요청이 없으면 휴면 상태가 된다.
// 앱이 열리는 즉시 헬스체크를 보내 서버를 미리 깨워, 로그인 시점의 대기 시간을 줄인다.
const API_BASE_URL = import.meta.env.VITE_API_URL || "http://localhost:8080";
fetch(`${API_BASE_URL}/api/v1/auth/health`, { mode: "cors" }).catch(() => {});

const app = createApp(App);
const pinia = createPinia();

app.use(pinia);
app.use(router);
app.mount("#app");
