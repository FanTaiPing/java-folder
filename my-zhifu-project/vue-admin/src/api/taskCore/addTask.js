import request from '@/utils/request'

export function createAdmin(data) {
  return request({
    url:'/sys/sysUser/register',
    method:'post',
    data:data
  })
}



