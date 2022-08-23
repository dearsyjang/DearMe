<template>
<div class="page-content-wrapper py-3">
  <div class="blog-wrapper direction-rtl">
    <div class="container">
      <div class="row g-3">
        <div class="col-6 col-sm-4 col-md-3">
          <div v-for="favorite in myFavorite" :key="favorite" class="card position-relative shadow-sm">
            <div class="card-body">
              <router-link :to="{ name: 'counselorProfile', params: {counselorId: favorite.counselorId }}">
              <span class="badge bg-danger rounded-pill mb-1 d-inline-block"><i class="bi bi-hand-thumbs-up-fill"></i>{{ favorite.nickName}}</span>
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
    myFavorite: Array,
  },
  components: {},
  data() {
    return {

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
.bg-p {
  background-color: #5B5792
}
</style>
