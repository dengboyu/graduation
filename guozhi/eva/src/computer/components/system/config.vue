<!-- 组件 -->
<template>
    <div class="tmpl">
        <p style="margin-left: 10px;">系统简介:</p>
        <p>1. 系统的主要目的是学生登录系统对各科教师进行线上打分、评教</p>
        <p>2. 管理员、教师可以查看各位教师的打分成绩</p>
        <p>3. 本系统后续会推出其他功能...</p>
    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {

            }
        },
        components:{

        }
    }
</script>

<!-- 本组件样式 -->
<style scoped>
    .tmpl p{
        margin-top: 10px;
        margin-left: 20px;
        color:#666666;
    }
</style>
