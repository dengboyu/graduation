<!-- 组件 -->
<template>
    <div class="tmpl">
        <div class="main-top">
            <span style="display:inline-block;margin-right:15px;">添加备注信息</span>
            <el-input type="textarea" style="width:60%;" :rows="2" placeholder="请输入备注信息" v-model="textarea"></el-input>
            <el-button type="primary" style="margin-left:40px">添加</el-button>
        </div>
        <hr>
        <div class="main-botton">
            <span class="has-sort">已有备注:</span>
            <p v-for="(value,index) in remarkList" :key="index">{{index+1}}. {{value}}</p>
        </div>
    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {
                remarkList:[
                    "非人为损坏，3年保修","以上产品单价均为含税单价，含税17%"
                ],
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
                input:null,
                textarea:null,
            }
        },
        components:{

        }
    }
</script>

<!-- 本组件样式 -->
<style scoped>
    .tmpl{
        position: absolute;
        padding-top: 20px;
        top: 20%;
        left: 25%;
        width: 680px;
        height: 380px;
        background: #65c0e8;
    }
    .main-top{
        height:70px;
        margin-left:30px;
    }
    .main-botton{
        height:50px;
        margin-top:20px;
        margin-left:30px;
    }
    .main-botton p{
        margin-left:20px;
        font-size: 14px;
        margin-top:10px;
    }
</style>
