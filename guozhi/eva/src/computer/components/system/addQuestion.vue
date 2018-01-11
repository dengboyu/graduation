<!-- 组件 -->
<template>
    <div class="tmpl">
        <el-table :data="tableData" stripe style="width: 100%">
            <el-table-column label="序号" width="90">
                <template slot-scope="scope">
                    <span v-text="scope.$index+1"></span>
                </template>
            </el-table-column>
            <el-table-column prop="snumber" label="标签" width="200">
                <template slot-scope="scope">
                    <el-select v-model="value" placeholder="请选择">
                        <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value"></el-option>
                    </el-select>
                </template>
            </el-table-column>
            <el-table-column label="问题"  width="400">
                <template slot-scope="scope">
                    <el-input type="text" v-model="scope.row.sname"  width="240"></el-input>
                </template>
            </el-table-column>
            <el-table-column  label="操作">
                <template slot-scope="scope"><el-button @click="deleteClick(scope)" type="text" size="small">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-button type="primary" style="width:10%;margin-top:40px;margin-left:350px;" @click="addQuetion">添加</el-button>
        <el-button type="primary" style="width:10%;" @click="">提交</el-button>
    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {
                options: [{
                    value: '选项1',
                  label: '教学态度'
                }, {
                  value: '选项2',
                  label: '教学内容'
                }, {
                  value: '选项3',
                  label: '教学方法'
                }, {
                  value: '选项4',
                  label: '教学效果'
                }, {
                  value: '选项5',
                  label: '教学素养'
                }],
                value: '',
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
            addQuetion() {
                this.tableData.push(new Object());
            },
            deleteClick(scope){
                this.$confirm('是否将该问题删除?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.tableData.splice(scope.$index,1);
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
    .cell .el-input{
        width:100%;
    }
    thead tr th:nth-child(2){
        text-align: left;
        padding-left: 40px;
    }
</style>
