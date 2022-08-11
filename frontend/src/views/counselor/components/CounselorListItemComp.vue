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
        :to="{ name: 'counselor', params: {counselorId: counselor.id} }"> -->
    <div class="card mb-3" style="max-width: 540px;">
      <div class="row g-0">
        <div class="col-md-4">
          사진:{{counselor.pictureUrl}}
        </div>
        <div class="col-md-8">
          <div class="card-body">
            <h5 class="card-title">닉네임 : {{counselor.nickname}}</h5>
            <p class="card-text">{{counselor.counselorProfileInfoDto}}</p>
            <p class="card-text"><small class="text-muted"></small></p>
          </div>
        </div>
      </div>
    </div>
    <!-- </router-link> -->

  </div>


</template>

<script>
  export default {
    name : 'CounselorItem',
    props:{
      counselor:Object
    }
    
    
  }

</script>

<style>

</style>