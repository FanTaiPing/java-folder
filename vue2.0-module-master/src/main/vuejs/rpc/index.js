import axios from 'axios'
import Vuex from 'vuex'
// import store from '@/vuex/store'

let base='/autoops/API'
//let base=''
export default{
  getAsset: (url, params) => {
    return axios.get(url,{ params: params })
  },
  get : (url, params) => {
    return axios.get(base+url,{ params: params })
  },
  post : (url, params,transformResponse) => {
    var userData = JSON.parse(window.sessionStorage.getItem('access-user'))
    if (userData == null || userData.user==null){
      params.currentUser='ls'
      params.userID = 0
    }
    else {
      params.currentUser = userData.user.uuid
      params.userID = userData.user.userid
    }
    params.currentUser='zs'
    // alert(params.currentUser)
    var trans = axios.defaults.transformResponse;
    trans = (typeof(transformResponse) == 'function') ? trans.concat(transformResponse):trans
    return axios.post(base+url, params, {transformResponse:trans})
  },
  transformResponse: (data)=>{
    console.log(data)
    return data
  },

  accessControl: {

    routes:null

  },
  pre_base: base

}
