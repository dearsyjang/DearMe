<template>
  <div id="main-container" class="container">
    <div id="join" v-if="!session">
      <div id="join-dialog" class="jumbotron vertical-center">
        <div class="form-group">
          <p class="text-center">
            <button class="btn btn-lg btn-success" @click="createToken()">상담방 입장</button>
          </p>
        </div>
      </div>
    </div>

    <div id="session" v-if="session">
      <div id="session-header">
        <h1 id="session-title">{{ mySessionId }}</h1>
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
// axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';
// axios.defaults.headers.common['Content-Type'] = 'application/x-www-form-urlencoded'
// axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';
import { OpenVidu } from 'openvidu-browser';
import UserVideo from './components/UserVideo';
import { mapGetters } from 'vuex';

axios.defaults.headers.post['Content-Type'] = 'application/json';
// const OPENVIDU_SERVER_URL = "https://i7d206.p.ssafy.io:4443";
// const OPENVIDU_SERVER_SECRET = "dearme";


// 사용자 => 상담방 입장
// 코드 한 번 더 정리하기

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
      subscribers: [],
      subscriber: undefined,
      mySessionId: '', // 방 이름
      myUserName: '', // 유저 닉네임
      counselingId: this.$route.params.counselingId,
    };
  },

  // 오픈비두 서버 보내는 과정
  // First request performs a POST to /openvidu/api/sessions (we send a customSessionId field to name the session with our mySessionId value retrieved from HTML input)
  // Second request performs a POST to /openvidu/api/sessions/<sessionId>/connection (the path requires the sessionId to assign the token to this same session)

  methods: {
    // 사용자!!!
    // joinToken() {

    //   this.OV = new OpenVidu();

    //   // --- Init a session --- 세션 초기화
    //   this.session = this.OV.initSession();

    //   // --- Specify the actions when events take place in the session ---
    //   // On every new Stream received... 참가자 추가
    //   this.session.on('streamCreated', ({ stream }) => {
    //     const subscriber = this.session.subscribe(stream);
    //     this.subscribers.push(subscriber);
    //     console.log('aaaaa')
    //     console.log(stream)
    //     console.log(subscriber)
    //   });
    //   // On every Stream destroyed...
    //   this.session.on('streamDestroyed', ({ stream }) => {
    //     const index = this.subscribers.indexOf(stream.streamManager, 0);
    //     if (index >= 0) {
    //       this.subscribers.splice(index, 1);
    //     }
    //   });

    //   // On every asynchronous exception... 비동기 오류
    //   this.session.on('exception', ({ exception }) => {
    //     console.warn(exception);
    //   });


    //   return new Promise((resolve, reject) => {
        
    //     let authHeader = this.authHeader2
    //     let counselingId = this.counselingId // 왜!!!!!!!!!!!!!!!!!!! 토큰!!!!!!!!!!!!!!!!!
    //     axios
    //       .get(
    //         `https://i7d206.p.ssafy.io/counseling-rooms/` + counselingId,       
    //          {
    //           headers: {
    //             Authorization : authHeader
    //           }
    //         }
    //       )
    //       .then((response) => response.data)
    //       .then((data) => {
    //         resolve(data.token)
    //         return data.data.token
    //       })
    //       .then((token) => {
            
    //           this.session.connect(token, { clientData: this.myUserName })
    //       .then(() => {
    //           console.log('initPublisher')
    //           // 영상 가져오기
    //           let publisher = this.OV.initPublisher(undefined, {
    //               audioSource: undefined, // The source of audio. If undefined default microphone
    //               videoSource: undefined, // The source of video. If undefined default webcam
    //               publishAudio: true,     // Whether you want to start publishing with your audio unmuted or not
    //               publishVideo: true,     // Whether you want to start publishing with your video enabled or not
    //               resolution: '640x480',  // The resolution of your video
    //               frameRate: 30,          // The frame rate of your video
    //               insertMode: 'APPEND',   // How the video is inserted in the target element 'video-container'
    //               mirror: false           // Whether to mirror your local video or not
    //           });

    //         this.mainStreamManager = publisher;
    //         console.log('메인스트림', this.mainStreamManager)
		// 				this.publisher = publisher;
    //         // this.session.publish(this.publisher)
          
    //         this.session.publish(this.publisher)
    //       })
    //       .catch(error => {
    //           console.log('There was an error connecting to the session:', error.code, error.message);
    //       });
    //       })
    //       .catch((error) => reject(error.response));
		// 	});
		// },
    // joinSession() {
    //   // --- Get an OpenVidu object ---
    //   this.OV = new OpenVidu();

    //   // --- Init a session --- 세션 초기화
    //   this.session = this.OV.initSession();

    //   // --- Specify the actions when events take place in the session ---
    //   // On every new Stream received... 참가자 추가
    //   this.session.on('streamCreated', ({ stream }) => {
    //     const subscriber = this.session.subscribe(stream);
    //     this.subscribers.push(subscriber);
    //   });
    //   // On every Stream destroyed...
    //   this.session.on('streamDestroyed', ({ stream }) => {
    //     const index = this.subscribers.indexOf(stream.streamManager, 0);
    //     if (index >= 0) {
    //       this.subscribers.splice(index, 1);
    //     }
    //   });

    //   // On every asynchronous exception... 비동기 오류
    //   this.session.on('exception', ({ exception }) => {
    //     console.warn(exception);
    //   });

    //   // token을 백에서 받아오자
    //   this.getToken().then(token => {
    //     console.log(token)
    //     this.session.connect(token, { clientData: this.myUserName })
    //       .then(() => {

    //           // 영상 가져오기
    //           let publisher = this.OV.initPublisher(undefined, {
    //               audioSource: undefined, // The source of audio. If undefined default microphone
    //               videoSource: undefined, // The source of video. If undefined default webcam
    //               publishAudio: true,     // Whether you want to start publishing with your audio unmuted or not
    //               publishVideo: true,     // Whether you want to start publishing with your video enabled or not
    //               resolution: '640x480',  // The resolution of your video
    //               frameRate: 30,          // The frame rate of your video
    //               insertMode: 'APPEND',   // How the video is inserted in the target element 'video-container'
    //               mirror: false           // Whether to mirror your local video or not
    //           });

    //         this.mainStreamManager = publisher;
		// 				this.publisher = publisher;

    //         this.session.publish(this.publisher)
    //       })
    //       .catch(error => {
    //           console.log('There was an error connecting to the session:', error.code, error.message);
    //       });
    //   });
    //   window.addEventListener('beforeunload', this.leaveSession);
    //   },


    leaveSession() {
      // --- Leave the session by calling 'disconnect' method over the Session object ---
      if (this.session) this.session.disconnect();
      this.session = undefined;
      this.mainStreamManager = undefined;
      this.publisher = undefined;
      this.subscribers = [];
      this.OV = undefined;
      window.removeEventListener('beforeunload', this.leaveSession);
      },

    updateMainVideoStreamManager(stream) {
      if (this.mainStreamManager === stream) return;
      this.mainStreamManager = stream;
    },


    /**
     * --------------------------
     * SERVER-SIDE RESPONSIBILITY
     * --------------------------
     * These methods retrieve the mandatory user token from OpenVidu Server.
     * This behavior MUST BE IN YOUR SERVER-SIDE IN PRODUCTION (by using
     * the API REST, openvidu-java-client or openvidu-node-client):
     *   1) Initialize a Session in OpenVidu Server	(POST /openvidu/api/sessions)
     *   2) Create a Connection in OpenVidu Server (POST /openvidu/api/sessions/<SESSION_ID>/connection)
     *   3) The Connection.token must be consumed in Session.connect() method
    */

    // 백이랑 통신 코드!!
    createToken() {

      this.OV = new OpenVidu();

      // --- Init a session --- 세션 초기화
      this.session = this.OV.initSession();

      // --- Specify the actions when events take place in the session ---
      // On every new Stream received... 참가자 추가
      this.session.on('streamCreated', ({ stream }) => {
        const subscriber = this.session.subscribe(stream);
        this.subscribers.push(subscriber);
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
        let counselingId = this.counselingId // 왜!!!!!!!!!!!!!!!!!!! 토큰!!!!!!!!!!!!!!!!!
        console.log(counselingId)

        axios
          .get(
            `https://i7d206.p.ssafy.io/counseling-rooms/` + counselingId,       
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
            return data.data.token
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
	}
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