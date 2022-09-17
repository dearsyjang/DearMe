<template>
<div class="member-gb">
  <div class="page-content-wrapper py-3 ">
    <div class="shop-pagination pb-3">
      <div class="container">
        <div class="card">
          <div class="card-body p-2">
            <div class="d-flex align-items-center justify-content-between">
              <small class="ms-1 board-text-index">사용자 유형 선택</small>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="top-products-area product-list-wrap">
      <div class="container">
      <div class="type card text-center my-2">
        <h1 class="card-title my-2">취업준비생</h1>
        <router-link :to="{name: 'signupuser', params:{type: 'USER'}}">
          <img class="signup-type-img" src="@/assets/images/img/bg-img/user.png" alt="">
        </router-link>
      </div>
      <div class="type card text-center">
        <h1 class="card-title my-2">심리상담사</h1>
        <router-link :to="{name: 'signupcounselor', params:{type: 'COUNSELOR'}}">
          <img class="signup-type-img" src="@/assets/images/img/bg-img/doctor.png" alt="">
        </router-link>
      </div>
      </div>
    </div>
  </div>
  <div>
</div>

</div>
</template>
<script>
export default {
  components: {},
  data() {
    return {
      sampleData: ''
    }
  },
  setup() {},
  created() {},
  mounted() {},
  unmounted() {},
  methods: {}
}
</script>
<style>
.signup-type-img {
  height: 250px;
}
.signup-img {
  height: 200px;
}
.member-gb{
  background-color: #F9F7F7;
  height: 100%;
  padding-bottom: 100%;
}
</style>