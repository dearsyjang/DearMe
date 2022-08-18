<template>
  <div>
    <div class="container">
      <span class="board-text-bold form-label board-text-title" id="group-toggle" @click="openCloseToc()">내가 속한 그룹 상담방 <i class="bi bi-caret-down-fill"></i></span>
      <span class="badge mypage-badge rounded-pill mx-1">{{ mygroup.length }}</span>
      <my-group-list-comp :groups="mygroup" id="group-toc-content" ></my-group-list-comp>
    </div>
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
    this.fetchMyGroup()
  },
  mounted() {},
  unmounted() {},
  methods: {
    ...mapActions(['fetchMyGroup',]),

    openCloseToc: function() {
    if(document.getElementById('group-toc-content').style.display === 'block') {
      document.getElementById('group-toc-content').style.display = 'none';
    } else {
      document.getElementById('group-toc-content').style.display = 'block';
    }
  }
  },
  computed: {
    ...mapGetters(['mygroup'])
  },
}
</script>
<style >
   #group-toc-content {
    display: none;
  }
  #group-toggle {
    cursor: pointer;
    color: black;
  }
  #group-toggle:hover {
    text-decoration: none;
  }
  .mypage-badge{
    background-color: #595892;
  }
</style>
