<template>
<div>
  <div class="page-content-wrapper py-3 board-bg">
    <div class="shop-pagination pb-3">
      <div class="container">
        <div class="card">
          <div class="card-body p-2">
            <div class="d-flex align-items-center justify-content-between">
              <small class="ms-1 board-text-index ">1 : 1 수락 대기 중인 상담</small>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="blog-wrapper direction-rtl">
      <div class="container">
          <div>
            <personal-card-comp v-for="(request,idx) in requests.data" :key="idx" :request="request" ></personal-card-comp>
          </div>
      </div>
    </div>
    </div>
    <div class="page-content-wrapper py-3 board-bg">
  <div class="shop-pagination pb-3">
    <div class="container">
      <div class="card">
        <div class="card-body p-2">
          <div class="d-flex align-items-center justify-content-between">
            <small class="ms-1 board-text-index ">그룹 상담 일정</small>
=======
    <div class="blog-wrapper direction-rtl">
    <div class="container">
        <div v-for="(re, idx) in request" :key="idx" :re="re">
          <div class="card position-relative">
            <div class="card-body">
              <!-- <router-link :to="{ name: 'counseling', params: { counselingId: counseling.id, counselorId:counseling.counselorId}}"> -->
              <div class="d-flex justify-content-around">
                <div>
                  <span class="badge bg-danger rounded-pill mb-2 d-inline-block"> {{ idx }}</span>
                  <h3 class="blog-title d-block text-dark board-title">user : {{re.userId}}</h3>
                  <h4>상담일 : {{re.year}}/{{re.month}}/{{re.day}}</h4>
                </div>
              </div>
              <!-- </router-link> -->
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="blog-wrapper direction-rtl">
      <div class="container">
          <div>
            <personal-card-comp v-for="(request,idx) in requests.data" :key="idx" :request="request" class="col-6 col-sm-4 col-md-3"></personal-card-comp>
          </div>
      </div>
    </div>
    <!-- <div class="top-products-area product-list-wrap">
      <div class="container d-flex align-items-center justify-content-center">
        <div>
          <button class="w-btn-outline w-btn-yellow-outline" type="button" @click="changeIsGroup()">
              1:1 상담
          </button>
          <button class="w-btn-outline w-btn-yellow-outline" type="button" @click="changeIsGroup()">
              그룹 상담
          </button>
        </div>
        </div>
        <div >
          <h2>1:1 상담</h2>
            <personal-card-comp v-for="(request,idx) in requests.data" :key="idx" :request="request"></personal-card-comp>
        </div>
      </div> -->
    </div>
    <div class="page-content-wrapper py-3 board-bg">
  <div class="shop-pagination pb-3">
      <div class="container">
        <div class="card">
          <div class="card-body p-2">
            <div class="d-flex align-items-center justify-content-between">
              <small class="ms-1 board-text-index ">그룹 수락 대기 중인 상담</small>
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>
  <div class="blog-wrapper direction-rtl">
    <div class="container">
      <div>
        <group-card-comp v-for="(request,idx) in requests.data" :key="idx" :request="request"></group-card-comp>
      </div>
          </div>
      </div>
    </div>
  </div>
</template>

<script>
import personalCardComp from '@/views/counseling-request/components/personalcardComp.vue'
import groupCardComp from '@/views/counseling-request/components/groupcardComp.vue'

import { mapGetters,mapActions } from 'vuex'
export default {
  name : 'CounselingRequestList',
  components: {
    personalCardComp,
    groupCardComp,
  },
  data() {
    return {
      isGroup: false
    }
  },
  setup() {},

  mounted() {
    console.log(this.requests)
  },
  unmounted() {},
  computed:{
    ...mapGetters(['requests','currentUser']),
  },
  methods: {
    ...mapActions(['fetchRequests', 'fetchCurrentUser']),
    changeIsGroup() {
      this.isGroup = !this.isGroup;
    }
  },
  created() {
    this.fetchCurrentUser()
    this.fetchRequests()
}
}
</script>


<style scoped>



/* .counseling-request-list-title{
=======
.counseling-request-list-title{
>>>>>>> 9539e6226b03dbb50be9ab0bc0cef959bc8b47ea
  text-align: center;
  background-color:
}

.counseling-request-list-cards{
  justify-content: center;
<<<<<<< HEAD
} */





</style>