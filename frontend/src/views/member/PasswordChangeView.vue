<template>
  <div>
    <h1 style="text-align:center">비밀번호 변경</h1>

    
    <div class="change-box">
      <form class="change-form" @submit.prevent="changePassword(credentials)">

        <div class="form-item">
          <input v-model="credentials.new_password1" type="password" placeholder="변경할 비밀번호" id="new_password1" required />
        </div>

        <div class="form-item">
          <input v-model="credentials.new_password2" type="password" placeholder="비밀번호확인" id="new_password2" required />
        </div>

        <button class="change-btn">비밀번호 변경</button>
        
      </form>
    </div>
  </div>


</template>

<script>
  import { mapActions, mapGetters } from 'vuex'


  export default {
    name: 'PasswordChangeView',

    data() {
      return {
        credentials: {
          new_password1: '',
          new_password2: '',
        }
      }
    },
  computed: {
      ...mapGetters(['authError'])
    },
    methods: {
      ...mapActions(['changePassword'])
    },
  }
</script>

<style>

.change-form {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-content: center;
  margin: 0 auto;
  width : 400px;
  height: 200px;
  background-color: #1A1D29;
  border: 1px solid white;
}

#new_password1 {
  height: 1.5rem;
  width: 22rem;
  
}

#new_password2 {
  height: 1.5rem;
  width: 22rem;
  
}
.change-btn {
  margin: 0.6rem;
  height: 2em;
  width: 20rem;
  font-size: 1.5rem;
  position: relative;
  left: 7%
}



</style>
