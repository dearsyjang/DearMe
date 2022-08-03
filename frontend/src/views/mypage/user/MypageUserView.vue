<template>
  <div class="mypage">
    <info-comp id="info"></info-comp>
    <my-board-comp id="myboard"></my-board-comp>
    <my-group-comp id="mygroup"></my-group-comp>
    <my-favorite-comp id="myfavorite"></my-favorite-comp>
  </div>
</template>
<script>
import infoComp from './components/infoComp.vue'
import myBoardComp from './components/myBoardComp.vue'
import myGroupComp from './components/myGroupComp.vue'
import myFavoriteComp from './components/myFavoriteComp.vue'
export default {
  components: {
    infoComp,
    myBoardComp,
    myGroupComp,
    myFavoriteComp
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
<style>
* {
  border: 1px black solid;
}
</style>