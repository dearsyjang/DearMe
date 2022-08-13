<template>
  <div>
    <div v-for="comment in comments" :key="comment">
      <div>
        <p>댓글 | 작성자 {{ comment.user_id }}</p>
        <p>{{ comment.contents }}</p>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  props: {
    comments: Object
  },
  components: {},
  data() {
    return {
      sampleData: ''
    }
  },
  setup() {},
  created() {},
  mounted() {},
  unmounted() {},
  methods: {}
}
</script>
