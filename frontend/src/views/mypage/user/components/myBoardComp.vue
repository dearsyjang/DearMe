<template>
  <div class="Board">
    <p class="title">내가 작성한 게시글 ▼ </p>
    <my-board-list-comp class="d-flex justify-content-around"></my-board-list-comp>
  </div>
</template>
<script>
import MyBoardListComp from './myBoardListComp.vue'
export default {
  components: {
    MyBoardListComp
  },
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
<style scoped>
  p {
    text-align: left;
    color: #1E2022;
  }
</style>
