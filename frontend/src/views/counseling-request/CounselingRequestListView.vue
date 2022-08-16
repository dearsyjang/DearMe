<template>
  <div>
    <br><br><br><br>
    <h1 class="counseling-request-list-title">수락 대기 중인 상담</h1>
    
    <br><br>
    <div class="counseling-request-list-cards">
      <div>
          <div>
              <h2>1:1 상담</h2>
              <hr>                <div>
                  <personalcard-comp 
                  v-for="(request,idx) in requests.data"
                  :key="idx"
                  :request="request">
                  </personalcard-comp>
                </div>
          </div>
      </div>
      <br>
      <div>
          <div>
            <br>
            <h2>그룹 상담</h2>
             <hr>  
          </div>
            <div>
              <groupcard-comp 
              v-for="(request,idx) in requests.data"
                  :key="idx"
                  :request="request">
              </groupcard-comp>
            </div>
            
      </div>
    </div>
    <br><br><br><br><br><br><br>
  </div>
</template>
<script>
import personalcardComp from '@/views/counseling-request/components/personalcardComp.vue'
import groupcardComp from '@/views/counseling-request/components/groupcardComp.vue'

import { mapGetters,mapActions } from 'vuex'
export default {
  name : 'CounselingRequestList',
  components: {
    personalcardComp,
    groupcardComp,
  },
  data() {
    return {
      sampleData: ''
    }
  },
  setup() {},

  mounted() {},
  unmounted() {},
  computed:{
    ...mapGetters(['requests','currentUser']),
  },
  methods: {
    ...mapActions(['fetchRequests', 'fetchCurrentUser']),
  },
  created() {
    this.fetchCurrentUser()
    this.fetchRequests()
}
}
</script>

<style >
.counseling-request-list-title{
  text-align: center
}

.counseling-request-list-cards{
  justify-content: center;
}
</style>