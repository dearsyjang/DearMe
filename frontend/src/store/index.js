import Vuex from 'vuex';
import member from './modules/member';
import board from './modules/board';
import counselors from './modules/counselors';
import counselingSchedule from './modules/counselingSchedule'
export default new Vuex.Store({
  strict: true,
  modules: {
    member,
    board,
    counselors,
    counselingSchedule
  },
});