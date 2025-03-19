<template>
  <div class="form-detail">
    <h1>表单详情</h1>
    <Card>
      <template #header>表单信息</template>
      <div>
        <p>表单ID: {{ formData.formId }}</p>
        <p>表单类型: {{ formData.formType }}</p>
        <p>提交人: {{ formData.submitUser }}</p>
        <p>当前状态: {{ formData.currentStatus }}</p>
        <p>创建时间: {{ formData.createTime }}</p>
      </div>
    </Card>
    <Card>
      <template #header>表单数据</template>
      <pre>{{ formData.formData }}</pre>
    </Card>
  </div>
</template>

<script>
import { ref } from 'vue';
import { getFormDataById } from '@/api/formData';
import Card from '@/components/Card.vue';

export default {
  name: 'FormDetail',
  components: { Card },
  setup() {
    const formData = ref({});

    const fetchFormData = async () => {
      const formId = this.$route.params.formId;
      const response = await getFormDataById(formId);
      formData.value = response.data;
    };

    fetchFormData();

    return {
      formData,
    };
  },
};
</script>

<style scoped>
.form-detail {
  padding: 20px;
}

pre {
  background-color: #f5f5f5;
  padding: 10px;
  border-radius: 5px;
}
</style>