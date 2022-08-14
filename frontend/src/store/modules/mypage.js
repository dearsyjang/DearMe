import axios from 'axios'
import drf from '@/api/drf'


export default {
  state: {
    myBoards: [],
    myId : {},
    myFavorite: []
  },
  getters: {
    myboards: state => state.myboards,
    myid: state => state.myId,
    myfavorite: state => state.myFavorite
  },
  mutations: {
    SET_MY_BOARDS: (state, myboards) => state.myboards = myboards,
    SET_MY_ID: (state, myId) => state.myId = myId,
    SET_MY_FAVORITE: (state, myFavorite) => state.myFavorite = myFavorite
  },
  actions: {
    // 나의 게시글 패치

    fetchMyBoards ({ commit, getters }) {
      axios({
        url: drf.board.boardsList()+'?page=0&size=100',
        method: 'get',
        headers: getters.authHeader,
      })
      .then(res => {
        console.log(res.data.data)
        console.log(res.data.data.content)
        // const resNickname = res.data.data.content.nickName
        // if (resNickname === getters.currentUser.data.nickName)
        commit('SET_BOARDS', res.data.data.content)
      })
      .catch(err => console.error(err.response))
    },
    fetchMyId({ commit, getters }) {
      // page, size 가 뭐지
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
    fetchFavorite({ commit, getters }) {
      // page, size 가 뭐지
      axios({
        url: drf.mypage.myFavorite(),
        method: 'get',
        headers: getters.authHeader,
      })
      .then(res => {
        console.log(res.data)
        commit('SET_MY_FAVORITE', res.data.counselorId)
      })
      .catch(err => console.error(err.response))
    },
  }
}
