<!-- 组件 -->
<template>
    <div class="tmpl">
        <header>
            <p>
                <img src="../../../assets/img/logo.jpg">
                <span class="title">智能导购系统</span>
            </p>
            <p class="register">
                <span class="common" @click="tabLogin(0)">登 录</span>
                <span class="yuandian"></span>
                <span class="common" style="margin-left:20px" @click="tabLogin(1)">普通用户注册</span>
                <span class="yuandian"></span>
                <span class="company"  @click="tabLogin(2)">企业注册</span>
                <span class="yuandian" style="margin-right:20px"></span>
                <span class="company"  @click="goIndex">进入主页</span>
            </p>
        </header>
        <div class="login-register">
            <div class="register-user login" v-if="loginFlag===0?true:false">
                <p>
                    <span>用户名</span>
                    <el-input v-model="input" placeholder="请输入用户名"></el-input>
                </p>
                <p>
                    <span>密&nbsp;&nbsp;&nbsp;码</span>
                    <el-input v-model="input" type="password" placeholder="请输入密码"></el-input>
                </p>
                <p class="changeIden">
                    <el-radio v-model="radio" label="1">客 户</el-radio>
                    <el-radio v-model="radio" label="2">商 户</el-radio>
                </p>
                <p>
                    <el-button type="success">登 录</el-button>
                </p>
            </div>
            <div class="register-user common-register" v-else-if="loginFlag===1?true:false">
                <p>
                    <span>用户名</span>
                    <el-input v-model="input" placeholder="请输入用户名"></el-input>
                </p>
                <p>
                    <span>密&nbsp;&nbsp;&nbsp;码</span>
                    <el-input v-model="input" type="password" placeholder="请输入密码"></el-input>
                </p>
                <p>
                    <el-button type="success">注 册</el-button>
                </p>
            </div>
            <div class="register-user company-register" v-else>
                <p>
                    <span>店铺名</span>
                    <el-input v-model="input" placeholder="请输入店铺名称"></el-input>
                </p>
                <p>
                    <span>手机号</span>
                    <el-input v-model="input" placeholder="请输入手机号"></el-input>
                </p>
                <p>
                    <span>密&nbsp;&nbsp;&nbsp;码</span>
                    <el-input v-model="input" type="password" placeholder="请输入密码"></el-input>
                </p>
                <p>
                    <el-button type="success">注 册</el-button>
                </p>
            </div>
        </div>
    </div>
</template>

<!-- 组件导出 -->
<script>
import {mapState, mapMutations,mapActions} from 'vuex'
    export default{
        data(){
            return {
                loginFlag:0,
                radio: '1',
                input: '',
            }
        },
        created(){

        },
        methods:{
            tabLogin(param){
                this.loginFlag=param;
            },
            goIndex(){
                // this.$store.dispatch('userModule/changeName',"我们");
                this.$router.push({path:'/index'});
                console.log(this.$store)
            }
        },
        components:{

        }
    }
</script>

<!-- 本组件样式 -->
<style scoped>
    .tmpl{
        position: absolute;
        top:0;
        bottom: 0;
        width:100%;
        background:url("../../../assets/img/bg.gif") repeat-x center;
    }
    header{
        height:120px;
    }
    header img{
        width:150px;
        height:80px;
        position: absolute;
        left:30px;
        background-color: red;
    }
    header .title{
        position: absolute;
        top: 5px;
        left: 15%;
        letter-spacing: 2px;
        font-size: 18px;
    }
    .yuandian{
        display: inline-block;
        width: 6px;
        height: 6px;
        background: #39476c;
        border-radius: 50%;
    }
    .tmpl .register{
        position: absolute;
        top:20px;
        right:6%;
        font-size:20px;
    }
    .common:hover,.company:hover{
        cursor: pointer;
        color:red;
    }
    .common{
        margin-right:20px;
    }
    .company{
        margin-left:20px;
    }
    .login-register{
        width:320px;
        height:340px;
        background-color: #fff;
        position: absolute;
        top:18%;
        right:10%;
    }
    .register-user{
        margin-top:60px;
        padding-left:20px;
    }
    .register-user .el-input{
        width:75%;
        height:30px;
    }
    .register-user p{
        height:60px;
    }
    .register-user p .el-button{
        width:260px;
        margin-left:8px;
    }
    .changeIden{
        font-weight: normal;
        margin-left:60px;
    }
</style>
