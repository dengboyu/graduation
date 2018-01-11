<!-- 组件 -->
<template>
    <div class="tmpl">
        <p class="sel-look">学院专业查看</p>
        <el-tree :data="data" :props="defaultProps" :accordion="true" @node-click="handleNodeClick"></el-tree>
    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {
                data: [{
                  label: '经济与管理学院',
                  children: [{
                    label: '信心管理与信息系统专业',
                  },{
                    label: '物流管理专业'
                  }]
                }, {
                  label: '外国语学院',
                  children: [{
                    label: '日语专业'
                  }, {
                    label: '英语专业'
                  }]
                }],
                defaultProps: {
                  children: 'children',
                  label: 'label'
                }
            }
        },
        methods:{
            handleNodeClick(data) {
                console.log(data);
            }
        },
        components:{

        }
    }
</script>

<!-- 本组件样式 -->
<style scoped>
    .tmpl{
        position: relative;
        top: 30px;
        left: 50px;
    }
    .sel-look{
        margin-left: -10px;
        margin-bottom: 20px;
        color: #797474;
    }
</style>
