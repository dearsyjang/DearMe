import userSchedule from '@/views/counselingSchedule/UserScheduleView.vue'
import counselorSchedule from '@/views/counselingSchedule/CounselorScheduleView.vue'

export default [
  {
    path: '/counseling-schedule/user-schedule',
    name: 'userSchedule',
    component: userSchedule
    },
  {
    path: '/counseling-schedule/counselor-schedule',
    name: 'counselorSchedule',
    component: counselorSchedule
  },
     
]