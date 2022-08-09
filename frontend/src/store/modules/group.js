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
    groups: state => state.groups,
    group: state => state.group,
  },
  mutations: {
    SET_GROUPS: (state, groups) => state.groups = groups,
    SET_GROUP: (state, group) => state.group = group,
  },
  actions: {
    goupRequest({ commit }, content) {
      axios({
        url: drf.group.groupRequest(),
        method: 'post',
        data: content
      })
      .then(res =>
        {commit('SET_GROUP', res.data.data)
        router.push({
          name: 'mypageUser'
        })})
      .catch(err => console.error(err.response))
    },
  },
}
