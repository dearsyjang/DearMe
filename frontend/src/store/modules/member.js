import axios from 'axios'
import drf from '@/api/drf'
import router from '@/router'

// import _ from 'lodash'

export default {
  state: {
    // 회원가입때 생성된 토큰을 로컬스토리지에서 조회
    token: localStorage.getItem('token') || '',
    // 로그인된 사용자
    currentUser: {},
    profile: {},
    authError: null,
  },
  getters: {
    // 로그인, 로그아웃 경우에 현재 사용자 업데이트
    isLoggedIn: state => !!state.token,
    currentUser: state => state.currentUser,
    profile: state => state.profile,
    // 현재 사용자의 토큰을 나타냄 (요청 보낼 때, header에서 사용)
    authHeader2: state => `Token ${state.token}`,
    authHeader: state => ({ Authorization: `Token ${state.token}`}),
    authError: state => state.authError,
  },
  mutations: {
    SET_TOKEN: (state, token) => state.token = token,
    SET_CURRENT_USER: (state, user) => state.currentUser = user,
    SET_PROFILE: (state, profile) => state.profile = profile,
    SET_AUTH_ERROR: (state, error) => state.authError = error,

  },
  actions: {
    // 회원가입
    saveToken({ commit }, token) {
      commit('SET_TOKEN', token)
      // 회원가입시 받은 토큰을 로컬스토리지에 추가
      localStorage.setItem('token', token)
    },
    // 로그아웃
    removeToken({ commit }) {
      // 현재 사용자 비움
      commit('SET_TOKEN', '')
      localStorage.setItem('token', '')
      commit('SET_CURRENT_USER', '')

    },
    // 받아오는 데이터가 한개일 경우 입력, 여러개일 경우 {}안에 담아와야함
    login({ commit, dispatch}, data) {
      axios({
        // url: 'https://i7d206.p.ssafy.io/users/token?id=id1&pw=pw1',
        url: drf.member.login()+`?id=${data.id}&pw=${data.pw}`,
        method: 'get'
      })
        .then(res => {
          const token = res.data.data.accessToken
          console.log(res.data)
          dispatch('saveToken', token)
          dispatch('fetchCurrentUser')
          router.push({ name: 'mypageUser' })
        })
        .catch(err => {
          console.error(err)
          console.error(err.response.data)
          commit('SET_AUTH_ERROR', err.response.data)
        })
    },
    // POST 요청일 경우 FormData로 보내야함 (SignupUserView 참고)
    signup({ commit, dispatch }, formData) {
      axios({
        url: drf.member.signup(),
        method: 'post',
        data: formData,
        // haeder 이형식이면 axios error 발생
        // headers: {
        //   'Content-Type': 'multipart/form-data'
        // }
      })
      .then(res => {
          // console.log(res)
          // console.log(res.data)
          // console.log(res.data.data)
          // console.log(res.data.data.accessToken)
          const token = res.data.data.accessToken
          console.log(token)
          // 로컬스토리지에 토큰 저장
          dispatch('saveToken', token)
          alert('회원가입 성공')
          // 여기서 바로 마이페이지로 넘어갈지 고민중..
          router.push({ name: 'login' })
        })
        .catch((err) => {
          console.error(err)
          console.error(err.response.data)
          commit('SET_AUTH_ERROR', err.response.data)
        })
    },
    // 로그아웃은 별도 요청 없이 현재 사용자 리셋
    logout({ dispatch, getters}) {
      dispatch('removeToken')
      console.log(getters.currentUser)
      router.push({ name: 'login' })
    },
  
  // fetchCurrentUser({ commit, getters, dispatch }) {
  //   if (getters.isLoggedIn) {
  //     axios({
  //       url: drf.member.currentUserInfo(),
  //       method: 'get',
  //       headers: getters.authHeader,
  //     })
  //       .then(res => {
  //         commit('SET_CURRENT_USER', res.data.data.accessToken)
  //       })
  //       .catch(err => {
  //         if (err.response.status == 401) {
  //           dispatch('removeToken')
  //           router.push({ name: 'login' })
  //         }
  //       })
  //   }
  // },
  fetchCurrentUser({ commit, getters }) {
    axios({
     url: drf.member.currentUser(),
     method : 'GET',
     headers: {
      'Content-Type': 'application/json',
      'Authorization': getters.authHeader2
      }
    })
    .then(res => {
      console.log(res)
      commit('SET_CURRENT_USER', res.data)
    })       
      
    .catch(err => console.error(err) )
  },
  // 회원 정보(비밀번호, 닉네임) 수정
  updateProfile({ commit, getters }, { pw, nickname}) {
    axios({
      url: drf.member.profileEdit(profileId),
      method: 'put',
      data: { pw, nickname },
      headers: getters.authHeader
    })
      .then(res => {
        commit('SET_PROFILE', res.data)
        router.push({
          name: 'mypageUser',
          
        })
      })
  },
}
}