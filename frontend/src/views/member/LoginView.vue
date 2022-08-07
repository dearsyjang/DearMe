<template>
  <div class="container py-4">
    <div>
      <h1>LOGIN</h1>
    </div>
    <div class="form-group mt-4">
      <label class="form-label mt-4 mx-2" for="id">아이디</label>
      <input clss="form-control" type="text" v-model="credentials.id" placeholder="아이디">
    </div>
    <div class="form-group">
      <label class="form-label mt-4 mx-2" for="password">비밀번호</label>
      <input clss="form-control" type="text" v-model="credentials.pw" placeholder="비밀번호">
    </div>
    <div class="form-group mt-4">
      <button @click="LogIn()" class="btn btn-success btn-lg">Login</button>
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
      const id = this.credentials.id
      const pw = this.credentials.pw
      // console.log(id, pw)
      this.login(id, pw)
    }
  },
  created() {
    // this.login()
  },
  mounted() {},
  unmounted() {},
}
</script>