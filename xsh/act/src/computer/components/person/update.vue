<!-- 组件 -->
<template>
    <div class="tmpl-update">
        <p class="img-top"><img src="../../../assets/img/p1.png" height="50" width="50"><span>修改信息</span></p>
        <el-form ref="form" :model="sysUser" label-width="80px">
          <el-form-item label="学号">
            <span v-text="sysUser.number"></span>
          </el-form-item>
          <el-form-item label="姓名">
            <el-input v-model="sysUser.name" class="input-width"></el-input>
          </el-form-item>
          <el-form-item label="邮箱">
            <el-input v-model="sysUser.email" class="input-width"></el-input>
          </el-form-item>
          <el-form-item label="手机号">
            <el-input v-model="sysUser.phone" class="input-width"></el-input>
          </el-form-item>
          <el-form-item label="学院">
            <span v-text="sysUser.collegeName"></span>
          </el-form-item>
          <el-form-item label="专业">
            <span v-text="sysUser.professionName"></span>
          </el-form-item>
          <el-form-item label="性别">
            <el-radio-group v-model="sysUser.sex">
              <el-radio label="男"></el-radio>
              <el-radio label="女"></el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="updateUserInfo">修 改</el-button>
          </el-form-item>
        </el-form>
    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {
                sysUser: {
                    number:'',
                    name: '',
                    password:'',
                    email:'',
                    phone:'',
                    collegeId: '',
                    professionId:'',
                    sex:'',
                },
                collegeList:[],
                professionList:[],
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
            },
            updateUserInfo(){
                if(this.sysUser.name==''||this.sysUser.email==''||this.sysUser.phone==''||this.sysUser.sex==''){
                    return this.$message.warning("请将信息补充完整");
                }

                this.$http.axios({
                    url:'/sysUser/updateUserInfo',
                    method:'post',
                    data:this.sysUser,
                    json:true
                }).then(resolve=>{

                    this.$message.success("更新完毕");
                    this.$router.push({path:'/index/query'});

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
