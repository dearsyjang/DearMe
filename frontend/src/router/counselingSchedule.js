
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
     
]