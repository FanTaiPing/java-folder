import request from '@/utils/request'
export function fetchList(params) {
  return request({
    url:'/sys/sysUser/list',
    method:'get',
    params:params
  })
}
// 查询所有用户
export function findAllSysUser(params) { 
  return request({
    url:'/sys/sysUser/findAllSysUser',
    method:'get',
    params:params
  })
}
export function userRoles(params,adminId) {
  return request({
    url:'/sys/sysUser/role/'+adminId,
    method:'get',
    params:params
  })
}
export function userRoleCheck(params) {
  return request({
    url:'/sys/sysUser/userRoleCheck',
    method:'get',
    params:params
  })
}
export function createAdmin(data) {
  return request({
    url:'/sys/sysUser/register',
    method:'post',
    data:data
  })
}
//添加用户
export function addUser(data) {
  return request({
    url:'/sys/sysUser/insertUser',
    method:'post',
    data:data
  })
}
export function updateShowStatus(data) {
  return request({
    url:'/sys/sysUser/update/updateShowStatus',
    method:'post',
    data:data
  })
}

export function updateFactoryStatus(data) {
  return request({
    url:'/sys/sysUser/update/factoryStatus',
    method:'post',
    data:data
  })
}
export function deleteAdmin(id) {
  return request({
    url:'/sys/sysUser/deleteAdmin/'+id,
    method:'get',
  })
}
export function deleteUser(id) {
  return request({
    url:'/sys/sysUser/deleteUser?id='+id,
    method:'get',
  })
}

export function getAdmin(id) {
  return request({
    url:'/sys/sysUser/'+id,
    method:'get',
  })
}

export function updatePassword(data) {
  return request({
    url:'/sys/sysUser/updatePassword',
    method:'post',
    data:data
  })
}
export function updateAdmin(id,data) {
  return request({
    url:'/sys/sysUser/update/'+id,
    method:'post',
    data:data
  })
}

export function communityList(id) {
  return request({
    url:'/sys/sysUser/community/'+id,
    method:'get'
  })
}

export function communityUser(id) {
  return request({
    url:'/sys/sysUser/communityUser/'+id,
    method:'get'
  })
}
export function userCommunityRelate(data) {
  return request({
    url:'/sys/sysUser/userCommunityRelate',
    method:'post',
    data:data
  })
}
