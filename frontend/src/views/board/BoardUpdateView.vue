<template>
  <div class="page-content-wrapper py-3 board-bg">
  <div class="shop-pagination pb-3">
    <div class="container">
      <div class="card">
        <div class="card-body p-2">
          <div class="d-flex align-items-center justify-content-between">
            <small class="ms-1 board-text-index">게시글 수정</small>
            <div>
              <router-link to="/board"><button class="board-btn-index btn-sm ">목록</button></router-link>
              <button @click="onSubmit()" class="board-btn-submit btn-sm mx-2">수정</button>
              <button @click="deleteBoard(board.id)" class="board-btn-submit btn-sm ">삭제</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="top-products-area product-list-wrap">
    <div class="container ">
      <div class="form-group ">
        <label class="board-text-bold form-label board-text-title board-input" for="exampleInputText">제목</label>
        <input class="form-control board-input " v-model="data.title" id="exampleInputText" type="text" placeholder="제목을 입력하시오.">
      </div>
      <label class="board-text-bold form-label board-text-title" for="exampleInputText">내용</label>
      <textarea class="form-control " v-model="data.contents" cols="20" rows="10" placeholder="내용을 입력하시오."></textarea>
    </div>
  </div>
</div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'

export default {
  components: {

  },
  data() {
    return {
      boardID: this.$route.params.boardId,
      data: {
        title: this.board.title,
        contents: this.board.contents
      }
    }
  },
  computed: {
    ...mapGetters(['board'])

  },
  methods: {
    ...mapActions(['fetchBoard', 'deleteBoard', 'updateBoard']),
    onsubmit() {
      const data = {
        title: this.title,
        contents: this.contents
      }
      this.updateBoard(this.boardID, data)
    }
  },
  created() {
    this.fetchBoard(this.boardID)
  },
  mounted() {
  },
  unmounted() {},
}
</script>

<style>
#article-form-title, #article-form-content {
    width: 100%;
}

#article-form-title-text, #article-form-content-text{
  text-align: start;
}

#article-form-submit-button {
  width:auto; height:50px;
  background-color: #3282B8;
  margin: 3px;
  outline: none;
}

#article-form-cancel-button{
  width:auto; height:50px;
  background-color: #B83232;
  margin: 3px;
  outline: none;
}

</style>