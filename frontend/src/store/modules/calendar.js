import axios from 'axios'
import drf from '@/api/drf'
import router from '@/router'


export default {
    state: {
        textDiaries: [],
        textDiary: {},
        videoDiaries: [],
        videoDiary: {},

    },
    getters: {
        textDiaries: state => state.textdiaries,
        textDiary: state => state.textdiary,
        videoDiaries: state => state.videoDiaries,
        videoDiary: state => state.videoDiary,

    },
    mutations: {
        SET_TEXTDIARIES: (state, textDiaries) => state.textDiaries = textDiaries,
        SET_TEXTDIARY: (state, textDiary) => state.textDiary = textDiary,

    },
    actions: {
        // 텍스트 일기 삭제
    deleteTextDiary({ commit, getters }, textDiaryId) {
        if (confirm('정말 삭제하시겠습니까?')) {
          axios({
            url: drf.textDiary.textDiaryEdit(textDiaryId),
            method: 'delete',
            headers: getters.authHeader
          })
            .then(() => {
              commit('SET_TEXTDIARY', {})
              router.push({ name: 'CalendarComp' })
            })
            .catch(err => console.error(err.response))
        }
      },// 영상 일기 삭제
      deleteVideoDiary({ commit, getters }, videoDiaryId) {
        if (confirm('정말 삭제하시겠습니까?')) {
          axios({
            url: drf.videoDiary.videoDiaryEdit(videoDiaryId),
            method: 'delete',
            headers: getters.authHeader
          })
            .then(() => {
              commit('SET_VIDEODIARY', {})
              router.push({ name: 'CalendarComp' })
            })
            .catch(err => console.error(err.response))
        }
      },
        

    },

}