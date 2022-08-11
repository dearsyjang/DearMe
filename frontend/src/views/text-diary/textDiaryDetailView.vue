<template>
  <div id="textDiaryDetail">
    <div id="textDiaryTitle">
      {{ textDiary.data.year}}.
      {{ textDiary.data.month}}.
      {{ textDiary.data.day}}
      {{ textDiary.data.title }}
      </div>
    <div id="textDiaryContents" class="card">
        <div class="card-body">
            {{ textDiary.data.contents }}
        </div>
    </div>
    <router-link :to="{ name:'calendar' }">
      <div id="textDiaryList-button">
          <button>목록</button>
      </div>
    </router-link>
    <div id="textDiaryDelete-button">
        <button @click="deleteTextDiary(textDiaryId)">삭제</button>
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
      textDiaryId: this.$route.params.textDiaryId,
      
      
    }
  },
  computed: {
    ...mapGetters(['textDiary'])
    
  },
  setup() {},
  
  mounted() {},
  unmounted() {},
  methods: {
    ...mapActions(['fetchTextDiary']),
    ...mapActions(['deleteTextDiary']),
    

    // getTextDiary() {
    //   const subData = {
    //     title: this.data.title,
    //     contents: this.data.contents,
    //   }
    //   this.fetchTextDiary(subData)
    // }
  },
  created() {
    this.fetchTextDiary(this.textDiaryId)
  },
  
}
</script>