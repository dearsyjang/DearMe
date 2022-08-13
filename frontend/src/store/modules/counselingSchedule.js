import drf from '@/api/drf'
import axios from 'axios'


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
        fetchCounselings({commit, getters}) {
            axios({
                url: drf.counselingSchedule.counselingSchedule(),
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
        }
    }
}