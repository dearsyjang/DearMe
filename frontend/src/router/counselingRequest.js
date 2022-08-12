import CounselingRequestListView from "@/views/counseling-request/CounselingRequestListView.vue";
import CounselingRequestDocumentView from "@/views/counseling-request/CounselingRequestDocumentView.vue";
import CounselingRequestView from "@/views/counseling-request/CounselingRequestView.vue";
import TimeselectComp from "@/views/counseling-request/components/timeSelectComp"
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
  {
    path: "/counseling-request/timeSelect",
    name: "CounselingTimeSelect",
    component: TimeselectComp
  },

];