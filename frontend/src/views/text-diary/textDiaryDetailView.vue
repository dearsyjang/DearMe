<template>
  <div id="textDiaryDetail">
    <div id="textDiaryTitle">
      <div class="text-diary-date">
      {{ textDiary.data.year}}/{{ textDiary.data.month}}/{{ textDiary.data.day}}
      </div>
      <hr>

      {{ textDiary.data.title }}
      </div>
    <div id="textDiaryContents" class="card">
        <div class="card-body">
            {{ textDiary.data.contents }}
        </div>
    </div>
    <router-link :to="{ name:'calendar' }">
      <div id="textDiaryList-button">
        <button>다른 일기 보러가기</button>
      </div>
    </router-link>
    <div id="textDiaryDelete-button">
        <button @click="deleteTextDiary(textDiaryId)">삭제하기</button>
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

<style>
.text-diary-date{
  text-align:center
}

#textDiaryDelete-button{
  float:right
}

#textDiaryList-button{
  float:left
}
</style>