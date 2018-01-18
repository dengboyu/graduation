<!-- 组件 -->
<template>
    <div class="tmpl">
        <p class="hasOrder">购物车:</p>
        <div class="shop-detail" v-for="(item,index) in shopList">
            <p>店铺: &nbsp;<span v-text="item.shopName"></span></p>
            <p>商品名称: &nbsp;<span v-text="item.productName"></span></p>
            <p>单价: &nbsp;￥<span v-text="item.cent"></span></p>
            <p>标签: &nbsp;<span v-text="item.tag"></span></p>
            <div class="buy"><el-button type="success">购买</el-button></div>
        </div>
    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {
                shopList:[
                    {
                        shopName:'淘宝小店',
                        productName:'零售汽车店机油',
                        cent:1,
                        tag:'食品 / 酒 / 生鲜'
                    },
                    {
                        shopName:'淘宝小店',
                        productName:'零售汽车店机油',
                        cent:1,
                        tag:'食品 / 酒 / 生鲜'
                    }
                ]
            }
        },
        components:{

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
        width:600px;
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
        left: 80%;
    }
</style>
