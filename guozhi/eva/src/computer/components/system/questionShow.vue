<!-- 组件 -->
<template>
    <div class="tmpl">
        <el-table :data="tableData" stripe style="width: 100%">
            <el-table-column label="序号" width="90">
                <template slot-scope="scope">
                    <span v-text="scope.$index+1"></span>
                </template>
            </el-table-column>
            <el-table-column prop="tag" label="标签" width="180"></el-table-column>
            <el-table-column label="问题"  width="600">
                <template slot-scope="scope">
                    <span v-if="scope.row.flag" v-text="scope.row.question"></span>
                    <el-input v-else type="text" v-model="scope.row.question"  width="240"></el-input>
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
    import { Message } from 'element-ui' //消息提示

    export default{
        data(){
            return {
                tableData: [

                ]
            }
        },
        methods: {
            handleClick(row) {
                if(row.flag){
                    row.updateInfo = '确定';
                    row.flag = !row.flag;
                }else{
                    //确定修改，提交
                    this.$http.axios({
                        url:'/question/updateQuestionById',
                        method:'post',
                        json:true,
                        data:row,
                    }).then(resolve=>{
                        Message({
                            showClose: true,
                            message: '修改成功',
                            type: 'success'
                        });

                        row.updateInfo = '修改';
                        row.flag = !row.flag;
                    }).catch(err=>{
                        console.log("失败了"+err)
                    })
                }
            },
            deleteClick(row){
                this.$confirm('是否将该学生删除?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {

                    console.log(row);

                    this.$http.axios({
                        url:'/question/deleteQuestion',
                        method:'post',
                        data:{id:row.id},
                    }).then(resolve=>{

                        this.tableData.splice(row.$index,1);

                        this.$message({
                            type: 'success',
                            message: '删除成功!'
                        });
                    }).catch(err=>{
                        console.log("失败了"+err)
                    })

                }).catch(()=>{});
            },
            getQuestionList(){

                this.$http.axios({
                    url:'/question/getQuestionList',
                    method:'get',
                }).then(resolve=>{
                    if(resolve!=null){
                        for(let i in resolve){
                            resolve[i].flag=true;
                            resolve[i].updateInfo='修改';
                        }
                    }
                    this.tableData=resolve;
                }).catch(err=>{
                    console.log("失败了"+err)
                })
            }
        },
        created(){
           this.getQuestionList();
        },
        components:{

        }
    }
</script>

<!-- 本组件样式 -->
<style scoped>
    .tmpl{
        margin: 20px 10%;
        height: 90%;
        overflow: scroll;
    }
    .el-table .cell .el-input{
        width:323px!important;
    }
</style>
