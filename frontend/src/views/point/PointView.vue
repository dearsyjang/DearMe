<template>

  <section class="test">
    <select v-model="selected">
      <option disabled value="">충전할 포인트를 선택해 주세요.  </option>
      <option>1000</option>
      <option>2000</option>
      <option>3000</option>
    </select>
    <br>
    <span>선택함 : {{ selected }}  point</span>
      
    <button @click="onPayment">
      결제하기
    </button>
  </section>

</template>


<script>
export default {
  name: 'PointView',
  data(){
    return{
      selected:0,   

    }
  },
  methods: {
    onPayment() {
      /* 1. 가맹점 식별하기 */
      const { IMP } = window;
      IMP.init('TC0ONETIME');

      /* 2. 결제 데이터 정의하기 */
      const paydata = {
        pg:'kakaopay',                          // PG사
        pay_method: 'card',                           // 결제수단
        merchant_uid: `mid_${new Date().getTime()}`,   // 주문번호
        amount: this.selected,                                 // 결제금액
        name: '아임포트 결제',                  // 주문명
        buyer_name: '강지명',                           // 구매자 이름
        buyer_tel: '01071335217',                     // 구매자 전화번호
        buyer_email: 'rainbow7417@naver.com',               // 구매자 이메일
        buyer_addr: '명륜로19',                    // 구매자 주소
        buyer_postcode: '06018',                      // 구매자 우편번호
        
      };
  
      /* 4. 결제 창 호출하기 */
      IMP.request_pay(paydata, this.callback);
    },
    callback(response) {
      /* 3. 콜백 함수 정의하기 */
      const selected = this.selected

      const {
        success,
        // merchant_uid,
        // error_msg,
      } = response;

      if (success) {
        fetch('http://localhost:8080/users/points', {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization' : 'ad eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6ImlkIiwiaXNzIjoiZGVhcm1lIiwiaWF0IjoxNjU5NjgwMzg0LCJleHAiOjE2NTk2ODM5ODR9.izg6xcOPKIdxiU6QjTQ2GoVKFqSsBwBgyP4FCd6uibQ'
                },
                body: JSON.stringify({price: selected})
            }).then((response) => response.json()).then((selected) => {
                console.log(selected);
            });
            alert("완료 -> imp_uid : " + response.imp_uid+" / merchant_uid(orderKey) : " + response.merchant_uid);
        
      } else {
        alert("실패 : 코드(" + response.error_code + ") / 메시지(" + response.error_msg + ")");
        alert(`결제 실패`);
      }
    },
  }
}
    //   rsp => {
    //     const selected = this.selected
    //     if(rsp.success){
            // fetch('http://localhost:8080/users/points', {
            //     method: 'PUT',
            //     headers: {
            //         'Content-Type': 'application/json',
            //         'Authorization' : 'ad eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6ImlkIiwiaXNzIjoiZGVhcm1lIiwiaWF0IjoxNjU5NjgwMzg0LCJleHAiOjE2NTk2ODM5ODR9.izg6xcOPKIdxiU6QjTQ2GoVKFqSsBwBgyP4FCd6uibQ'
            //     },
            //     body: JSON.stringify({price: selected})
            // }).then((response) => response.json()).then((selected) => {
            //     console.log(selected);
            // });
            // alert("완료 -> imp_uid : " + rsp.imp_uid+" / merchant_uid(orderKey) : " + rsp.merchant_uid);
    //     }else{
            // alert("실패 : 코드(" + rsp.error_code + ") / 메시지(" + rsp.error_msg + ")");
    //     }
    // }
//   },
// },

</script>