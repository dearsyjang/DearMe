<template>
    <div class="container">
        <div id="join" v-show="!joined">
            <br>
            <br>
            <h1>{{ nowDate }} 영상 일기</h1>
            <h2></h2>
            <br>
            <form @submit.prevent="joinSession">
                <input type="text" id="videodiary-title" v-model="title">
                <br>
                <br>
                <button class="btn"><h3>:orange_heart::yellow_heart::green_heart::blue_heart::purple_heart:</h3></button>
            </form>
        </div>

        <div id="session" v-show="joined">
            <h1 v-text="sessionId"></h1>
            <div class="container mb-5 mt-5" id="video-diary">
                <div id="publisher" class="justify-content-center ml-4"></div>
            </div>
            <div class="container" id="video-diary-button">
                <div id="video-button">
                    <button type="button" class="btn" @click="leaveSession"></button>
                    <button type="button" class="btn" @click="startRecording">
                    <h1><i class="bi bi-circle-fill"></i></h1>
                    </button>
                    <button type="button" class="btn" @click="stopRecording">
                    <h1><i class="bi bi-square-fill"></i></h1>
                    </button>
                    <button type="button" class="btn" @click="deleteRecording">
                    <h1><i class="bi bi-trash-fill"></i></h1>
                    </button>
                    <button type="button" class="btn" @click="saveRecording">
                    <h1><i class="bi bi-download"></i></h1>
                    </button>
                </div>

                <div v-if="videoSource!=''">
                    <button class="board-btn-submit btn-sm mx-2" data-bs-toggle="modal"
                        data-bs-target="#videoDiaryView">영상 다시보기</button>
                  <div class="modal fade" id="videoDiaryView" tabindex="-1" aria-labelledby="exampleModalLabel"
                    aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">영상 일기</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <div class="player-container">
                                    <vue3-video-player :src="videoSource"></vue3-video-player>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </div>
            </div>
            <div class="player-container" v-if="this.isTextOn">
                <textarea v-model="this.sentiment"></textarea>
                <textarea v-model="this.contents"></textarea>
                <button type="button" class="btn" @click="updateText">
                    <h1>수정하기</h1>
                </button>
            </div>
        </div>
    </div>

</template>


 
<script>
import axios from 'axios';
import { OpenVidu } from 'openvidu-browser';
import { mapGetters } from 'vuex';





var OV;
var session;
var token;

export default {
    data() {
        return {
            nowDate: '',
            joined: false,
            sessionId: "",
            recordingId: "",
            record_status: false,
            video: '',
            title: '',
            players: {},
            volume: 80,
            isTextOn: false,
            sentiment: '',
            contents: '',
            videoId:'',
            videoSource:'',
        };
    },

    computed: {
        ...mapGetters(['authHeader2'])
    },

    // 오늘 날짜
    mounted () {
        this.timer = setInterval(() => {
        this.setNowTimes()
        },1000)
    },


    methods: {
        setNowTimes () {
            let myDate = new Date()
            let yy = String(myDate.getFullYear())
            let mm = myDate.getMonth() + 1
            let dd = String(myDate.getDate() < 10 ? '0' + myDate.getDate() : myDate.getDate())
            this.nowDate = yy + '년 ' + mm + '월 ' + dd + '일 '
        },

        joinSession() {
            this.getToken(this.sessionId).then(token => {
            OV = new OpenVidu();

            session = OV.initSession();

            session.on("streamCreated", function (event) {
                session.subscribe(event.stream, "subscriber");
            });

            session.connect(token)
                .then(() => {
                    this.joined = true;
                    // 비디오 사이즈 조절
                    var resolution_data = (window.innerWidth * 0.8) + "x" + (window.innerWidth * 0.8);
                    var publisher = OV.initPublisher("publisher", { resolution: resolution_data});
                    session.publish(publisher);
                })
                .catch(error => {
                    console.log("세션 connect 오류", error.code, error.message);
                    });
            })
            .catch(error => {
                console.warn('세션 connect 오류', error.code, error.message);
            });
            },

            leaveSession() {
                this.removeUser();
                session.disconnect();
                if (this.record_status) {
                    this.stop_record(); 
                }
                this.joined = false;
            },

            getToken(mySessionId) {
                // return this.createSession(mySessionId).then((sessionId) => this.createToken(sessionId));
                const authHeader = this.authHeader2
                console.log(authHeader)
                return new Promise((resolve, reject) => {
                    axios
                        .get(
                            https://i7d206.p.ssafy.io/api/recording/get-token,
                            {
                               headers: {
                                    Authorization : authHeader
                                }
                            }
                        )

                    .then(response => {
                        console.log("sessionId", mySessionId);
                        console.log('response', response)
                        console.log('reponse data', response.data)
                        console.log('token', response.data.token);
                        console.log(response.data.data.token)
                        token = response.data.data.token
                        resolve(token);
                    })
                    .catch(error => {
                        console.log("토큰 에러", error)
                        reject(error);
                    })
                });
            },

            removeUser() {
                axios({
                    method:'post', 
                    url: "http://localhost:5000/recording-java/api/remove-user",
                    data: {session_id: this.sessionId, token: token},
                })
                .then(response => {
                    console.warn("remove", this.sessionId);
                    console.log("remove response", response);
                })
                .catch(error => {
                    console.log('remove 에러', error);
                })
            },

            startRecording() {
              const authHeader = this.authHeader2
              console.log(authHeader)
              console.log(session.sessionId)
                axios({
                    method:'post', 
                    url: "https://i7d206.p.ssafy.io/api/recording/start",
                    headers: {
                        Authorization : authHeader
                    },
                    data: ({
                      session: session.sessionId,
                      hasAudio: true,
                      hasVideo: true,
                      outputMode: "COMPOSED",
                      }),
                    })
                .then(response => {
                    console.log('start_record', response);
                    console.log('start_record', response.data.data.recording.id);
                    this.recordingId = response.data.data.recording.id;
                    this.record_status = true;
                })
                .catch(error => {
                    console.error('start_record error', error)
                });
            },

            stopRecording(){
                const authHeader = this.authHeader2
                console.log(authHeader)
                axios({
                    method:'post', 
                    url: "https://i7d206.p.ssafy.io/api/recording/stop",
                    headers: {
                            Authorization : authHeader
                        } ,
                    data: ({ 
                        recording: this.recordingId
                    }),
                  })
                .then(response => {
                    this.record_status = false;
                    console.log(response);
                    console.log("stop record", this.recordingId);
                    this.videoSource="https://i7d206.p.ssafy.io:4443/api/openvidu/recordings/" + this.recordingId + "/" + this.recordingId + ".mp4"

                })
                .catch(error => {
                    console.error(error)
                });
            },

            deleteRecording(){
                const authHeader = this.authHeader2
                console.log(authHeader)
                axios({
                    method: 'delete',
                    url: "https://i7d206.p.ssafy.io/api/recording/delete",
                    headers: {
                        Authorization : authHeader
                    },
                    data: ({
                    recording: this.recordingId
                    }),
                })
                .then(response => {
                    this.videoSource= ''
                    console.log('delete 성공!!')
                    console.log(response)
                })
            },

        saveRecording() {
                const authHeader = this.authHeader2
                console.log(authHeader)
                axios({
                    method: 'post',
                    url: "https://i7d206.p.ssafy.io/api/video-diaries",
                    headers: {
                        Authorization : authHeader
                    },
                    data: ({
                        realFileName: this.recordingId,
                        title: this.title
                    }),
                })
                .then (response => {
                    console.log('저장요청', response)
                    this.isTextOn = true
                    this.sentiment = response.data.data.sentiment
                    this.contents = response.data.data.contents
                    this.videoId = response.data.data.id
                })
                .catch((error) => { // 말을 해야 저장 가능!
                    if (error.response.status === 500) {
                        alert('괜찮아요! 편하게 이야기를 들려주세요:blush:')
                    } 
                });
            },updateText(){
                const authHeader = this.authHeader2
                console.log(authHeader)
                axios({
                    method: 'put',
                    url: "https://i7d206.p.ssafy.io/api/video-diaries/" + this.videoId,
                    headers: {
                        Authorization : authHeader
                    },
                    data: ({
                        title: this.title,
                        contents: this.contents,
                        sentiment: this.sentiment
                    }),
                })
                .then (response => {
                    console.log('수정 요청', response)
                })
                .catch((error) => { // 말을 해야 저장 가능!
                    console.log('에러입니다', error)
                });
        },
        }
    }
</script>


<style scoped>
div{
  background-color: #F9F7F7;
  min-height: 30vh;
}
.container{
background-color: #F9F7F7;
}
body{
  width: auto;
  height: 800px;
  background-color: #F9F7F7;
  justify-content: center;
  align-content: center;
  text-align: center;
}
#join{
    text-align: center;
    justify-content: center;
    height: 800px;
}
.test-player-wrap {
  width: 720px;
  height: 405px;
  position: relative;
  margin: 20px auto;
}
.btn-play {
  color: white;
  margin-right: 10px;
  cursor: pointer;
}
.btn-play svg {
  width: 16px;
}

.test-player-wrap {
  width: 720px;
  height: 405px;
  position: relative;
  margin: 20px auto;
}
.btn-play {
  color: white;
  margin-right: 10px;
  cursor: pointer;
}

.btn-play svg {
  width: 16px;
}
#video-button{
  text-align: center;
}
#publisher{
    margin:0 auto; 
}
#video-diary{
    margin:0 auto; 
}
</style>