<template>
<div class="container">
  <div class="row">
    <div class="container direction-rtl my-4">
        <div class="row my-2" v-for="board in boards" :key="board">
          <div class="card">
            <div class="card-body">
              <div class="row"  >
                <p class="col-sm-2" id="boardele">{{ board.title }}</p>
                <p class="col-sm-2" id="boardele">{{ board.date[0] }}.{{ board.date[1] }}.{{ board.date[2] }}</p>
                <!-- <a class="btn col-sm-4 btn-round btn-secondary" href="#">게시글</a> -->
                <button class="col-sm-2 btn btn-primary" id="boardele">게시글</button>
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
<style scoped>
  #boardele {
    width: 110px;
  }
</style>