<template>
  <div>
 
  <div class="requestform">
    <div class="card">
      <div class="card-body">
        <h1 style="text-align:center">상담 신청하기</h1>
      </div>
    </div>
    <div class="card">
      <div class="card-body" style="height: 50px;">
        <p>신청자 : {{currentUser.data.nickname}}</p>
      </div>
    </div>

  
    <form @submit.prevent="onSubmit" class="article-form">
    <textarea style="width:100%; height: 400px; justify-content:center " v-model="contents" placeholder="상담 원하는 내용을 작성해 주세요"></textarea>

   
    <div class="request-calendar">
       <p style="text-align: center;">상담 날짜를 선택해주세요</p>
    <section class="section" >
      <div class="container">
        <h2 class="subtitle has-text-centered">
          <button class="button is-small is-info is-outlined mr-5"
          @click="calendarData(-1)">&lt;</button>
          {{ year }}년 {{ month }}월
          <button class="button is-small is-info is-outlined ml-5"
          @click="calendarData(1)">&gt;</button>
        </h2>
        <table class="table has-text-centered is-fullwidth" @click="year2=year">
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
                <div class="calendar-day" @click="day2=day" style="height:50px; width:30px">
                  <div @click="month2=month" :class="{ 'has-text-grey-light': idx === 0 && day >= lastMonthStart || dates.length - 1 === idx && nextMonthStart > day,
                  'has-text-primary': day === today && month === currentMonth && year === currentYear && idx <32 
                  }">
                  <div @click="timeon()" >{{ day }}</div>
                
                  </div>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </section>
    </div>
    <div v-if="isSelected==true">

    <div v-for="(counseling,idx) in counselings.data.counselings"
    :key="idx"
    :counseling="counseling">
    <!-- {{year2}}
    {{month2}}
    {{day2}} -->
    <div v-if="year2==counseling.year && month2 ==counseling.month && day2==counseling.day">
    {{counseling.hours}}
    </div>
    
    </div>
    <select  v-model="selectHour" class="form-select" style="width:100%; height:240px; display:inline-block; text-align: center ; " multiple aria-label="multiple select example">
      <option disabled value="">희망하는 상담 시간을 선택해주세요</option>
      <hr>
      <!-- <div v-if="counseling.hours>=9 && counseling.hours<10">
        <option disabled>09:00</option>
      </div>
      <div v-else>
        <option >09:00</option>
      </div>
      <div v-if="counseling.hours>=10 && counseling.hours<11">
        <option disabled>10:00</option>
      </div>
      <div v-else>
        <option >10:00</option>
      </div>
      <div v-if="counseling.hours>=11 && counseling.hours<12">
        <option disabled>11:00</option>
      </div>
      <div v-else>
        <option >11:00</option>
      </div>
      <div v-if="counseling.hours>=13 && counseling.hours<14">
        <option disabled>13:00</option>
      </div>
      <div v-else>
        <option >13:00</option>
      </div>
      <div v-if="counseling.hours>=14 && counseling.hours<15">
        <option disabled>14:00</option>
      </div>
      <div v-else>
        <option >14:00</option>
      </div>
      <div v-if="counseling.hours>=15 && counseling.hours<16">
        <option disabled>15:00</option>
      </div>
      <div v-else>
        <option >15:00</option>
      </div>
      <div v-if="counseling.hours>=16 && counseling.hours<17">
        <option disabled>16:00</option>
      </div>
      <div v-else>
        <option >16:00</option>
      </div>
      <div v-if="counseling.hours>=17 && counseling.hours<18">
        <option disabled>17:00</option>
      </div>
      <div v-else>
        <option >17:00</option>
      </div>
      <div v-if="counseling.hours>=18 && counseling.hours<19">
        <option disabled>18:00</option>
      </div>
      <div v-else>
        <option >18:00</option>
      </div> -->
      <option >09:00</option>
      <option >10:00</option>
      <option >11:00</option>
      <option >13:00</option>
      <option >14:00</option>
      <option >15:00</option>
      <option >16:00</option>
      <option >17:00</option>
      <option >18:00</option>
      
    </select>
    </div>
    <br>
    <div id="open-choice-app">  
    <div class="form-switch" @click="isOpen= !isOpen">
        <input class="form-check-input6"  type="checkbox" role="switch" id="flexSwitchCheckChecked" checked>
        <label class="form-check-label6"  for="flexSwitchCheckChecked">감정달력 열람 허용</label>
    </div>
    <p>*감정달력을 공개하시면 더욱 자세한 심리 상담이 가능해져요*</p>
    </div>

  
    <button type="submit" class="btn" id="article-form-submit-button">신청하기</button>
    </form>
    <br><br><br>
  </div>
  <br><br><br> <br><br><br>
 
  <!-- <counseling-time-comp
      v-for="(request,idx) in requests.data"
      :key="idx"
      :request="request">
     </counseling-time-comp> -->
  </div>
</template>

<script>

import { mapGetters,mapActions } from 'vuex'

// import CounselingTimeComp from '@/views/counseling-request/components/counselingTimeComp.vue'
  export default {
  name : 'CounselingRequestView',
  // components: {
  //   CounselingTimeComp
  // },
  data() {
    return {
      isSelected:false,
      month2:0,
      day2:0,
      year2:0,
      selectHour:{},
      selectHour2:{},
      contents: '',
      date2 :'1',
      id:0,
      nine:true,
      ten:true,
      eleven:true,
      twelve:true,
      thirteen:true,
      fourteen:true,
      fifteen:true,
      sixteen:true,
      seventeen:true,
      eighteen:true,
      isOpen:true,
      newRequest:{
        contents : '',
          isOpen : '',
          id : '',
          year : '',
          month : '',
          day : '',
          hours : 0
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
    ...mapGetters(['counselings','requests']),
    },
    methods: {
    ...mapActions(['fetchCurrentUser','createRequest']),
    ...mapActions(['fetchSchedules','fetchRequests',]),

   timeon(){
      this.isSelected=true
      console.log()
   },
   
    onSubmit() {
      // let formData = new FormData()
      // this.date2 = `${this.year2}-${this.month2}-${this.day2}${Object.values(this.selectHour)}`
      // formData.append('contents', this.contents)
      // formData.append('isOpen', this.isOpen)
      // formData.append('id', this.id)
      // formData.append('date', this.date2)
      // this.createRequest(this.formData)
      this.date2 = `${this.year2}-${this.month2}-${this.day2} ${this.selectHour[0]}:00`,
      this.selectHour2= 'T'+this.selectHour[0]+':00.000Z',

      this.id=this.$route.params.counselorId

      this.date3 = new Date(this.date2)
      let hour4 = this.date3.getHours()
      this.newRequest={
        contents : this.contents,
          isOpen : this.isOpen,
          id : this.id,
          year : this.year2,
          month : this.month2,
          day : this.day2,
          hours : hour4
      },

      this.createRequest(this.newRequest)

      console.log(this.newRequest.contents)
      console.log(this.newRequest.isOpen)
      console.log(this.newRequest.day)
      console.log(this.newRequest.year)
      console.log(this.newRequest.month)
      console.log(this.newRequest.hours)
      console.log(this.newRequest.id)
      console.log(typeof(this.newRequest.hours))
      console.log(this.date3)
      
      console.log(Number(this.selectHour[0]))
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
    this.fetchSchedules()
    const dates = new Date();
    this.currentYear = dates.getFullYear(); // 이하 현재 년, 월 가지고 있기
    this.currentMonth = dates.getMonth() + 1;
    this.year = this.currentYear;
    this.month = this.currentMonth;
    this.today = dates.getDate(); // 오늘 날짜
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

#article-form-submit-button{
  width:100%
}
.request-calendar{
  width:100%;
  border: 1px solid;
}
#open-choice-app{
  text-align: center
}
</style>