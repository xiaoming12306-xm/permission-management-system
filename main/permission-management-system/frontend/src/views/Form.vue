<template>
  <div class="form-container">
    <el-card class="form-card">
      <h2 class="form-title">表单提交</h2>
      <el-form :model="formData" :rules="rules" ref="formData" class="form">
        <el-form-item label="姓名" prop="name">
          <el-input v-model="formData.name" placeholder="请输入姓名"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="formData.email" placeholder="请输入邮箱"></el-input>
        </el-form-item>
        <el-form-item label="内容" prop="content">
          <el-input
              type="textarea"
              v-model="formData.content"
              placeholder="请输入内容"
              :rows="4"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm">提交</el-button>
          <el-button @click="resetForm">重置</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
import {ref} from 'vue';
import {ElMessage} from 'element-plus';
import axios from 'axios';

export default {
  setup() {
    const formData = ref({
      name: '',
      email: '',
      content: '',
    });

    const rules = {
      name: [{required: true, message: '请输入姓名', trigger: 'blur'}],
      email: [
        {required: true, message: '请输入邮箱', trigger: 'blur'},
        {type: 'email', message: '请输入有效的邮箱地址', trigger: 'blur'},
      ],
      content: [{required: true, message: '请输入内容', trigger: 'blur'}],
    };

    const submitForm = () => {
      axios.post('/api/forms', formData.value)
          .then(response => {
            ElMessage.success('表单提交成功');
            resetForm();
          })
          .catch(error => {
            ElMessage.error('表单提交失败：' + error.response.data.message);
          });
    };

    const resetForm = () => {
      formData.value = {
        name: '',
        email: '',
        content: '',
      };
    };

    return {
      formData,
      rules,
      submitForm,
      resetForm,
    };
  },
};
</script>

<style scoped>
.form-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f0f2f5;
}

.form-card {
  width: 500px;
  padding: 20px;
}

.form-title {
  text-align: center;
  margin-bottom: 20px;
  font-size: 24px;
  color: #303133;
}

.form {
  margin-top: 20px;
}
</style>