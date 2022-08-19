<template>
  <div>
    <h1 style="text-align:center">텍스트 일기 작성</h1>
    <hr>
        <content-Comp></content-Comp>

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