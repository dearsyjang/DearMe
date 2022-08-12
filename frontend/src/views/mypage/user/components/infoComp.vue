<template>
  <div class="Info container">
    <div class="row">
      <label id="con1" class="col-sm-6 col-form-label" for="nickname">나는야 고민왕</label>
      <p id="con1" class="form-control col-sm-6">사용자</p>
    </div>
    <div id="point">
      <label class="form-label" for="myPoint">잔여포인트</label>
    </div>
    <div class="row">
      <p id="con2" class="form-control col-sm-6">500 pt</p>
      <button id="con2" class="btn btn-primary col-sm-6">충전하기</button>
    </div>
  </div>
</template>
<script>
export default {
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
  methods: {
    // 회원 정보 수정 매서드 받아와서 패치하고 출력
  }
}
</script>
<style scoped>
  div {
    background-color: #F0F5F9;
  }
  con1 {
    width: 160px;
    display: table-cell;
  }
  con2 {
    width: 160px;
    display: table-cell;
  }

</style>
