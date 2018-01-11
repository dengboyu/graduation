// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import ElementUI from 'element-ui'          //引入element-ui框架
import 'element-ui/lib/theme-chalk/index.css'   //引入element默认的css
import '@/assets/css/reset.css'     // 去除公共样式css
import '@/assets/css/site.css'      // 整个站点公共css
import plugin from '@/assets/plugin/customize/plugin'   //导入自定义以及第三方插件
import store from '@/computer/store/pcStore'  //vuex数据管理仓库
import router from './router'   //路由
import App from './App'



Vue.use(plugin)     //使用自定义以及第三方插件
Vue.use(ElementUI)  //elementUI插件

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
    el: '#app',
    router,
    store,
    template: '<App/>',
    components: { App }
})
