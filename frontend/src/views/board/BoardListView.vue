<template>
    <div class="board-list container">
        <br>
        <h1>상담 게시판</h1>
        <router-link :to="{ name:'articleCreate' }"><button type="button" id="create-button" class="btn mb-3">새 글 작성</button></router-link> 
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
            <tr v-for="(row, idx) in list" :key="idx" v-on:click="onRowClicked">
                <td>{{ row.idx }}</td>
                <td>{{ row.title }}</td>
                <td>{{ row.author }}</td>
                <td>{{ row.created_at }}</td>
            </tr>
            </tbody>
        </table>
        </div>
    </div>
</template>

<script>
export default {
// 임시 게시글 데이터
  data() {
    return {
      list: {},
    }
  },
  mounted() {
    this.fnGetList()
  },
  methods: {
    onRowClicked(){
        // this.$router.push({ name: 'article', params: { articlePk: item.pk } })
        this.$router.push('/board/1')
    },

    fnGetList() {
      this.list = [
        {
            "idx":1,
            "title": "제목1",
            "author": "장수영",
            "created_at": "2022-08-04"
        },
        {
            "idx":2,
            "title": "제목2",
            "author": "장수영",
            "created_at": "2022-08-04"
        },
        {
            "idx":3,
            "title": "제목3",
            "author": "장수영",
            "created_at": "2022-08-04"
        },
        {
            "idx":4,
            "title": "제목4",
            "author": "장수영",
            "created_at": "2022-08-04"
        },
        {
            "idx":5,
            "title": "제목5",
            "author": "장수영",
            "created_at": "2022-08-04"
        },
        {
            "idx":6,
            "title": "제목6",
            "author": "장수영",
            "created_at": "2022-08-04"
        },
        {
            "idx":7,
            "title": "제목7",
            "author": "장수영",
            "created_at": "2022-08-04"
        },
        {
            "idx":8,
            "title": "제목8",
            "author": "장수영",
            "created_at": "2022-08-04"
        },
        {
            "idx":9,
            "title": "제목9",
            "author": "장수영",
            "created_at": "2022-08-04"
        },
      ]
    }
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