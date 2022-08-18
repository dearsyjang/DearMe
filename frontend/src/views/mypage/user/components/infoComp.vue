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
              <p id="point-number" style="font-size: 0.8em" class="mb-0 me-4 board-mypoint board-text-bold">잔여 포인트 : {{ currentUser?.data?.points }} pt</p>
              <router-link :to="{ name: 'PointView'}">
              <button class="w-btn w-btn-charge" type="button">충전하기</button>
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
    this.getImage()
    console.log(this.currentUser.data.pictureUrl)
  },
  unmounted() {},
  methods: {
    ...mapActions(['fetchCurrentUser']),
    getImage () {
      console.log(this.currentUser)
      const img = document.getElementById('profile');
      img.src = this.currentUser.data.pictureUrl
    },
    // 회원 정보 수정 매서드 받아와서 패치하고 출력
  },
  computed:{
    ...mapGetters(['currentUser']),
  }

}
</script>
<style >
#info-p {
  font-size: large;
}
#info-pl {
  font-size: xx-large;
  margin: 20px, 0
}
#info-plc {
  font-size: xx-large;
  line-height: 100px;
}
.w-btn-charge {
    /* position: relative; */
    border: none;
    min-width: 90px;
    min-height: 30px;
    background: linear-gradient(
        90deg,
        #8d8cb0 0%,
        #636294 100%
    );
    border-radius: 1000px;
    color: darkslategray;
    cursor: pointer;
    box-shadow: 12px 12px 24px #76769a1a;
    font-weight: 500;
    transition: 0.3s;
    color: #E8E5DC;
    font-size:14px
}

.point-number{
  font-size: 5px
}

.w-btn-charge:hover {
    transform: scale(1.2);
}
.board-mypoint{
  font-size: medium;
}

</style>
