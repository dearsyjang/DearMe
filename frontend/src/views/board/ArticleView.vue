<template>
  <div id="ArticleView" class="container">
    <br>
    <!--데이터 연결하기-->
    <div id="ArticleViewTop">
        <h3 id="article-view-top-title">제목</h3>
        <p id="article-view-top-date">작성일: </p>
        <p id="article-view-user">작성자: </p>
    </div>

    <div id="ArticleViewMiddle">
        <p>게시글 내용</p>
    </div>
    
    <div>
        <!--버튼 if -->
        <button id="article-view-update-button" class="btn m-1">수정하기</button>
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
    
  </div>

</template>

<script>
import CommentCreateForm from './components/CommentCreateForm.vue'
// import CommentList from './components/CommentList.vue'

export default {
  components: { 
    // CommentList, 
    CommentCreateForm 
    },
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