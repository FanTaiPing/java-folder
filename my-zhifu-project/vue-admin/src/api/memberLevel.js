import request from '@/utils/request'
export function fetchList(params) {
    return request({
        url:'/ums/UmsMemberLevel/list',
        method:'get',
        params:params
    })
}
export function createMemberLevel(data) {
    return request({
        url:'/ums/UmsMemberLevel/create',
        method:'post',
        data:data
    })
}

export function deleteMemberLevel(id) {
    return request({
        url:'/ums/UmsMemberLevel/delete/'+id,
        method:'get',
    })
}

export function getMemberLevel(id) {
    return request({
        url:'/ums/UmsMemberLevel/'+id,
        method:'get',
    })
}

export function updateMemberLevel(id,data) {
    return request({
        url:'/ums/UmsMemberLevel/update/'+id,
        method:'post',
        data:data
    })
}

