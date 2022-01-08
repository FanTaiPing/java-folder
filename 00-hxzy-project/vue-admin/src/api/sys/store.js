import request from '@/utils/request'
export function fetchList(params) {
    return request({
        url:'/sys/sysStore/list',
        method:'get',
        params:params
    })
}

export function setStoreId(id) {
    return request({
        url:'/sys/sysStore/setStoreId/'+id,
        method:'get',
    })
}
export function createStore(data) {
    return request({
        url:'/sys/sysStore/create',
        method:'post',
        data:data
    })
}

export function deleteStore(id) {
    return request({
        url:'/sys/sysStore/delete/'+id,
        method:'get',
    })
}

export function getStore(id) {
    return request({
        url:'/sys/sysStore/'+id,
        method:'get',
    })
}

export function updateStore(id,data) {
    return request({
        url:'/sys/sysStore/update/'+id,
        method:'post',
        data:data
    })
}

export function listBakCate(params) {
    return request({
        url:'/sys/sysStore/listBakCate',
        method:'get',
        params:params
    })
}
