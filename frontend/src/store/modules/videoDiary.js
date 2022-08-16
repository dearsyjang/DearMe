import axios from 'axios'
import drf from '@/api/drf'
import router from '@/router'

import _ from 'lodash'

export default {
  state: {
    videoDiaries: [],
    videoDiary: {},
  },
  getters: {
    videoDiaries: state => state.videoDiaries,
    videoDiary: state => state.videoDiary,
    isAuthor2: (state, getters) => {
      return state.board.user?.username === getters.currentUser.username
    },
    isvideoDiary: state => !_.isEmpty(state.diary),

  },
  mutations: {
    SET_VIDEODIARIES: (state, videoDiaries) => state.videoDiaries = videoDiaries,
    SET_VIDEODIARY: (state, videoDiary) => state.videoDiary = videoDiary,
  },
  actions: {

    //영상 일기 상세 페이지
    fetchVideoDiary({ commit, getters }, videoDiaryPk) {
      axios({
        url: drf.videoDiary.videoDiaryDetail(videoDiaryPk),
        method: 'get',
        headers: getters.authHeader,
      })
        .then(res =>{
          console.log(res.data.data)
          commit('SET_VIDEODIARY', res.data.data)
          
        } )
        
        .catch(err => {
          console.error(err.response)
          if (err.response.status === 404) {
            router.push({ name: 'NotFound404' })
          }
        })
      },

    // 영상 일기 작성
    createVideoDiary({ commit, getters }, videoDiary) {
      
      axios({
        url: drf.videoDiary.videoDiaryCreate(),
        method: 'post',
        data: {
          contents: videoDiary.contents,
          title: videoDiary.title,
          
        },
        headers: {
          'Content-Type': 'application/json',
          'Authorization': getters.authHeader2
          }
    
        // headers: getters.authHeader
    } )
        .then(res => {
          commit('SET_VIDEODIARY', res.data.data)
          router.go()        
        })
        .catch(err => console.log(err))
    },
     // 영상 일기 삭제
     deleteVideoDiary({ commit, getters }, videoDiaryPk) {
        if (confirm('정말 삭제하시겠습니까?')) {
            
          axios({
            url: drf.videoDiary.videoDiaryEdit(videoDiaryPk),
            method: 'delete',
            headers: getters.authHeader
          })
            .then(() => {
              commit('SET_VIDEODIARY', {})
              router.push({ to:'/calendar' })
            })
            
            .catch(err => console.error(err.response))
            
        }
      }
   },
}
