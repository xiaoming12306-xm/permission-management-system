import axios from 'axios';

const API_URL = 'http://localhost:8080/api/form-data';

// 获取所有表单数据
export const getAllFormData = async () => {
  const response = await axios.get(API_URL);
  return response.data;
};

// 获取单个表单数据
export const getFormDataById = async (formId) => {
  const response = await axios.get(`${API_URL}/${formId}`);
  return response.data;
};

// 创建表单数据
export const createFormData = async (formData) => {
  const response = await axios.post(API_URL, formData);
  return response.data;
};

// 更新表单数据
export const updateFormData = async (formId, formData) => {
  const response = await axios.put(`${API_URL}/${formId}`, formData);
  return response.data;
};

// 删除表单数据
export const deleteFormData = async (formId) => {
  const response = await axios.delete(`${API_URL}/${formId}`);
  return response.data;
};