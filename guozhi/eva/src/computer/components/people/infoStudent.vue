<!-- 组件 -->
<template>
    <div class="tmpl">
        <div class="table">
            <table>
                <tr>
                    <td>个人信息</td>
                    <td>
                        <p>
                            <span>&nbsp;&nbsp;&nbsp;学&nbsp;&nbsp;&nbsp;号</span>
                            <span v-text="account.contactName"></span>
                        </p>
                        <p>
                            <span>&nbsp;&nbsp;&nbsp;姓&nbsp;&nbsp;&nbsp;名</span>
                            <span v-text="account.user"></span>
                        </p>
                        <p>
                            <span>&nbsp;&nbsp;&nbsp;学&nbsp;&nbsp;&nbsp;院</span>
                            <span v-text="account.userMsgInfo"></span>
                        </p>
                        <p>
                            <span>&nbsp;&nbsp;&nbsp;专&nbsp;&nbsp;&nbsp;业</span>
                            <span v-text="account.mailMsgInfo"></span>
                        </p>
                        <p>
                            <span>&nbsp;&nbsp;&nbsp;邮&nbsp;&nbsp;&nbsp;箱</span>
                            <span v-text="account.mail"></span>
                        </p>
                        <p>
                            <span>&nbsp;&nbsp;&nbsp;手机号</span>
                            <span v-text="account.pho"></span>
                        </p>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {
                options: [{
                    value: '选项1',
                    label: '黄金糕'
                }, {
                  value: '选项2',
                  label: '双皮奶'
                }, {
                  value: '选项3',
                  label: '蚵仔煎'
                }, {
                  value: '选项4',
                  label: '龙须面'
                }, {
                  value: '选项5',
                  label: '北京烤鸭'
                }],
                value: '',
                account: {
                    // 用户名
                    user: '张国智',
                    region: '',
                    // 用户名报错信息
                    userMsg: false,
                    // 用户名报错信息内容
                    userMsgInfo: '经济与管理学院',
                    password: '',
                    pwdMsg: false,
                    mail: 'fdafdsafd@163.com',
                    mailMsg: false,
                    mailMsgInfo: '信息管理与信息系统专业',
                    pho: '1832342342',
                    phoMsg: false,
                    companyName: '',
                    code: '',
                    address: '',
                    contactPho: '',
                    contactName: '12323'
                },
                // 点击提交做的相关判断依据
                submitAccord: {
                    user: false,
                    mail: false,
                    password: false,
                    tel: false
                },
                eye: false,
                eyeClose: true,
                pwdType: 'password'
            }
        },
        components:{

        },
        methods:{
            changeEye() {
                this.pwdType = this.pwdType === 'password' ? 'text' : 'password';
                this.eyeClose = !this.eyeClose;
                this.eye = !this.eye;
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
    padding-bottom: 20px;
}
.table table p span:nth-child(2){
    margin-left:40px;
}
.el-select {
    width: 97px;
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
