import axios from 'axios';

const API_URL = 'http://localhost:8080/api/approval-flows';

// 获取所有审批流程
export const getAllFlows = async () => {
  const response = await axios.get(API_URL);
  return response.data;
};

// 获取单个审批流程
export const getFlowById = async (flowId) => {
  const response = await axios.get(`${API_URL}/${flowId}`);
  return response.data;
};

// 创建审批流程
export const createFlow = async (flow) => {
  const response = await axios.post(API_URL, flow);
  return response.data;
};

// 更新审批流程
export const updateFlow = async (flowId, flow) => {
  const response = await axios.put(`${API_URL}/${flowId}`, flow);
  return response.data;
};

// 删除审批流程
export const deleteFlow = async (flowId) => {
  const response = await axios.delete(`${API_URL}/${flowId}`);
  return response.data;
};