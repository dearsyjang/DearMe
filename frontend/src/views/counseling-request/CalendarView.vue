<template>
  <div>
    <calendar-comp :acceptUserId="this.userId" ></calendar-comp>

  </div>
</template>

<script>

  import CalendarComp from '@/views/counseling-request/components/CalendarComp.vue'

  export default {
    // props: {
    //   USERID: Object
    // },
    name : 'CalendarView',
    components: {CalendarComp},
    data() {
      return {
        userId: this.$route.params.USERID
      }
    },
    created() {
      alert(this.userId)
    }
  }
</script>
<style>

</style>