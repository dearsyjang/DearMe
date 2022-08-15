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

body{
  background-color: #F9F7F7;
}
</style>
