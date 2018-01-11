<!-- 组件 -->
<template>
    <div class="tmpl">
        <el-table :data="tableData" stripe style="width: 100%">
            <el-table-column prop="address" label="任课教师" width="180"></el-table-column>
            <el-table-column prop="snumber" label="教师工号" width="180"></el-table-column>
            <el-table-column prop="snumber" label="课程编号" width="180"></el-table-column>
            <el-table-column label="课程名称"  width="180">
                <template slot-scope="scope">
                    <span v-if="scope.row.flag" v-text="scope.row.sname"></span>
                    <el-input v-else type="text" v-model="scope.row.sname"  width="180"></el-input>
                </template>
            </el-table-column>
            <el-table-column prop="scollege" label="学院"></el-table-column>
            <el-table-column prop="sprofession" label="专业"></el-table-column>
            <el-table-column  label="操作">
                <template slot-scope="scope">
                    <el-button @click="handleClick(scope.row)" type="text" size="small">查看结果</el-button>
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
                tableData: [
                    {
                      snumber: '1102012',
                      sname: '市场营销',
                      scollege: '经济管理学院',
                      sprofession:'信息管理与信息系统',
                      address:'李丽',
                      sphone:18423234321,
                      flag:true,
                      updateInfo:'修改',
                    },
                    {
                      snumber: '1102013',
                      sname: '物流管理',
                      scollege: '外国语学院',
                      sprofession:'英语专业',
                      address:'李强',
                      sphone:18734234223,
                      flag:true,
                      updateInfo:'修改',
                    }
                ]
            }
        },
        methods: {
            handleClick(row) {
                // console.log(row);
                this.$router.push({path:'/index/compare'})
            },
            deleteClick(){
                this.$confirm('是否将该课程删除?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.$message({
                        type: 'success',
                        message: '删除成功!'
                    });
                }).catch(()=>{});
            }
        },
        components:{

        }
    }
</script>

<!-- 本组件样式 -->
<style scoped>
    .el-input{
        width:100%;
    }
</style>
