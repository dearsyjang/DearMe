<template>
  <section class="section" >
    <div class="container">
      <h2 class="subtitle has-text-centered">
        <button class="btn" type="button"
        @click="calendarData(-1)">&lt;</button>
        {{ year }}년 {{ month }}월
        <button type="button" class="btn"
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
              <div v-if="day<8&& idx === 0 && day >= lastMonthStart || dates.length - 1 === idx && nextMonthStart > day"
              @click="calendarData(1)"
                :class="'has-text-grey-light'">
                {{ day }}
              </div>
              <div v-else-if="day>24&& idx === 0 && day >= lastMonthStart || dates.length - 1 === idx && nextMonthStart > day"
              @click="calendarData(-1)"
                :class="'has-text-grey-light'">
                {{ day }}
              </div>
              <div v-else>
              <div>
              
              <router-link :to="{
                name: 'calendarDay',
                params: {
                  textDiaryId: this.dayInfo[day].textDiaryId,
                videoDiaryId: this.dayInfo[day].videoDiaryId},
              }" 
                :class="{ 'has-text-grey-light': idx === 0 && day >= lastMonthStart || dates.length - 1 === idx && nextMonthStart > day,
              'has-text-primary': day === today && month === currentMonth && year === currentYear && idx <32
              }">
              {{this.dayInfo[day].textDiaryId}}
              {{ day }}
              <br>
              </router-link>
              </div>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </section>
</template>

<script>
import { mapGetters } from 'vuex';
import axios from 'axios';

export default {
  name: 'CalendarComp',
  data() {
    return {
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
      textDiaries:[],
      videoDiaries: [],
      dayInfo: [],
    };
  },
  created() { // 데이터에 접근이 가능한 첫 번째 라이프 사이클
    const date = new Date();
    this.currentYear = date.getFullYear(); // 이하 현재 년, 월 가지고 있기
    this.currentMonth = date.getMonth() + 1;
    this.year = this.currentYear;
    this.month = this.currentMonth;
    this.today = date.getDate(); // 오늘 날짜
    this.calendarData();
    this.getTextDiaries();
  },
  computed: {
    ...mapGetters(['authHeader2'])
    },
  methods: {

    getTextDiaries() {
        const authHeader = this.authHeader2
      console.log(authHeader) 
      this.dayInfo.length = 31
      for (let i = 0; i <= 31; i++){
        this.dayInfo[i]=[]
       }
        axios
          .get(
            `https://i7d206.p.ssafy.io/text-diaries/year/` + this.year + `/month/` + this.month,
            {
              headers: {
                Authorization: authHeader
              }
            }
          )
          .then(response => {
            console.log(response)
            this.textDiaries = response.data.data.textDiaries;
            
            
            this.textDiaries.forEach(element => {
              this.dayInfo[element.day].textDiaryId = element.id
              this.dayInfo[element.day].textDiarySentiment = element.sentiment
              this.dayInfo[element.day].textDiaryPercentage = element.percentage
            });
            this.getVideoDiaries();
          })
          .catch(error => {
            console.error(error)
          })

    },
    getVideoDiaries() {
        const authHeader = this.authHeader2
        console.log(authHeader)    
        axios
            .get(
                `https://i7d206.p.ssafy.io/video-diaries/year/`+this.year + `/month/` + this.month,
                {
                  headers: {
                        Authorization : authHeader
                    }  
                }
            )
          .then(response => {
            console.log(response)
            this.videoDiaries = response.data.data.videoDiaries;
            
            
            this.videoDiaries.forEach(element => {
              this.dayInfo[element.day].videoDiaryId = element.id
              this.dayInfo[element.day].videoDiarySentiment = element.sentiment
              this.dayInfo[element.day].videoDiaryPercentage = element.percentage
            });
        })
          .catch(error => {
          console.error(error)
        })
    },
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
};
</script>
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap');
* {
  font-family: 'Gowun Dodum', sans-serif;
}

.container a{
  text-decoration: none;
  color: black;
}
.body{
  background-color: #F9F7F7;
}
section{
  background-color: #F9F7F7;
  height: 100%;
}
.table{
  background-color: #F9F7F7;
  height: 580px;
}
.td{
  height: 100px;
  padding: 5px
}
.card{
  background-color: #F9F7F7;
  border: none;
  shadow: none;
}
.td{
  padding: none;
}
</style>
