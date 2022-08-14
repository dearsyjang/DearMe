<template>
  <div id="app">
    <top-bar></top-bar>
    <bottom-bar></bottom-bar>
  </div>
  <router-view/>
</template>

<script>
import TopBar from '@/views/home/TopBarView.vue'
import BottomBar from '@/views/home/BottomBarView.vue'
import "bulma/css/bulma.css"

  export default {
    name: 'App',
    components: { TopBar, BottomBar },
    methods : {}
  }

</script>

<style>
/* @import '../assets/css/style.css'; */
@import './assets/css/member.css';
@import './assets/css/topbar.css';

/* #app {
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
} */
</style>
