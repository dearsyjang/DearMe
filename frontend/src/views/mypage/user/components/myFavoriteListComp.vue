<template>
<div class="container direction-rtl">
    <div class="row ">
      <div class="card">
        <div class="card-body">
          <div class="row"  >
            <p class="col-sm-4">상담사 이름</p>
            <button class="col-sm-4 btn btn-primary">상담사 프로필</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { mapGetters, mapActions } from 'vuex';
export default {
  components: {},
  data() {
    return {
      sampleData: ''
    }
  },
  setup() {},
  created() {
    this.fetchFavorite()
  },
  mounted() {},
  unmounted() {},
  methods: {
    ...mapActions(['fetchFavorite']),

  },
  computed: {
    ...mapGetters(['myfavorite'])
  }
}
</script>
<style scoped>
  /* .Favorite {
    background-color: #F0F5F9;
  }
  p, button {
    width: 160px;
    display: table-cell;
  } */
</style>
