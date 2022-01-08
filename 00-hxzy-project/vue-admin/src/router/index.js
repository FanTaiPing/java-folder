import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

import Home from '@/views/home/index'
// import "ant-design-vue/dist/antd.css"


Vue.use(Router)

import Layout from '../views/layout/Layout'

export const constantRouterMap = [
  { path: '/acceptStore', component: () => import('@/views/login/acceptStore'), hidden: true },
  { path: '/login', component: () => import('@/views/login/index'), hidden: true },
  { path: '/404', component: () => import('@/views/404'), hidden: true },
  // {
  //   path: '/',
  //   name: 'HelloWorld',
  //   component: HelloWorld
  // },
  {
    path: '/',
    component: Layout,
    redirect: '/sys/admin',
    children: [{
      path: 'index',
      name: 'index',
      component: () => import('@/views/home/index'),
      meta: { title: '首页', icon: 'home' }
    }]
  },

  {
    path: '/sys',
    component: Layout,
    // redirect: '/sys/admin',
    name: 'sys',
    meta: { title: '系统管理', icon: 'home' },
    children: [
      {
        path: 'admin',
        name: 'admin',
        component: () => import('@/views/sys/admin/index'),
        meta: { title: '用户列表', icon: 'product-list' }
      },
      {
        path: 'userCommunity',
        name: 'userCommunity',
        component: () => import('@/views/sys/admin/userCommunity'),
        meta: { title: '绑定', icon: 'product-list' }
      },
      {
        path: 'addAdmin',
        name: 'addAdmin',
        component: () => import('@/views/sys/admin/add'),
        meta: { title: '添加用户' },
        hidden: true
      },
      {
        path: 'updateAdmin',
        name: 'updateAdmin',
        component: () => import('@/views/sys/admin/update'),
        meta: { title: '编辑用户' },
        hidden: true
      },
      {
        path: 'permissionCategory',
        name: 'permissionCategory',
        component: () => import('@/views/sys/permissionCategory/index'),
        meta: { title: '菜单类别列表}' }
      },
      {
        path: 'addPermissionCategory',
        name: 'addPermissionCategory',
        component: () => import('@/views/sys/permissionCategory/add'),
        meta: { title: '添加菜单类别', icon: 'permissionCategory-add' },
        hidden: true
      },
      {
        path: 'updatePermissionCategory',
        name: 'updatePermissionCategory',
        component: () => import('@/views/sys/permissionCategory/update'),
        meta: { title: '修改菜单类别', icon: 'permissionCategory-update' },
        hidden: true
      },
      {
        path: 'permission',
        name: 'permission',
        component: () => import('@/views/sys/permission/index'),
        meta: { title: '权限列表', icon: 'product-list' }
      },
      {
        path: 'addPermission',
        name: 'addPermission',
        component: () => import('@/views/sys/permission/add'),
        meta: { title: '添加权限' },
        hidden: true
      },
      {
        path: 'updatePermission',
        name: 'updatePermission',
        component: () => import('@/views/sys/permission/update'),
        meta: { title: '编辑权限' },
        hidden: true
      },
      {
        path: 'role',
        name: 'role',
        component: () => import('@/views/sys/role/index'),
        meta: {
          title: '角色列表',
          icon: 'product-list'
        }
      },
      {
        path: 'addRole',
        name: 'addRole',
        component: () => import('@/views/sys/role/add'),
        meta: {
          title: '添加角色'
        },
        hidden: true
      },
      {
        path: 'updateRole',
        name: 'updateRole',
        component: () => import('@/views/sys/role/update'),
        meta: {
          title: '编辑角色'
        },
        hidden: true
      },


      {
        path: 'sysOrg',
        name: 'sysOrg',
        component: () => import('@/views/sys/sysOrg/index'),
        meta: { title: '管理列表', icon: 'product-list' }
      },

      {
        path: 'addSysOrg',
        name: 'addSysOrg',
        component: () => import('@/views/sys/sysOrg/add'),
        meta: { title: '添加管理' },
        hidden: true
      },
      {
        path: 'updateSysOrg',
        name: 'updateSysOrg',
        component: () => import('@/views/sys/sysOrg/update'),
        meta: { title: '编辑管理' },
        hidden: true
      },

      // {
      //   path: 'appversion',
      //   name: 'appversion',
      //   component: () => import('@/views/sys/version/index'),
      //   meta: {title: '版本管理列表', icon: 'product-list'}
      // },

    ]
  },

  {
    path: '/taskCore',
    component: Layout,
    redirect: '/taskCore/index',
    name: 'taskCore',
    meta: { title: '任务中心', icon: 'home' },
    children: [
      {
        path: 'index',
        name: 'index',
        component: () => import('@/views/activiti/creatTask/index'),
        meta: { title: '任务中心', icon: 'product-list' }
      },
      {
        path: 'addTaskBill',
        name: 'addTaskBill',
        component: () => import('@/views/activiti/creatTask/add'),
        meta: { title: '添加任务', icon: 'product-list' }
      },
      {
        path: 'findTask',
        name: 'findTask',
        component: () => import('@/views/activiti/creatTask/add'),
        meta: { title: '添加任务', icon: 'product-list' }
      },
      {
        path: 'findUndoTask',
        name: 'findUndoTask',
        component: () => import('@/views/activiti/creatTask/add'),
        meta: { title: '添加任务', icon: 'product-list' }
      },
      {
        path: 'findDoneTask',
        name: 'findDoneTask',
        component: () => import('@/views/activiti/creatTask/add'),
        meta: { title: '添加任务', icon: 'product-list' }
      },
    ]

  },

  {
    path: '/example',
    component: Layout,
    // redirect: '/sys/admin',
    name: 'example',
    meta: { title: '示例', icon: 'home' },
    children: [
      {
        path: 'demo',
        name: 'demo',
        component: () => import('@/views/example/demo/index'),
        meta: { title: 'table', icon: 'product-list' }
      },
      {
        path: 'addUser',
        name: 'addUser',
        component: () => import('@/views/example/demo/addUsers'),
        meta: { title: '添加用户' },
        // hidden: true
      },
    ]

  },
  // {
  //   path: '/app',
  //   component: Layout,
  //   redirect: '/app/appversion',
  //   name: 'app',
  //   meta: {title: 'APP管理', icon: 'home'},
  //   children: [{
  //       path: 'appversion',
  //       name: 'appversion',
  //       component: () => import('@/views/app/version/index'),
  //       meta: {title: '版本管理列表', icon: 'product-list'}

  //   },
  //   {
  //     path: 'addVersion',
  //     name: 'addVersion',
  //     component: () => import('@/views/app/version/add'),
  //     meta: {title: '添加新版本'},
  //     hidden: true
  //   }
  // ]
  // }

]



export const asyncRouterMap = [
  {
    path: '/pms',
    component: Layout,
    redirect: '/pms/product',
    name: 'pms',
    meta: { title: '商品', icon: 'product' },
  },

  { path: '*', redirect: '/404', hidden: true }
]


export default new Router({
  // mode: 'history', //后端支持可开
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRouterMap
})
