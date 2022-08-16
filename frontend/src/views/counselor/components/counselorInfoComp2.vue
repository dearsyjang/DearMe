<template>
  <div>
    <div class="counselor-info">      
      <br>
      <div class="accordion" id="accordionPanelsStaySevenExample">
        <div class="accordion-item">
          <h2 class="accordion-header" id="panelsStayOpen-headingSeven">
            <button class="accordion-button"   type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseSeven" aria-expanded="true" aria-controls="panelsStayOpen-collapseSeven">
              <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-people-fill" viewBox="0 0 16 16">
  <path d="M7 14s-1 0-1-1 1-4 5-4 5 3 5 4-1 1-1 1H7zm4-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
  <path fill-rule="evenodd" d="M5.216 14A2.238 2.238 0 0 1 5 13c0-1.355.68-2.75 1.936-3.72A6.325 6.325 0 0 0 5 9c-4 0-5 3-5 4s1 1 1 1h4.216z"/>
  <path d="M4.5 8a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5z"/>
</svg> <div style="color:black"> 주요 자격</div>
            </button>
          </h2>
          <div id="panelsStayOpen-collapseSeven" class="accordion-collapse collapse show" aria-labelledby="panelsStayOpen-headingSeven">
            <div class="accordion-body">
              <div  class="contents" v-for="(c,idx) in counselor.data.groups"
            :key="idx"
            :c="c">
              -{{c.title}}
            <router-link :to="{name:'groupDetail', params: {groupId:c.id}}">
            <button class="group-enter-btn"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-door-open" viewBox="0 0 16 16">
      <path d="M8.5 10c-.276 0-.5-.448-.5-1s.224-1 .5-1 .5.448.5 1-.224 1-.5 1z"/>
      <path d="M10.828.122A.5.5 0 0 1 11 .5V1h.5A1.5 1.5 0 0 1 13 2.5V15h1.5a.5.5 0 0 1 0 1h-13a.5.5 0 0 1 0-1H3V1.5a.5.5 0 0 1 .43-.495l7-1a.5.5 0 0 1 .398.117zM11.5 2H11v13h1V2.5a.5.5 0 0 0-.5-.5zM4 1.934V15h6V1.077l-6 .857z"/>
    </svg></button>
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
              &#128151; <div style="color:black"> 리뷰</div>
            </button>
          </h2>
          <div id="panelsStayOpen-collapseSix" class="accordion-collapse collapse show" aria-labelledby="panelsStayOpen-headingSix">
            <div class="accordion-body">
              <div  class="contents" v-for="(c,idx) in counselor.data.reviews"
            :key="idx"
            :c="c">
            -{{c.contents}}
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
  name: 'CounselorInfoComp2',
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

</style>