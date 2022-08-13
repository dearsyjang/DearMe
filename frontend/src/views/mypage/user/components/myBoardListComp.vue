<template>
<div class="container BoardList">
  <!-- {{ boards }} -->
  <div v-for="board in boards" :key="board" class="form-group row">
    <p class="col-sm-4">{{ board.title }}</p>
    <p class="col-sm-4">{{ board.date }}</p>
    <button class="col-sm-4 btn btn-primary">게시글</button>
  </div>
</div>
</template>
<script>
import { mapActions, mapGetters } from 'vuex'

export default {
  components: {},
  data() {
    return {
      sampleData: ''
    }
  },
  setup() {},
  created() {
    this.fetchBoards()
  },
  mounted() {},
  unmounted() {},
  methods: {
    // 나의 게시글 패치
    ...mapActions(['fetchBoards', 'fetchMyid']),
    mygroup() {
      // this.fetchBoards()
      // const boardAuthId = board.userid
      // const userId = this.myId
      // this.boards.filter()
    }

  },
  computed: {
    ...mapGetters(['boards', 'myId'])
  },
}
</script>
<style scoped>
  .BoardList {
    background-color: #F0F5F9;

  }
  p, button {
    width: 160px;
    display: table-cell;
  }
</style>