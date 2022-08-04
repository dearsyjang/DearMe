<template>
  <div id="article-form">
    <br>
    <h1>게시글 작성하기</h1>
    <!--v-if="action"==""으로 작성, 수정 구분해주기-->
    <hr>
    <div class="container">
        <h4 id="article-form-title-text">제목</h4> 
        <form class="article-form">
            <input id="article-form-title" type="text" v-model="title" placeholder="제목을 입력해주세요.">
            <br>
            <br>
            <h4 id="article-form-content-text">내용</h4>
            <textarea id="article-form-content" rows="6" max-rows="'6" v-model="contents" placeholder="내용을 입력해주세요."></textarea>
            <br>
            <div>
                <button type="button" class="btn" id="article-form-submit-button" v-on:click="fnSave">저장</button>
                <router-link :to="{ name: 'board' }"><button button type="button" class="btn" id="article-form-cancel-button">취소</button></router-link>
            </div>
        </form> 
    </div>
  </div>
</template>

<script>
export default {

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