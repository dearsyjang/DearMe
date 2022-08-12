<template>
  <div>
     <h2>날짜 파라미터로 받아온 해당 날의 상담
        파라미터로 받아오는게 아니고 모든 요청을 받아와서 해결해야하나???
     </h2>
     {{requests}}
    <!-- <div
      v-for="(counselor,idx) in counselors.data"
      :key="idx"
      :counselor="counselor">
    </div> -->
     

  </div>
</template>
<script>
import { mapActions,mapGetters} from 'vuex'
export default  {
    name : 'timeSelectComp',
  
 
    // data() {
    //   return {
    //     selectDay: this.$route.params.counselingDay,
       
  
    //   }
    // },
    computed : {
      ...mapGetters(['requests']),

    },

    methods: {
      ...mapActions(['fetchRequests',]),
    
    
    },
    created() {
      this.fetchRequests()
     
      },
  }
</script>


<style>


</style>
