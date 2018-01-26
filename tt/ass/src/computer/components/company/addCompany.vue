<!-- 组件 -->
<template>
    <div class="tmpl">
        <span style="margin-left:160px;margin-bottom:10px;display:inline-block">添加公司</span>
        <el-form ref="form" :model="form" label-width="90px">
            <el-form-item label="公司名称">
                <el-input v-model="form.comName"></el-input>
            </el-form-item>
            <el-form-item label="联系电话">
                <el-input v-model="form.linkPhone" :maxlength="11"></el-input>
            </el-form-item>
            <el-form-item label="联系人">
                <el-input v-model="form.linkName"></el-input>
            </el-form-item>
            <el-form-item label="传真号码">
                <el-input v-model="form.fax" :maxlength="12"></el-input>
            </el-form-item>
             <el-form-item label="企业邮箱">
                <el-input v-model="form.email"></el-input>
            </el-form-item>
            <el-form-item label="联系地址">
                <el-input v-model="form.address"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit" style="margin-top: 30px;margin-left: 30px;">保存</el-button>
                <el-button type="primary" @click="reset">清空</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<!-- 组件导出 -->
<script>
    import addCompanyCss from '../../../assets/css/addCompany.css'
    export default{
        data(){
            return {
                fileList: [],
                form: {
                  comName: '',
                  address: '',
                  linkPhone: '',
                  fax: '',
                  address:'',
                  email: ''
                }
            }
        },
        methods:{
            onSubmit() {

                if(this.$fn.hasObjectNull(this.form)){
                    this.$message({
                        message: '请将信息填完整',
                        type: 'warning'
                    });
                    return;
                }


                this.$http.axios({
                    url:'/company/insertCompanyEntity',
                    method:'post',
                    data:this.form,
                    json:true,
                }).then(resolve=>{

                    for(let i in this.form){
                        this.form[i]=null;
                    }

                    this.$message({
                        message: '添加完毕',
                        type: 'success'
                    });

                }).catch(err=>{
                    console.log("失败了")
                })
            },
            reset(){
                for(let i in this.form){
                    this.form[i]=null;
                }
            }
        },
        components:{

        }
    }
</script>

<!-- 本组件样式 -->
<style scoped>
    .tmpl{
        position: absolute;
        padding-top: 20px;
        top: 30%;
        left: 35%;
        width: 380px;
        height: 380px;
        background: #65c0e8;
    }

</style>
