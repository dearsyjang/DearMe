// const HOST = 'http://localhost:8080/api/'
const HOST = "https://i7d206.p.ssafy.io/api"
const MEMBER = '/users'
const BOARD ='/boards'
const COMMENT ='/comments'
const COUNSELOR = '/counselors'
const GROUP = '/groups'
const TEXTDIARY = '/text-diaries'
const VIDEODIARY = '/video-diaries'
const COUNSELING = '/counselings'
const CAREER = '/careers'
const CERTIFICATE = '/certificates'

export default {
  member : {
    login: () => HOST + MEMBER + '/token',
    logout: () => HOST + MEMBER + '/token',
    signup: () => HOST + MEMBER,
    // currentUserInfo: () => HOST + MEMBER + '/token',
    currentUserInfo: () => HOST + MEMBER + '/token',
    currentUser: () => HOST + MEMBER,// 정보수정
    idCheck: id => HOST + MEMBER + `/id` + `/${id}`,
    nickNameCheck: nickname => HOST + MEMBER + `/nickname` + `/${nickname}`,
    // profile: username => HOST + MEMBER + 'profile/' + username,
    // profile: () => HOST + MEMBER
    careerCreate: () => HOST + MEMBER + CAREER ,
    careerDelete: (careerId) => HOST + MEMBER + CAREER + `/${careerId}`,
    certificateCreate: () => HOST + MEMBER + CERTIFICATE ,
    certificateDelete: (certificateId) => HOST + MEMBER + '/certificate' + `/${certificateId}`,
    profileEdit: () => HOST + MEMBER,
    userDelete: () => HOST + MEMBER

    // profile: () => HOST + MEMBER
  },
  board : {
    boardCreate: () => HOST + BOARD,
    boardsList: () => HOST + BOARD,
    boardDetail: boardId => HOST + BOARD + `/${boardId}`,
    boardEdit: boardId => HOST + BOARD + `/${boardId}`,
    commentCreate: boardPk => HOST + BOARD + `/${boardPk}` + COMMENT,
    commentEdit: (boardPk, commentPk) => HOST + BOARD + `/${boardPk}` + COMMENT + `/${commentPk}`
  },
  counselors: {

     counselors : () => HOST + COUNSELOR + "?",
     counselor : (counselorId) => HOST + COUNSELOR  + `/${counselorId}`,
     reviews : () => HOST + '/reviews',
     favorites : () => HOST + '/favorites',
     favoriteA : () => HOST + '/favorites',
     favoriteD : (favoriteId) => HOST + '/favorites' + `/${favoriteId}`
    // filter : (categoryId) => HOST + MEMBER + '/filter' +  `/${categoryId}`,
    // search : (keyword) => HOST + MEMBER + '/search' +  `/${keyword}`,
  },
  counselingRequest : {
    requestList: () => HOST + COUNSELING,
    requestDetail: (counselingDocumentId) => HOST + COUNSELING  + `/${counselingDocumentId}`,
    requestCreate: () => HOST + '/counseling-documents',
    requestUpdate: () => HOST + COUNSELING,
  },
  group : {
    groupRequest: () => HOST + '/counseling-documents/groups',
    groupDetail: groupId => HOST + GROUP +`/${groupId}`,
    groups: () => HOST + MEMBER + GROUP,
    myGroup:() => HOST + MEMBER + GROUP,
  },
  counselingSchedule: {
    counselingSchedules: () => HOST + COUNSELING,
    counselingSchedule: () => HOST + COUNSELING,
    groupDetail: groupId => HOST + GROUP +`/${groupId}`,
  },
  textDiary : {
    textDiaryCreate: () => HOST + TEXTDIARY,
    textDiaryList: () => HOST + TEXTDIARY,
    textDiaryDetail: textDiaryId => HOST + TEXTDIARY + `/${textDiaryId}`,
    textDiaryEdit: textDiaryId => HOST + TEXTDIARY + `/${textDiaryId}`,
  },
  videoDiary : {
    videoDiaryCreate: () => HOST + VIDEODIARY,
    videoDiaryList: () => HOST + VIDEODIARY,
    videoDiaryDetail: videoDiaryId => HOST + VIDEODIARY + `/${videoDiaryId}`,
    videoDiaryEdit: videoDiaryId => HOST + VIDEODIARY + `/${videoDiaryId}`,
  },
  //downPrice=0&upPrice=1000000&reviewCntUp=FALSE&reviewCntDown=FALSE&reviewScoreUp=FALSE&reviewScoreDown=FALSE&favorite=FALSE
}