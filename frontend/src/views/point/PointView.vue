<template>
  <div class="page-content-wrapper py-3 group-bg">
    <div class="container">
      <div class="card my-2">
        <div class="card-body p-2">
          <div class="justify-content-between">
            <small class="ms-1 board-text-index">포인트 충전</small>
          </div>
        </div>
      </div>
      <div class="d-flex justify-content-center">
        <!-- <img src="@/assets/images/point.png" id="coin_image" class="my-4" alt=""> -->
      </div>
      <div class="card product-details-card mb-3 direction-rtl">
        <div class="card-body">
          <h6>충전된 포인트는 상담 신청시 차감됩니다.</h6>
          <hr>
          <h6>결제가 완료된 포인트는 환불되지 않으니 유의하시기 바랍니다.</h6>
        </div>
      </div>

      <div class="card product-details-card mb-3 direction-rtl">
        <div class="card-body">
          <div class="form-group">
              <label class="form-label" for="defaultSelect" >충전 포인트</label>
              <select v-model="selected" class="form-select" id="defaultSelect" name="defaultSelect" aria-label="Default select example">
              <option selected disabled value="">충전할 포인트를 선택해 주세요.  </option>
                <option>1000</option>
                <option>2000</option>
                <option>3000</option>
              </select>
            </div>
          <h4>{{ selected }}  point</h4>
          <button @click="requestPay()" class="w-btn w-btn-charge2">
            결제하기
          </button>
        </div>

  </div>
</div>
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
#coin_image{
  width: 80px;
  height: 80px;
  margin: 0;
}
body {
  background-color: #F9F7F7 !important;
}

.point1 {
  margin-top: 50px;
}
.pointTitle {
  font-size: 50px;
  padding-bottom: 10px;

}

.test {
  margin: auto;
  text-align: center;
  width: 80%;

}
.w-btn-charge2 {
    /* position: relative; */
    margin-top: 20px;

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