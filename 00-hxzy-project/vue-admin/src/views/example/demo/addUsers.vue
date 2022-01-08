<template> 
  <addUser-detail :is-edit='false'></addUser-detail>
</template>
<script>
  import addUserDetail from './components/addUserDetail'
  export default {
    name: 'addUser',
    components: {
      addUserDetail
    }
  }

</script>
<style>
</style>
