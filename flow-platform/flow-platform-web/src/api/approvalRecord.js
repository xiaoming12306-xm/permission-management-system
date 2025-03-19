import axios from 'axios';

const API_URL = 'http://localhost:8080/api/approval-records';

// 获取所有审批记录
export const getAllRecords = async () => {
  const response = await axios.get(API_URL);
  return response.data;
};

// 获取单个审批记录
export const getRecordById = async (recordId) => {
  const response = await axios.get(`${API_URL}/${recordId}`);
  return response.data;
};

// 创建审批记录
export const createRecord = async (record) => {
  const response = await axios.post(API_URL, record);
  return response.data;
};

// 更新审批记录
export const updateRecord = async (recordId, record) => {
  const response = await axios.put(`${API_URL}/${recordId}`, record);
  return response.data;
};

// 删除审批记录
export const deleteRecord = async (recordId) => {
  const response = await axios.delete(`${API_URL}/${recordId}`);
  return response.data;
};