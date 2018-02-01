'use strict'


export default{
    /**
     * 判断对象中值是否齐全
     * 有是返回true,没有返回false
     */
    hasObjectNull(obj){
        for(let i in obj){
            if(!obj[i])return true;
        }
        return false;
    },
    /**
     * 清空对象所有值
     */
    resetObject(obj){
        for(let i in obj){
            obj[i]=null;
        }
    }

}
