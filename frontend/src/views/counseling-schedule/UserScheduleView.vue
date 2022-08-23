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

    <!--카드 밑에 줄이 자꾸 생겨서 border 다 뺏습니다-->
    <div class="top-products-area product-list-wrap">
      <div class="container">
        <div v-for="(counseling, idx) in counselings.data.counselings" :key="idx" :counseling="counseling" class="card mb-2">
            <div v-if="counseling.status==`ACCEPTED` && counseling.groupId == null" class="card-body d-flex align-items-stretch">
              <div class="user-info">
                <div class="d-flex align-items-center">
                  <div>
                    <h5 class="mb-1 board-text-bold">상담사 : {{ counseling.counselorNickName }}</h5>
                  </div>
                  <div class="mx-2">
                    <span class="badge bg-warning ms-2 rounded-pill">1 : 1</span>
                  </div>
                </div>
                <div class="d-flex align-items-center">
                  <div>
                    <p class="m-0 me-4 board-mypoint board-text-bold">상담일: {{ counseling.year }}. {{ counseling.month }}. {{ counseling.day }}</p>
                  </div>
                  <div class="mx-5">
                    <router-link :to="{ name: 'counseling', params: { counselingId: counseling.id }}">
                    <button class="w-btn w-btn-charge" >상담방 입장</button>
                    </router-link>
                  </div>
                </div>
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
  <div class="top-products-area product-list-wrap">
    <div class="container">
      <div v-for="(counseling, idx) in counselings.data.counselings" :key="idx" :counseling="counseling" class="card mb-2">
          <div v-if="counseling.status==`ACCEPTED` && counseling.groupId != null" class="card-body d-flex align-items-center">
            <div class="user-info">
              <div class="d-flex align-items-center">
                <div>
                  <h5 class="mb-1 board-text-bold">상담사 : {{ counseling.counselorNickName }}</h5>
                </div>
                <div class="mx-2">
                  <span class="badge bg-warning ms-2 rounded-pill">GROUP</span>
                </div>
              </div>
              <div class="d-flex align-items-center">
                <div>
                  <p class="mb-0 me-4 board-mypoint board-text-bold">상담일: {{ counseling.year }}. {{ counseling.month }}. {{ counseling.day }}</p>
                </div>
                <div class="mx-5">
                  <router-link :to="{ name: 'counseling', params: { counselingId: counseling.id }}">
                  <button class="w-btn w-btn-charge" >상담방 입장</button>
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
    <!-- <div v-if="currentUser.data.type==`USER`">
      <h1 id="userschedule-title">상담 일정</h1>
      <hr>
      <br>
      <h2 id="userschedule-personal">1:1 상담</h2>
      <div v-for="(counseling, idx) in counselings.data.counselings" :key="idx" :counseling="counseling">
        <div v-if="counseling.status==`ACCEPTED` && counseling.groupId == null" class="card" style="width: 18rem; height: 10rem;" id="user-personal-card">
          <div class="personal-request-index" style="text-decoration: none">{{idx}}</div>
          <h5 class="personal-card-title">상담일: {{ counseling.year }}. {{ counseling.month }}. {{ counseling.day }}</h5>
          <h5 class="personal-card-title">상담사: {{ counseling.counselorNickName }}</h5>
          <router-link :to="{ name: 'counseling', params: { counselingId: counseling.id }}"><button  class="btn" id="user-enter-button">상담방 입장</button></router-link>
        </div>
      </div>
      <h2 id="userschedule-group">그룹 상담</h2>
      <div v-for="(counseling, idx) in counselings.data.counselings" :key="idx" :counseling="counseling">
        <div v-if="counseling.status==`ACCEPTED` && counseling.groupId != null" class="card" style="width: 18rem; height: 8rem;">
          <h5 class="card-title">상담일: {{ counseling.year }}. {{ counseling.month }}. {{ counseling.day }}</h5>
          <h5 class="card-title">상담사: {{ counseling.counselorNickName }}</h5>
          <router-link :to="{ name: 'counseling', params: { counselingId: counseling.id }}"><button  class="btn" id="enter-button">상담방 입장</button></router-link>
      </div>
    </div>
  </div> -->

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
    }
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
