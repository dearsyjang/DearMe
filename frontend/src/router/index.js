import { createRouter, createWebHistory } from 'vue-router'
// import HomeView from '../views/HomeView.vue'

import member from './member.js'
import mypage from './mypage.js'
import counselor from './counselor.js'
import group from './group.js'
import point from './point.js'


const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes: [
    ...member,
    ...mypage,
    ...counselor,
    ...group,
    ...point,
  ]

// vue 기본 양식
// const routes = [
//   // {
//   //   path: '/',
//   //   name: 'home',
//   //   component: HomeView
//   // },

})

export default router
