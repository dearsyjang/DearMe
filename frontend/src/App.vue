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
@import './assets/css/style.css';
@import './assets/css/topbar.css';
@import url('https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap');
* {
  font-family: 'Gowun Dodum', sans-serif;
}

#app {
  display:flex;
  flex-direction:column;
  justify-content: center;
  position: relative;
  z-index: 1;
  background-color: #F9F7F7;
}
html, body{
  width: 100%;
  height: 100%;
  margin: 0;
  padding: 0;
  background-color: #F9F7F7;
}
</style>
