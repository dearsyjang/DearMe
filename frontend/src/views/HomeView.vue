<template>
<div id="home">
    <div class="card">
      <div class="card-body">
      <h5 class="card-title">Dear Me</h5>
      <br>
      <div class="card-text">
        서비스 소개  어쩌고저쩌고
      </div>
      </div>
    </div>
    <br>
      <router-link :to="{ name:'login' }"><button id="login-button" class="btn">로그인</button></router-link>
      <router-link :to="{ name:'signupuser' }"><button id="signup2-button" class="btn">일반 회원가입</button></router-link>
      <router-link :to="{ name:'signupcounselor' }"><button id="signup2-button" class="btn">상담사 회원가입</button></router-link>
</div>
</template>

<script>

export default {
}
</script>

<style scoped>
.card {
  justify-content: center;
  width: auto;
  height: 280px;
  margin-bottom: 25px;
  background-color: #F9F7F7;
  border-style: none;
}

#signup-button {
  background-color: #A7BBC7;
  width: 100%;
  height: auto;
  color: white;
  border-width: 0px;
  border-radius: 5px;
  margin-bottom: 20px;
}

#signup2-button {
  background-color: #F1D00A;
  width: 100%;
  height: auto;
  color: white;
  border-width: 0px;
  border-radius: 5px;
  margin-bottom: 20px;
}

#login-button {
  background-color: #3F72AF;
  width: 100%;
  height: auto;
  color: white;
  border-width: 0px;
  border-radius: 5px;
  margin-bottom: 20px;
}
</style>
