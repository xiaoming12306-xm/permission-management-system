<template>
  <div class="login-container">
    <el-card class="login-card">
      <h2 class="login-title">登录</h2>
      <el-form
          :model="loginForm"
          :rules="rules"
          ref="loginFormRef"
          @submit.prevent="handleLogin"
          class="login-form"
      >
        <el-form-item prop="username">
          <el-input
              v-model="loginForm.username"
              placeholder="用户名"
              prefix-icon="el-icon-user"
              @input="handleInput"
          ></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input
              v-model="loginForm.password"
              type="password"
              placeholder="密码"
              prefix-icon="el-icon-lock"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-button
              type="primary"
              class="login-button"
              @click="handleLogin"
              :loading="loading"
          >登录
          </el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
import {onMounted, ref} from 'vue';
import {ElMessage} from 'element-plus';
import axios from 'axios';
import {useRouter} from 'vue-router';
import {useStore} from 'vuex';

export default {
  setup() {
    const loginForm = ref({
      username: '',
      password: '',
    });

    const rules = {
      username: [{required: true, message: '请输入用户名', trigger: 'blur'}],
      password: [{required: true, message: '请输入密码', trigger: 'blur'}],
    };

    const loading = ref(false);
    const router = useRouter();
    const store = useStore();
    const loginFormRef = ref(null);

    const handleLogin = () => {
      loading.value = true;
      axios.post('/api/auth/login', loginForm.value)
          .then(response => {
            const token = response.data.token;
            store.commit('setToken', token); // 保存 Token 到 Vuex
            ElMessage.success('登录成功');
            router.push('/'); // 跳转到首页
          })
          .catch(error => {
            console.error('登录失败:', error);
            const errorMessage = error.response?.data?.message || '登录失败，请稍后重试';
            ElMessage.error(errorMessage);
          })
          .finally(() => {
            loading.value = false;
          });
    };

    const handleInput = (value) => {
      console.log('输入框的值:', value);
    };

    onMounted(() => {
      console.log('loginFormRef:', loginFormRef.value);
    });

    return {
      loginForm,
      rules,
      loading,
      handleLogin,
      handleInput,
      loginFormRef,
    };
  },
};
</script>

<style scoped>
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f0f2f5;
}

.login-card {
  width: 400px;
  padding: 20px;
}

.login-title {
  text-align: center;
  margin-bottom: 20px;
  font-size: 24px;
  color: #303133;
}

.login-form {
  margin-top: 20px;
}

.login-button {
  width: 100%;
}
</style>