<template>
  <div class="page-content-wrapper py-3">
  <div class="shop-pagination pb-3">
    <div class="container">
      <div class="card">
        <div class="card-body p-2">
          <div class="d-flex align-items-center justify-content-between">
            <small class="ms-1">게시글 보기</small>
            <div>
              <router-link to="/board"><button class="btn btn-primary btn-sm">목록</button></router-link>
              <button @click="onSubmit()" class="btn btn-danger btn-sm mx-3">편집</button>
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
                  <label class="form-label" for="exampleInputText">제목</label>
                  <p>{{ board.title }}</p>
                </div>
              </div>
              <div class="d-flex align-items-center">
                <div class="form-group">
                  <label class="form-label" for="exampleInputText">내용</label>
                  <p>{{ board.contents }}</p>
                </div>
              </div>
            </div>
        </div>
      </div>
    </div>
  </div>
    <comment-list-form></comment-list-form>
    <comment-list-comp :comments="board.comments"></comment-list-comp>
</div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'

import commentListForm from './components/commentListForm.vue'
import commentListComp from './components/commentListComp.vue'
export default {
  props: {
  },
  components: {
    commentListForm,
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
    ...mapGetters(['board'])

  },
  methods: {
    ...mapActions(['fetchBoard', 'deleteBoard']),
  },
  created() {
    this.fetchBoard(this.data.boardId)},
  mounted() {},
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