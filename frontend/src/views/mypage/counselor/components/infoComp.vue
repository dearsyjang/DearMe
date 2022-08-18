<template>
<div class="page-content-wrapper py-3 board-bg">
  <div class="shop-pagination pb-3">
    <div class="container">
      <div class="card">
        <div class="card-body p-2">
          <div class="d-flex align-items-center justify-content-between">
            <small class="ms-1 board-text-index ">{{ currentUser?.data?.id }} MYPAGE</small>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="top-products-area product-list-wrap">
    <div class="container">
      <div class="card user-info-card mb-3">
        <div class="card-body d-flex align-items-center">
          <div class="user-profile me-3">
                <label for="uploadItemFile">
                    <div class="wrapper-image" >
                        <img id = "profile" ref="uploadItemImage" width="auto">
                    </div>      
                </label>
          </div>
          <div class="user-info">
            <div class="d-flex align-items-center">
              <h5 class="mb-1 board-text-bold">{{ currentUser?.data?.nickname }}</h5>
              <span class="badge bg-warning ms-2 rounded-pill">{{ currentUser?.data?.type }}</span>
            </div>
            <div class="d-flex align-items-center">
              <p class="mb-0 me-4 board-mypoint board-text-bold">최고의 상담사</p>
              <router-link :to="{ name: 'counselorProfile', params: {counselorId: currentUser?.data?.id}}">
              <button class="w-btn w-btn-charge" type="button">프로필</button>
              </router-link>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</template>
<script>
import { mapActions, mapGetters } from 'vuex';

export default {
  components: {},
  data() {
    return {
      sampleData: '',
    }
  },
  setup() {},
  created() {
    this.fetchCurrentUser()
  },
  mounted() {
    const img = document.getElementById('profile');
    console.log(this.currentUser.data)
      img.src = this.currentUser.data.pictureUrl
  },
  computed:{
    ...mapGetters(['currentUser']),
  },
  unmounted() {},
  methods: {
    ...mapActions(['fetchCurrentUser']),
        getImage () {
      const img = document.getElementById('profile');
      console.log(this.currentUser.data)
      img.src = this.currentUser.data.pictureUrl
    },
    // 회원 정보 수정 매서드 받아와서 패치하고 출력
  },
  

}
</script>
<style scoped>

</style>
