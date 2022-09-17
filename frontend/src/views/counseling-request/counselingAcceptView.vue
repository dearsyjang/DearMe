<template>
<div class="page-content-wrapper py-3 board-bg">
  <div class="shop-pagination pb-3">
    <div class="container">
      <div class="card ">
        <div class="card-body m-2">
          <div class="d-flex align-items-center justify-content-between">
            <small class="ms-1 board-text-index">수락 대기 중인 상담</small>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="top-products-area product-list-wrap">
    <div class="container">
      <div class="row g-3">
          <div class="card " >
            <div class="board-card-radius card-body board-card-bg">
              <!-- <router-link :to="{ name: 'boardDetail', params: {boardId: board.id }}"> -->
                <div class="d-flex justify-content-between">
                  <div>
                    <h2>상담 번호 : {{ this.credentials.id }}</h2>
                    <h4>회원 ID : {{ this.userID }}</h4>
                    <!-- <h2 class="card-title">{{personalInfo.userId}}</h2> -->
                  </div>
                  <div>
                    <button @click="isAccept()" class="mx-2 w-btn-accept">수락</button>
                    <button @click="isReject()" class="w-btn-cancel">거절</button>
                  </div>
                </div>
                <!-- <div>
                  <h5>상담일 : {{personalInfo.year}}/{{personalInfo.month}}/{{personalInfo.day}}</h5>
                  {{personalInfo}}
                </div> -->
               <!-- </router-link> -->
                 <div class="my-3">
                   상담 신청 내용
                 </div>
                 <router-link :to="{name:'findCalendar', params: {USERID: this.userID}}" >
                 <div class="text-end">
                   <button class="w-btn-diary">감정달력</button>
                 </div>
                 </router-link>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { mapActions, mapGetters } from 'vuex';
export default {
  components: {},
  data() {
    return {
      credentials : {
        id : this.$route.params.id,
        status: 'UNACCEPTED'
      },
      userID: this.$route.params.userid

    }
  },
  setup() {},
  created() {
  },
  mounted() {},
  unmounted() {},
  methods: {
    ...mapActions(['counselingAccept', 'requests','currentUser']),
    isAccept() {
      const data = {
        id: this.credentials.id,
        status: 'ACCEPTED'
      }
      this.counselingAccept(data)
      console.log(data)
    },
    isReject() {
      const data = {
        id: this.credentials.id,
        status: 'REJECT'
      }
      this.counselingAccept(data)
      console.log(data)
    },
  },
  computed: {
    ...mapGetters([ 'fetchCurrentUser']),
  }
}
</script>
<style>
.w-btn-accept {
    /* position: relative; */
    border: none;
    min-width: 90px;
    min-height: 30px;
    background: linear-gradient(
        90deg,
        #5B5792 0%,
        #5B5792 100%
    );
    border-radius: 1000px;
    color: darkslategray;
    cursor: pointer;
    box-shadow: 12px 12px 24px #76769a1a;
    font-weight: 500;
    transition: 0.3s;
    color: #E8E5DC;
    font-size:14px
}
.w-btn-cancel {
    /* position: relative; */
    border: none;
    min-width: 90px;
    min-height: 30px;
    background: linear-gradient(
        90deg,
        #EFCC70 0%,
        #EFCC70 100%
    );
    border-radius: 1000px;
    color: darkslategray;
    cursor: pointer;
    box-shadow: 12px 12px 24px #76769a1a;
    font-weight: 500;
    transition: 0.3s;
    color: #1E1E42;
    font-size:14px
}
.w-btn-diary {
    /* position: relative; */
    border: none;
    min-width: 90px;
    min-height: 30px;
    background: linear-gradient(
        90deg,
        #1E1E42 0%,
        #1E1E42 100%
    );
    border-radius: 1000px;
    color: darkslategray;
    cursor: pointer;
    box-shadow: 12px 12px 24px #76769a1a;
    font-weight: 500;
    transition: 0.3s;
    color: #E8E5DC;
    font-size:14px
}
.board-btn-index {
  background-color: #1E2022;
  color: white;
  border: none;
}
.board-btn-edit {
  background-color: #52616B;
  color: white;
  border: none;
}
.board-btn-submit {
  background-color: #262A53;
  color: white;
  border: none;
}
.board-btn-detail {
  background-color: #FFA0A0;
  color: white;
  border: none;
}
</style>