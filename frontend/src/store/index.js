import Vuex from 'vuex';
import member from './modules/member';
import board from './modules/board';
import counselors from './modules/counselors';
import counselingSchedule from './modules/counselingSchedule'
import bottombar from './modules/bottombar'
import group from './modules/group';
import counselingRequest from './modules/counselingRequest';
import textDiary from './modules/textDiary';
import videoDiary from './modules/videoDiary';
import createPersistedState from 'vuex-persistedstate';
import mypage from './modules/mypage';

export default new Vuex.Store({
  strict: true,
  modules: {
    mypage,
    member,
    board,
    counselors,
    counselingSchedule,
    bottombar,
    counselingRequest,
    group,
    textDiary,
    videoDiary,
  },
  //vuex plugin 명시
  plugins: [createPersistedState({
      paths: ['member', 'mypage', 'member', 'group', 'counselingSchedule']
  })]
});
