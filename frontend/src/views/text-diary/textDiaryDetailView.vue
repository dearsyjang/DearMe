<template>
  <div>
    <div>2022.8.5 ({{ textdiarytitle }})</div>
    <div class="card">
        <div class="card-body">
            {{ textdiarycontent }}
        </div>
    </div>
    <div>
        <button>목록</button>
        <button>삭제</button>
    </div>
  </div>
</template>
<script>
export default {
  name : 'textDiaryDetail',
  components: {},
  data() {
    return {
      sampleData: '',
      textdiarytitle: '제목',
      textdiarycontent: '내용',
    }
  },
  setup() {},
  created() {},
  mounted() {},
  unmounted() {},
  methods: {}
}
</script>