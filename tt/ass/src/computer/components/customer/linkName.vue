<!-- 组件 -->
<template>
    <div class="tmpl editProduct">
        <span style="margin-left:290px;margin-bottom:10px;display:inline-block">添加客户信息</span>
        <el-form ref="form" :model="form" label-width="90px" :inline="true">
            <el-form-item label="公司名称" style="width:39.5%">
                <el-select v-model="value" placeholder="请选择">
                    <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="联系人姓名">
                <el-input v-model="form.address"></el-input>
            </el-form-item>
            <el-form-item label="职务">
                <el-input v-model="form.phone"></el-input>
            </el-form-item>
            <el-form-item label="性别" >
                <el-input v-model="form.linkname"></el-input>
            </el-form-item>
            <el-form-item label="手机号码">
                <el-input v-model="form.linkname"></el-input>
            </el-form-item>
            <el-form-item label="联系电话">
                <el-input v-model="form.telPhone"></el-input>
            </el-form-item>
            <el-form-item label="旺旺号码">
                <el-input v-model="form.telPhone"></el-input>
            </el-form-item>
            <el-form-item label="传真号码">
                <el-input v-model="form.telPhone"></el-input>
            </el-form-item>
            <el-form-item label="QQ">
                <el-input v-model="form.telPhone"></el-input>
            </el-form-item>
            <el-form-item label="MSN">
                <el-input v-model="form.telPhone"></el-input>
            </el-form-item>
            <el-form-item label="联系地址">
                <el-input v-model="form.telPhone"></el-input>
            </el-form-item>
            <el-form-item label="Email">
                <el-input v-model="form.telPhone"></el-input>
            </el-form-item>
            <el-form-item label="备注">
                <el-input type="textarea" v-model="form.desc" style="margin-top: 5px;width: 161px;"></el-input>
            </el-form-item>
            <el-form-item style='width:100%'>
                <el-button type="primary" @click="onSubmit" style="margin-top: 30px;margin-left: 220px;">保存</el-button>
                <el-button type="primary" @click="reset">取消</el-button>
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
                },
                options: [{
                  value: '选项1',
                  label: '黄金糕'
                }, {
                  value: '选项2',
                  label: '双皮奶'
                }, {
                  value: '选项3',
                  label: '蚵仔煎'
                }, {
                  value: '选项4',
                  label: '龙须面'
                }, {
                  value: '选项5',
                  label: '北京烤鸭'
                }],
                value: '',
                input:null,
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
        height: 420px;
        background: #65c0e8;
    }

</style>
