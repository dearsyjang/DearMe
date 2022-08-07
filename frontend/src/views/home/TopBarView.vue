<template>
  <div id="topbar">
    <nav class="navbar navbar-expand-lg">
      <div class="container-fluid">
        <img id="logoimg" src="../../assets/images/logo.png" class="m-3 d-inline-block" alt="logo">

        <button class="navbar-toggler mx-3 float-right" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <!-- 라우터 링크 연결하기 -->
        <div v-if="this.currentUser" class="collapse navbar-collapse" id="navbarSupportedContent">
          <div class="navbar-nav">
            <li><router-link to="signup" class="mx-3">회원정보수정</router-link></li>
            <button @click="logOUT()">로그아웃</button>
            <!-- <li><router-link to="logout" class="mx-4">로그아웃</router-link></li> -->
          </div>
        </div>
        <div v-else class="collapse navbar-collapse" id="navbarSupportedContent">
          <div class="navbar-nav">
            <li><router-link to="login" class="mx-4">로그인</router-link></li>
          </div>
        </div>

      </div>
    </nav>
  </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'
export default {
  name: 'TopBar',
  components: {},
  data() {
    return {
    }
  },
  setup() {},
  created() {
  },
  mounted() {},
  unmounted() {},
  methods: {
    ...mapActions(['logout']),
    // 로그아웃 버튼 누르면 로그아웃 실행
    logOUT() {
      this.logout()
    }
  },
  computed: {
    // 로그인 여부 확인
    ...mapGetters(['currentUser'])
  }
}
</script>

<style>
#topbar > .navbar {
  position: sticky;
  display:flex;
  flex-direction:row;
  background-color: #FDFDFD;
  border-bottom: 1px solid black;
}

#topbar > .navbar a{
  text-decoration: none;
}

#topbar > .navbar a:hover{
  color: #3F72AF;
  transition:all.3s;
  border-bottom: 3px solid;
}

#topbar > .navbar a.router-link-exact-active {
  color: #3F72AF;
  border-bottom: 3px solid;
  width: auto;
}

#navbarSupportedContent {
  justify-content: end;
}

#img > .logoimg {
  max-width: 100%;
  width: auto;
  height: auto;
  align-content: center;
  justify-content: center;
}
</style>