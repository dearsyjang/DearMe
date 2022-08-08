<template>

  <section class="test">
    <select v-model="selected">
      <option disabled value="">충전할 포인트를 선택해 주세요.  </option>
      <option value = "1000">1000</option>
      <option value = "2000">2000</option>
      <option value = "3000">3000</option>
    </select>
    <br>
    <span>선택함 : {{ selected }}  point</span>
      
    <button @click="requestPay">
      결제하기
    </button>
  </section>

</template>


<script>
import { mapGetters, mapState } from 'vuex';
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
    ...mapState(['token']),
    ...mapGetters(['authHeader']),
  },
  methods: { 
    
    requestPay : function() {
      console.log(this.token)
      console.log(this.authHeader)
      /* 1. 가맹점 식별하기 */
      const { IMP } = window;+
      IMP.init('TC0ONETIME');
      /* 2. 데이터로 결제요청하기 */
      IMP.request_pay({
          pg : 'kakaopay',
          pay_method : 'card',
          merchant_uid: "order_no_0001", 
          name : '주문명:결제테스트',
          amount : this.selected,
          buyer_email : this.userinfo.email,
          buyer_name : this.userinfo.name,
          m_redirect_url : 'http://localhost:8080/'
          }, 
          console.log(this.authHeader),
          rsp => { // callback
                const token = this.token
                console.log(token)
                const data = this.selected
                console.log(data)
                if (rsp.success) {
                  fetch('http://localhost:8080/users/points', {         //json데이터 업로드.
                  method: 'PUT',
                  headers: {
                    'Content-Type': 'applications/json',
                    Authorization : token
                  },
                  body: JSON.stringify(data),
                  })
                  .then((response)=> response.json())
                  .then((data)=> {
                    console.log('hi', data)
                    alert("완료 -> imp_uid : " + rsp.imp_uid+" / merchant_uid(orderKey) : " + rsp.merchant_uid);
                  })
                  .catch((error) => {
                    console.log('bye', error)
                    alert("실패 : 코드(" + rsp.error_code + ") / 메시지(" + rsp.error_msg + ")");
                  })
                }

            })
          }
        }
  }
</script>
      
    //     function(rsp) { // callback
    //         console.log(this.selected)
    //         let amount = this.selected
    //         console.log(amount)
    //         if (rsp.success) {
    //         fetch('http://localhost:8080/users/points', {
    //             method: 'PUT',
    //             headers: this.authHeader,
    //             body: JSON.stringify({price: amount})
    //         }).then((rsp) => rsp.json()).then((amount) => {
    //             console.log(amount);
    //         });
    //         alert("완료 -> imp_uid : " + rsp.imp_uid+" / merchant_uid(orderKey) : " + rsp.merchant_uid);
        
    //   } else {
    //     alert("실패 : 코드(" + rsp.error_code + ") / 메시지(" + rsp.error_msg + ")");
    //     alert(`결제 실패`);
    //   }
    // })
    
    },
  }
}
    
<!-- 
</script> -->