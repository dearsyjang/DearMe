<template>
  <div>
    <div id="Group">
      <p>그룹 모음 ▼</p>
      <my-group-listt-comp class="d-flex justify-content-around"></my-group-listt-comp>
    </div>
  </div>
</template>
<script>
import myGroupListtComp from './myGroupListComp.vue'
export default {
  components: {
    myGroupListtComp
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
