import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import LoginView from '@/views/member/LoginView.vue'
import LogoutView from '@/views/member/LogoutView.vue'
import SignupUserView from '@/views/member/SignupUserView.vue'
import SignupCounselorView from '@/views/member/SignupCounselorView.vue'
import TopBarView from '@/views/home/TopBarView.vue'
import CounselorListView from '@/views/counselor/CounselorListView.vue'
import CounselorDetailView from '@/views/counselor/CounselorDetailView.vue'
import MypageUserView from '@/views/mypage/user/MypageUserView.vue'
import FileFormComp from '@/views/counselor/components/FileFormComp'
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
    path: '/member/signupuser',
    name: 'signupuser',
    component: SignupUserView
  },
  {
    path: '/member/signupcounselor',
    name: 'signupcounselor',
    component: SignupCounselorView
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
  {
    path: '/counselors/attachFile/',
    name: 'attachFile',
    component: FileFormComp
  },
  {
    path: '/mypage',
    name: 'mypage',
    component: MypageUserView
  },


]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
