<!-- 组件 -->
<template>
    <div class="tmpl">
        <div class="main-top">
            <span class="has-sort">已有产品分类</span>
            <el-select v-model="value" placeholder="请选择">
                <el-option v-for="item in sortList" :key="item.id" :label="item.sortName" :value="item.id"></el-option>
            </el-select>
        </div>
        <hr>
        <div class="main-botton">
            <span style="display:inline-block;margin-right:30px;">添加产品分类</span>
            <el-input style="width:29.5%;" v-model="input" placeholder="请输入产品分类名称"></el-input>
            <el-button type="primary" style="margin-left:40px" @click="addProduct">添加</el-button>
        </div>
    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {
                sortList:[],
                value: '',
                input:null,//产品分类
            }
        },
        components:{

        },
        methods:{
            addProduct(){
                if(this.input==null){
                    this.$message({
                        message: '请输入分类名称',
                        type: 'warning'
                    });
                    return;
                }


                this.$http.axios({
                    url:'/productSort/insertProductSortEntity',
                    method:'post',
                    data:{sortName:this.input},
                    json:true,
                }).then(resolve=>{
                    this.getProductSortList();

                    this.$message({
                        message: '添加成功',
                        type: 'success'
                    });

                    this.input='';
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
            }
        },
        created(){
            this.getProductSortList();
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
    .main-top{
        height:50px;
        margin-left:30px;
    }
    .main-top .has-sort{
        display: inline-block;
        margin-right:30px;
    }
    .main-botton{
        height:50px;
        margin-top:20px;
        margin-left:30px;
    }
</style>
