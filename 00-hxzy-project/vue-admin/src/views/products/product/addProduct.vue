<template> 
  <productDetail :isEdit='false'></productDetail>
</template>
<script>
  import productDetail from './components/productDetail'
  // import addUserDetial from './components/addUserDetail.vue'
  export default {
    name: 'addProduct',
    components: {
      productDetail
    }
  }

</script>
<style>
</style>
