//导入vue 这个包，得到vue构造函数
import Vue from 'vue'

import 'normalize.css/normalize.css'// A modern alternative to CSS resets

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import locale from 'element-ui/lib/locale/lang/zh-CN' // lang i18n
import VCharts from 'v-charts'

import '@/styles/index.scss' // global css

import App from './App'
import router from './router'
import store from './store'

import '@/icons' // icon
import '@/permission' // permission control
import '@/components/templatePage/static/common/common.less'


Vue.use(ElementUI, { locale })
import('element-ui/lib/theme-chalk/index.css')
Vue.use(VCharts)

Vue.config.productionTip = false

//创建vue的实例对象
new Vue({
  el: '#app',
  router,
  store,
  template: '<App/>',
  components: { App }
})
