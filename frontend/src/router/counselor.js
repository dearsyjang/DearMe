import CounselorListView from '@/views/counselor/CounselorListView.vue'
import CounselorDetailView from '@/views/counselor/CounselorDetailView.vue'
import FileFormComp from '@/views/counselor/components/FileFormComp.vue'




export default [
    {
        path: '/counselors/counselorList',
        name: 'counselorList',
        component: CounselorListView
      },

      {
        path: '/counselors/attachFile',
        name: 'attachfile',
        component: FileFormComp
      },
         {
        path: '/counselors/:counselorId',
        name: 'counselorProfile',
        component: CounselorDetailView
      },


  ]