<template>
  <div>
    <h2>상담사 프로필 페이지</h2>
    
    <router-link to="/counselors/request">
      <button>상담 신청</button>
    </router-link>
    <div class="counselor-profile">
      <div class="card">
        <div class="card mb-3" style="max-width: 540px;">
          <div class="row g-0">
            <div class="col-md-4">

               <p class="card-title">{{counselor.pic}}</p> 
               <p class="card-title">{{counselor.nickName}}</p> 
            </div>
            <div class="col-md-8">
              <div class="card-body">
                <!-- <span v-if="currentUser.id === profile.user.id >   -->
                <button class="createinfo" v-if="isdone==false" @click="isModalViewed=true">자기소개 작성하기</button>
                <!-- </span>  -->
                <div class="counselor-info">
                  <info-item-comp v-for="info in infos"
                  :key="info.Content"
                  :info="info"></info-item-comp>
                 <!-- {{counselor.info}}  -->
                 {{counselor.careers}}
                 {{counselor.categories}}
                 {{counselor.certificates}}
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div v-if="!favorite">
        <button class="btn btn-link" @click="favoriteCounselor(counselorId)"><i class="fa-solid fa-heart" style="color:black"></i></button>
      </div>
      <div v-else>
        <button class="btn btn-link" @click="favoriteCounselor(counselorId)"><i class="fa-solid fa-heart" style="color:red"></i></button>
      </div>
      
      <div class="counselor-info-create">
        <div class="black-bg" v-if = "isModalViewed==true">
        <div class="white-bg">
          <form @submit.prevent="createInfo" class="info-create-form">
            <div class="my-3 w-100 d-flex justify-content-start align-items-center ">
              <label for="review">자기소개 작성</label>
              
              <input  type="text" id="review"  style="width:85%; height:300px " v-model="infoContent" required>
            </div>
            <hr>
            <button class="changebtn" >작성하기   </button> <button class="changebtn" @click="isModalViewed=false">닫기</button>
          </form>
          
        </div>
        </div>
      </div>
    



      <!-- <span v-if="currentUser.type === student"> 
        <button>개인상담신청하기</button>
        </span> -->
      <div class="price">
        <h4>상담 가격</h4>
        <div class="personal-price" 
        v-if ="ispersonalpriced==false"
        @keyup.enter="ispersonalpriced=true">
          <li>개인상담 : <input type="text">point</li>
        </div>
        <div v-else>
          개인상담가격띄워야됨
          <!-- {{counselor.price}} -->
        </div> 
      </div>

<!-- 
      
      <h4>전문분야</h4>
      <div class="category-list row row-cols-2 row-cols-md-5 g-3">
        <span v-for="category in counselor.categories" 
        :key="category.key">
        {{category.name}}
        </span> 
      </div>
     
      <div class="career-list row row-cols-2 row-cols-md-5 g-3">
        <span v-for="career in counselor.careers" 
        :key="career.key">
        {{career.name}}
        {{career.date}}
        </span> 
      </div>

      <div class="manage-group-list row row-cols-2 row-cols-md-5 g-3">
        <span v-for="group in counselor.groups" 
        :key="group.key">
        {{group.name}}
        </span> 
      </div>

      <div class="review-list row row-cols-2 row-cols-md-5 g-3">
        <span v-for="review in counselor.reviews" 
        :key="review.key">
        {{review.content}}
        </span> 
      </div> -->


      <career-list-comp>
      </career-list-comp>
      <manage-group-list-comp>
      </manage-group-list-comp>
      <review-list-comp>
      </review-list-comp>
      
      <file-list-comp>
      </file-list-comp>

     
     

    </div>
  </div>
</template>
<script>
  import InfoItemComp from '@/views/counselor/components/InfoItemComp.vue'
  import CareerListComp from '@/views/counselor/components/CareerListComp.vue'
  import FileListComp from '@/views/counselor/components/FileListComp.vue'
  import ManageGroupListComp from '@/views/counselor/components/ManageGroupListComp.vue'
  import ReviewListComp from '@/views/counselor/components/ReviewListComp.vue'



  import { mapActions,mapGetters} from 'vuex'


  export default {
    name : 'CounselorDetailView',
    components: {
    CareerListComp,
    FileListComp,
    ManageGroupListComp,
    ReviewListComp,
    InfoItemComp,
   
},

    data() {
      return {
        counselorId: this.$route.params.id,
        isModalViewed: false,
        infoContent:'',
        isdone : false,
        ispersonalpriced: false,
        isgrouppriced: false,
        ismaked: false,
  
      }
    },
    computed : {
      ...mapGetters(['counselor','currentUser', 'favorite']),
      infos() {
      return this.$store.state.infos
    }
    },
    methods: {
      ...mapActions(['fetchCounselor','favoriteCounselor','isfavorite']),
    
      

      createInfo(){
        if (this.isdone === false){
        
        const newInfo = {
          Content: this.infoContent,
          isdone : this.isdone=true
        }
        this.$store.dispatch('createInfo',newInfo)
        this.infoContent=''
        alert('작성이 완료되었습니다')
          }
        else{
      
        alert('자기소개는 1개 작성 가능합니다!!')
        }
      },
    },
    created() {
      this.fetchCounselor(this.counselorId)
      this.favorite =''
      },
  }
</script>


<style>
.counselor-profile {
  margin:auto;
  text-align: center;
}
.price {
  border : solid black 1px;
  margin : auto;
  margin-top : 20px;
}
.counselor-info {

  margin: auto;

}

div {
  box-sizing : border-box;

}

.black-bg {
  width: 100% ; height : 100%;
  background : rgba(0,0,0,0.5);
  position : fixed; padding : 20px;

}
.white-bg {
  width: 100% ; 
  background :white ;
  border-radius:8px; 
  padding : 20px;

}
.card {
  margin: auto
}



</style>
