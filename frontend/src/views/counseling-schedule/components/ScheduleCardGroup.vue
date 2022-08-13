<template>
<div>
    <!-- @click="" => method 연결하기
    <div class="card" style="width: 18rem; height: 8rem;">
        <div class="card-body">
            <h5 class="card-title">상담사: </h5>
            <h5 class="card-title">상담일: </h5>
            <router-link to="counseling"><button  class="btn" id="enter-button">상담방 입장</button></router-link>
        </div>
    </div> -->
    <div v-for="(re,idx) in request"
      :key="idx"
      :re="re">
    <div class="card mb-3" style="max-width: 540px;">
      <div class="row g-0">
        <div class="col-md-4">
          상담번호: {{re.id}}
          <br>
          유저 번호: {{re.userId}}
          <br>
          상담사번호:{{re.counselorId}}
          <br>
          {{re.year}}/{{re.month}}/{{re.day}}
        </div>
        <div class="col-md-8">
          <div class="card-body">
            <h5 class="card-title"> </h5>
            <!-- <p class="card-text">{{request}}</p> -->
            <p class="card-text"><small class="text-muted"></small></p>
          </div>
        </div>
      </div>
    </div>
    </div>
</div>
</template>

<script>
export default {
    name: "ScheduleDocumentComp",
    props:{
      request: Array,
    }

}
</script>

<style scoped>
.card {
 text-align: left;
}
#enter-button{
  background-color: #3F72AF;
  float: right;
}
</style>
