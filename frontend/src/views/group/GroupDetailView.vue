<template>
  <div>
    <group-info-vue></group-info-vue>
    <group-content-vue></group-content-vue>
  </div>
</template>
<script>
import groupContentVue from './components/groupContent.vue'
import groupInfoVue from './components/groupInfo.vue'
export default {
  components: {
    groupContentVue,
    groupInfoVue
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
