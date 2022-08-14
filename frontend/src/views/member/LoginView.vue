<template>
  <div class="login-wrapper d-flex align-items-center justify-content-center">
    <div class="custom-container">
      <div class="text-center px-4">
        <img class="login-intro-img" src="@/assets/images/logo.png">
      </div>
      <div class="register-form mt-4">
        <h6 class="mb-3 text-center">Dear Me는 로그인 후 이용가능합니다.</h6>
          <div class="form-group">
            <input class="form-control" type="text" v-model="credentials.id" placeholder="아이디">
          </div>
          <div class="form-group position-relative">
            <input class="form-control" type="text" v-model="credentials.pw" placeholder="비밀번호">
          </div>
          <button @click="LogIn()" class="btn btn-primary w-100" >LOGIN</button>
      </div>

      <div class="login-meta-data text-center">
        <a class="stretched-link forgot-password d-block mt-3 mb-1" href="http://localhost:8081/member/findId">Forgot Password?</a>
        <p class="mb-0">계정이 없으신가요? <a class="stretched-link" href="http://localhost:8081/member/signuptype">Register Now</a></p>
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
    // this.login()
  },
  mounted() {},
  unmounted() {},
}
</script>

<style>

</style>