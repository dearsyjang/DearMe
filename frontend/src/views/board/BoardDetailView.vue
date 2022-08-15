<template>
<div class="page-content-wrapper py-3 board-bg-sky">
  <div class="shop-pagination pb-3">
    <div class="container">
      <div class="card">
        <div class="card-body p-2">
          <div class="d-flex align-items-center justify-content-between">
            <small class="ms-1 board-text-index">게시글 보기</small>
            <div>
              <router-link to="/board"><button class="board-btn-index btn-sm">목록</button></router-link>
              <router-link :to="{name: 'boardUpdate', params: {boardId: board.id}}"><button class="board-btn-edit btn-sm mx-2">편집</button></router-link>
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
              <div class="">
                <div class="form-group">
                  <h1 class="form-label board-text-title" for="exampleInputText">제목</h1>
                  <hr>
                  <p class="board-detail-context">{{ board.title }}</p>
                </div>
              </div>
              <div class="">
                <div class="form-group">
                  <h1 class="form-label board-text-title" for="exampleInputText">내용</h1>
                  <hr>
                  <p class="board-detail-context">{{ board.contents }}</p>
                </div>
              </div>
            </div>
        </div>
      </div>
    </div>
  </div>
    <comment-list-comp :comments="board.comments" :boardId="board.id"></comment-list-comp>
</div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'

import commentListComp from './components/commentListComp.vue'
export default {
  props: {
  },
  components: {
    commentListComp,

  },
  data() {
    return {
      data: {
        title: '',
        contents: '',
        boardId: this.$route.params.boardId
      }
    }
  },
  computed: {
    ...mapGetters(['board', 'currentUser'])

  },
  methods: {
    ...mapActions(['fetchBoard', 'deleteBoard']),
  },
  created() {
    this.fetchBoard(this.data.boardId)
    },
  mounted() {},
  unmounted() {},
}
</script>

<style>
.board-bg-sky {
  background-color: #D6E6F2 ;

}
.board-btn-index {
  background-color: #1E2022;
  color: white;
  border: none;
}
.board-btn-edit {
  background-color: #52616B;
  color: white;
  border: none;
}
.board-btn-submit {
  background-color: #262A53;
  color: white;
  border: none;
}
.board-btn-detail {
  background-color: #FFA0A0;
  color: white;
  border: none;
}
.board-text-title {
  font-size: large;
}
.board-text-index {
  font-size: large;
  font-weight: bold;
}
.board-detail-width{
  width: 100%;
}
.board-detail-context {
  font-size: large;
  color : #52616B;
  border: none;
}
</style>