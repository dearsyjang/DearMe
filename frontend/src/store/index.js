import Vuex from 'vuex';
import member from './modules/member';
import board from './modules/board';

export default new Vuex.Store({
  strict: true,
  modules: {
    member,
    board,
  },
});