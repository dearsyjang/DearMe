<template>
  <div>
    <div class="mymy">
      <div class="my-profile">
        <br>
        <br>
        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-circle" viewBox="0 0 16 16">
  <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
  <path d="M10.97 4.97a.235.235 0 0 0-.02.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-1.071-1.05z"/>
</svg>
        <h1>{{ profile.username }}</h1>
        <h1>{{ profile.id }}</h1>
        <h1>{{ profile.email }}</h1>
        <h1>{{ profile.birth }}</h1>
        <h1>{{ profile.gender }}</h1>

        <div class="changepasw">
          <button @click="passwordChange()" class="changebtn">비밀번호변경</button> 
        </div>
        <br>
     
      <br>
 
</div>



    </div>


    
  </div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex'


export default {
  name: 'MyProfileView',
  computed: {
    ...mapGetters(['profile'])
  },
  methods: {
    ...mapActions(['fetchProfile']),
    passwordChange() {
      this.$router.push('/passwordChange')
    }
  },
  created() {
    const payload = { id: this.$route.params.id }
    this.fetchProfile(payload)
  },
}
</script>


<style>


.mymy{
  margin: 50px;
}
.changebtn
{
  background : #1A1D29;
  border: white;
  color: white;
}
.accordion-item{
  background : #1A1D29;
}

.accordion-button{
  background : #1A1D29;
  color: white;
}


.changepasw{
  float: right;
 
}
</style>