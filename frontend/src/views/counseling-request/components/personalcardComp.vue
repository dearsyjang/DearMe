<template>
  <div>

    
    <div class="personal-request-cards">
      <div v-for="(re,idx) in request"
        :key="idx"
        :re="re">
      <div v-if="re.counselorId== currentUser.data.userId && re.status==`UNACCEPTED`  && re.groupId == null" class="card mb-3" style="max-width: 540px;">
       <router-link :to="{ name: 'CounselingRequestDocument', params : {counselingId : re.id}}">
        <div class="row g-0" id="personal-request-card" >
          <div class="col-md-16">
            
            <div class="personal-request-index">{{re.id}}</div>
            <br>
            유저 번호: {{re.userId}}
            <br>
            상담사:{{re.counselorNickName}}
            <br>
            상담 신청일 : {{re.year}}/{{re.month}}/{{re.day}}
          </div>
          <div class="col-md-16">
            <div class="card-body">
              <h5 class="card-title"> </h5>
              <!-- <p class="card-text">{{request}}</p> -->
              <p class="card-text"><small class="text-muted">
              </small></p>
            </div>
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
.personal-request-cards{
  width:40%;

  
}


.personal-request-watch-btn{
  float: right;
  margin-bottom : 5px
}


</style>