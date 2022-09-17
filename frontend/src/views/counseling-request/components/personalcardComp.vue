<template>
  <div class="blog-wrapper direction-rtl">
    <div class="container">
        <div v-for="(re,idx) in request"
        :key="idx">
          <div class="card position-relative">
            <div class="card-body">
              <router-link :to="{ name: 'counselingAcceptView', params : { id:re.id, userid:re.userId}}">
              <div class="d-flex justify-content-around">
                  <div>
                    <span class="badge bg-danger rounded-pill mb-2 d-inline-block"> {{ idx }}</span>
                    <h4 class="blog-title d-block text-dark board-title">user : {{re.userId}}</h4>
                    <h4>상담일 : {{re.year}}/{{re.month}}/{{re.day}}</h4>
                  </div>
              </div>
              </router-link>
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
    console.log(this.request)
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