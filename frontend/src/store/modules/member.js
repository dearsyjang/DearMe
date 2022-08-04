import router from "@/router";
import drf from "@/api/drf";
import axios from "axios";

export default {
  state: {
    token: localStorage.getItem("token") || "",
    currentUser: {},
    userProfile: {},
    authError: null,
  },
  getters: {
    isLoggedIn(state) {
      return !!state.token;
    },
    //currentUser는 현재 로그인되어 있는 유저의 기본 정보
    currentUser(state) {
      return state.currentUser;
    },
    //profile은 대상 유저의 기본 정보 + 작성글/좋아요글/(+작성댓글/좋아요댓글/본영화/보고싶은영화/기타)
    authError(state) {
      return state.authError;
    },
    //유저 인증을 위해 axios 요청 보낼 때 필수적으로 보내야됨. token이 있으면 authHeadr를 getter로 불러올 수 있음
    authHeader(state) {
      return { Authorization: `Token ${state.token}` };
    },
  },
  mutations: {
    SET_TOKEN(state, token) {
      return (state.token = token);
    },
    SET_CURRENT_USER(state, user) {
      console.log("지금 커런트 유저 설정됨", user);
      return (state.currentUser = user);
    },
    SET_AUTH_ERROR(state, error) {
      return (state.authError = error);
    },
  },
  actions: {
    setToken({ commit }, token) {
      commit("SET_TOKEN", token);
      console.log("setToken완료");
      localStorage.setItem("token", token);
    },
    removeToken({ commit }) {
      commit("SET_TOKEN");
      localStorage.setItem("token", "");
    },

    signUp({ commit, dispatch, getters }, credentials) {
      axios({
        url: drf.accounts.signup(),
        method: "post",
        data: credentials,
      })
        .then((res) => {
          dispatch("setToken", res.data.key);
          dispatch("getCurrentUser");
          setTimeout(function () {
            console.log("회원가입 후 currentUser", getters.currentUser);
            dispatch("getUserProfile", {
              username: getters.currentUser.username,
            });
            router.push({
              name: "profile",
              params: { username: getters.currentUser.username },
            });
          }, 10);
        })
        .catch((err) => {
          console.error(err.response.data);
          commit("SET_AUTH_ERROR", err.response.data);
        });
    },

    getCurrentUser({ commit, getters, dispatch }) {
      if (getters.isLoggedIn) {
        axios({
          url: drf.accounts.currentUserInfo(),
          method: "get",
          headers: getters.authHeader,
        })
          .then((res) => {
            commit("SET_CURRENT_USER", res.data);
          })
          .catch((err) => {
            if (err.response.status === 401) {
              dispatch("removeToken");
              router.push({ name: "login" });
            }
          });
      }
    },
  },
};
// import axios from "axios";
// import drf from "@/api/drf.js";
// import router from "@/router";

// export default createStore({
//   state: {
//     token: localStorage.getItem("token") || "",
//     currentUser: {},
//     authError: null,
//   },
//   getters: {
//     currentUser: (state) => state.currentUser,
//     authError: (state) => state.authError,
//   },
//   mutations: {
//     SET_TOKEN: (state, token) => (state.token = token),
//     SET_CURRENT_USER: (state, user) => (state.currentUser = user),
//     SET_AUTH_ERROR: (state, error) => (state.authError = error),
//   },
//   actions: {
//     saveToken({ commit }, token) {
//       commit("SET_TOKEN", token);
//       console.log("setToken완료");
//       localStorage.setItem("token", token);
//     },
//     removeToken({ commit }) {
//       commit("SET_TOKEN", "");
//       localStorage.setItem("token", "");
//     },

//     signup({ commit, dispatch }, credentials) {
//       alert("axios 전");
//       axios({
//         url: drf,
//         method: "post",
//         data: credentials,
//       })
//         .then((res) => {
//           const token = res.data.key;
//           dispatch("saveToken", token);
//           dispatch("fetchCurrentUser");
//           // router.push({ name: "mypage" });
//           alert("성공");
//         })
//         .catch((err) => {
//           console.error(err.response.data);
//           commit("SET_AUTH_ERROR", err.response.data);
//         });
//     },
//     fetchCurrentUser({ commit, getters, dispatch }) {
//       if (getters.isLoggedIn) {
//         axios({
//           url: drf.accounts.currentUserInfo(),
//           method: "get",
//           headers: getters.authHeader,
//         })
//           .then((res) => {
//             commit("SET_CURRENT_USER", res.data);
//           })
//           .catch((err) => {
//             if (err.response.status == 401) {
//               dispatch("removeToken");
//               // router.push({ name: "mypage" });
//             }
//           });
//       }
//     },
//   },
//   modules: {},
// });
