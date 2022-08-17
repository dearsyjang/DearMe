<template>
  <div>
    <div class="group-request-cards">
    <div v-for="(re,idx) in request"
      :key="idx"
      :re="re">
    <div v-if="re.counselorId== currentUser.data.userId && re.status==`UNACCEPTED` && re.groupId != null "  class="card mb-3" >
    <router-link :to="{ name: 'CounselingRequestDocument', params : {counselingId : re.id}}">
      <div class="row g-0">
        <div class="col-md-4" style="text-decoration: none">
           
          <div class="personal-request-index" style="text-decoration: none">{{idx}}</div>
          <p>그룹 번호: {{re.groupId}}</p>
          
          <p>상담사:{{re.counselorNickName}}</p>
         
          <p>상담일 : {{re.year}}/{{re.month}}/{{re.day}}</p>
        </div>
      </div>
      </router-link>
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
.group-request-cards{
  max-width:90%;
  margin:auto;
  text-decoration: none;
}

a:link {
  text-decoration: none;
}


.group-request-watch-btn{
  float: right;
  margin-bottom : 5px
}

.personal-request-index{
  background-color: bisque;
  color:bisque;
}

</style>