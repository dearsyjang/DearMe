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


import counselingRequest from './counselingRequest.js'

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
  ]
})

export default router
