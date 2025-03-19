import axios from 'axios';

const API_URL = 'http://localhost:8080/api/wechat';

// 发送通知
export const sendNotification = async (userId, message) => {
  const response = await axios.post(`${API_URL}/send-notification`, null, { params: { userId, message } });
  return response.data;
};