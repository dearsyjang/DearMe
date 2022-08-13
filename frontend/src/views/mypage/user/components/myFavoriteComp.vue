<template>
  <div>
    <p>즐겨찾기 모음 ▼</p>
    <my-favorite-list-comp class="d-flex justify-content-around"></my-favorite-list-comp>
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
  methods: {}
}
</script>
<style scoped>
  p {
      text-align: left;
      color: #1E2022;
    }
</style>
