<template>
  <div class="page-content-wrapper py-3 group-bg">
    <div class="container">
      <div class="card my-2">
        <div class="card-body p-2">
          <div class="d-flex align-items-center justify-content-between">
            <small class="ms-1 board-text-index">그룹 참가 신청</small>
            <!-- <div>
              <router-link to="/board"><button class="board-btn-index btn-sm mx-2">목록</button></router-link>
            </div> -->
          </div>
        </div>
      </div>
      <div class="card product-details-card mb-3 direction-rtl">
        <div class="card-body">

          <h1>{{ group.counselor }} 상담사</h1>
          <p>최고의 상담사</p>
        </div>
      </div>

      <div class="card product-details-card mb-3 direction-rtl">
        <div class="card-body">
          <h5>그룹 상담 신청 내용</h5>
          <p>{{ group.contents }}</p>
          <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolorum soluta tempore tenetur provident eligendi
            porro, eius nulla? Aliquam, blanditiis id. Corporis.</p>
          <p class="mb-0">Lorem ipsum dolor sit, amet consectetur adipisicing elit. At ut fugit accusantium quo quidem
            magni laboriosam!</p>
        </div>
    </div>
  </div>
</div>
</template>
<script>
import { mapActions, mapGetters } from "vuex";
export default {
  props: {
    group:Object
  },
  components: {},
  data() {
    return {
      // groupId 받아오는거 생각해보기
      groupId: this.$route.params.groupId,
      isOpen: true,
      contents: "",
    };
  },
  setup() {},
  created() {
    this.fetchGroup(this.groupId)
  },
  mounted() {},
  unmounted() {},
  methods: {
    ...mapActions(["groupRequest", 'fetchGroup']),
    onSubmit() {
      const data = {
        id: this.groupId,
        isOpen: this.isOpen,
        contents: this.contents
      }
      this.groupRequest(data)
    },
    switchOpen() {
      this.isOpen = !this.isOpen
    }
  },
  computed: {
    ...mapGetters(['currentUser', 'group'])
  }
};
</script>
<style scoped>
.groupRequestContent {
  background-color: #f0f5f9;
  padding-top: 30px;
}
#groupRequestName {
  background-color: #f0f5f9;
  width: 30%;
  margin: auto;
  border: solid #1e2022 1px;
  margin-bottom: 10px;
}
h1 {
  border: solid #1e2022 1px;
  width: 90%;
  margin: auto;
  background-color: #f0f5f9;
  margin-bottom: 10px;
}
</style>
