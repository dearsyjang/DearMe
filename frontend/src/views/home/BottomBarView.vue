<template>
<div>
  <div id="bottombar" class="container">
    <div>
      <router-link to="/calendar" class="img mx-3"><img id="emotion" src="../../assets/images/emotion.png" alt="emotion"></router-link>
      <p class="text">감정달력</p>
    </div>
    <div>
      <router-link to="/mypage/counselor" class="img mx-3"><img id="calendar" src="../../assets/images/calendar.png" alt="calendar"></router-link>
      <p class="text">상담일정</p>
    </div>
    <div>
      <router-link to="/mypage/user" class="img mx-3"><img id="home" src="../../assets/images/home.png" alt="home"></router-link>
      <p class="text">마이페이지</p>
    </div>
    <div>
      <router-link to="/counselor_list" class="img mx-3"><img id="counselor" src="../../assets/images/counselor.png" alt="counselor"></router-link>
    <p class="text">상담사조회</p>
    </div>
    <div>
      <router-link to="/board" class="img mx-3"><img id="board" src="../../assets/images/board.png" alt="board"></router-link>
      <p class="text">상담게시판</p>
    </div>
  </div>
</div>
</template>

<script>
export default {
  name: 'BottomBar',
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

<style scoped>
#bottombar {
    position: fixed;
    bottom: 0px;
    left: 0px;
    border-top: 1px solid black;
    background-color: #FDFDFD;
    display: flex;
    margin: 0;
    padding: 0;
    max-width: 100%;
    overflow-x: hidden;
}

#bottombar > div {
    float: left;
    width: 20%;
    height: 100%;
    text-align: center;
    padding-top: 13px;
    overflow-x: hidden;
}

.img > #emotion {
  width: 30px;
  height: 30px;
  object-fit: cover;
  margin-bottom: 0.4em;
}

.img > #calendar {
  width: 30px;
  height: 30px;
  object-fit: cover;
  margin-bottom: 0.4em;
}

.img > #home {
  width: 30px;
  height: 30px;
  object-fit: cover;
  margin-bottom: 0.4em;
}

.img > #counselor {
  width: 30px;
  height: 30px;
  object-fit: cover;
  margin-bottom: 0.4em;
}

.img > #board{
  width: 30px;
  height: 30px;
  object-fit: cover;
  margin-bottom: 0.4em;
}

.text {
  font-size: 0.8em;
}
</style>