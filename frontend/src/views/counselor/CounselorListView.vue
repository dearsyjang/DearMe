<!-- <template>
  <div>
    <h1>상담사 리스트 페이지</h1>
    
    <div id="counselorListMain">
      <div id="counselorListSelectBar">
        <div class="select-bar">
          <select v-model="filter" @change="selectFilter" class="form-select rounded-pill"  aria-label="Default select example" style="40px">
            <option class="select-item" hidden="" disabled="disabled" selected="selected" value="">상담사 필터</option>         
            <option class="select-item" value=1>별점 높은 순</option>
            <option class="select-item" value=2>리뷰 많은 순</option>
            <option class="select-item" value=3>즐겨찾기</option>
          </select>
        </div>
      </div>
    </div>
    <div v-if="!isempty">
      <div v-if="check(filtering_counselors)">
      </div>
      <div v-else>
        <div class="counselor-list row row-cols-2 row-cols-md-5 g-3">
          <counselor-list-item-comp
          v-for="(counselor,idx) in filtering_counselors"
          :key="idx"
          :counselor="counselor">
          </counselor-list-item-comp>
        </div>
      </div>
    </div>

    <div class="search-counselor">
      <span>[상담사검색] </span>
      <input type="text"
      v-model.trim="inputData"
      @keyup.enter="search">
      <button @click="search">검색</button>
      <hr>
      <div v-if="!isempty">
        <div v-if="check(searched_counselor)">        
          <h2>검색 결과가 없습니다. </h2>   
        </div>
        <div v-else>
          <div class="counselor-list row row-cols-2 row-cols-md-5 g-3">
          <counselor-list-item-comp
          v-for="(counselor,idx) in searched_counselor"
          :key="idx"
          :counselor="counselor">
          </counselor-list-item-comp>
          </div>
        </div>
      </div>
    </div>  

    <div class="counselor-list">
      <counselor-list-item-comp
      v-for="temp in temps"
      :key="temp.pk"
      :temp="temp">
      </counselor-list-item-comp>
    </div>

  </div>
</template>

<script>
  import CounselorListItemComp from '@/views/counselor/components/CounselorListItemComp.vue'
  import { mapActions, mapGetters } from 'vuex'
  export default {
    name : 'CounselorDetailView',
    components: {CounselorListItemComp},
    data: function() {
    return {
      isempty:true,
      inputData:'',
      filter:''
 
      }
    },
  computed:{
    ...mapGetters(['searched_counselor', 'filtering_counselors']),

    temps() {
      return this.$store.state.temps
    }
  },
  methods:{
    search :function() {
        if (this.inputData) {
        this.$store.dispatch('searchCounselor', this.inputData)
        this.isempty = false
        }
        else{ alert('내용을 입력해주세요!!')
      }
    },

    selectFilter: function (){
    this.$store.dispatch('filterCounselor',this.filter)
    this.isempty = false
    },

    ...mapActions(['searchCounselor','filterCounselor']),
    
   

    check : function(arr)  {
    if(Array.isArray(arr) && arr.length === 0)  {
      return true;
    }
    return false;
    }

  },
  }
</script>
<style>
.counselor-list{
 
  width : 500px;
  margin: auto;
}
</style> -->



<template>
  <div>
    
      <img src = "@/assets/images/counselor.jpeg" class="counselor-img"/>
      <hr>
      <div class="counselor-list-top">
      
      <button class="filter-button" id = "filter-btn" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasBottom" aria-controls="offcanvasBottom"> 
    
      <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-sliders2" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M10.5 1a.5.5 0 0 1 .5.5v4a.5.5 0 0 1-1 0V4H1.5a.5.5 0 0 1 0-1H10V1.5a.5.5 0 0 1 .5-.5ZM12 3.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 0 1h-2a.5.5 0 0 1-.5-.5Zm-6.5 2A.5.5 0 0 1 6 6v1.5h8.5a.5.5 0 0 1 0 1H6V10a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5ZM1 8a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 0 1h-2A.5.5 0 0 1 1 8Zm9.5 2a.5.5 0 0 1 .5.5v4a.5.5 0 0 1-1 0V13H1.5a.5.5 0 0 1 0-1H10v-1.5a.5.5 0 0 1 .5-.5Zm1.5 2.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 0 1h-2a.5.5 0 0 1-.5-.5Z"/>
</svg></button>
      </div>
      <div class="offcanvas offcanvas-bottom" tabindex="-1" id="offcanvasBottom" aria-labelledby="offcanvasBottomLabel">
        <div class="offcanvas-header">
          <h5 class="offcanvas-title" id="offcanvasBottomLabel">상담사 필터 설정</h5>
        
          <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
        </div>
        <div class="offcanvas-body small">


          <form @submit.prevent="onSubmit" >

            <p2 >정렬</p2>
            <br><br>
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
           
              <p2 >전문 분야</p2>
              <br><br>
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
             
              <p2 >즐겨찾기</p2>
              <br>
                      <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" id="7" value="true" v-model="filter.favorite">
                <label class="form-check-label" for="7">
                즐겨찾기
                </label>
              </div>
                <br>
            
          

          <!-- <div id="counselorListMain">
            <div id="counselorListSelectBar">
              <div class="select-bar">
                <select v-model="align" class="form-select rounded-pill"  aria-label="Default select example" style="40px">
                  <option class="select-item" hidden="" disabled="disabled" selected="selected" value="">상담사 필터</option>         
                  <option class="select-item" value=1>별점 높은 순</option>
                  <option class="select-item" value=2>리뷰 많은 순</option>
                </select>
              </div>
            </div>
          </div>

          <div id="counselorListMain">
            <div id="counselorListSelectBar">
              <div class="select-bar">
                <select v-model="categories"  class="form-select rounded-pill"  aria-label="Default select example" style="40px">
                  <option class="select-item" hidden="" disabled="disabled" selected="selected" value="">상담사 필터</option>         
                  <option class="select-item" value=3>가족</option>
                  <option class="select-item" value=4>직장,진로</option>
                  <option class="select-item" value=5>연애,결혼</option>
                  <option class="select-item" value=6>자기이해</option>   
                </select>
              </div>
            </div>
          </div> -->
          <hr>
          <div class="bottom-btn">
          <button @click=resetFilter() type="reset" class="btn" id="reset-btn" >초기화하기</button>
          <button type="submit" class="btn" id="apply-btn">적용하기</button>
          </div>
          </form>
          
        </div>
      </div>



    
        <hr>
    
    <counselor-list-item 
      v-for="(counselor,idx) in counselors.data"
      :key="idx"
      :counselor="counselor">
    </counselor-list-item>
    
  
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
          favorite: false
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
      // if (this.filter.reviewCntDown 
      // ||this.filter.reviewCntUp 
      // ||this.filter.reviewScoreUp
      // ||this.filter.reviewScoreDown
      // ||this.filter.category 
      // ||this.filter.favorite)  {  this.$store.dispatch('fetchCounselors',this.filter)}
      // else if (this.filter.reviewCntUp) {this.$store.dispatch('fetchCounselors',this.filter)}
      // else if (this.filter.reviewScoreUp) {this.$store.dispatch('fetchCounselors',this.filter)}
      // else if (this.filter.reviewScoreDown) {this.$store.dispatch('fetchCounselors',this.filter)}
      // else if (this.filter.category) {this.$store.dispatch('fetchCounselors',this.filter)}
      // else if (this.filter.favorite) {this.$store.dispatch('fetchCounselors',this.filter)}
    },
    resetFilter () {
      location.reload();
    }
    
    // search :function() {
    //     if (this.inputData) {
    //     this.$store.dispatch('searchCounselor', this.inputData)
    //     this.isempty = false
    //     }
    //     else{ alert('내용을 입력해주세요!!')
    //   }
    // }, 
  //   selectFilter: function (){
  //   this.$store.dispatch('filterMovie',this.filter)
  //   this.isempty = false
  //  },

  //   check : function(arr)  {
  //   if(Array.isArray(arr) && arr.length === 0)  {
  //     return true;
  //   }
  //   return false;
  //   }
    },
    
  created() {
    this.fetchCounselors()
  
  },
}
</script>



<style>

/* @import './assets/css/counselor-list.css'; */

.list {
  display: flex;
  flex-direction: row-reverse;
  justify-content: space-around;
  text-align: center;

}
.filter-img{
  width:20px;
  
}
#reset-btn{
  float:left;
  border: 1px solid;

}

#apply-btn{
  
  float : right;
  background-color: black;
  color: white;
}
.bottom-btn{
   margin:auto;
   justify-content: space-around;
}
.counselor-img{
  opacity: 90%;
  width: 100%;
}
.list input {
  display: none;
}

.form-check-label{
  border : 2px solid;
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
  background-color: rgb(130, 174, 231);
 
}



#filter-btn{
  background-color:  rgb(247, 247, 247);
  border : 1px black;
  margin-left: 10%;
  color: black
}

#offcanvasBottom{
  height: 85%;
}
</style>