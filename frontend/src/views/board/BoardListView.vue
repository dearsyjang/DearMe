<template>
    <div class="board-list container">
        <br>
        <h1>상담 게시판</h1>
        <router-link to="/board/create"><button type="button" id="create-button" class="btn mb-3">새 글 작성</button></router-link>
      <div>
        <!-- <div class="col-md-6 col-xl-4">
          <div class="card bg-warning text-white mb-3">
            <div class="card-header">{{ board.}}</div>
            <div class="card-body">
              <h5 class="card-title text-white">Warning card title</h5>
              <p class="card-text">
                Some quick example text to build on the card title and make up.
              </p>
            </div>
          </div>
        </div> -->
        <table>
          <thead>
          <tr>
            <th>No</th>
            <th>nickName</th>
            <th>title</th>
            <th>hitCnt</th>
            <th>date</th>
          </tr>
          </thead>
          <tbody>
            <tr v-for="board in boards" :key="board.id">
              <td>{{ board.id }}</td>
              <td>{{ board.nickName }}</td>
              <!-- <td><router-link :to="{ name: 'boardDetail', params: { boardid: board.id }}">
              {{ board.title }}
              </router-link></td> -->
              <td>{{ board.title }}</td>
              <td>{{ board.hitCnt }}</td>
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
    this.fetchBoards()
  }

}
</script>


<style scoped>
/* .table{
    width: auto;
    color: #112D4E;
    border-style: solid;
    border: 3px solid #112D4E;
    border-color: #112D4E;
    background-color: #F9F7F7;
} */

#create-button{
  background-color: #31558C;
  color: white;
  float: right;
}
body {
  padding:1.5em;
  background: #f5f5f5
}

table {
  border: 1px #a39485 solid;
  font-size: .9em;
  box-shadow: 0 2px 5px rgba(0,0,0,.25);
  width: 100%;
  border-collapse: collapse;
  border-radius: 5px;
  overflow: hidden;
}

th {
  text-align: left;
  color: white;
}

thead {
  font-weight: bold;
  color: #fff;
  background: #31558C;
}

 td, th {
  padding: 1em .5em;
  vertical-align: middle;
}

 td {
  border-bottom: 1px solid rgba(0,0,0,.1);
  background: #fff;
}

a {
  color: #31558C;
}

 @media all and (max-width: 768px) {

  table, thead, tbody, th, td, tr {
    display: block;
  }

  th {
    text-align: right;
  }

  table {
    position: relative;
    padding-bottom: 0;
    border: none;
    box-shadow: 0 0 10px rgba(0,0,0,.2);
  }

  thead {
    float: left;
    white-space: nowrap;
  }

  tbody {
    overflow-x: auto;
    overflow-y: hidden;
    position: relative;
    white-space: nowrap;
  }

  tr {
    display: inline-block;
    vertical-align: top;
  }

  th {
    border-bottom: 1px solid #a39485;
  }

  td {
    border-bottom: 1px solid #e5e5e5;
  }


  }
  .row {
    flex-shrink: 0;
    width: 100%;
    max-width: 100%;
    padding-right: calc(var(--bs-gutter-x)*.5);
    padding-left: calc(var(--bs-gutter-x)*.5);
    margin-top: var(--bs-gutter-y);
}
</style>