<template>
  <div id="textDiary-form">
    <p>일기 제목을 입력하시오. (50자 이내)</p>
          <input v-model="textdiarytitle" type="text" placeholder="제목을 입력하시오">
        <p>일기 내용을 입력하시오.</p>
          <p>(후에 추가 수정은 불가합니다.)</p>
            <textarea v-model="textdiarycontent" placeholder="일기 내용을 입력하시오"></textarea>
  </div>
</template>
<script>
export default {
  name : 'contentComp',
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