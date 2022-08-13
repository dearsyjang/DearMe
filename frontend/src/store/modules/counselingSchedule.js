import drf from '@/api/drf'
import axios from 'axios'


export default {
    state: {
        counselings: [],
        counseling: [],
    },
    getters: {
        counselings: state => state.counselings,
        counseling: state => state.counseling,
    },
    mutations: {
        SET_COUNSELINGS: (state, counselings) => state.counselings=counselings,
        SET_COUNSELING: (state, counseling) => state.counseling=counseling
    },
    actions: {
        async fetchCounselings({commit, getters}) {
            await axios({
                url: drf.counselingSchedule.counselingSchedules(),
                method: 'GET',
                headers: {
                    'Authorization': getters.authHeader2
                }
            })
            .then(res => {
                commit('SET_COUNSELINGS', res.data)
            })
            .catch(err => {
                console.error(err)
            })
        },

        async fetchCounseling({commit, getters}, counselingPk) {
            await axios({
                url: drf.counselingRequest.requestDetail(counselingPk),
                method: 'GET',
                headers: {
                  'Content-Type': 'application/json',
                  'Authorization': getters.authHeader2
                  }
              })
                .then(res => {
                    commit('SET_COUNSELING', res.data)
                })
                .catch(err => {
                  console.error(err)
                })
        }
    }
}