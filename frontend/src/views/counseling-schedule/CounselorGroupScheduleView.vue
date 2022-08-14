<template>
  <div>
    <div>
      <h1 id="userschedule-title">상담 일정</h1>
      <hr>
      <br>
      <h2 id="userschedule-group">1:1 상담</h2>
      {{ counselings.data.groupCounselings }}
      <div v-for="(counseling, idx) in counselings.data.groupCounselings" :key="idx" :counseling="counseling">
        <div class="card" style="width: 18rem; height: 8rem;">
          <h5 class="card-title">{{ counseling.groupId }}</h5>
          <router-link :to="{ name: 'counselinggroup', params: { groupId: counseling.groupId }}"><button  class="btn" id="enter-button">상담방 입장</button></router-link>
        </div>
      </div> 
      <h2 id="userschedule-group">그룹 상담</h2>
      <div v-for="(counseling, idx) in counselings.data.counselings" :key="idx" :counseling="counseling">
        <div v-if="counseling.groupId != null" class="card" style="width: 18rem; height: 8rem;">
          <h5 class="card-title">상담일: {{ counseling.year }}. {{ counseling.month }}. {{ counseling.day }}</h5>
          <h5 class="card-title">상담사: {{ counseling.counselorNickName }}</h5>
          <!-- <router-link :to="{ name: 'counselinggroup', params: { groupId: counselings.data.groupCounselings.groupId }}"><button  class="btn" id="enter-button">상담방 입장</button></router-link> -->
      </div> 
    </div>
  </div>
  </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'


export default {
    name:'CounselorGro',
    data() {
      return {
        groupId: this.$route.params.groupId,
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
