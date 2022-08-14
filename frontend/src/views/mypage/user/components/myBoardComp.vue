<template>
  <div class="Board">
    <div class="container">
      <span id="toc-toggle" @click="openCloseToc()">내가 작성한 게시글 ▼ </span>
      <span class="badge bg-primary rounded-pill">{{ boards.length }}</span>
    </div>
    <my-board-list-comp :boards="boards" id="toc-content" ></my-board-list-comp>
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
</style>
