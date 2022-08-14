<template>
  <div class="Info container">
    <div class="row">
      <label id="con1" class="col-sm-6 col-form-label" for="nickname">정윤해</label>
      <p id="con1" class="form-control col-sm-6">상담사</p>
    </div>
    <div id="point">
      <label class="form-label" for="myPoint">잔여포인트</label>
    </div>
    <div class="row">
      <button id="con2" class="btn btn-primary col-sm-6">내 프로필</button>
    </div>
  </div>
</template>
<script>
export default {
  components: {},
  data() {
    return {
      sampleData: '',
      
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
