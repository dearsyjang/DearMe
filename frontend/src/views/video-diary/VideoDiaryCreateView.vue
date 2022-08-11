<template>
    <div class="container">
        <div id="join" v-show="!joined">
            <h1>화상 일기 시작</h1>
            <form @submit.prevent="joinSession"> 
                <p>
                    <label>Session:</label>
                    <input type="text" v-model="sessionId">
                </p>
                <p>
                    <input type="submit" value="JOIN">
                </p>
            </form>
        </div>

        <div id="session" v-show="joined">
            <h1 v-text="sessionId"></h1>
            <input type="text" v-model="title">
            <button type="button" class="btn btn-primary" @click="leaveSession">나가기</button>
            <button type="button" class="btn btn-primary" @click="startRecording">녹화 시작</button>
            <button type="button" class="btn btn-primary" @click="stopRecording">녹화 중지</button>
            <button type="button" class="btn btn-primary" @click="deleteRecording">녹화 삭제</button>
            <button type="button" class="btn btn-primary" @click="saveRecording">녹화 저장</button>
            <div >
                <div id ="publisher" ><h3></h3></div>
            </div>

        </div>
    </div>
    
</template>

     

<script>
import axios from 'axios';
import { OpenVidu } from 'openvidu-browser';

var OV;
var session;
var token;
var title;


    export default {
        data() {
            return {
              joined: false,
              sessionId: "",
              recordingId: "",
              record_status: false,
              video: '',
              title: '',
            };
        },

        methods: {
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
                    var resolution_data = (window.innerWidth * 0.35) + "x" + (window.innerWidth * 0.35 / 4.0 * 3.0);  
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
                return new Promise((resolve, reject) => {
                    axios({
                        method:'post', 
                        url: "http://localhost:5000/recording-java/api/get-token",
                        data: {
                            sessionName: ''
                        },
                    })
                    .then(response => {
                        console.log("sessionId", mySessionId);
                        console.log('response', response)
                        console.log('token', response.data.token);
                        token = response.data[0];
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
              console.log(session)               
                axios({
                    method:'post', 
                    url: "http://localhost:5000/recording-java/api/recording/start",
                    data: ({
                      session: session.sessionId
                      }),
                    })
                .then(response => {
                    console.log('start_record', response);
                    this.recordingId = response.data.id;
                    this.record_status = true;
                    console.log('이게 아마 recordingId', this.recordingId);
                })
                .catch(error => {
                    console.error('start_record error', error)
                });
            },
            stopRecording(){
                axios({
                    method:'post', 
                    url: "http://localhost:5000/recording-java/api/recording/stop",
                    data: ({ 
                        recording: this.recordingId
                    }),   
                  })
                .then(response => {
                    this.record_status = false;
                    console.log(response);
                    console.log("stop record", response.data.id);
                })
                .catch(error => {
                    console.error(error)
                });
            },
          deleteRecording(){
              axios({
                method: 'delete',
                url: "http://localhost:5000/recording-java/api/recording/delete",
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
                axios({
                    method: 'post',
                    url: "http://localhost:5000/recording-java/api/recording", // url 주소가 뭘까요?!
                    data: ({
                        recording: this.recordingId,
                        title: title,                        
                    }),
                })
                .then (response => {
                    console.log('저장요청', response)
                })
            }

        
        }
    }
</script>

<style scoped>
#publisher {    
    float: left;
    width: auto;
}
</style>

