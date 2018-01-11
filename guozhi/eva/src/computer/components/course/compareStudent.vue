<!-- 组件 -->
<template>
    <div class="tmpl">
        <el-table :data="tableData" stripe style="width: 100%">
            <el-table-column prop="snumber" label="课程编号" width="180"></el-table-column>
            <el-table-column prop="sname" label="课程名称"  width="180"></el-table-column>
            <el-table-column prop="scollege" label="学院"></el-table-column>
            <el-table-column prop="sprofession" label="专业"></el-table-column>
            <el-table-column prop="address"  label="任课教师" width="180"></el-table-column>
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
                    {
                      snumber: '14086102',
                      sname: '市场营销',
                      scollege: '经济管理学院',
                      sprofession:'信息管理与信息系统',
                      address:'李丽',
                      sphone:18423234321,
                    },
                    {
                      snumber: '14086103',
                      sname: '大数据分析',
                      scollege: '外国语学院',
                      sprofession:'英语专业',
                      address:'熊新',
                      sphone:18734234223,
                    }
                ]
            }
        },
        methods: {
            handleClick(row) {
                console.log(row);
                this.$router.push({path:'/index/evalution'});
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
