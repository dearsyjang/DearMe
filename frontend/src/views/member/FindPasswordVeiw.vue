<template>
<div class="member-gb">
  <div class="page-content-wrapper py-3 ">
      <div class="shop-pagination pb-3">
        <div class="container">
          <div class="card">
            <div class="card-body p-2">
              <div class="d-flex align-items-center justify-content-between">
                <small class="ms-1 board-text-index">비밀번호 찾기</small>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="top-products-area product-list-wrap">
        <div class="container">
          <div class="form-group mt-4">
            <label class="form-label mx-2" for="id">아이디</label>
            <input type="text" class="form-control" placeholder="아이디">
          </div>
          <div class="form-group mt-4">
            <label class="form-label mx-2" for="email">이메일</label>
            <input type="text" class="form-control" placeholder="이메일">
          </div>
          <div class="form-group mt-4">
            <button class="btn btn-primary">비밀번호 찾기</button>
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
