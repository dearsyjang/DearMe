<template>
  <div>

    
    <div class="personal-request-cards">
      <div v-for="(re,idx) in request"
        :key="idx"
        :re="re">
      <div v-if="re.counselorId== currentUser.data.userId && re.status==`UNACCEPTED`  && re.groupId == null" class="card mb-3" >
       <router-link :to="{ name: 'CounselingRequestDocument', params : {counselingId : re.id}}">
        <div class="row g-0" id="personal-request-card" >
          <div class="col-md-16" style="text-decoration: none" >
            
            <div class="personal-request-index" style="text-decoration: none">{{idx}}</div>
            <p style="">유저 번호: {{re.userId}}</p>
          
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
    name : 'personalcardComp',
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
}
    
  }

</script>

<style>
a:link {
  text-decoration: none;
  
}

p {
  margin-left:10;
}
.personal-request-cards{
  max-width:90%;
  margin:auto;
  text-decoration: none;
}


.personal-request-watch-btn{
  float: right;
  margin-bottom : 5px
}

.personal-request-index{
  background-color: bisque;
   color:bisque;
}
</style>