<!-- 组件 -->
<template>
    <div class="tmpl">
        <header>
            <p>
                <img src="../../../assets/img/logo.jpg">
                <span class="title">智能导购系统</span>
            </p>
            <p class="register">
                <span class="common" :class="loginFlag==0?'red-back':''" @click="tabLogin(0)">登 录</span>
                <span class="yuandian"></span>
                <span class="common" :class="loginFlag==1?'red-back':''" style="margin-left:20px" @click="tabLogin(1)">普通用户注册</span>
                <span class="yuandian"></span>
                <span class="company" :class="loginFlag==2?'red-back':''" @click="tabLogin(2)">企业注册</span>
                <span class="yuandian" style="margin-right:20px"></span>
                <span class="company"  @click="goIndex">进入主页</span>
            </p>
        </header>
        <div class="login-register">
            <div class="register-user login" v-if="loginFlag==0?true:false">
                <p>
                    <span>用户名</span>
                    <el-input v-model="userInfo.nick" placeholder="请输入用户名"></el-input>
                </p>
                <p>
                    <span>密&nbsp;&nbsp;&nbsp;码</span>
                    <el-input v-model="userInfo.password" type="password" placeholder="请输入密码"></el-input>
                </p>
                <p class="changeIden">
                    <el-radio v-model="radioType" label="0">客 户</el-radio>
                    <el-radio v-model="radioType" label="1">商 户</el-radio>
                </p>
                <p>
                    <el-button type="success" @click="login">登 录</el-button>
                </p>
            </div>
            <div class="register-user common-register" v-else-if="loginFlag==1?true:false">
                <p>
                    <span>用户名</span>
                    <el-input v-model="userInfo.nick" placeholder="请输入用户名"></el-input>
                </p>
                <p>
                    <span>手机号</span>
                    <el-input v-model="userInfo.phone" type="tel" :maxlength="11" placeholder="请输入手机号"></el-input>
                </p>
                <p>
                    <span>邮&nbsp;&nbsp;&nbsp;箱</span>
                    <el-input v-model="userInfo.email" type="text" placeholder="请输入个人邮箱"></el-input>
                </p>
                <p>
                    <span>密&nbsp;&nbsp;&nbsp;码</span>
                    <el-input v-model="userInfo.password" type="password" placeholder="请输入密码"></el-input>
                </p>
                <p>
                    <el-button type="success" @click="register(0)">注 册</el-button>
                </p>
            </div>
            <div class="register-user company-register" v-else>
                <p>
                    <span>店铺名</span>
                    <el-input v-model="userInfo.nick" placeholder="请输入店铺名称"></el-input>
                </p>
                <p>
                    <span>手机号</span>
                    <el-input v-model="userInfo.phone" type="tel" :maxlength="11" placeholder="请输入手机号"></el-input>
                </p>
                <p>
                    <span>邮&nbsp;&nbsp;&nbsp;箱</span>
                    <el-input v-model="userInfo.email" type="text" placeholder="请输入企业邮箱"></el-input>
                </p>
                <p>
                    <span>密&nbsp;&nbsp;&nbsp;码</span>
                    <el-input v-model="userInfo.password" type="password" placeholder="请输入密码"></el-input>
                </p>
                <p>
                    <el-button type="success" @click="register(1)">注 册</el-button>
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
                radioType:'0',
                userInfo:{
                    nick:'',
                    password:'',
                    phone:'',
                    email:'',
                }
            }
        },
        created(){
            if(this.$route.params.loginFlag!=null){
                this.loginFlag = this.$route.params.loginFlag;
            }
        },
        methods:{
            tabLogin(param){
                this.loginFlag=param;
                for(let i in this.userInfo){
                    this.userInfo[i]='';
                }
            },
            goIndex(){
                this.$router.push({path:'/index'});
            },
            login(){
                if(this.userInfo.nick==null || this.userInfo.password==null) return this.$message.warning('请将信息填写完毕');

                this.userInfo.type = this.radioType;
                this.$http.axios({
                    url:'/user/userLogin',
                    method:'post',
                    data:this.userInfo,
                    json:true,
                }).then(resolve=>{

                    if(this.userInfo.type==0){
                        this.$router.push({path:'/index'});
                    }else if(this.userInfo.type==1){
                        this.$router.push({path:'/company'});
                    }

                }).catch(err=>{
                    console.log("失败了")
                })

            },
            register(param){
                this.userInfo.type=''+param;

                if(this.$fn.hasObjectNull(this.userInfo)) return this.$message.warning('请将信息填写完毕');


                this.$http.axios({
                    url:'/userInfo/insertUserInfoEntity',
                    method:'post',
                    data:this.userInfo,
                    json:true,
                }).then(resolve=>{
                    this.$message.success('注册成功');
                    for(let i in this.userInfo){
                        this.userInfo[i]='';
                    }

                    this.loginFlag=0;
                }).catch(err=>{
                    console.log("失败了")
                })
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
        height:360px;
        background-color: #fff;
        position: absolute;
        top:18%;
        right:10%;
    }
    .register-user{
        margin-top:40px;
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
    .red-back{
        color:red;
    }
</style>
