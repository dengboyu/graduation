<!-- 组件 -->
<template>
    <div class="tmpl-update">
        <p class="img-top"><img src="../../../assets/img/p1.png" height="50" width="50"><span>添加系统好友</span></p>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="学号">
            <el-input v-model="form.name"  class="input-width" placeholder="请输入学号"></el-input>
          </el-form-item>
          <div v-if="friend">
              <el-form-item label="姓名">
                <span v-text="form.name"></span>
              </el-form-item>
              <el-form-item label="邮箱">
                <span v-text="form.name"></span>
              </el-form-item>
              <el-form-item label="手机号">
                <span v-text="form.name"></span>
              </el-form-item>
              <el-form-item label="分组">
                <span v-text="form.name"></span>
              </el-form-item>
              <el-form-item label="学院">
                <span v-text="form.name"></span>
              </el-form-item>
              <el-form-item label="专业">
                <span v-text="form.name"></span>
              </el-form-item>
              <el-form-item label="性别">
                <span v-text="form.name"></span>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="">添 加</el-button>
              </el-form-item>
          </div>
          <div v-else class="not-friend">系统没有该用户</div>
        </el-form>
    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {
                friend:false,
                form: {
                    name: '',
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
    .not-friend{
        width: 100%;
        height: 30px;
        line-height: 30px;
        padding: 0px 180px;
    }
</style>
