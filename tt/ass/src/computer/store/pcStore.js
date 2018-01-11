/**
 * author:by@Deng
 * email:by@6886432@163.com
 * version:1.0
 * descriptioin: pc端数据管理仓库
 */

import Vue from 'vue'
import Vuex from 'vuex' //导入数据管理状态
import userModule from './modules/userModule'   //用户信息模块

Vue.use(Vuex)       //使用vuex管理数据

//管理模块
export default new Vuex.Store({
    modules:{
        userModule,     //用户信息模块
    }
})
