<template>
<div>
  <div class="container">
    <div class="type card text-center my-2">
      <h1 class="card-title my-2">취업준비생</h1>
      <router-link :to="{name: 'signupuser', params:{type: 'USER'}}">
        <img src="@/assets/images/img/bg-img/user.png" alt="">
      </router-link>
    </div>
    <div class="type card text-center">
      <h1 class="card-title my-2">심리상담사</h1>
      <router-link :to="{name: 'signupcounselor', params:{type: 'COUNSELOR'}}">
        <img src="@/assets/images/img/bg-img/doctor.png" alt="">
      </router-link>
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
.type {
  height: 250px;
}
img {
  height: 200px;
}
</style>