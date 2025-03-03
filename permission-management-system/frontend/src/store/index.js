import {createStore} from 'vuex';

export default createStore({
    state: {
        token: null,
    },
    mutations: {
        setToken(state, token) {
            state.token = token;
        },
    },
    actions: {
        login({commit}, token) {
            commit('setToken', token);
        },
    },
});