import { createRouter, createWebHistory } from 'vue-router'

import home from './home.js'
import member from './member.js'
import mypage from './mypage.js'
import counselor from './counselor.js'
import board from './board.js'
import group from './group.js'
import point from './point.js'
import calendar from './calendar.js'
import textDiary from './textDiary.js'
import counseling from './counseling.js'
import schedule from './schedule.js'
import counselingRequest from './counselingRequest.js'
import videodiary from './videoDiary.js'


import counselingSchedule from './counselingSchedule.js'
const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes: [
    ...home,
    ...member,
    ...mypage,
    ...counselor,
    ...board,
    ...group,
    ...point,
    ...calendar,
    ...textDiary,
    ...counselingRequest,
    ...counseling,
    ...schedule,
    ...videodiary,    

  
    ...counselingSchedule



  ],
  scrollBehavior(to, from, savedPosition) {
    if (savedPosition) {
      return savedPosition
    } else {
      return { top: 0 }
    }
  },

// vue 기본 양식
// const routes = [
//   // {
//   //   path: '/',
//   //   name: 'home',
//   //   component: HomeView
//   // },

})

export default router