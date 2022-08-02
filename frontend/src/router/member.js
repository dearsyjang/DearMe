import { createRouter, createWebHistory }  from 'vue-router'
// import Vue from 'vue'
import LoginView from '@/views/member/LoginView.vue'
import LogoutView from '@/views/member/LogoutView.vue'
import SignupUserView from '@/views/member/SignupUserView.vue'
import SignupCounselorView from '@/views/member/SignupCounselorView.vue'

// // Vue.use(VueRouter)

const routes = [
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
]
const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

// export default router