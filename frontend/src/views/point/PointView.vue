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
      
    <button @click="requestPay">
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
      userinfo : {
        name: '',
        email: '',
      }
    }
  },
  methods: {
    requestPay : function() {
      /* 1. 가맹점 식별하기 */
      const { IMP } = window;
      IMP.init('TC0ONETIME');

      /* 2. 결제 데이터 정의하기 */
       IMP.request_pay({
        pg:'kakaopay',                       
        pay_method: 'card',                     
        merchant_uid: `mid_${new Date().getTime()}`, 
        amount: this.selected,                                
        name: '아임포트 결제',               
        buyer_name: this.userinfo.name,                      
        buyer_email: this.userinfo.email,               
                   
        
      }, 
        function(rsp) { // callback
            let amount=this.amount
            console.log(amount)
            if (rsp.success) {
            fetch('http://localhost:8080/users/points', {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization' : 'ad eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6ImlkIiwiaXNzIjoiZGVhcm1lIiwiaWF0IjoxNjU5NjgwMzg0LCJleHAiOjE2NTk2ODM5ODR9.izg6xcOPKIdxiU6QjTQ2GoVKFqSsBwBgyP4FCd6uibQ'
                },
                body: JSON.stringify({price: amount})
            }).then((rsp) => rsp.json()).then((amount) => {
                console.log(amount);
            });
            alert("완료 -> imp_uid : " + rsp.imp_uid+" / merchant_uid(orderKey) : " + rsp.merchant_uid);
        
      } else {
        alert("실패 : 코드(" + rsp.error_code + ") / 메시지(" + rsp.error_msg + ")");
        alert(`결제 실패`);
      }
    })
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