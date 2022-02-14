import request from '@/utils/request'
export function fetchList(params) {
return request({
url: '/app/appMenuModule/list',
method: 'get',
params: params
})
}
export function appMenuList(params) {
return request({
url: '/app/appMenuModule/appMenuList',
method: 'get',
params: params
})
}
export function createAppMenuModule(data) {
return request({
url: '/app/appMenuModule/create',
method: 'post',
data: data
})
}

export function deleteAppMenuModule(id) {
return request({
url: '/app/appMenuModule/delete/' + id,
method: 'get',
})
}

export function getAppMenuModule(id) {
return request({
url: '/app/appMenuModule/' + id,
method: 'get',
})
}

export function updateAppMenuModule(id, data) {
return request({
url: '/app/appMenuModule/update/' + id,
method: 'post',
data: data
})
}

