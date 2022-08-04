import axios from "axios";
import drf from "@/api/drf";
import router from "@/router";

export default createStore({
  state: {
    nickname: "",
    groupRequestContent: "",
    isOpenCalender: true,
  },
  getters: {
    nickname: (state) => state.nickname,
    groupReqeust: (state) => state.groupRequestContent,
    isOpenCalender: (state) => state.isOpenCalender,
  },
  mutations: {
    NICKNAME: (state, nickname) => (state.nickname = nickname),
    GROUPREQUEST: (state, groupRequest) => (state.groupRequest = groupRequest),
    ISOPENCALENDER: (state, isOpenCalender) =>
      (state.isOpenCalender = isOpenCalender),
  },
  actions: {
    // 그룹 참가 신청 작성
    createRequest({ commit, getters }, groupReqeust, groupId) {
      axios({
        url: drf.group.request(),
        method: "post",
        data: groupReqeust,
        headers: getters.authHeader,
      }).then((res) => {
        commit("GROUPREQUEST", res.data);
        router.push({
          name: "groupReqeust",
        });
      });
    },
    // 신청서 작성을 위한 사용자 닉네임 받아오기
    fetchNickname({ commit, getters }, userId) {
      axios({
        url: drf.group.request(userId),
        method: "GET",
        headers: getters.authHeader,
      })
        .then((res) => commit("NICKNAME", res.data))
        .catch((err) => {
          console.error(err.response);
          if (err.response.status === 404) {
            router.push({ name: "NotFound404" });
          }
        });
    },
  },
  modules: {},
});
