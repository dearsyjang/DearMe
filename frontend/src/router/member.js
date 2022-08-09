import LoginView from '@/views/member/LoginView.vue'
import LogoutView from '@/views/member/LogoutView.vue'
import SignupUserView from '@/views/member/SignupUserView.vue'
import SignupCounselorView from '@/views/member/SignupCounselorView.vue'
import FindIdView from '@/views/member/FindIdView.vue'
import FindPasswordView from '@/views/member/FindPasswordView.vue'
import MyProfileView from '@/views/member/MyProfileView.vue'
import PasswordChangeView from '@/views/member/PasswordChangeView.vue'
export default [
  {
    path: '/member/login',
    name: 'login',
    component: LoginView
  },
  {
    path: '/member/logout',
    name: 'logout',
    component: LogoutView
  },
  {
    path: '/member/signupuser',
    name: 'signupuser',
    component: SignupUserView
  },
  {
    path: '/member/signupcounselor',
    name: 'signupcounselor',
    component: SignupCounselorView
  },
  // component 에러 발생해서 다른 컴포넌트로 일단 작성함
  {
    path: '/member/findId',
    name: 'FindIdView',
    component: FindIdView
  },
  {
    path: '/member/findPassword',
    name: 'FindPasswordView',
    component: FindPasswordView
  },
  {
    path: '/member/profile/:id',
    name: 'myprofile',
    component: MyProfileView
  },

  {
    path: '/passwordchange',  
    name: 'passwordchange',
    component: PasswordChangeView,
  },

]
