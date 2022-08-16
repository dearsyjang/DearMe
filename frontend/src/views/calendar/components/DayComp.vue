<template>
  <div>
    <div v-if="this.textDiaryId!=undefined">
      <button class="board-btn-submit btn-sm mx-2" data-bs-toggle="modal" data-bs-target="#textDiaryView">텍스트 일기
        보기</button>

      <div class="modal fade" id="textDiaryView" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">텍스트 일기</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            {{this.textDiary}}
            <button @click="textDiaryDelete()" class="board-btn-submit btn-sm mx-3">삭제</button>

          </div>
        </div>
      </div>
    </div>


    <div v-if="videoDiaryId!=undefined">
      <button class="board-btn-submit btn-sm mx-2" data-bs-toggle="modal"
            data-bs-target="#videoDiaryView">영상 일기 보기</button>
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
          {{this.videoDiary}}
          
            <vue3-video-player :src="videoSource"></vue3-video-player>
        </div>
        <button @click="videoDiaryDelete()" class="board-btn-submit btn-sm mx-3">삭제</button>
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
        if(this.videoDiaryId!=undefined)
          this.getVideoDiary(this.$route.query.videoDiaryId)
        console.log(this.textDiaryId)
        console.log(this.videoDiaryId)
        this.videoSource="https://i7d206.p.ssafy.io:4443/openvidu/recordings/" + this.videoDiary.realFileName + "/" + this.videoDiary.realFileName + ".mp4"
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
<style>
</style>