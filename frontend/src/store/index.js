import Vuex from 'vuex';
import member from './modules/member';
import board from './modules/board';
import counselors from './modules/counselors';
import counselingSchedule from './modules/counselingSchedule'
import bottombar from './modules/bottombar'
import group from './modules/group';
import counselingRequest from './modules/counselingRequest';
import calendar from './modules/calendar';

export default new Vuex.Store({
  strict: true,
  modules: {
    member,
    board,
    counselors,
    counselingSchedule,
    bottombar,
    counselingRequest,
    group,
    calendar,
  },
});