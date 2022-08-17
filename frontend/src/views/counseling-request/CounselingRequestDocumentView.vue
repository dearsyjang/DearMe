<template>
<div>
  <div class="page-content-wrapper py-3 board-bg">
    <div class="shop-pagination pb-3">
      <div class="container">
        <div class="card">
          <div class="card-body p-2">
            <div class="d-flex align-items-center justify-content-between">
              <small class="ms-1 board-text-index ">수락 대기 중인 상담</small>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="top-products-area product-list-wrap">
      <div class="container">
        <div v-for="(request,idx) in requests.data" :key="idx" :request="request"  >
          <div v-for="(re,idx) in request" :key="idx" :re="re">
          <div v-if="re.counselorId== currentUser.data.userId && re.status==`UNACCEPTED`  && re.id ==counselingId" class="card mb-3" style="max-width: 540px;">
          <div class="card mb-2">
            <div class="card-body d-flex align-items-center">
              <div class="user-info">
                  <h2>1 : 1 상담</h2>
                  <div>
                    <h3>상담사:{{re.counselorNickName}}</h3>
                    <h4>
                      상담일 : {{re.year}}/{{re.month}}/{{re.day}}
                    </h4>
                  </div>
                </div>
                <div v-if="re.status==`UNACCEPTED`">
                  <router-link :to="{ name: 'counseling', params : {counselingId : re.id}}">
                  <button id="open-room">상담방 개설</button>
                  </router-link>
                </div>
                <div v-else>
                  <div id="requset-accept-btn">
                    {{re}}
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
       <div>
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
  float: right;
  margin-bottom: 10px;
}
#open-room{
  float: right;
  margin-bottom: 10px;
}
</style>