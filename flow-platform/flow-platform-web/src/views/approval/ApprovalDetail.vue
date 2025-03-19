<template>
  <div class="approval-detail">
    <h1>审批详情</h1>
    <Card>
      <template #header>表单信息</template>
      <div>
        <p>表单ID: {{ formData.formId }}</p>
        <p>表单类型: {{ formData.formType }}</p>
        <p>提交人: {{ formData.submitUser }}</p>
        <p>当前状态: {{ formData.currentStatus }}</p>
      </div>
    </Card>
    <Card>
      <template #header>审批记录</template>
      <Table :columns="columns" :data="records" />
    </Card>
  </div>
</template>

<script>
import { ref } from 'vue';
import { getFormDataById, getRecordsByFormId } from '@/api/formData';
import Card from '@/components/Card.vue';
import Table from '@/components/Table.vue';

export default {
  name: 'ApprovalDetail',
  components: { Card, Table },
  setup() {
    const formData = ref({});
    const records = ref([]);

    const columns = [
      { key: 'recordId', title: '记录ID' },
      { key: 'approver', title: '审批人' },
      { key: 'approvalResult', title: '审批结果' },
      { key: 'approvalOpinion', title: '审批意见' },
    ];

    const fetchData = async () => {
      const formId = this.$route.params.formId;
      const formResponse = await getFormDataById(formId);
      formData.value = formResponse.data;

      const recordsResponse = await getRecordsByFormId(formId);
      records.value = recordsResponse.data;
    };

    fetchData();

    return {
      formData,
      records,
      columns,
    };
  },
};
</script>

<style scoped>
.approval-detail {
  padding: 20px;
}
</style>