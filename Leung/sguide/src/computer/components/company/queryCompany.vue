<!-- 组件 -->
<template>
    <div class="tmpl">
        <p class="info">企业信息管理</p>
        <div class="inputLen add-product">
            <el-form ref="form" :model="form" label-width="80px">
                <el-form-item label="公司名称">
                    <el-input v-model="form.name" v-if="hasInfo"></el-input>
                    <span v-text="form.name" v-else></span>
                </el-form-item>
                <el-form-item label="联系人">
                    <el-input v-model="form.name" v-if="hasInfo"></el-input>
                    <span v-text="form.name" v-else></span>
                </el-form-item>
                <el-form-item label="联系地址">
                    <el-input v-model="form.name" v-if="hasInfo"></el-input>
                    <span v-text="form.name" v-else></span>
                </el-form-item>
                <el-form-item label="手机号">
                    <el-input v-model="form.name" type="number" v-if="hasInfo"></el-input>
                    <span v-text="form.name" v-else></span>
                </el-form-item>
                <el-form-item label="座机">
                    <el-input v-model="form.name" v-if="hasInfo"></el-input>
                    <span v-text="form.name" v-else></span>
                </el-form-item>
                <el-form-item>
                    <el-button style="margin-left:100px;margin-top:20px" type="primary" @click="onSubmit">{{hasInfo?"提交信息":"修改信息"}}</el-button>
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
                hasInfo:false,
                form: {
                    name: '公司名称',
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
        methods: {
            onSubmit() {

                if(this.hasInfo){
                    //提交信息


                }
                this.hasInfo = !this.hasInfo;
            }
        },
        components:{

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
