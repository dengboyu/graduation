<!-- 组件 -->
<template>
    <div class="tmpl">
        <p class="result">已合作公司</p>
        <el-table ref="multipleTable" border :data="tableData3" tooltip-effect="dark" style="margin-left:15%;width: 70%" @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55"></el-table-column>
            <el-table-column label="公司名称" width="120">
                <template slot-scope="scope">{{ scope.row.date }}</template>
            </el-table-column>
            <el-table-column prop="name" label="联系电话" width="240"></el-table-column>
            <el-table-column prop="name" label="联系人" ></el-table-column>
            <el-table-column prop="name" label="传真号码" ></el-table-column>
            <el-table-column prop="name" label="企业邮箱" ></el-table-column>
            <el-table-column prop="name" label="联系地址"></el-table-column>
            <el-table-column label="修改" width="60">
                <template slot-scope="scope">
                    <el-button @click="handleClick(scope.row)" type="text" size="small" width="60">修改</el-button>
                </template>
            </el-table-column>
          </el-table>
    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {
                tableData3: [{
                      date: '2016-05-03',
                      name: '王小虎',
                      address: '上海市普陀区金沙江路 1518 弄'
                    }, {
                      date: '2016-05-02',
                      name: '王小虎',
                      address: '上海市普陀区金沙江路 1518 弄'
                    }, {
                      date: '2016-05-04',
                      name: '王小虎',
                      address: '上海市普陀区金沙江路 1518 弄'
                    }],
                    multipleSelection: []
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
                this.$router.push({path:'/index/editProduct'});
            },
            addProduct(){
                this.$router.push({path:'/index/addProduct'});
            }
        },
        components:{

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
