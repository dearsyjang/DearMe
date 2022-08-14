import axios from 'axios'
import drf from '@/api/drf'
import router from '@/router'


export default {
  state: {
    groups: [],
    group: {},
    groupRequest:{}
  },
  getters: {
    groups: state => state.groups,
    group: state => state.group,
    grouprequest: state => state.groupRequest
  },
  mutations: {
    SET_GROUPS: (state, groups) => state.groups = groups,
    SET_GROUP: (state, group) => state.group = group,
    SET_GROUP_REQUEST : (state, groupRequest) => state.groupRequest = groupRequest
  },
  actions: {
    groupRequest({ commit, getters }, content) {
      axios({
        url: drf.group.groupRequest(),
        method: 'post',
        data: content,
        headers: {
          'Content-Type': 'application/json',
          'Authorization' : `Bearer ${getters.authHeader3}`
        },
        // headers: getters.authHeader,
      })
      .then(res =>{
        console.log(res.data)
        console.log(res.data.data)
        commit('SET_GROUP_REQUEST', res.data.data)
        alert('그룹 신청 성공')
        router.push({
          name: 'mypageUser'
        })})
      .catch(err => console.error(err.response))
    },
    // 그룹 상세 페이지 내용 패치
    fetchGroup({ commit, getters }, groupId){
      axios({
        url: drf.group.groupDetail(groupId),
        method: 'get',
        headers: getters.authHeader,
      })
      .then(res => {
        console.log(res.data)
        console.log(res.data.data)
        commit('SET_GROUP', res.data.data)
        console.log(getters.group)
      })
      .catch(err => {
        console.error(err)
        if (err.response.status === 404) {
          router.push({ name: 'NotFound404' })
        }
      })
    },
    groupAccept({ commit, getters }, content){
      axios({
        url: drf.group.groupAccept,
        method: 'get',
        data: content,
        headers: {
          'Content-Type': 'application/json',
          'Authorization' : `Bearer ${getters.authHeader3}`
        },
      })
      .then(res => {
        // 어디에 저장할지 생각
        console.log(res.data)
        console.log(res.data.data)
        commit('SET_GROUP', res.data.data)
        console.log(getters.group)
      })
      .catch(err => {
        console.error(err)
        if (err.response.status === 404) {
          router.push({ name: 'NotFound404' })
        }
      })
    },
    // 회원의 그룹 탈퇴
    groupCancel({ commit, getters }, baordId) {
      if (confirm('정말 그룹 나가기를 하시겠습니까?')) {
        axios({
          url: drf.board.groupCancel(baordId),
          method: 'delete',
          headers: getters.authHeader
        })
          .then(() => {
            // SET 을 어디에 해야할지 고민
            commit('SET_GROUP', {})
            router.push({ name: 'mypageUser' })
          })
          .catch(err => console.error(err.response))
      }
    },
  },
}
