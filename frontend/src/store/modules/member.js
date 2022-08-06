import axios from 'axios'
import drf from '@/api/drf'
import router from '@/router'

// import _ from 'lodash'

export default {
  state: {
    token: localStorage.getItem('token') || '',
    currentUser: {},
    profile: {},
    authError: null,
    isAdmin: false,
  },
  getters: {
    isLoggedIn: state => !!state.token,
    currentUser: state => state.currentUser,
    profile: state => state.profile,
    authError: state => state.authError,
    authHeader: state => ({ Authorization: `Token ${state.token}`}),
    isAdmin: state => state.isAdmin,
  },
  mutations: {
    SET_TOKEN: (state, token) => state.token = token,
    SET_CURRENT_USER: (state, user) => state.currentUser = user,
    SET_PROFILE: (state, profile) => state.profile = profile,
    SET_AUTH_ERROR: (state, error) => state.authError = error,
    SET_IS_ADMIN: (state, admin) => state.isAdmin = admin,
  },
  actions: {
    saveToken({ commit }, token) {
      commit('SET_TOKEN', token)
      localStorage.setItem('token', token)
    },
    removeToken({ commit }) {
      commit('SET_TOKEN', '')
      localStorage.setItem('token', '')
    },
    login({ commit, getters, dispatch }) {
      axios({
        url: drf.member.login(),
        method: 'get',
        headers: getters.authHeader,
      })
        .then(res => {
          console.log('성공')
          const token = res.data.accessToken
          dispatch('fetchCurrentUser', token)
          router.push({ name: 'mypageUser' })
        })
        .catch(err => {
          console.error(err.response.data)
          commit('SET_AUTH_ERROR', err.response.data)
        })
    },
    signup({ commit, dispatch }, formData) {
      axios({
        url: drf.member.signup(),
        method: 'post',
        data: formData
      })
      .then((res) => {
          // console.log(res)
          // console.log(res.data)
          const token = res.data.accessToken
          dispatch('saveToken', token)
          alert('save token성공')
          dispatch('fetchCurrentUser')
          alert('fetch user 성공')
          router.push({ name: 'login' })
        })
        .catch((err) =>
        { console.error(err)
          console.error(err.response.data)
          commit('SET_AUTH_ERROR', err.response.data)
        })
    },
    logout({ getters, dispatch, commit }) {
      axios({
        url: drf.member.logout(),
        method: 'post',
        // data: {},
        headers: getters.authHeader,
      })
        .then(() => {
          dispatch('removeToken')
          commit('SET_IS_ADMIN', false)
          router.push({ name: 'login' })
        })
        .error(err => {
          console.error(err.response)
        })
    },
    fetchCurrentUser({ commit, getters, dispatch }) {
      if (getters.isLoggedIn) {
        axios({
          url: drf.member.currentUserInfo(),
          method: 'get',
          headers: getters.authHeader,
        })
          .then(res => {
            commit('SET_CURRENT_USER', res.data)
          })
          .catch(err => {
            if (err.response.status == 401) {
              dispatch('removeToken')
              router.push({ name: 'login' })
            }
          })
      }
    },
  },
}
