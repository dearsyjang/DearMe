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
    :to="{ name: 'counselorProfile', params: {counselorId: counselor.counselorId}}">
    <div class="card mb-3" style="max-width: 540px;">
      <div class="row g-0">
        <div class="col-md-4">
          사진:{{counselor.pictureUrl}}
        </div>
        <div class="col-md-8">
          <div class="card-body">
            <h5 class="card-title">닉네임 : {{counselor.nickName}}</h5>


            <!-- <div v-if="f.counselorId !=counselor.data.userId">
            <button class="btn btn-link" style="color: black " @click="favoriteAdd(counselor.data.userId)">★
            </button>
            </div>
            <div v-if="f.counselorId ==counselor.data.userId"> 
            <button class="btn btn-link" style="color: red" @click="favoriteDelete(f.id)">★
            </button>
            </div> -->
           

<!-- 
            {{currentUser}} -->
            <!-- {{favorite.data}} -->
            <!-- "counselor.counselorId in favorite.data && "
            <div v-if="!favorite">
            <button class="btn btn-link" ><span style='font-size:20px;'>&#129505;</span></button>
            </div>
            <div v-else>
            <button class="btn btn-link" ><span style='font-size:20px;'>&#127830;</span></button>
            </div> -->

            <!-- <p class="card-text">{{counselor}}</p> -->
            <p class="card-text"><small class="text-muted">평점 / 후기 수 :{{counselor.value}}/{{counselor.reviewCnt}}</small></p>
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
      this.fetchCurrenUser()
      this.favoriteGet()
      this.favorite=''
    }
  }

</script>

<style>

</style>