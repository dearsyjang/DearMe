<template>
  <div>
    <br>
    <h1 style="text-align:center">오늘의 상담</h1>
    <hr>
    <br><br>
    <div>
        <div>
            <h2 style="text-align:center">1:1 상담</h2>
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
          <hr>
          <h2 style="text-align:center">그룹 상담</h2>
        </div>
          <div>
            <groupcard-comp 
            v-for="(request,idx) in requests.data"
                :key="idx"
                :request="request">
            </groupcard-comp>
          </div>
          
    </div>
    <br><br><br><br><br><br><br>
  </div>
</template>
<script>
import PersonalcardComp from '@/views/counseling-schedule/components/PersonalcardComp.vue'
import GroupcardComp from '@/views/counseling-schedule/components/GroupcardComp.vue'

import { mapGetters,mapActions } from 'vuex'
export default {
  name : 'TodayScheduleView',
  components: {
    PersonalcardComp,
    GroupcardComp,
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
body{
  background-color: #F9F7F7;
}
</style>