<template>
  <div>
    <h1>{{ $route.params.title }}그룹 참가 신청하기</h1>
    <div id="groupRequestName" class="d-flex justify-content-center">
      <div>신청자 : </div>
    </div>
    <div class="groupRequestContent">
      <div>
        <textarea
          rows="10"
          cols="40"
          placeholder="상담 내용을 입력하시오."
          v-model="contents"
        ></textarea>
      </div>
      <!-- user / counselor 구분 -->
      <!-- <div v-if="isCounselor === true"> -->
      <div class="d-flex justify-content-end">
        <button>수락</button>
        <button class="mx-3">거절</button>
      </div>
      <!-- <div v-if="isCounselor === false"> -->
      <div>
        <div class="d-flex justify-content-start">
          <div class="form-check form-switch mx-3">
            <input
              class="form-check-input"
              type="checkbox"
              role="switch"
              id="flexSwitchCheckChecked"
              checked
              v-model="isOpen"
              @click="switchOpen()"
            />
            <label for="flexSwitchCheckChecked">감정달력 공개</label>
          </div>
        </div>
        <div class="d-flex justify-content-end">
          <button @click="onSubmit()" class="mx-3">완료</button>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { mapActions, mapGetters } from "vuex";
export default {
  props: {
    group:Object
  },
  components: {},
  data() {
    return {
      // groupId 받아오는거 생각해보기
      groupId: 1,
      isOpen: true,
      contents: "",
    };
  },
  setup() {},
  created() {},
  mounted() {},
  unmounted() {},
  methods: {
    ...mapActions(["groupRequest"]),
    onSubmit() {
      const data = {
        'id': this.groupId,
        'isOpen': this.isOpen,
        'contents': this.contents
      }
      this.groupRequest(data)
    },
    switchOpen() {
      this.isOpen = !this.isOpen
    }
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
