<template>
  <div>
    <h1>텍스트 일기 작성</h1>
        <content-Comp></content-Comp>
    <div>
      <button>저장하기</button>
    </div>

  </div>
</template>
<script>
import contentComp from '@/views/text-diary/components/contentComp.vue'
export default {
  name : 'textDiaryCreate',
  components: {
    contentComp
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