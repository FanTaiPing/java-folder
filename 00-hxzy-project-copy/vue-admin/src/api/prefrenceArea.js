import request from '@/utils/request'
export function fetchList() {
  return request({
    url:'/cms/CmsPrefrenceArea/list',
    method:'get',
  })
}
