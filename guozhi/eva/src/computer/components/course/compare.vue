<!-- 组件 -->
<template>
    <div class="tmpl">
        <div class="table">
            <table>
                <caption>
                    任课教师: <span>黄换然</span>  课程名称: <span>市场营销</span>
                </caption>
                <thead>
                    <tr>
                        <th>序号</th>
                        <th>学号</th>
                        <th>姓名</th>
                        <th>详情</th>
                        <th>最终评分</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="(item,index) in tableList" :key="index">
                        <td v-text="index+1"></td>
                        <td v-text="item.number"></td>
                        <td v-text="item.username"></td>
                        <td>
                            <el-button type="text" size="small" @click="getDetail(item.id)">查 看</el-button>
                        </td>
                        <td v-text="item.totalCore"></td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="2">平均分</td>
                        <td colspan="3" v-text="avgScore"></td>
                    </tr>
                </tfoot>
            </table>
        </div>

        <el-dialog title="评教详情" :visible.sync="dialogVisible" width="50%">
            <p v-for="(item,index) in answerList">{{index+1}}. {{item.question}}<span style="margin-left:40px;">{{item.score}}</span>分</p>
        </el-dialog>
    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {
                tableList:[],
                avgScore:0,
                dialogVisible:false,
                answerList:[],
            }
        },
        components:{

        },
        created(){
            this.getCourseStudentList(this.$route.params.courseId);
        },
        methods:{
            getCourseStudentList(courseId){
                this.$http.axios({
                    url:'/evalution/getEvalutionList?courseId='+courseId,
                    method:'get',
                }).then(resolve=>{
                    this.tableList = resolve.studentCourse;
                    this.avgScore = resolve.avg;
                }).catch(err=>{
                    console.log("失败了")
                })
            },
            getDetail(courseId){
                this.dialogVisible=true;
                this.$http.axios({
                    url:'/evalution/getCourseListByStudent?evalutionId='+courseId,
                    method:'get',
                }).then(resolve=>{
                    this.answerList=resolve;
                }).catch(err=>{
                    console.log("失败了"+err)
                })
            }
        }
    }
</script>

<!-- 本组件样式 -->
<style  scoped>
.table {
    width: 800px;
    margin: 0 auto;
    text-align: center;
    margin-top: 30px;
}
.table table {
    width: 100%;
    border: 1px solid RGBA(223, 223, 223, 1);
    font-size: 15px;
    color: #666666;
}
.table table caption{
    text-align: left;
    height: 30px;
    line-height: 30px;
    font-size: 16px;
}
caption span{
    margin-right:65px;
}
.table table tr{
    height:40px;
}
.table table tr td{
    width: 200px;
}
.table table tr th,.table table tr td {
    border: 1px solid RGBA(223, 223, 223, 1);
}
tfoot tr td{
    text-align: right;
    padding-right: 10px;
}
</style>
