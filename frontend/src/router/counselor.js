import CounselorListView from '@/views/counselor/CounselorListView.vue'
import CounselorDetailView from '@/views/counselor/CounselorDetailView.vue'

export default [
    {
        path: '/counselor_list',
        name: 'counselorList',
        component: CounselorListView
      },
      {
        path: '/counselors/counselor/:counselorId',
        name: 'counselor',
        component: CounselorDetailView
      },
    
  ]