import axios from 'axios'
import drf from '@/api/drf'
import router from '@/router'

// import _ from 'lodash'

export default {
  state: {
    requests: [],
    request: {},
    open:'',
    isaccept: false
  },
  getters: {
    requests: state => state.requests,
    request: state => state.request,
    isaccept: state => state.isaccept

   // open: state => state.open


  },
  mutations: {
    SET_REQUESTS: (state, requests) => state.requests = requests,
    SET_REQUEST: (state, request) => state.request = request,
    SET_IS_ACCEPT: (state, isaccept) => state.isaccept = isaccept
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
    createRequest({ commit, getters }, request) {
      // console.log(request)
      // console.log(getters.authHeader)
      axios({
        url: drf.counselingRequest.requestCreate(),
        method: 'post',
        data: {
          contents : request.contents,
          isOpen : request.isOpen,
          id : request.id,
          year : request.year,
          month : request.month,
          day : request.day,
          hours : request.hours
        },
        headers: {
          'Content-Type': 'application/json',
          'Authorization': getters.authHeader2
          }
      })
        .then(res => {
          commit('SET_REQUEST', res.data)
          alert('상담 신청이 완료되었습니다.')
          router.push({
            name: 'counselorList'
          })
        })
        .catch((err) => {
          alert('상담 신청 양식을 채워주세요.')
          console.log(request.contents)
          console.log(request.isOpen)
          console.log(request.id)
          console.log(request.year)
          console.log(request.month)
          console.log(request.day)
          console.log(request.hours)

          console.error(err)
          console.error(err.response.data)

        })
    },

    updateRequest({ commit, getters }, change ) {

      axios({
        url: drf.counselingRequest.requestUpdate(),
        method: 'put',
        data: { id: change.id,
              status: change.status },
        headers: {
          'Content-Type': 'application/json',
          'Authorization': getters.authHeader2
          }
      })
        .then(res => {
          commit('SET_REQUEST', res.data)
          alert('상담 신청이 수락되었습니다.')
          router.push({
            name: 'CounselingRequestList',

          })
        })
        .catch((err) => {

          console.error(err)
          console.error(err.response.data)

        })
    },
    counselingAccept ({ commit, getters }, content ) {

      axios({
        url: drf.counselingRequest.requestList(),
        method: 'put',
        data: content,
        headers: {
          'Content-Type': 'application/json',
          'Authorization': getters.authHeader2
          }
      })
        .then(res => {
          console.log(res.data)
          commit('SET_IS_ACCEPT', res.data)
          alert('상담 신청이 수락되었습니다.')
          router.push({
            name: 'mypageCounselor',

          })
        })
        .catch((err) => {

          console.error(err)
          console.error(err.response.data)

        })
      }
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