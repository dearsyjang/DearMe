<template>
  <div>
    <h1> Dear Me </h1>
      <form @submit.prevent="login(credentials)">
        <div>
        <label for="username">아이디 </label> <br>
        <input v-model="credentials.username" type="text" id="username" required />
      </div>

      <div>
        <label for="password">비밀번호 </label> <br>
        <input v-model="credentials.password" type="password" id="password" required />
      </div>
      <br>

      <button>로그인</button> 
      </form>
      <br>
      <button>아이디 찾기</button> &emsp;
      <button>비밀번호 찾기</button>
  </div>
</template>
<script>
import { mapActions } from 'vuex'

export default {
  name: 'LoginView',
  components: {},
  data() {
    return {
      credentials: {
        username: '',
        password: '',
      }
    }
  },
  setup() {},
  created() {},
  mounted() {},
  unmounted() {},
  methods: {
    ...mapActions(['login'])
  },
}
</script>
