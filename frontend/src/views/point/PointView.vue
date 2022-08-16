<template>
<div class="point">
  <section class="test">
    <h1 class="pointTitle">포인트 충전</h1>
    <select v-model="selected">
      <option disabled value="">충전할 포인트를 선택해 주세요.  </option>
      <option>1000</option>
      <option>2000</option>
      <option>3000</option>
    </select>
    <br>
    <div>선택함 : {{ selected }}  point</div>
      
    <button @click="requestPay()" class="w-btn w-btn-charge2">
      결제하기
    </button>
  </section>
</div>
</template>


<script>
import { mapGetters } from 'vuex';
export default {
  name: 'PointView',
  data(){
    return{
      selected:0,   
      userinfo : {
        name: '',
        email: '',
      }
      

    }
  },
  computed : {
    ...mapGetters(['authHeader2']),
    
  },
  methods: {
    
    
    
    requestPay : function() {
      const point= this.selected
      const authHeader = this.authHeader2
      /* 1. 가맹점 식별하기 */
      const { IMP } = window;
      IMP.init('imp70028825');

      /* 2. 결제 데이터 정의하기 */
       IMP.request_pay({
        pg:'kakaopay',                       
        pay_method: 'card',                     
        merchant_uid: `mid_${new Date().getTime()}`, 
        amount: point,                                
        name: '아임포트 결제',               
        buyer_name: '강지명',                      
        buyer_email: 'rainbow7417@naver.com',    
        m_redirect_url : 'https://www.my-service.com/payments/complete'           
                   
        
      },
      
      
        function(rsp) { /* 3. 콜백 함수 정의하기 */

            if (rsp.success) {
            fetch('https://i7d206.p.ssafy.io/users/points', {
                method: 'PUT',
                headers: {
                'Content-Type': 'application/json',
                 'Authorization': authHeader
                },
                body: JSON.stringify({price: point})
            }).then((rsp) => rsp.json()).then((point) => {
                console.log(point);
                console.log(rsp)

            });
            // alert("완료 -> imp_uid : " + rsp.imp_uid+" / merchant_uid(orderKey) : " + rsp.merchant_uid);
            alert( point + "포인트가 성공적으로 충전되었습니다.");
        
      } else {
        alert("실패 : 코드(" + rsp.error_code + ") / 메시지(" + rsp.error_msg + ")");
        alert(`결제 실패`);
       
               
      }
    })
    },
  },

}
   

</script>
<style>
body {
  background-color: #F9F7F7 !important;
}

.pointTitle {
  font-size: 50px;
  padding-bottom: 100px;

}

.test {
  position: absolute; top: 400%; left: 21%;
}
.w-btn-charge2 {
    /* position: relative; */
    position: absolute; top: 700%; right: -17%;
    
    border: none;
    min-width: 320px;
    min-height: 40px;
    background: linear-gradient(
        90deg,
        #8d8cb0 0%,
        #636294 100%
    );
    border-radius: 1000px;
    color: darkslategray;
    cursor: pointer;
    box-shadow: 12px 12px 24px #76769a1a;
    font-weight: 500;
    transition: 0.3s;
    color: #E8E5DC;
    font-size:25px
}

</style>