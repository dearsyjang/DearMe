<template>
  <div>
    <!-- user / counselor 같은 컴포넌트 사용 (v-if로 구분) -->
    <!-- <div v-if="isCounselor===true">
      <p>운영 중인 그룹 ▼</p>
      <button>그룹 생성</button>
      <my-group-listt-comp class="d-flex justify-content-around"></my-group-listt-comp>
    </div> -->
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
