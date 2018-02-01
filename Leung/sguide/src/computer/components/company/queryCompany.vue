<!-- 组件 -->
<template>
    <div class="tmpl">
        <p class="info">企业信息管理</p>
        <div class="inputLen add-product">
            <el-form ref="form" :model="form" label-width="80px">
                <el-form-item label="店铺名称">
                    <span v-text="form.nick"></span>
                </el-form-item>
                <el-form-item label="账户余额">
                    <span v-text="form.companyPrice"></span>&nbsp;&nbsp;元
                </el-form-item>
                <el-form-item label="公司名称">
                    <el-input v-model="form.companyName" v-if="hasInfo"></el-input>
                    <span v-text="form.companyName" v-else></span>
                </el-form-item>
                <el-form-item label="联系人">
                    <el-input v-model="form.linkName" v-if="hasInfo"></el-input>
                    <span v-text="form.linkName" v-else></span>
                </el-form-item>
                <el-form-item label="联系地址">
                    <el-input v-model="form.companyAddress" v-if="hasInfo"></el-input>
                    <span v-text="form.companyAddress" v-else></span>
                </el-form-item>
                <el-form-item label="企业邮箱">
                    <el-input v-model="form.email" v-if="hasInfo"></el-input>
                    <span v-text="form.email" v-else></span>
                </el-form-item>
                <el-form-item label="手机号">
                    <el-input v-model="form.phone" type="tel" :maxlength="11" v-if="hasInfo"></el-input>
                    <span v-text="form.phone" v-else></span>
                </el-form-item>
                <el-form-item label="座机">
                    <el-input v-model="form.telPhone" v-if="hasInfo"></el-input>
                    <span v-text="form.telPhone" v-else></span>
                </el-form-item>
                <el-form-item>
                    <el-button style="margin-left:100px;margin-top:20px" type="primary" @click="onSubmit" v-text="sureButn"></el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {
                sureButn:'提交',
                hasInfo:true,
                form: {}
            }
        },
        methods: {
            onSubmit() {

                if(this.sureButn=='提交'){
                    if(this.form.companyName==null || this.form.companyAddress==null || this.form.linkName==null || this.form.telPhone==null)
                        return this.$message.warning('请将信息填写完毕');

                    this.$http.axios({
                        url:'/userInfo/updateUserInfoEntity',
                        method:'post',
                        data:this.form,
                        json:true,
                    }).then(resolve=>{
                        this.hasInfo = !this.hasInfo;
                        this.$message.success('修改完毕');
                        this.sureButn='修改';
                    }).catch(err=>{
                        console.log("失败了")
                    })
                }else{
                    this.hasInfo = !this.hasInfo;
                    this.sureButn='提交';
                }
            },
            getUserInfo(){
                this.$http.axios({
                    url:'/userInfo/getUserInfoEntity',
                    method:'get',
                }).then(resolve=>{

                    if(resolve.telPhone){
                        this.hasInfo = !this.hasInfo;
                        this.sureButn='修改';
                    }
                    this.form = resolve;
                }).catch(err=>{
                    console.log("失败了")
                })
            },
        },
        components:{

        },
        created(){
            this.getUserInfo();
        }
    }
</script>

<!-- 本组件样式 -->
<style scoped>
    .tmpl .info{
        height: 40px;
        line-height: 40px;
        background-color: #a79b9b;
        margin-top: 20px;
        text-indent: 126px;
        width: 20%;
    }
    .tmpl .add-product{
        width: 60%;
        height: 500px;
        border: 1px solid #d3dce7;
        margin-left: 20%;
        margin-top: 60px;
    }
    .tmpl .add-product .el-form{
        width:80%;
        margin:20px auto;
    }
    .el-form-item{
        margin-bottom:0px;
    }
    .tmpl .add-product .el-form .el-select{
        width:362px;
    }
</style>
