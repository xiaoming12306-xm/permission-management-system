<template>
  <div class="role-management">
    <h1>角色管理</h1>
    <Button type="primary" @click="showCreateModal">创建角色</Button>
    <Table :columns="columns" :data="roles" />
    <Modal
      v-if="isCreateModalVisible"
      title="创建角色"
      @close="hideCreateModal"
      @confirm="createRole"
    >
      <Form :fields="formFields" v-model:formData="newRole" />
    </Modal>
  </div>
</template>

<script>
import { ref } from 'vue';
import { getAllRoles, createRole } from '@/api/role';
import Button from '@/components/Button.vue';
import Table from '@/components/Table.vue';
import Modal from '@/components/Modal.vue';
import Form from '@/components/Form.vue';

export default {
  name: 'RoleManagement',
  components: { Button, Table, Modal, Form },
  setup() {
    const roles = ref([]);
    const isCreateModalVisible = ref(false);
    const newRole = ref({
      roleName: '',
      roleKey: '',
      dataScope: 1,
    });

    const columns = [
      { key: 'roleId', title: '角色ID' },
      { key: 'roleName', title: '角色名称' },
      { key: 'roleKey', title: '角色标识' },
      { key: 'dataScope', title: '数据范围' },
    ];

    const formFields = [
      { name: 'roleName', label: '角色名称', type: 'text' },
      { name: 'roleKey', label: '角色标识', type: 'text' },
      { name: 'dataScope', label: '数据范围', type: 'select', options: [
        { value: 1, label: '全部数据' },
        { value: 2, label: '自定义数据' },
      ]},
    ];

    const fetchRoles = async () => {
      const response = await getAllRoles();
      roles.value = response.data;
    };

    const showCreateModal = () => {
      isCreateModalVisible.value = true;
    };

    const hideCreateModal = () => {
      isCreateModalVisible.value = false;
    };

    const createRole = async () => {
      await createRole(newRole.value);
      hideCreateModal();
      fetchRoles();
    };

    fetchRoles();

    return {
      roles,
      columns,
      isCreateModalVisible,
      newRole,
      formFields,
      showCreateModal,
      hideCreateModal,
      createRole,
    };
  },
};
</script>

<style scoped>
.role-management {
  padding: 20px;
}
</style>