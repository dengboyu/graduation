<!-- 组件 -->
<template>
    <div class="index-tmpl">
        <el-container>
            <el-aside width="220px">
                <aside-vue></aside-vue>
            </el-aside>
            <el-container>
                <el-header>
                    <p>
                        <router-link to="/login" v-if="userInfo.name===null?true:false" class="login">Hi,请 登录</router-link>
                        <span v-else class="login" style="margin-right:10px">Hi,您好: <span v-text="userInfo.name"></span></span>
                        <router-link to="/register" >注册</router-link>
                        <router-link to="/index/orderList">
                            <i class="el-icon-tickets"></i>
                            <span>我的订单</span>
                        </router-link>
                        <router-link to="/index/shopCar">
                            <i class="iconfont icon-qicheqianlian-"></i>
                            <span>购物车</span>
                        </router-link>
                        <span v-if="userInfo.name===null?false:true" class="logout" @click="logout">【退出】</span>
                    </p>
                </el-header>
                <el-main>
                    <router-view></router-view>
                </el-main>
            </el-container>
        </el-container>

    </div>
</template>

<!-- 组件导出 -->
<script>
    import {mapState,mapActions} from 'vuex'
    import asideVue from './aside'
    export default{
        data(){
            return {

            }
        },
        created(){

        },
        methods:{
            logout(){
                this.$store.state.userModule.userInfo.name=null;
                this.$router.push({path:'/index'});
            },
        },
        computed:{
            ...mapState('userModule',['userInfo'])
        },
        components:{
            asideVue,
        }
    }
</script>

<!-- 本组件样式 -->
<style scoped>
    .index-tmpl{
        position: absolute;
        top:0;
        bottom: 0;
        width:100%;
        overflow: overlay;
    }
    .el-header, .el-footer {
        background-color: #e5e5e5;
        color: #333;
        text-align: center;
        line-height: 40px;
        height:40px!important;
    }
    .el-aside {
        background-color: rgb(230, 126, 55);
        color: #fff;
        padding-top:40px;
    }
    .el-main {
        background-color: #E9EEF3;
        color: #666;
        padding:0px;
        padding-bottom: 30px;
    }
    .index-tmpl > .el-container {
        height:100%;
    }
    .el-container:nth-child(5) .el-aside,
    .el-container:nth-child(6) .el-aside {
        line-height: 260px;
    }
    .el-container:nth-child(7) .el-aside {
        line-height: 320px;
    }
    .el-header p {
        text-align: right;
        margin-right:30px;
    }
    .el-header p a{
        color:#666;
        display: inline-block;
        margin-right:20px;
    }
    .el-header p a:hover,
    .logout:hover{
        color:#ff4040;
        cursor: pointer;
    }
    .el-header p .login{
        color:#ff4040;
    }
    .logout{
        margin-left:-20px;
    }
</style>
