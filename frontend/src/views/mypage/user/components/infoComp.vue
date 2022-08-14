<template>
  <div class="container">
    <div class="row">

      {{ currentUser }}

      <label id="con1" class="col-sm-6 col-form-label" for="nickname"></label>
      <p id="con1" class="form-control col-sm-6">사용자</p>
    </div>
    <div id="point">
      <label class="form-label" for="myPoint">잔여포인트</label>
    </div>
    <div class="row">
      <p id="con2" class="form-control col-sm-6">500 pt</p>
      <router-link to="/point">
      <button id="con2" class="btn btn-primary col-sm-6">충전하기</button>
      </router-link>
      <div class="container direction-rtl my-4">
      <div class="card mb-3">
        <div class="card-body">
          <div class="row my-3">
            <div class="col-5" id="info-plc">
              <div class="feature-card mx-auto text-center" >
                <div class="card mx-auto bg-gray">
                  <img src="@/assets/images/img/bg-img/user.png" alt="">
                </div>
                <p class="mb-0" id="info-pl">{{ currentUser.data.nickname }}</p>
              </div>
            </div>
            <div class="col-4">
              <div>
                <p id="info-p">{{ currentUser.data.type }}</p>
              </div>
              <div class="my-3">
                <span>잔여 포인트 : </span>
                <span id="info-p">{{ currentUser.data.points }}pt</span>
              </div>
                <router-link :to="{ name: 'PointView'}"><a class="btn btn-round btn-outline-info" href="#">충전하기</a></router-link>
              <div>
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
import { mapGetters } from 'vuex';
export default {
  components: {},
  data() {
    return {
      sampleData: ''
    }
  },
  setup() {},
  created() {
  },
  mounted() {},
  unmounted() {},
  methods: {
    // 회원 정보 수정 매서드 받아와서 패치하고 출력
  },
  computed:{
    ...mapGetters(['currentUser']),
  }

}
</script>
<style scoped>
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

</style>
