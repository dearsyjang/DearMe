<template>
  <div>
    <div class="self-introduce"> 
    {{counselor.data.introduce}}
    <h5>안녕하세요.상담사 강지명입니다.
    마음의 병이 생겼다면 우리는 어떻게 해야 할까요. 오랫동안 전문상담사를 양성해 온 천성문 교수는 심리상담이 필요한 이유를 쉽게 설명하였습니다.
    '진료는 의사에게 약은 약사에게'라는 문구를 우리는 잘 알고잇다. 가변은 상처라면 집에서 간단히 처리를하지만 그렇지ㅏ 않다면 우리는 병원을 찾게 된다. 
    적절한 치료를 하고 주사나 약을 처방받고 며칠간 치료를 다니다가 낫지 않으면 수술을 하기도 한다. 그러나 우리의 마음은 누가 치료해주는가</h5>
    </div>
    <div class="counselor-info">       
      <div class="accordion" id="accordionPanelsStayOpenExample">
        <div class="accordion-item">
          <h2 class="accordion-header" id="panelsStayOpen-headingOne">
            <button class="accordion-button"   type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseOne" aria-expanded="true" aria-controls="panelsStayOpen-collapseOne">
              &#128220; <div style="color:black">주요 약력</div>
            </button>
          </h2>
          <div id="panelsStayOpen-collapseOne" class="accordion-collapse collapse show" aria-labelledby="panelsStayOpen-headingOne">
            <div class="accordion-body">
              <div class="contents" v-for="(c,idx) in counselor.data.careers"
              :key="idx"
              :c="c">
              -{{c.contents}}<button class="add-button"   v-if="counselor.data.nickName==currentUser.data.nickname" @click="deleteCareer(c.id)">x</button>
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
      <br><br><br>
      <div class="accordion" id="accordionPanelsStayThreeExample">
        <div class="accordion-item">
          <h2 class="accordion-header" id="panelsStayOpen-headingThree">
            <button class="accordion-button"   type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseThree" aria-expanded="true" aria-controls="panelsStayOpen-collapseThree">
              &#127942; <div style="color:black">주요 자격</div>
            </button>
          </h2>
          <div id="panelsStayOpen-collapseThree" class="accordion-collapse collapse show" aria-labelledby="panelsStayOpen-headingThree">
            <div class="accordion-body">
              <div class="contents" v-for="(c,idx) in counselor.data.certificates"
            :key="idx"
            :c="c">
            -{{c.contents}}<button class="add-button"   v-if="counselor.data.nickName==currentUser.data.nickname" @click="deleteCertificate(c.id)">x</button>
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
    </div>
  </div>
</template>

<script>
import { mapActions,mapGetters} from 'vuex'
export default{
  name: 'CounselorInfoComp',
  computed : {
      ...mapGetters(['counselor','currentUser','groups']),
   
      
    },
    data() {
      return {
        counselorId: this.$route.params.counselorId,
        infoContent:'',
        careerContent:'',
        certificateContent:'',
    
        
  
      }
    },
    methods: {
      ...mapActions(['fetchCounselor',
      'fetchCurrentUser',
       'deleteCareer',
       'createCareer',
       'deleteCertificate',
       'createCertificate',
       'fetchGroups',

      ])
      },
      created() {
            this.fetchCurrentUser()
            this.fetchCounselor(this.counselorId)
            this.fetchGroups()
        
            },



}
</script>

<style>
.self-introduce{
  margin:20px;
}
</style>