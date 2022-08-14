<template>
<div class="page-content-wrapper py-3">
  <div class="shop-pagination pb-3">
    <div class="container">
      <div class="card">
        <div class="card-body p-2">
          <div class="d-flex align-items-center justify-content-between">
            <small class="ms-1">댓글 목록</small>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="top-products-area product-list-wrap">
    <div class="container">
      <div class="row g-3">
          <div class="card single-product-card">
            <div class="card-body">
              <div v-for="comment in comments" :key="comment"  class="d-flex align-items-center">
                <div class="form-group">
                  <!-- {{ comment }} -->
                  <p class="text-end">{{ comment.userId }}</p>
                </div>
                <div class="form-group">
                  <p>{{ comment.contents }}</p>
                </div>
              </div>
            </div>
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
  props: {
    comments: Object
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
