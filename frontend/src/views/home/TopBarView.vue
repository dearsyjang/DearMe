<template>
  <div >
    <!--상단바-->
    <div class="header-demo-bg shadow-sm">
      <div id="topbar" class="container">
        <!-- Header Content -->
        <div
          class="header-content header-style-five position-relative d-flex align-items-center justify-content-between">
          <!-- Logo Wrapper -->
          <div class="logo-wrapper">
            <a href="page-home.html">
              <img id="logoimg" src="../../assets/images/logo.png" alt="logo">
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
    aria-labelledby="affanOffcanvsLabel">
      <button class="btn-close btn-close-black text-reset" type="button" data-bs-dismiss="offcanvas"
        aria-label="Close"></button>

      <div class="offcanvas-body p-0">
        <div class="sidenav-wrapper">
          <!-- Sidenav Nav -->
          <ul class="sidenav-nav ps-0">
            <br>
            <li><router-link to="/calendar" class="mx-3" style="text-decoration:none"><i class="bi bi-calendar-heart"></i>감정 달력</router-link></li>
            <li><router-link to="/member/Profile" class="mx-3" style="text-decoration:none"><i class="bi bi-eyeglasses"></i>회원정보수정</router-link></li>
            <li><router-link to="/board" class="mx-3" style="text-decoration:none"><i class="bi bi-clipboard"></i>상담 게시판</router-link></li>
            <li><router-link to="/counselor" class="mx-3" style="text-decoration:none"><i class="bi bi-people"></i>상담사 조회</router-link></li>
            <li><router-link to="/mypage" class="mx-3" style="text-decoration:none"><i class="bi bi-house"></i>마이 페이지</router-link></li>
            <li><router-link to="/mypage" class="mx-3" style="text-decoration:none"><i class="bi bi-cash-coin"></i>포인트 충전</router-link></li>
            <li><router-link to="/member/Profile" class="mx-3" style="text-decoration:none"><i class="bi bi-eyeglasses"></i>회원정보수정</router-link></li>
            <hr>
            <li>
              <!-- <div class="night-mode-nav">
                <i class="bi bi-moon"></i> Night Mode
                <div class="form-check form-switch">
                  <input class="form-check-input form-check-success" id="darkSwitch" type="checkbox">
                </div>
              </div> -->
            </li>
            <li>
              <a @click="logOUT()"><i class="bi bi-box-arrow-right" fill="#red"></i> Logout</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
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
</style>