<template>
  <div class="groupDetail d-flex justify-content-around">
    <div class="d-flex align-items-center">
      <p id="groupCounselor">정윤해</p>
    </div>
    <div class="d-flex align-items-center">
      <p id="counselorGrade">최고의 상담사</p>
    </div>
    <div class="d-flex align-items-center">
      <button>프로필</button>
    </div>
  </div>
</template>
<script>
export default {
  components: {},
  data() {
    return {
      sampleData: "",
    };
  },
  setup() {},
  created() {},
  mounted() {},
  unmounted() {},
  methods: {},
};
</script>
<style scoped>
.groupDetail {
  background-color: #f0f5f9;
}
#groupCounselor {
  font-size: 20pt;
  line-height: 40px;
}
#counselorGrade {
  font-size: 14pt;
  font-weight: bold;
  line-height: 50px;
}
</style>
