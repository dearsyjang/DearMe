import GroupRequestView from "@/views/group/GroupRequestView.vue";
import GroupDetailView from "@/views/group/GroupDetailView.vue";
import GroupAcceptview from "@/views/group/GroupAcceptview.vue";
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
  {
    path: "/group/accept",
    name: "groupAccept",
    component: GroupAcceptview,
  },
];
