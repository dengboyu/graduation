<!-- 组件 -->
<template>
    <div class="tmpl">
        <div class="table">
            <table>
                <tr>
                    <td>添加学院信息</td>
                    <td>
                        <p>
                            <span>学院编号</span>
                            <el-input placeholder="请输入学院编号" v-model.trim="college.collegeNum"  :maxlength='20'></el-input>
                        </p>
                        <p>
                            <span>学院名称</span>
                            <el-input placeholder="请输入学院名称" v-model.trim="college.collegeName"  :maxlength='20'></el-input>
                        </p>
                        <p>
                            <span>成立时间</span>
                            <el-date-picker v-model="college.startTime" type="date" placeholder="学院成立时间"></el-date-picker>
                        </p>
                        <el-button type="primary" style="width:20%;margin: 40px 24%;" @click="addCollege">提交</el-button>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</template>

<!-- 组件导出 -->
<script>
    import { Message } from 'element-ui' //消息提示
    import Bus from '../public/bus'

    export default{
        data(){
            return {
                college:{
                    collegeNum:null,
                    collegeName:null,
                    startTime:null
                },
            }
        },
        components:{

        },
        methods:{
            addCollege(){
                let sendData = this.college;
                if(this.$fn.hasObjectNull(sendData)){
                    Message({
                        showClose: true,
                        message: '请把信息填全',
                        type: 'warning'
                    });
                    return;
                }

                this.$http.axios({
                    url:'/college/addCollegeEntity',
                    method:'post',
                    data:sendData,
                    json:true,
                }).then(resolve=>{
                    Message({
                        showClose: true,
                        message: '添加成功',
                        type: 'success'
                    });
                    this.$fn.resetObject(this.college);
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
