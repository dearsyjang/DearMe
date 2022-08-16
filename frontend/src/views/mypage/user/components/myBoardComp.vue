<template>
  <div>
    <div class="container">
      <span class="board-text-bold form-label board-text-title" id="toc-toggle" @click="openCloseToc()">내가 작성한 게시글 <i class="bi bi-caret-down-fill"></i></span>
      <span class="badge mypage-badge rounded-pill mx-1">{{ this.myboard.length }}</span>
      <my-board-list-comp :boards="this.myboard" id="toc-content" ></my-board-list-comp>
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
      myboard: []
    }
  },
  setup() {},
  created() {
    
  },
  mounted() {
    this.findMyBoard()
  },
  unmounted() {},
  methods: {
    ...mapActions(['fetchBoards', 'fetchMyid']),

    openCloseToc: function() {
    if(document.getElementById('toc-content').style.display === 'block') {
      document.getElementById('toc-content').style.display = 'none';
    } else {
      document.getElementById('toc-content').style.display = 'block';
    }
  },
  findMyBoard() {
    this.fetchBoards()
    // console.log(this.currentUser.data.nickname)
    let MYBOARD = []
    for(var i = 0; i < this.boards.length; i++) {
      if (this.boards[i].nickName === this.currentUser.data.nickname){
        MYBOARD.push(this.boards[i])
      }
    }
    console.log(MYBOARD)
    this.myboard = MYBOARD
    console.log(this.myboard)
  }
  },
  computed: {
    ...mapGetters(['boards', 'myId', 'currentUser'])
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
