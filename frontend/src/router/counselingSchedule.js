
import counselorScheduleView from '@/views/counselingSchedule/CounselorScheduleView.vue'
import TodayScheduleView from '@/views/counselingSchedule/TodayScheduleView.vue'
import UserSchedule from '@/views/counseling-schedule/UserScheduleView.vue'
import counselorGroupSchedule from '@/views/counseling-schedule/CounselorGroupScheduleView.vue'

import counselorScheduleView from '@/views/counselingSchedule/CounselorScheduleView.vue'
import TodayScheduleView from '@/views/counselingSchedule/TodayScheduleView.vue'
export default [

  {
    path: '/counseling-schedule/counselor-schedule',
    name: 'counselorSchedule',
    component: counselorScheduleView
  },
  {
    path: '/counseling-schedule/:today',
    name: 'todaySchedule',
    component: TodayScheduleView
  },
  {
    path: '/counseling-schedule/:today',
    name: 'todaySchedule',
    component: TodayScheduleView
  },
  {
    path: '/counseling-schedule/userschedule',
    name: 'userSchedule',
    component: UserSchedule
    },
    {
      path: '/counseling-schedule/counselorschedule',
      name: 'counselorGroupSchedule',
      component: counselorGroupSchedule
    },     
]