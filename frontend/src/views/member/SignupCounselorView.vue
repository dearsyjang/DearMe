<template>
  <div>
    <h1>회원가입</h1>
    <p>(상담사)</p>

    <account-error-list v-if="authError"></account-error-list>

    <form @submit.prevent="signup(credentials)">
      <div>
        <label for="username">아이디 </label> <br>
        <input  v-model="credentials.username" type="text" id="username" required/>
        <button>중복확인</button>
      </div>
      <div>
        <label for="password1">비밀번호 </label> <br>
        <input v-model="credentials.password1" type="password" id="password1" required />
      </div>
      <div>
        <label for="password2">비밀번호 확인</label> <br>
        <input v-model="credentials.password2" type="password" id="password2" required />
      </div>
      <div>
        <label for="birthday">생년월일</label> <br>
         <select class="birth-select" aria-label="Default select example">
          <option value="1">1990</option>
          <option value="2">1991</option>
          <option value="3">1992</option>
          <option value="4">1993</option>
          <option value="5">1994</option>
          <option value="6">1995</option>
          <option value="7">1996</option>
          <option value="8">1997</option>
          <option value="9">1998</option>
          <option value="10">1999</option>
          <option value="11">2000</option>
          <option value="12">2001</option>
          <option value="13">2002</option>
          <option value="14">2003</option></select>

          <select class="birth-select" aria-label="Default select example">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
            <option value="11">11</option>
            <option value="12">12</option></select>

          <select class="birth-select" aria-label="Default select example">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
            <option value="11">11</option>
            <option value="12">12</option>
            <option value="13">13</option>
            <option value="14">14</option>
            <option value="15">15</option>
            <option value="16">16</option>
            <option value="17">17</option>
            <option value="18">18</option>
            <option value="19">19</option>
            <option value="20">20</option>
            <option value="21">21</option>
            <option value="22">22</option>
            <option value="23">23</option>
            <option value="24">24</option>
            <option value="25">25</option>
            <option value="26">26</option>
            <option value="27">27</option>
            <option value="28">28</option>
            <option value="29">29</option>
            <option value="30">30</option>
            <option value="31">31</option></select> 
      </div>

      <div> 사진 첨부 </div>

      <div>
        <select class="gender-select" aria-label="Default select example">
            <option value="1">남</option>
            <option value="2">여</option> </select> 
      </div>

      <div class="input-group mb-3">
        <label for="e-mail">이메일</label> <br>
        <input type="text" class="form-control">
        <span class="input-group-text">@</span>
        <input type="text" class="form-control">
      </div>

      <div>
        <label for="nickname">닉네임 </label> <br>
        <input  v-model="credentials.nickname" type="text" id="nickname" required/>
        <button>중복확인</button>
      </div>

      <div>
        <label for="career">경력</label> <br>
        <div id="careerlist">
            <career-list></career-list>
            <career-form></career-form>
        </div>

      </div>

      <div>
        <label for="certificate">자격증</label> <br>
      </div>

      <div>
        <label for="category">전문 분야</label> <br>
        <div class="btn-group" role="group" aria-label="Basic checkbox toggle button group">
          <input type="checkbox" class="btn-check" id="btncheck1" autocomplete="off">
          <label class="btn btn-outline-primary" for="btncheck1">가족</label>

          <input type="checkbox" class="btn-check" id="btncheck2" autocomplete="off">
          <label class="btn btn-outline-primary" for="btncheck2">직장,진로</label>

          <input type="checkbox" class="btn-check" id="btncheck3" autocomplete="off">
          <label class="btn btn-outline-primary" for="btncheck3">연애,결혼</label>

          <input type="checkbox" class="btn-check" id="btncheck4" autocomplete="off">
          <label class="btn btn-outline-primary" for="btncheck4">자기이해</label>
        </div>
      </div>

      <div>
        <button>가입하기</button>
      </div>
    </form>


  </div>
</template>
<script>
  import { mapActions} from 'vuex'
  import CareerList from '@/views/member/components/CareerList'
  import CareerForm from '@/views/member/components/CareerForm'

export default {
  name: 'SignupCounselor',
  components: {
    CareerList,
    CareerForm,
  },
  data() {
    return {
      credentials: {
        username: '',
        password1: '',
        password2: '',
        nickname: '',
      }
    }
  },
  setup() {},
  created() {
  
  },
  mounted() {},
  unmounted() {},
  methods: {
    ...mapActions(['signup'])
    
  }
}
</script>
