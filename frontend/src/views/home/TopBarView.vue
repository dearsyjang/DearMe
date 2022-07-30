<template>
  <div id="TopBar">
    <nav class="navbar navbar-expand-lg">
      <div class="container-fluid">
        <img id="LogoImage" src="../../assets/images/logo.png" class="m-3 d-inline-block align-center justify-content-center" alt="logo">

        <button class="navbar-toggler mx-3 float-right" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <!-- 라우터 링크 연결하기 -->
        <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
          <div class="navbar-nav">
            <li><router-link to="signup" class="mx-3">회원정보수정</router-link></li>
            <li><router-link to="logout" class="mx-4">로그아웃</router-link></li>
          </div>
        </div>

      </div>
    </nav>
  </div>
</template>

<script>
export default {
  name: 'TopBar',
  components: {},
  data() {
    return {
      sampleData: ''
    }
  },
  setup() {},
  created() {},
  mounted() {},
  unmounted() {},
  methods: {}
}
</script>

<style>
.navbar {
  position: sticky;
  display:flex;
  flex-direction:row;
  background-color: #F9F7F7;
}

.navbar a{
  text-decoration: none;
}
.navbar a:hover{
  color: #3F72AF;
  transition:all.5s;
  border-bottom: 3px solid;
}
.navbar a.router-link-exact-active {
  color: #3F72AF;
  border-bottom: 3px solid;
  width: auto;
}
</style>