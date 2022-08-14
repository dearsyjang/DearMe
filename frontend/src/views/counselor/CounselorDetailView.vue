<template>
  <div>
  <div>
    <!-- {{currentUser.data}} -->
    <!-- {{groups}} -->

    <h2>상담사 프로필 페이지</h2>
    <!-- <router-link :to="{ name: 'counselingReview', params : {counselorId : counselor.data.userId}}">
                <button>리뷰 쓰러가는 버튼! 상담 나가기에 버튼 달아도 되고 종료시 라우터 푸시로 해도됨</button>
                </router-link> -->
    <router-link to="/counseling-request"  >
      <button v-if="currentUser.data.type==`USER`">상담 신청</button>
    </router-link>
    <div class="counselor-profile">
      <div class="card">
        <div class="card mb-3" style="max-width: 540px;">
          <div class="row g-0">
            <div class="col-md-4">
               
               <p class="card-title">상담사 사진 : {{counselor.data.picUrl}}</p> 
               <p class="card-title">상담사 이름 : {{counselor.data.nickName}}</p> 
            </div>
            <div class="col-md-8">
              <div class="card-body">
<!--             
                <button class="createinfo" v-if="currentUser.id === profile.user.id && isdone==false" @click="isModalViewed=true">작성하기</button>
                <button v-else>개인상담신청하기</button> -->
                
                <!--{{favorite.data}} -->



                <!-- <div v-for="(f,idx) in favorite.data"
                :key="idx"
                :f="f">
                {{f}} -->
                <!-- <div v-if="check(counselorId !=counselor.data.userId)==true" >
                  <button class="btn btn-link" style="color: black " @click="favoriteAdd(counselor.data.userId)">★
                  </button>
                </div>
                

                <div v-else> 
                  <button class="btn btn-link" style="color: red" @click="favoriteDelete(f.id)">★
                  </button>
                </div> -->
                
                <!-- </div>  -->
=
                

                <div>자기소개 : {{counselor.data.introduce}}</div>
              </div>
              </div> 
                <div class="counselor-info">
                  <!-- <info-item-comp v-for="info in infos"
                  :key="info.Content"
                  :info="info"></info-item-comp> -->
                
                

                <hr>
                <div>개인상담가격 : {{counselor.data.price}} </div>
                <!-- <button class="add-button"   v-if="counselor.data.nickName==currentUser.data.nickname" @click="deleteCertificate(c.id)">개인상담가격수정</button> -->
                <br>
                <br>



                <div class="accordion" id="accordionPanelsStayFiveExample">
                  <div class="accordion-item">
                    <h2 class="accordion-header" id="panelsStayOpen-headingFive">
                      <button class="accordion-button"   type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseFive" aria-expanded="true" aria-controls="panelsStayOpen-collapseFive">
                        전문분야
                      </button>
                    </h2>
                    <div id="panelsStayOpen-collapseFive" class="accordion-collapse collapse show" aria-labelledby="panelsStayOpen-headingFive">
                      <div class="accordion-body">
                       <div  class="contents" v-for="(c,idx) in counselor.data.categories"
                        :key="idx"
                        :c="c">
                        {{c.contents}}
                      </div>
                      </div>
                    </div>
                  </div>
                </div>

                <br>


                

                <br>
                <!-- <div class="card" id="certificate-card" style="width: 18rem;">
                  <div class="card-header">
                    전문분야<button class="add-button" v-if="counselor.data.nickName==currentUser.data.nickname">+</button>
                  </div>
                  <ul class="list-group list-group-flush">
                    <li class="list-group-item">
                      <div v-for="(c,idx) in counselor.data.categories"
                        :key="idx"
                        :c="c">
                        {{c.contents}}
                        </div> 
                    </li>
                  </ul>
                </div> -->
                
                <div class="accordion" id="accordionPanelsStayOpenExample">
                  <div class="accordion-item">
                    <h2 class="accordion-header" id="panelsStayOpen-headingOne">
                      <button class="accordion-button"   type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseOne" aria-expanded="true" aria-controls="panelsStayOpen-collapseOne">
                        약력
                      </button>
                    </h2>
                    <div id="panelsStayOpen-collapseOne" class="accordion-collapse collapse show" aria-labelledby="panelsStayOpen-headingOne">
                      <div class="accordion-body">
                       <div class="contents" v-for="(c,idx) in counselor.data.careers"
                        :key="idx"
                        :c="c">
                        {{c.contents}}<button class="add-button"   v-if="counselor.data.nickName==currentUser.data.nickname" @click="deleteCareer(c.id)">x</button>
                      </div>
                      </div>
                    </div>
                  </div>
                  <div class="accordion-item">
                    <h2 class="accordion-header" id="panelsStayOpen-headingTwo">
                      <button class="accordion-button collapsed" v-if="counselor.data.nickName==currentUser.data.nickname" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseTwo" aria-expanded="false" aria-controls="panelsStayOpen-collapseTwo">
                        약력 추가하기
                      </button>
                    </h2>
                    <div id="panelsStayOpen-collapseTwo" class="accordion-collapse collapse" aria-labelledby="panelsStayOpen-headingTwo">
                      <div class="accordion-body">
                        <form @submit.prevent="createCareerFunc" class="career-list-form">
                        <div class="my-3 w-100 d-flex justify-content-start align-items-center ">
                          <label for="review"></label>
                          <input  placeholder="추가할 내용을 입력해주세요" type="text" id="review"  style="width:85%; height:25px " v-model="careerContent" required>
                        </div>
                        <button class="changebtn" >작성하기</button>
                      </form>
                      </div>
                    </div>
                  </div>
                </div>

                <!-- <div class="card" id="carrer-card" style="width: 18rem;">
                  <div class="card-header">
                    약력
                    <button class="add-button" v-if="counselor.data.nickName==currentUser.data.nickname">+</button>          
                  </div>
                  <ul class="list-group list-group-flush">
                    <li class="list-group-item">
                      <div v-for="(c,idx) in counselor.data.careers"
                        :key="idx"
                        :c="c">
                        {{c.contents}}
                      </div>
                    </li>
                  </ul>
                </div> -->
              
                <br><br><br>

                <div class="accordion" id="accordionPanelsStayThreeExample">
                  <div class="accordion-item">
                    <h2 class="accordion-header" id="panelsStayOpen-headingThree">
                      <button class="accordion-button"   type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseThree" aria-expanded="true" aria-controls="panelsStayOpen-collapseThree">
                        자격증
                      </button>
                    </h2>
                    <div id="panelsStayOpen-collapseThree" class="accordion-collapse collapse show" aria-labelledby="panelsStayOpen-headingThree">
                      <div class="accordion-body">
                       <div class="contents" v-for="(c,idx) in counselor.data.certificates"
                      :key="idx"
                      :c="c">
                      {{c.contents}}<button class="add-button"   v-if="counselor.data.nickName==currentUser.data.nickname" @click="deleteCertificate(c.id)">x</button>
                      </div>
                      </div>
                    </div>
                  </div>
                  <div class="accordion-item">
                    <h2 class="accordion-header" id="panelsStayOpen-headingFour">
                      <button class="accordion-button collapsed" v-if="counselor.data.nickName==currentUser.data.nickname" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseFour" aria-expanded="false" aria-controls="panelsStayOpen-collapseFour">
                        자격증 추가하기
                      </button>
                    </h2>
                    <div id="panelsStayOpen-collapseFour" class="accordion-collapse collapse" aria-labelledby="panelsStayOpen-headingFour">
                      <div class="accordion-body">
                        <form @submit.prevent="createCertificateFunc" class="certificate-list-form">
                        <div class="my-3 w-100 d-flex justify-content-start align-items-center ">
                          <label for="review"></label>
                          <input  placeholder="추가할 내용을 입력해주세요" type="text" id="review"  style="width:85%; height:25px " v-model="certificateContent" required>
                        </div>
                        <button class="changebtn" >작성하기</button>
                      </form>
                      </div>
                    </div>
                  </div>
                </div>

                <!-- <div class="card" id="certificate-card" style="width: 18rem;">
                  <div class="card-header">
                    자격증<button class="add-button" v-if="counselor.data.nickName==currentUser.data.nickname">+</button>
                  </div>
                  <ul class="list-group list-group-flush">
                    <li class="list-group-item">
                      <div v-for="(c,idx) in counselor.data.certificates"
                      :key="idx"
                      :c="c">
                      {{c.contents}}
                      </div> 
                    </li>
                  </ul>
                </div> -->

                <br>


          
                <br>

                <div class="accordion" id="accordionPanelsStaySevenExample">
                  <div class="accordion-item">
                    <h2 class="accordion-header" id="panelsStayOpen-headingSeven">
                      <button class="accordion-button"   type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseSeven" aria-expanded="true" aria-controls="panelsStayOpen-collapseSeven">
                        운영중인 그룹
                      </button>
                    </h2>
                    <div id="panelsStayOpen-collapseSeven" class="accordion-collapse collapse show" aria-labelledby="panelsStayOpen-headingSeven">
                      <div class="accordion-body">
                       <div  class="contents" v-for="(c,idx) in counselor.data.groups"
                      :key="idx"
                      :c="c">
                      그룹 번호 : {{c.id}}
                      그룹 이름 : {{c.title}}
                      <router-link :to="{name:'groupDetail', params: {groupId:c.id}}">
                      <button>그룹 상세페이지</button>
                      </router-link>
                      </div>
                      </div>
                    </div>
                  </div>
                </div>



                <br>


        

                <br>

                <div class="accordion" id="accordionPanelsStaySixExample">
                  <div class="accordion-item">
                    <h2 class="accordion-header" id="panelsStayOpen-headingSix">
                      <button class="accordion-button"   type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseSix" aria-expanded="true" aria-controls="panelsStayOpen-collapseSix">
                        리뷰
                      </button>
                    </h2>
                    <div id="panelsStayOpen-collapseSix" class="accordion-collapse collapse show" aria-labelledby="panelsStayOpen-headingSix">
                      <div class="accordion-body">
                       <div  class="contents" v-for="(c,idx) in counselor.data.reviews"
                      :key="idx"
                      :c="c">
                      {{c.contents}}
                      </div>
                      </div>
                    </div>
                  </div>
                </div>

                <!-- <div class="card" id="review-card" style="width: 18rem;">
                  <div class="card-header">
                    리뷰
                  </div>
                  <ul class="list-group list-group-flush">
                    <li class="list-group-item">
                      <div v-for="(c,idx) in counselor.data.reviews"
                      :key="idx"
                      :c="c">
                      {{c.contents}}
                      </div> 
                    </li>
                  </ul>
                </div> -->

             
             
            

 
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <!-- <div v-if="!favorite">
        <button class="btn btn-link" @click="favoriteCounselor(counselorId)"><i class="fa-solid fa-heart" style="color:black"></i></button>
      </div>
      <div v-else>
        <button class="btn btn-link" @click="favoriteCounselor(counselorId)"><i class="fa-solid fa-heart" style="color:red"></i></button>
      </div> -->
<!--       
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
     -->



      <!-- <span v-if="currentUser.type === student"> 
        <button>개인상담신청하기</button>
        </span> -->
      <!-- <div class="price">
        <h4>상담 가격</h4>
        <div class="personal-price" 
        v-if ="ispersonalpriced==false"
        @keyup.enter="ispersonalpriced=true">
          <li>개인상담 : <input type="text">point</li>
        </div>
        <div v-else>
          개인상담가격띄워야됨 -->
          <!-- {{counselor.price}} -->
        <!-- </div> 
      </div> -->
<!-- 

      
      <h4>전문분야</h4>
      <div class="category-list row row-cols-2 row-cols-md-5 g-3">
        <span v-for="category in counselor.categories" 
        :key="category.key">
        {{category}}
        </span> 
      </div>
     
      <div class="career-list row row-cols-2 row-cols-md-5 g-3">
        <span v-for="career in counselor.careers" 
        :key="career.key">
        {{career.title}}
        {{career.contents}}
        </span> 
      </div>

      <div class="manage-group-list row row-cols-2 row-cols-md-5 g-3">
        <span v-for="group in counselor.groups" 
        :key="group.key">
        {{group}}
        </span> 
      </div>

      <div class="review-list row row-cols-2 row-cols-md-5 g-3">
        <span v-for="review in counselor.reviews" 
        :key="review.key">
        {{review.content}}
        </span> 
      </div> -->


      <!-- <career-list-comp>
      </career-list-comp>
      <manage-group-list-comp>
      </manage-group-list-comp>
      <review-list-comp>
      </review-list-comp>
      
      <file-list-comp>
      </file-list-comp> -->

    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
     

  </div>
</template>
<script>
  // import InfoItemComp from '@/views/counselor/components/InfoItemComp.vue'
  // import CareerListComp from '@/views/counselor/components/CareerListComp.vue'
  // import FileListComp from '@/views/counselor/components/FileListComp.vue'
  // import ManageGroupListComp from '@/views/counselor/components/ManageGroupListComp.vue'
  // import ReviewListComp from '@/views/counselor/components/ReviewListComp.vue'



  import { mapActions,mapGetters} from 'vuex'


  export default {
    name : 'CounselorDetailView',
    components: {
    // CareerListComp,
    // FileListComp,
    // ManageGroupListComp,
    // ReviewListComp,
    // InfoItemComp,
   
},  

    data() {
      return {
        counselorId: this.$route.params.counselorId,
        isModalViewed: false,
        infoContent:'',
        careerContent:'',
        certificateContent:'',
        isdone : false,
        ispersonalpriced: false,
        isgrouppriced: false,
        ismaked: false,
      
        
  
      }
    },
    computed : {
      ...mapGetters(['counselor','currentUser', 'favorite','groups','favorite']),
      infos() {
      return this.$store.state.infos
      
    }
    },
    methods: {
      ...mapActions(['fetchCounselor',
      'favoriteCounselor',
      'fetchCurrentUser',
       'deleteCareer',
       'createCareer',
       'deleteCertificate',
       'createCertificate',
       'fetchGroups',
       'favoriteAdd',
       'favoriteDelete',
       'favoriteGet']),
   
      nick1() {
        return this.currentUser.data.nickName
      },

      createCareerFunc() {
        this.createCareer(this.careerContent)
        

      },
      createCertificateFunc() {
        this.createCertificate(this.certificateContent)
       

      },
      // check(num1) {
      //   if (num1.value%2 == 1){
      //     return true;
      //   } else {
      //     return false;
      //   }
      // },


      // createCategoryFunc() {
      //   this.createCareer(this.categoryContent)
      // favoriteaddfunc() {
      //   let userId= this.counselor.data.userId
      //   this.favoriteAdd(this.counselor.data.userId)
      //   console.log(userId)
    
      // },

      // favoritedeletefunc() {
      //   let id = this.favorite.data.id
      //   this.favoriteDelete(id)
      //   console.log(id)
      // },
      // },


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
      this.fetchCurrentUser()
      this.fetchCounselor(this.counselorId)
      this.fetchGroups()
      this.favoriteGet()
      // this.check()
  

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


.card-header{
  display: flex;
  justify-content: space-between;

}
.contents{
  display: flex;
  justify-content: space-between;

}
.add-button{
  border:none;
  background-color: transparent
}
</style>
