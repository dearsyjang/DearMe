import axios from 'axios'
import drf from '@/api/drf'

import _ from 'lodash'

export default {
  state: {
    myBoards: [],
    myId : {},
  },
  getters: {
    myboards: state => state.myboards,
    myid: state => state.myId,
  },
  mutations: {
    SET_MY_BOARDS: (state, myboards) => state.myboards = myboards,
    SET_MY_ID: (state, myId) => state.myId = myId
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
        location.reload();
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
        location.reload();
      })
      .catch(err => console.error(err.response))
    },
  }
}
