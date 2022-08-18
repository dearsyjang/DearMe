<template>
  <div>
    <div class="page-content-wrapper py-3 board-bg">
      <div class="shop-pagination">
        <div class="container">
          <div class="self-introduce ">
            <h5>{{counselor.data.introduce}}</h5>
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
                  <button class="accordion-button"  type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseThree" aria-expanded="true" aria-controls="panelsStayOpen-collapseThree">
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