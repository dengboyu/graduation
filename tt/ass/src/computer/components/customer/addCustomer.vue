<!-- 组件 -->
<template>
    <div class="tmpl">
        <p class="result">已添加客户</p>
        <el-table ref="multipleTable" border :data="tableData3" tooltip-effect="dark" style="margin-left:5%;width: 90%" @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55"></el-table-column>
            <el-table-column label="公司名称" width="120">
                <template slot-scope="scope">{{ scope.row.date }}</template>
            </el-table-column>
            <el-table-column prop="name" label="联系人"></el-table-column>
            <el-table-column prop="name" label="性别" ></el-table-column>
            <el-table-column prop="name" label="职位" ></el-table-column>
            <el-table-column prop="name" label="手机号码" ></el-table-column>
            <el-table-column prop="name" label="联系电话"></el-table-column>
            <el-table-column prop="name" label="传真号码"></el-table-column>
            <el-table-column prop="name" label="电子邮箱"></el-table-column>
            <el-table-column prop="name" label="联系地址"></el-table-column>
            <el-table-column label="修改" width="120">
                <template slot-scope="scope">
                    <el-button @click="handleClick(scope.row)" type="text" size="small" width="60">修改</el-button>
                    <el-button @click="handleClick(scope.row)" type="text" size="small" width="60">删除</el-button>
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
                      date: '阿里巴巴集团有限公司',
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
                    }, {
                      date: '2016-05-01',
                      name: '王小虎',
                      address: '上海市普陀区金沙江路 1518 弄'
                    }, {
                      date: '2016-05-08',
                      name: '王小虎',
                      address: '上海市普陀区金沙江路 1518 弄'
                    }, {
                      date: '2016-05-06',
                      name: '王小虎',
                      address: '上海市普陀区金沙江路 1518 弄'
                    }, {
                      date: '2016-05-07',
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

            },
            addLinkName(){
                this.$router.push({path:'/index/linkName'})
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
