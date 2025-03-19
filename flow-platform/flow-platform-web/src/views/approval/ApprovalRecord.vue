<template>
  <div class="approval-record">
    <h1>审批记录</h1>
    <Table :columns="columns" :data="records" />
  </div>
</template>

<script>
import { ref } from 'vue';
import { getAllRecords } from '@/api/approvalRecord';
import Table from '@/components/Table.vue';

export default {
  name: 'ApprovalRecord',
  components: { Table },
  setup() {
    const records = ref([]);

    const columns = [
      { key: 'recordId', title: '记录ID' },
      { key: 'formId', title: '表单ID' },
      { key: 'approver', title: '审批人' },
      { key: 'approvalResult', title: '审批结果' },
      { key: 'approvalOpinion', title: '审批意见' },
    ];

    const fetchRecords = async () => {
      const response = await getAllRecords();
      records.value = response.data;
    };

    fetchRecords();

    return {
      records,
      columns,
    };
  },
};
</script>

<style scoped>
.approval-record {
  padding: 20px;
}
</style>