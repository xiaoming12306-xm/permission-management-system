import axios from 'axios';

const API_URL = 'http://localhost:8080/api/logs';

// 获取所有日志
export const getAllLogs = async () => {
  const response = await axios.get(API_URL);
  return response.data;
};

// 获取单个日志
export const getLogById = async (logId) => {
  const response = await axios.get(`${API_URL}/${logId}`);
  return response.data;
};