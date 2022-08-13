// const HOST = 'http://localhost:8080/api/'
const HOST = "https://i7d206.p.ssafy.io"

const MEMBER = '/users'
const BOARD ='/boards'
const COMMENT ='/comments'
const GROUP = '/groups'


export default {
  member : {
    login: () => HOST + MEMBER + '/token',
    logout: () => HOST + MEMBER + '/token',
    signup: () => HOST + MEMBER,
    currentUser: () => HOST + MEMBER,// 정보수정
    idCheck: () => HOST + MEMBER + '/id',
  },
  board : {
    boardCreate: () => HOST + BOARD,
    boardsList: () => HOST + BOARD,
    boardDetail: boardPk => HOST + BOARD + `/${boardPk}`,
    boardEdit: boardPk => HOST + BOARD + `/${boardPk}`,
    commentCreate: boardPk => HOST + BOARD + `/${boardPk}` + COMMENT,
    commentEdit: (boardPk, commentPk) => HOST + BOARD + `/${boardPk}` + COMMENT + `/${commentPk}`
  },
  group : {
    groupRequest: () => HOST + '/counseling-doucments/groups',
    groupDetail: groupId => HOST + GROUP +`/${groupId}`,

  }

}