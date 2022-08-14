<template>
  <div id="app">
    <top-bar></top-bar>
    <div class="body">
      <router-view/>
    </div>
    <bottom-bar></bottom-bar>
  </div>
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
  flex-direction:column;
  justify-content: center;
  align-items:center;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: black;
}

.body {
  width: 100%;
  height: 77vh;
  padding: 50px;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
}
</style>
