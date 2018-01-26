<!-- 组件 -->
<template>
    <div class="tmpl">
        <p class="result">已添加客户</p>
        <el-table ref="multipleTable" border :data="tableData3" tooltip-effect="dark" style="margin-left:5%;width: 90%" @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55"></el-table-column>
            <el-table-column prop="comName" label="公司名称" width="120"></el-table-column>
            <el-table-column prop="linkName" label="联系人" width="100"></el-table-column>
            <el-table-column prop="sex" label="性别" width="60"></el-table-column>
            <el-table-column prop="post" label="职位" ></el-table-column>
            <el-table-column prop="phone" label="手机号码" ></el-table-column>
            <el-table-column prop="tel" label="联系电话"></el-table-column>
            <el-table-column prop="fax" label="传真号码"></el-table-column>
            <el-table-column prop="email" label="电子邮箱"></el-table-column>
            <el-table-column prop="address" label="联系地址"></el-table-column>
            <el-table-column label="修改" width="120">
                <template slot-scope="scope">
                    <el-button @click="handleClick(scope.row)" type="text" size="small" width="60">修改</el-button>
                    <!-- <el-button @click="handleClick(scope.row)" type="text" size="small" width="60">删除</el-button> -->
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
                tableData3: [],
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
            handleClick(row){
                this.$router.push({name:'updateCustomer',params:{id:row.id}});
            },
            getCustomerList(){

                this.$http.axios({
                    url:'/customer/getCustomerList',
                    method:'get',
                }).then(resolve=>{

                    this.tableData3=resolve;

                }).catch(err=>{
                    console.log("失败了")
                })

            }
        },
        components:{

        },
        created(){
            this.getCustomerList();
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
