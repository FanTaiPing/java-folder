import request from '@/utils/request'

export function get(id) {
  return request({
    url: '/api/interviewPage/get/' + id,
    method: 'get'
  })
}

export default { get }
