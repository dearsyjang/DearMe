import CounselingGroupView from '@/views/counseling-group/CounselingGroupView.vue'

export default[
    {
        path: '/counseling/group',
        name: 'counselinggroup',
        component: CounselingGroupView
      },
      {
        path: '/counseling/group/:groupId',
        name: 'counselinggroup',
        component: CounselingGroupView
      },
]