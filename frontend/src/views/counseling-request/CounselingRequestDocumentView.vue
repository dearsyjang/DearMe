<template>
  <div>
    <div class="card">
      <div class="card-body">
      <h1>상담 신청서</h1>    
      </div>
    </div>
      <div class="card">
        <div class="card-body">
        <p>신청자 : 신청자 이름 받아오기</p>
        </div>
      </div>
      <div class="card">
        <div class="card-body">
        <p>상담날짜 : 상담 날짜 받아오기</p>
        </div>
      </div>
      <div class="card">
        <div class="card-body">
        <p>나이 : 신청자 나이 받아오기</p>
        </div>
      </div>
      <div class="card">
        <div class="card-body">
        <p>상담시간 : 상담 시간 받아오기</p>
        </div>
      </div>
      <div class="card">
        <div class="card-body">
        <p>성별 : 신청자 성별 받아오기</p>
        </div>
      </div>
      <div class="card">
        <div class="card-body">
        <p>내용 받아와야됨</p>
        </div>
      </div>
      <!--수락한 신청서는 수락&거절버튼 대신 감정달력보기로 바꾸기 -->
      <button>수락하기</button>
      <button>거절하기</button>
  </div>
</template>
<script>
export default {
  name : 'CounselingRequestDocument', 
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