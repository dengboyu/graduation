<!-- 组件 -->
<template>
    <div class="tmpl">
        <p class="hasOrder">购物车:</p>
        <p v-if="total>0?false:true" class="no-shop">购物车暂无产品</p>
        <div v-else>
            <div class="shop-detail" v-for="(item,index) in shopList">
                <p>店铺: &nbsp;<span v-text="item.nick"></span></p>
                <p>商品名称: &nbsp;<span v-text="item.productName"></span></p>
                <p>单价: &nbsp;￥<span v-text="item.centPrice"></span></p>
                <p>标签: &nbsp;<span v-text="item.tag"></span></p>
                <div class="buy">
                    <el-button type="info" @click="deleteShopEntity(item.id)">删除</el-button>
                    <el-button type="success" @click="goSureShop(item.productId)">购买</el-button>
                </div>
            </div>
            <p class="pagination" style="margin-left:400px">
                <el-pagination background layout="prev, pager, next" @current-change="handleCurrentChange" :page-size="pageSize" :total="total"></el-pagination>
            </p>
        </div>
    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {
                total:0,
                pageSize:4,
                shopList:[],
            }
        },
        methods:{
            getShopCarList(pageStart,pageSize){

                this.$http.axios({
                    url:'/shop/getShopCarList',
                    method:'get',
                    params:{pageStart:pageStart,pageSize:pageSize},
                }).then(resolve=>{
                    this.shopList = resolve.mapList;
                    this.total = resolve.totalAccount;
                }).catch(err=>{
                    console.log("失败了")
                })
            },
            handleCurrentChange(val){
                this.getShopCarList(val,this.pageSize);
            },
            deleteShopEntity(id){

                this.$http.axios({
                    url:'/shop/deleteShopEntity',
                    method:'post',
                    data:{id:id}
                }).then(resolve=>{
                    this.$message.success('删除成功');
                    this.getShopCarList(1,this.pageSize);
                }).catch(err=>{
                    console.log("失败了")
                })

            },
            goSureShop(id){
                this.$router.push({name:'detail',params:{id:id}});
            }
        },
        components:{

        },
        created(){
            this.getShopCarList(1,this.pageSize);
        }
    }
</script>

<!-- 本组件样式 -->
<style scoped>
    .tmpl{
        width:80%;
        margin:10px auto;
        height:200px;
        position: relative;
    }
    .hasOrder{
        height: 40px;
        line-height: 40px;
        font-size: 16px;
        padding-left: 10px;
    }
    .shop-detail{
        width:800px;
        border:1px solid #666;
        height: 110px;
        margin-bottom: 20px;
    }
    .shop-detail p span{
        color:#212020
    }
    .shop-detail p {
        padding-left:10px;
        margin-top:5px;
    }
    .buy{
        position: relative;
        top: -65px;
        left: 78%;
    }
    .el-form span{
        color:#000;
    }
    .no-shop{
        width: 100%;
        background-color: #e6e6e6;
        height: 30px;
        line-height: 30px;
        text-align: center;
    }
</style>
