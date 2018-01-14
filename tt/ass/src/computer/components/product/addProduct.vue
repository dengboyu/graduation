<!-- 组件 -->
<template>
    <div class="tmpl editProduct">
        <span style="margin-left:290px;margin-bottom:10px;display:inline-block">添加产品</span>
        <el-form ref="form" :model="form" label-width="90px" :inline="true">
            <el-form-item label="产品名称">
                <el-input v-model="form.name"></el-input>
            </el-form-item>
            <el-form-item label="产品分类">
                <el-select v-model="form.region" placeholder="请选择产品分类" style="width:95%;">
                    <el-option label="分类一" value="shanghai"></el-option>
                    <el-option label="分类二" value="beijing"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="产品规格">
                <el-input v-model="form.phone"></el-input>
            </el-form-item>
            <el-form-item label="产品编号" >
                <el-input v-model="form.linkname"></el-input>
            </el-form-item>
            <el-form-item label="单位">
                <el-input v-model="form.linkname"></el-input>
            </el-form-item>
            <el-form-item label="成本价">
                <el-input v-model="form.telPhone"></el-input>
            </el-form-item>
            <el-form-item label="单价">
                <el-input v-model="form.telPhone"></el-input>
            </el-form-item>
            <el-form-item label="备注">
                <el-input type="textarea" v-model="form.desc" style="margin-top: 5px;width: 161px;"></el-input>
            </el-form-item>
            <el-form-item style='width:100%'>
                <el-button type="primary" @click="onSubmit" style="margin-top: 30px;margin-left: 220px;">保存</el-button>
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
                  desc: '',
                  region:null,
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
        top: 20%;
        left: 25%;
        width: 680px;
        height: 380px;
        background: #65c0e8;
    }

</style>
