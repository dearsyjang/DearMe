<template>
  <div class="Info container">
    <div class="form-group">
      <label class="form-label" for="nickname">닉네임</label>
      <p class="form-control">사용자</p>
    </div>
    <div class="form-group">
      <label class="form-label" for="myPoint">잔여포인트</label>
      <p class="form-control">500 pt</p>
      <button class="btn btn-primary">충전하기</button>
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
  methods: {}
}
</script>
<style scoped>
  div {
    background-color: #F0F5F9;
  }
  p {
    text-align: left;
  }
</style>
