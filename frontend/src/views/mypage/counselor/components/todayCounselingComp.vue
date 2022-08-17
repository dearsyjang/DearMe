<template>
<div class="container">
    <span class="board-text-bold form-label board-text-title" id="toc-toggle">오늘의 상담 <i class="bi bi-caret-down-fill"></i></span>
    <span class="badge mypage-badge rounded-pill mx-1"></span>
    <today-counseling-list-comp :requests="requests.data" id="toc-content" ></today-counseling-list-comp>
  </div>
</template>
<script>
import { mapGetters,mapActions } from 'vuex'
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
  mounted() {},
  unmounted() {},
  computed:{
    ...mapGetters(['requests','currentUser']),
  },
  methods: {
    ...mapActions(['fetchRequests', 'fetchCurrentUser']),
  },
  created() {
    this.fetchCurrentUser()
    this.fetchRequests()
}
}
</script>
<style >

</style>
