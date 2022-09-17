<template>
<div class="page-content-wrapper py-3 board-bg">
  <div class="shop-pagination pb-3">
    <div class="container">
      <div class="card ">
        <div class="card-body p-2">
          <div class="d-flex align-items-center justify-content-between">
            <!--카드들이 다 왜 이래...?!-->
            <!--페이지네이션...?!-->
            <div>
              <small class="ms-1 board-text-index">상담사 리스트</small>
            </div>
            <div>
              <div class="filter-button" id = "filter-btn" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasBottom" aria-controls="offcanvasBottom">
                <i class="bi bi-funnel-fill"></i>
              </div>
              <div class="offcanvas offcanvas-bottom" tabindex="-1" id="offcanvasBottom" aria-labelledby="offcanvasBottomLabel">
                <div class="offcanvas-header">
                  <h5 class="offcanvas-title" id="offcanvasBottomLabel">상담사 필터 설정</h5>
                  <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                </div>
                <div class="offcanvas-body small">
                  <form @submit.prevent="onSubmit()" >
                    <div class="filter-title">정렬</div>
                      <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" id="1" value="true" name="radio1" v-model="filter.reviewScoreUp">
                        <label class="form-check-label" for="1">
                          별점 높은 순
                        </label>
                      </div>
                      <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" id="8" value="true" name="radio1" v-model="filter.reviewCntDown">
                        <label class="form-check-label" for="8">
                          별점 적은 순
                        </label>
                      </div>
                      <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" id="2" value="true" name="radio1" v-model="filter.reviewCntUp">
                        <label class="form-check-label" for="2">
                          리뷰 많은 순
                        </label>
                      </div>
                      <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" id="9" value="true" name="radio1" v-model="filter.reviewCntDown">
                        <label class="form-check-label" for="9">
                          리뷰 적은 순
                        </label>
                      </div>
                        <br>
                      <br>
                      <hr>
                      <div class="filter-title">전문 분야</div>
                      <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" id="3" value="가족" name="radio2" v-model="filter.category">
                        <label class="form-check-label" for="3">
                        가족
                        </label>
                      </div>
                      <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" id="4" value="직장,진로" name="radio2" v-model="filter.category">
                        <label class="form-check-label" for="4">
                        직장, 진로
                        </label>
                      </div>
                      <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" id="5" value="연애,결혼" name="radio2" v-model="filter.category">
                        <label class="form-check-label" for="5">
                        연애, 결혼
                        </label>
                      </div>
                      <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" id="6" value="자기이해" name="radio2"  v-model="filter.category">
                        <label class="form-check-label" for="6">
                        자기 이해
                        </label>
                      </div>
                        <br>
                      <br>
                      <hr>
                      <div class="filter-title" >즐겨찾기</div>

                      <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="7" value="true" v-model="filter.favorite">
                        <label class="form-check-label" for="7">
                        즐겨찾기
                        </label>
                      </div>

                      <div class="bottom-btn my-4">
                      <button @click=resetFilter() type="reset" class="btn" id="reset-btn" >초기화하기</button>
                      <button type="submit" class="btn" id="apply-btn">적용하기</button>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
  </div>
  <div class="top-products-area product-list-wrap">
    <div class="container">
      <div class="row g-3">
        <div v-for="(counselor,idx) in counselors.data"
        :key="idx"
        :counselor="counselor" class="col-12">
        <counselor-list-item
        v-for="(counselor,idx) in counselors.data"
        :key="idx"
        :counselor="counselor">
      </counselor-list-item>
        </div>
      </div>
    </div>
    </div>
    </div>
</template>

<script>
  import CounselorListItem from '@/views/counselor/components/CounselorListItemComp.vue'
  import {mapActions, mapGetters} from 'vuex'

  export default {
    name: 'CounselorListView',
    components: {CounselorListItem},
    data () {
      return {
        filter: {
          reviewScoreUp: false,
          reviewCntUp: false,
          reviewScoreDown: false,
          reviewCntDown: false,
          category: '',
          favorite: false,
        },
      }
    },


    computed : {
    ...mapGetters(['counselors']),
    ...mapGetters(['searched_counselors']),
    ...mapGetters(['filtering_counselors'])

    },
    methods: {
    ...mapActions(['fetchCounselors']),
    ...mapActions(['filterCounselors']),
    ...mapActions(['searchCounselors']),

     onSubmit () {

     this.fetchCounselors(this.filter)

      this.reviewScoreUp=false,
      this.reviewCntUp=false,
      this.reviewScoreDown=false,
      this.reviewCntDown=false,
      this.category='',
      this.favorite=false
      console.log(this.filter)
      console.log(Boolean(this.filter.reviewCntDown))
      console.log(Boolean(this.filter.reviewCntUp  ))
      console.log(Boolean(this.filter.reviewScoreUp ))
      console.log(Boolean(this.filter.reviewScoreDown))
      console.log(this.filter.category)
      console.log(Boolean(this.filter.favorite  ))

    },
    resetFilter () {
      location.reload();
    }


    },

  created() {
    this.fetchCounselors()

  },
}
</script>



<style>

/* @import './assets/css/counselor-list.css'; */


.filter-img{
  width:20px;

}
#reset-btn{
  float:left;
  border: 1px solid;

}
.filter-title {
  font-size: 18px;
}

#apply-btn{
  float : right;
  background-color: #5B5792;
  color: white;
}
.bottom-btn{
   margin:auto;
   justify-content: space-around;
}
.counselor-img-top{
  opacity: 90%;
  width: 100%;
}
.list input {
  display: none;
}

.form-check-label{
  border : 2px solid #7f7cb2db ;
  border-radius : 20px;
  padding: 7px;
  width: 100px;
  margin-top: 10%;
  text-align: center;
  justify-content: center;
  margin-left: 35%;

}
.form-check-input{
  display: none;
}

.form-check :checked ~ label {
  -webkit-text-fill-color: white;
  background-color: #7f7cb2db;
}

#filter-btn{
  background-color: white ;
  border : 1px #7f7cb283;
  margin-left: 10%;
  color: black
}

#offcanvasBottom{
  height: 85%;
}
</style>