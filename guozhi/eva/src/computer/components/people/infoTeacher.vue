<!-- 组件 -->
<template>
    <div class="tmpl">
        <div class="table">
            <table>
                <tr>
                    <td>个人信息</td>
                    <td>
                        <p>
                            <span>&nbsp;&nbsp;&nbsp;工&nbsp;&nbsp;&nbsp;号</span>
                            <span v-text="userInfo.number"></span>
                        </p>
                        <p>
                            <span>&nbsp;&nbsp;&nbsp;姓&nbsp;&nbsp;&nbsp;名</span>
                            <span v-text="userInfo.username"></span>
                        </p>
                        <p>
                            <span>&nbsp;&nbsp;&nbsp;学&nbsp;&nbsp;&nbsp;院</span>
                            <span v-text="userInfo.collegeName"></span>
                        </p>
                        <p>
                            <span>&nbsp;&nbsp;&nbsp;专&nbsp;&nbsp;&nbsp;业</span>
                            <span v-text="userInfo.proName"></span>
                        </p>
                        <p>
                            <span>&nbsp;&nbsp;&nbsp;邮&nbsp;&nbsp;&nbsp;箱</span>
                            <span v-text="userInfo.email"></span>
                        </p>
                        <p>
                            <span>&nbsp;&nbsp;&nbsp;手机号</span>
                            <span v-text="userInfo.phone"></span>
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
                userInfo:{},
            }
        },
        components:{

        },
        created(){
            this.getMainInfo();
        },
        methods:{
            getMainInfo(){
                this.$http.axios({
                    url:'/userInfo/getUserInfoById',
                    method:'get',
                }).then(resolve=>{
                    this.userInfo=resolve;
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
