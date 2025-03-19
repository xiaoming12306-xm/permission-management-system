import axios from 'axios';

const API_URL = 'http://localhost:8080/api/files';

// 上传文件
export const uploadFile = async (file) => {
  const formData = new FormData();
  formData.append('file', file);
  const response = await axios.post(API_URL, formData, {
    headers: {
      'Content-Type': 'multipart/form-data',
    },
  });
  return response.data;
};

// 获取文件列表
export const getFileList = async () => {
  const response = await axios.get(API_URL);
  return response.data;
};

// 下载文件
export const downloadFile = async (fileId) => {
  const response = await axios.get(`${API_URL}/${fileId}`, { responseType: 'blob' });
  return response.data;
};