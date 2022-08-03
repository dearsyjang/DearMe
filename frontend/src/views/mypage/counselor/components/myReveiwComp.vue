<template>
  <div>
    <p>최근 리뷰 모음 ▼</p>
    <my-reveiw-list-comp class="d-flex justify-content-around"></my-reveiw-list-comp>
  </div>
</template>
<script>
import myReveiwListComp from '@/views/mypage/counselor/components/myReveiwListComp.vue'
export default {
  components: {
    myReveiwListComp
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
