import axios from 'axios'
import drf from '@/api/drf'
import router from '@/router'

import _ from 'lodash'

export default {
    state: {
        textDiaries: [],
        textDiary: {},
    },
    getters: {
        textDiaries: state => state.textDiaries,
        textDiary: state => state.textDiary,
        isAuthor: (state, getters) => {
          return state.textDiary.user?.username === getters.currentUser.username
        },
        isTextDiary: state => !_.isEmpty(state.article),

    },
    mutations: {
        SET_TEXTDIARIES: (state, textDiaries) => state.textDiaries = textDiaries,
        SET_TEXTDIARIY: (state, textDiary) => state.textDiary = textDiary,
    },
    actions: {
        // 전체 텍스트 일기 조회
        fetchTextdIs({ commit, getters }) {
            axios({
              url: drf.board.boardsList(),
              method: 'get',
              headers: getters.authHeader,
            })
    },
    modules: {
    }
  }