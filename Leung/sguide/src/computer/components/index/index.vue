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
                        <router-link to="/login/0" v-if="username==''?true:false" class="login">Hi,请 登录</router-link>
                        <span v-else class="login" style="margin-right:10px">Hi,您好: <span class="goPerInfo" @click="goPerInfo" v-text="username"></span></span>
                        <router-link to="/login/1" >注册</router-link>
                        <router-link to="/index/orderList">
                            <i class="el-icon-tickets"></i>
                            <span>我的订单</span>
                        </router-link>
                        <router-link to="/index/shopCar">
                            <i class="iconfont icon-qicheqianlian-"></i>
                            <span>购物车</span>
                        </router-link>
                        <span v-if="username==''?false:true" class="logout" @click="logout">【退出】</span>
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
                username:''
            }
        },
        created(){

        },
        methods:{
            logout(){
                this.$http.axios({
                    url:'/userInfo/logout',
                    method:'post',
                }).then(resolve=>{

                    this.username='';
                    this.$router.push({path:'/index'});

                }).catch(err=>{
                    console.log("失败了")
                })

            },
            goPerInfo(){
                this.$router.push({path:'/person'});
            },
            getUserInfo(){
                this.$http.axios({
                    url:'/userInfo/getUserInfoEntity',
                    method:'get',
                }).then(resolve=>{

                    if(resolve!=null){
                        this.username=resolve.nick;
                    }

                }).catch(err=>{
                    console.log("失败了")
                })
            }
        },
        computed:{
            ...mapState('userModule',['userInfo'])
        },
        components:{
            asideVue,
        },
        created(){
            this.getUserInfo();
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
    .goPerInfo:hover{
        cursor: pointer;
    }
</style>
