// const HOST = 'http://localhost:8080/api/'
const HOST = "https://i7d206.p.ssafy.io/"
const MEMBER = 'users'

export default {
  member : {
    login: () => HOST + MEMBER + '/token',
    logout: () => HOST + MEMBER + '/token',
    signup: () => HOST + MEMBER,
    currentUserInfo: () => HOST + MEMBER + '/token',
  },
}