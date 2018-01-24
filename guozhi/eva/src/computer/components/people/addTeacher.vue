<!-- 组件 -->
<template>
    <div class="tmpl">
        <div class="table">
            <table>
                <tr>
                    <td>添加教师信息</td>
                    <td>
                        <p>
                            <span>&nbsp;&nbsp;&nbsp;工&nbsp;&nbsp;&nbsp;号</span>
                            <el-input placeholder="请输入教师工号" v-model.trim="userInfo.number"  :maxlength='20'></el-input>
                        </p>
                        <p>
                            <span>&nbsp;&nbsp;&nbsp;姓&nbsp;&nbsp;&nbsp;名</span>
                            <el-input placeholder="请输入教师姓名" v-model.trim="userInfo.username"  :maxlength='20'></el-input>
                        </p>
                        <p class="college-select">
                            <span style="margin-right:10px">&nbsp;&nbsp;&nbsp;学&nbsp;&nbsp;&nbsp;院</span>
                            <college-select @retValue="changeCollegeId"></college-select>
                        </p>
                        <p class="profession-select">
                            <span style="margin-right:10px">&nbsp;&nbsp;&nbsp;专&nbsp;&nbsp;&nbsp;业</span>
                            <profession-select @retProfessionValue="changeProfessionId"></profession-select>
                        </p>
                        <p>
                            <span>邮箱账号</span>
                            <el-input placeholder="请输入教师邮箱账号" v-model.trim="userInfo.email" >
                            </el-input>
                        </p>
                        <p>
                            <span>创建密码</span>
                            <el-input placeholder="格式为6-16位数字+字母" v-model.trim="userInfo.password" :type="pwdType" :maxlength='16'>
                                <i slot="suffix" class="el-input__icon el-icon-date" :class='{eye:eye,eyeClose:eyeClose}' @click="changeEye"></i>
                            </el-input>
                        </p>
                        <p>
                            <span>绑定手机</span>
                            <el-input placeholder="请输入手机号" v-model.trim="userInfo.phone" :maxlength='11'>
                            </el-input>
                        </p>
                        <el-button type="primary" style="width:20%;margin: 40px 24%;" @click="addTeacher">提交</el-button>
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

    export default{
        data(){
            return {
                userInfo:{
                    username:null,
                    password:null,
                    email:null,
                    identity:"1",
                    number:null,
                    college:null,
                    profession:null,
                    phone:null
                },
                eye: false,
                eyeClose: true,
                pwdType: 'password'
            }
        },
        components:{
            collegeSelect,
            professionSelect
        },
        methods:{
            changeEye() {
                this.pwdType = this.pwdType === 'password' ? 'text' : 'password';
                this.eyeClose = !this.eyeClose;
                this.eye = !this.eye;
            },
            changeCollegeId(param){
                //选择学院
                this.userInfo.college = param;
            },
            changeProfessionId(param){
                this.userInfo.profession = param;
            },
            addTeacher(){
                let sendData = this.userInfo;
                if(this.$fn.hasObjectNull(sendData)){
                    Message({
                        showClose: true,
                        message: '请把信息填全',
                        type: 'warning'
                    });
                    return;
                }

                this.$http.axios({
                    url:'/userInfo/addUserInfoEntity',
                    method:'post',
                    data:sendData,
                    json:true,
                }).then(resolve=>{
                    console.log("chenggong");
                    Message({
                        showClose: true,
                        message: '添加成功',
                        type: 'success'
                    });
                    Bus.$emit('resetProfessionSelect');
                    Bus.$emit('resetCollegeSelect');
                    this.$fn.resetObject(this.userInfo);
                    this.userInfo.identity="1";
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

.eye {
    background: url('../../../assets/img/eye1.png') no-repeat center;
    background-size: contain;
}
.eyeClose {
    background: url('../../../assets/img/eye2.png') no-repeat center;
    background-size: contain;
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
