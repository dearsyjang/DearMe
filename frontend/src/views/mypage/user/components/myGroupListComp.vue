<template>
<div class="page-content-wrapper py-3">
  <div class="blog-wrapper direction-rtl">
    <div class="container">
      <div class="row g-3">
        <div v-for="group in groups" :key="group" class="col-6 col-sm-4 col-md-3">
          <div class="card position-relative shadow-sm">
            <div class="card-body">
              <router-link :to="{ name: 'groupDetail', params: {groupId: group.id }}">
              <span class="badge bg-nav rounded-pill mb-2 d-inline-block">
                <i class="bi bi-box-arrow-in-right"></i> 상담방 입장</span>
              <h4 class="blog-title d-block text-dark board-title">{{ group.title }}</h4>
              </router-link>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</template>
<script>
export default {
  props: {
    groups: Object
  },
  components: {},
  data() {
    return {
      sampleData: ''
    }
  },
  created() {

  },
  methods: {

  },
  computed: {

  }
}
</script>
<style >
.bg-nav {
  background-color: #1E1E42;
}
</style>
