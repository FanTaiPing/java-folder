import request from '@/utils/request'
export function fetchList(params) {
return request({
url: '/sys/adminDayStatics/list',
method: 'get',
params: params
})
}
export function createAdminDayStatics(data) {
return request({
url: '/sys/adminDayStatics/create',
method: 'post',
data: data
})
}

export function deleteAdminDayStatics(id) {
return request({
url: '/sys/adminDayStatics/delete/' + id,
method: 'get',
})
}

export function getAdminDayStatics(id) {
return request({
url: '/sys/adminDayStatics/' + id,
method: 'get',
})
}

export function updateAdminDayStatics(id, data) {
return request({
url: '/sys/adminDayStatics/update/' + id,
method: 'post',
data: data
})
}

