import request from '@/utils/request'
export function fetchList(params) {
return request({
url: '/sys/sysOrg/list',
method: 'get',
params: params
})
}
export function createSysOrg(data) {
return request({
url: '/sys/sysOrg/create',
method: 'post',
data: data
})
}

export function deleteSysOrg(id) {
return request({
url: '/sys/sysOrg/delete/' + id,
method: 'get',
})
}

export function getSysOrg(id) {
return request({
url: '/sys/sysOrg/' + id,
method: 'get',
})
}

export function updateSysOrg(id, data) {
return request({
url: '/sys/sysOrg/update/' + id,
method: 'post',
data: data
})
}

