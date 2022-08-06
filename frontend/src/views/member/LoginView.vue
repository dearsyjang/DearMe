<template>
  <div class="container py-4">
    <div>
      <h1>LOGIN</h1>
    </div>
    <div id="login-form" class="form-group">
      <input id="id-input" class="form-control" type="text" v-model="credentials.id" placeholder="아이디">
      <input id="pw-input" class="form-control" type="text" v-model="credentials.password" placeholder="비밀번호">
    </div>
    <div class="form-group mt-4">
      <button id="login-button" class="btn btn-lg">Login</button>
    </div>
    <div class="mt-4">
      <router-link to="/member/findId">아이디 찾기</router-link> |
      <router-link to="/member/findPassword">비밀번호 찾기</router-link>
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
        password: '',
      }
    }
  },
  computed: {
    ...mapGetters(['authError'])
  },
  methods: {
    ...mapActions({ login:'login' }),
  },
  created() {},
  mounted() {},
  unmounted() {},
}
</script>

<style scoped>
#id-input {
  width: 100%;
  height: auto;
  margin-top: 30px;
  margin-bottom: 20px;
}
#pw-input {
  width: 100%;
  height: auto;
}
#login-button {
  width: 100%;
  background-color: #E8E8E8;
  color: #495464;
}
</style>
