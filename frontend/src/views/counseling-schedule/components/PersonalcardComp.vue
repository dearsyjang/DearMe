<template>
<div class="page-content-wrapper">
  <div class="blog-wrapper direction-rtl">
    <div class="container">
      <div class="row g-3">
        <div v-for="(re,idx) in request"
            :key="idx"
            :re="re">
                    <div v-if="re.counselorId== currentUser.data.userId && re.status==`ACCEPTED`  && re.groupId == null " class="card" id="today-personal-card" >
          <div class="card position-relative">
            <div class="card-body">
              <div class="card-body d-flex align-items-center">
                  <div>
                    <span class="badge bg-danger rounded-pill mb-2 d-inline-block"> {{ idx+1 }}</span>
                    <h3 class="blog-title d-block text-dark board-title">상담자 이름: {{re.userNickname}}</h3>
                    <h4>상담시간 : {{re.hours}}시</h4>
                    <div id="card-btn">
                      <router-link :to="{ name: 'counseling', params : {counselingId : re.id}}">
                        <button class="w-btn w-btn-charge" id="open-room">상담방 개설</button>
                      </router-link>
                    </div>
                  </div>
              </div>
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
    name : 'PersonalcardComp',
    data () {
      return {
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
    console.log(this.request)
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

#card-btn{
  float: right;
}

</style>