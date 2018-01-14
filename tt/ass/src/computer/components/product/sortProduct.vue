<!-- 组件 -->
<template>
    <div class="tmpl">
        <div class="main-top">
            <span class="has-sort">已有产品分类</span>
            <el-select v-model="value" placeholder="请选择">
                <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value"></el-option>
            </el-select>
        </div>
        <hr>
        <div class="main-botton">
            <span style="display:inline-block;margin-right:30px;">添加产品分类</span>
            <el-input style="width:29.5%;" v-model="input" placeholder="请输入产品分类名称"></el-input>
            <el-button type="primary" style="margin-left:40px">添加</el-button>
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
                input:null,
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
        height:50px;
        margin-left:30px;
    }
    .main-top .has-sort{
        display: inline-block;
        margin-right:30px;
    }
    .main-botton{
        height:50px;
        margin-top:20px;
        margin-left:30px;
    }
</style>
