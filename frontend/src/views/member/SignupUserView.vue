<template>
  <div class="login-wrapper d-flex align-items-center justify-content-center">
    <div class="custom-container">
      <div class="text-center px-4" id="signup-img">
        <img src="@/assets/images/img/bg-img/user.png" alt="">
      </div>
      <!-- Register Form -->
      <div class="register-form mt-4">
        <h6 class="mb-3 text-center">{{ $route.params.type }}</h6>
        <h6 class="mb-3 text-center">아래 항목을 입력하시오.</h6>
        <form >
          <div class="form-group">
            <input class="form-control" type="text" v-model="credentials.id" placeholder="아이디">
          </div>
          <div class="form-group position-relative">
            <input class="form-control" type="password" v-model="credentials.pw" placeholder="비밀번호">
            <div class="position-absolute">
              <i class="bi bi-eye"></i>
              <i class="bi bi-eye-slash"></i>
            </div>
          </div>
          <div class="form-group">
            <input class="form-control" type="text" v-model="credentials.nickName" placeholder="닉네임">
          </div>
          <div class="form-group">
              <select class="form-select" id="defaultSelect" v-model="credentials.gender" >
                <option selected value="0">성별</option>
                <option value="MALE">남성</option>
                <option value="FEMALE">여성</option>
              </select>
          </div>
          <div class="form-group">
            <input class="form-control" type="email" v-model="credentials.email" placeholder="이메일">
          </div>
          <div class="form-group row d-flex justify-content-evenly">
            <input class="form-control col-sm-3" id="signup-birth" type="text" name="yy" placeholder="년(4자)">
            <input class="form-control col-sm-3" id="signup-birth" type="text" name="mm" placeholder="월(2자)">
            <input class="form-control col-sm-3" id="signup-birth" type="text" name="dd" placeholder="일(2자)">
          </div>
          <button @click="signUp()" class="btn btn-primary w-100" type="submit">회원가입</button>
        </form>
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
    signUp() {
      let formData = new FormData()
      formData.append('id', this.credentials.id)
      formData.append('pw', this.credentials.pw)
      formData.append('type', this.credentials.type)
      formData.append('nickName', this.credentials.nickName)
      formData.append('birth', this.credentials.birth)
      formData.append('gender', this.credentials.gender)
      formData.append('email', this.credentials.email)
      this.signup(formData)
      // console.log(formData.getAll('id'))
    },
    // 아이디 중복 확인 (response 수정해야함)
    idCheck(){
      axios({
        url: drf.member.idCheck()+`/${this.credentials.id}`,
        method: 'get'
      })
      .then(res => {
        if (res.status === 'success'){
          alert('사용 가능한 아이디 입니다.')
        }
        else{
          alert('중복된 아이디가 존재합니다.')
        }
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
<style scoped>
  #signup-birth {
  width: 100px;
  }
  #signup-img {
    width: 200px;
    margin: auto;
  }
</style>
