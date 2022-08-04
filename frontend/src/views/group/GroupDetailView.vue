<template>
  <div>
    <group-info-vue class="groupInfo"></group-info-vue>
    <group-content-vue class="groupContent"></group-content-vue>
  </div>
</template>
<script>
import groupContentVue from "./components/groupContent.vue";
import groupInfoVue from "./components/groupInfo.vue";
export default {
  components: {
    groupContentVue,
    groupInfoVue,
  },
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
.groupInfo {
  height: 20%;
  margin-bottom: 20px;
}
.groupContent {
  height: 70%;
}
</style>
