<template> 
  <addUserDetail :is-edit='false'></addUserDetail>
</template>
<script>
  import addUserDetail from './components/addUserDetail'
  // import addUserDetial from './components/addUserDetail.vue'
  export default {
    name: 'addUser',
    components: {
      addUserDetail
    }
  }

</script>
<style>
</style>
