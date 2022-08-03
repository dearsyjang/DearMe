<template>
  <div>
    <p>오늘의 상담 ▼</p>
    <today-counseling-list-comp class="d-flex justify-content-around"></today-counseling-list-comp>
  </div>
</template>
<script>
import todayCounselingListComp from '@/views/mypage/counselor/components/todayCounselingListComp.vue'
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
<style scoped>
  p {
      text-align: left;
      color: #1E2022;
    }
</style>
