<template>
    <div class="board-list container">
        <br>
        <h1>상담 게시판</h1>
        <router-link to="/board/create"><button type="button" id="create-button" class="btn mb-3">새 글 작성</button></router-link>
        <div>
        <table class="table table-hover">
            <thead>
            <tr>
            <th>No</th>
            <th>제목</th>
            <th>작성자</th>
            <th>등록일시</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="board in boards" :key="board.boardid">
                <td>{{ board.boardid }}</td>
                <td>{{ board.title }}</td>
                <td>{{ board.nickname }}</td>
                <td>{{ board.date }}</td>
            </tr>
            </tbody>
        </table>
        </div>
    </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'

export default {
// 임시 게시글 데이터
  computed: {
    ...mapGetters(['boards'])
  },
  methods: {
    ...mapActions(['fetchBoards'])
  },
  created() {
    // this.fetchArticles()
  }

}
</script>


<style scoped>
.table{
    width: auto;
    color: #112D4E;
    border-style: solid;
    border: 3px solid #112D4E;
    border-color: #112D4E;
    background-color: #F9F7F7;
}

#create-button{
  background-color: #769FCD;
  float: right;
}
</style>