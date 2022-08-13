<template>
  <div>
      <router-link :to="{ name: 'videodiary' }"><button id="videodiary-enter-btn" class="btn"><h1>📷</h1></button></router-link>
      <button>일기 아이콘</button>
  </div>
</template>
<script>


export default {
    name : 'DayComp',
  }
</script>
<style>
</style>
