<template>
  <div class="register-container">
    <el-card class="register-card">
      <h2 class="register-title">用户注册</h2>
      <el-form :model="registerForm" :rules="rules" ref="registerForm" class="register-form">
        <el-form-item label="用户名" prop="username">
          <el-input v-model="registerForm.username" placeholder="请输入用户名"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input
              type="password"
              v-model="registerForm.password"
              placeholder="请输入密码"
          ></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="confirmPassword">
          <el-input
              type="password"
              v-model="registerForm.confirmPassword"
              placeholder="请再次输入密码"
          ></el-input>
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="registerForm.email" placeholder="请输入邮箱"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm">注册</el-button>
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
import {useRouter} from 'vue-router';

export default {
  setup() {
    const registerForm = ref({
      username: '',
      password: '',
      confirmPassword: '',
      email: '',
    });

    const rules = {
      username: [{required: true, message: '请输入用户名', trigger: 'blur'}],
      password: [{required: true, message: '请输入密码', trigger: 'blur'}],
      confirmPassword: [
        {required: true, message: '请再次输入密码', trigger: 'blur'},
        {
          validator: (rule, value, callback) => {
            if (value !== registerForm.value.password) {
              callback(new Error('两次输入的密码不一致'));
            } else {
              callback();
            }
          },
          trigger: 'blur',
        },
      ],
      email: [
        {required: true, message: '请输入邮箱', trigger: 'blur'},
        {type: 'email', message: '请输入有效的邮箱地址', trigger: 'blur'},
      ],
    };

    const router = useRouter();

    const submitForm = () => {
      axios.post('/api/auth/register', registerForm.value)
          .then(response => {
            ElMessage.success('注册成功');
            router.push('/login');
          })
          .catch(error => {
            ElMessage.error('注册失败：' + error.response.data.message);
          });
    };

    const resetForm = () => {
      registerForm.value = {
        username: '',
        password: '',
        confirmPassword: '',
        email: '',
      };
    };

    return {
      registerForm,
      rules,
      submitForm,
      resetForm,
    };
  },
};
</script>

<style scoped>
.register-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f0f2f5;
}

.register-card {
  width: 500px;
  padding: 20px;
}

.register-title {
  text-align: center;
  margin-bottom: 20px;
  font-size: 24px;
  color: #303133;
}

.register-form {
  margin-top: 20px;
}
</style>