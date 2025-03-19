<template>
  <div class="form-list">
    <h1>表单列表</h1>
    <Table :columns="columns" :data="forms" />
  </div>
</template>

<script>
import { ref } from 'vue';
import { getAllFormData } from '@/api/formData';
import Table from '@/components/Table.vue';

export default {
  name: 'FormList',
  components: { Table },
  setup() {
    const forms = ref([]);

    const columns = [
      { key: 'formId', title: '表单ID' },
      { key: 'formType', title: '表单类型' },
      { key: 'submitUser', title: '提交人' },
      { key: 'currentStatus', title: '当前状态' },
    ];

    const fetchForms = async () => {
      const response = await getAllFormData();
      forms.value = response.data;
    };

    fetchForms();

    return {
      forms,
      columns,
    };
  },
};
</script>

<style scoped>
.form-list {
  padding: 20px;
}
</style>