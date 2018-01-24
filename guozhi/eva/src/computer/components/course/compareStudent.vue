<!-- 组件 -->
<template>
    <div class="tmpl">
        <el-table :data="tableData" stripe style="width: 100%">
            <el-table-column prop="courseNum" label="课程编号" width="180"></el-table-column>
            <el-table-column prop="courseName" label="课程名称"  width="180"></el-table-column>
            <el-table-column prop="collegeName" label="学院"></el-table-column>
            <el-table-column prop="proName" label="专业"></el-table-column>
            <el-table-column prop="username"  label="任课教师" width="180"></el-table-column>
            <el-table-column  label="操作">
                <template slot-scope="scope">
                    <el-button @click="handleClick(scope.row)" type="text" size="small">开始评教</el-button>
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

                ]
            }
        },
        methods: {
            handleClick(row) {
                console.log(row);
                this.$router.push({name:'evalution',params:{id:row.id,username:row.username,courseName:row.courseName}});
            },
            getCourseList(){
                this.$http.axios({
                    url:'/course/getCourseListByStudent',
                    method:'get',
                }).then(resolve=>{
                    this.tableData = resolve;
                }).catch(err=>{
                    console.log("失败了")
                })
            }
        },
        created(){
            this.getCourseList();
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
