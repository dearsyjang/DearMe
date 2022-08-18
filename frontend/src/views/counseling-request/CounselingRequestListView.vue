<template>
<div>
  <div class="page-content-wrapper py-3 board-bg">
    <div class="shop-pagination pb-3">
      <div class="container">
        <div class="card">
          <div class="card-body p-2">
            <div class="d-flex align-items-center justify-content-between">
              <small class="ms-1 board-text-index ">수락 대기 중인 상담</small>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="top-products-area product-list-wrap">
      <div class="container">
        <h2 class="mx-2">1 : 1 상담</h2>
          <div>
            <personal-card-comp v-for="(request,idx) in requests.data" :key="idx" :request="request"></personal-card-comp>
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
    <div class="top-products-area product-list-wrap">
      <div class="container">
        <div  class="card mb-2">
          <div class="card-body d-flex align-items-center">
            <div class="user-info">
                <h2>그룹 상담</h2>
                <div>
                  <group-card-comp v-for="(request,idx) in requests.data" :key="idx" :request="request"></group-card-comp>
                </div>
              </div>
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

  mounted() {},
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

<style>


.counseling-request-list-title{
  text-align: center;
  background-color:
}

.counseling-request-list-cards{
  justify-content: center;
}



</style>