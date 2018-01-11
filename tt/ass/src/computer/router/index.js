import Vue from 'vue'
import Router from 'vue-router'
import page404 from '@/computer/components/public/page404'  //404页面
import example from '@/computer/components/example'         //示例
import login from '@/computer/components/login/login'         //登录页
import index from '@/computer/components/index/index'         //首页


Vue.use(Router)

export default new Router({
    mode: 'history',
    base:'/',
    //初始路由
    routes: [
        {name: 'login',path: '/login',component: login},   //登录页
        {name: 'root',path: '/',redirect: '/login'},   //访问根实例,不加任何其他路由
        {name: 'index',path: '/index',component: index},   //首页
        {name: 'page404',path: '/page404',component: page404},         //404页面
        {name: 'error',path: '*',redirect: '/page404'},         //匹配不到页面时跳转404页面
        {name: 'example',path: '/components/example',component: example},   //示例
    ]
})
