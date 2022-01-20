import request from '@/utils/request'



export function geTest() {
  return request({
    url: 'api/test/index',
    method: 'get'
  })
}
 

export default { geTest }
