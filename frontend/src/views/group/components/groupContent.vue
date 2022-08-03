<template>
<div>
  <p>공지....</p>
  <div id="groupContent">
    <textarea name="notice" id="notice" cols="30" rows="10">저희 상담방은 매주 월요일 7시에 시작합니다.</textarea>
  </div>
  <!-- isCounselor 여부로 신청버튼 유무 결정 -->
  <button>신청</button>
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
  p {
    text-align: left;
  }
  #groupContent {
    background-color: #F0F5F9;

  }
</style>