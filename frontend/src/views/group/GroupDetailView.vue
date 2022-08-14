<template>
  <div>
    <group-info :group="group" class="groupInfo"></group-info>
    <group-content :group="group" class="groupContent"></group-content>
    <p>{{ group }}</p>
    <p></p>
  </div>
</template>
<script>
import { mapGetters, mapActions } from 'vuex'
import groupContent from "./components/groupContent.vue";
import groupInfo from "./components/groupInfo.vue";
export default {
  components: {
    groupContent,
    groupInfo,
  },
  data() {
    return {
      sampleData: "",
    };
  },
  setup() {},
  created() {
    // 상담사 프로필에서 params로 groupid 받아오기
    this.fetchGroup(1)
  },
  mounted() {},
  unmounted() {},
  computed: {
    ...mapGetters(['group']),

  },
  methods: {
    ...mapActions(['fetchGroup']),

  },
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
