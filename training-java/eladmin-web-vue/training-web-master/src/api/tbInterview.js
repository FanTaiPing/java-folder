import request from '@/utils/request'

export function add(data) {
  return request({
    url: 'api/tbInterview',
    method: 'post',
    data
  })
}

export function del(ids) {
  return request({
    url: 'api/tbInterview/',
    method: 'delete',
    data: ids
  })
}

export function edit(data) {
  return request({
    url: 'api/tbInterview',
    method: 'put',
    data
  })
}

export default { add, edit, del }
