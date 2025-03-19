<template>
  <table class="table">
    <thead>
      <tr>
        <th v-for="column in columns" :key="column.key">{{ column.title }}</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="(row, index) in data" :key="index">
        <td v-for="column in columns" :key="column.key">{{ row[column.key] }}</td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  name: 'Table',
  props: {
    columns: {
      type: Array,
      required: true,
    },
    data: {
      type: Array,
      required: true,
    },
  },
};
</script>

<style scoped>
.table {
  width: 100%;
  border-collapse: collapse;
  margin-bottom: 20px;
}

.table th,
.table td {
  padding: 10px;
  border: 1px solid #ccc;
  text-align: left;
}

.table th {
  background-color: #f8f9fa;
  font-weight: bold;
}
</style>