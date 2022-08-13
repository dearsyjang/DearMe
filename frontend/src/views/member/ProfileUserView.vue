<template>
  <div>
    <form @submit.prevent="updateprofile()">

      아이디 : {{currentUser.data.id}}
      <hr>
      비밀번호 : {{currentUser.data.pw}}
      <hr>
      <div class="form-group has-success">
        <label class="form-label mt-2" for="password1">새 비밀번호</label>
        <input type="password" class="form-control is-valid" placeholder="비밀번호" v-model="credentials.password1">
      </div>
      <div class="form-group has-danger">
        <label class="form-label mt-2" for="password2">새 비밀번호 확인</label>
        <input type="password" class="form-control is-valid" placeholder="비밀번호 확인" v-model="credentials.password2">
        <div class="invalid-feedback">비밀번호가 일치하지 않습니다.</div>
      </div>
      <hr>
      닉네임 : {{currentUser.data.nickname}}
      <hr>
      <div class="form-group">
        <label class="form-label mt-2" for="nickname">닉네임</label>
        <div class="row">
          <input type="text" class="form-control col-sm-6 mx-3" placeholder="닉네임" id="inputId" v-model="credentials.nickName">
          <button @click="idCheck()" class="btn btn-primary col-sm-3" id="sameId">중복검사</button>
        </div>
      </div>
      <hr>
      사진 : {{currentUser.pictureUrl}}
      <hr>
      이메일 : {{currentUser.data.email}}
      <hr>
      성별 : {{currentUser.data.gender}}
    
      <button type="submit">수정하기</button>
    </form>

    <button>탈퇴하기</button>

  </div>
</template>

<script>

  import {  mapActions, mapGetters} from 'vuex'

  export default {
    data() {
      return {
        iscounselor: ,
        credentials: {
          pw: '',
          nickName: '',
          
        }

      }
    },
    name: 'ProfileUserView',


    computed : {
    ...mapGetters(['currentUser']),
    },
    methods: {
    ...mapActions(['fetchCurrentUser']),
    ...mapActions(['updateProfile']),

    },
    
  created() {
    this.fetchCurrentUser()
  },
}
</script>



<style>



</style>