<template> 
  <admin-detail :is-edit='false'></admin-detail>
</template>
<script>
  import AdminDetail from './components/AdminDetail'
  export default {
    name: 'addAdmin',
    components: { AdminDetail }
  }
</script>
<style>
</style>
<div class="app-container">
 <div>
      <i class="el-icon-search"></i>
      <span>add</span>
</div>


