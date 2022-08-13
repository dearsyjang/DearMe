<template>
  <div>
    <form @submit.prevent="onSubmit()">
      <textarea name="comment" id="comment" cols="80" rows="4" v-model="contents" placeholder="댓글을 입력해 주세요." required>
      </textarea>
      <div>
        <button type="submit" class="comment-btn">등록</button>
      </div>
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
      this.createComment({
        contents: this.contents
      })
      this.contents = ''
    }
  }
}
</script>

<style>

</style>
