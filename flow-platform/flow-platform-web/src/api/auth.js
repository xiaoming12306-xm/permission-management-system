import axios from 'axios';

const API_URL = 'http://localhost:8080/api/auth';

// 用户登录
export const login = async (username, password) => {
  const response = await axios.post(`${API_URL}/login`, { username, password });
  return response.data;
};

// 用户注册
export const register = async (username, password, email) => {
  const response = await axios.post(`${API_URL}/signup`, { username, password, email });
  return response.data;
};