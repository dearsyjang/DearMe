import { createStore } from 'vuex'

export default createStore({
  state: {
    careers: [
      {
        title: '경력 1',
        isCompleted: false,
        date: new Date().getTime(),
      },
      {
        title: '경력 2',
        isCompleted: false,
        date: new Date().getTime()
      }
    ]
  },
  getters: {
  },
  mutations: {
    CREATE_CAREER: function (state, careerItem) {
      state.careers.push(careerItem)
    }
  },
  actions: {
    createCareer: function (context, careerItem) {
      context.commit('CREATE_CAREER', careerItem)
    }
  },
  modules: {
  }
})