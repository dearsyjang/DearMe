<template>
<div class="page-content-wrapper py-3 board-bg">
  <div class="shop-pagination pb-3">
    <div class="container">
      <div class="card ">
        <div class="card-body p-2">
          <div class="d-flex align-items-center justify-content-between">
            <small class="ms-1 board-text-index">게시글 목록</small>
            <router-link to="/board/create"><button class="board-btn-submit btn-sm">게시글 작성</button></router-link>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="top-products-area product-list-wrap">
    <div class="container">
      <div class="row g-3">
        <div v-for="board in boards" :key="board" class="col-12">
          <div class="card " >
            <div class="board-card-radius card-body board-card-bg">
               <router-link :to="{ name: 'boardDetail', params: {boardId: board.id }}">
               <h3 class="card-title">{{ board.title }}</h3>
               </router-link>
              <p class="card-text text-end ">{{ board.date[0]}}.{{ board.date[1] }}.{{ board.date[2] }}</p>
              <!-- <router-link :to="{ name: 'boardDetail', params: {boardId: board.id }}">
                <a class="board-btn-detail btn-sm" href="#">
                  게시글 자세히 보기
                </a>
              </router-link> -->
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
  data() {
    return {
      pageNum : [1, 2, 3, 4, 5]
    }
  },
  computed: {
    ...mapGetters(['boards'])
  },
  methods: {
    ...mapActions(['fetchBoards'])
  },
  created() {
    console.log()
    this.fetchBoards()
  }

}
</script>


<style>

.board-list-title {
  font-weight: xx-large;
}
.board-card-bg {
  background-color: white;
  color : white
}
.board-card-radius {
  border-radius: 30%;
}
</style>