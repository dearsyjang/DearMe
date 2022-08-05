<template>
  <div>
    <div> 2022.08.05 ({{ textdiarytitle }})</div>
    <div class="card">
        <div class="card-body">
            {{ textdiarycontent }}
        </div>
    </div>
    <div>
        <button>목록</button>
    </div>
    <div>
        <button type="button" data-bs-toggle="modal" data-bs-target="#textdiarydelete">
          삭제
        </button>
        <div class="modal fade" id="textdiarydelete" tabindex="-1" aria-labelledby="textdiarydeleteLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
              <h5 class="modal-title" id="textdiarydeleteLabel">일기 삭제</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
            삭제 후 복구가 불가합니다. 삭제를 진행하시겠습니까?
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">목록</button>
              <button type="button" class="btn btn-primary">삭제</button>
            </div>
          </div>
        </div>
      </div>
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