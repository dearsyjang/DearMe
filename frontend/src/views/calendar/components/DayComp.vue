<template>
  <div>
      <router-link :to="{ name: 'videodiary' }"><button id="videodiary-enter-btn" class="btn"><h1>📷</h1></button></router-link>
      <button v-on:click = "this.isTextOn =!this.isTextOn">텍스트 일기 보기</button>
      <div class="player-container" v-if="this.isTextOn">
          {{this.textDiary.contents}}
      </div>
 <button @click="deleteTextDiary()">텍스트 일기 삭제</button>
      <button v-on:click = "this.isVideoOn =!this.isVideoOn">영상 일기 보기</button>
      <div class="player-container" v-if="this.isVideoOn">
          {{this.videoSource}}
            <vue3-video-player :src="videoSource"></vue3-video-player>
        </div>
        <button @click="deleteVideoDiary()">영상 일기 삭제</button>
      <button v-on:click = "this.isTextOn =!this.isTextOn">영상 일기 보기</button>
  </div>
</template>
<script>
import { mapGetters } from 'vuex';
import axios from 'axios';
export default {
  name: 'DayComp',
  data() {
    return {
      isVideoOn: false,
      isTextOn: false,
      textDiaryId: 0,
      videoDiaryId: 0,
      textDiary: [],
      videoDiary: [],
      videoSource : 0,
    };
  },
  mounted() {
  },
  created() {
    this.textDiaryId = this.$route.params.textDiaryId
    this.videoDiaryId = this.$route.params.videoDiaryId
    this.getTextDiary()
    this.getVideoDiary()
  },
  computed: {
    ...mapGetters(['authHeader2'])
    },
  methods: {
    //텍스트 일기 삭제
      deleteTextDiary() {
        const authHeader = this.authHeader2
        if (confirm('텍스트 일기를 정말 삭제하시겠습니까?')) {
          axios
          .delete(
            `https://i7d206.p.ssafy.io/text-diaries/`+this.textDiaryId,
            {
              headers: {
                Authorization: authHeader
              }
            }
          )
          .then(response => {
            console.log(response)
          })
          .catch(error => {
            console.error(error)
          })
        }
      },
      // 영상 일기 삭제
      //나중에 영상이 있을 때에만 삭제 버튼이 나오게 변경해주셔야합니다
      deleteVideoDiary() {
        const authHeader = this.authHeader2
        if (confirm('영상 일기를 정말 삭제하시겠습니까?')) {
          axios
          .delete(
            `https://i7d206.p.ssafy.io/video-diaries/`+this.videoDiaryId,
            {
              headers: {
                Authorization: authHeader
              }
            }
          )
          .then(response => {
            console.log(response)
          })
          .catch(error => {
            console.error(error)
          })
        }
      },
   getTextDiary() {
      const authHeader = this.authHeader2
       axios
          .get(
            `https://i7d206.p.ssafy.io/text-diaries/`+this.textDiaryId,
            {
              headers: {
                Authorization: authHeader
              }
            }
          )
          .then(response => {
            console.log(response)
            this.textDiary = response.data.data;
          })
          .catch(error => {
            console.error(error)
          })
    },
    getVideoDiary() {
      const authHeader = this.authHeader2
       axios
         .get(
            `https://i7d206.p.ssafy.io/video-diaries/1`,
            //실제는 아래처럼 써야함
            // `https://i7d206.p.ssafy.io/video-diaries/1`+this.videoDiaryId,
            {
              headers: {
                Authorization: authHeader
              }
            }
          )
          .then(response => {
            console.log(response)
            this.videoDiary = response.data.data
            this.videoSource="https://i7d206.p.ssafy.io:4443/openvidu/recordings/" + this.videoSource.realFileName + "/" + this.videoSource.realFileName + ".mp4"
            console.log(this.videoSource)
            })
          .catch(error => {
            console.error(error)
          })
    },
    
  },
}
</script>
<style>
</style>