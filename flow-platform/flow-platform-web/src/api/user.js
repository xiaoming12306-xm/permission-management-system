import axios from 'axios';

const API_URL = 'http://localhost:8080/api/users';

// 获取所有用户
export const getAllUsers = async () => {
  const response = await axios.get(API_URL);
  return response.data;
};

// 获取单个用户
export const getUserById = async (userId) => {
  const response = await axios.get(`${API_URL}/${userId}`);
  return response.data;
};

// 创建用户
export const createUser = async (user) => {
  const response = await axios.post(API_URL, user);
  return response.data;
};

// 更新用户
export const updateUser = async (userId, user) => {
  const response = await axios.put(`${API_URL}/${userId}`, user);
  return response.data;
};

// 删除用户
export const deleteUser = async (userId) => {
  const response = await axios.delete(`${API_URL}/${userId}`);
  return response.data;
};