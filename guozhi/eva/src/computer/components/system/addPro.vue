<!-- 组件 -->
<template>
    <div class="tmpl">
        <div class="table">
            <table>
                <tr>
                    <td>添加专业信息</td>
                    <td>
                        <p>
                            <span>专业编号</span>
                            <el-input placeholder="请输入专业编号" v-model.trim="account.user"  :maxlength='20'></el-input>
                        </p>
                        <p>
                            <span>专业名称</span>
                            <el-input placeholder="请输入专业名称" v-model.trim="account.user"  :maxlength='20'></el-input>
                        </p>
                        <p>
                            <span>选择学院</span>
                            <el-select v-model="value" placeholder="请选择专业">
                                <el-option
                                    v-for="item in options"
                                    :key="item.value"
                                    :label="item.label"
                                    :value="item.value">
                                </el-option>
                            </el-select>
                        </p>
                        <p>
                            <span>成立时间</span>
                            <el-date-picker v-model="value4" type="month" placeholder="专业成立时间"></el-date-picker>
                        </p>
                        <el-button type="primary" style="width:20%;margin: 40px 24%;" @click="">提交</el-button>
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
                value4: '',
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
                    user: '',
                    region: '',
                    // 用户名报错信息
                    userMsg: false,
                    // 用户名报错信息内容
                    userMsgInfo: '',
                    password: '',
                    pwdMsg: false,
                    mail: '',
                    mailMsg: false,
                    mailMsgInfo: '',
                    pho: '',
                    phoMsg: false,
                    phoMsgInfo: '此手机号一经绑定，不得更改',
                    companyName: '',
                    code: '',
                    address: '',
                    contactPho: '',
                    contactName: ''
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
