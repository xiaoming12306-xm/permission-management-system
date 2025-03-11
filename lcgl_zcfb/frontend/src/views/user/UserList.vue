<template>
  <el-card>
    <el-table :data="userList" style="width: 100%">
      <el-table-column prop="id" label="ID" width="80"></el-table-column>
      <el-table-column prop="username" label="用户名"></el-table-column>
      <el-table-column prop="realName" label="真实姓名"></el-table-column>
      <el-table-column prop="email" label="邮箱"></el-table-column>
      <el-table-column prop="status" label="状态">
        <template #default="scope">
          <el-tag :type="scope.row.status === 1 ? 'success' : 'danger'">
            {{ scope.row.status === 1 ? '正常' : '禁用' }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column label="操作" width="180">
        <template #default="scope">
          <el-button type="primary" @click="editUser(scope.row)">编辑</el-button>
          <el-button type="danger" @click="deleteUser(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </el-card>
</template>

<script setup>
import { ref } from 'vue'

const userList = ref([
  { id: 1, username: 'admin', realName: '系统管理员', email: 'admin@example.com', status: 1 },
  { id: 2, username: 'zhangsan', realName: '张三', email: 'zhangsan@example.com', status: 1 },
  { id: 3, username: 'lisi', realName: '李四', email: 'lisi@example.com', status: 0 }
])

const editUser = (row) => {
  console.log('编辑用户:', row)
  // 在此处调用API进行用户编辑操作
}

const deleteUser = (row) => {
  console.log('删除用户:', row)
  // 在此处调用API进行用户删除操作
}
</script> 