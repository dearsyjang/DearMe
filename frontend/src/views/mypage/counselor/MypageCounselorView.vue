<template>
  <div class="mypage">
    <info-comp id="info"></info-comp>
    <my-review-comp id="myboard"></my-review-comp>
    <my-group-comp id="mygroup"></my-group-comp>
    <today-counseling-comp id="myfavorite"></today-counseling-comp>
  </div>
</template>
<script>
import infoComp from './components/infoComp.vue'
import myReviewComp from './components/myReveiwComp.vue'
import myGroupComp from '@/views/mypage/user/components/myGroupComp.vue'
import todayCounselingComp from './components/todayCounselingComp.vue'
export default {
  components: {
    infoComp,
    myReviewComp,
    myGroupComp,
    todayCounselingComp
  },
  data() {
    return {
      isCounselor: false
    }
  },
  setup() {},
  created() {},
  mounted() {},
  unmounted() {},
  methods: {}
}
</script>
<style>
/* * {
  border: 1px black solid;
} */
</style>