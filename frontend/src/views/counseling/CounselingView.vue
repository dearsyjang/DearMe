<template>
  <div id="main-container" class="container">
    <div id="join" v-if="!session">
      <div id="join-dialog" class="jumbotron vertical-center">
        <div class="container">
          <div class="popup-wrap" id="popup">
            <div class="popup">
              <div class="popup-body">
                <div class="body-content">
                  <div class="body-contentbox">
                    <h3> 상담방에 입장하시겠습니까? </h3>
                    <div id="popup-btn">
                      <button v-if="currentUser.data.type==`USER`" id="enter-button" class="btn btn-mg" @click="joinSession()">상담방 입장</button>
                      <button v-if="currentUser.data.type==`COUNSELOR`" id="enter-button" class="btn btn-mg" @click="createSession()">상담방 개설</button>
                      <router-link :to="{ name:'userSchedule' }"><button v-if="currentUser.data.type==`USER`" id="cancel-button" class="btn btn-mg">돌아가기</button></router-link>
                      <router-link :to="{ name:'counselorSchedule' }"><button v-if="currentUser.data.type==`COUNSELOR`" id="cancel-button" class="btn btn-mg">돌아가기</button></router-link>
                  </div>
                </div>
                
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

    <!--세션 오픈-->
    <div id="session" v-if="session">
      <div class="card mt-4" id="my-camera">
        <user-video :stream-manager="mainStreamManager"/>
      </div>

      <div class="card-group">
        <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel" data-interval="false">
        <div class="carousel-inner">
          <div class="carousel-item active">
          <user-video
            :stream-manager="publisher"
           @click="updateMainVideoStreamManager(publisher)"/>
          <div id="mynickname"><h5>{{ this.currentUser.data.nickname }}</h5></div>
          </div>
          <div class="carousel-item">
            <user-video
             :stream-manager="publisher"
             @click="updateMainVideoStreamManager(publisher)"/>
            <div id="mynickname"><h5>{{ this.currentUser.data.nickname }}</h5></div>
      </div>

      <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
        </div>
        </div>
      </div>
      <input class="btn btn-large btn-danger" type="button" id="buttonLeaveSession" @click="leaveSession" value="상담 종료"/>
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
import { mapGetters, mapActions } from 'vuex';

axios.defaults.headers.post['Content-Type'] = 'application/json';
// const OPENVIDU_SERVER_URL = "https://i7d206.p.ssafy.io:4443";
// const OPENVIDU_SERVER_SECRET = "dearme";

export default {
  name: 'App',
  components: {
    UserVideo,
  },

  computed: {
    ...mapGetters(['authHeader2', 'currentUser', 'reviews'])
  },

  data() {
    return {
      OV: undefined,
      session: undefined,
      mainStreamManager: undefined,
      publisher: undefined,
      subscribers: [],
      subscriber: undefined,
      mySessionId: '',
      myUserName: '',
      counselingId: this.$route.params.counselingId,
      isdone: false,
      counselorId: this.$route.params.counselorId,
      review : {
      contents: '',
      id: 6,
      value : 0},
    };
  },

  // 오픈비두 서버 보내는 과정
  // First request performs a POST to /openvidu/api/sessions (we send a customSessionId field to name the session with our mySessionId value retrieved from HTML input)
  // Second request performs a POST to /openvidu/api/sessions/<sessionId>/connection (the path requires the sessionId to assign the token to this same session)

  methods: {
    ...mapActions(['fetchCurrentUser', 'createReview']),

    onSubmit() {
    this.review = {
      id: 6,
      contents: this.review.contents,
      value: this.value
    }
    this.createReview(this.review)
    console.log(this.review.id)
    console.log(this.review.contents)
    console.log(this.review.value)
    },

    // 취업준비생 => 상담방 입장
    joinSession() {

      this.OV = new OpenVidu();

      // --- Init a session --- 세션 초기화
      this.session = this.OV.initSession();

      // --- Specify the actions when events take place in the session ---
      // On every new Stream received... 참가자 추가
      this.session.on('streamCreated', ({ stream }) => {
        const subscriber = this.session.subscribe(stream);
        this.subscribers.push(subscriber);
        console.log('aaaaa')
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
        let counselingId = this.counselingId
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
            resolve(data.token)
            return data.data.token
          })
          .then((token) => {
            
              this.session.connect(token, { clientData: this.myUserName })
          .then(() => {
              console.log('initPublisher')
              // 영상 가져오기 => 모든 사용자는 publisher
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
            console.log('메인스트림', this.mainStreamManager)
						this.publisher = publisher;
            this.session.publish(this.publisher)
          })
          .catch(error => {
              console.log('There was an error connecting to the session:', error.code, error.message);
              alert('아직 상담방이 개설되지 않았습니다 😥')
          });
          })
          .catch((error) => reject(error.response));
			});
		},
    

    leaveSession() {


      
      // --- Leave the session by calling 'disconnect' method over the Session object ---
      if (this.session) this.session.disconnect();
      this.session = undefined;
      this.mainStreamManager = undefined;
      this.publisher = undefined;
      this.subscribers = [];
      this.OV = undefined;
      this.isdone = true;
      // this.$router.push({ name: 'CounselingReview', params: {counselorId: 'counselingId'} })
      window.removeEventListener('beforeunload', this.leaveSession);
      console.log(this.isdone)
      },
      


    updateMainVideoStreamManager(stream) {
      if (this.mainStreamManager === stream) return;
      this.mainStreamManager = stream;
    },
    


    // 상담사 => 1:1 상담방 개설
    createSession() {

      const authHeader = this.authHeader2
      var counselingId = this.counselingId

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
        axios
          .post(
            `https://i7d206.p.ssafy.io/counseling-rooms`,
            {
              counselingId : counselingId,
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

              // 영상 가져오기 => 모든 사용자는 publisher
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
              alert('아직 상담방이 개설되지 않았습니다 😥')
          });
          })
          .catch((error) => reject(error.response));
			});
		},
	},

  // currentuser 정보 가져오기
  created(){
    this.fetchCurrentUser()
  }
}
</script>

<style scoped>
#app{
  width: 100%;
  height: 100%;
  background-color: #F9F7F7;
}
div{
  background-color: #F9F7F7;
  text-align: center;
}
body{
  background-color: #F9F7F7;
}
#session{
  flex-direction: column;
}
#main-container{
  background-color: #F9F7F7;
  width: auto;
  height: auto;
}
#card {
  justify-content: center;
  width: auto;
  height: 100px;
  border-style: none;
  border: none;
  color: #1B262C;
}
.popup-wrap{
  background-color:rgba(0,0,0,.3); 
  justify-content:center; 
  align-items:center;     
  position:fixed;         
  top:0;
  left:0;
  right:0;
  bottom:0;               
  display:none; 
  display:flex;
  padding:15px; 
}
.popup{
  width:100%;             
  max-width:400px;          
  border-radius:10px;       
  overflow:hidden;          
  background-color:#264db5; 
  box-shadow: 5px 10px 10px 1px rgba(0,0,0,.3); 
}
.popup-body{                
  width:100%;
  background-color:#ffffff;
  text-align: center;
}
.body-content{              
  width:100%;
  padding:30px;             
}
.body-titlebox{             
  text-align:center;        
  width:100%;
  height:40px;
  margin-bottom:10px;       
}
.body-contentbox{           
  word-break:break-word;    
  overflow-y:auto;          
  min-height:100px;         
  max-height:200px;         
}

#enter-button{
  background-color: #92B4EC;
  color: white;
  margin-top: 20px;
  margin-right: 15px;
}
#cancel-button{
  background-color: #F38181;
  color: white;
  margin-top: 20px;
  margin-right: 10px;
}

#popup-btn{
  display: flex;
  justify-content: center;
}

#session{
  display: flex;
  justify-content: center;
  align-items:center;   
}

html{
  background-color: #DBE2EF;
}

#buttonLeaveSession{
  background-color: #FF6B6B;
  color: white;
  margin: 0;
}
#video-button{
  text-align: center;
}
#video{
  width: auto;
  height: auto;
}
#video-container1{
  width: auto;
  height: auto;
  text-align: center;
  border: 1px solid #A2B5BB;
  margin-bottom: 1;
}
#video-container2{
  width: auto;
  height: auto;
  text-align: center;
  border: 1px solid #A2B5BB;
}
.my-nickname{
  background-color: 112D4E;
  color: white;
  text-align: center;
  margin: 0;
}
.h6{
  margin: 0;
  text-align: center;
  color: #1C3879;
  font-weight: bold;
}
</style>
