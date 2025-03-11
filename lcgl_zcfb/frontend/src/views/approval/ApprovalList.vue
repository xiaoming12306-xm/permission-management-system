<template>
  <el-card>
    <el-table :data="approvalList" style="width: 100%">
      <el-table-column prop="id" label="ID" width="80"></el-table-column>
      <el-table-column prop="applicant" label="申请人"></el-table-column>
      <el-table-column prop="department" label="部门"></el-table-column>
      <el-table-column prop="status" label="状态">
        <template #default="scope">
          <el-tag :type="getStatusType(scope.row.status)">
            {{ getStatusText(scope.row.status) }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column label="操作" width="180">
        <template #default="scope">
          <el-button type="primary" @click="approve(scope.row)">审批</el-button>
          <el-button type="danger" @click="reject(scope.row)">驳回</el-button>
        </template>
      </el-table-column>
    </el-table>
  </el-card>
</template>

<script setup>
import { ref } from 'vue'

const approvalList = ref([
  { id: 1, applicant: '张三', department: '技术部', status: '待审批' },
  { id: 2, applicant: '李四', department: '市场部', status: '已通过' },
  { id: 3, applicant: '王五', department: '财务部', status: '已驳回' }
])

const getStatusType = (status) => {
  switch (status) {
    case '待审批':
      return 'warning'
    case '已通过':
      return 'success'
    case '已驳回':
      return 'danger'
    default:
      return ''
  }
}

const getStatusText = (status) => {
  return status
}

const approve = (row) => {
  console.log('审批通过:', row)
  // 在此处调用API进行审批操作
}

const reject = (row) => {
  console.log('审批驳回:', row)
  // 在此处调用API进行驳回操作
}
</script> 