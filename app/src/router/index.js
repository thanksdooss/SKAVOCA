import { createRouter, createWebHistory } from "vue-router";
import { useAuthStore } from "../stores/useAuthStore.js";

import MainDashboard from "../views/MainDashboard.vue";
import ProfileSetup from "../views/ProfileSetup.vue";
import CourseCatalog from "../views/CourseCatalog.vue";
import LearnSession from "../views/LearnSession.vue";
import ReviewSession from "../views/ReviewSession.vue";
import MyStatsPage from "../views/MyStatsPage.vue";
import InstructorAdmin from "../views/InstructorAdmin.vue";
import WordDetail from "../views/WordDetail.vue";

const routes = [
  { path: "/", name: "home", component: MainDashboard },
  { path: "/profile", name: "profile", component: ProfileSetup },
  { path: "/catalog", name: "catalog", component: CourseCatalog },
  { path: "/learn", name: "learn", component: LearnSession },
  { path: "/review", name: "review", component: ReviewSession },
  { path: "/stats", name: "stats", component: MyStatsPage },
  { path: "/instructor", name: "instructor", component: InstructorAdmin },
  { path: "/word/:wordId", name: "wordDetail", component: WordDetail, props: true }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

// Guard: redirect to /profile if no profile exists
router.beforeEach((to) => {
  const authStore = useAuthStore();
  if (!authStore.isAuthenticated && to.name !== "profile") {
    return { name: "profile" };
  }
});

export default router;
