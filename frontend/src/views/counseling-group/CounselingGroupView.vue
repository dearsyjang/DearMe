<template>
  <div id="main-container" class="container">
    <div id="join" v-if="!session">
      <div id="join-dialog" class="jumbotron vertical-center">
        <div class="form-group">
          <p class="text-center">
            <button class="btn btn-lg btn-success" @click="createGroupSession()">그룹 상담방 개설</button>
          </p>
        </div>
      </div>
    </div>

    <!--세션 오픈 / 비디오-->
    <div id="session" v-if="session">
      <div id="session-header">
        <!-- <h1 id="session-title">{{ mySessionId }}</h1> -->
        <input
          class="btn btn-large btn-danger"
          type="button"
          id="buttonLeaveSession"
          @click="leaveSession"
          value="Leave session"
        />
      </div>
      <div id="main-video" class="col-md-6">
        <user-video :stream-manager="mainStreamManager" />
      </div>
      <div id="video-container" class="col-md-6">
        <user-video
          :stream-manager="publisher"
          @click="updateMainVideoStreamManager(publisher)"
        />
        <user-video
          v-for="sub in subscribers"
          :key="sub.stream.connection.connectionId"
          :stream-manager="sub"
          @click="updateMainVideoStreamManager(sub)"
        />
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import { OpenVidu } from 'openvidu-browser';
import UserVideo from './components/UserVideo';
import { mapGetters } from 'vuex';

axios.defaults.headers.post['Content-Type'] = 'application/json';
// const OPENVIDU_SERVER_URL = "https://i7d206.p.ssafy.io:4443";
// const OPENVIDU_SERVER_SECRET = "dearme";

export default {
  name: 'App',
  components: {
    UserVideo,
  },

  computed: {
    ...mapGetters(['authHeader2'])
  },

  data() {
    return {
      OV: undefined,
      session: undefined,
      mainStreamManager: undefined,
      publisher: undefined,
      subscriber: undefined,
      subscribers: [],
      mySessionId: '', // 방 이름
      myUserName: '', // 유저 닉네임
      groupId: this.$route.params.groupId,
    };
  },

  // 오픈비두 서버 보내는 과정
  // First request performs a POST to /openvidu/api/sessions (we send a customSessionId field to name the session with our mySessionId value retrieved from HTML input)
  // Second request performs a POST to /openvidu/api/sessions/<sessionId>/connection (the path requires the sessionId to assign the token to this same session)

  methods: {
    // 상담사 => 그룹 상담방 개설
    createToken() {

      this.OV = new OpenVidu();

      // --- Init a session --- 세션 초기화
      this.session = this.OV.initSession();

      // --- Specify the actions when events take place in the session ---
      // On every new Stream received... 참가자 추가
      this.session.on('streamCreated', ({ stream }) => {
        const subscriber = this.session.subscribe(stream);
        this.subscribers.push(subscriber);
        console.log(stream)
        console.log(subscriber)
      });
      // On every Stream destroyed...
      this.session.on('streamDestroyed', ({ stream }) => {
        const index = this.subscribers.indexOf(stream.streamManager, 0);
        if (index >= 0) {
          this.subscribers.splice(index, 1);
        }
      });

      // On every asynchronous exception... 비동기 오류
      this.session.on('exception', ({ exception }) => {
        console.warn(exception);
      });

      return new Promise((resolve, reject) => {
        
        let authHeader = this.authHeader2
        let groupId = this.groupId
        console.log('Token', authHeader)
        console.log('그룹아이디', groupId)

        axios
          .post(
            `https://i7d206.p.ssafy.io/api/counseling-rooms/groups`,
            {
              groupId: groupId
            },       
             {
              headers: {
                Authorization : authHeader
              }
            }
          )
          .then((response) => response.data)
          .then((data) => {
            console.log('data', data)
            resolve(data.token)
            console.log(data.data.counselorToken)
            return data.data.counselorToken
          })
          .then((token) => {
            console.log(token)
            
              this.session.connect(token, { clientData: this.myUserName })
          .then(() => {

              // 영상 가져오기
              let publisher = this.OV.initPublisher(undefined, {
                  audioSource: undefined, // The source of audio. If undefined default microphone
                  videoSource: undefined, // The source of video. If undefined default webcam
                  publishAudio: true,     // Whether you want to start publishing with your audio unmuted or not
                  publishVideo: true,     // Whether you want to start publishing with your video enabled or not
                  resolution: '640x480',  // The resolution of your video
                  frameRate: 30,          // The frame rate of your video
                  insertMode: 'APPEND',   // How the video is inserted in the target element 'video-container'
                  mirror: false           // Whether to mirror your local video or not
              });

            this.mainStreamManager = publisher;
						this.publisher = publisher;
            this.session.publish(this.publisher)
          })
          .catch(error => {
              console.log('There was an error connecting to the session:', error.code, error.message);
          });
          })
          .catch((error) => reject(error.response));
			});
		},
	},
}
</script>

<style scoped>
.card {
  justify-content: center;
  width: auto;
  height: 280px;
  margin-bottom: 25px;
  background-color: #DBE2EF;
  border-style: none;
}
</style>