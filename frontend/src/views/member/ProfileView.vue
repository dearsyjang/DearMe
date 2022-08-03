<template>
  <h1>회원 정보</h1>
  <div>
    <div>
      <label for="username">아이디 </label> <br>
        <div>{{ profile.username }}</div>
    </div>

    <div>
      <label for="current-password">현재 비밀번호 </label> <br>
        <div>{{ profile.userpassword }}</div>
    </div>

    <div>
      <label for="new-password1">새 비밀번호 </label> <br>
      <input v-model="credentials.password1" type="password" id="new-password1" required />
    </div>

    <div>
      <label for="new-password1">새 비밀번호 확인 </label> <br>
      <input v-model="credentials.password2" type="password" id="new-password2" required />
    </div>

    <div>
      <label for="birthday">출생년도 </label> <br>
      <div>{{ profile.birthday }}</div>
    </div>

    <div>
      사진
    </div>

    <div>
      <label for="gender">성별 </label> <br>
      <div>성별 받아와야됨</div>
    </div>

    <div>
      <label for="e-mail">이메일</label> <br>
      <div>{{ profile.e-mail}}</div>
    </div>

    <div>
      <label for="nickname">닉네임 </label> <br>
      <input  v-model="credentials.nickname" type="text" id="nickname" required/>
      <button>중복확인</button>
    </div>

    <button>수정하기</button> <br>
    <button>탈퇴하기</button>
    
  </div>
</template>
<script>
export default {
  components: {},
  data() {
    return {
      sampleData: ''
    }
  },
  setup() {},
  created() {},
  mounted() {},
  unmounted() {},
  methods: {}
}
</script>