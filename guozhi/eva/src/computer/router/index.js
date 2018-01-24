import Vue from 'vue'
import Router from 'vue-router'
import page404 from '@/computer/components/public/page404'  //404页面
import example from '@/computer/components/example'         //示例
import login from '@/computer/components/login/login'         //登录页
import index from '@/computer/components/index/index'         //首页
import addStudent from '@/computer/components/people/addStudent'    //学生管理页
import infoStudent from '@/computer/components/people/infoStudent'    //学生信息查询
import addTeacher from '@/computer/components/people/addTeacher'    //教师管理页
import infoTeacher from '@/computer/components/people/infoTeacher'    //教师信息查询
import college from '@/computer/components/system/college'    //学院管理页
import addCollege from '@/computer/components/system/addCollege'    //学院管理页
import addPro from '@/computer/components/system/addPro'    //专业管理页
import config from '@/computer/components/system/config'    //系统配置
import studentAccount from '@/computer/components/system/studentAccount'    //学长账户管理
import teacherAccount from '@/computer/components/system/teacherAccount'    //教师账户管理
import comparePro from '@/computer/components/system/comparePro'    //评比项目管理
import questionShow from '@/computer/components/system/questionShow'    //评比项目管理
import addQuestion from '@/computer/components/system/addQuestion'    //评比项目管理
import addCourse from '@/computer/components/course/addCourse'    //添加课程
import editCourse from '@/computer/components/course/editCourse'    //修改课程
import compare from '@/computer/components/course/compare'    //评比结果
import compareResult from '@/computer/components/course/compareResult'    //评比结果组件
import compareStudent from '@/computer/components/course/compareStudent'    //学生评比页面
import evalution from '@/computer/components/course/evalution'    //学生评比页面

Vue.use(Router)

export default new Router({
    mode: 'history',
    base:'/',
    //初始路由
    routes: [
        {name: 'login',path: '/login',component: login},   //登录页
        {name: 'root',path: '/',redirect: '/login'},   //访问根实例,不加任何其他路由
        {
            name: 'index',  //首页
            path: '/index',
            component: index,
            children: [
                {
                    name:'addStudent',
                    path:'addStudent',
                    component:addStudent
                },
                {
                    name:'addTeacher',
                    path:'addTeacher',
                    component:addTeacher
                },
                {
                    name:'infoStudent',
                    path:'infoStudent',
                    component:infoStudent
                },
                {
                    name:'infoTeacher',
                    path:'infoTeacher',
                    component:infoTeacher
                },
                {
                    name:'college',
                    path:'college',
                    component:college
                },
                {
                    name:'addCollege',
                    path:'addCollege',
                    component:addCollege
                },
                {
                    name:'addPro',
                    path:'addPro',
                    component:addPro
                },
                {
                    name:'config',
                    path:'config',
                    component:config
                },
                {
                    name:'studentAccount',
                    path:'studentAccount',
                    component:studentAccount
                },
                {
                    name:'teacherAccount',
                    path:'teacherAccount',
                    component:teacherAccount
                },
                {
                    name:'addCourse',
                    path:'addCourse',
                    component:addCourse
                },
                {
                    name:'editCourse',
                    path:'editCourse',
                    component:editCourse
                },
                {
                    name:'compare',
                    path:'compare/:courseId',
                    component:compare
                },
                {
                    name:'comparePro',
                    path:'comparePro',
                    component:comparePro
                },
                {
                    name:'compareResult',
                    path:'compareResult',
                    component:compareResult
                },
                {
                    name:'compareStudent',
                    path:'compareStudent',
                    component:compareStudent
                },
                {
                    name:'evalution',
                    path:'evalution/:id/:username/:courseName',
                    component:evalution
                },
                {
                    name:'questionShow',
                    path:'questionShow',
                    component:questionShow
                },
                {
                    name:'addQuestion',
                    path:'addQuestion',
                    component:addQuestion
                },
            ]
        },
        {name: 'page404',path: '/page404',component: page404},         //404页面
        {name: 'error',path: '*',redirect: '/page404'},         //匹配不到页面时跳转404页面
        {name: 'example',path: '/components/example',component: example},   //示例
    ]
})
