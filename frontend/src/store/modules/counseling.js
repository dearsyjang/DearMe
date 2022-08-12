import axios from 'axios'

export default {
    state: {
        counselingId: ''
    },

    getters: {
        usertype: (state, getters) => {
            return state.iscounselor === getters.currentUser.type
        },
        counselingId: state => state.counselingId
    },
    
    mutations: {
        SET_COUNSELINGID: (state, counselingId) => state.counselingId = counselingId
    },

    actions: {
       fetchCounselingId({ commit, getters }){
        axios({
            url: 'https://i7d206.p.ssafy.io:443/counselings',
            method:'get',
            headers: {
                'Authorization': getters.authHeader2
            }
        })
        .then(res => commit('SET_COUNSELINGID', res.data.counselings))
        .catch(err => console.error(err.response))
       }
    }
}