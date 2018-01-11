<!-- 组件 -->
<template>
    <div class="tmpl">
        <el-table :data="tableData" stripe style="width: 100%">
            <el-table-column prop="tnumber" label="工号" width="180"></el-table-column>
            <el-table-column label="姓名"  width="180">
                <template slot-scope="scope">
                    <span v-if="scope.row.flag" v-text="scope.row.tname"></span>
                    <el-input v-else type="text" v-model="scope.row.tname"  width="180"></el-input>
                </template>
            </el-table-column>
            <el-table-column prop="tcollege" label="学院"></el-table-column>
            <el-table-column prop="tprofession" label="专业"></el-table-column>
            <el-table-column label="邮箱" width="180">
                <template slot-scope="scope">
                    <span v-if="scope.row.flag" v-text="scope.row.address"></span>
                    <el-input v-else type="text" v-model="scope.row.address"  width="180"></el-input>
                </template>
            </el-table-column>
            <el-table-column label="手机" width="180">
                <template slot-scope="scope">
                    <span v-if="scope.row.flag" v-text="scope.row.tphone"></span>
                    <el-input v-else type="text" v-model="scope.row.tphone"  width="180"></el-input>
                </template>
            </el-table-column>
            <el-table-column  label="操作">
                <template slot-scope="scope">
                    <el-button @click="handleClick(scope.row)" type="text" size="small">{{scope.row.updateInfo}}</el-button>
                    <el-button @click="deleteClick(scope.row)" type="text" size="small">删除</el-button>
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
                      tnumber: '14086102',
                      tname: '王老师',
                      tcollege: '经济管理学院',
                      tprofession:'信息管理与信息系统',
                      address:'byfdsa@163.com',
                      tphone:18423234321,
                      flag:true,
                      updateInfo:'修改',
                    },
                    {
                      tnumber: '14086103',
                      tname: '张老师',
                      tcollege: '外国语学院',
                      tprofession:'英语专业',
                      address:'teafdaa@163.com',
                      tphone:18734234223,
                      flag:true,
                      updateInfo:'修改',
                    }
                ]
            }
        },
        methods: {
            handleClick(row) {
                // console.log(row);
                console.log(row.flag);

                if(row.flag){
                    row.updateInfo = '确定';
                    row.flag = !row.flag;
                }else{
                    //确定修改，提交
                    console.log("提交信息");
                }
            },
            deleteClick(){
                this.$confirm('是否将该教师删除?', '提示', {
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
