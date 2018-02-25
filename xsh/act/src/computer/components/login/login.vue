<!-- 组件 -->
<template>
    <div class="tmpl">
        <div>
            <div class="img-loop">
                <div class="block">
                    <el-carousel height="600px" :interval="2000" :arrow="'never'">
                        <el-carousel-item v-for="(item,index) in imgList" :key="index">
                            <img :src="item" class="img-ci">
                        </el-carousel-item>
                    </el-carousel>
                </div>
            </div>
            <div class="login-main">
                <p class="img-top"><img src="../../../assets/img/p1.png" height="50" width="50"><span>用户登陆</span></p>
                <p class="username-login"><input v-model='sysUser.number' placeholder="请输入学号"></p>
                <p class="password-login"><input v-model='sysUser.password' type="password" placeholder="密码"></p>
                <p class="login"><el-button type="primary" @click="login">登 陆</el-button></p>
                <p class="register">
                    <router-link to="/loginTop/register" class="register-one">注 册</router-link>
                    <router-link to="/loginTop/resetPas" class="register-two">忘记密码?</router-link>
                </p>
            </div>
        </div>
    </div>
</template>

<!-- 组件导出 -->
<script>
    import slide1 from '../../../assets/img/slide1.jpg';
    import slide2 from '../../../assets/img/slide2.jpg';
    import slide3 from '../../../assets/img/slide3.jpg';
    import slide4 from '../../../assets/img/slide4.jpg';
    import slide5 from '../../../assets/img/slide5.jpg';
    import slide6 from '../../../assets/img/slide6.jpg';
    import slide7 from '../../../assets/img/slide7.jpg';
    import slide8 from '../../../assets/img/slide8.jpg';

    export default{
        data(){
            return {
                imgList:[
                    slide1,slide2,slide3,slide4,slide5,slide6,slide7,slide8,
                ],
                sysUser:{
                    number:'',
                    password:''
                }
            }
        },
        methods:{
            login(){

                if(this.sysUser.number=='' ||  this.sysUser.password==''){
                    return this.$message.warning('请输入学号或密码登录');
                }

                this.$http.axios({
                    url:'/user/userLogin',
                    method:'post',
                    data:this.sysUser
                }).then(resolve=>{

                    if(this.sysUser.number==='admin'){
                        this.$router.push({path:'/admin'});
                    }else{
                        this.$router.push({path:'/index'});
                    }

                }).catch(err=>{
                    console.log("失败了")
                })


            },

        },
        created(){

        },
        components:{

        }
    }
</script>

<!-- 本组件样式 -->
<style scoped>
    .img-loop{
        margin:20px auto;
        width:1200px;
        height:600px;
    }
    .img-ci{
        width:1200px;
        height:600px;
    }
    .login-main{
        background: url('../../../assets/img/log_4_3.png');
        width: 400px;
        height: 300px;
        position: absolute;
        top:220px;
        right:200px;
        z-index: 2;
    }
    .img-top{
        height:60px;
        margin-top:10px;
        font-size: 20px;
        padding-left:20px;
    }
    .img-top span{
        position: relative;
        display: inline-block;
        top:-15px;
        left:10px;
    }
    .username-login input{
        background:#fff url('../../../assets/img/username-bg.png') no-repeat 0px 0px / 50px 45px;
        height: 41px;
        width:90%;
        margin-left:5%;
        text-indent: 17%;
        border: 1px solid #ada4a4;
        margin-top:10px;
    }
    .password-login input{
        background:#fff url('../../../assets/img/password-bg.png') no-repeat 0px 0px / 50px 45px;
        height: 41px;
        width:90%;
        margin-left:5%;
        text-indent: 17%;
        border: 1px solid #ada4a4;
        margin-bottom:10px;
    }
    .login .el-button{
        width: 90%;
        margin-left: 5%;
    }
    .register{
        margin:10px 40px;
    }
    .register-two{
        color:red;
        margin-left:210px;
    }
</style>
