<!-- 组件 -->
<template>
    <div class="tmpl">
        <p class="chineseName">外协企业智能报价单系统</p>
        <p class="englishName">Outsourcing Business Intelligence Quotation System</p>
        <div class="main">
            <div class="mian-form">
                &nbsp;&nbsp;&nbsp;用户名:<el-input v-model="user.name" placeholder="请输入用户名" class="username"></el-input><br>
                &nbsp;&nbsp;&nbsp;密&nbsp;&nbsp; 码: <el-input v-model="user.password" placeholder="请输入密码" type="password" style="margin-left:16px;"></el-input><br>
                确认密码: <el-input v-model="user.passwordAgin" type="password" placeholder="再次输入密码" style="margin-left:16px;"></el-input><br>
                真实姓名: <el-input v-model="user.realName" placeholder="请输入真实姓名" style="margin-left:16px;"></el-input><br>
                &nbsp;&nbsp;&nbsp;&nbsp;Email:&nbsp;<el-input v-model="user.email" placeholder="请输入Email" style="margin-left:18px;"></el-input><br>
                手机号码: <el-input v-model="user.phone" placeholder="请输入手机号码" style="margin-left:16px;"></el-input><br>
                <el-button type="primary" >注册</el-button>
                <el-button type="primary" @click="reset">清空</el-button>
            </div>
        </div>
        <div class="footer">OA在线试用 | 联系我们 | 项目管理系统 | OA系统  <span style="margin-left:140px">Copyright @ 天津科技大学 大沽南路1038号</span></div>
    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {
                user:{
                    name:null,
                    password:null,
                    passwordAgin:null,
                    realName:null,
                    email:null,
                    phone:null,
                }
            }
        },
        methods: {
            reset(){
                for(let i in this.user){
                    this.user[i]=null;
                }
            }
        },
        created(){

        },
        components:{

        }
    }
</script>

<!-- 本组件样式 -->
<style scoped>
    .tmpl{
        background:#EEF0EF url("../../../assets/img/bg.jpg") repeat-x top;
        position: absolute;
        top:0px;
        bottom: 0px;
        width:100%;
        color:#4f564f;
    }
    .footer{
        position: absolute;
        height:40px;
        left: 20%;
        bottom:20px;
    }
    .chineseName{
        margin-top:70px;
        font-size: 22px;
        margin-left:400px;
    }
    .englishName{
        margin-top:10px;
        font-size: 22px;
        margin-left:520px;
    }
    .main{
        position: absolute;
        top:21%;
        left:37%;
        height:500px;
        width:400px;
        background: #65c0e8;
    }
    .mian-form{
        padding-left: 55px;
        padding-top:30px;
    }
    .el-input{
        width:53%;
        margin-left:20px;
        margin-top:15px;
    }
    .el-button{
        margin:40px 25px;
    }
</style>
