<!-- 组件 -->
<template>
    <div class="tmpl">
        <p class="search">
            <input type="text" placeholder="请输入搜索产品"><el-button
                type="primary" icon="el-icon-search" @click="search">搜索</el-button>
        </p>
        <div class="food-main-title">
            <p class="condition">
                <span>筛选条件:</span>
                <el-button type="text" style="margin-left:20px;color:#666">销 量</el-button>
                <span style="margin-left:30px;margin-right:5px;">价格:</span>
                <input type="number"> -
                <input type="number">
            </p>
            <p>
                <span>智能推荐:</span>
                <el-button type="text" style="margin-left:20px;color:#e67e37;">购 物</el-button>
            </p>
            <p>
                <span>搜索条件:</span>
                <span v-text="asideSearchData" style="margin-left: 20px;"></span>
                <span v-text="topSearchData" style="margin-left: 30px;"></span>
            </p>
        </div>
        <div class="food-main">
            <p class="has-nothing" v-if="foodDetails.length>0?false:true">没有相关的产品</p>
            <div v-else>
                <div  class="food-detail" v-for="(item,index) in foodDetails" @click="goDetail">
                    <img :src="item.img">
                    <p style="padding-left:5px">￥<span v-text="item.price"></span><span class="bayou" v-if="item.isPlan==1?true:false">包邮</span><span class="total-pay"><em v-text="item.payAccount"></em>人付款</span></p>
                    <p class="food-title-detail" v-text="item.title"></p>
                </div>
                <p class="pagination">
                    <el-pagination background layout="prev, pager, next" :total="100"></el-pagination>
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
                asideSearchData:'食品 / 酒 / 生鲜',
                topSearchData:'数量',
                foodDetails:[
                    {
                        img:"https://g-search1.alicdn.com/img/bao/uploaded/i4/imgextra/i1/118550965/TB2KBA3dQfb_uJkSne1XXbE4XXa_!!0-saturn_solar.jpg_460x460Q90.jpg_.webp",
                        price:"9.50",
                        isPlan:1,
                        payAccount:0,
                        title:"产品名称产品名称产品名称产品名称产品名称",
                    },
                    {
                        img:"https://g-search1.alicdn.com/img/bao/uploaded/i4/imgextra/i1/118550965/TB2KBA3dQfb_uJkSne1XXbE4XXa_!!0-saturn_solar.jpg_460x460Q90.jpg_.webp",
                        price:"9.50",
                        isPlan:1,
                        payAccount:0,
                        title:"产品名称产品名称产品名称产品名称产品名称",
                    },
                    {
                        img:"https://g-search1.alicdn.com/img/bao/uploaded/i4/imgextra/i1/118550965/TB2KBA3dQfb_uJkSne1XXbE4XXa_!!0-saturn_solar.jpg_460x460Q90.jpg_.webp",
                        price:"9.50",
                        isPlan:1,
                        payAccount:0,
                        title:"产品名称产品名称产品名称产品名称产品名称",
                    },
                    {
                        img:"https://g-search1.alicdn.com/img/bao/uploaded/i4/imgextra/i1/118550965/TB2KBA3dQfb_uJkSne1XXbE4XXa_!!0-saturn_solar.jpg_460x460Q90.jpg_.webp",
                        price:"9.50",
                        isPlan:1,
                        payAccount:0,
                        title:"产品名称产品名称产品名称产品名称产品名称",
                    },
                    {
                        img:"https://g-search1.alicdn.com/img/bao/uploaded/i4/imgextra/i1/118550965/TB2KBA3dQfb_uJkSne1XXbE4XXa_!!0-saturn_solar.jpg_460x460Q90.jpg_.webp",
                        price:"9.50",
                        isPlan:1,
                        payAccount:0,
                        title:"产品名称产品名称产品名称产品名称产品名称",
                    },
                    {
                        img:"https://g-search1.alicdn.com/img/bao/uploaded/i4/imgextra/i1/118550965/TB2KBA3dQfb_uJkSne1XXbE4XXa_!!0-saturn_solar.jpg_460x460Q90.jpg_.webp",
                        price:"9.50",
                        isPlan:1,
                        payAccount:0,
                        title:"产品名称产品名称产品名称产品名称产品名称",
                    },
                    {
                        img:"https://g-search1.alicdn.com/img/bao/uploaded/i4/imgextra/i1/118550965/TB2KBA3dQfb_uJkSne1XXbE4XXa_!!0-saturn_solar.jpg_460x460Q90.jpg_.webp",
                        price:"9.50",
                        isPlan:1,
                        payAccount:0,
                        title:"产品名称产品名称产品名称产品名称产品名称",
                    },
                    {
                        img:"https://g-search1.alicdn.com/img/bao/uploaded/i4/imgextra/i1/118550965/TB2KBA3dQfb_uJkSne1XXbE4XXa_!!0-saturn_solar.jpg_460x460Q90.jpg_.webp",
                        price:"9.50",
                        isPlan:1,
                        payAccount:0,
                        title:"产品名称产品名称产品名称产品名称产品名称",
                    }
                ]
            }
        },
        methods:{
            goDetail(){
                this.$router.push({path:'/index/detail'})
            },
            search(){

            }
        },
        created(){

        },
        mounted(){
            Bus.$on('search', (e) => {
                console.log(e)
                this.asideSearchData=e;
                this.topSearchData=null;
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
