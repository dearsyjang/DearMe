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

        async fetchSchedules({commit, getters}) {
            return await axios({
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
                console.error(err.response)
            })
        }
    }
}