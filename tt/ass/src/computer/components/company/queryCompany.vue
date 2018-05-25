<!-- 组件 -->
<template>
    <div class="tmpl">
        <p class="result">已合作公司</p>
        <el-table ref="multipleTable" border :data="companylist" tooltip-effect="dark" style="margin-left:10%;width: 80%" @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55"></el-table-column>
            <el-table-column label="公司名称" width="120">
                <template slot-scope="scope">{{ scope.row.comName }}</template>
            </el-table-column>
            <el-table-column prop="linkPhone" label="联系电话" width="240"></el-table-column>
            <el-table-column prop="linkName" label="联系人" ></el-table-column>
            <el-table-column prop="fax" label="传真号码" ></el-table-column>
            <el-table-column prop="email" label="企业邮箱" ></el-table-column>
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
                companylist: [],
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
            getCompanyList(){

                this.$http.axios({
                    url:'/company/getCompanyList',
                    method:'get',
                }).then(resolve=>{

                    this.companylist = resolve;

                }).catch(err=>{

                })

            },
            handleClick(row){
                this.$router.push({name:'updateCompany',params:{id:row.id}});
            }
        },
        components:{

        },
        created(){
            this.getCompanyList();
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
