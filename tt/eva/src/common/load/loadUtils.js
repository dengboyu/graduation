/**
 * author: by@Deng
 * email: by6886432@163.com
 * description: 封装load效果
 */
import { Loading } from 'element-ui';

let load=null;

export default{
    //对element-ui的loading二次封装
    loading(){
        load = Loading.service({
            lock: true,
            text: '加载中...',
            spinner: 'el-icon-loading',
            background: 'rgba(0, 0, 0, 0.7)'
        })
    },
    closeLoading(){         //关闭loading
        if(load){
            load.close();
        }
    }
}


