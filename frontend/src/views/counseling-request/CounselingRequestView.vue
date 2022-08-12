<template>
  <div>
  <div class="requestform">
    <div class="card">
      <div class="card-body">
        <h1>상담 신청하기</h1>
      </div>
    </div>
    <div class="card">
      <div class="card-body">
        <p>신청자 : {{currentUser.data.nickname}}</p>
      </div>
    </div>


    <form @submit.prevent="onSubmit" class="article-form">
    <br><br><br><br><br><br><br><br>
    <textarea style="width:90%; height:90%" v-model="req.contents" placeholder="내용을 작성하시오..."></textarea>
    <br><br><br><br><br><br><br><br>


    <div id="app">
    <p v-if="req.isOpen">
      state가 true상태 입니다.
    </p>
    <p v-else>
      state가 false상태 입니다.
    </p>
    
    <div class="form-switch" @click="req.isOpen= !req.isOpen">
        <input class="form-check-input"  type="checkbox" role="switch" id="flexSwitchCheckChecked" checked>
        <label class="form-check-label"  for="flexSwitchCheckChecked">감정달력 공개여부</label>
    </div>
    </div>


      

    <section class="section" >
      <div class="container">
        <h2 class="subtitle has-text-centered">
          <button class="button is-small is-info is-outlined mr-5"
          @click="calendarData(-1)">&lt;</button>
          {{ year }}년 {{ month }}월
          <button class="button is-small is-info is-outlined ml-5"
          @click="calendarData(1)">&gt;</button>
        </h2>
        <table class="table has-text-centered is-fullwidth">
          <thead>
            <th v-for="day in days" :key="day" style="text-align:center">{{ day }}</th>
          </thead>
          <tbody>
            <tr v-for="(date, idx) in dates" :key="idx">
              <td
                v-for="(day, secondIdx) in date" 
                :key="secondIdx"
              > 
              <!-- "{ name: 'CounselingTimeSelect', params: {counselingDay:selectDay}}" -->
                <div class="calendar-day" style="height:50px; width:30px">
                <router-link to="/counseling-request/timeSelect" :class="{ 'has-text-grey-light': idx === 0 && day >= lastMonthStart || dates.length - 1 === idx && nextMonthStart > day,
                'has-text-primary': day === today && month === currentMonth && year === currentYear && idx <32
                }">
                {{ day }}
              
                </router-link>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </section>
  
    <br><br><br><br><br><br><br><br>
    <select v-model="req.hour" class="form-select" style="width:35%; display:inline-block; text-align: center ; " multiple aria-label="multiple select example">
      <option disabled value="">상담가능시간</option>
      <option >09:00</option>
      <option >10:00</option>
      <option >11:00</option>
      <option >13:00</option>
      <option >14:00</option>
      <option >15:00</option>
      <option >16:00</option>
      <option >17:00</option>
    </select>
    <br>
 

    <br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br>
   

  
    <button type="submit" class="btn" id="article-form-submit-button">신청하기</button>
    </form>

  </div>
  <br><br><br><br><br><br><br><br>

  <counseling-time-comp
      v-for="(request,idx) in requests.data"
      :key="idx"
      :request="request">
     </counseling-time-comp>
  </div>
</template>

<script>

import { mapGetters,mapActions } from 'vuex'

import CounselingTimeComp from '@/views/counseling-request/components/counselingTimeComp.vue'
  export default {
  name : 'CounselingRequestView',
  components: {
    CounselingTimeComp
  },
  data() {
    return {
      selectDay:'',
      req:{
      contents: '',
      hour:'',
      isOpen:true,
      

    },
    days: [
        '일',
        '월',
        '화',
        '수',
        '목',
        '금',
        '토',
      ],
      dates: [],
      currentYear: 0,
      currentMonth: 0,
      year: 0,
      month: 0,
      lastMonthStart: 0,
      nextMonthStart: 0,
      today: 0,
    }
  },

  computed : {
    ...mapGetters(['currentUser','request']),
    ...mapGetters(['requests']),
    },
    methods: {
    ...mapActions(['fetchCurrentUser','createRequest',]),
    ...mapActions(['fetchRequests',]),

    onSubmit() {
      const formData = new FormData()
      formData.append('contents', this.data.req.contents)
      formData.append('isOpen', this.data.req.isOpen)
      formData.append('date', this.data.req.date)
      this.createRequest(this.formData)
     
      },

    //////////////////////////////////이 밑으로는 달력/////////////////////////////


    calendarData(arg) { // 인자를 추가
      if (arg < 0) { // -1이 들어오면 지난 달 달력으로 이동
        this.month -= 1;
      } else if (arg === 1) { // 1이 들어오면 다음 달 달력으로 이동
        this.month += 1;
      }
      if (this.month === 0) { // 작년 12월
        this.year -= 1;
        this.month = 12;
      } else if (this.month > 12) { // 내년 1월
        this.year += 1;
        this.month = 1;
      }
      const [
        monthFirstDay,
        monthLastDate,
        lastMonthLastDate,
      ] = this.getFirstDayLastDate(this.year, this.month);
      this.dates = this.getMonthOfDays(
        monthFirstDay,
        monthLastDate,
        lastMonthLastDate,
      );
    },
    getFirstDayLastDate(year, month) {
      const firstDay = new Date(year, month - 1, 1).getDay(); // 이번 달 시작 요일
      const lastDate = new Date(year, month, 0).getDate(); // 이번 달 마지막 날짜
      let lastYear = year;
      let lastMonth = month - 1;
      if (month === 1) {
        lastMonth = 12;
        lastYear -= 1;
      }
      const prevLastDate = new Date(lastYear, lastMonth, 0).getDate(); // 지난 달 마지막 날짜
      
      return [firstDay, lastDate, prevLastDate];
      
    },
    getMonthOfDays(
      monthFirstDay,
      monthLastDate,
      prevMonthLastDate,
    ) {
      let day = 1;
      let prevDay = (prevMonthLastDate - monthFirstDay) + 1;
      const dates = [];
      let weekOfDays = [];
      while (day <= monthLastDate) {
        if (day === 1) {
          // 1일이 어느 요일인지에 따라 테이블에 그리기 위한 지난 셀의 날짜들을 구할 필요가 있다.
          for (let j = 0; j < monthFirstDay; j += 1) {
            if (j === 0) this.lastMonthStart = prevDay; // 지난 달에서 제일 작은 날짜
            weekOfDays.push(prevDay);
            prevDay += 1;
          }
        }
        weekOfDays.push(day);
        if (weekOfDays.length === 7) {
          // 일주일 채우면
          dates.push(weekOfDays);
          weekOfDays = []; // 초기화
        }
        day += 1;
      }
      const len = weekOfDays.length;
      if (len > 0 && len < 7) {
        for (let k = 1; k <= 7 - len; k += 1) {
          weekOfDays.push(k);
        }
      }
      if (weekOfDays.length > 0) dates.push(weekOfDays); // 남은 날짜 추가
      this.nextMonthStart = weekOfDays[0]; // 이번 달 마지막 주에서 제일 작은 날짜
      
      return dates;
    },
    },
    
  created() {
    this.fetchCurrentUser()
    this.fetchRequests()

    const date = new Date();
    this.currentYear = date.getFullYear(); // 이하 현재 년, 월 가지고 있기
    this.currentMonth = date.getMonth() + 1;
    this.year = this.currentYear;
    this.month = this.currentMonth;
    this.today = date.getDate(); // 오늘 날짜
    this.calendarData();
    
    
  },
}
</script>

<style scoped>
.requestform {
  width : auto
}
.container a{
  text-decoration: none;
  color: black
}
</style>