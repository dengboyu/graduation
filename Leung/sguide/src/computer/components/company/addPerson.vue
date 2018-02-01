<!-- 组件 -->
<template>
    <div class="tmpl">
        <p class="info">个人信息</p>
        <div class="inputLen add-product">
            <el-form ref="form" :model="form" label-width="90px">
                <el-form-item label="昵称">
                    <span v-text="form.nick"></span>
                </el-form-item>
                <el-form-item label="邮箱">
                    <el-input v-model="form.email" v-if="flag"></el-input>
                    <span v-text="form.email" v-else></span>
                </el-form-item>
                <el-form-item label="手机号">
                    <el-input v-model="form.phone" v-if="flag"></el-input>
                    <span v-text="form.phone" v-else></span>
                </el-form-item>
                <el-form-item label="收获人">
                    <el-input v-model="form.harvestPeople" v-if="flag"></el-input>
                    <span v-text="form.harvestPeople" v-else></span>
                </el-form-item>
                <el-form-item label="收获地址">
                    <el-input v-model="form.harvestAddress" v-if="flag"></el-input>
                    <span v-text="form.harvestAddress" v-else></span>
                </el-form-item>
                <el-form-item>
                    <el-button style="margin-left:100px;margin-top:30px;" type="primary" @click="onSubmit" v-text="sureButn"></el-button>
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
                flag:true,
                form: {},
                sureButn:'提交信息'
            }
        },
        methods: {
            onSubmit() {
                if(this.sureButn=='提交信息'){
                    if(this.form.harvestPeople==null || this.form.harvestAddress==null) return this.$message.warning('请将信息填写完毕');

                    this.$http.axios({
                        url:'/userInfo/updateUserInfoEntity',
                        method:'post',
                        data:this.form,
                        json:true,
                    }).then(resolve=>{
                        this.flag = !this.flag;
                        this.$message.suceess('修改完毕');
                        this.sureButn='修改';
                    }).catch(err=>{
                        console.log("失败了")
                    })
                }else{
                    this.flag = !this.flag;
                    this.sureButn='提交信息';
                }

            },
            getUserInfo(){
                this.$http.axios({
                    url:'/userInfo/getUserInfoEntity',
                    method:'get',
                }).then(resolve=>{

                    if(resolve.harvestPeople){
                        this.flag = !this.flag;
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
