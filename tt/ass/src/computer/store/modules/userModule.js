/**
 * 用户模块的信息
 */
import mutationName from '../mutation_name'   //导入mutation_name管理公共数据的名称的方法

export default{
    namespaced:true,       //开启自动命名空间
    state(){
        return {
            userInfo: {     //用户信息
                name: '李涛'
            },
            isLogin: false, //是否登录
        }
    },
    getters:{

    },
    mutations:{
        //example
        [mutationName.LOGIN](state){
            state.isLogin=!state.isLogin;
        }
    },
    actions:{
        [mutationName.LOGIN](context){
            context.commit(mutationName.LOGIN); //提交mutations中login方法
        }
    }
}
