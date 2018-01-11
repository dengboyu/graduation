/**
 * 用户模块的信息
 */
import mutationName from '../mutation_name'   //导入mutation_name管理公共数据的名称的方法

export default{
    namespaced:true,       //开启自动命名空间
    state(){
        return {
            identity:1,  //登录系统身份 1-管理员，2-学生，3-教师
            userName:null, //用户名
        }
    },
    getters:{

    },
    mutations:{
        changeIdentity(state,identity){
            state.identity=identity;
        },
        changeUserName(state,name){
            state.userName = name;
        }
    },
    actions:{
        changeIdentity(context,identity){
            context.commit('changeIdentity',identity); //提交mutations中changeIdentiy方法
        },
        changeUserName(context,name){
            context.commit('changeUserName',name);  //更改用户名
        }
    }
}
