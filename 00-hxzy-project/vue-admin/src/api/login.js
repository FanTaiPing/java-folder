import request from '@/utils/request'

export function login(username, password) {
  return request({
    url: '/sys/sysUser/login',
    method: 'post',
    data: {
      username,
      password
    }
  })
}

export function getInfo() {
  return request({
    url: '/sys/sysUser/info',
    method: 'get',
  })
}

export function logout() {
  return request({
    url: '/sys/sysUser/logout',
    method: 'post'
  })
}
