<template>
  <div id="topbar" v-if="isLoggedIn">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
    <!--상단바-->
    <div class="header-demo-bg shadow-sm">
      <div class="container">
        <!-- Header Content -->
        <div
          class="header-content header-style-five position-relative d-flex align-items-center justify-content-between">
          <!-- Logo Wrapper -->
          <div class="logo-wrapper">
            <a href="page-home.html">
              <img id="logoimg" src="@/assets/images/logo.png" alt="logo">
            </a>
          </div>
          <!-- Navbar Toggler -->
          <div class="navbar--toggler" id="affanNavbarToggler6" data-bs-toggle="offcanvas"
            data-bs-target="#affanOffcanvas" aria-controls="affanOffcanvas">
            <span class="d-block"></span>
            <span class="d-block"></span>
            <span class="d-block"></span>
          </div>
        </div>
      </div>
    </div>

    <!--사이드바-->
    <div class="offcanvas offcanvas-start" id="affanOffcanvas" data-bs-scroll="true" tabindex="-1"
    aria-labelledby="affanOffcanvsLabel"  >
      <button class="btn-close btn-close-black text-reset" type="button" data-bs-dismiss="offcanvas"
        aria-label="Close"></button>

      <div class="offcanvas-body p-0" >
        <div class="sidenav-wrapper">
          <!-- Sidenav Nav -->
          <ul class="sidenav-nav ps-0">
            <br>
            <li><a href="/counselors/counselorList" class="mx-3" style="text-decoration:none"><i class="bi bi-people"></i>상담사 조회</a></li>
            <li><a href="/board" class="mx-3" style="text-decoration:none"><i class="bi bi-clipboard"></i>상담 게시판</a></li>
            <li><a href="/point" class="mx-3" style="text-decoration:none"><i class="bi bi-cash-coin"></i>포인트 충전</a></li>
            <li><a href="/member/Profile" class="mx-3" style="text-decoration:none"><i class="bi bi-eyeglasses"></i>회원정보수정</a></li>
            <hr>
            <li>
              <a href="/member/login" @click="logOUT()"><i class="bi bi-box-arrow-right"></i> Logout</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapActions } from 'vuex'

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
    ...mapActions(['logout', 'isLoggedIn']),
    // 로그아웃 버튼 누르면 로그아웃 실행
    logOUT() {
      this.logout()
    }
  },
  computed: {
  },
}
</script>

<style>
.offcanvas-body{
  position: relative;
  z-index: 10;
}
li{
  color: #112D4E;
}
</style>