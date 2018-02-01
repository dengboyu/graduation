<!-- 组件 -->
<template>
    <div class="tmpl">
        <P class="hasOrder">已买到的宝贝:</P>
        <el-table :data="tableData" style="width:100%">
            <el-table-column prop="orderId" label="订单号" width="130"></el-table-column>
            <el-table-column prop="createTime" label="购买日期" width="120"></el-table-column>
            <el-table-column prop="productName"  label="商品名称" width="200"></el-table-column>
            <el-table-column prop="nick"  label="商家店铺" width="200"></el-table-column>
            <el-table-column prop="centPrice"  label="单价" width="120"></el-table-column>
            <el-table-column prop="account"  label="数量" width="120"></el-table-column>
            <el-table-column prop="totalMoney"  label="付款金额" width="80"></el-table-column>
            <el-table-column label="操作" width="80">
                <template slot-scope="scope">
                    <el-button @click="handleClick(scope.row)" v-text="scope.row.isContent==1?'已评论':'评论'" type="text" size="small"></el-button>
                </template>
            </el-table-column>
        </el-table>

        <p class="pagination" style="margin-left:650px;margin-top:20px;" v-if="total>0?true:false">
            <el-pagination background @current-change="handleCurrentChange" layout="prev, pager, next" :page-size="pageSize" :total="total"></el-pagination>
        </p>

        <el-dialog title="售后评论" :visible.sync="contentBoolean" width="40%" class="btnGoShop">
            <el-form ref="form" :model="content" label-width="90px">
                <el-form-item label="售后评价">
                    <el-radio-group v-model="content.score">
                        <el-radio label="较差"></el-radio>
                        <el-radio label="差"></el-radio>
                        <el-radio label="一般"></el-radio>
                        <el-radio label="好"></el-radio>
                        <el-radio label="较好"></el-radio>
                    </el-radio-group>
                </el-form-item>
                <el-form-item label="评论:">
                    <el-input type="textarea" v-model="content.content"></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button type="primary" @click="insertContent">提 交</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {
                content:{
                    content:'',
                    score:'',
                    productId:'',
                },
                contentProductId:'',
                total:0,
                pageSize:5,
                contentBoolean:false,
                tableData: []
            }
        },
        components:{

        },
        methods:{
            insertContent(){
                if(this.$fn.hasObjectNull(this.content)) return this.$message.warning('请把评论信息填完整');


                switch (this.content.score){
                    case "较差":   this.content.score="-1";
                        break;
                    case "差":   this.content.score="0";
                        break;
                    case "一般":   this.content.score="1";
                        break;
                    case "好":   this.content.score="3";
                        break;
                    case "较好":   this.content.score="5";
                        break;
                }

                this.$http.axios({
                    url:'/content/insertContentEntity',
                    method:'post',
                    data:this.content,
                    json:true,
                }).then(resolve=>{
                    this.contentBoolean=!this.contentBoolean;
                    this.$message.success('评论成功');

                    this.getOrderList(1,this.pageSize);

                }).catch(err=>{
                    console.log("失败了")
                })

            },
            handleClick(row){
                if(row.isContent=='0'){
                    this.content.productId = row.productId;
                    this.contentBoolean=!this.contentBoolean;
                }
            },
            getOrderList(pageStart,pageSize){

                this.$http.axios({
                    url:'/orderBase/getOrderList',
                    method:'get',
                    params:{pageStart:pageStart,pageSize:pageSize},
                }).then(resolve=>{
                    this.tableData = resolve.mapList;
                    this.total = resolve.totalAccount;
                }).catch(err=>{
                    console.log("失败了")
                })
            },
            handleCurrentChange(val){
                this.getOrderList(val,this.pageSize);
            }
        },
        created(){
            this.getOrderList(1,this.pageSize);
        }
    }
</script>

<!-- 本组件样式 -->
<style scoped>
    .tmpl{
        width:85%;
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
