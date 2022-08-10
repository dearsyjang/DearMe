import Vuex from 'vuex';
import member from './modules/member';
import board from './modules/board';
import counselors from './modules/counselors'
export default new Vuex.Store({
  strict: true,
  modules: {
    member,
    board,
    counselors,
  },
});