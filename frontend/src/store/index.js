import Vuex from 'vuex';
import member from './modules/member';
import board from './modules/board';
import group from './modules/group';

export default new Vuex.Store({
  strict: true,
  modules: {
    member,
    board,
    group,
  },
});