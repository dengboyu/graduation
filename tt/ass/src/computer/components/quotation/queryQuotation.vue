<!-- 组件 -->
<template>
    <div class="tmpl">
        <p class="result">报价单统计结果</p>
        <el-table ref="multipleTable" border :data="tableData3" tooltip-effect="dark" style="width: 90%;margin-left:5%" @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55"></el-table-column>
            <el-table-column label="报价单编号" width="140">
                <template slot-scope="scope">{{ scope.row.quoNum }}</template>
            </el-table-column>
            <!-- <el-table-column prop="name" label="报价单名称" width="240"></el-table-column> -->
            <el-table-column prop="quoName" label="报价人" width="120"></el-table-column>
            <el-table-column prop="quoTime" label="报价日期" width="120"></el-table-column>
            <el-table-column prop="totalPrice" label="总金额" width="80"></el-table-column>
            <el-table-column prop="cent" label="单位" width="80"></el-table-column>
            <el-table-column prop="comName" label="公司名称" ></el-table-column>
            <el-table-column prop="linkName" label="联系人" width="140"></el-table-column>
            <el-table-column prop="createTime" label="创建时间" width="160"></el-table-column>
            <el-table-column label="查看详情" width="100">
                <template slot-scope="scope">
                    <el-button @click="handleClick(scope.row)" type="text" size="small" width="60">查看</el-button>
                </template>
            </el-table-column>
        </el-table>

        <el-dialog :visible.sync="dialogVisible" width="70%">
            <detail-quotation :quotationVo="quotationVo"></detail-quotation>
        </el-dialog>

    </div>
</template>

<!-- 组件导出 -->
<script>
    import detailQuotation from './detailQuotation'
    export default{
        data(){
            return {
                tableData3: [],
                multipleSelection: [],
                dialogVisible:false,
                quotationVo:{},
            }
        },
        methods:{
            toggleSelection(rows) {
                if (rows) {
                  rows.forEach(row => {
                    this.$refs.multipleTable.toggleRowSelection(row);
                  });
                } else {
                  this.$refs.multipleTable.clearSelection();
                }
            },
            handleSelectionChange(val) {
                this.multipleSelection = val;
            },
            handleClick(row){

                    this.$http.axios({
                        url:'/quotation/getQuotationDetail?id='+row.id,
                        method:'get',
                    }).then(resolve=>{
                        this.quotationVo = resolve;
                        this.dialogVisible=true;
                    }).catch(err=>{

                    })
            },
            getQuatationList(){

                this.$http.axios({
                    url:'/quotation/getQuotationList',
                    method:'get',
                }).then(resolve=>{
                    this.tableData3 = resolve;
                }).catch(err=>{
                    console.log("失败了")
                })
            }
        },
        components:{
            detailQuotation,
        },
        created(){
            this.getQuatationList();
        }
    }
</script>

<!-- 本组件样式 -->
<style scoped>
    .addProduct{
        margin-top: 10px;
        margin-bottom: 10px;
        margin-left: 75%;
    }
    .result{
        height: 30px;
        line-height: 30px;
        margin-left: 46%;
        margin-bottom: 10px;
        margin-top: 10px;
    }
</style>
