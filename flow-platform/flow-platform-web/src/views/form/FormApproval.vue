<template>
  <div class="form-approval">
    <h1>表单审批</h1>
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
      <template #header>审批操作</template>
      <div>
        <Button type="primary" @click="approveForm">通过</Button>
        <Button type="danger" @click="rejectForm">拒绝</Button>
      </div>
    </Card>
  </div>
</template>

<script>
import { ref } from 'vue';
import { getFormDataById, approveForm, rejectForm } from '@/api/formData';
import Button from '@/components/Button.vue';
import Card from '@/components/Card.vue';

export default {
  name: 'FormApproval',
  components: { Button, Card },
  setup() {
    const formData = ref({});

    const fetchFormData = async () => {
      const formId = this.$route.params.formId;
      const response = await getFormDataById(formId);
      formData.value = response.data;
    };

    const approveForm = async () => {
      await approveForm(formData.value.formId);
      alert('审批通过');
      fetchFormData();
    };

    const rejectForm = async () => {
      await rejectForm(formData.value.formId);
      alert('审批拒绝');
      fetchFormData();
    };

    fetchFormData();

    return {
      formData,
      approveForm,
      rejectForm,
    };
  },
};
</script>

<style scoped>
.form-approval {
  padding: 20px;
}
</style>