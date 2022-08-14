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
    isAuthor2: (state, getters) => {
      return state.board.user?.username === getters.currentUser.username
    },
    isTextDiary: state => !_.isEmpty(state.diary),

  },
  mutations: {
    SET_TEXTDIARIES: (state, textDiaries) => state.textDiaries = textDiaries,
    SET_TEXTDIARY: (state, textDiary) => state.textDiary = textDiary,
  },
  actions: {
    // 전체 텍스트 일기장 조회
    fetchTextDiaries({ commit, getters }) {
      axios({
        url: drf.textDiary.textDiaryList(),
        method: 'get',
        headers: getters.authHeader,
      })
      .then(res => commit('SET_TEXTDIARIES', res.data.data))
      .catch(err => console.error(err.response))
    },

    //텍스트 일기 상세 페이지
    fetchTextDiary({ commit, getters }, textDiaryPk) {
      axios({
        url: drf.textDiary.textDiaryDetail(textDiaryPk),
        method: 'get',
        headers: getters.authHeader,
      })
        .then(res => commit('SET_TEXTDIARY', res.data))
        
        .catch(err => {
          console.error(err.response)
          if (err.response.status === 404) {
            router.push({ name: 'NotFound404' })
          }
        })
      },

    // 텍스트 일기 작성
    createTextDiary({ commit, getters }, textDiary) {
      
      axios({
        url: drf.textDiary.textDiaryCreate(),
        method: 'post',
        data: {
          contents: textDiary.contents,
          title: textDiary.title,
          
        },
        headers: {
          'Content-Type': 'application/json',
          'Authorization': getters.authHeader2
          }
    
        // headers: getters.authHeader
    } )
        .then(res => {
          console.log(res.data)
          console.log(this.contents)
          console.log('1')
          console.log(res.data.data)
          commit('SET_TEXTDIARY', res.data.data)
          console.log(getters.textDiary.id)
          router.push({
            name: 'textDiaryDetail',
            params: { textDiaryId: getters.textDiary.id
            }
          })
        })
        .catch(err => console.log(err))
    },
     // 텍스트 일기 삭제
     deleteTextDiary({ commit, getters }, textDiaryPk) {
        if (confirm('정말 삭제하시겠습니까?')) {
            
          axios({
            url: drf.textDiary.textDiaryEdit(textDiaryPk),
            method: 'delete',
            headers: getters.authHeader
          })
            .then(() => {
              commit('SET_TEXTDIARY', {})
              
              router.push({ name: 'textDiaryList' })
            })
            
            .catch(err => console.error(err.response))
            
        }
      }
   },
}