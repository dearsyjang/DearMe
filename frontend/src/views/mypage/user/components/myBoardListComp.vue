<template>
<div class="page-content-wrapper py-3">
  <div class="blog-wrapper direction-rtl">
    <div class="container">
      <div class="row g-3">
        <div v-for="board in boards" :key="board" class="col-6 col-sm-4 col-md-3">
          <div class="card position-relative shadow-sm">
            <div class="card-body">
              <router-link :to="{ name: 'boardDetail', params: {boardId: board.id }}">
              <span class="badge bg-danger rounded-pill mb-2 d-inline-block"><i class="bi bi-hand-thumbs-up-fill"></i> {{ board.hitCnt}}</span>
              <h4 class="blog-title d-block text-dark board-title">{{ board.title }}</h4>
              </router-link>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</template>
<script>
// import { mapActions, mapGetters } from 'vuex'

export default {
  props: {
    boards: Object
  },
  components: {},
  data() {
    return {
      sampleData: ''
    }
  },
  setup() {},
  created() {
    // this.fetchBoards()
  },
  mounted() {},
  unmounted() {},
  // methods: {
  //   // 나의 게시글 패치
  //   ...mapActions(['fetchBoards', 'fetchMyid']),
  //   mygroup() {
  //     // this.fetchBoards()
  //     // const boardAuthId = board.userid
  //     // const userId = this.myId
  //     // this.boards.filter()
  //   }

  // },
  // computed: {
  //   ...mapGetters(['boards', 'myId'])
  // },
}
</script>
<style >

  .w-btn-outline {
    /* position: relative; */
    border: none;
    min-width: 60px;
    min-height: 20px;
    text-decoration: none;
    font-weight: 400;
    font-size: 15px;
    transition: 0.25s;
    border-radius: 15px;
    color: darkslategray;
    cursor: pointer;
    font-weight: 500;
    transition: 0.3s;
}

.w-btn-yellow-outline {
    border: 2px solid #595892;
    color: #595892;
}
/* .mypage-card {
  background-color: #F9F7F7;
  border-radius: 15px;
} */
.mypage-card-bord {
  background-color: #F9F7F7;
  border-radius: 15px;
  border: #595892 solid 1px;
}
</style>