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
      groupId: this.$route.params.groupId,
    };
  },
  setup() {},
  created() {
    this.fetchGroup(this.groupId)
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
