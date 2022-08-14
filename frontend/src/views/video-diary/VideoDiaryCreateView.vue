<template>
    <div class="container">
        <div id="join" v-show="!joined">
            <h2>{{ nowDate }} 영상 일기</h2>
            <h2></h2>
            <br>
            <form @submit.prevent="joinSession"> 
                <input type="text" id="videodiary-title" v-model="title">
                <br>
                <br>
                <input type="submit" value="영상일기 기록하기">
            </form>
        </div>

        <div id="session" v-show="joined">
            <h1 v-text="sessionId"></h1>
            <div>
                <div id="publisher"></div>
            </div>
            <div id="video-diary">
                <button type="button" class="btn" @click="leaveSession"></button>
                <button type="button" class="btn" @click="startRecording"><h1>시작</h1></button>
                <button type="button" class="btn" @click="stopRecording"><h1>종료</h1></button>
                <button type="button" class="btn" @click="deleteRecording"><h1>삭제</h1></button>
                <button type="button" class="btn" @click="saveRecording"><h1>저장</h1></button>
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
                            `https://i7d206.p.ssafy.io/recording/get-token`,
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
                    url: "https://i7d206.p.ssafy.io/recording/start",
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
                    url: "https://i7d206.p.ssafy.io/recording/stop",
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
                    url: "https://i7d206.p.ssafy.io/recording/delete",
                    headers: {
                        Authorization : authHeader
                    },
                    data: ({
                    recording: this.recordingId
                    }),
                })
                .then(response => {
                    console.log('delete 성공!!')
                    console.log(response)
                })
            },

            saveRecording(){
                const authHeader = this.authHeader2
                console.log(authHeader)    
                axios({
                    method: 'post',
                    url: "https://i7d206.p.ssafy.io/video-diaries",
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
                })
                .catch((error) => { // 말을 해야 저장 가능!
                    if (error.response.status === 500) {
                        alert('괜찮아요! 편하게 이야기를 들려주세요😊')
                    } 
                });
            }
        }
    }
</script>

<style scoped>
input{
    width: auto;
}
</style>
