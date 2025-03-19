import axios from 'axios';

const API_URL = 'http://localhost:8080/api/notifications';

// 获取所有通知
export const getAllNotifications = async () => {
  const response = await axios.get(API_URL);
  return response.data;
};

// 标记通知为已读
export const markAsRead = async (notificationId) => {
  const response = await axios.put(`${API_URL}/${notificationId}/read`);
  return response.data;
};