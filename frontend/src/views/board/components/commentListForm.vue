<template>
<div class="page-content-wrapper py-3">
  <div class="shop-pagination pb-3">
    <div class="container">
      <div class="card">
        <div class="card-body p-2">
          <div class="d-flex align-items-center justify-content-between">
            <small class="ms-1">댓글 작성</small>
            <div>
              <button @click="onSubmit()" class="btn btn-danger btn-sm mx-3">등록</button>
            </div>
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
              <div class="d-flex align-items-center">
                <div class="form-group">
                  <textarea name="comment" id="comment" cols="45" rows="4" v-model="contents" placeholder="댓글을 입력해 주세요." required>
      </textarea>
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
import { mapGetters, mapActions } from 'vuex'

export default {
  data() {
    return {
      contents: ''
    }
  },
  computed: {
    ...mapGetters(['board']),
  },
  methods: {
    ...mapActions(['createComment']),
    onSubmit() {
      this.createComment({
        contents: this.contents
      })
      this.contents = ''
    }
  }
}
</script>

<style>

</style>
