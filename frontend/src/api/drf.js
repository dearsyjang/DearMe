// const HOST = 'http://localhost:8080/api/'
const HOST = "https://i7d206.p.ssafy.io"
const MEMBER = '/users'
const BOARD ='/boards'
const COMMENT ='/comments'
const COUNSELOR = '/counselors'
const GROUP = '/groups'

export default {
  member : {
    login: () => HOST + MEMBER + '/token',
    logout: () => HOST + MEMBER + '/token',
    signup: () => HOST + MEMBER,
    // currentUserInfo: () => HOST + MEMBER + '/token',
    currentUser: () => HOST + MEMBER,// 정보수정
    idCheck: id => HOST + MEMBER + `/id` + `/${id}`,
    nickNameCheck: nickname => HOST + MEMBER + `/nickname` + `/${nickname}`,
    // profile: username => HOST + MEMBER + 'profile/' + username,
    // profile: () => HOST + MEMBER
  },
  board : {
    boardCreate: () => HOST + BOARD,
    boardsList: () => HOST + BOARD,
    boardDetail: boardPk => HOST + BOARD + `/${boardPk}`,
    boardEdit: boardPk => HOST + BOARD + `/${boardPk}`,
    commentCreate: boardPk => HOST + BOARD + `/${boardPk}` + COMMENT,
    commentEdit: (boardPk, commentPk) => HOST + BOARD + `/${boardPk}` + COMMENT + `/${commentPk}`
  },
  counselors: {
     counselors : () => HOST + COUNSELOR,
     counselor : (counselorId) => HOST + COUNSELOR  + `/${counselorId}`,
    // filter : (categoryId) => HOST + MEMBER + '/filter' +  `/${categoryId}`,
    // search : (keyword) => HOST + MEMBER + '/search' +  `/${keyword}`,
  },
  group : {
    groupRequest: () => HOST + '/counseling-documents/groups',
    groupDetail: groupId => HOST + GROUP +`/${groupId}`,
    groupAccept: () => HOST + '/counseling-doucments'

  }


}