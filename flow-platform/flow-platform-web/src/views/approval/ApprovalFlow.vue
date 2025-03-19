<template>
  <div class="approval-flow">
    <h1>审批流程管理</h1>
    <Button type="primary" @click="showCreateModal">创建流程</Button>
    <Table :columns="columns" :data="flows" />
    <Modal
      v-if="isCreateModalVisible"
      title="创建审批流程"
      @close="hideCreateModal"
      @confirm="createFlow"
    >
      <Form :fields="formFields" v-model:formData="newFlow" />
    </Modal>
  </div>
</template>

<script>
import { ref } from 'vue';
import { getAllFlows, createFlow } from '@/api/approvalFlow';
import Button from '@/components/Button.vue';
import Table from '@/components/Table.vue';
import Modal from '@/components/Modal.vue';
import Form from '@/components/Form.vue';

export default {
  name: 'ApprovalFlow',
  components: { Button, Table, Modal, Form },
  setup() {
    const flows = ref([]);
    const isCreateModalVisible = ref(false);
    const newFlow = ref({
      formType: '',
      flowName: '',
      configJson: '',
    });

    const columns = [
      { key: 'flowId', title: '流程ID' },
      { key: 'flowName', title: '流程名称' },
      { key: 'formType', title: '表单类型' },
    ];

    const formFields = [
      { name: 'formType', label: '表单类型', type: 'text' },
      { name: 'flowName', label: '流程名称', type: 'text' },
      { name: 'configJson', label: '流程配置', type: 'text' },
    ];

    const fetchFlows = async () => {
      const response = await getAllFlows();
      flows.value = response.data;
    };

    const showCreateModal = () => {
      isCreateModalVisible.value = true;
    };

    const hideCreateModal = () => {
      isCreateModalVisible.value = false;
    };

    const createFlow = async () => {
      await createFlow(newFlow.value);
      hideCreateModal();
      fetchFlows();
    };

    fetchFlows();

    return {
      flows,
      columns,
      isCreateModalVisible,
      newFlow,
      formFields,
      showCreateModal,
      hideCreateModal,
      createFlow,
    };
  },
};
</script>

<style scoped>
.approval-flow {
  padding: 20px;
}
</style>