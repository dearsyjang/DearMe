import CounselorListView from '@/views/counselor/CounselorListView.vue'
import CounselorDetailView from '@/views/counselor/CounselorDetailView.vue'
import FileFormComp from '@/views/counselor/components/FileFormComp'
import CounselingRequestView from '@/views/counseling-request/CounselingRequestView.vue'
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
      {
        path: '/counselors/attachFile',
        name: 'attachfile',
        component: FileFormComp
      },
      {
        path: '/counseling-request/request',
        name: 'request',
        component: CounselingRequestView
      },
    
  ]