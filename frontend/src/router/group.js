import GroupRequestView from "@/views/group/GroupRequestView.vue";
import GroupDetailView from "@/views/group/GroupDetailView.vue";
export default [
  {
    // /{group_id} 추가 해야함
    path: "/group/request",
    name: "groupRequest",
    component: GroupRequestView,
  },
  {
    path: "/group/detail",
    name: "groupDetail",
    component: GroupDetailView,
  },
];
