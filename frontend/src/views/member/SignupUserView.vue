<template>
  <div class="container">
    <form @submit.prevent="signUp()">
      <div class="form-group">
        <label for="id" class="form-label mt-2">아이디</label>
        <div class="row">
          <input id="inputId" type="text" class="form-control col-sm-6 mx-3" placeholder="아이디" v-model="credentials.id">
          <button @click="idCheck()" class="btn btn-primary col-sm-3" id="sameId">중복검사</button>
        </div>
      </div>
      <div class="form-group has-success">
        <label class="form-label mt-2" for="password">비밀번호</label>
        <input type="password" class="form-control" placeholder="비밀번호" v-model="credentials.pw">
      </div>
      <div class="form-group">
        <label class="form-label mt-2" for="nickname">닉네임</label>
        <div class="row">
          <input type="text" class="form-control col-sm-6 mx-3" placeholder="닉네임" id="inputId" v-model="credentials.nickName">
          <button @click="idCheck()" class="btn btn-primary col-sm-3" id="sameId">중복검사</button>
        </div>
      </div>
      <div class="birth_wrap ">
        <label class="form-label mt-2" for="birth">생년월일</label>
        <div class="row">
          <div class="bir_yy col-sm-4">
            <span class="ps_box">
              <input
                type="text"
                class="form-control"
                id="yy"
                placeholder="년(4자)"
                maxlength="4"
              />
            </span>
          </div>
          <div class="bir_mm col-sm-4">
            <span class="ps_box focus">
              <select class="form-select" id="mm">
                <option>월</option>
                <option v-for="month in months" :key="month">{{ month }}</option>
              </select>
            </span>
          </div>
          <div class="bir_mm col-sm-4">
            <span class="ps_box focus">
              <select class="form-select" id="mm">
                <option>일</option>
                <option v-for="day in days" :key="day">{{ day }}</option>
              </select>
            </span>
          </div>
        </div>
      </div>
      <div clss="form-group">
        <label class="form-label mt-2" for="email">이메일</label>
        <input
          v-model="credentials.email"
          placeholder="이메일"
          type="email"
          class="form-control"
          id="email"
        />
      </div>
      <div class="row">
        <div class="form-group col-md-4">
          <label class="form-label mt-2" for="gender">성별</label>
          <select class="form-select" v-model="credentials.gender" id="gender">
            <option value="MALE">남자</option>
            <option value="FEMALE">여자</option>
          </select>
        </div>
        <div class="form-group col-md-4">
          <label class="form-label mt-2" for="type">사용자 구분</label>
          <div class="row">
            <div class="form-group col-md-6">
              <input @click="imCounselor()" value="COUNSELOR" type="radio" class="btn-check" name="options-outlined" id="success-outlined" autocomplete="off" checked>
              <label class="btn btn-outline-success" for="success-outlined">상담사</label>
            </div>
            <div class="form-group col-md-6">
              <input @click="imUser()" value="USER" type="radio" class="btn-check" name="options-outlined" id="danger-outlined" autocomplete="off">
              <label class="btn btn-outline-success" for="danger-outlined">사용자</label>
            </div>

          </div>
        </div>
      </div>
      <div v-if="this.isCounselor">
        <label class="form-label mt-2" for="inputGroupFile01">자격증명서 (상담사 해당)</label>
        <div class="input-group mb-3">
          <input @change="inputImg()" ref="serveryImg" type="file" class="form-control" id="inputGroupFile01">
        </div>
      </div>
      <div class="d-grid gap-2">
        <button type="submit" class="btn btn-primary btn-sm">가입하기</button>
      </div>
    </form>
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
        type: '',
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
  #inputId {
    width: 60%;
  }
  #sameId {
    width: 30%;
  }
</style>
