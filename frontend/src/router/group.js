import GroupRequestView from '@/views/group/GroupRequestView.vue'
import GroupDetailView from '@/views/group/GroupDetailView.vue'
export default [
  {
    path: '/group/request',
    name: 'groupRequest',
    component: GroupRequestView
  },
  {
    path: '/group/detail',
    name: 'groupDetail',
    component: GroupDetailView
  },
]
