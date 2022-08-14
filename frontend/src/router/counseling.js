import CounselingView from '@/views/counseling/CounselingView.vue'
import CounselingReViewComp from '@/views/counseling/components/counselingreviewComp'
export default [
    {
      path: '/counseling/:counselingId',
      name: 'counseling',
      component: CounselingView
    },
      {
        path: '/counseling/review/:counselorId',
        name: 'counselingReview',
        component: CounselingReViewComp
      },
      {
        path: '/counseling/review/:counselorId',
        name: 'counselingReview',
        component: CounselingReViewComp
      },
  ]