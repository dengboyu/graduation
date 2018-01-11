<!-- 组件 -->
<template>
    <div class="tmpl">
        <el-table :data="tableData" stripe style="width: 100%">
            <el-table-column label="序号" width="90">
                <template slot-scope="scope">
                    <span v-text="scope.$index+1"></span>
                </template>
            </el-table-column>
            <el-table-column prop="snumber" label="标签" width="180"></el-table-column>
            <el-table-column label="问题"  width="300">
                <template slot-scope="scope">
                    <span v-if="scope.row.flag" v-text="scope.row.sname"></span>
                    <el-input v-else type="text" v-model="scope.row.sname"  width="240"></el-input>
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
                      snumber: '教学态度',
                      sname: '上课认真，耐心辅导答疑，认真批改作业',
                      scollege: '经济管理学院',
                      sprofession:'信息管理与信息系统',
                      address:'byfdsa@163.com',
                      sphone:18423234321,
                      flag:true,
                      updateInfo:'修改',
                    },
                    {
                      snumber: '教学内容',
                      sname: '注意与学生的沟通和交流，关心学生学习',
                      scollege: '外国语学院',
                      sprofession:'英语专业',
                      address:'teafdaa@163.com',
                      sphone:18734234223,
                      flag:true,
                      updateInfo:'修改',
                    }
                ]
            }
        },
        methods: {
            handleClick(row) {
                console.log(row);
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
                this.$confirm('是否将该学生删除?', '提示', {
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
    .tmpl{
        margin: 20px 10%;
    }
    .el-table .cell .el-input{
        width:323px!important;
    }
</style>
