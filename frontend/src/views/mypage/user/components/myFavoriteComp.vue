<template>
  <div>
    <div class="container">
      <span class="board-text-bold form-label board-text-title" id="toc-toggle" @click="openCloseToc()">즐겨찾는 상담사 <i class="bi bi-caret-down-fill"></i></span>
      <span class="badge mypage-badge rounded-pill mx-1">1</span>
      <my-favorite-list-comp :myFavorite="favorite.data" id="toc-content3" ></my-favorite-list-comp>
    </div>
  </div>
</template>
<script>
import { mapActions, mapGetters  } from 'vuex';
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
  created() {
    this.favoriteGet()

  },
  mounted() {},
  methods: {
    ...mapActions(['favoriteGet']),
    openCloseToc: function() {
    if(document.getElementById('toc-content3').style.display === 'block') {
      document.getElementById('toc-content3').style.display = 'none';
    } else {
      document.getElementById('toc-content3').style.display = 'block';
    }
  }
  },
  computed: {
    ...mapGetters(['favorite'])
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