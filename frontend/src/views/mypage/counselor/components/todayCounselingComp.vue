<template>
<div class="container">
    <span class="board-text-bold form-label board-text-title" id="toc-toggle">오늘의 상담 <i class="bi bi-caret-down-fill"></i></span>
    <span class="badge mypage-badge rounded-pill mx-1"></span>
    <today-counseling-list-comp id="toc-content" ></today-counseling-list-comp>
  </div>
</template>
<script>
import todayCounselingListComp from './todayCounselingListComp.vue'
export default {
  components: {
    todayCounselingListComp
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
