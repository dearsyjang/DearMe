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
     카운슬러 목록 기모링~

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

    computed : {
    ...mapGetters(['counselors']),
    ...mapGetters(['searched_counselors']),
    ...mapGetters(['filtering_counselors'])
    },
    methods: {
    ...mapActions(['fetchCounselors']),
    ...mapActions(['filterCounselors']),
    ...mapActions(['searchCounselors']),

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



</style>