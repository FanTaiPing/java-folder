import Vue from 'vue'
import Router from 'vue-router'
import Layout from '../layout/index'

Vue.use(Router)

export const constantRouterMap = [
  {
    path: '/login',
    meta: { title: '登录', noCache: true },
    component: (resolve) => require(['@/views/login'], resolve),
    hidden: true
  },
  {
    path: '/404',
    component: (resolve) => require(['@/views/features/404'], resolve),
    hidden: true
  },
  {
    path: '/401',
    component: (resolve) => require(['@/views/features/401'], resolve),
    hidden: true
  },
  {
    path: '/redirect',
    component: Layout,
    hidden: true,
    children: [
      {
        path: '/redirect/:path*',
        component: (resolve) => require(['@/views/features/redirect'], resolve)
      }
    ]
  },
  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [
      {
        path: 'dashboard',
        component: (resolve) => require(['@/views/home'], resolve),
        name: 'Dashboard',
        meta: { title: '首页', icon: 'index', affix: true, noCache: true }
      }
    ]
  },
  {
    path: '/user',
    component: Layout,
    hidden: true,
    redirect: 'noredirect',
    children: [
      {
        path: 'center',
        component: (resolve) => require(['@/views/system/user/center'], resolve),
        name: '个人中心',
        meta: { title: '个人中心' }
      }
    ]
  },

  //mydemo
  {
    path: '/mydemo',
    name:'mydemo',
    component: Layout,
    hidden:true,
    redirect: 'noredirect',
    // alwaysShow:true,
    meta: { title: '我的模块',icon:'visits'},
    children: [
      {
        path: 'barChart',
        name: 'barChart',
        component: (resolve) => require(['@/views/mydemo/demoOne/index'], resolve),
        meta: { title: '柱形图表',icon:'chart' }
      },
      {
        path: 'myInterview',
        name: 'myInterview',
        component: (resolve) => require(['@/views/mydemo/demoOne/myInterview'], resolve),
        meta: { title: '我的面试管理',icon:'wechat' }
      },
      // {
      //   path: 'edit',
      //   name: 'edit',
      //   component: (resolve) => require(['@/views/mydemo/demoOne/edit'], resolve),
      //   meta: { title: '编辑页面',icon:'wechat' }
      // },
      {
        path: 'edit',
        name: 'edit',
        components: () => import('@/views/mydemo/demoOne/edit'),
        meta: { title: '编辑页面',icon:'wechat' }
      },
    ]
  }
]

export default new Router({
  // mode: 'hash',
  mode: 'history',
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRouterMap
})
