<template>
  <div>
      
      <router-link :to="{ name: 'videodiary' }"><button id="videodiary-enter-btn" class="btn"><h1>📷</h1></button></router-link>
      <button v-on:click = "this.isTextOn =!this.isTextOn">텍스트 일기 보기</button>
      <div class="player-container" v-if="this.isTextOn">
          {{this.textDiary.contents}}
      </div>

      <button v-on:click = "this.isVideoOn =!this.isVideoOn">영상 일기 보기</button>
      <div class="player-container" v-if="this.isVideoOn">
          {{this.videoSource}}
            <vue3-video-player src="{{this.videoSource}}"></vue3-video-player>
        </div>
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
      videoSource : '',
    };
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
            this.videoSource="https://i7d206.p.ssafy.io:4443/openvidu/recordings/ses_BD8mHmWSHB/ses_BD8mHmWSHB.mp4"
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