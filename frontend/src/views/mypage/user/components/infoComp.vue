<template>
  <div class="Info">
    <div class="d-flex justify-content-around">
      <div class="mx-4" id="label">
        <p for="nickname">닉네임</p>
        <p for="point">잔여 포인트</p>
      </div>
      <div id="content">
        <P>사용자</P>
        <p>500 pt</p>
      </div>
      <div class="mx-5" id="btn">
        <button class="btn btn-primary btn-sm align-self-end">충전하기</button>
      </div>
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
