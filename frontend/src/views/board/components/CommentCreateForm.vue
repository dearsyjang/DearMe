<template>
  <div id="CommentCreateView">
    <form @submit="commentCreate">
      <input v-model="commentContent" type="text" placeholder="댓글을 입력해주세요.">
      <button id="commit-create-button" type="submit" class="btn">댓글 등록</button>
    </form>    
  </div>
</template>

<script>
export default {

}
</script>

<style>
#CommentCreateView input{
  width: auto;
  margin: 0;
  display: inline-block;
}

.comment-create-button{
  align-self: flex-end;
}
</style>