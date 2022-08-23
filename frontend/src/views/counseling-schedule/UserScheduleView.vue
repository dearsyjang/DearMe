<template>
<div>
  <div class="page-content-wrapper py-3 board-bg">
    <div class="shop-pagination pb-3">
      <div class="container">
        <div class="card">
          <div class="card-body p-2">
            <div class="d-flex align-items-center justify-content-between">
              <small class="ms-1 board-text-index ">1 : 1 상담 일정</small>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- <div class="page-content-wrapper py-3"> -->
  <div class="blog-wrapper direction-rtl">
    <div class="container">
        <div v-for="(counseling, idx) in counselings.data.counselings" :key="idx" :counseling="counseling">
        <div v-if="counseling.status==`ACCEPTED` && counseling.groupId == null">
          <div class="card position-relative">
            <div class="card-body ">
              <router-link :to="{ name: 'counseling', params: { counselingId: counseling.id, counselorId:counseling.counselorId}}">
              <div class="d-flex justify-content-around">
                <div>
                  <h4 class="blog-title d-block text-dark board-title">상담사 : {{ counseling.counselorNickName }}</h4>
                  <p>상담일: {{ counseling.year }}. {{ counseling.month }}. {{ counseling.day }}</p>
                </div>
                <div >
                  <button class="w-btn w-btn-charge" >상담방 입장</button>
                </div>
              </div>
              </router-link>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="page-content-wrapper py-3 board-bg">
  <div class="shop-pagination pb-3">
    <div class="container">
      <div class="card">
        <div class="card-body p-2">
          <div class="d-flex align-items-center justify-content-between">
            <small class="ms-1 board-text-index ">그룹 상담 일정</small>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- <div class="page-content-wrapper py-3"> -->
  <div class="blog-wrapper direction-rtl">
    <div class="container">
        <div v-for="(counseling, idx) in counselings.data.counselings" :key="idx" :counseling="counseling" >
        <div v-if="counseling.status==`ACCEPTED` && counseling.groupId != null">
          <div class="card position-relative">
            <div class="card-body ">
              <router-link :to="{ name: 'counseling', params: { counselingId: counseling.id, counselorId:counseling.counselorId }}">
              <div class="d-flex justify-content-around">
                <div>
                  <h4 class="blog-title d-block text-dark board-title">상담사 : {{ counseling.counselorNickName }}</h4>
                  <p>상담일: {{ counseling.year }}. {{ counseling.month }}. {{ counseling.day }}</p>
                </div>
                <div >
                  <button class="w-btn w-btn-charge" >상담방 입장</button>
                </div>
              </div>
              </router-link>
            </div>
          </div>
          </div>
      </div>
    </div>
  </div>
</div>
</div>
</div>


</template>

<script>
import { mapActions, mapGetters } from 'vuex'
// 사용자 스케줄 => /counseling-schedule/userschedule 혹은 하단바


export default {
    name:'UserSchedule',
    data() {
      return {
        counselingId: this.$route.params.counselingId,
      }
    },
    computed: {
      ...mapGetters(['counselings', 'currentUser']),
    },
    methods: {
      ...mapActions(['fetchSchedules', 'fetchCurrentUser'])
    },
    created() {
      this.fetchSchedules()
      this.fetchCurrentUser()
      console.log(this.counseling)
    },
    mounted(){
    },
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap');
* {
  font-family: 'Gowun Dodum', sans-serif;
}
hr {
  width: 100%;
}

#userschedule-title{
  text-align:center;
}
#userschedule-personal, #userschedule-group {
  text-align: left;
}

#user-enter-button{
  float: right;
}
.personal-card-title{
  padding:5px;
  text-align:center;
}
</style>