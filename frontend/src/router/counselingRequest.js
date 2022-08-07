import CounselingRequestListView from "@/views/counseling-request/CounselingRequestListView.vue";
import CounselingRequestDocumentView from "@/views/counseling-request/CounselingRequestDocumentView.vue";
import CounselingRequestView from "@/views/counseling-request/CounselingRequestView.vue";
export default [
  {
    path: "/counseling-request/list",
    name: "CounselingRequestList",
    component: CounselingRequestListView,
  },
  {
    path: "/counseling-request/document",
    name: "CounselingRequestDocument",
    component: CounselingRequestDocumentView,
  },
  {
    path: "/counseling-request",
    name: "CounselingRequest",
    component: CounselingRequestView,
  },
];