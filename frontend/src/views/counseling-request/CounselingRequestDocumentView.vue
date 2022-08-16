<template>
  <div>
    
      <div v-for="(request,idx) in requests.data"
                :key="idx"
                :request="request">
           
           <div v-for="(re,idx) in request"
            :key="idx"
            :re="re">
            
          <div v-if="re.counselorId== currentUser.data.userId && re.status==`UNACCEPTED`  && re.id ==counselingId" class="card mb-3" style="max-width: 540px;">
            <div class="row g-0">
              <div class="col-md-4">
        
                상담번호: {{re.id}}
                <br>
                유저 번호: {{re.userId}}
                <br>
                내용~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                <!-- {{re.contetns}}  백에 요청-->
                <br>
                상담사:{{re.counselorNickName}}
                <br>
                상담일 : {{re.year}}/{{re.month}}/{{re.day}}
              </div>
              <div class="col-md-8">
                <div class="card-body">
                  <h5 class="card-title"> </h5>
                  <p class="card-text"><small class="text-muted">
                  </small></p>
                     <div id="requset-accept-btn">
                        <button  @click="onSubmit">수락하기</button>

                        <router-link to="/counseling-request/list">
                        <button>거절하기</button>
                        </router-link>
                        </div>

                </div>
              </div>
            </div>
          </div>
          </div>
      </div>
      
  </div>
</template>
<script>
import { mapGetters,mapActions } from 'vuex'
export default {
  name : 'CounselingRequestDocument', 
  components: {},
  data () {
    return {
    counselingId: this.$route.params.counselingId,
    id: '',
    status:'',
    change:{
      id: '',
      status: ''
    }
    
  }},
  
  computed:{
    ...mapGetters(['requests','currentUser']),
  },
  methods: {
    ...mapActions(['fetchRequests', 'fetchCurrentUser' ,'updateRequest']),
  onSubmit() {
    let status2 = 'ACCEPTED'
    let id2 = this.counselingId
    this.change={
      id: id2,
      status: status2
    }
    this.updateRequest(this.change)
    console.log(this.change.id)
    console.log(this.change.status)
  }
  },

  created() {
    
    this.fetchCurrentUser()
    this.fetchRequests()
   

}
}
</script>


<style >
#requset-accept-btn{
  float: right
}
</style>