<template>
  <div>
    <h1>상담 신청하기</h1>
        <br>
        <p>신청자 : 이름 떠야됨</p>
        <br>
        <span></span>
        <p style="white-space: pre-line">{{ message }}</p>
        <br>
        <textarea v-model="message" placeholder="내용을 작성하시오..."></textarea>
        <br>
        <div class="form-check form-switch">
            <input class="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckChecked" checked>
            <label class="form-check-label" for="flexSwitchCheckChecked"></label>
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

<style>
</style>