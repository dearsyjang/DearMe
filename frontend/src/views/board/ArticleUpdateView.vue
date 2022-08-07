<template>
  <div id="ArticleView" class="container">
    <br>
    <!--데이터 연결하기-->
    <div id="ArticleViewTop">
        <h3 id="article-view-top-title">{{ data.title }}</h3>
        <p id="article-view-top-date">작성일: </p>
        <p id="article-view-user">작성자: </p>
    </div>

    <div id="ArticleViewMiddle">
        <textarea v-model="data.content"></textarea>
    </div>

    <div>
      <!-- 게시글 작성자 닉네임과 현재 유저 닉네임이 같으면 수정, 삭제 버튼 표시
      현재 유저는 토큰인데 닉네임을 어떻게 가져올지 고민 -->
      <!-- <div v-if="this.board.nickname === this.currentUser"> -->

      </div>
        <!--버튼 if -->
        <button @click="onSubmit()" id="article-view-update-button" class="btn m-1">수정하기</button>
        <button id="article-view-delete-button" class="btn m-1" @click="articleDelete(articlePk)">삭제하기</button>
        <router-link :to="{ name: 'board' }">
        <button id="article-view-back-button" type="button" class="btn m-1">글 목록</button>
        </router-link>
    </div>

    <div id="article-view-bottom">
        <!-- <comment-list></comment-list> -->
        <br>
        <comment-create-form></comment-create-form>
    </div>
</template>

<script>
import CommentCreateForm from './components/CommentCreateForm.vue'
// import CommentList from './components/CommentList.vue'
import { mapGetters, mapActions } from 'vuex'
export default {
  components: {
    // CommentList,
    CommentCreateForm
    },
    data() {
    return {
      data: {
        // 수정하기 전 원래 내용 불러오기
        title: this.board.title,
        content: this.board.content,
        }
      }
    },
    computed: {
    ...mapGetters(['board', 'isBoard', 'currentUser'])
    },
    methods: {
      ...mapActions(['fetchBoard', 'updateBoard']),
      onSubmit() {
        const payload = {
          pk: this.board.pk,
          ...this.data,
        }
        this.updateBoard(payload)
      }
    },
    created() {
      // board pk 어떻게 불러올지 생각하기
    // this.fetchBoard(this.board.pk)
    }



}

</script>

<style>
#ArticleView {
  width: auto;
  display: flex;
  flex-direction: column;
  justify-content:space-between;
  font-size: 20px;
}

#ArticleViewTop {
  width: auto;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}

#article-view-top-title{
  font-size:40px;
  font-weight:bold;
}

#article-view-top-date, #article-view-user{
  font-size: 15px;

}

#article-view-user {
    margin:none;
}

#ArticleViewMiddle{
  height: 300px;
  width: 100%;
  padding: 10px;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  margin-top: 10px;
  margin-bottom: 10px;
  background-color: #F9F7F7;
}

#like-button{
  background-color:transparent;
  color: black;
}

#article-view-update-button{
  width:auto; height:50px;
  background-color: #3282B8;
}

#article-view-delete-button{
  width:auto; height:50px;
  background-color: #B83232;
}

#article-view-back-button{
  width:auto; height:50px;
  background-color: #5fb832;
}

#article-view-middle-buttons{
  width: 100%;
  margin-top: 10px;
  margin-bottom: 10px;
}

#ArticleViewBottom {
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  margin-top: 10px;
  margin-bottom: 10px;
}

#ArticleViewBottom a{
  align-self: flex-end;
}

#CommentList {
  width: 100%;
  text-align:start;
  margin-top: 5px;
  margin-bottom: 5px;
}
</style>