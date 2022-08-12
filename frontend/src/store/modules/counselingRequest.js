import axios from 'axios'
import drf from '@/api/drf'
import router from '@/router'

// import _ from 'lodash'

export default {
  state: {
    requests: [],
    request: {},
    open:''
  },
  getters: {
    requests: state => state.requests,
    request: state => state.request,
    
   // open: state => state.open
    

  },
  mutations: {
    SET_REQUESTS: (state, requests) => state.requests = requests,
    SET_REQUEST: (state, request) => state.request = request,
    //SET_OPEN: (state, open) => state.open = open,
  },
  actions: {
    // 전체 상담 요청 조회
    fetchRequests({ commit, getters }) {
      axios({
        url: drf.counselingRequest.requestList(),
        method: 'get',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': getters.authHeader2
          }
      })
        .then(res => commit('SET_REQUESTS', res.data))
        .catch(err => console.error(err.response))
    },

    // 개별 상담 요청 조회
    fetchRequest({ commit, getters }, requestPk) {
      axios({
        url: drf.counselingRequest.requestDetail(requestPk),
        method: 'get',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': getters.authHeader2
          }
      })
        .then(res => commit('SET_REQUEST', res.data))
        .catch(err => {
          console.error(err.response)
          if (err.response.status === 404) {
            router.push({ name: 'NotFound404' })
          }
        })
      },

    // 상담 요청 작성
    createRequest({ commit, getters }, formData) {
      // console.log(request)
      // console.log(getters.authHeader)
      axios({
        url: drf.counselingRequest.requestCreate(),
        method: 'post',
        data: formData,
        headers: {
          'Content-Type': 'application/json',
          'Authorization': getters.authHeader2
          }
      })
        .then(res => {
          commit('SET_REQUEST', res.data)
          router.push({
            name: 'request'
          })
        })
        .catch((err) => {
          console.error(err)
          console.error(err.response.data)
         
        })
    },

    // openRequest({ state, commit, getters }, requestId) {

    //   axios({
    //     url: drf.counselingRequest.openRequest(requestId),
    //     method: 'post',
    //     headers: getters.authHeader,
    //   })
    //     .then(res => {commit('SET_MOVIE', res.data)
    //         let liked = false
    //         state.movie.like_users.forEach((el) => {
    //         if (el.username === getters.currentUser.username){
    //           liked = true
    //         }
    //       })
    //       commit('SET_LIKE', liked)
    //     })
    //     .catch(err => console.error(err.response))
    // },

    // isLiked({ state, commit, getters}) {
    //   let liked = false
    //   state.movie.like_users.forEach((el) => {
    //   if (el.username === getters.currentUser.username){
    //     liked = true
    //   }
    //   })
    //   commit('SET_LIKE', liked)

    // },
    
  }


}