<template>
<div class="container direction-rtl">
  <!-- <div class="row " v-for="group in groups" :key="group"></div> -->
    <div class="row ">
      <div class="card">
        <div class="card-body">
          <div class="row"  >
            <p class="col-sm-4">상담사 이름</p>
            <p class="col-sm-4">상담 횟수 : 1 회</p>
            <!-- <p class="col-sm-4">{{ group.title }}</p>
            <p class="col-sm-4">{{ group.date[0] }}.{{ group.date[1] }}.{{ group.date[2] }}</p> -->
            <button class="col-sm-4 btn btn-primary">상담사 프로필</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  components: {},
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
  /* .Favorite {
    background-color: #F0F5F9;
  }
  p, button {
    width: 160px;
    display: table-cell;
  } */
</style>
