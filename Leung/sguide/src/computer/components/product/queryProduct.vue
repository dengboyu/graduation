<!-- 组件 -->
<template>
    <div class="tmpl">
        <p class="search">
            <input type="text" placeholder="请输入搜索产品" v-model="searchObj.topSearch"><el-button
                type="primary" icon="el-icon-search" @click="topSearch">搜索</el-button>
        </p>
        <div class="food-main-title">
            <p class="condition">
                <span>筛选条件:</span>
                <el-button type="text" @click="saleSearch" style="margin-left:20px;color:#666">销 量</el-button>
                <span style="margin-left:30px;margin-right:5px;">价格:</span>
                <input type="number" v-model="searchObj.beginPrice"> -
                <input type="number" v-model="searchObj.endPrice">
            </p>
            <p>
                <span>智能推荐:</span>
                <el-button type="text" @click="intelSearch" style="margin-left:20px;color:#e67e37;">购 物</el-button>
            </p>
            <p>
                <span>搜索条件:</span>
                <span v-text="searchObj.asideSearchData" style="margin-left: 20px;"></span>
            </p>
        </div>
        <div class="food-main">
            <p class="has-nothing" v-if="foodDetails.length>0?false:true">没有相关的产品</p>
            <div v-else>
                <div  class="food-detail" v-for="(item,index) in foodDetails" @click="goDetail(item.id)">
                    <img :src="item.img">
                    <p style="padding-left:5px">￥<span v-text="item.activityPrice"></span><span class="bayou" v-if="item.isShip==1?true:false">包邮</span><span class="total-pay"><em v-text="item.saleAccount"></em>人付款</span></p>
                    <p class="food-title-detail" v-text="item.productName"></p>
                </div>
                <p class="pagination">
                    <el-pagination background layout="prev, pager, next" @current-change="handleCurrentChange" :page-size="searchObj.pageSize" :total="total"></el-pagination>
                </p>
            </div>
        </div>
    </div>
</template>

<!-- 组件导出 -->
<script>
    import Bus from '../public/bus.js'
    export default{
        data(){
            return {
                foodDetails:[],
                searchObj:{
                    pageStart:1,
                    pageSize:8,
                    asideSearchData:'全部',
                    topSearch:'',
                    saleAmount:'',
                    beginPrice:'',
                    endPrice:'',
                    intelSearch:'',
                },
                total:0,
            }
        },
        methods:{
            goDetail(paramId){
                this.$router.push({name:'detail',params:{id:paramId}});
            },
            saleSearch(){
                this.searchObj.saleAmount=1;
                this.searchObj.asideSearchData='全部';
                this.searchObj.topSearch='';
                this.searchObj.beginPrice='';
                this.searchObj.endPrice='';
                this.searchObj.intelSearch='';
                this.search();
            },
            intelSearch(){

                this.searchObj.intelSearch=1;
                this.searchObj.saleAmount='';
                this.searchObj.asideSearchData='全部';
                this.searchObj.topSearch='';
                this.searchObj.beginPrice='';
                this.searchObj.endPrice='';

                this.search();
            },
            topSearch(){
                this.searchObj.saleAmount='';
                this.searchObj.intelSearch='';
                this.search();
            },
            search(){

                this.$http.axios({
                    url:'/product/getProductList',
                    method:'get',
                    params:this.searchObj,
                }).then(resolve=>{
                    if(resolve.productList.length>0){
                        for(let i in resolve.productList){
                            resolve.productList[i].img='/shopGuide/product/downLoadFile?fileName='+resolve.productList[i].img;
                        }
                    }
                    this.foodDetails = resolve.productList;
                    this.total = resolve.total;

                }).catch(err=>{
                    console.log("失败了")
                })
            },
            handleCurrentChange(val){
                this.searchObj.pageStart = val;
                this.search();
            }

        },
        created(){
            this.search();
        },
        mounted(){
            Bus.$on('search', (e) => {
                this.searchObj.asideSearchData=e;
            })
        },
        components:{

        },
    }
</script>

<!-- 本组件样式 -->
<style scoped>
    .el-main .search{
        height:80px;
        line-height: 80px;
    }
    .el-main .search input{
        width: 685px;
        height: 36px;
        color:#000;
        outline: 0 none;
        border:2px solid #ff4040;
        border-top-left-radius: 4px;
        border-bottom-left-radius: 4px;
        padding-left: 15px;
        font-size: 14px;
        line-height: 36px;
        margin-left:18%;
    }
    .search .el-button{
        background-color: #ff4040;
        border-color: #ff4040;
        border-top-left-radius: 0px;
        border-bottom-left-radius: 0px;
    }
    .food-main-title{
        height: 90px;
        line-height: 40px;
        margin-left: 146px;
        margin-bottom: 20px;
        width: 76.3%;
        padding-left: 14px;
        border: 2px solid #bfb6b6;
    }
    .food-main-title p{
        height:30px;
        line-height: 30px;
    }
    .food-main{
        padding-left:12%;
        min-height:200px;
    }
    .food-detail{
        width:220px;
        min-height:220px;
        border:1px solid #666;
        display: inline-block;
        margin-right:20px;
        margin-bottom: 30px;
        cursor: pointer;
    }
    .food-detail img{
        width: 220px;
        height:220px;
    }
    .bayou{
        font-size: 12px;
        margin-left:5px;
        padding:1px;
        background-color: #e67e37;
    }
    .total-pay{
        font-size: 13px;
        margin-left:80px;
    }
    .food-title-detail{
        font-size:13px;
        padding-left:7px;
        white-space: nowrap;
        text-overflow: ellipsis;
        overflow:hidden;
    }
    .pagination{
        margin-right:150px;
        text-align: right;
    }
    .has-nothing{
        height: 200px;
        line-height: 200px;
        margin-left: 37%;
        font-size: 16px;
        letter-spacing: 1px;
    }
    .food-main-title .condition input{
        width: 60px;
        outline: 1px solid #e67e37;
        height: 20px;
        border: 0 none;
        text-indent: 5px;
    }
</style>
