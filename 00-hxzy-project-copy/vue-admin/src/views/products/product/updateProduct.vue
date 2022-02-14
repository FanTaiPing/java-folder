<template>
    <productDetail :isEdit='true'></productDetail>
</template>

<script>
  import productDetail from './components/productDetail'
  export default {
    name: 'updateProduct',
    components: {
      productDetail
    },
  }

</script>
