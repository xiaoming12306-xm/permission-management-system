<template>
  <el-container>
    <el-aside width="200px">
      <el-menu :default-active="activeMenu" class="el-menu-vertical-demo" @select="handleSelect">
        <el-menu-item index="1">表单管理</el-menu-item>
        <el-menu-item index="2">审批管理</el-menu-item>
        <el-menu-item index="3">用户管理</el-menu-item>
      </el-menu>
    </el-aside>

    <el-container>
      <el-header>
        <h2>事务</h2>
      </el-header>

      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'

const activeMenu = ref('1')
const router = useRouter()

const handleSelect = (index) => {
  switch (index) {
    case '1':
      router.push('/api/form')
      break
    case '2':
      router.push('/api/approval')
      break
    case '3':
      router.push('/api/user')
      break
  }
}
</script>

<style>
.el-header {
  background-color: #b3c0d1;
  color: #333;
  line-height: 60px;
  text-align: center;
}

.el-main {
  padding: 20px;
}
</style> 