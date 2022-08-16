<template>
  <div>
    <div class="personal-today-cards">
    <div v-for="(re,idx) in request"
      :key="idx"
      :re="re">
      <!-- {{re}} -->
    <div v-if="re.counselorId== currentUser.data.userId && re.status==`ACCEPTED`  && re.groupId == null && today==`${re.year}-${re.month}-${re.day}`" class="card mb-3" id="today-personal-card" >
      <router-link :to="{ name: 'CounselingRequestDocument', params : {counselingId : re.id}}">
      <div class="row g-0" >
        <div class="col-md-4" style="text-decoration: none">
          <div class="personal-request-index" style="text-decoration: none"> {{idx}}</div>
          <p>유저 번호: {{re.userId}}</p>
          
          <p>상담사:{{re.counselorNickName}}</p>
        
          <p>상담일 : {{re.year}}/{{re.month}}/{{re.day}}</p>
        </div>
      </div>
      </router-link>
    </div>
    </div>


      </div>
    </div>

</template>

<script>
import { mapGetters,mapActions } from 'vuex'
  export default {
    name : 'PersonalcardComp',
    data () {
      return {
       today : this.$route.params.today
    }
    },
    props:{
      request: Array,
      day: Object
    },
     computed:{
    ...mapGetters(['requests','currentUser']),
  },
  methods: {
    ...mapActions(['fetchRequests', 'fetchCurrentUser']),
  },
  created() {
    this.fetchCurrentUser()
    this.fetchRequests()
    console.log(this.today)
}
    
  }

</script>

<style>


.personal-today-cards{
  max-width:90%;
  margin:auto;
  text-decoration: none;
}

a:link{
  text-decoration: none;
}



.personal-request-index{
  background-color: bisque;
   color:bisque;
   
}


</style>