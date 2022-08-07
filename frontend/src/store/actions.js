import $axios from '../util/axios'

export default {


    requestStartRecording(context, payload) {
        const OPENVIDU_URL = "https://i7d206.p.ssafy.io:4443"
        const AUTH_REQ = {
            username: 'OPENVIDUAPP',
            password: 'MY_SECRET',
        }
        const URL = OPENVIDU_URL + '/openvidu/api/recordings/start'

        return $axios.post(URL, JSON.stringify(payload), { auth: AUTH_REQ })
    },

    requestEndRecording(context, payload) {
        const OPENVIDU_URL = "https://i7d206.p.ssafy.io:4443"
        const AUTH_REQ = {
            username: 'OPENVIDUAPP',
            password: 'MY_SECRET',
        }
        const URL = OPENVIDU_URL + '/openvidu/api/recordings/stop/' + payload.ovSessionId

        return $axios.post(URL, JSON.stringify({}), { auth: AUTH_REQ })
    },


}