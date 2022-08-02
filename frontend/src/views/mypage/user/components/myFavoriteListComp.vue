<template>
  <div class="Favorite">
    <div>
      <p class="mx-4">상담사 1</p>
    </div>
    <div>
      <p> 상담 받은 횟수 : 1회</p>
    </div>
    <div>
      <button class="mx-5 btn btn-primary btn-sm">상세 페이지</button>
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
  .Favorite {
    width: 98%;
    background-color: #F0F5F9;
    border-radius: 20px 40px 60px 80px / 80px 60px 40px 20px;
  }
</style>
