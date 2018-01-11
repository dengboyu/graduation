'use strict'

import Vue from 'vue'
import commonUtils from '@/common/utils/commonUtils'   //公共函数js
import requestUtils from '@/common/utils/requestUtils'     //自定义封装axios请求
import loadUtils from '@/common/load/loadUtils'  //加载中动画
import api from '@/common/api/api'      //访问后台请求接口


export default {
    install:function(Vue){
        Object.defineProperty(Vue.prototype, '$commonUtils', {value: commonUtils})   //公共函数js
        Object.defineProperty(Vue.prototype, '$http', {value: requestUtils})  //自定义封装axios请求
        Object.defineProperty(Vue.prototype, '$load', {value: loadUtils})  //自定义封装axios请求
        Object.defineProperty(Vue.prototype, '$api', {value: api})  //访问后台请求接口
    }
}
