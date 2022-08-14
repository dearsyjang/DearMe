<template>
  <div>
    <h1>그룹 참가 수락하기</h1>
    <div id="groupRequestName" class="d-flex justify-content-center">
      <div>신청자 : </div>
    </div>
    <div class="groupRequestContent">
      <div>
        <textarea
          rows="10"
          cols="40"
          placeholder="this.contents"
          v-model="contents"
        ></textarea>
      </div>
      <div class="d-flex justify-content-end">
        <button @click="accept()">수락</button>
        <button @click="unaccept()" class="mx-3">거절</button>
        <button @click="reject()" class="mx-3">보류</button>
      </div>
      <div v-if="isOpen">
        <button>감정달력 보러가기</button>
      </div>
    </div>
  </div>
</template>
<script>
import { mapActions, mapGetters } from "vuex";
export default {
  props: {
    // group:Object
  },
  components: {},
  data() {
    return {
      // groupDetail에서 상담사 프로필에서 params로 groupid 받아오기
      // groupDetail에서 params로 보내기
      id: 1,
      status: '' ,
      // 라우터 다 연결 후 fetch 실행하고 group 내용 받아오기
      // contents: this.group.title,
      isOpen: false
    };
  },
  setup() {},
  created() {},
  mounted() {},
  unmounted() {},
  methods: {
    ...mapActions(['groupAccept']),
    accept() {
      const sumbitData = {
        id: this.id,
        status: this.status
      }
      this.status = 'ACCEPTED';
      this.groupAccept(sumbitData)
      this.isOpen = true
    },
    unaccept() {
      this.status = 'UNACCEPTED';
    },
    reject() {
      this.status = 'ACCEPTED';
    },
  },
  computed: {
    ...mapGetters(['currentUser'])
  }
};
</script>
<style scoped>
.groupRequestContent {
  background-color: #f0f5f9;
  padding-top: 30px;
}
#groupRequestName {
  background-color: #f0f5f9;
  width: 30%;
  margin: auto;
  border: solid #1e2022 1px;
  margin-bottom: 10px;
}
h1 {
  border: solid #1e2022 1px;
  width: 90%;
  margin: auto;
  background-color: #f0f5f9;
  margin-bottom: 10px;
}
</style>
