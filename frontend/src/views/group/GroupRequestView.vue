<template>
  <div class="groupDetail">
    <header>상담 신청서</header>
    <div id="RequestInfo" class="d-flex justify-content-around">
      <div>
        <div>신청자 : </div>
        <div>나이 : </div>
        <div>성별 : </div>
      </div>
      <div>
        <div>상담날짜 : </div>
        <div>상담시간 : </div>
      </div>
    </div>
    <div>
      <textarea rows=10 cols=40 placeholder="상담 내용을 입력하시오."></textarea>
    </div>
    <div>
      <button>수락</button>
      <button>거절</button>
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
  .groupDetail {
    background-color: #F0F5F9;

  }
</style>
