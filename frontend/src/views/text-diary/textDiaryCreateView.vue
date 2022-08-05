<template>
  <div>
    <h1>텍스트 일기 작성</h1>
        <content-Comp></content-Comp>
    <div>
      <button type="button" data-bs-toggle="modal" data-bs-target="#textdiarysave">저장하기</button>

      <div class="modal fade" id="textdiarysave" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">텍스트 일기 저장하기</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              텍스트 일기가 성공적으로 저장되었습니다!
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">확인</button>
            </div>
          </div>
        </div>
      </div>
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