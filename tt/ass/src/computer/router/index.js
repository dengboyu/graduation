import Vue from 'vue'
import Router from 'vue-router'
import page404 from '@/computer/components/public/page404'  //404页面
import example from '@/computer/components/example'         //示例
import login from '@/computer/components/login/login'         //登录页
import register from '@/computer/components/login/register'         //登录页
import index from '@/computer/components/index/index'         //首页
import link from '@/computer/components/index/link'         //首页
import addCompany from '@/computer/components/company/addCompany'         //添加公司
import queryCompany from '@/computer/components/company/queryCompany'         //添加公司
import product from '@/computer/components/product/product'         //添加公司
import editProduct from '@/computer/components/product/editProduct'         //添加公司
import addProduct from '@/computer/components/product/addProduct'         //添加公司
import sortProduct from '@/computer/components/product/sortProduct'         //添加公司
import queryRemark from '@/computer/components/product/queryRemark'         //添加公司
import addCustomer from '@/computer/components/customer/addCustomer'         //添加公司
import updateCustomer from '@/computer/components/customer/updateCustomer'         //添加公司
import updateCompany from '@/computer/components/company/updateCompany'         //添加公司
import linkName from '@/computer/components/customer/linkName'         //添加公司
import addQuotation from '@/computer/components/quotation/addQuotation'         //添加公司
import queryQuotation from '@/computer/components/quotation/queryQuotation'         //添加公司
import detailQuotation from '@/computer/components/quotation/detailQuotation'         //添加公司


Vue.use(Router)

export default new Router({
    mode: 'history',
    base:'/',
    //初始路由
    routes: [
        {name: 'login',path: '/login',component: login},   //登录页
        {name: 'root',path: '/',redirect: '/login'},   //访问根实例,不加任何其他路由
        {
            name: 'index',
            path: '/index',
            component: index,
            children:[
                {
                    //首页默认路由
                    path: "/",
                    redirect: "queryQuotation"
                },
                {
                    name:'addCompany',
                    path:'addCompany',
                    component:addCompany,
                },
                {
                    name:'queryCompany',
                    path:'queryCompany',
                    component:queryCompany,
                },
                {
                    name:'link',
                    path:'link',
                    component:link,
                },
                {
                    name:'product',
                    path:'product',
                    component:product,
                },
                {
                    name:'addCustomer',
                    path:'addCustomer',
                    component:addCustomer,
                },
                {
                    name:'updateCustomer',
                    path:'updateCustomer/:id',
                    component:updateCustomer,
                },
                {
                    name:'updateCompany',
                    path:'updateCompany/:id',
                    component:updateCompany,
                },
                {
                    name:'editProduct',
                    path:'editProduct/:id',
                    component:editProduct,
                },
                {
                    name:'linkName',
                    path:'linkName',
                    component:linkName,
                },
                {
                    name:'addQuotation',
                    path:'addQuotation',
                    component:addQuotation,
                },
                {
                    name:'queryQuotation',
                    path:'queryQuotation',
                    component:queryQuotation,
                },
                {
                    name:'addProduct',
                    path:'addProduct',
                    component:addProduct,
                },
                {
                    name:'sortProduct',
                    path:'sortProduct',
                    component:sortProduct,
                },
                {
                    name:'queryRemark',
                    path:'queryRemark',
                    component:queryRemark,
                },
                {
                    name:'detailQuotation',
                    path:'detailQuotation',
                    component:detailQuotation,
                },
            ]
        },   //首页
        {name: 'register',path: '/register',component: register},   //首页
        {name: 'page404',path: '/page404',component: page404},         //404页面
        {name: 'error',path: '*',redirect: '/page404'},         //匹配不到页面时跳转404页面
        {name: 'example',path: '/components/example',component: example},   //示例
    ]
})
