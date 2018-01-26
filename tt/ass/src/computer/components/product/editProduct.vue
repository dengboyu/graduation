<!-- 组件 -->
<template>
    <div class="tmpl editProduct">
        <span style="margin-left:290px;margin-bottom:10px;display:inline-block">产品修改</span>
        <el-form ref="form" :model="form" label-width="90px" :inline="true">
            <el-form-item label="产品名称">
                <el-input v-model="form.proName"></el-input>
            </el-form-item>
            <el-form-item label="产品分类">
                <el-select v-model="form.sortId" placeholder="请选择产品分类" style="width:95%;">
                    <el-option v-for="item in sortList" :key="item.id" :label="item.sortName" :value="item.id"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="产品规格">
                <el-input v-model="form.norm"></el-input>
            </el-form-item>
            <el-form-item label="产品编号" >
                <el-input v-model="form.proNum"></el-input>
            </el-form-item>
            <el-form-item label="单位">
                <el-input v-model="form.cent"></el-input>
            </el-form-item>
            <el-form-item label="成本价">
                <el-input v-model="form.costPrice"></el-input>
            </el-form-item>
            <el-form-item label="单价">
                <el-input v-model="form.centPrice"></el-input>
            </el-form-item>
            <el-form-item label="备注">
                <el-input type="textarea" v-model="form.remark" style="margin-top: 5px;width: 161px;"></el-input>
            </el-form-item>
            <el-form-item style='width:100%'>
                <el-button type="primary" @click="onSubmit" style="margin-top: 30px;margin-left: 220px;">保存</el-button>
                <!-- <el-button type="primary" @click="reset">取消</el-button> -->
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
                sortList: [],
                form: {}
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
                    url:'/product/updateProductEntity',
                    method:'post',
                    data:this.form,
                    json:true,
                }).then(resolve=>{

                    this.$message({
                        message: '更新成功',
                        type: 'success'
                    });

                    this.$router.push({path:'/index/product'});

                }).catch(err=>{
                    console.log("失败了")
                })
            },
            getProductSortList(){
                this.$http.axios({
                    url:'/productSort/getProductSortList',
                    method:'get',
                }).then(resolve=>{
                    this.sortList = resolve;
                }).catch(err=>{
                    console.log("失败了")
                })
            },
            getProductInfo(){
                this.$http.axios({
                    url:'/product/getProductEntityById?id='+this.$route.params.id,
                    method:'get',
                }).then(resolve=>{

                    this.form = resolve;

                }).catch(err=>{
                    console.log("失败了")
                })
            }
        },
        components:{

        },
        created(){
            this.getProductSortList();
            this.getProductInfo();
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
