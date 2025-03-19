<template>
  <div class="user-management">
    <h1>用户管理</h1>
    <Button type="primary" @click="showCreateModal">创建用户</Button>
    <Table :columns="columns" :data="users" />
    <Modal
      v-if="isCreateModalVisible"
      title="创建用户"
      @close="hideCreateModal"
      @confirm="createUser"
    >
      <Form :fields="formFields" v-model:formData="newUser" />
    </Modal>
  </div>
</template>

<script>
import { ref } from 'vue';
import { getAllUsers, createUser } from '@/api/user';
import Button from '@/components/Button.vue';
import Table from '@/components/Table.vue';
import Modal from '@/components/Modal.vue';
import Form from '@/components/Form.vue';

export default {
  name: 'UserManagement',
  components: { Button, Table, Modal, Form },
  setup() {
    const users = ref([]);
    const isCreateModalVisible = ref(false);
    const newUser = ref({
      username: '',
      password: '',
      email: '',
      status: 1,
    });

    const columns = [
      { key: 'userId', title: '用户ID' },
      { key: 'username', title: '用户名' },
      { key: 'email', title: '邮箱' },
      { key: 'status', title: '状态' },
    ];

    const formFields = [
      { name: 'username', label: '用户名', type: 'text' },
      { name: 'password', label: '密码', type: 'password' },
      { name: 'email', label: '邮箱', type: 'text' },
      { name: 'status', label: '状态', type: 'select', options: [
        { value: 1, label: '启用' },
        { value: 0, label: '禁用' },
      ]},
    ];

    const fetchUsers = async () => {
      const response = await getAllUsers();
      users.value = response.data;
    };

    const showCreateModal = () => {
      isCreateModalVisible.value = true;
    };

    const hideCreateModal = () => {
      isCreateModalVisible.value = false;
    };

    const createUser = async () => {
      await createUser(newUser.value);
      hideCreateModal();
      fetchUsers();
    };

    fetchUsers();

    return {
      users,
      columns,
      isCreateModalVisible,
      newUser,
      formFields,
      showCreateModal,
      hideCreateModal,
      createUser,
    };
  },
};
</script>

<style scoped>
.user-management {
  padding: 20px;
}
</style>