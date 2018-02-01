<!-- 组件 -->
<template>
    <div class="tmpl">
        <p class="info">添加产品信息</p>
        <div class="inputLen add-product">
            <el-form ref="form" :model="form" label-width="80px">
                <el-form-item label="产品名称">
                    <el-input v-model="form.productName"></el-input>
                </el-form-item>
                <el-form-item label="产品类型" class="productType">
                    <el-select v-model="form.tag" placeholder="请选择产品类型">
                        <el-option v-for="(item,index) in tags" :label="item" :value="item" :key="index"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="产品数量">
                    <el-input v-model="form.productAmount" type="number"></el-input>
                </el-form-item>
                <el-form-item label="产品单价">
                    <el-input v-model="form.centPrice" type="number"></el-input>
                </el-form-item>
                <el-form-item label="产品原价">
                    <el-input v-model="form.originPrice" type="number"></el-input>
                </el-form-item>
                <el-form-item label="促销价格">
                    <el-input v-model="form.activityPrice" type="number"></el-input>
                </el-form-item>
                <el-form-item label="广告价">
                    <el-input v-model="form.advPrice" type="number" placeholder="50元竞标提高1%%排名"></el-input>
                </el-form-item>
                <el-form-item label="产品简介">
                    <el-input class="pro-intro" v-model="form.productIntro" type="textarea"></el-input>
                </el-form-item>
                <el-form-item label="是否包邮">
                    <el-switch v-model="form.isShip"></el-switch>
                </el-form-item>
                <el-form-item label="宣传图片">
                    <el-upload
                         :http-request="upload"
                          class="upload-demo"
                          name="file"
                          action=""
                          :limit="1"
                          ref="upload">
                          <el-button size="small" type="primary">点击上传</el-button>
                          <div slot="tip" class="el-upload__tip">只能上传jpg/png文件</div>
                    </el-upload>
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
                    productIntro: '',
                    productName:'',
                    tag:'',
                    centPrice: '',
                    productAmount: '',
                    originPrice: '',
                    activityPrice: '',
                    isShip: false,
                    img: '',
                    advPrice:'',
                },
                tags:[
                    "食品 / 酒 / 生鲜",
                    "母婴 / 玩具 / 童装",
                    "宠物 / 纸巾 / 厨卫清洁",
                    "家居 / 家纺 / 家装",
                    "美妆个人清洁",
                    "女装 / 男装 / 内衣 / 珠宝",
                    "鞋靴 / 箱包 / 运动户外",
                    "手机 / 数码 / 电脑办公",
                    "家用电器 / 汽车用品",
                    "医药 / 保健滋补",
                    "图书"
                ]
            }
        },
        methods: {
            onSubmit() {
                if(this.form.isShip){
                    this.form.isShip='1';
                }else{
                    this.form.isShip='0';
                }

                if(this.$fn.hasObjectNull(this.form)) {

                    if(this.form.isShip=='1'){
                        this.form.isShip = true;
                    }else{
                        this.form.isShip = false;
                    }

                    return this.$message.warning('请将产品信息填完整');
                }


                this.$http.axios({
                    url:'/product/insertProductEntity',
                    method:'post',
                    data:this.form,
                    json:true,
                }).then(resolve=>{

                    this.$message.success('添加成功');

                    this.form.productIntro= '';
                    this.form.productName='';
                    this.form.tag='';
                    this.form.centPrice='';
                    this.form.productAmount= '';
                    this.form.originPrice='';
                    this.form.activityPrice= '';
                    this.form.isShip=false,
                    this.form.img='';
                    this.form.advPrice='';

                    this.$refs.upload.clearFiles();

                }).catch(err=>{
                    console.log("失败了")
                })


            },
            upload(item){
                let formData = new FormData();
                formData.append("file", item.file);

                this.$http.updaloadExcel({
                    url:'/product/parseProductImg',
                    method:'post',
                    data:formData,
                }).then(resolve=>{
                    this.form.img = resolve.data.data;

                }).catch(err=>{
                    console.log("失败了")
                })
            }
        },
        components:{

        },
        created(){


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
        height: 600px;
        border: 1px solid #d3dce7;
        margin-left: 20%;
        margin-top: 30px;
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
    .pro-intro{
        margin-top:3px;
        width:361px;
    }

</style>
