import axios from 'axios'
import drf from '@/api/drf'
import router from '@/router'


export default {
  state: {
    groups: [],
    group: {},
    groupRequest:{},
    myGroup: []
  },
  getters: {
    groups: state => state.groups,
    group: state => state.group,
    grouprequest: state => state.groupRequest,
    mygroup: state => state.myGroup
  },
  mutations: {
    SET_GROUPS: (state, groups) => state.groups = groups,
    SET_GROUP: (state, group) => state.group = group,
    SET_GROUP_REQUEST : (state, groupRequest) => state.groupRequest = groupRequest,
    SET_MY_GROUP: (state, mygroup) => state.myGroup = mygroup
  },
  actions: {
    groupRequest({ commit, getters }, content) {
      console.log(content)
      axios({
        url: drf.group.groupRequest(),
        method: 'post',
        data: content,
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${getters.authHeader3}`
          }
      })
      .then(res =>{
        console.log(res.data)
        console.log(res.data.data)
        commit('SET_GROUP_REQUEST', res.data.data)
        alert('그룹 신청 성공')
        router.push({
          name: 'mypageUser'
        })
      })
      .catch(err => console.error(err))
    },
    // 그룹 상세 페이지 내용 패치
    fetchGroup({ commit, getters }, groupId){
      axios({
        url: drf.group.groupDetail(groupId),
        method: 'get',
        headers: getters.authHeader,
      })
      .then(res => {
        console.log('2', getters.group)
        commit('SET_GROUP', res.data.data)
        console.log('3', getters.group)
      })
      .catch(err => {
        console.error(err)
        if (err.response.status === 404) {
          router.push({ name: 'NotFound404' })
        }
      })
    },

    fetchGroups({ commit, getters } ){
      axios({
        url: drf.counselingSchedule.groups(),
        method: 'get',
        headers: {
          'Content-Type': 'application/json',

          'Authorization': getters.authHeader2
          },
      })
      .then(res => {

        commit('SET_GROUPS', res.data.data)

      })
      .catch(err => {
        console.error(err)
        if (err.response.status === 404) {
          router.push({ name: 'NotFound404' })
        }
      })
    },
    fetchMyGroup({ commit, getters } ){
      axios({
        url: drf.group.myGroup(),
        method: 'get',
        headers: getters.authHeader
      })
      .then(res => {
        console.log(res.data)
        console.log(res.data.data)
        commit('SET_MY_GROUP', res.data.data.groups)

      })
      .catch(err => {
        console.error(err)
        if (err.response.status === 404) {
          router.push({ name: 'NotFound404' })
        }
      })
    },




  },
}
