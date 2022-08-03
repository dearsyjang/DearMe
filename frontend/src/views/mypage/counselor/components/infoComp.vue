<template>
  <div class="Info">
    <div class="d-flex justify-content-around">
      <div class="mx-4" id="label">
        <p for="name">정윤해</p>
        <p for="point">잔여 포인트</p>
      </div>
      <div id="content">
        <P>최고의 상담사</P>
        <p>500 pt</p>
      </div>
      <div class="mx-5" id="btn">
        <button class="btn btn-primary btn-sm align-self-end">프로필</button>
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
  .Info {
      background-color: #F0F5F9;
      border-radius: 20px 40px 60px 80px / 80px 60px 40px 20px;
      text-align: center;
      width: 98%;
    }
</style>
