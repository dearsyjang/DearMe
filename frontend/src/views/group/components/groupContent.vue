<template>
  <div>
    <div>
      <p id="detailTitle">[그룹 상담방 공지사항]</p>
    </div>
    <div id="groupContent">
      <!-- .를 기준으로 줄을 나눠야할지 고민 -->
      <div>
        저희 상담방은 매주 월요일 7시에 시작합니다.
        <br />많이 힘들죠 저도 힘들어요 <br />예예예예예옝 <br />설레는
        전화벨소리 그대인가요 <br />헬로우 헬로우
      </div>
    </div>
    <!-- isCounselor 여부로 신청버튼 유무 결정 -->
    <router-link to="/group/request"><button>신청</button></router-link>
  </div>
</template>
<script>
export default {
  components: {},
  data() {
    return {};
  },
  setup() {},
  created() {},
  mounted() {},
  unmounted() {},
  methods: {},
};
</script>
<style scoped>
p {
  text-align: left;
}
#groupContent {
  background-color: #f0f5f9;
}
#detailTitle {
  font-weight: bold;
}
</style>
