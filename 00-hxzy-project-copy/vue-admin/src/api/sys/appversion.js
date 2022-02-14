import request from '@/utils/request'
export function fetchList(params) {
  return request({
    url:'/sys/appVersion/list',
    method:'get',
    params:params
  })
}


