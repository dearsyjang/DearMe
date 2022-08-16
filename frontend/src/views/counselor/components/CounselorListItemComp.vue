<template>
  <div>



    <router-link 
    :to="{ name: 'counselorProfile', params: {counselorId: counselor.counselorId}}" style="text-decoration:none">
    
    <div class="card mb-3" id="counselor-item-card" style="max-width: 90%;">
      <div class="row" id="counselor-item-row">
        <div class="counselor-item-pic col-md-16 " style="max-width:50%;">
          <img src = "@/assets/images/강지명.png" class="counselor-img2"/>
          {{counselor.pictureUrl}}
        </div> 
        <div class="card-body col-md-16" id="counselor-item-card-body" style="max-width:50%;" >
          <h5 class="card-title" id="counselor-item-card-title">{{counselor.nickName}} 상담사</h5>
          <div class="counselor-item-price">1:1 상담 : {{counselor.price}} point</div>
          <p class="card-text" id="counselor-item-text"><small class="text-muted">&#11088; {{counselor.value}} ({{counselor.reviewCnt}})</small></p>
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

<style>
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