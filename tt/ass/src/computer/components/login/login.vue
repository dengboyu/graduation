<!-- 组件 -->
<template>
    <div class="tmpl">
        <p class="chineseName">外协企业智能报价单系统</p>
        <p class="englishName">Outsourcing Business Intelligence Quotation System</p>
        <div class="main">
            <div class="mian-form">
                用户名:<el-input v-model="username" placeholder="请输入用户名" class="username"></el-input><br>
                密&nbsp;&nbsp; 码: <el-input type="password" v-model="password" placeholder="请输入密码" style="margin-left:16px;"></el-input><br>
                <el-button type="primary" @click="login">登录</el-button>
                <el-button type="primary" @click="jumpRegister">注册</el-button>
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
                username:null,
                password:null,
            }
        },
        methods: {
            login(){


                if(this.username==null || this.password==null){
                    this.$message({
                        message: '请输入用户名或密码',
                        type: 'warning'
                    });
                    return;
                }


                this.$http.axios({
                    url:'/user/userLogin',
                    method:'post',
                    data:{username:this.username,password:this.password},
                }).then(resolve=>{
                    this.$router.push({path:'/index'});
                }).catch(err=>{
                    console.log("失败了")
                })
            },
            jumpRegister(){
                this.$router.push({path:'/register'});
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
        margin-top:100px;
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
        top:33%;
        left:37%;
        height:300px;
        width:400px;
        background: #65c0e8;
    }
    .mian-form{
        padding-left: 70px;
    }
    .el-input{
        width:53%;
        margin-left:20px;
    }
    .username{
        margin-top:60px;
        margin-bottom:30px;
    }
    .el-button{
        margin:20px;
    }
</style>
