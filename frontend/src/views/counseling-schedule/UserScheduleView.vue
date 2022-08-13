<template>
  <div id="UserSchedule">
    <h1 id="userschedule-title">상담 일정</h1>
    <hr>
    <br>
    <div>
      <h2 id="userschedule-personal">1:1 상담</h2>
      <schedule-card-personal></schedule-card-personal>
    </div>
    <br>
    <hr>
    <br>
    <div>
      <h2 id="userschedule-group">그룹 상담</h2>
      <schedule-card-group></schedule-card-group>
    </div>
  </div>
</template>

<script>
import ScheduleCardGroup from './components/ScheduleCardGroup.vue'
import ScheduleCardPersonal from './components/ScheduleCardPersonal.vue'
import { mapActions, mapGetters } from 'vuex'


export default {
  components: { ScheduleCardPersonal, ScheduleCardGroup },
    name:'UserScheduleView',
    Components: { ScheduleCardGroup },
    computed: {
      ...mapGetters(['counselings'])
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
