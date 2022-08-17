<template>
<div class="page-content-wrapper py-3">
  <div class="blog-wrapper direction-rtl">
    <div class="container">
      <div class="row g-3">
        <div class="col-6 col-sm-4 col-md-3">
          <div class="card position-relative shadow-sm">
            <div class="card-body">
              <span class="badge bg-danger rounded-pill mb-2 d-inline-block"><i class="bi bi-hand-thumbs-up-fill"></i>4.5</span>
              <h4 class="blog-title d-block text-dark board-title">그룹 상담방</h4>
              <h6>10:00 - 11:00</h6>
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
  props: {
    requests: Array
  },
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
  .BoardList {
    background-color: #F0F5F9;

  }
  p, button {
    width: 160px;
    display: table-cell;
  }
</style>