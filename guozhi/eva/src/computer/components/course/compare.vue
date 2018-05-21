<!-- 组件 -->
<template>
    <div class="tmpl">
        <div class="table">
            <table>
                <caption style="margin-bottom: 15px;">
                    任课教师: <span>黄换然</span>  课程名称: <span>市场营销</span>
                    <span>按照分数筛选
                        <el-select v-model="queryScore" placeholder="选择分数">
                            <el-option label="全部" value=""></el-option>
                            <el-option label="40-80" value="40-80"></el-option>
                            <el-option label="80-120" value="80-120"></el-option>
                            <el-option label="120-160" value="120-160"></el-option>
                            <el-option label="160-200" value="160-200"></el-option>
                        </el-select>
                        <el-button type="text" size="big" @click="getCourseStudentList()">查询</el-button>
                    </span>
                </caption>
                <thead>
                    <tr>
                        <th>序号</th>
                        <th>学号</th>
                        <th>姓名</th>
                        <th>详情</th>
                        <th>最终评分</th>
                        <th>恶性剔除</th>
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
                        <td>
                            <el-button type="text" size="small" @click="deleteAnswer(item.id)">删 除</el-button>
                        </td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="2">平均分</td>
                        <td colspan="4" v-text="avgScore"></td>
                    </tr>
                </tfoot>
            </table>
        </div>

        <el-dialog title="评教详情" :visible.sync="dialogVisible" width="50%">
            <p v-for="(item,index) in answerList">{{index+1}}. {{item.question}}<span style="margin-left:40px;">{{item.score}}</span>分</p>
            <p><span>学生建议:</span><span v-text="suggestion"></span></p>
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
                suggestion:'',
                queryScore:'',
                courseId :''
            }
        },
        components:{

        },
        created(){
            this.courseId = this.$route.params.courseId;
            this.getCourseStudentList();
        },
        methods:{
            getCourseStudentList(){
                var param = '?courseId='+this.courseId;
                if(this.queryScore!=''){
                    param+='&score='+this.queryScore;
                }

                this.$http.axios({
                    url:'/evalution/getEvalutionList'+param,
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
                    this.answerList=resolve.answer;
                    this.suggestion = resolve.suggestion;
                }).catch(err=>{
                    console.log("失败了"+err)
                })
            },
            deleteAnswer(id){
                this.$http.axios({
                    url:'/evalution/deleteAnswer?evalutionId='+id,
                    method:'get',
                }).then(resolve=>{
                    getCourseStudentList();
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
