<template>
  <div class="page-content-wrapper py-3 group-bg">
    <div class="container">
      <div class="card my-2">
        <div class="card-body p-2">
          <div class="d-flex align-items-center justify-content-between">
            <small class="ms-1 board-text-index">그룹 상세 페이지</small>
            <div>
              <router-link to="/board"><button class="board-btn-index btn-sm mx-2">목록</button></router-link>
            </div>
          </div>
        </div>
      </div>
      <div class="card product-details-card mb-3 direction-rtl">
        <div class="card-body">

          <h1>{{ group.counselor }} 상담사</h1>
          <p>최고의 상담사</p>
          <form action="#" class="text-center">
            <router-link :to="{name: 'counselorProfile', params: {counselorId: this.group.counselorId}}">
              <button class="btn btn-primary w-50" type="submit">상담사 프로필</button>
            </router-link>

          </form>
        </div>
      </div>

      <div class="card product-details-card mb-3 direction-rtl">
        <div class="card-body">
          <h5>그룹 공지사항</h5>
          <p>{{ group.contents }}</p>
          <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolorum soluta tempore tenetur provident eligendi
            porro, eius nulla? Aliquam, blanditiis id. Corporis.</p>
          <p class="mb-0">Lorem ipsum dolor sit, amet consectetur adipisicing elit. At ut fugit accusantium quo quidem
            magni laboriosam!</p>



      <div class="card related-product-card direction-rtl my-3 p-0 price-card">
        <div class="card-body">
          <div class="d-flex justify-content-center">
            <p class="row badge bg-primary mx-3">price</p>
            <p class="text-center group-price">₩ {{ group.price }}</p>
          </div>
          <form action="#" class="text-center">
            <router-link to="/group/request">
              <button class="btn btn-primary">그룹 참가신청</button>
            </router-link>
          </form>
        </div>
      </div>
    </div>
  </div>
  </div>
</div>
</template>
<script>
import { mapGetters, mapActions } from 'vuex'

export default {
  components: {
  },
  data() {
    return {
      groupId: this.$route.params.groupId,
    };
  },
  setup() {},
  created() {
    this.fetchGroup(this.groupId)
  },
  mounted() {},
  unmounted() {},
  computed: {
    ...mapGetters(['group']),

  },
  methods: {
    ...mapActions(['fetchGroup']),

  },
};
</script>
<style>
.group-btn {
  background-color: #B2C8DF;
  border: none;

}
.group-bg{
  background-color: #F9F7F7;
}
.group-price{
  font-size: large;
}
.price-card {
  background-color: #F9F7F7;
}
</style>
