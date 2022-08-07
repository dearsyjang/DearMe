// const HOST = 'http://localhost:8080/api/'
const HOST = "https://i7d206.p.ssafy.io/"
const MEMBER = 'users'
const BOARD ='boards'

export default {
  member : {
    login: () => HOST + MEMBER + '/token',
    logout: () => HOST + MEMBER + '/token',
    signup: () => HOST + MEMBER,
    currentUserInfo: () => HOST + MEMBER + '/token',
    idCheck: () => HOST + MEMBER + '/id',
  },
  board : {
    create: () => HOST + BOARD,
    boardsList: () => HOST + BOARD,
    boardDetail: () => HOST + BOARD,
    boardUpdate: () => HOST + BOARD,
    boardDelete: () => HOST + BOARD,
  }
}