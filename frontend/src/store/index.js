import Vuex from 'vuex';
import member from './modules/member';
import board from './modules/board';
import textDiary from './modules/textDiary';

export default new Vuex.Store({
  strict: true,
  modules: {
    member,
    board,
    textDiary,
  },
});