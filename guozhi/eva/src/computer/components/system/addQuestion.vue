<!-- 组件 -->
<template>
    <div class="tmpl">
        <el-table :data="tableData" stripe style="width: 100%" empty-text="请添加问题">
            <el-table-column label="序号" width="90">
                <template slot-scope="scope">
                    <span v-text="scope.$index+1"></span>
                </template>
            </el-table-column>
            <el-table-column label="标签" width="200">
                <template slot-scope="scope">
                    <el-select v-model="scope.row.tag" placeholder="请选择">
                        <el-option v-for="item in scope.row.options" :key="item.value" :label="item.label" :value="item.value"></el-option>
                    </el-select>
                </template>
            </el-table-column>
            <el-table-column label="问题"  width="400">
                <template slot-scope="scope">
                    <el-input type="text" v-model="scope.row.question"  width="240"></el-input>
                </template>
            </el-table-column>
            <el-table-column  label="操作">
                <template slot-scope="scope"><el-button @click="deleteClick(scope)" type="text" size="small">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-button type="primary" style="width:10%;margin-top:40px;margin-left:350px;" @click="addQuestion">添加</el-button>
        <el-button type="primary" style="width:10%;" @click="addQuestionEntity">提交</el-button>
    </div>
</template>

<!-- 组件导出 -->
<script>
    import { Message } from 'element-ui' //消息提示

    export default{
        data(){
            return {
                tableData: []
            }
        },
        methods: {
            addQuestion() {
                let obj={
                    tag:null,
                    question:null,
                    statu:"1",
                    options: [
                        {
                            value: '教学态度',
                            label: '教学态度'
                        },
                        {
                          value: '教学内容',
                          label: '教学内容'
                        },
                        {
                          value: '教学方法',
                          label: '教学方法'
                        },
                        {
                          value: '教学效果',
                          label: '教学效果'
                        },
                        {
                          value: '教学素养',
                          label: '教学素养'
                        }
                    ],
                };
                this.tableData.push(obj);
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
            },
            addQuestionEntity(){
                let sendData = this.tableData;

                this.$http.axios({
                    url:'/question/insertQuestionBatch',
                    method:'post',
                    data:sendData,
                    json:true,
                }).then(resolve=>{
                    Message({
                        showClose: true,
                        message: '添加成功',
                        type: 'success'
                    });
                    this.tableData=[];
                }).catch(err=>{
                    console.log("失败了"+err)
                })
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
