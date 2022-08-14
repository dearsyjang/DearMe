<template>
  <div>
    <div class="container">
      <span id="toc-toggle" @click="openCloseToc()">즐겨찾기 ▼ </span>
      <!-- <span class="badge bg-primary rounded-pill">{{ favorite.length }}</span> -->
    </div>
    <my-favorite-list-comp id="toc-content3"></my-favorite-list-comp>
  </div>
</template>
<script>
import myFavoriteListComp from './myFavoriteListComp.vue'
export default {
  components: {
    myFavoriteListComp
  },
  data() {
    return {
      sampleData: ''
    }
  },
  setup() {},
  created() {},
  mounted() {},
  unmounted() {},
  methods: {
    openCloseToc: function() {
    if(document.getElementById('toc-content3').style.display === 'block') {
      document.getElementById('toc-content3').style.display = 'none';
    } else {
      document.getElementById('toc-content3').style.display = 'block';
    }
  }
  }
}
</script>
<style scoped>
   #toc-content3 {
    display: none;
  }
  #toc-toggle {
    cursor: pointer;
    color: black;
  }
  #toc-toggle:hover {
    text-decoration: none;
  }
</style>