import Vuex from 'vuex';
import member from './modules/member';

export default new Vuex.Store({
  strict: true,
  modules: {
    member,
  },
});