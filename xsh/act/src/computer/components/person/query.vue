<!-- 组件 -->
<template>
    <div class="tmpl-update">
        <p class="img-top"><img src="../../../assets/img/p1.png" height="50" width="50"><span>查看个人信息</span></p>
        <el-form ref="form" :model="sysUser" label-width="80px">
          <el-form-item label="学号:">
            <span v-text="sysUser.number"></span>
          </el-form-item>
          <el-form-item label="姓名:">
            <span v-text="sysUser.name"></span>
          </el-form-item>
          <el-form-item label="邮箱:">
            <span v-text="sysUser.email"></span>
          </el-form-item>
          <el-form-item label="手机号:">
            <span v-text="sysUser.phone"></span>
          </el-form-item>
          <el-form-item label="学院:">
            <span v-text="sysUser.collegeName"></span>
          </el-form-item>
          <el-form-item label="专业:">
            <span v-text="sysUser.professionName"></span>
          </el-form-item>
          <el-form-item label="性别:">
            <span v-text="sysUser.sex"></span>
          </el-form-item>
        </el-form>
    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {
                sysUser: {}
            }
        },
        methods:{
            getUserInfo(){
                this.$http.axios({
                    url:'/sysUser/getSysUserInfo',
                    method:'get',
                }).then(resolve=>{

                    this.sysUser = resolve;

                }).catch(err=>{
                    console.log("失败了")
                })
            }

        },
        computed:{

        },
        created(){
            this.getUserInfo();
        },
        mounted(){

        },
        components:{

        },
    }
</script>

<!-- 本组件样式 -->
<style scoped>
    .tmpl-update{
        width:500px;
        margin:20px auto;
        border:1px solid #d2cece;
    }
    .img-top{
        height:60px;
        margin-top:10px;
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
