const authModule = {
  namespaced: true,
  state: {
    token: null,
    isAuthenticated: false,
  },
  mutations: {
    SET_TOKEN(state, token) {
      state.token = token;
      state.isAuthenticated = !!token;
    },
    CLEAR_AUTH(state) {
      state.token = null;
      state.isAuthenticated = false;
    },
  },
  actions: {
    login({ commit }, token) {
      commit('SET_TOKEN', token);
      localStorage.setItem('token', token);
    },
    logout({ commit }) {
      commit('CLEAR_AUTH');
      localStorage.removeItem('token');
    },
  },
  getters: {
    isAuthenticated: (state) => state.isAuthenticated,
  },
};

export default authModule;