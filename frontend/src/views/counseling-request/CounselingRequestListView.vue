<template>
  <div>
    <div>
        <div>
            <h1>1:1 상담</h1>
              <div>
                <personalcard-comp></personalcard-comp>
              </div>
        </div>
    </div>

    <div>
        <div>
          <h1>그룹 상담</h1>
        </div>
          <div>
            <groupcard-comp></groupcard-comp>
          </div>
          
    </div>
    
  </div>
</template>
<script>
import personalcardComp from '@/views/counseling-request/components/personalcardComp.vue'
import groupcardComp from '@/views/counseling-request/components/groupcardComp.vue'
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
  created() {},
  mounted() {},
  unmounted() {},
  methods: {}
}
</script>