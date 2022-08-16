<template>
<div class="page-content-wrapper py-3 board-bg">
  <div class="shop-pagination pb-3">
    <div class="container">
      <div class="card">
        <div class="card-body p-2">
          <div class="d-flex align-items-center justify-content-between">
            <small class="ms-1 board-text-index">게시글 상세</small>
            <div>
              <router-link to="/board"><button class="board-btn-index btn-sm  mx-2">목록</button></router-link>
              <router-link :to="{name: 'boardUpdate', params: {boardID: board.id}}"><button class="board-btn-edit btn-sm">편집</button></router-link>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="top-products-area product-list-wrap">
    <div class="container ">
      <div class="form-group ">
        <div class="d-flex justify-content-between">
          <label class="board-text-bold board-text-title" >{{ board.title }}</label>
          <p>{{ board.date[0]}}.{{ board.date[1] }}.{{ board.date[2] }}</p>
        </div>
        <hr class="my-2">
        <div>
          <label class=" board-text-title">{{ board.contents }}</label>
        </div>
      </div>
    </div>
  </div>

    <comment-list-comp :comments="board.comments" :boardIdComment="board.id"></comment-list-comp>
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
        boardId: '',
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
    this.fetchBoard(this.$route.params.boardId)
  },
  mounted() {
    
  },
  unmounted() {},
}
</script>

<style>
.board-bg {
  background-color: #F9F7F7 ;

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
.board-text-bold {
  font-weight: bold;
}
</style>