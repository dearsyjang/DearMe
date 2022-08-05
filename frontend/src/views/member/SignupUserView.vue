<template>
  <div class="container">
    <form @submit.prevent="signUp()">
      <div>
        <select for="isCounselor" v-model="credentials.type">사용자 구분
          <option value="USER">취업 준비생</option>
          <option value="COUNSELOR">심리 상담사</option>
        </select>
      </div>
      <div class="form-group">
        <label for="id" class="form-label mt-2">아이디</label>
        <input type="text" class="form-control" placeholder="아이디" v-model="credentials.id">
      </div>
      <div class="form-group has-success">
        <label class="form-label mt-2" for="password">비밀번호</label>
        <input type="password" class="form-control is-valid" placeholder="비밀번호" v-model="credentials.pw">
      </div>
      <div class="form-group">
        <label class="form-label mt-2" for="nickname">닉네임</label>
        <input type="text" class="form-control" placeholder="닉네임" v-model="credentials.nickName">
      </div>
      <div class="birth_wrap">
        <label class="form-label mt-2" for="birth">생년월일</label>
        <div class="bir_yy">
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
        <div class="bir_mm">
          <span class="ps_box focus">
            <select class="form-select" id="mm">
              <option>월</option>
              <option>1</option>
              <option>2</option>
              <option>3</option>
              <option>4</option>
              <option>5</option>
              <option>6</option>
              <option>7</option>
              <option>8</option>
              <option>9</option>
              <option>10</option>
              <option>11</option>
              <option>12</option>
            </select>
          </span>
        </div>
        <div class="bir_dd">
          <span class="ps_box">
            <input
              type="text"
              id="dd"
              class="form-control"
              placeholder="일"
              maxlength="2"
            />
          </span>
        </div>
      </div>
      <div class="form-group">
        <label class="form-label mt-2" for="gender">성별</label>
        <select class="form-select" v-model="credentials.gender" id="gender">
          <option value="MALE">남자</option>
          <option value="FEMAILE">여자</option>
        </select>
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
      <div class="d-grid gap-2">
        <button type="submit" class="btn btn-primary btn-sm">가입하기</button>
      </div>
    </form>
  </div>
</template>
<script>
import { mapActions, mapGetters } from 'vuex'
export default {
  name: 'SignupUser',
  components: {},
  data() {
    return {
      credentials: {
        id: '',
        pw: '',
        type: '',
        nickName: '',
        birth: '2022/02/02',
        gender: '',
        email: ''
      }
    }
  },
  computed: {
    ...mapGetters(['authError', 'currentUser'])
  },
  methods: {
    ...mapActions(['signup']),
    signUp() {
      let formData = new FormData()
      formData.append('id', this.credentials.id)
      formData.append('pw', this.credentials.pw)
      formData.append('type', this.credentials.type)
      formData.append('nickName', this.credentials.nickName)
      formData.append('birth', this.credentials.birth)
      formData.append('gender', this.credentials.gender)
      this.signup(formData)
    }

    // signUp() {
    //   console.log(this.credentials)
    //   this.signup(this.credentials)
    // }
    // signUp () {
    //   const newCredentials = {
    //     id: this.id,
    //     pw: this.pw,
    //     type: this.type,
    //     nickName: this.nickName,
    //     birth: this.birth,
    //     gender: this.gender,
    //     email: this.email,
    //   }
    //   console.log(newCredentials)
    //   this.signup(newCredentials)
    }
}
</script>
<style scoped>
  .bir_yy, .bir_mm, .bir_dd {
    width: 160px;
    display: table-cell;
  }
</style>
