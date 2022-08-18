<template>
<div class="page-content-wrapper">
  <div class="blog-wrapper direction-rtl">
    <div class="container">
      <div class="row g-3">
        <div v-for="(re,idx) in request" :key="idx" :re="re" class="col-6 col-sm-4 col-md-3">
        <div v-if="re.counselorId== currentUser.data.userId && re.status==`UNACCEPTED` && re.groupId != null " >
          <div class="card position-relative shadow-sm">
            <div class="card-body">
              <!-- <router-link :to="{ name: 'CounselingRequestDocument', params : {counselingId : re.id}}"> -->
              <div class="card-body d-flex align-items-center">
                  <div>
                    <span class="badge bg-danger rounded-pill mb-2 d-inline-block"> {{ idx }}</span>
                    <h3 class="blog-title d-block text-dark board-title">그룹 번호: {{re.groupId}}</h3>
                    <h4>상담사:{{re.counselorNickName}}</h4>
                    <h4>상담일 : {{re.year}}/{{re.month}}/{{re.day}}</h4>
                  </div>
              </div>
            <!-- </router-link> -->
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