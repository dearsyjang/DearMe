import MypageUserView from "@/views/mypage/user/MypageUserView.vue";
import MypageCounselorView from "@/views/mypage/counselor/MypageCounselorView.vue";
export default [
  {
    path: "/mypage/user",
    name: "mypageUser",
    component: MypageUserView,
  },
  {
    path: "/mypage/counselor",
    name: "mypageCounselor",
    component: MypageCounselorView,
  },
];
