<template>
<div class="page-content-wrapper py-3">
  <div class="blog-wrapper direction-rtl">
    <div class="container">
      <div class="row g-3">
        <div class="col-6 col-sm-4 col-md-3">
          <div class="card position-relative shadow-sm">
            <div class="card-body">
              <span class="badge bg-p rounded-pill mb-2 d-inline-block">
                <i class="bi bi-file-earmark-person"></i> 상담사 프로필</span>
              <h4>상담사 이름</h4>
              <!-- <router-link :to="{ name: 'boardDetail', params: {boardId: board.id }}">
              <span class="badge bg-danger rounded-pill mb-2 d-inline-block"><i class="bi bi-hand-thumbs-up-fill"></i> {{ board.hitCnt}}</span>
              <h4 class="blog-title d-block text-dark board-title">{{ board.title }}</h4>
              </router-link> -->
            </div>
          </div>
        </div>
      </div>
    </div>
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
<style scoped>
.bg-p {
  background-color: #5B5792
}
</style>
