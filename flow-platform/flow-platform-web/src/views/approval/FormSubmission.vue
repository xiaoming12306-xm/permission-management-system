<template>
  <div class="form-submission">
    <h1>表单提交</h1>
    <Form :fields="formFields" v-model:formData="formData" />
    <Button type="primary" @click="submitForm">提交</Button>
  </div>
</template>

<script>
import { ref } from 'vue';
import { submitForm } from '@/api/formData';
import Button from '@/components/Button.vue';
import Form from '@/components/Form.vue';

export default {
  name: 'FormSubmission',
  components: { Button, Form },
  setup() {
    const formData = ref({
      formType: '',
      formData: '',
    });

    const formFields = [
      { name: 'formType', label: '表单类型', type: 'text' },
      { name: 'formData', label: '表单数据', type: 'textarea' },
    ];

    const submitForm = async () => {
      await submitForm(formData.value);
      alert('表单提交成功');
    };

    return {
      formData,
      formFields,
      submitForm,
    };
  },
};
</script>

<style scoped>
.form-submission {
  padding: 20px;
}
</style>