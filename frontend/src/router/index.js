import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import LoginView from '@/views/member/LoginView.vue'
import LogoutView from '@/views/member/LogoutView.vue'
import SignupView from '@/views/member/SignupView.vue'
import TopBarView from '@/views/home/TopBarView.vue'
import CounselorListView from '@/views/counselor/CounselorListView.vue'
import CounselorDetailView from '@/views/counselor/CounselorDetailView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/member/login',
    name: 'login',
    component: LoginView
  },
  {
    path: '/member/logout',
    name: 'logout',
    component: LogoutView
  },
  {
    path: '/member/signup',
    name: 'signup',
    component: SignupView
  },
  {
    path: '/home/topbar',
    name: 'topbar',
    component: TopBarView
  },
  {
    path: '/counselor_list',
    name: 'counselorList',
    component: CounselorListView
  },
  {
    path: '/counselors/counselor/:counselorId',
    name: 'counselor',
    component: CounselorDetailView
  },

  
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
