<template>
  <div id="UserSchedule">
    <br>
    <h1>1:1 상담</h1>
    <schedule-card-personal></schedule-card-personal>
    <hr>
    <h1>그룹 상담</h1>
    <schedule-card-group></schedule-card-group>
  </div>
</template>

<script>

import ScheduleCardGroup from './components/ScheduleCardGroup.vue'
import ScheduleCardPersonal from './components/ScheduleCardPersonal.vue'

export default {
  components: { ScheduleCardPersonal, ScheduleCardGroup },
    name:'UserScheduleView',
    Components: { ScheduleCardPersonal },

}
</script>

<style>

</style>
