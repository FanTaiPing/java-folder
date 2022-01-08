import Cookies from 'js-cookie'

const TokenKey = 'loginToken'
const UserInfo = 'userInfo'

export function getToken() {
  return Cookies.get(TokenKey)
}

export function setToken(token) {
  return Cookies.set(TokenKey, token)
}

export function setUserInfo(token) {
  return Cookies.set(UserInfo, token)
}

export function setUserId(token) {
  return Cookies.set("userId", token)
}

export function getUserId() {
  return Cookies.get("userId")
}

export function getUserInfo() {
  return Cookies.get()
}

export function removeToken() {
  return Cookies.remove(TokenKey)
}

export function get(key) {
  return Cookies.get(key)
}

export function set(key,value) {
  return Cookies.set(key, value)
}

export function remove(key) {
  return Cookies.remove(key)
}

 
