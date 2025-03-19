import { createStore } from 'vuex';
import userModule from './modules/user';
import authModule from './modules/auth';

const store = createStore({
  modules: {
    user: userModule,
    auth: authModule,
  },
});

// 创建 Vuex Store
const store = createStore({
  state: {
    user: null, // 当前用户信息
    token: null, // 认证令牌
    isAuthenticated: false, // 是否已认证
    userRoles: [], // 用户角色列表
  },
  mutations: {
    // 设置用户信息
    SET_USER(state, user) {
      state.user = user;
    },
    // 设置认证令牌
    SET_TOKEN(state, token) {
      state.token = token;
      state.isAuthenticated = !!token;
    },
    // 设置用户角色
    SET_USER_ROLES(state, roles) {
      state.userRoles = roles;
    },
    // 清除用户信息和令牌
    CLEAR_AUTH(state) {
      state.user = null;
      state.token = null;
      state.isAuthenticated = false;
      state.userRoles = [];
    },
  },
  actions: {
    // 登录
    login({ commit }, { token, user, roles }) {
      commit('SET_TOKEN', token);
      commit('SET_USER', user);
      commit('SET_USER_ROLES', roles);
      localStorage.setItem('token', token); // 将 token 存储到 localStorage
    },
    // 注销
    logout({ commit }) {
      commit('CLEAR_AUTH');
      localStorage.removeItem('token'); // 清除 localStorage 中的 token
    },
    // 初始化认证状态
    initializeAuth({ commit }) {
      const token = localStorage.getItem('token');
      if (token) {
        commit('SET_TOKEN', token);
        // 这里可以添加获取用户信息的逻辑
      }
    },
  },
  getters: {
    // 获取当前用户
    currentUser: (state) => state.user,
    // 是否已认证
    isAuthenticated: (state) => state.isAuthenticated,
    // 获取用户角色
    userRoles: (state) => state.userRoles,
  },
});

export default store;