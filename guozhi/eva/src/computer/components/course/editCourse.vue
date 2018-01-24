<!-- 组件 -->
<template>
    <div class="tmpl">
        <el-table :data="tableData" stripe style="width: 100%">
            <el-table-column prop="courseNum" label="课程编号" width="180"></el-table-column>
            <el-table-column label="课程名称"  width="180">
                <template slot-scope="scope">
                    <span v-if="scope.row.flag" v-text="scope.row.courseName"></span>
                    <el-input v-else type="text" v-model="scope.row.courseName"  width="180"></el-input>
                </template>
            </el-table-column>
            <el-table-column prop="collegeName" label="学院"></el-table-column>
            <el-table-column prop="proName" label="专业"></el-table-column>
            <el-table-column prop="username" label="任课教师" width="180"></el-table-column>
            <el-table-column prop="number" label="教师工号" width="180"></el-table-column>
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
                tableData: []
            }
        },
        methods: {
            handleClick(row) {

                if(row.flag){
                    row.updateInfo = '确定';
                    row.flag = !row.flag;
                }else{
                    this.$http.axios({
                        url:'/course/updateCourseEntity',
                        method:'post',
                        data:row,
                        json:true,
                    }).then(resolve=>{
                        this.$message({
                            type: 'success',
                            message: '修改成功!'
                        });
                        row.updateInfo = '修改';
                        row.flag = !row.flag;

                    }).catch(err=>{
                        console.log("失败了"+err)
                    })
                }
            },
            deleteClick(row){
                this.$confirm('是否将该课程删除?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {

                    this.$http.axios({
                        url:'/course/deleteCourseEntity',
                        method:'post',
                        data:{id:row.id},
                    }).then(resolve=>{
                        this.$message({
                            type: 'success',
                            message: '删除成功!'
                        });
                        this.tableData.splice(row.$index,1);

                    }).catch(err=>{
                        console.log("失败了"+err)
                    })
                }).catch(()=>{});
            },
            getCourseList(){
                this.$http.axios({
                    url:'/course/getCourseEntityList',
                    method:'get',
                }).then(resolve=>{
                    if(resolve.length>0){
                        for(let i in resolve){
                            resolve[i].flag=true;
                            resolve[i].updateInfo='修改';
                        }
                    }
                    this.tableData = resolve;

                }).catch(err=>{
                    console.log("失败了"+err)
                })
            }
        },
        components:{

        },
        created(){
            this.getCourseList();
        }
    }
</script>

<!-- 本组件样式 -->
<style scoped>
    .el-input{
        width:100%;
    }
</style>
