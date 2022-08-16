import counselorScheduleView from '@/views/counseling-schedule/CounselorScheduleView.vue'
import TodayScheduleView from '@/views/counseling-schedule/TodayScheduleView.vue'
import UserSchedule from '@/views/counseling-schedule/UserScheduleView.vue'


export default [
  // 상담사 상담 일정 달력
  {
    path: '/counseling-schedule/counselor-schedule',
    name: 'counselorSchedule',
    component: counselorScheduleView
  },
  // 상담사 상담 하루 일정
  {
    path: '/counseling-schedule/:today',
    name: 'todaySchedule',
    component: TodayScheduleView
  },
  // 취업준비생 상담 일정(전체) => 취업준비생만 조회 가능
  {
    path: '/counseling-schedule/userschedule',
    name: 'userSchedule',
    component: UserSchedule
    },
]