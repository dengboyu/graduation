<!-- 组件 -->
<template>
    <div class="tmpl">
        <div class="top">
            <p class="top-one">本系统功能,管理员可以发布评分评价内容及新闻公告,可以进行数据库里面信息档案管理,教师登入可以进入自己的管理页面进行查看自己的评分及留言,不允许教师进行评分及留言。管理员,学生,教师各进入自己管理页面进行相应操作。</p>
            <p class="top-two" style="margin-top: 10px;">在以下功能中: A - 10分 - 好&nbsp;&nbsp;&nbsp;&nbsp; B - 8分 - 较好&nbsp;&nbsp;&nbsp;&nbsp; C - 6分 - 一般&nbsp;&nbsp;&nbsp;&nbsp; D - 4分 - 较差&nbsp;&nbsp;&nbsp;&nbsp; E -2分 - 差 </p>
            <p class="top-three">您正在给&nbsp;&nbsp;<span v-text="$route.params.courseName"></span>&nbsp;&nbsp;课程,&nbsp;&nbsp;<span v-text="$route.params.username"></span>&nbsp;&nbsp;教师评教</p>
        </div>
        <div class="main" style="padding-top: 30px;">
            <div v-for="(item,index) in questionList" :key="index">
                <p>{{index+1}}【{{item.tag}}】 {{item.question}}</p>
                <p class="question">
                    <el-radio v-model="item.score" label="10">A</el-radio>
                    <el-radio v-model="item.score" label="8">B</el-radio>
                    <el-radio v-model="item.score" label="6">C</el-radio>
                    <el-radio v-model="item.score" label="4">D</el-radio>
                    <el-radio v-model="item.score" label="2">E</el-radio>
                </p>
            </div>
            <br>
            <div>
                <span>请您给点建议:</span>
                <el-input type="textarea" v-model="evalution.suggestion" placeholder="请给出您的宝贵建议:"></el-input>
            </div>
            <el-button type="primary" style="width:12%;margin-top: 30px;margin-left: 43%;" @click="login">提交</el-button>
        </div>
    </div>
</template>

<!-- 组件导出 -->
<script>
    import { Message } from 'element-ui' //消息提示
    export default{
        data(){
            return {
                questionList:[],
                evalution:{
                    answer:'',
                    totalCore:0,//总分
                    couseId:'',//课程id
                    suggestion:''
                }
            }
        },
        created(){
            this.getQuestionList();
            console.log(this.$route.params)
        },
        methods:{
            login(){
                this.evalution.answer='',
                this.evalution.totalCore = 0;   //清空
                this.evalution.couseId = this.$route.params.id;


                for(let item in this.questionList){
                    if(!this.questionList[item].score) {
                        Message({
                            showClose: true,
                            message: "请答题完毕再提交",
                            type: 'warning'
                        });
                        return ;
                    }

                    //总分
                    this.evalution.totalCore +=(this.questionList[item].score*1);

                    this.evalution.answer+=this.questionList[item].id+'-'+this.questionList[item].score+',';
                }
                this.evalution.answer = this.evalution.answer.substring(0,this.evalution.answer.length-1);

                this.$http.axios({
                    url:'/evalution/insertEvalutionEntity',
                    method:'post',
                    data:this.evalution,
                    json:true,
                }).then(resolve=>{
                    Message({
                        showClose: true,
                        message: "评教完毕",
                        type: 'success'
                    });
                    this.$router.push({path:'/index/compareStudent'});
                }).catch(err=>{
                    console.log("失败了")
                })

            },
            getQuestionList(){

                this.$http.axios({
                    url:'/question/getQuestionList',
                    method:'get',
                }).then(resolve=>{
                    this.questionList=resolve;
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
        color:#666;
        margin:30px 120px;
        height: 650px;
        overflow: scroll;
    }
    .top,.main{
        border: 1px solid #666;
        padding: 10px;
    }
    .question span{
        margin-left:20px;
        display: inline-block;
    }
    .el-radio{
        color:#666;
    }
    .question{
        margin: 10px 30px;
    }
    .top-three{
        margin-top:10px;
        color:#7070dc;
    }
    .top-three span{
        color:red;
    }
</style>
