<!-- 组件 -->
<template>
    <div class="tmpl">
        <span style="margin-left:160px;margin-bottom:10px;display:inline-block">添加公司</span>
        <el-form ref="form" :model="form" label-width="90px">
            <el-form-item label="公司名称">
                <el-input v-model="form.name"></el-input>
            </el-form-item>
            <el-form-item label="联系电话">
                <el-input v-model="form.phone"></el-input>
            </el-form-item>
            <el-form-item label="联系人">
                <el-input v-model="form.linkname"></el-input>
            </el-form-item>
            <el-form-item label="传真号码">
                <el-input v-model="form.telPhone"></el-input>
            </el-form-item>
             <el-form-item label="企业邮箱">
                <el-input v-model="form.telPhone"></el-input>
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
                  name: '',
                  address: '',
                  phone: '',
                  telPhone: '',
                  delivery: false,
                  type: [],
                  linkname: '',
                  desc: ''
                }
            }
        },
        methods:{
            onSubmit() {
                console.log('submit!');
            },
            handleRemove(file, fileList) {
                console.log(file, fileList);
              },
              handlePreview(file) {
                console.log(file);
              },
              handleExceed(files, fileList) {
                this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
              },
              beforeRemove(file, fileList) {
                return this.$confirm(`确定移除 ${ file.name }？`);
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
