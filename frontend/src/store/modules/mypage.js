import { createStore } from 'vuex'
import drf from '@/api/drf'
import axios from 'axios'

export default createStore({
  state: {
    // [ nickname, isCounselor, myPoint ]
    myinfo: ['ulsanjoomo', '사용자', '500' ],
    //  [ boardTitle, boardDate ]
    myboard: ['힘들어요', '2022.08.02'],
    // [ counselor, groupTitle ]
    mygroup: ['이상민', '이별방'],
    // [ counselor, counselingCnt ]
    myfavorite: ['이상민', '3']
  },
  getters: {
    myinfo: state => state.myinfo,
    myboard: state => state.myboard,
    mygroup: state => state.mygroup,
    myfavorite: state => state.myfavorite,
  },
  mutations: {
    MYINFO : (state, myinfo) => state.myinfo=myinfo,
    MYBOARD : (state, myboard) => state.myinfo=myboard,
    MYGROUP : (state, mygroup) => state.myinfo=mygroup,
    MYFAVORITE : (state, myfavorite) => state.myinfo=myfavorite,
  },
  actions: {
    getMyinfo({ commit, getters }) {
      axios({
        url: 'drf.mypage.myinfo()',
        method : 'GET',
        headers: getters.authHeader,
       })
       .then(res => {
         commit('MYINFO', res.data)
       })

       .catch(err => console.error(err.response))
    },
    getMyboard({ commit, getters }) {
      axios({
        url: 'drf.mypage.myboard()',
        method : 'GET',
        headers: getters.authHeader,
       })
       .then(res => {
         commit('MYBOARD', res.data)
       })

       .catch(err => console.error(err.response))
    },
    getMygroup({ commit, getters }) {
      axios({
        url: 'drf.mypage.mygroup()',
        method : 'GET',
        headers: getters.authHeader,
       })
       .then(res => {
         commit('MYGROUP', res.data)
       })

       .catch(err => console.error(err.response))
    },
    getMyfavorite({ commit, getters }) {
      axios({
        url: 'drf.mypage.myfavorite()',
        method : 'GET',
        headers: getters.authHeader,
       })
       .then(res => {
         commit('MYFAVORITE', res.data)
       })

       .catch(err => console.error(err.response))
    },
  },
  modules: {
  }
})