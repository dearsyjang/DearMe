<template>

<div class = "point">  
  <div class="card">
      <div class="card-body">
      <h3>포인트 충전</h3>    
      </div>
  </div>

  <div class="card">
    <div class="card-body">
      <p>
        ※ 충전된 포인트는 상담 신청시 차감됩니다.
      </p> 
      <p>
        ※ 결제가 완료된 포인트는 환불되지 않으니 유의하시기 바랍니다. 
      </p>
      <p>
        ※ 1포인트 = 1000원
      </p>    
      <p>
        ※ 100포인트(10만원)이상 결제시 10% 할인
      </p>
      <p>
        500포인트(50만원)이상 결제시 15% 할인
      </p>
      <p>
        1000포인트(100만원)이상 결제시 20% 할인 
      </p>   
        
          
        
    </div>
  </div>

  <div>
    <input v-model="point" type="text"> <span>POINT</span>
  </div>
  <div>
    <button>충전하기</button>
  </div>
</div>

    
  
</template>
<script>
export default {
  name : 'PointView',
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
<style scoped>
.point {
  width : auto
}
</style>