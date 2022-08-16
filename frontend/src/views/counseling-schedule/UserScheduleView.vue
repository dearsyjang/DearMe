<template>
  <div>
    <br>
    <div v-if="currentUser.data.type==`USER`">
      
      <h1 id="userschedule-title">상담 일정</h1>
      <hr>
      <br>
      <h2 id="userschedule-personal">1:1 상담</h2>
      <div v-for="(counseling, idx) in counselings.data.counselings" :key="idx" :counseling="counseling">
        <div v-if="counseling.status==`ACCEPTED` && counseling.groupId == null" class="card" style="width: 18rem; height: 10rem;" id="user-personal-card">
          <div class="personal-request-index" style="text-decoration: none">{{idx}}</div>
          <h5 class="personal-card-title">상담일: {{ counseling.year }}. {{ counseling.month }}. {{ counseling.day }}</h5>
          <h5 class="personal-card-title">상담사: {{ counseling.counselorNickName }}</h5>
          <router-link :to="{ name: 'counseling', params: { counselingId: counseling.id }}"><button  class="btn" id="user-enter-button">상담방 입장</button></router-link>
        </div>
      </div> 
      <h2 id="userschedule-group">그룹 상담</h2>
      <div v-for="(counseling, idx) in counselings.data.counselings" :key="idx" :counseling="counseling">
        <div v-if="counseling.status==`ACCEPTED` && counseling.groupId != null" class="card" style="width: 18rem; height: 8rem;" id="user-group-card">
          <h5 class="group-card-title">상담일: {{ counseling.year }}. {{ counseling.month }}. {{ counseling.day }}</h5>
          <h5 class="group-card-title">상담사: {{ counseling.counselorNickName }}</h5>
          <router-link :to="{ name: 'counseling', params: { counselingId: counseling.id }}"><button  class="btn" id="user-enter-button">상담방 입장</button></router-link>
      </div> 
      </div>
      </div>
    </div>

</template>

<script>
import { mapActions, mapGetters } from 'vuex'
// 사용자 스케줄 => /counseling-schedule/userschedule 혹은 하단바


export default {
    name:'UserSchedule',
    data() {
      return {
        counselingId: this.$route.params.counselingId,
      }
    },
    computed: {
      ...mapGetters(['counselings', 'currentUser']),
    },
    methods: {
      ...mapActions(['fetchSchedules', 'fetchCurrentUser'])
    },
    created() {
      this.fetchSchedules()
      this.fetchCurrentUser()
      console.log(this.counseling)
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

#userschedule-title{
  text-align:center;
}
#userschedule-personal, #userschedule-group {
  text-align: center;  
}
#user-personal-card{
  margin:auto;
  margin-bottom:7px;
}

#user-enter-button{
  float: right;
}
.personal-card-title{
  padding:5px;
  text-align:center;
}
</style>
