<template>
  <div>
    <div class="container">
      <span class="board-text-bold form-label board-text-title" id="toc-toggle" @click="openCloseToc()">내가 작성한 게시글 <i class="bi bi-caret-down-fill"></i></span>
      <span class="badge mypage-badge rounded-pill mx-1">{{ boards.length }}</span>
      <my-board-list-comp :boards="boards" id="toc-content" ></my-board-list-comp>
    </div>
  </div>
</template>
<script>
import { mapActions, mapGetters } from 'vuex'
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
  created() {
    this.fetchBoards()
  },
  mounted() {},
  unmounted() {},
  methods: {
    ...mapActions(['fetchBoards', 'fetchMyid']),

    openCloseToc: function() {
    if(document.getElementById('toc-content').style.display === 'block') {
      document.getElementById('toc-content').style.display = 'none';
    } else {
      document.getElementById('toc-content').style.display = 'block';
    }
  }
  },
  computed: {
    ...mapGetters(['boards', 'myId'])
  },
}
</script>
<style scoped>
   #toc-content {
    display: none;
  }
  #toc-toggle {
    cursor: pointer;
    color: black;
  }
  #toc-toggle:hover {
    text-decoration: none;
  }
  .mypage-badge{
    background-color: #595892;
  }
</style>
