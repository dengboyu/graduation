<!-- 组件 -->
<template>
    <div class="tmpl">
        <p class="result">报价单统计结果</p>
        <el-table ref="multipleTable" border :data="tableData3" tooltip-effect="dark" style="width: 100%" @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55"></el-table-column>
            <el-table-column label="报价单编号" width="120">
                <template slot-scope="scope">{{ scope.row.date }}</template>
            </el-table-column>
            <!-- <el-table-column prop="name" label="报价单名称" width="240"></el-table-column> -->
            <el-table-column prop="name" label="报价人" ></el-table-column>
            <el-table-column prop="name" label="报价日期" ></el-table-column>
            <el-table-column prop="name" label="总金额" ></el-table-column>
            <el-table-column prop="name" label="成本价" ></el-table-column>
            <el-table-column prop="name" label="利润" ></el-table-column>
            <el-table-column prop="name" label="公司名称" ></el-table-column>
            <el-table-column prop="name" label="联系人" ></el-table-column>
            <el-table-column prop="name" label="状态" ></el-table-column>
            <el-table-column prop="name" label="发送" ></el-table-column>
            <el-table-column prop="date" label="创建时间"></el-table-column>
            <el-table-column label="查看详情" width="100">
                <template slot-scope="scope">
                    <el-button @click="handleClick(scope.row)" type="text" size="small" width="60">查看</el-button>
                </template>
            </el-table-column>
        </el-table>

        <el-dialog :visible.sync="dialogVisible" width="70%">
            <detail-quotation></detail-quotation>
        </el-dialog>

    </div>
</template>

<!-- 组件导出 -->
<script>
    import detailQuotation from './detailQuotation.vue'
    export default{
        data(){
            return {
                tableData3: [
                    {
                        date: '1093222',
                        name: 'oracle公司报价单',
                        address: '上海市普陀区金沙江路 1518 弄',
                        date:'2017-09-02'
                    }
                ],
                multipleSelection: [],
                dialogVisible:false
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
            handleClick(){
                this.dialogVisible=true;
            }
        },
        components:{
            detailQuotation,
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
