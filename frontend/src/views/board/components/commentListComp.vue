<template>
<div class="page-content-wrapper py-3 board-bg-sky">
  <div class="shop-pagination pb-3">
    <div class="container">
      <div class="card">
        <div class="card-body p-2">
          <div class="d-flex align-items-center justify-content-between">
            <small class="ms-1 board-text-index">댓글 목록</small>
            <div v-if="isCounselor === true">
            <button class="board-btn-submit btn-sm mx-2" data-bs-toggle="modal"
            data-bs-target="#commentCreate">등록</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="top-products-area product-list-wrap">
    <div class="container">
      <div class="row">
          <div class="card single-product-card">
            <div class="card-body">
              <div v-for="comment in comments" :key="comment"  class="d-flex row align-items-center">
                <div class="form-group">
                  <i class="bi bi-chat-right-heart"></i>
                  <p class="text-end">COUNSELOR ID : {{ comment.userId }} | {{ comment.date[0] }}.{{ comment.date[1] }}.{{ comment.date[2] }}.{{ comment.date[3] }}</p>
                  <p class="board-detail-context">{{ comment.contents }}</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  <div>
</div>
<div class="modal fade" id="commentCreate" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">댓글 등록하기</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <textarea v-model="contents" rows="10" cols="50" type="text" placeholder="댓글 내용을 입력하시오."></textarea>
        <button @click="onSubmit()" class="board-btn-submit btn-sm mx-3">등록</button>
      </div>
    </div>
  </div>
</div>
</div>
</template>
<script>
import {  mapActions, mapGetters  } from 'vuex'
export default {
  props: {
    comments: Object,
    boardId: Object
  },
  components: {},
  data() {
    return {
      isCounselor: false,
      contents: ''
    }
  },
  setup() {},
  created() {
    this.checkCounselor()
  },
  mounted() {},
  unmounted() {},
  methods: {
    ...mapActions(['createComment']),
    onSubmit() {
      this.createComment({
        contents: this.contents
      })
      this.$router.push({ name: 'boardDetail', params: {boardId: this.boardId} })
    },
    checkCounselor() {
      if (this.currentUser.data.type === 'COUNSELOR') {
        this.isCounselor = true
      }
    }
  },
  computed: {
    ...mapGetters(['currentUser'])
  }
}
</script>
<style>


</style>
