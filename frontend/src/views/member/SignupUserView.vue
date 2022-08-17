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
                    <input class="form-control" type="email" v-model="credentials.email" placeholder="이메일">    
                  </div>
                  <div class="form-group">
                    <input class="form-control" type="phone" v-model="credentials.phone" placeholder="전화번호">
                  </div>
                  <div class="form-group row d-flex justify-content-center">
                    <input class="form-control col-sm-3" id="signup-birth" type="text" name="yy" placeholder="년(4자)">
                    <input class="form-control col-sm-3" id="signup-birth" type="text" name="mm" placeholder="월(2자)">
                    <input class="form-control col-sm-3" id="signup-birth" type="text" name="dd" placeholder="일(2자)">
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
  name: 'SignupUser',
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
        email: '',
        picture: '',
        phone: ''
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
    ...mapGetters(['authError', 'currentUser'])
  },
  methods: {
    ...mapActions(['signup']),
    // 회원가입 폼 제출
    signUp() {
      let formData = new FormData()
      formData.append('id', this.credentials.id)
      formData.append('pw', this.credentials.pw)
      formData.append('type', this.credentials.type)
      formData.append('nickName', this.credentials.nickName)
      formData.append('birth', this.credentials.birth)
      formData.append('gender', this.credentials.gender)
      formData.append('email', this.credentials.email)
      formData.append('phone', this.credentials.phone)
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
<style>
  #signup-birth {
    width: 100px;
  }
  #signup-img {
    width: 200px;
    margin: auto;
  }
  .w-btn-check {
    /* position: relative; */
    border: none;
    min-width: 70px;
    min-height: 20px;
    background: linear-gradient(
        90deg,
        #5b5792bd 0%,
        #5b5792bb 100%
    );
    border-radius: 10px;
    color: darkslategray;
    cursor: pointer;
    /* box-shadow: 12px 12px 24px #5a554747; */
    font-weight: 700;
    transition: 0.3s;
    color: #E9E5DC;
    margin-left: 8px;
    font-size: 13px;
}
.w-btn-signup {
    /* position: relative; */
    border: none;
    min-width: 170px;
    min-height: 50px;
    background: linear-gradient(
        90deg,
        #5B5792 0%,
        #5B5792 100%
    );
    border-radius: 1000px;
    color: darkslategray;
    cursor: pointer;
    box-shadow: 12px 12px 24px #5a554747;
    font-weight: 700;
    transition: 0.3s;
    color: #E9E5DC
}
</style>
