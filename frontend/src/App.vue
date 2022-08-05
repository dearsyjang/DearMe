<template>
  <div id="app">
    <top-bar></top-bar>
    <bottom-bar></bottom-bar>
  </div>
  <nav>
    <router-link to="/member/login">login</router-link> |
    <router-link to="/member/signupuser">signup(user)</router-link> |
    <router-link to="/member/signupcounselor">signup(counselor)</router-link> |
  </nav>
  <router-view/>
</template>

<script>
import TopBar from '@/views/home/TopBarView.vue'
import BottomBar from '@/views/home/BottomBarView.vue'
import "bulma/css/bulma.css"

  export default {
    name: 'App',
    components: { TopBar, BottomBar },
  }
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
