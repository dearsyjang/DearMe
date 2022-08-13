<template>
<div class="container Favorite">
  <div class="form-group row">
    <p class="col-sm-4" >정윤해</p>
    <p class="col-sm-4" >상담 횟수 : 1회</p>
    <button class="col-sm-4 btn btn-primary">상담사 프로필</button>
  </div>
</div>
</template>
<script>
export default {
  components: {},
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
  .Favorite {
    background-color: #F0F5F9;
  }
  p, button {
    width: 160px;
    display: table-cell;
  }
</style>
