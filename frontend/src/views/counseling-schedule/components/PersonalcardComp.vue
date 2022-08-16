<template>
  <div>
    
    <div v-for="(re,idx) in request"
      :key="idx"
      :re="re">
      <!-- {{re}} -->
    <div v-if="re.counselorId== currentUser.data.userId && re.status==`ACCEPTED`  && re.groupId == null && today==`${re.year}-${re.month}-${re.day}`" class="card mb-3" style="max-width: 540px;">
      <div class="row g-0">
        <div class="col-md-4">
      
          상담번호: {{re.id}}
          <br>
          유저 번호: {{re.userId}}
          <br>
          상담사:{{re.counselorNickName}}
          <br>
          상담일 : {{re.year}}/{{re.month}}/{{re.day}}
        </div>
        <div class="col-md-8">
          <div class="card-body">
            <h5 class="card-title"> </h5>
            <!-- <p class="card-text">{{request}}</p> -->
            <p class="card-text"><small class="text-muted">
                <router-link :to="{ name: 'CounselingRequestDocument', params : {counselingId : re.id}}">
                <button>신청서 보기</button>
                </router-link>
                <router-link :to="{ name: 'counseling', params : {counselingId : re.id}}">
                <button>상담방 개설</button>
                </router-link>
            </small></p>
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

</style>