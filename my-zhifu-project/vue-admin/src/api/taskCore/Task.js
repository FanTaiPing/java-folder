import request from '@/utils/request'

export function addTaskBill(data) {
  return request({
    url:'/taskCore/addTaskBill',
    method:'post',
    data:data
  })
}
export function updateTaskBill(id,data) {
  return request({
    url:'/sys/sysUser/update/'+id,
    method:'post',
    data:data
  })
}
export function deleteTaskBill(id) {
  return request({
    url:'/sys/sysUser/communityUser/'+id,
    method:'get'
  })
}

//  代办事项
export function findTask(id,data) {
  return request({
    url:'/sys/sysUser/communityUser/'+id,
    method:'get'
  })
}

// 未完成的事项
export function findUndoTask(id,data) {
  return request({
    url:'/sys/sysUser/communityUser/'+id,
    method:'get'
  })
}

// 已完成的事项
export function findDoneTask(id,data) {
  return request({
    url:'/sys/sysUser/communityUser/'+id,
    method:'get'
  })
}




