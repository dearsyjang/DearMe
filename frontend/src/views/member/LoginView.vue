<template>
  <div class="login-wrapper d-flex align-items-center justify-content-center member-login-gb">
    <div class="custom-container">
      <div class="text-center px-4">
        <img class="login-intro-img" src="@/assets/images/logo.png">
      </div>
      <div class="register-form mt-4">
        <h6 class="mb-3 text-center">Dear Me는 로그인 후 이용 가능합니다.</h6>
          <div class="form-group">
            <input class="form-control" type="text" v-model="credentials.id" placeholder="아이디">
          </div>
          <div class="form-group position-relative">
            <input class="form-control" type="password" v-model="credentials.pw" placeholder="비밀번호">
          </div>
          <button @click="LogIn()" class="w-btn-login w-100" type="button">LOGIN</button>
      </div>

      <div class="login-meta-data text-center my-2">
        <a class="stretched-link forgot-password d-block mt-3 mb-1" href="http://localhost:8081/member/findId">Forgot Password?</a>
        <p class="mb-0">계정이 없으신가요?
          <a class="stretched-link" href="http://localhost:8081/member/signuptype">회원가입</a>
        </p>
      </div>
    </div>
  </div>
</template>
<script>
import { mapActions, mapGetters } from 'vuex'
export default {
  components: {},
  data() {
    return {
      credentials: {
        id: '',
        pw: '',
      }
    }
  },
  computed: {
    ...mapGetters(['authError'])
  },
  methods: {
    ...mapActions([ 'login' ]),
    LogIn() {
      let data = {
        id: this.credentials.id,
        pw: this.credentials.pw
      }
      // const id = this.credentials.id
      // const pw = this.credentials.pw
      console.log(data)
      this.login(data)
    }
  },
  created() {
    window.localStorage.clear()
    // this.login()
  },
  mounted() {},
  unmounted() {},
}
</script>

<style scoped>
body {
  background-color: #F9F7F7;
  overflow: hidden;
  height: 100%;
  z-index:-5;
}
.member-login-gb{
  background-color: #F9F7F7;
  height: 100%;
  padding-top: 150px;
  padding-bottom: 100%;
}
.w-btn-login {
    /* position: relative; */
    border: none;
    min-width: 170px;
    min-height: 50px;
    background: linear-gradient(
        90deg,
        #EFCC70 0%,
        #EFCC70 100%
    );
    border-radius: 1000px;
    color: darkslategray;
    cursor: pointer;
    box-shadow: 12px 12px 24px #5a554747;
    font-weight: 700;
    transition: 0.3s;
    color: #1E1E42
}

.w-btn-login:hover {
    transform: scale(1.2);
}
</style>