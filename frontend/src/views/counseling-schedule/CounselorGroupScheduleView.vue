<template>
  <div>
    <div>
      <h1 id="userschedule-title">상담 일정</h1>
      <hr>
      <br>
      <h2 id="userschedule-group">1:1 상담</h2>
      <div v-for="(counseling, idx) in counselings?.data.groupCounselings" :key="idx" :counseling="counseling">
        <div class="card" style="width: 18rem; height: 8rem;">
          {{ counseling }}
          <h5 class="card-title">{{ counseling.groupId }}</h5>
          <router-link :to="{ name: 'counselinggroup', params: { groupId: counseling.groupId }}"><button  class="btn" id="enter-button">상담방 입장</button></router-link>
        </div>
      </div>
      <h2 id="userschedule-group">그룹 상담</h2>
      <div v-for="(counseling, idx) in counselings?.data.counselings" :key="idx" :counseling="counseling">
        <div v-if="counseling.groupId != null" class="card" style="width: 18rem; height: 8rem;">
          <h5 class="card-title">상담일: {{ counseling.year }}. {{ counseling.month }}. {{ counseling.day }}</h5>
          <h5 class="card-title">상담사: {{ counseling.counselorNickName }}</h5>
      </div>
    </div>
  </div>
  </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'

// 상담사 그룹 스케줄 => /counseling-schedule/counselorschedule
// 템플릿 수정하기...
// 링크 정리하고 버튼 위치 정하기...


export default {
    name:'CounselorGro',
    data() {
      return {
        groupId: '',
      }
    },
    computed: {
      ...mapGetters(['counselings']),
    },
    methods: {
      ...mapActions(['fetchSchedules'])
    },
    created() {
      this.fetchSchedules()
      this.groupId=this.$route.params.groupId
    }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap');
* {
  font-family: 'Gowun Dodum', sans-serif;
}
hr {
  width: 100%;
}
#userschedule-personal, #userschedule-group {
  text-align: left;
}

</style>
