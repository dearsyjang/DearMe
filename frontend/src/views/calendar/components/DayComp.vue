<template>
<div id="daycomp"> 
    <div class="custom-container">
        <div v-if="this.textDiaryId!=undefined" id="diary-btn">
        <button class="btn mb-3" data-bs-toggle="modal" data-bs-target="#textDiaryView"><img id="text-diary-img" src="../../../assets/images/text-diary.png" alt="text-diary"></button>

    <div class="modal fade" id="textDiaryView" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">텍스트 일기</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <h1>{{ this.textDiary.title }}</h1>
            <p>{{ this.textDiary.contents }}</p>
            <p>{{ this.textDiary.year }}년 {{ this.textDiary.month }}월 {{ this.textDiary.day}}일</p>
            <h3 v-if="this.textDiary.sentiment == 'positive'">😊</h3>
            <h3 v-if="this.textDiary.sentiment == 'negative'">😢</h3>
            <h3 v-if="this.textDiary.sentiment == 'netural'">😐</h3>
            <button @click="textDiaryDelete()" class="board-btn-submit btn-sm mx-3">삭제</button>
          </div>
        </div>
    </div>


    <div v-if="videoDiaryId!=undefined" id="diary-btn">
      <button class="btn" data-bs-toggle="modal"
            data-bs-target="#videoDiaryView"><img id="video-diary-img" src="@/assets/images/video-diary.png" alt="video-diary"></button>
      </div>
 
<div class="modal fade" id="videoDiaryView" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">영상 일기</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div class="player-container">
          <h1>{{ this.textDiary.title }}</h1>
            <p>{{ this.textDiary.contents }}</p>
            <p>{{ this.textDiary.year }}년 {{ this.textDiary.month }}월 {{ this.textDiary.day}}일</p>
            <h3 v-if="this.textDiary.sentiment == 'positive'">😊</h3>
            <h3 v-if="this.textDiary.sentiment == 'negative'">😢</h3>
            <h3 v-if="this.textDiary.sentiment == 'netural'">😐</h3>
            <vue3-video-player :src="videoSource"></vue3-video-player>
        </div>
        <button @click="videoDiaryDelete()" class="board-btn-submit btn-sm mx-3">삭제</button>
      </div>
    </div>
  </div>
</div>
    </div>
  </div>
</div>
</template>
<script>
import { mapActions, mapGetters } from 'vuex';
export default {
  name: 'DayComp',
  data() {
    return {
      videoSource:'',
      textDiaryId:'',
      videoDiaryId:'',
    };
  },
  mounted() {

  },
  created() {
        this.textDiaryId=this.$route.query.textDiaryId
        if(this.textDiaryId!=undefined)
           this.getTextDiary(this.$route.query.textDiaryId)
        
        this.videoDiaryId=this.$route.query.videoDiaryId
        if(this.videoDiaryId!=undefined){
          this.getVideoDiary(this.$route.query.videoDiaryId)
          this.videoSource="https://i7d206.p.ssafy.io:4443/api/openvidu/recordings/" + this.videoDiary.realFileName + "/" + this.videoDiary.realFileName + ".mp4"
        }
        //this.getVideoDiary()
  },
  computed: {
    ...mapGetters(['authHeader2', 'textDiary', 'videoDiary'])
    },
  methods: {
    //텍스트 일기 삭제
     ...mapActions(['fetchTextDiary', 'deleteTextDiary', 'fetchVideoDiary', 'deleteVideoDiary']),

    textDiaryDelete() {
      this.deleteTextDiary(this.textDiaryId)
    },
    // 영상 일기 삭제
    videoDiaryDelete() {
      this.deleteTextDiary(this.videoDiaryId)
    },
   getTextDiary(textDiaryPk) {
       this.fetchTextDiary(textDiaryPk)
    },
    getVideoDiary(videoDiaryPk) {
      this.fetchVideoDiary(videoDiaryPk)
    },
}
}
</script>
<style scoped>
.btn{
    border: 0;
    outline: 0;
}
#daycomp{
  display: flex;
  height: 720px;
  margin: 0 auto;
  background-color: #F9F7F7;
  align-items: center;
}
#text-diary-img{
  width: 80px;
  height: 80px;
  margin: 0;
}
#video-diary-img{
  width: 80px;
  height: 80px;
  margin: 0;
}
#diary-btn{
  justify-content: cener;
  align-items: center;
  text-align: center;
}
</style>
