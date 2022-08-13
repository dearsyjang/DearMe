import axios from 'axios'
import drf from '@/api/drf'

export default ({
  state: {
    token: localStorage.getItem('token') || '',
    currentUser: {},
    type: "",
  },

  getters: {
    userType: state => state.type,
  },

  mutations: {
    SET_USER_TYPE: (state, type) => state.type = type
  },

  actions: {
    getuserType({ commit, getters }) {
        axios({
            url: drf.users.user(),
            method: 'get',
            headers: getters.authHeader,
        })
        .then(res => {
            console.log(res)
            commit('SET_USER_TYPE', res.data)
        })
        .catch(err => console.error('type', err))
    }
  },
})