<template>
  <div id="UserSchedule">
    <h1 id="userschedule-title">상담 일정</h1>
    <hr>
    <br>
      <!--counselings는 1대1, groupcounselings는 그룹-->
      {{ counselings }}
      <h2 id="userschedule-group">1:1 상담</h2>
      <div v-for = "(counseling, idx) in counselings.data.counselings" :key="idx" :counseling="counseling">
          <div class="card" style="width: 18rem; height: 8rem;">
          <div class="card-body">
            <h5 class="card-title">상담일: {{ counseling.year }}. {{ counseling.month }}. {{ counseling.day }}</h5> <!--year, month, day-->
            <h5 class="card-title">상담사: {{ counseling.counselorNickName }}</h5> <!--상담사 id로 상담사 이름-->
            <router-link to="counseling"><button  class="btn" id="enter-button">상담방 입장</button></router-link>
        </div>
      </div>
      <div v-for = "(groupcounseling, idx) in counselings.data.groupCounselings" :key="idx" :groupcounseling="groupcounseling">
          <div class="card" style="width: 18rem; height: 8rem;">
            <div class="card-body">
              <h5 class="card-title">상담일: {{ groupcounseling.year }}. {{ groupcounseling.month }}. {{ groupcounseling.day }}</h5> <!--year, month, day-->
              <h5 class="card-title">상담사: {{ groupcounseling.counselorNickName }}</h5> <!--상담사 id로 상담사 이름-->
              <router-link to="counseling"><button  class="btn" id="enter-button">상담방 입장</button></router-link>
          </div>
      </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'


export default {
    name:'UserScheduleView',
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
