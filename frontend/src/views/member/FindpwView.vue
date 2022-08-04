<template>
  <div>
    <h1>비밀번호 찾기</h1>
  </div>
   <br>
  <div>
    <label for="username">아이디 </label> <br>
    <input  v-model="credentials.username" type="text" id="username" required/>
  </div>
   <br>
  <div class="input-group mb-3">
    <label for="e-mail">이메일</label> <br>
    <input type="text" class="form-control">
     <span class="input-group-text">@</span>
    <input type="text" class="form-control">
  </div>

  <div>
    <button>비밀번호 찾기</button>
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