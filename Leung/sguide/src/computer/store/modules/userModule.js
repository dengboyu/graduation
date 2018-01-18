/**
 * 用户模块的信息
 */
import mutationName from '../mutation_name'   //导入mutation_name管理公共数据的名称的方法

export default{
    namespaced:true,       //开启自动命名空间
    state(){
        return {
            userInfo: {     //用户信息
                phone: 15833333333,
                // name: '李涛'
                name: '李涛涛'
            },
            isLogin: false, //是否登录
        }
    },
    getters:{

    },
    mutations:{
        //example
        changeName(state,name){
            state.userInfo.name=name;
        }
    },
    actions:{
        changeName(context,name){
            context.commit(changeName,name); //提交mutations中login方法
        }
    }
}
