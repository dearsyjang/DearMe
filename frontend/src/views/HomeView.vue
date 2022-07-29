<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
    <LoginView></LoginView>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import LoginView from '@/views/member/LoginView.vue'
export default {
  name: 'HomeView',
  components: {
    HelloWorld,
    LoginView
  }
}
</script>
