<template>
<div>
  <div class="page-content-wrapper py-3 board-bg">
    <div class="shop-pagination pb-3">
      <div class="container">
        <div class="card">
          <div class="card-body p-2">
            <div class="d-flex align-items-center justify-content-between">
              <small class="ms-1 board-text-index ">오늘의 상담</small>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="top-products-area product-list-wrap">
      <div class="container">
        <div  class="card mb-2">
          <div class="card-body d-flex align-items-center">
            <div class="user-info">
              <h2>1:1 상담</h2>
              <div>
                <personalcard-comp
                v-for="(request,idx) in requests.data"
                :key="idx"
                :request="request">
                </personalcard-comp>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="top-products-area product-list-wrap">
      <div class="container">
        <div  class="card mb-2">
          <div class="card-body d-flex align-items-center">
            <div class="user-info">
                <h2>그룹 상담</h2>
                <div >
                  <groupcard-comp
                  v-for="(request,idx) in requests.data"
                      :key="idx"
                      :request="request">
                  </groupcard-comp>
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
import PersonalcardComp from '@/views/counseling-schedule/components/PersonalcardComp.vue'
import GroupcardComp from '@/views/counseling-schedule/components/GroupcardComp.vue'

import { mapGetters,mapActions } from 'vuex'
export default {
  name : 'TodayScheduleView',
  components: {
    PersonalcardComp,
    GroupcardComp,
  },
  data() {
    return {
      sampleData: ''
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
  },
  created() {
    this.fetchCurrentUser()
    this.fetchRequests()
}
}
</script>

<style >
body{
  background-color: #F9F7F7;
}
</style>