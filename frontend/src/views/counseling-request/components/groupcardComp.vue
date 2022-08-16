<template>
     <div>
    
    <div v-for="(re,idx) in request"
      :key="idx"
      :re="re">
    <div v-if="re.counselorId== currentUser.data.userId && re.status==`UNACCEPTED` && re.groupId != null "  class="card mb-3" style="max-width: 540px;">
      <div class="row g-0">
        <div class="col-md-4">
           
          상담번호: {{re.id}}
          <br>
          그룹 번호: {{re.groupId}}
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
                <button class="group-request-watch-btn">신청서보기</button>
            </small></p>
          </div>
        </div>
      </div>
    </div>
    </div>


  </div>
</template>
<script>
export default {
    name : 'groupcardComp'
    
}
</script>
<style>
.group-request-watch-btn{
  float: right;
  margin-bottom : 5px
}
</style>