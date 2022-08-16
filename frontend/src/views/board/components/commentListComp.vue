<template>
<div class="page-content-wrapper py-3 board-bg-sky">
  <div v-if="board.comments">
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
              
              <div v-for="comment in board.comments" :key="comment"  class="d-flex row align-items-center">
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
<div class="modal fade" v-if="isModal" id="commentCreate" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
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
</div>
</template>
<script>
import {  mapActions, mapGetters  } from 'vuex'
export default {
  props: {
    comments: null,
    boardId: null,
  },
  components: {},
  data() {
    return {
      isModal: true,
      isCounselor: false,
      contents: '',
    }
  },
  setup() {},
  created() {
  },
  mounted() {
    this.checkCounselor()
  },
  unmounted() {},
  methods: {
    ...mapActions(['createComment']),
    onSubmit() {
      this.isModal=!this.isModal
      this.createComment({
        contents: this.contents
      })
      
      this.$router.push({ name: 'boardDetail', params: {boardId: this.boardId} })
      this.$router.go()
    },
    checkCounselor() {
      if (this.currentUser.data.type === 'COUNSELOR') {
        this.isCounselor = true
      }
    }
  },
  computed: {
    ...mapGetters(['currentUser' ,'board'])
  }
}
</script>
<style>


</style>
