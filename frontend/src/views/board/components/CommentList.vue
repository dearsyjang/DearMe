<template>
    <div>
        // 이 페이지는 수정사항이 많음
        <p>댓글 보는 페이지입니다</p>
        <button class="comment-btn" @click="onUpdate()">Edit</button>
        <button class="comment-btn" @click="deleteComment(payload)">Delete</button>
    </div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex'
export default {
data() {
    return {
      isEditing: false,
      payload: {
        articlePk: this.comment.article,
        commentPk: this.comment.pk,
        content: this.comment.content
      }
    }
  },
  computed: {
    ...mapGetters(['currentUser']),
  },
  methods: {
    ...mapActions(['updateComment', 'deleteComment']),
    switchIsEditing() {
      this.isEditing = !this.isEditing
    },
    onUpdate() {
      this.updateComment(this.payload)
      this.isEditing = false
    },
  }

}
</script>

<style>

</style>