<template>
  <el-card>
    <el-form :model="form" label-width="120px">
      <el-form-item label="申请人">
        <el-input v-model="form.applicant"></el-input>
      </el-form-item>
      <el-form-item label="部门">
        <el-select v-model="form.department" placeholder="请选择部门">
          <el-option label="技术部" value="技术部"></el-option>
          <el-option label="人事部" value="人事部"></el-option>
          <el-option label="财务部" value="财务部"></el-option>
          <el-option label="市场部" value="市场部"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="请假类型">
        <el-select v-model="form.leaveType" placeholder="请选择请假类型">
          <el-option label="事假" value="事假"></el-option>
          <el-option label="病假" value="病假"></el-option>
          <el-option label="年假" value="年假"></el-option>
          <el-option label="调休" value="调休"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="开始日期">
        <el-date-picker v-model="form.startDate" type="date" placeholder="选择日期"></el-date-picker>
      </el-form-item>
      <el-form-item label="结束日期">
        <el-date-picker v-model="form.endDate" type="date" placeholder="选择日期"></el-date-picker>
      </el-form-item>
      <el-form-item label="请假原因">
        <el-input type="textarea" v-model="form.reason"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm">提交</el-button>
        <el-button @click="resetForm">重置</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>

<script setup>
import { ref } from 'vue'

const form = ref({
  applicant: '',
  department: '',
  leaveType: '',
  startDate: '',
  endDate: '',
  reason: ''
})

const submitForm = () => {
  console.log('提交表单:', form.value)
  // 在此处调用API提交表单数据
}

const resetForm = () => {
  form.value = {
    applicant: '',
    department: '',
    leaveType: '',
    startDate: '',
    endDate: '',
    reason: ''
  }
}
</script>

<style scoped>
.form-list {
  padding: 20px;
}

.filter-container {
  margin-bottom: 20px;
}

.pagination {
  margin-top: 20px;
  text-align: right;
}
</style>