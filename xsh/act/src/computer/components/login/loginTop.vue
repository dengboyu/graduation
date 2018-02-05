<!-- 组件 -->
<template>
    <div class="tmpl">
        <div class="login-top">
            <img class="login-logo" src="../../../assets/img/tjkd.jpg" height="110" width="300">
            <span class="main-act">校园活动</span>
            <span class="main-tuijian">推荐系统</span>
        </div>
        <div>
            <router-view></router-view>
        </div>
    </div>
</template>

<!-- 组件导出 -->
<script>
    import login from './login';

    export default{
        data(){
            return {

            }
        },
        created(){

        },
        components:{
            login,
        }
    }
</script>

<!-- 本组件样式 -->
<style scoped>
    .login-top{
        border-bottom: 2px solid #fff;
        height:120px;
    }
    .login-logo{
        margin:5px 50px;
        display: inline-block;
    }
    .main-act{
        position: relative;
        top: -70px;
        font-size: 26px;
        letter-spacing: 2px;
        font-weight: bold;
        color: #116eb7;
    }
    .main-tuijian{
        position: relative;
        top: -35px;
        font-size: 26px;
        letter-spacing: 2px;
        font-weight: bold;
        color: #116eb7;
    }
</style>
