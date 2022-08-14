<template>
<div class="page-content-wrapper py-3">
  <div class="shop-pagination pb-3">
    <div class="container">
      <div class="card">
        <div class="card-body p-2">
          <div class="d-flex align-items-center justify-content-between">
            <small class="ms-1">게시글 목록</small>
            <router-link to="/board/create"><button class="btn btn-primary btn-sm">게시글 작성</button></router-link>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="top-products-area product-list-wrap">
    <div class="container">
      <div class="row g-3">
        <div v-for="board in boards" :key="board" class="col-12">
          <div class="card single-product-card">
            <div class="card-body">
              <div class="d-flex align-items-center">
                <div class="card-side-img">
                </div>
                <div class="card-content px-4 py-2">
                  <a class="product-title d-block text-truncate mt-0" href="#">{{ board.title }}</a>
                  <p class="sale-price">{{ board.date[0]}}.{{ board.date[1] }}.{{ board.date[2] }}</p>
                  <router-link :to="{ name: 'boardDetail', params: {boardId: board.id }}">
                    <a class="btn btn-danger btn-sm disabled" href="#">
                      게시글 자세히 보기
                    </a>
                  </router-link>

                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="shop-pagination pt-3">
      <div class="container">
        <div class="card">
          <div class="card-body py-3">
            <nav aria-label="Page navigation example">
              <ul class="pagination pagination-two justify-content-center">
                <li class="page-item">
                  <a class="page-link" href="#" aria-label="Previous">
                    <i class="bi bi-chevron-left"></i>
                  </a>
                </li>
                <li class="page-item active">
                  <a class="page-link" href="#">1</a>
                </li>
                <li class="page-item">
                  <a class="page-link" href="#">2</a>
                </li>
                <li class="page-item">
                  <a class="page-link" href="#">3</a>
                </li>
                <li class="page-item">
                  <a class="page-link" href="#">...</a>
                </li>
                <li class="page-item">
                  <a class="page-link" href="#">9</a>
                </li>
                <li class="page-item">
                  <a class="page-link" href="#" aria-label="Next">
                    <i class="bi bi-chevron-right"></i>
                  </a>
                </li>
              </ul>
            </nav>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'

export default {
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