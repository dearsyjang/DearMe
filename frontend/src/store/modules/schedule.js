import axios from 'axios'
import drf from '@/api/drf'


export default {
    state: {
        counselings: [],
    },

    getters: {
        counselings: state => state.counselings,
    },

    mutations: {
        SET_COUNSELINGS: (state, counselings) => state.counselings=counselings,
    },

    actions: {

        fetchSchedules({commit, getters}) {
            axios({
                url: drf.counselingSchedule.counselingSchedule(),
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': getters.authHeader2
                }
            })
            .then(res => {
                commit('SET_COUNSELINGS', res.data)
            })
            .catch(err => {
                console.error(err.response)
            })
        }
    }
}