<template>
<div class="page-content-wrapper py-3">
  <div class="blog-wrapper direction-rtl">
    <div class="container">
      <div class="row g-3">
        <div class="col-6 col-sm-4 col-md-3">
          <div class="card position-relative shadow-sm">
            <div v-if="re.counselorId== currentUser.data.userId && re.status==`ACCEPTED` && re.groupId == null && today==`${re.year}-${re.month}-${re.day}`"
            id="today-personal-card" >
            <router-link :to="{ name: 'CounselingRequestDocument', params : {counselingId : re.id}}">
            <div class="card-body">
              <span class="badge bg-danger rounded-pill mb-2 d-inline-block"><i class="bi bi-hand-thumbs-up-fill"></i>{{idx}}</span>
              <h4 class="blog-title d-block text-dark board-title">상담 번호: {{re.counselingDocumentId}}</h4>
              <button>상담방 입장</button>
              <!-- <h6>상담일 : {{re.year}}/{{re.month}}/{{re.day}}</h6> -->
            </div>
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
    re: Object
  },
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
  .BoardList {
    background-color: #F0F5F9;

  }
  p, button {
    width: 160px;
    display: table-cell;
  }
</style>