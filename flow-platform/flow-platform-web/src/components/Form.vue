<template>
  <form @submit.prevent="onSubmit">
    <div class="form-group" v-for="(field, index) in fields" :key="index">
      <label :for="field.name">{{ field.label }}</label>
      <input
        v-if="field.type === 'text' || field.type === 'password'"
        :type="field.type"
        :id="field.name"
        v-model="formData[field.name]"
        :placeholder="field.placeholder"
      />
      <select v-else-if="field.type === 'select'" :id="field.name" v-model="formData[field.name]">
        <option v-for="option in field.options" :key="option.value" :value="option.value">
          {{ option.label }}
        </option>
      </select>
    </div>
    <Button type="primary" @click="onSubmit">提交</Button>
  </form>
</template>

<script>
import Button from './Button.vue';

export default {
  name: 'Form',
  components: { Button },
  props: {
    fields: {
      type: Array,
      required: true,
    },
  },
  data() {
    return {
      formData: {},
    };
  },
  methods: {
    onSubmit() {
      this.$emit('submit', this.formData);
    },
  },
};
</script>

<style scoped>
.form-group {
  margin-bottom: 15px;
}

.form-group label {
  display: block;
  margin-bottom: 5px;
  font-weight: bold;
}

.form-group input,
.form-group select {
  width: 100%;
  padding: 10px;
  font-size: 16px;
  border: 1px solid #ccc;
  border-radius: 5px;
}
</style>