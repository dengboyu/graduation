<!-- 组件 -->
<template>
    <div class="tmpl">
        <el-row>
            <el-col>
                <div class="grid-content bg-purple">
                    <p class="pingjiao">高校学生评教系统</p>
                    <el-form class="login" label-position="right" label-width="80px" :model="formLabelAlign">
                        <el-form-item label="用户名">
                            <el-input v-model="formLabelAlign.number" placeholder="请输入用户名"></el-input>
                        </el-form-item>
                        <el-form-item label="密码">
                            <el-input type="password" v-model="formLabelAlign.password" placeholder="请输入密码"></el-input>
                        </el-form-item>
                        <el-form-item label="选择身份">
                            <el-radio-group v-model="formLabelAlign.resource">
                                <el-radio label="学生"></el-radio>
                                <el-radio label="教师"></el-radio>
                                <el-radio label="管理员"></el-radio>
                            </el-radio-group>
                        </el-form-item>
                        <el-button type="primary" style="width:52%;margin-left: 26%" @click="login">登录</el-button>
                    </el-form>
                </div>
            </el-col>
        </el-row>
    </div>
</template>

<!-- 组件导出 -->
<script>
    import register from './register'
    // import { mapState,mapGetters,mapMutations,mapActions } from 'vuex'

    export default{
        data(){
            return {
                formLabelAlign: {
                    number: '',
                    password: '',
                    identity: '',
                    resource: '学生',
                }
            }
        },
        created(){

        },
        components:{

        },
        methods:{
            // ...mapActions('userModule',['changeIdentity']),
            login(){

                //跳转到首页
                if(this.formLabelAlign.resource==='教师'){
                    this.formLabelAlign.identity='1';
                }else if(this.formLabelAlign.resource==='学生'){
                    this.formLabelAlign.identity='0';
                }else if(this.formLabelAlign.resource==='管理员'){
                    this.formLabelAlign.identity='2';
                }

                if(this.formLabelAlign.number=='' || this.formLabelAlign.password==''){
                    return this.$message({
                        type:'warning',
                        message:'请输入用户名或密码'
                    });
                }

                this.$http.axios({
                    url:'/user/userLogin',
                    method:'post',
                    data:this.formLabelAlign,
                    json:true,
                }).then(resolve=>{
                    this.$router.push({ path: '/index' });
                }).catch(err=>{
                    console.log("失败了")
                })



            }
        }
    }
</script>

<!-- 本组件样式 -->
<style scoped>
    .tmpl{
        width: 100%;
        position: absolute;
        top: 0px;
        bottom: 0px;
        height: 100%;
        background: #3d84ca;
    }
    .el-row{
        position: absolute;
        top:25%;
        left:30%;
        width:40%;
        height:400px;
        background: url('../../../assets/img/loginbg.jpeg');
    }
    .grid-content {
        position: absolute;
        top:0;
        bottom:0;
        width:100%;
        height:100%;
    }
    .pingjiao{
        width: 100%;
        height: 80px;
        line-height: 80px;
        font-size: 26px;
        text-align: center;
        color: #fff;
        letter-spacing: 2px;
    }
    .login{
        width: 80%;
        margin-left: 10%;
        margin-top: 60px;
    }
    .el-form-item{
        margin-left: 40px;
    }
    .el-form-item__label{

    }
</style>
