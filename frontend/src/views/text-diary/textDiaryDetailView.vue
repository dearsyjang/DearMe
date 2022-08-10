<template>
  <div>
    <div> 2022.08.05 ({{ textDiary.title }})</div>
    <div class="card">
        <div class="card-body">
            {{ textDiary.contents }}
        </div>
    </div>
    <div id="textDiaryList-button">
        <button>목록</button>
    </div>
    <div id="textDiaryDelete-button">
        <button>삭제</button>
    </div>
  </div>
        
</template>
<script>
import { mapActions, mapGetters } from 'vuex'
export default {
  name : 'textDiaryDetail',
  components: {},
  data() {
    return {
      
    }
  },
  computed: {
    ...mapGetters(['textDiaries'])
  },
  setup() {},
  
  mounted() {},
  unmounted() {},
  methods: {
    ...mapActions(['fetchTextDiaries'])
  },
  created() {
    this.fetchTextDiaries
  },
}
</script>