<template>
<div class="page-content-wrapper py-3 board-bg">
  <div class="shop-pagination pb-3">
    <div class="container">
      <div class="card">
        <div class="card-body p-2">
          <div class="d-flex align-items-center justify-content-between">
            <small class="ms-1 board-text-index ">{{ currentUser?.data?.id }} MYPAGE</small>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="top-products-area product-list-wrap">
    <div class="container">
      <div class="card user-info-card mb-3">
        <div class="card-body d-flex align-items-center">
          <div class="user-profile me-3">
            <img src="@/assets/images/emotion.png" alt="">
            <i class="bi bi-pencil"></i>
            <form action="#">
              <input class="form-control" type="file">
            </form>
          </div>
          <div class="user-info">
            <div class="d-flex align-items-center">
              <h5 class="mb-1 board-text-bold">{{ currentUser?.data?.nickname }}</h5>
              <span class="badge bg-warning ms-2 rounded-pill">{{ currentUser?.data?.type }}</span>
            </div>
            <div class="d-flex align-items-center">
              <p class="mb-0 me-4 board-mypoint board-text-bold">잔여 포인트 : {{ currentUser?.data?.points }} pt</p>
              <!-- <router-link :to="{ name: 'PointView'}">
              <button class="w-btn w-btn-charge" type="button">충전하기</button>
              </router-link> -->
              <div>
                <!-- <div v-if="this.textDiaryId!=undefined"> -->
                  <button class="board-btn-submit btn-sm mx-2" data-bs-toggle="modal" data-bs-target="#PointView">충전하기
                    </button>

                  <div class="modal fade" id="PointView" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                      <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">포인트 충전</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <select v-model="selected">
                          <option disabled value="">충전할 포인트를 선택해 주세요.  </option>
                          <option>1000</option>
                          <option>2000</option>
                          <option>3000</option>
                        </select>
                        <br>
                        <span>선택함 : {{ selected }}  point</span>  
                        <button @click="requestPay()" class="board-btn-submit btn-sm mx-3">결제하기</button>
                    
                      </div>
                    </div>
                  </div><!-- </div> -->
                
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</template>
<script>
import { mapActions, mapGetters } from 'vuex';
export default {
  components: {},
  data() {
    return {
      sampleData: '',
      selected: 0,
      userinfo : {
        name: '',
        email: '',
      }
    }
  },
  setup() {},
  created() {
    this.fetchCurrentUser()
  },
  mounted() {
  },
  unmounted() {},
  methods: {
    ...mapActions(['fetchCurrentUser']),
    // 회원 정보 수정 매서드 받아와서 패치하고 출력
    // 카카오페이 결제
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
  computed:{
    ...mapGetters(['currentUser', 'authHeader2']),
  }

}
</script>
<style scoped>
#info-p {
  font-size: large;
}
#info-pl {
  font-size: xx-large;
  margin: 20px, 0
}
#info-plc {
  font-size: xx-large;
  line-height: 100px;
}
.w-btn-charge {
    /* position: relative; */
    border: none;
    min-width: 90px;
    min-height: 30px;
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
    font-size:14px
}

.w-btn-charge:hover {
    transform: scale(1.2);
}
.board-mypoint{
  font-size: medium;
}

</style>
