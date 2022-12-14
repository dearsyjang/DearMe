import CounselingRequestListView from "@/views/counseling-request/CounselingRequestListView.vue";
import CounselingRequestDocumentView from "@/views/counseling-request/CounselingRequestDocumentView.vue";
import CounselingRequestView from "@/views/counseling-request/CounselingRequestView.vue";
import CounselingTimeComp from "@/views/counseling-request/components/counselingTimeComp.vue";
import counselingAcceptView from "@/views/counseling-request/counselingAcceptView.vue";
import findCalendar from "@/views/counseling-request/CalendarView.vue"
export default [
  {
    path: "/counseling-request/list",
    name: "CounselingRequestList",
    component: CounselingRequestListView,
  },
  {
    path: "/counseling-request/:counselingId",
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
    component: CounselingTimeComp
  },
  {
    path: "/counseling-request/accept",
    name: "counselingAcceptView",
    component: counselingAcceptView
  },
  {
    path: "/counseling-request/accept/diary",
    name: "findCalendar",
    component: findCalendar
  },

];