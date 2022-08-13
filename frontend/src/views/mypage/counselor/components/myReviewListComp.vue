<template>
<div class="container BoardList">
  <div class="form-group row">
    <p class="col-sm-4">5점</p>
    <p class="col-sm-4">2022.08.05</p>
    <button class="col-sm-4 btn btn-primary">리뷰보기</button>
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

  }
  p, button {
    width: 160px;
    display: table-cell;
  }
</style>