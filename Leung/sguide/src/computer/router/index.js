import Vue from 'vue'
import Router from 'vue-router'
import page404 from '@/computer/components/public/page404'  //404页面
import example from '@/computer/components/example'         //示例
import login from '@/computer/components/login/login'         //登录页
import register from '@/computer/components/login/register'         //登录页
import index from '@/computer/components/index/index'         //首页
import detail from '@/computer/components/product/detail'         //首页
import queryProduct from '@/computer/components/product/queryProduct'         //首页
import orderList from '@/computer/components/product/orderList'         //首页
import shopCar from '@/computer/components/product/shopCar'         //首页
import company from '@/computer/components/login/company'         //首页
import addPerson from '@/computer/components/company/addPerson'         //首页
import person from '@/computer/components/login/person'         //首页
import addProduct from '@/computer/components/company/addProduct'         //首页
import queryCompany from '@/computer/components/company/queryCompany'         //首页


Vue.use(Router)

export default new Router({
    mode: 'history',
    base:'/',
    //初始路由
    routes: [
        {name: 'login',path: '/login/:loginFlag',component: login},   //登录页
        {name: 'root',path: '/',redirect: '/index'},   //访问根实例,不加任何其他路由
        {
            name: 'index',
            path: '/index',
            component: index,
            children:[
                {
                    path: '/',
                    component: queryProduct
                },
                {
                    name:'queryProduct',
                    path: 'queryProduct',
                    component: queryProduct
                },
                {
                    name: 'detail',
                    path: 'detail/:id',
                    component: detail,
                },
                {
                    name: 'orderList',
                    path: 'orderList',
                    component: orderList,
                },
                {
                    name: 'shopCar',
                    path: 'shopCar',
                    component: shopCar,
                },
            ]
        },   //首页
        {name: 'register',path: '/register',component: register},
        {
            name: 'company',
            path: '/company',
            component: company,
            children:[
                {
                    name:'addProduct',
                    path: 'addProduct',
                    component: addProduct,
                },
                {
                    name:'queryCompany',
                    path: 'queryCompany',
                    component: queryCompany,
                },
            ]
        },
        {
            name: 'person',
            path: '/person',
            component: person,
            children:[
                {
                    name:'addPerson',
                    path: 'addPerson',
                    component: addPerson,
                },
            ]
        },
        {name: 'page404',path: '/page404',component: page404},         //404页面
        {name: 'error',path: '*',redirect: '/page404'},         //匹配不到页面时跳转404页面
        {name: 'example',path: '/components/example',component: example},   //示例
    ]
})
