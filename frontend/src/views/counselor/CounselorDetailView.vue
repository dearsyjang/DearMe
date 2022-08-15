<template>
  <div>
  <div>

  
    <!-- <router-link :to="{ name: 'counselingReview', params : {counselorId : counselor.data.userId}}">
                <button>리뷰 쓰러가는 버튼! 상담 나가기에 버튼 달아도 되고 종료시 라우터 푸시로 해도됨</button>
                </router-link> -->
 
    
    <div class="counselor-profile">
      <div class="card">
        <div class="card mb-3" style="max-width: 540px;">
          <div class="row g-0">


            <div class="card2 mb-3" id="counselor-card" >
              <div class="row">
                <div class="card-pic col-md-16 " style="max-width:50%;">
                  <img src = "@/assets/images/강지명.png" class="counselor-img2"/>
                  {{counselor.data.picUrl}}
                 
                </div> 
                <div class="card-body col-md-16" style="max-width:50%;" >
                    <h5 class="card-title2">{{counselor.data.nickName}}상담사</h5>
                  
                  <p class="card-text"><small class="text-muted">&#11088; {{counselor.data.value}} ({{counselor.data.reviewCnt}})</small></p>
                  전문분야<div  class="category-contents" v-for="(c,idx) in counselor.data.categories"
                            :key="idx"
                            :c="c">  
                          <button class="category-btn">{{c.contents}}</button>
                          </div>     
                      <br>
                    <!-- <div class="counseling-price2">1:1 상담 : {{counselor.data.price}} point</div> -->
                     
                </div>
              </div>
            </div>
         <div class= "select-sections" >

        <button id= "select-left" @click="changeDp()" :class="{ red:isRed, blod:isBold }"> 
            상담사 정보
        </button>
        <button id="select-right" @click="changeFp()" :class="{ red:isRed2, blod:isBold2 }"> 
            상담 정보
        </button>

          </div>

          <div v-if="d==true && f==false">
          <counselor-info-comp></counselor-info-comp>
          </div>
          <div v-if="d==false && f==true">
          <counselor-info-comp-2></counselor-info-comp-2> 
          </div>  
            
          <div id="counselor-bottombar" class="container">
            <div>
              <router-link to="/counseling-request"  >
                <button v-if="currentUser.data.type==`USER`" class="one-on-one-request-btn">1:1 상담 신청하기</button>
              </router-link>
            </div>
          </div>
             
              
              </div>
            </div>
          </div>
        </div>
      </div>



    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
     

  </div>
</template>
<script>



  import { mapActions,mapGetters} from 'vuex'
  import counselorInfoComp from './components/counselorInfoComp.vue'
  import counselorInfoComp2 from './components/counselorInfoComp2.vue'

  export default {
    name : 'CounselorDetailView',
    components: {

   counselorInfoComp,
   counselorInfoComp2
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
        b:false,
        d:true,
        f:false,
        isRed : true,
        isBold : true,
        isRed2 : false,
        isBold2 : false,
        
  
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
      check(a) {
        if ( a==true)
        {this.b =true
        return(true)}
        
        if (this.b==false){
        {return false}}
     
          
      },

      changeDp() {
        this.d=true
        this.f=false

        this.isRed = !this.isRed;
        this.isBold = !this.isBold;
        this.isRed2 = !this.isRed2;
        this.isBold2 = !this.isBold2;

      },
      changeFp(){
        this.d=false
        this.f=true

        this.isRed = !this.isRed;
        this.isBold = !this.isBold;
        this.isRed2 = !this.isRed2;
        this.isBold2 = !this.isBold2;
      },

      createCategoryFunc() {
        this.createCareer(this.categoryContent)
      },

      favoriteaddfunc() {
        let userId= this.counselor.data.userId
        this.favoriteAdd(this.counselor.data.userId)
        console.log(userId)
    
      },

      favoritedeletefunc() {
        let id = this.favorite.data.id
        this.favoriteDelete(id)
        console.log(id)
      },
      


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
      this.check()
  

      },
 }
</script>


<style>
.category-btn{
  font-size:5px;
  border : 2px solid;
  border-radius : 5px;
  width: 70px;
  height: 20px;
  margin: 4px;
  text-align: center;
  justify-content: center;
  background-color: rgb(199, 217, 255);
 


}
.group-enter-btn{
   background-color: white;
   border: none;
}

.counseling-price2{
  font-size:5px;
}
.counseling-request2{
  background-color: none;
}
.counseling-price{
  font-size: 2px;
 
}
.card-title {
  float: left
}
.card-body{
  float: right
}
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


.select-sections{
width: 100%
}

#select-left{
 width: 50%; 
 float: left;  
 height: 50px;
 border: none;
 background-color: rgb(233, 233, 233);
}

#select-right{
  width: 50%; 
 float: right;  
 height: 50px;
 border: none;
 background-color: rgb(233, 233, 233);
}
.red{
color:blue
        }
.bold{
font-weight: bold;
        }
.red2{
color:blue
        }
.bold2{
font-weight: bold;
        }

.card-title2{
  margin-top:20px;
}

.counselor-img2{
  margin-top:20px;
}

.card-category{
  justify-content: center;
  font-size: 15px;
  width: 110px;
  margin-top: 30px;
  text-align: center;
}

.one-on-one-request-btn{
  background-color: black;
  color: white;
  border-radius : 5px;
  width:100%;
  height: 40px;
}

.card-body2{
   justify-content: center;
   text-align: center;
}

#card-category3{
  margin-top: 30px;
  margin-right:80px;
  font-size: 15px;
  text-align: center;
  justify-content: center;
}
#counselor-card{
  height:280px
}
</style>
