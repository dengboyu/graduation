<!-- 组件 -->
<template>
    <div class="tmpl">
        <div class="main_top">
            <p>
                <span>电话:</span>&nbsp;&nbsp;<span class="phone">18432342435</span>
                <span style="margin-left:20px">传真:</span>&nbsp;&nbsp;<span class="chuanzhen">022-323432</span>
            </p>
            <p class="baojia">报价单</p>
        </div>
        <p class="orderNum">单号:&nbsp;&nbsp;201801141234</p>
        <div class="main">
            <div class="company">
                <p>
                    公&nbsp;&nbsp;&nbsp;司:<span class="fontContent">阿里巴巴科技有限公司</span>
                    <span style="margin-left:100px">联系人:</span><span class="fontContent">黄先生</span>
                </p>
                <p>
                    电&nbsp;&nbsp;&nbsp;话:<span class="fontContent">阿里巴巴科技有限公司</span>
                    <span style="margin-left:100px">传&nbsp;&nbsp;&nbsp;真:</span><span class="fontContent">黄先生</span>
                </p>
                <p>
                    邮&nbsp;&nbsp;&nbsp;箱:<span class="fontContent">阿里巴巴科技有限公司</span>
                    <span style="margin-left:100px">地&nbsp;&nbsp;&nbsp;址:</span><span class="fontContent">黄先生</span>
                </p>
                <p>
                    报价人:<span class="fontContent">阿里巴巴科技有限公司</span>
                    <span style="margin-left:100px">日&nbsp;&nbsp;&nbsp;期:</span><span class="fontContent">黄先生</span>
                </p>
                <table>
                    <thead>
                        <tr>
                            <td style="width:8%">编号</td>
                            <td style="width:26%">产品名称</td>
                            <td style="width:8%">规格</td>
                            <td style="width:8%">数量</td>
                            <td style="width:8%">单位</td>
                            <td style="width:8%">单价</td>
                            <td style="width:8%">金额</td>
                            <td style="width:18%">备注</td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(item,index) in tableData3" :key="index">
                            <td v-text="index+1"></td>
                            <td v-text="item.proName"></td>
                            <td v-text="item.guige"></td>
                            <td v-text="item.num"></td>
                            <td v-text="item.cent"></td>
                            <td v-text="item.price"></td>
                            <td v-text="item.totalPrice"></td>
                            <td v-text="item.remark"></td>
                        </tr>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td colspan="9" style="text-align:right;padding-right:20px;">
                                <span>币种:</span>&nbsp;&nbsp;&nbsp;<span>人民币</span>
                                <span style="margin-left:20px">总计:</span>&nbsp;&nbsp;&nbsp;<span>12000</span>
                            </td>
                        </tr>
                        <tr>
                            <td>备<br>注</td>
                            <td colspan="8" style="height:100px"></td>
                        </tr>
                    </tfoot>
                </table>
            </div>
        </div>
    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {
                tableData3: [
                    {
                        proName:"销售苹果",
                        guige:"v-1.0",
                        num:23,
                        cent:'元',
                        price:1,
                        totalPrice:23,
                        remark:null
                    },
                    {
                        proName:"零售专卖店",
                        guige:"v-2.0",
                        num:23,
                        cent:'元',
                        price:1,
                        totalPrice:23,
                        remark:'备注信息'
                    }
                ],
                multipleSelection: []
            }
        },
        methods:{

        },
        components:{

        }
    }
</script>

<!-- 本组件样式 -->
<style scoped>
    .tmpl{
        width:800px;
        min-height:500px;
        background: #fff;
        margin:20px auto;
        color:#000;
        font-weight: bold;
        overflow-y: -webkit-paged-x;
    }
    .main_top{
        height:100px;
    }
    .main_top p{
        height:50px;
        line-height: 50px;
        text-align: center;
    }
    .baojia{
        font-size: 20px;
        letter-spacing: 2px;
    }
    .orderNum{
        font-weight: normal;
        margin-left:76%;
    }
    .main{
        margin:0 auto;
        width:90%;
        padding-top:10px;
    }
    .company p{
        margin-top:5px;
    }
    .fontContent{
        font-weight: normal;
        margin-left:10px;
        width:243px;
        display: inline-block;
        letter-spacing: 1px;
        border-bottom: 1px solid #000;
    }
    .el-table{
        font-size:16px;
    }
    .totalPrie{
        border:1px solid #000;
        border-top-style: none;
        padding-left:70%;
    }
    table {
        width: 100%;
        margin: 0 auto;
        text-align: center;
        margin-top: 13px;
        margin-bottom: 30px;
        border: 1px solid #000;
        font-size: 15px;
        color: #000;
    }
    table tr{
        width: 100%;
        height:27px;
    }
    table  thead tr td {
        font-weight: bold;
    }
    table  tr td {
        border: 1px solid #000;
        font-weight: normal;
    }
</style>
