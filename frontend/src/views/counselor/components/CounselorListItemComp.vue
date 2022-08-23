<template>
  <div>

    <!-- <router-link to="/counselors/counselor/:memberId">
      <div class="card mb-3" style="max-width: 540px;">
        <div class="row g-0">
          <div class="col-md-4">
            <img src="@/assets/사람.png" class="img-fluid rounded-start" style="width:100px;height: 100px;" alt="...">
          </div>
          <div class="col-md-8">
            <div class="card-body">
              <h5 class="card-title">강지명</h5>
              <p class="card-text">최고의 상담사</p>
              <p class="card-text"><small class="text-muted">상담 만족도 4.5 / 5 (1225)</small></p>
            </div>
          </div>
        </div>
      </div>
    </router-link> -->
    <!-- <router-link to="/counselors/counselor/:counselorId"> -->

    <!-- <router-link
    :to="`/counselors/${counselor.counselorId}`"> -->


    <router-link
    :to="{ name: 'counselorProfile', params: {counselorId: counselor.counselorId}}" style="text-decoration:none">

    <div class="card mb-3" id="counselor-item-card">
      <!--왜 카드를 이렇게...-->
      <div id="container">
        <div class="row" id="counselor-item-row">
        <div class="counselor-item-pic col-md-6" >
          <img src = "@/assets/images/kjm.png" class="counselor-img2"/>
        </div>
        <div class="card-body" id="counselor-item-card-body" >
          <h5 class="card-title" id="counselor-item-card-title">{{counselor.nickName}} 상담사</h5>
          <h5 class="counselor-item-price">1:1 상담 : {{counselor.price}} point</h5>
          <div class="card-text" id="counselor-item-text">
            <p class="text-muted">&#11088; {{counselor.value}} ({{counselor.reviewCnt}})</p>
            </div>
        </div>
      </div>
      </div>
    </div>

    </router-link>



  </div>


</template>

<script>
import {  mapActions, mapGetters } from 'vuex';
  export default {
    name : 'CounselorItem',
    props:{
      counselor:Object
    },
    computed: {
      ...mapGetters(['favorite','currentUser']),
    },
    methods: {
     ...mapActions(['favoriteGet','fetchCurrenUser'])
    },

    created() {
      // this.fetchCurrenUser()
      // this.favoriteGet()
      // this.favorite=''
    }
  }

</script>

<style scoped>
#counselor-item-card{
  margin:auto
}
.counselor-img2{
  margin-left:15px;
}
#counselor-item-card-title{
  margin-top : 10px;
}

.counselor-item-price{
  font-size: 2px;
}

#counselor-item-card:hover {
  transform: scale(1.03)
}

#counselor-item-card-body{
  float: right;
  margin-bottom: 5%;
}
</style>