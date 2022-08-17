<template>
<div class="container">
  <span class="board-text-bold form-label board-text-title" id="toc-toggle">오늘의 상담 <i class="bi bi-caret-down-fill"></i></span>
  <span class="badge mypage-badge rounded-pill mx-1"></span>
  <div v-for="(request,idx) in requests.data" :key="idx">
    <div v-for="(re,idx) in request" :key="idx" :re="re">
      <div v-if="re.counselorId== currentUser.data.userId && re.status==`ACCEPTED`
        && re.groupId == null && today==`${re.year}-${re.month}-${re.day}`"
        class="card mb-3" id="today-personal-card" >
        <today-counseling-list-comp :re="re" id="toc-content" ></today-counseling-list-comp>
      </div>
    </div>
  </div>
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
