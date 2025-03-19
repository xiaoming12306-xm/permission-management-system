import axios from 'axios';

const API_URL = 'http://localhost:8080/api/workflow';

// 启动审批流程
export const startApprovalProcess = async (formData, flowId) => {
  const response = await axios.post(`${API_URL}/start`, formData, { params: { flowId } });
  return response.data;
};

// 审批通过
export const approveForm = async (formId, userId, comment) => {
  const response = await axios.post(`${API_URL}/approve`, null, { params: { formId, userId, comment } });
  return response.data;
};

// 审批拒绝
export const rejectForm = async (formId, userId, comment) => {
  const response = await axios.post(`${API_URL}/reject`, null, { params: { formId, userId, comment } });
  return response.data;
};