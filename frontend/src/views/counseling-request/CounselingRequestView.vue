<template>
  <div class="requestform">
    <div class="card">
      <div class="card-body">
        <h1>상담 신청하기</h1>
      </div>
    </div>
    <div class="card">
      <div class="card-body">
        <p>신청자 : {{ userName }}</p>
      </div>
    </div>

    <textarea style="width:40%" v-model="message" placeholder="내용을 작성하시오..."></textarea>

    <div class="form-switch">
        <input class="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckChecked" checked>
        <label class="form-check-label" for="flexSwitchCheckChecked">개인정보 공개</label>
    </div>

  
    <div>
      <calendar-comp></calendar-comp>

      <!-- 시간자리~ -->
    </div>
    <div>
      <button @click="test">신청</button>
    </div>
  </div>
</template>

<script>
import calendarComp from '@/views/counseling-request/components/calendarComp.vue'
  export default {
  name : 'CounselingRequestView',
  components: {calendarComp},
  data() {
    return {
      message: '이거는 넘겨줘야해',
      userName: '이거는 위에서 땡겨와야대'
    }
  },
  setup() {},
  created() {},
  mounted() {},
  unmounted() {},
  methods: {
    test () {
      console.log('확인용', this.message)
    }
  }
}
</script>

<style scoped>
.requestform {
  width : auto
}
</style>