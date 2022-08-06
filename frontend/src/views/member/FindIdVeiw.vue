<template>
  <div class="container">
    <div>
      <h1>아이디 찾기</h1>
    </div>
    <div class="form-group mt-4">
      <label class="form-label mx-2" for="email">이메일</label>
      <input id="id-input" type="text" class="form-control" placeholder="이메일">
    </div>
    <div id="findid-button" class="form-group mt-4 mx-2">
      <button class="btn">아이디 찾기</button>
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
#id-input {
  width: 100%;
  height: auto;
}

#findid-button {
  width: 100%;
  height: auto;
  background-color: #E8E8E8;
  color: #495464;
  border-radius: 7px;
  margin:0%;
}
</style>