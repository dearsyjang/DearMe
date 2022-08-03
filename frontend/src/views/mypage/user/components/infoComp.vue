<template>
  <div class="Info">
    <div class="d-flex justify-content-around">
      <div class="mx-4" id="label">
        <p for="nickname">{{ $store.myinfo}}</p>
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
      nickname: '',
      myPoint: '',
      isCounselor: false
    }
  },
  setup() {},
  created() {},
  mounted() {},
  unmounted() {},
  methods: {
  },
  computed: {
  }
}
</script>
<style scoped>
  p {
    text-align: left;
  }
  .Info {
    background-color: #F0F5F9;
    border-radius: 20px 40px 60px 80px / 80px 60px 40px 20px;
    text-align: center;
    width: 98%;
  }
</style>
