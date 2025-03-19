import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import axios from 'axios';
import './assets/css/global.css';
import './assets/css/theme.css';

// 设置 Axios 默认配置
axios.defaults.baseURL = 'http://localhost:8080/api';
axios.defaults.headers.common['Authorization'] = localStorage.getItem('token') || '';

// 创建 Vue 应用
const app = createApp(App);

// 使用路由和状态管理
app.use(router);
app.use(store);

// 挂载应用
app.mount('#app');

// 初始化认证状态
store.dispatch('initializeAuth');

// 全局错误处理
app.config.errorHandler = (err, vm, info) => {
  console.error('全局错误:', err);
  alert('发生错误，请检查控制台日志');
};

// 全局 Axios 拦截器
axios.interceptors.request.use(
  (config) => {
    // 请求发送前的处理
    const token = localStorage.getItem('token');
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  (error) => {
    // 请求错误处理
    return Promise.reject(error);
  }
);

axios.interceptors.response.use(
  (response) => {
    // 响应成功处理
    return response;
  },
  (error) => {
    // 响应错误处理
    if (error.response.status === 401) {
      // 未授权，跳转到登录页
      router.push('/login');
    }
    return Promise.reject(error);
  }
);