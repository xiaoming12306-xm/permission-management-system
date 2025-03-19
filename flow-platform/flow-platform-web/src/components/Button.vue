<template>
  <button :class="['button', `button-${type}`]" @click="onClick">
    <slot></slot>
  </button>
</template>

<script>
export default {
  name: 'Button',
  props: {
    type: {
      type: String,
      default: 'primary',
      validator: (value) => ['primary', 'secondary', 'success', 'danger', 'warning', 'info'].includes(value),
    },
  },
  methods: {
    onClick() {
      this.$emit('click');
    },
  },
};
</script>

<style scoped>
.button {
  display: inline-block;
  padding: 10px 20px;
  font-size: 16px;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  text-align: center;
}

.button-primary {
  background-color: #007bff;
}

.button-secondary {
  background-color: #6c757d;
}

.button-success {
  background-color: #28a745;
}

.button-danger {
  background-color: #dc3545;
}

.button-warning {
  background-color: #ffc107;
}

.button-info {
  background-color: #17a2b8;
}
</style>