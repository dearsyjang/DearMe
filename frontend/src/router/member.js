// import LoginView from '@/views/member/LoginView.vue'
// import LogoutView from '@/views/member/LogoutView.vue'
import SignupUserView from "@/views/member/SignupUserView.vue";
import SignupCounselorView from "@/views/member/SignupCounselorView.vue";

export default [
  // {
  //   path: '/member/login',
  //   name: 'login',
  //   component: LoginView
  // },
  // {
  //   path: '/member/logout',
  //   name: 'logout',
  //   component: LogoutView
  // },
  {
    path: "/member/signupuser",
    name: "signupuser",
    component: SignupUserView,
  },
  {
    path: "/member/signupcounselor",
    name: "signupcounselor",
    component: SignupCounselorView,
  },
];
