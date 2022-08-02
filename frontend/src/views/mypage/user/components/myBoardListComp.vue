<template>
  <div class="BoardList d-flex">
    <div id="content1">
      <p class="mx-4">힘들어요</p>
    </div>
    <div id="content2">
      <p>2022.08.02</p>
    </div>
    <div id="content3">
      <button class="mx-5 btn btn-primary btn-sm">게시글</button>
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
  .BoardList {
    background-color: #F0F5F9;
    border-radius: 20px 40px 60px 80px / 80px 60px 40px 20px;

  }
  .content1 {
    width: 30%;
    text-align: center;
  }
</style>