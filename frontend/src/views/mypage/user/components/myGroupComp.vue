<template>
  <div>
    <div class="container">
      <span id="toc-toggle" @click="openCloseToc()">나의 그룹 상담 ▼ </span>
      <!-- <span class="badge bg-primary rounded-pill">{{ groups.length }}</span> -->
    </div>
    <my-group-list-comp id="toc-content2"></my-group-list-comp>
    <!-- <my-group-list-comp :groups="groups" id="toc-content"></my-group-list-comp> -->
  </div>
</template>
<script>
import { mapActions, mapGetters } from 'vuex'
import myGroupListComp from './myGroupListComp.vue'
export default {
  components: {
    myGroupListComp
  },
  data() {
    return {
      sampleData: ''
    }
  },
  setup() {},
  created() {
    // this.fetchGroups()
  },
  mounted() {},
  unmounted() {},
  methods: {
    ...mapActions(['fetchGroups',]),

    openCloseToc: function() {
    if(document.getElementById('toc-content2').style.display === 'block') {
      document.getElementById('toc-content2').style.display = 'none';
    } else {
      document.getElementById('toc-content2').style.display = 'block';
    }
  }
  },
  computed: {
    ...mapGetters(['groups'])
  },
}
</script>
<style scoped>
   #toc-content2 {
    display: none;
  }
  #toc-toggle {
    cursor: pointer;
    color: black;
  }
  #toc-toggle:hover {
    text-decoration: none;
  }
</style>
