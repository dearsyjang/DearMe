import { createRouter, createWebHistory } from 'vue-router'
// import HomeView from '../views/HomeView.vue'

import member from './member.js'
import mypage from './mypage.js'
import counselor from './counselor.js'
import board from './board.js'
import group from './group.js'
import calendar from './calendar.js'

import counselingRequest from './counselingRequest.js'

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes: [
    ...member,
    ...mypage,
    ...counselor,
    ...board,
    ...group,
    ...calendar,
    ...counselingRequest,
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
