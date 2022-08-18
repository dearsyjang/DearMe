<template>
<div class="blog-wrapper direction-rtl">
    <div class="container">
        <div v-for="(re, idx) in request" :key="idx" :re="re" class="col-6 col-sm-4 col-md-3">
          <div class="card position-relative shadow-sm">
            <div class="card-body ">
              <!-- <router-link :to="{ name: 'counseling', params: { counselingId: counseling.id, counselorId:counseling.counselorId}}"> -->
              <div class="d-flex align-items-center">
                <div>
                  <span class="badge bg-danger rounded-pill mb-2 d-inline-block"> {{ idx }}</span>
                  <h3 class="blog-title d-block text-dark board-title">user : {{re.userId}}</h3>
                  <h4>상담일 : {{re.year}}/{{re.month}}/{{re.day}}</h4>
                </div>
                <div >
                  <button class="w-btn w-btn-charge" >상담방 입장</button>
                </div>
              </div>
              <!-- </router-link> -->
            </div>
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