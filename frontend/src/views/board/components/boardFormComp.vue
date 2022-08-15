<template>
<div class="page-content-wrapper py-3 board-bg-sky">
  <div class="shop-pagination pb-3">
    <div class="container">
      <div class="card">
        <div class="card-body p-2">
          <div class="d-flex align-items-center justify-content-between">
            <small class="ms-1 board-text-index">게시글 작성</small>
            <div>
              <router-link to="/board"><button class="board-btn-index btn-sm mx-2">목록</button></router-link>
              <button @click="onSubmit()" class="board-btn-submit btn-sm ">저장</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="top-products-area product-list-wrap">
    <div class="container">
      <div class="row g-3">
          <div class="card single-product-card">
            <div class="card-body ">
              <div class=" ">
                <div class="form-group ">
                  <label class="form-label board-text-title board-input" for="exampleInputText">제목</label>
                  <input class="form-control board-input " v-model="data.title" id="exampleInputText" type="text" placeholder="제목을 입력하시오.">
                </div>
              </div>

              <div class="">
                <div class="">
                  <label class="form-label board-text-title" for="exampleInputText">내용</label>
                  <textarea class="form-control " v-model="data.contents" cols="20" rows="10" placeholder="내용을 입력하시오."></textarea>

                </div>
              </div>
            </div>
        </div>
      </div>
    </div>
  </div>
</div>
</template>

<script>
import { mapActions } from 'vuex'
export default {
  components: {},
  data() {
    return {
      data: {
        title: '',
        contents: ''
      }
    }
  },
  computed: {
  },
  methods: {
    ...mapActions(['createBoard']),
    onSubmit() {
      const subData = {
        'title': this.data.title,
        'contents': this.data.contents,
        // 'date': '2202/02/02'
      }
      console.log(subData)
      this.createBoard(subData)
      }
  },
  created() {},
  mounted() {},
  unmounted() {},
}
</script>

<style>
.board-input {
  widows: 100%;
}

</style>