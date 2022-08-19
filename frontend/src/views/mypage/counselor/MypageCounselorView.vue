<template>
  <div class="mypage">
    <info-comp id="info"></info-comp>
    <my-review-comp id="myreview"></my-review-comp>
    <!-- <my-group-comp id="mygroup"></my-group-comp> -->
    <today-counseling-comp id="todaycounseling"></today-counseling-comp>
  </div>
</template>
<script>
import infoComp from './components/infoComp.vue'
import myReviewComp from './components/myReviewComp.vue'
// import myGroupComp from '@/views/mypage/user/components/myGroupComp.vue'
import todayCounselingComp from './components/todayCounselingComp.vue'
export default {
  components: {
    infoComp,
    myReviewComp,
    // myGroupComp,
    todayCounselingComp
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
div{
  background-color: #F9F7F7;
  min-height: 30vh;
}
</style>