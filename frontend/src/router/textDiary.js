import textDiaryCreateView from "@/views/text-diary/textDiaryCreateView.vue";
import textDiaryDetailView from "@/views/text-diary/textDiaryDetailView.vue";

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
];