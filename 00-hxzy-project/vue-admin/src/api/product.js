import request from '@/utils/request'
export function findAllProduct(selectName) {
  return request({
    url: '/products/product/productList/' + selectName,
    method: 'get',
    params: selectName
  })
}
//添加商品信息
export function addProduct(data) {
  return request({
    url: '/products/product/insertProduct',
    method: 'post',
    data: data
  })
}
//根据id查询商品信息
export function getProductById(id) {
  return request({
    url: 'products/product/getProductById?id=' + id,
    method: 'get',
    params: id
  })
}
//修改商品信息
export function updateProduct(id, data) {
  return request({
    url: 'products/product/updateProduct?id=' + id,
    method: 'post',
    data: data
  })
}

//删除商品信息
export function deleteProductById(id) {
  return request({
    url: '/products/product/deleteProductById?id=' + id,
    method: 'get',
  })
}