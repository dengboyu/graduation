<!-- 组件 -->
<template>
    <div class="tmpl">
        <div class="main_top">
            <p>
                <span>电话:</span>&nbsp;&nbsp;<span class="phone" v-text="quotationVo.quotationEntity.quoPhone"></span>
                <span style="margin-left:20px">传真:</span>&nbsp;&nbsp;<span class="chuanzhen" v-text="quotationVo.quotationEntity.quoFax"></span>
            </p>
            <p class="baojia">报价单</p>
        </div>
        <p class="orderNum">单号:&nbsp;&nbsp;<span v-text="quotationVo.quotationEntity.quoNum"></span></p>
        <div class="main">
            <div class="company">
                <p>
                    公&nbsp;&nbsp;&nbsp;司:<span class="fontContent" v-text="quotationVo.comName"></span>
                    <span style="margin-left:100px">联系人:</span><span class="fontContent" v-text="quotationVo.quotationEntity.linkName"></span>
                </p>
                <p>
                    电&nbsp;&nbsp;&nbsp;话:<span class="fontContent" v-text="quotationVo.quotationEntity.phone"></span>
                    <span style="margin-left:100px">传&nbsp;&nbsp;&nbsp;真:</span><span class="fontContent" v-text="quotationVo.quotationEntity.fax"></span>
                </p>
                <p>
                    邮&nbsp;&nbsp;&nbsp;箱:<span class="fontContent" v-text="quotationVo.quotationEntity.email"></span>
                    <span style="margin-left:100px">地&nbsp;&nbsp;&nbsp;址:</span><span class="fontContent" v-text="quotationVo.quotationEntity.address"></span>
                </p>
                <p>
                    报价人:<span class="fontContent" v-text="quotationVo.quotationEntity.quoName"></span>
                    <span style="margin-left:100px">日&nbsp;&nbsp;&nbsp;期:</span><span class="fontContent" v-text="quotationVo.quotationEntity.quoTime"></span>
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
                        <tr v-for="(item,index) in quotationVo.quoProductEntityList" :key="index">
                            <td v-text="index+1"></td>
                            <td v-text="item.proName"></td>
                            <td v-text="item.norm"></td>
                            <td v-text="item.num"></td>
                            <td v-text="item.cent"></td>
                            <td v-text="item.centPrice"></td>
                            <td v-text="item.totalPrice"></td>
                            <td v-text="item.remark"></td>
                        </tr>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td colspan="9" style="text-align:right;padding-right:20px;">
                                <span>币种:</span>&nbsp;&nbsp;<span v-text="quotationVo.quotationEntity.cent"></span>
                                <span style="margin-left:20px">运费:</span>&nbsp;&nbsp;<span v-text="quotationVo.quotationEntity.transport"></span>
                                <span style="margin-left:20px">总计:</span>&nbsp;&nbsp;<span v-text="quotationVo.quotationEntity.totalPrice"></span>
                            </td>
                        </tr>
                        <tr>
                            <td>备<br>注</td>
                            <td colspan="8" style="height:100px" v-text="quotationVo.quotationEntity.remark"></td>
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
            return {}
        },
        props:['quotationVo'],
        methods:{

        },
        components:{

        },
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
