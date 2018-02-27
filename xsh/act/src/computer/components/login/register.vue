<!-- 组件 -->
<template>
    <div class="tmpl">
        <p class="img-top"><img src="../../../assets/img/p1.png" height="50" width="50"><span>用户注册</span></p>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="学号">
            <el-input v-model="form.number" class="input-width" type="number"></el-input>
          </el-form-item>
          <el-form-item label="姓名">
            <el-input v-model="form.name" class="input-width"></el-input>
          </el-form-item>
          <el-form-item label="密码">
            <el-input v-model="form.password" type="password" class="input-width"></el-input>
          </el-form-item>
          <el-form-item label="邮箱">
            <el-input v-model="form.email" class="input-width"></el-input>
          </el-form-item>
          <el-form-item label="手机号">
            <el-input v-model="form.phone" class="input-width" type="number"></el-input>
          </el-form-item>
          <el-form-item label="学院">
            <el-select v-model="form.collegeId" placeholder="请选择学院" @change="changeProfession(form.collegeId)">
              <el-option :label="item.collegeName" :value="item.id" v-for="(item,index) in collegeList" :key="index"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="专业">
            <el-select v-model="form.professionId" placeholder="请选择专业">
              <el-option :label="item.professionName" :value="item.id" v-for="(item,index) in professionList" :key="index"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="性别">
            <el-radio-group v-model="form.sex">
              <el-radio label="男"></el-radio>
              <el-radio label="女"></el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="register">注 册</el-button>
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
            getCollegeProfession(){
                //获取学院和专业信息
                this.$http.axios({
                    url:'/college/getCollegeProfession',
                    method:'get',
                }).then(resolve=>{

                    this.collegeList = resolve;

                }).catch(err=>{
                    console.log("失败了")
                })
            },
            changeProfession(id){
                //查找专业
                this.form.professionId = '';

                this.$http.axios({
                    url:'/profession/getProfessionList?id='+id,
                    method:'get',
                }).then(resolve=>{

                    this.professionList = resolve;

                }).catch(err=>{
                    console.log("失败了")
                })

            },
            register(){

                if(this.$fn.hasObjectNull(this.form)){
                    return this.$message.warning("请将信息填完整");
                }


                this.$http.axios({
                    url:'/sysUser/addSysUser',
                    method:'post',
                    data:this.form,
                    json:true
                }).then(resolve=>{
                    this.$message.success("注册完毕");

                    this.$router.push({path:'/loginTop'});

                }).catch(err=>{
                    console.log("失败了")
                })

            }
        },
        computed:{

        },
        created(){
            this.getCollegeProfession();
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
