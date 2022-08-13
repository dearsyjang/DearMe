<template>
  <div class="login-wrapper d-flex align-items-center justify-content-center">
    <div class="custom-container">
      <div class="text-center px-4 my-3">
        <h1 class="mb-3 text-center">비밀번호 찾기</h1>
        <img class="login-intro-img" src="@/assets/images/img/bg-img/loginImg.jpg" alt="">
      </div>

      <div class="register-form mt-4">
        <form action="page-forget-password-success.html">
          <div class="form-group text-start mb-3">
            <input class="form-control" type="text" placeholder="id를 입력하시오.">
          </div>
          <button class="btn btn-primary w-100" type="submit">비밀번호 찾기</button>
        </form>
      </div>
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
img {
  width: 300px;
}
</style>
