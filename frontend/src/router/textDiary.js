import textDiaryCreateView from "@/views/text-diary/textDiaryCreateView.vue";
import textDiaryDetailView from "@/views/text-diary/textDiaryDetailView.vue";
import textDiaryListView from "@/views/text-diary/textDiaryListView.vue";
export default [
  {
    path: "/text-diary/create",
    name: "textDiaryCreate",
    component: textDiaryCreateView,
  },
  {
    path: "/text-diary/:textDiaryId",
    name: "textDiaryDetail",
    component: textDiaryDetailView, 
  },
  {
    path: "/text-diary/textDiaryList",
    name: "textDiaryList",
    component: textDiaryListView,
  }
];