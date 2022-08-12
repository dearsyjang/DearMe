<template>
  <div id="article-form">
    <br>
    <h1>게시글 작성하기</h1>
    <!--v-if="action"==""으로 작성, 수정 구분해주기-->
    <hr>
    <div class="container">
      <h4 id="article-form-title-text">제목</h4>
      <form class="article-form">
        <p>{{ board.title }}</p>
        <br>
        <br>
        <h4 id="article-form-content-text">내용</h4>
        <p id="article-form-content" rows="10" max-rows="10">{{ board.contents }}</p>
        <br>
        <div>
          <router-link :to="{name: 'boardUpdate'}"><button>수정</button></router-link>
          <router-link :to="{ name: 'board' }"><button button type="button" class="btn" id="article-form-cancel-button">목록</button></router-link>
        </div>
        <div>
        </div>
      </form>
    </div>
    <!-- <p>{{ board.comments }}</p> -->
    <!-- <div v-for="comment in board.comments" :key="comment">
      <comment-list-comp :comment="comment.contents" ></comment-list-comp>
    </div> -->
    <!-- counselor 경우 -->
    <comment-list-form></comment-list-form>
    <comment-list-comp :comments="board.comments"></comment-list-comp>

  </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'

import commentListForm from './components/commentListForm.vue'
import commentListComp from './components/commentListComp.vue'
export default {
  components: {
    commentListForm,
    commentListComp,

  },
  data() {
    return {
      data: {
        title: '',
        contents: ''
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
    this.fetchBoard(2)},
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