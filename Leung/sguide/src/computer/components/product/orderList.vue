<!-- 组件 -->
<template>
    <div class="tmpl">
        <P class="hasOrder">已买到的宝贝:</P>
        <el-table :data="tableData" style="width: 100%">
            <el-table-column prop="orderId" label="订单号" width="120"></el-table-column>
            <el-table-column prop="date" label="日期" width="120"></el-table-column>
            <el-table-column prop="productName"  label="商品名称" width="200"></el-table-column>
            <el-table-column prop="shopName"  label="商家店铺" width="200"></el-table-column>
            <el-table-column prop="cent"  label="单价" width="120"></el-table-column>
            <el-table-column prop="account"  label="数量" width="120"></el-table-column>
            <el-table-column prop="totalPrice"  label="付款金额" width="120"></el-table-column>
        </el-table>
    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {
                tableData: [
                    {
                        orderId:'1209323232',
                        date: '2016-05-02',
                        productName: '美国进口货汽车零售品牌',
                        shopName:'淘宝小店',
                        cent:2,
                        account:2,
                        totalPrice:4,
                    },
                    {
                        orderId:'1209323232',
                        date: '2016-05-02',
                        productName: '美国进口货汽车零售品牌',
                        shopName:'淘宝小店',
                        cent:2,
                        account:2,
                        totalPrice:4,
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
    }
    .hasOrder{
        height: 40px;
        line-height: 40px;
        font-size: 14px;
        padding-left: 10px;
    }
</style>
