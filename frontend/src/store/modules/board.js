import axios from 'axios'
import drf from '@/api/drf'
import router from '@/router'

import _ from 'lodash'

export default {
  state: {
    boards: [],
    board: {},
  },
  getters: {
    boards: state => state.boards,
    board: state => state.board,
    // isAuthor: (state, getters) => {
    //   return state.board.user?.username === getters.currentUser.username
    // },
    isBoard: state => !_.isEmpty(state.board),

  },
  mutations: {
    SET_BOARDS: (state, boards) => state.boards = boards,
    SET_BOARD: (state, board) => state.board = board,
    SET_BOARD_COMMENTS: (state, comments) => state.board.comments = comments,
  },
  actions: {
    // 전체 게시글 조회
    fetchBoards({ commit, getters }) {
      // page, size 가 뭐지
      axios({
        url: drf.board.boardsList()+'?page=0&size=5',
        method: 'get',
        headers: getters.authHeader,
      })
      .then(res => {
        // console.log(res.data)
        // console.log(res.data.data)
        // console.log(res.data.data.content)

        commit('SET_BOARDS', res.data.data.content)
      })
      .catch(err => console.error(err.response))
    },

    // 게시글 상세 페이지
    fetchBoard({ commit, getters }, pk) {
      axios({
        url: drf.board.boardDetail(pk),
        method: 'get',
        headers: getters.authHeader,
      })
        .then(res => {
          console.log(res.data)
          console.log(res.data.data)
          commit('SET_BOARD', res.data.data)
          commit('SET_BOARD_COMMENTS', res.data.data.comments)
          console.log(getters.board)
        })
        .catch(err => {
          console.error(err)
          if (err.response.status === 404) {
            router.push({ name: 'NotFound404' })
          }
        })
      },

    // 게시글 작성
    createBoard({ commit, getters }, board) {
      console.log(getters.authHeader2)
      axios({
        url: 'https://i7d206.p.ssafy.io/boards',
        method: 'post',
        data: {
          'title': board.title,
          'contents': board.contents
        },
        // headers: {
        //   'Content-Type': 'application/json',
        //   'Authorization': getters.authHeader2
        //   }
        headers: getters.authHeader
    })
        .then(res => {
          commit('SET_BOARD', res.data.data)
          commit('SET_BOARD_COMMENTS', res.data.data.comments)
          console.log(getters.board)
          router.push({
            name: 'board'
          })
        })
        .catch(err => console.error(err))
    },
    // 게시글 수정
    updateBoard({ commit, getters },content) {
      console.log(content)
      console.log(getters.board.id)
      axios({
        url: drf.board.boardEdit(getters.board.id),
        method: 'put',
        data: content,
        headers: getters.authHeader
      })
        .then(res => {
          commit('SET_BOARD', res.data.data)
          router.push({
            name: 'boardDetail',
            params: { boardId: getters.board.id }
          })
        })
    },
    // 게시글 삭제
    deleteBoard({ commit, getters }, boardId) {
      if (confirm('정말 삭제하시겠습니까?')) {
        axios({
          url: drf.board.boardEdit(boardId),
          method: 'delete',
          headers: getters.authHeader
        })
          .then(() => {
            commit('SET_BOARD', {})
            router.push({ name: 'board' })
          })
          .catch(err => console.error(err.response))
      }
    },

    // 댓글 작성
    createComment({ commit, getters }, content ) {
      // const contents = { content }
      axios({
        url: drf.board.commentCreate(1),
        method: 'post',
        data: content,
        headers: getters.authHeader
      })

        .then(res => {
          commit('SET_BOARD_COMMENTS', res.data)
          console.log('댓글 성공')
        })
        .catch(err => console.error(err))
    },
    // 댓글 수정
    updateComment({ commit, getters }, { boardPk, commentPk, content }) {
      const contents = { content }
      axios({
        url: drf.board.commentEdit(boardPk, commentPk),
        method: 'put',
        data: contents,
        headers: {
          'Content-Type': 'application/json',
         'Authorization': getters.authHeader2
        }
      })
        .then(res => {
          commit('SET_BOARD_COMMENTS', res.data)
        })
        .catch(err => console.error(err.response))
    },
    // 댓글 삭제
    deleteComment({ commit, getters }, { boardPk, commentPk }) {
      if (confirm('정말 삭제하시겠습니까?')) {
        axios({
          url: drf.board.commentEdit(boardPk, commentPk),
          method: 'delete',
          headers: getters.authHeader
        })
          .then(res => commit('SET_BOARD_COMMENTS', res.data))
          .catch(err => console.error(err.response))
      }
    }
  },
}
