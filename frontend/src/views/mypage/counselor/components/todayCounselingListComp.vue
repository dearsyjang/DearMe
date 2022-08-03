<template>
  <div class="MygroupList d-flex ">
    <div class="d-flex justify-content-center">
      <p class="mx-4">상담사 1</p>
    </div>
    <div class="d-flex align-items-center">
      <p>10:00 ~ 11:00</p>
    </div>
    <div class="d-flex align-items-center">
      <button class="mx-5 btn btn-primary btn-sm">상담방</button>
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

  .MygroupList {
      background-color: #F0F5F9;
      border-radius: 20px 40px 60px 80px / 80px 60px 40px 20px;
      text-align: center;
      width: 98%;
      display: inline-block;
    }
    .content1 {
      width: 30%;
    }
    p {
      text-align: left;
      color: #1E2022;
    }
</style>