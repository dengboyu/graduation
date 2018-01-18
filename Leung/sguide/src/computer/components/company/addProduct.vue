<!-- 组件 -->
<template>
    <div class="tmpl">
        <p class="info">添加产品信息</p>
        <div class="inputLen add-product">
            <el-form ref="form" :model="form" label-width="80px">
                <el-form-item label="产品名称">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item label="产品类型" class="productType">
                    <el-select v-model="form.region" placeholder="请选择产品类型">
                        <el-option label="区域一" value="shanghai"></el-option>
                        <el-option label="区域二" value="beijing"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="产品数量">
                    <el-input v-model="form.name" type="number"></el-input>
                </el-form-item>
                <el-form-item label="产品单价">
                    <el-input v-model="form.name" type="number"></el-input>
                </el-form-item>
                <el-form-item label="是否包邮">
                    <el-switch v-model="form.delivery"></el-switch>
                </el-form-item>
                <el-form-item label="宣传图片">
                    <input  type="file"/>
                </el-form-item>
                <el-form-item>
                    <el-button style="margin-left:100px" type="primary" @click="onSubmit">提交信息</el-button>
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
        methods: {
            onSubmit() {
                console.log('submit!');
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
