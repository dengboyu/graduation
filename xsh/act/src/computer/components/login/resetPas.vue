<!-- 组件 -->
<template>
    <div class="tmpl">
        <p class="img-top"><img src="../../../assets/img/p1.png" height="50" width="50"><span>密码重置</span></p>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="学号">
            <el-input v-model="form.number" class="input-width" placeholder="请输入学号"></el-input>
          </el-form-item>
          <el-form-item label="密码">
            <el-input v-model="form.password" type="password" class="input-width" placeholder='请输入密码'></el-input>
          </el-form-item>
          <el-form-item label="密码确认">
            <el-input v-model="passwordAgain" type="password" class="input-width" placeholder="再次输入密码"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="updatePassword">提 交</el-button>
          </el-form-item>
        </el-form>
    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {
                form: {
                    number: '',
                    password:''
                },
                passwordAgain:''
            }
        },
        methods:{
            updatePassword(){
                if(this.$fn.hasObjectNull(this.form) || this.passwordAgain==''){
                    return this.$message.warning("请将信息补充完整");
                }

                if(this.form.password!==this.passwordAgain){
                    return this.$message.warning("两次输入密码不一致");
                }


                this.$http.axios({
                    url:'/sysUser/updateUserInfo',
                    method:'post',
                    data:this.form,
                    json:true
                }).then(resolve=>{

                    this.$message.success("密码修改成功");
                    this.$router.push({path:'/loginTop'});

                }).catch(err=>{
                    console.log("失败了")
                })
            }
        },
        computed:{

        },
        created(){

        },
        mounted(){

        },
        components:{

        },
    }
</script>

<!-- 本组件样式 -->
<style scoped>
    .tmpl{
        width:500px;
        margin:20px auto;
        border:1px solid #d2cece;
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
    .el-form{
        margin-top:20px;
    }
    .input-width{
        width:80%;
    }
    .el-select,.el-button--primary{
        width:336px;
    }

</style>
