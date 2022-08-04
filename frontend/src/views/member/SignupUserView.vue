<template>
  <div class="container">
    <form>
      <div class="form-group">
        <label for="id" class="form-label mt-2">아이디</label>
        <input type="text" class="form-control" placeholder="아이디" v-model="credentials.id">
      </div>
      <div class="form-group has-success">
        <label class="form-label mt-2" for="password1">비밀번호</label>
        <input type="password" class="form-control is-valid" placeholder="비밀번호" v-model="credentials.password1">
      </div>
      <div class="form-group has-danger">
        <label class="form-label mt-2" for="password2">비밀번호 확인</label>
        <input type="password" class="form-control is-valid" placeholder="비밀번호 확인" v-model="credentials.password2">
        <div class="invalid-feedback">비밀번호가 일치하지 않습니다.</div>
      </div>
      <div class="form-group">
        <label class="form-label mt-2" for="nickname">닉네임</label>
        <input type="text" class="form-control" placeholder="닉네임" v-model="credentials.nickname">
      </div>
      <div class="birth_wrap">
        <label class="form-label mt-2" for="birth">생년월일</label>
        <div class="bir_yy">
          <span class="ps_box">
            <input
              v-model="credentials.birth_yy"
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
            <select class="form-select" id="mm" v-model="credentials.birth_mm">
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
              v-model="credentials.birth_dd"
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
          <option>남자</option>
          <option>여자</option>
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
        <button class="btn btn-primary btn-sm">가입하기</button>
      </div>
    </form>
  </div>
</template>
<script>
  import { mapActions } from 'vuex'
export default {
  name: 'SignupUser',
  components: {},
  data() {
    return {
      credentials: {
        username: [],
        password1: [],
        password2: [],
        nickname: [],
        birth_yy: [],
        birth_mm: [],
        birth_dd: []
      }
    }
  },
  setup() {},
  created() {

  },
  mounted() {},
  unmounted() {},
  methods: {
    ...mapActions(['signup']),

  }
}
</script>
<style scoped>
  .bir_yy, .bir_mm, .bir_dd {
    width: 160px;
    display: table-cell;
  }
</style>
