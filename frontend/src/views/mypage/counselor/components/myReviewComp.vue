<template>
  <div class="Board">
    <p class="title">최근 리뷰 모음 ▼ </p>
    <my-review-list-comp class="d-flex justify-content-around"></my-review-list-comp>
  </div>
</template>
<script>
import MyReviewListComp from './myReviewListComp.vue'
export default {
  components: {
    MyReviewListComp
  },
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
    color: #1E2022;
  }
</style>
