import { createStore } from 'vuex'

export default createStore({
  state: {
    temps:[
      {pk: 1,name:'강지명', isCounselor: true, rating:'하', satisfaction: '상담 만족도 1 / 5 (15)'},
      {pk:2,name:'최지상', isCounselor: true, rating:'중', satisfaction: '상담 만족도 3 / 5 (73)'},
      {pk:3,name:'정윤해', isCounselor: false},
      {pk:4,name:'장수영', isCounselor: true, rating:'상', satisfaction: '상담 만족도 4.5 / 5 (1225)'},
    ],
    infos:[]
  },
  getters: {
  },
  mutations: {
    CREATE_INFO(state,newInfo) {
      state.infos.push(newInfo)
    },
    DELETE_INFO(state,infoItem) {
      const index = state.infos.indexOf(infoItem)
      state.infos.splice(index,1)
    }
  },
  actions: {
    createInfo({commit},newInfo) {
      console.log(newInfo)
      commit('CREATE_INFO',newInfo)
    },
    deleteInfo({commit},infoItem) {
      commit('DELETE_INFO',infoItem)
    }
  },
  modules: {
  }
})
