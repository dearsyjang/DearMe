<template>
  <div id="CommentCreateView">
    <form @submit="commentCreate">
      <input v-model="contents" type="text" placeholder="댓글을 입력해주세요.">
      <button @click="onSubmit()" id="commit-create-button" type="submit" class="btn">댓글 등록</button>
    </form>
  </div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex'
export default {
  data() {
    return {
      contents: ''
    }
  },
  computed: {
    ...mapGetters(['board']),
  },
  methods: {
    ...mapActions(['createComment']),
    onSubmit() {
      let formData = new FormData()
      formData.append('contents', this.contents)
      const boardPk = this.board.pk
      // post 요청할 내용은 폼데이터로 보내고 pk는 다른 형식으로 보냄
      this.createComment({ boardPk, formData })
      this.contents = ''
    }
  }


}
</script>

<style scoped>
#CommentCreateView input{
  width: auto;
  margin: 0;
  display: inline-block;
  z-index: 1000;
}

.comment-create-button{
  align-self: flex-end;
}

form{
  width: auto;
}
</style>