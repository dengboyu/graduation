<!-- 组件 -->
<template>
    <div class="tmpl">
        <div class="table">
            <table>
                <tr>
                    <td>添加课程信息</td>
                    <td>
                        <p>
                            <span>课程编号</span>
                            <el-input placeholder="请输入课程编号" v-model.trim="course.courseNum"  :maxlength='20'></el-input>
                        </p>
                        <p>
                            <span>课程名称</span>
                            <el-input placeholder="请输入课程名称" v-model.trim="course.courseName"  :maxlength='20'></el-input>
                        </p>
                        <p class="college-select">
                            <span style="margin-right:10px">&nbsp;&nbsp;&nbsp;学&nbsp;&nbsp;&nbsp;院</span>
                            <college-select @retValue="changeCollegeId"></college-select>
                        </p>
                        <p class="profession-select">
                            <span style="margin-right:10px">&nbsp;&nbsp;&nbsp;专&nbsp;&nbsp;&nbsp;业</span>
                            <profession-select @retProfessionValue="changeProfessionId"></profession-select>
                        </p>
                        <p class="teacher-select">
                            <span style="margin-right:10px">任课教师</span>
                            <teacher-select @retValue="changeTeacherId"></teacher-select>
                        </p>
                        <el-button type="primary" style="width:20%;margin: 40px 24%;" @click="addCourseEnttiy">提交</el-button>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</template>

<!-- 组件导出 -->
<script>
    import { mapState,mapGetters,mapMutations,mapActions } from 'vuex'
    import collegeSelect from '../system/collegeSelect'
    import professionSelect from '../system/professionSelect'
    import { Message } from 'element-ui' //消息提示
    import Bus from '../public/bus'
    import teacherSelect from './teacherSelect'

    export default{
        data(){
            return {
                course:{
                    courseNum:null,
                    courseName:null,
                    college:null,
                    profession:null,
                    teacher:null
                }
            }
        },
        components:{
            collegeSelect,
            professionSelect,
            teacherSelect,
        },
        methods:{
            changeCollegeId(param){
                //选择学院
                this.course.college = param;
            },
            changeProfessionId(param){
                this.course.profession = param;
            },
            changeTeacherId(param){
                this.course.teacher = param;
            },
            addCourseEnttiy(){
                let sendData = this.course;
                if(this.$fn.hasObjectNull(sendData)){
                    Message({
                        showClose: true,
                        message: '请把信息填全',
                        type: 'warning'
                    });
                    return;
                }

                this.$http.axios({
                    url:'/course/addCourseEntity',
                    method:'post',
                    data:sendData,
                    json:true,
                }).then(resolve=>{
                    Message({
                        showClose: true,
                        message: '添加成功',
                        type: 'success'
                    });
                }).catch(err=>{
                    console.log("失败了")
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
.table table p{
    margin-top:15px;
}
.table table tr{
    width: 100%;
}
.table table tr td {
    border: 1px solid RGBA(223, 223, 223, 1);
}
.table table tr td:nth-child(2) {
    text-align: left;
    padding-left: 50px;
}
.el-select {
    width: 97px;
}
.companyType {
    width: 180px;
}
.sendMessage {
    border: none;
    color: #45c8dc;
    padding-left: 15px;
}
.sendMessage:hover,
.sendMessage:blur {
    border: none;
    color: #45c8dc;
}
.el-button--primary.is-plain:focus,
.el-button--primary.is-plain:hover .msgTip {
    border: none;
    color: #45c8dc;
}
.el-icon-date::before {
    display: none;
}
.msgTip {
    float: right;
    width: 33%;
    padding-left: 0;
}
.el-input{
    width:50%;
    margin-left:10px;
}
.el-select{
    margin-left:10px;
    width: 71%;
}
</style>
