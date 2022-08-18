import axios from 'axios'
import drf from '@/api/drf'


export default {
  state: {
    myBoards: [],
    myId : {},
    myreviews: []
  },
  getters: {
    myboards: state => state.myboards,
    myid: state => state.myId,
    myreviews: state => state.myreviews
  },
  mutations: {
    SET_MY_BOARDS: (state, myboards) => state.myboards = myboards,
    SET_MY_ID: (state, myId) => state.myId = myId,
    SET_MY_REVEIWS: (state, myreviews) => state.myreviews = myreviews,
  },
  actions: {
    // 나의 게시글 패치
    fetchMyBoards({ commit, getters }) {
      // page, size 가 뭐지
      axios({
        url: drf.board.boardsList()+'?page=0&size=5',
        method: 'get',
        headers: getters.authHeader,
      })
      .then(res => {
        commit('SET_BOARDS', res.data.data.content)
      })
      .catch(err => console.error(err.response))
    },
    fetchMyId({ commit, getters }) {
      axios({
        url: drf.member.signup(),
        method: 'get',
        headers: getters.authHeader,
      })
      .then(res => {
        commit('SET_MY_ID', res.data.data.id)
      })
      .catch(err => console.error(err.response))
    },
  },
  fetchReveiw({ commit, getters }) {
    axios({
      url: drf.mypage.getReveiw(),
      method: 'get',
      headers: getters.authHeader,
    })
    .then(res => {
      console.log(res.data.data)
      console.log(res.data)
      commit('SET_MY_REVEIWS', res.data.data)
    })
    .catch(err => console.error(err.response))
  },
}