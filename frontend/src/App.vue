<template>
  <div id="app">
    <top-bar></top-bar>
  </div>
  <nav>
    <router-link to="/">Home</router-link> |
    <router-link to="/about">About</router-link> |
    <router-link to="/member/login">login</router-link> |
    <router-link to="/member/logout">Logout</router-link> |

    <router-link to="/member/signupuser">signup(user)</router-link> |
    <router-link to="/member/signupcounselor">signup(counselor)</router-link> |
    <router-link to="/counselor_list">상담사 리스트 페이지</router-link> |
    <router-link to="/home/topbar">Home</router-link> |
    <router-link to="/mypage/user">mypage(user)</router-link> |
    <router-link to="/mypage/counselor">mypage(counselor)</router-link> |



  </nav>
  <router-view/>
</template>

<script>
import TopBar from '@/views/home/TopBarView.vue'

  export default {
    name: 'App',
    components: { TopBar },
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
