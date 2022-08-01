<template>
  <div>
    <h1>상담사 리스트 페이지</h1>



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
<!-- <script>
  import CounselorListItemComp from '@/views/counselor/components/CounselorListItemComp.vue'
  import { mapActions, mapGetters } from 'vuex'
  export default {
    name : 'CounselorDetailView',
    components: {CounselorListItemComp},
    setup () {
      const state = ({
        inputData: '',
      })
      const search = () =>{
        if (this.inputData) {
        this.$store.dispatch('searchCounselor', this.inputData)
        this.isempty = false
        }
        else{
          alert('내용을 입력해주세요!!')
    }
      }
      
      return {
        search,
        state
      }
    },
  computed:{
    ...mapGetters(['searched_counselor'])

  },
  methods:{
     ...mapActions([
    'searchCounselor',]),
   

  check : function(arr)  {
  if(Array.isArray(arr) && arr.length === 0)  {
    return true;
  }
  return false;
  }

  },
  }
</script> -->
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
      }
    },
  computed:{
    ...mapGetters(['searched_counselor']),

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

    ...mapActions(['searchCounselor',]),
    
   

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
</style>