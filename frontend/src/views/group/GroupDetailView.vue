<template>
  <div class="page-content-wrapper py-3 group-bg">
    <div class="container">
      <div class="card my-2">
        <div class="card-body p-2">
          <div class="d-flex align-items-center justify-content-between">
            <small class="ms-1 board-text-index">그룹 상담 상세</small>
            <div>
              <router-link to="/counselors/counselorList"><button class="board-btn-index btn-sm mx-2">목록</button></router-link>
            </div>
          </div>
        </div>
      </div>
      <div class="card product-details-card mb-3 direction-rtl">
        <div class="card-body">
          <h1 class="text-center">{{ group.counselor }} 상담사</h1>
          <p class="text-center">최고의 상담사</p>
          <form action="#" class="text-center">
            <router-link :to="{name: 'counselorProfile', params: {counselorId: this.group.counselorId}}">
              <button class="w-btn-neon2 " type="button">상담사 프로필</button>
            </router-link>
          </form>
        </div>
      </div>
      <div class="card product-details-card mb-3 direction-rtl">
        <div class="card-body">
          <h5>그룹 공지사항</h5>
          <p>{{ group.contents }}</p>
          <p>공지사항이 짧아서 아무글 써놨음 Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolorum soluta tempore tenetur provident eligendi
            porro, eius nulla? Aliquam, blanditiis id. Corporis.</p>
          <p class="mb-0">Lorem ipsum dolor sit, amet consectetur adipisicing elit. At ut fugit accusantium quo quidem
            magni laboriosam!</p>
        <div class="card related-product-card direction-rtl my-3 p-0 ">
          <div class="card-body">
            <div class="d-flex justify-content-center">
              <p class="row badge bg-primary mx-3 group-price-btn">price</p>
              <p class="text-center group-price">₩ {{ group.price }}</p>
            </div>
            <form action="#" class="text-center">
              <router-link :to="{name: 'groupRequest', params: {groupId: this.group.id}}">
                <button class="w-btn-neon2 " type="button">그룹 참가신청</button>
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
  background-color: #504E48;
  border: none;

}
.group-bg{
  background-color: #F9F7F7;
}
.group-price{
  font-size: large;
}
.group-price-btn {
  border: none;
    background: linear-gradient(
        90deg,
        #4a5069 0%,
        #293462 100%
    );
    border-radius: 1000px;
    color: darkslategray;
    cursor: pointer;
    /* box-shadow: 12px 12px 24px #293462; */
    font-weight: 700;
    transition: 0.3s;
}
.price-card {
  background-color: #F9F7F7;
}
.w-btn-neon2 {
    /* position: relative; */
    border: none;
    min-width: 200px;
    min-height: 50px;
    background: linear-gradient(
        90deg,
        #B2C8DF 0%,
        #86b2e1 100%
    );
    border-radius: 1000px;
    color: darkslategray;
    cursor: pointer;
    box-shadow: 12px 12px 24px #B2C8DF;
    font-weight: 700;
    transition: 0.3s;
}

.w-btn-neon2:hover {
    transform: scale(1.2);
}

</style>
