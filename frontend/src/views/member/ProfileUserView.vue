
<template>
  <div>

    아이디 : {{currentUser.data.id}}
    <hr>
    비밀번호 : {{currentUser.data.pw}}
    <hr>
    닉네임 : {{currentUser.data.nickname}}
    <hr>
    사진 : {{currentUser.pictureUrl}}
    <hr>
    이메일 : {{currentUser.data.email}}
    <hr>
    성별 : {{currentUser.data.gender}}

  </div>
</template>

<script>

  import {  mapActions, mapGetters} from 'vuex'

  export default {
    name: 'ProfileUserView',


    computed : {
    ...mapGetters(['currentUser']),
    },
    methods: {
    ...mapActions(['fetchCurrentUser']),

    },
    
  created() {
    this.fetchCurrentUser()
  },
}
</script>



<style>



</style>