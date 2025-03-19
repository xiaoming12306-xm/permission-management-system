<template>
  <div class="permission-management">
    <h1>权限管理</h1>
    <Button type="primary" @click="showCreateModal">创建权限</Button>
    <Table :columns="columns" :data="permissions" />
    <Modal
      v-if="isCreateModalVisible"
      title="创建权限"
      @close="hideCreateModal"
      @confirm="createPermission"
    >
      <Form :fields="formFields" v-model:formData="newPermission" />
    </Modal>
  </div>
</template>

<script>
import { ref } from 'vue';
import { getAllPermissions, createPermission } from '@/api/permission';
import Button from '@/components/Button.vue';
import Table from '@/components/Table.vue';
import Modal from '@/components/Modal.vue';
import Form from '@/components/Form.vue';

export default {
  name: 'PermissionManagement',
  components: { Button, Table, Modal, Form },
  setup() {
    const permissions = ref([]);
    const isCreateModalVisible = ref(false);
    const newPermission = ref({
      permName: '',
      permKey: '',
    });

    const columns = [
      { key: 'permId', title: '权限ID' },
      { key: 'permName', title: '权限名称' },
      { key: 'permKey', title: '权限标识' },
    ];

    const formFields = [
      { name: 'permName', label: '权限名称', type: 'text' },
      { name: 'permKey', label: '权限标识', type: 'text' },
    ];

    const fetchPermissions = async () => {
      const response = await getAllPermissions();
      permissions.value = response.data;
    };

    const showCreateModal = () => {
      isCreateModalVisible.value = true;
    };

    const hideCreateModal = () => {
      isCreateModalVisible.value = false;
    };

    const createPermission = async () => {
      await createPermission(newPermission.value);
      hideCreateModal();
      fetchPermissions();
    };

    fetchPermissions();

    return {
      permissions,
      columns,
      isCreateModalVisible,
      newPermission,
      formFields,
      showCreateModal,
      hideCreateModal,
      createPermission,
    };
  },
};
</script>

<style scoped>
.permission-management {
  padding: 20px;
}
</style>