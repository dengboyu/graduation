import Vue from 'vue'
import Router from 'vue-router'
import page404 from '@/computer/components/public/page404'  //404页面
import example from '@/computer/components/example'         //示例
import loginTop from '@/computer/components/login/loginTop'         //登录页
import login from '@/computer/components/login/login'         //登录页
import admin from '@/computer/components/index/admin'         //登录页
import register from '@/computer/components/login/register'         //登录页
import resetPas from '@/computer/components/login/resetPas'         //登录页
import index from '@/computer/components/index/index'         //首页
import update from '@/computer/components/person/update'         //首页
import college from '@/computer/components/person/college'         //首页
import query from '@/computer/components/person/query'         //首页
import shetuan from '@/computer/components/person/shetuan'         //首页
import addFriend from '@/computer/components/friend/addFriend'         //首页
import addSysFriend from '@/computer/components/friend/addSysFriend'         //首页
import hasFriend from '@/computer/components/friend/hasFriend'         //首页
import friendGroup from '@/computer/components/friend/friendGroup'         //首页
import actList from '@/computer/components/act/actList'         //首页
import shopList from '@/computer/components/act/shopList'         //首页
import actDetail from '@/computer/components/act/actDetail'         //首页
import actFriend from '@/computer/components/act/actFriend'         //首页
import adminAct from '@/computer/components/act/adminAct'         //首页
import addAct from '@/computer/components/act/addAct'         //首页
import adminActDetail from '@/computer/components/act/adminActDetail'         //首页


Vue.use(Router)

export default new Router({
    mode: 'history',
    base:'/',
    //初始路由
    routes: [
        {
            name: 'loginTop',
            path: '/loginTop',
            component: loginTop,
            children:[
                {
                    path: '/',
                    component: login
                },
                {
                    name:'register',
                    path: 'register',
                    component: register
                },
                {
                    name:'resetPas',
                    path: 'resetPas',
                    component: resetPas
                },
            ]
        },   //登录页
        {name: 'register',path: '/register',component: register},   //登录页
        {name: 'root',path: '/',redirect: '/loginTop'},   //访问根实例,不加任何其他路由
        {
            name: 'index',
            path: '/index',
            component: index,
            children:[
                {
                    name:'update',
                    path: 'update',
                    component: update
                },
                {
                    name:'query',
                    path: 'query',
                    component: query
                },
                {
                    name:'addFriend',
                    path: 'addFriend',
                    component: addFriend
                },
                {
                    name:'addSysFriend',
                    path: 'addSysFriend',
                    component: addSysFriend
                },
                {
                    name:'hasFriend',
                    path: 'hasFriend',
                    component: hasFriend
                },
                {
                    name:'friendGroup',
                    path: 'friendGroup',
                    component: friendGroup
                },
                {
                    name:'actList',
                    path: 'actList',
                    component: actList
                },
                {
                    name:'actDetail',
                    path: 'actDetail/:id',
                    component: actDetail
                },
                {
                    name:'shopList',
                    path: 'shopList',
                    component: shopList
                },
                {
                    name:'actFriend',
                    path: 'actFriend',
                    component: actFriend
                },
            ]
        },   //首页
        {
            name: 'admin',
            path: '/admin',
            component: admin,
            children:[
                {
                    name:'adminAct',
                    path: 'adminAct',
                    component: adminAct
                },
                {
                    name:'shetuan',
                    path: 'shetuan',
                    component: shetuan
                },
                {
                    name:'addAct',
                    path: 'addAct',
                    component: addAct
                },
                {
                    name:'college',
                    path: 'college',
                    component: college
                },
                {
                    name:'adminActDetail',
                    path: 'adminActDetail/:id',
                    component: adminActDetail
                },
            ]
        },
        {name: 'page404',path: '/page404',component: page404},         //404页面
        {name: 'error',path: '*',redirect: '/page404'},         //匹配不到页面时跳转404页面
        {name: 'example',path: '/components/example',component: example},   //示例
    ]
})
