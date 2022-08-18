<template>
  <div class="container">
    <span class="board-text-bold form-label board-text-title" id="toc-toggle">나의 리뷰 <i class="bi bi-caret-down-fill"></i></span>
    <span class="badge mypage-badge rounded-pill mx-1"></span>
    <my-review-list-comp  id="toc-content" ></my-review-list-comp>
  </div>
</template>
<script>
import myReviewListComp from './myReviewListComp.vue'
export default {
  components: {
    myReviewListComp
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
<style >

</style>
