<template>
<div class="member-gb">
  <div class="page-content-wrapper py-3 ">
      <div class="shop-pagination pb-3">
        <div class="container">
          <div class="card">
            <div class="card-body p-2">
              <div class="d-flex align-items-center justify-content-between">
                <small class="ms-1 board-text-index">{{ $route.params.type }} 회원가입</small>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="top-products-area product-list-wrap">
        <div class="container">
          <div class="login-wrapper d-flex align-items-center justify-content-center">
            <div class="custom-container">
              <div class="register-form mt-4">
                <h6 class="mb-3 text-center">아래 항목을 입력하시오.</h6>
                  <div class="form-group d-flex justify-content-center">
                    <input class="form-control" type="text" v-model="credentials.id" placeholder="아이디">
                    <button class="w-btn-check" @click="idCheck()">중복확인</button>
                  </div>
                  <div class="form-group position-relative">
                    <input class="form-control" type="password" v-model="credentials.pw" placeholder="비밀번호">
                    <div class="position-absolute">
                      <!-- <i class="bi bi-eye"></i>
                      <i class="bi bi-eye-slash"></i> -->
                    </div>
                  </div>
                  <div class="form-group d-flex justify-content-center">
                    <input class="form-control" type="text" v-model="credentials.nickName" placeholder="닉네임">
                    <button class="w-btn-check" @click="nicknameCheck()">중복확인</button>
                  </div>
                  <div class="form-group">
                      <select class="form-select" id="defaultSelect" v-model="credentials.gender" >
                        <option selected disabled>성별</option>
                        <option value="MALE">남성</option>
                        <option value="FEMALE">여성</option>
                      </select>
                  </div>
                   <div class="form-group">
                    <input class="form-control" type="text" v-model="credentials.phone" placeholder="전화번호">
                  </div>
                  <div class="form-group">
                    <input class="form-control" type="email" v-model="credentials.email" placeholder="이메일">
                  </div>
                  <div class="form-group row d-flex justify-content-center">
                    <input class="form-control col-sm-3" id="signup-birth" type="text" name="yy" placeholder="년(4자)">
                    <input class="form-control col-sm-3" id="signup-birth" type="text" name="mm" placeholder="월(2자)">
                    <input class="form-control col-sm-3" id="signup-birth" type="text" name="dd" placeholder="일(2자)">
                  </div>
                  <div class="form-group">
                    <form id="formElem" enctype="multipart/form-data">
                       <div class="itemFileBox" ref="itemFileBox">
                        <input type="file" 
                                class="item-file-image" 
                                id="uploadItemFile" 
                                ref="uploadItemFile"
                                @change="onFileSelected"
                                accept="image/*"
                        />
                        <label for="uploadItemFile">
                          <div class="wrapper-image" >
                              <img ref="uploadItemImage">
                          </div>      
                        </label>
                        </div>  
                    </form>
                  </div>


                  <br><hr><br>
                  <h3 class="counselor-info-set">상담 정보를 입력해주세요</h3>
                  <br><br>
                  <div class="su-filter-title" id="category-select" >
                    <p style="text-align:center">전문 분야를 선택해주세요</p>
                   
                    <div class="ctrg-inside">
                    <div class="form-check form-check-inline">
                      <input class="form-check-input" type="radio" id="3" value="가족" name="radio2" v-model="credentials.counselorProfile.categories[0].contents">
                      <label class="form-check-label" for="3">
                      가족
                      </label>
                    </div>
                    <div class="form-check form-check-inline">
                      <input class="form-check-input" type="radio" id="4" value="직장,진로" name="radio2" v-model="credentials.counselorProfile.categories[0].contents">
                      <label class="form-check-label" for="4">
                      직장, 진로
                      </label>
                    </div>
                    <div class="form-check form-check-inline">
                      <input class="form-check-input" type="radio" id="5" value="연애,결혼" name="radio2" v-model="credentials.counselorProfile.categories[0].contents" >
                      <label class="form-check-label" for="5">
                      연애, 결혼
                      </label>
                    </div>
                    <div class="form-check form-check-inline">
                      <input class="form-check-input" type="radio" id="6" value="자기이해" name="radio2" v-model="credentials.counselorProfile.categories[0].contents">
                      <label class="form-check-label" for="6">
                      자기 이해
                      </label>
                    </div>
                  </div>
                  </div>
                  
                  <br><br><br>
                  <p style="text-align:center">추가 정보를 입력해주세요</p>
                   <div class="form-group">
                    <div class="info-text">주요 약력을 입력해주세요</div>
                    <input class="form-control" type="text" v-model="credentials.counselorProfile.careers[0].contents" placeholder="약력">
                  </div>
                   <div class="form-group">
                    <div class="info-text">주요 자격증을 입력해주세요</div>
                    <input class="form-control" type="text" v-model="credentials.counselorProfile.certificates[0].contents" placeholder="자격증">
                  </div>
                   <div class="form-group">
                    <div class="info-text">상담가격   </div>
                    <input class="form-control" type="text" v-model="credentials.counselorProfile.price" placeholder="가격">
                    <p>*회원가입 시 상담가격은 1000point부터 시작합니다</p>
                  </div>
                  <div class="form-group" >
                    <div class="info-text">자기소개를 입력해주세요</div>
                    <input class="form-control" id="self-intro" type="text" v-model="credentials.counselorProfile.introduce" placeholder="">
                  </div>



                  <button @click="signUp()" class="w-btn-signup w-100" type="submit">회원가입</button>
              </div>
            </div>
          </div>
        </div>
      </div>
  </div>
</div>
</template>
<script>
import { mapActions, mapGetters } from 'vuex'
import axios from 'axios'
import drf from '@/api/drf'
export default {
  name: 'SignupCounselor',
  components: {},
  data() {
    return {
      isCounselor: false,
      credentials: {
        id: '',
        pw: '',
        type: this.$route.params.type,
        nickName: '',
        birth: '2022/02/02',
        gender: '',
        phone: '',
        email: '',
        picture: '',
        counselorProfile: {introduce : "",
              price : 1000,
                careers : [
                    { contents : "" },
                  ],
                  certificates : [
                    { contents : "" }
                  ],
                  categories : [
                    { contents : "" }
                  ]}  

        // counselorProfile: `{"introduce" : "introduce my self",
        //       "price" : 100,
        //         "careers" : [
        //             { "contents" : "contents1" },
        //             { "contents" : "contents1" },
        //             { "contents" : "contents1" },
        //             { "contents" : "contents1" }
        //           ],
        //           "certificates" : [
        //             { "contents" : "contents1" }
        //           ],
        //           "categories" : [
        //             { 'contents" : "contents1" }
        //           ]}  `


      },
      months: [
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
      ],
      days: [
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31
      ],
      category: [

      ]
    }
  },
  computed: {
    ...mapGetters(['authError'])
  },
  methods: {
    ...mapActions(['signup']),
    // 회원가입 폼 제출
    onFileSelected(event){
      let image = event.target;
      if(image.files[0]){
                
        let itemImage = this.$refs.uploadItemImage; //img dom 접근
        
        itemImage.src = window.URL.createObjectURL(image.files[0]);//img src에 blob주소 변환
        
        itemImage.width ='200'; // 이미지 넓이
        
        itemImage.onload = () => {
          window.URL.revokeObjectURL(this.src)  //나중에 반드시 해제해주어야 메모리 누수가 안생김.
        }
     
      }
    },
    signUp() {
      let formData = new FormData()
      formData.append('id', this.credentials.id)
      formData.append('pw', this.credentials.pw)
      formData.append('type', this.credentials.type)
      formData.append('nickName', this.credentials.nickName)
      formData.append('birth', this.credentials.birth)
      formData.append('gender', this.credentials.gender)
      formData.append('phone', this.credentials.phone)
      formData.append('email', this.credentials.email)
      formData.append('counselorProfile', this.credentials.counselorProfile)
      formData.append('picture', document.getElementById('formElem')[0].files[0]);
      this.signup(formData)
      // console.log(formData.getAll('id'))
    },
    // 아이디 중복 확인 (response 수정해야함)
    idCheck(){
      axios({
        url: drf.member.idCheck(this.credentials.id),
        method: 'get'
      })
      .then(res => {
        alert(`${this.credentials.id}는 사용가능한 아이디 입니다.`)
        console.log(res.data)
        console.log(res.data.data)
      })
      .catch(err => {
        alert(err.response.data.message)
          console.error(err.response.data.message)
      })
    },
    nicknameCheck(){
      axios({
        url: drf.member.nickNameCheck(this.credentials.nickName),
        method: 'get'
      })
      .then(res => {
        alert(`${this.credentials.nickName}는 사용가능한 닉네임 입니다.`)
        console.log(res.data)
        console.log(res.data.data)
      })
      .catch(err => {
        alert(err.response.data.message)
        // console.error(err.response.data.message)
      })
    },
    imCounselor() {
      this.isCounselor = true
      this.credentials.type = 'COUNSELOR'
      // console.log(this.isCounselor)
      // console.log(this.credentials.type)
    },
    imUser() {
      this.isCounselor = false
      this.credentials.type = 'USER'
    }
    // inputImg() {
    //   this.credentials.picture = this.$refs.serveryImg.files
    //   console.log(this.credentials.picture)
    // }
    }

}
</script>
<style >
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
.counselor-info-set{
  margin:auto;
  text-align:center;
  padding:20px;
}

.form-check :checked ~ label {
  -webkit-text-fill-color: white;
  background-color: #7f7cb2db;
}

#signup-birth{
  width:31%;
 
}

#self-intro{
  height:200px;
}

.info-text{
  margin-bottom:3px
}
</style>