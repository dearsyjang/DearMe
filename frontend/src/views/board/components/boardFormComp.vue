<template>
  <div class="page-content-wrapper py-3">
  <div class="shop-pagination pb-3">
    <div class="container">
      <div class="card">
        <div class="card-body p-2">
          <div class="d-flex align-items-center justify-content-between">
            <small class="ms-1">게시글 작성</small>
            <div>
              <router-link to="/board"><button class="btn btn-primary btn-sm">목록</button></router-link>
              <button @click="onSubmit()" class="btn btn-danger btn-sm mx-3">저장</button>
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
            <div class="card-body">
              <div class="d-flex align-items-center">
                <div class="form-group">
                  <label class="form-label" for="exampleInputText">제목</label>
                  <input class="form-control" v-model="data.title" id="exampleInputText" type="text" placeholder="제목을 입력하시오.">
                </div>
              </div>
              <div class="d-flex align-items-center">
                <div class="form-group">
                  <label class="form-label" for="exampleInputText">내용</label>
                  <input class="form-control" v-model="data.contents" id="exampleInputText" type="text" placeholder="내용을 입력하시오.">
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
#article-form-title, #article-form-content {
    width: 100%;
}

#article-form-title-text, #article-form-content-text{
  text-align: start;
}

#article-form-submit-button {
  width:auto; height:50px;
  background-color: #3282B8;
  margin: 3px;
  outline: none;
}

#article-form-cancel-button{
  width:auto; height:50px;
  background-color: #B83232;
  margin: 3px;
  outline: none;
}

</style>