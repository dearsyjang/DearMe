<template>
  <div>
    <br><br><br><br>
    <h1>수락 대기 중인 상담</h1>
    <hr>
    <br><br>
    <div>
        <div>
            <h2>1:1 상담</h2>
              <div>
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
          <h2>그룹 상담</h2>
        </div>
          <div>
            <groupcard-comp></groupcard-comp>
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