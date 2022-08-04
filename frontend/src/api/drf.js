const HOST = 'http://localhost:8080/api/'

const MEMBER = 'member/'

export default {
  member : {
    login: () => HOST + MEMBER + 'login/',
    logout: () => HOST + MEMBER + 'logout/',
    signup: () => HOST + MEMBER + 'signup/',
    currentUserInfo: () => HOST + MEMBER + 'user/',
    profile: username => HOST + MEMBER + 'profile/' + username,
    isAdmin: username => HOST + MEMBER + 'isadmin/' + username,
  },
}