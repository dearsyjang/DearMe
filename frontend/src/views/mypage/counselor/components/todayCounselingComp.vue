<template>
  <div>
    오늘의 상담
    <today-counseling-list-comp></today-counseling-list-comp>
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
