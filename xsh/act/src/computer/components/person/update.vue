<!-- 组件 -->
<template>
    <div class="tmpl-update">
        <p class="img-top"><img src="../../../assets/img/p1.png" height="50" width="50"><span>修改信息</span></p>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="学号">
            <span v-text="form.name"></span>
          </el-form-item>
          <el-form-item label="姓名">
            <el-input v-model="form.name" type="password" class="input-width"></el-input>
          </el-form-item>
          <el-form-item label="邮箱">
            <el-input v-model="form.name" class="input-width"></el-input>
          </el-form-item>
          <el-form-item label="手机号">
            <el-input v-model="form.name" class="input-width"></el-input>
          </el-form-item>
          <el-form-item label="学院">
            <el-select v-model="form.region" placeholder="请选择学院">
              <el-option label="区域一" value="shanghai"></el-option>
              <el-option label="区域二" value="beijing"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="专业">
            <el-select v-model="form.region" placeholder="请选择专业">
              <el-option label="区域一" value="shanghai"></el-option>
              <el-option label="区域二" value="beijing"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="性别">
            <el-radio-group v-model="form.resource">
              <el-radio label="男"></el-radio>
              <el-radio label="女"></el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="">修 改</el-button>
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
                    name: '姓名',
                    region: '',
                    date1: '',
                    date2: '',
                    delivery: false,
                    type: [],
                    resource: '',
                    desc: ''
                }
            }
        },
        methods:{

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
