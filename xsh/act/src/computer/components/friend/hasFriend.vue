<!-- 组件 -->
<template>
    <div class="tmpl-hasFriend">
        <p><img src="../../../assets/img/friend.png" height="50" width="80"><span class="has-span">好友列表</span></p>
        <div>
            women
        </div>
    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {

            }
        },
        methods:{

        },
        computed:{

        },
        created(){

        },
        mounted(){

        },
        components:{

        },
    }
</script>

<!-- 本组件样式 -->
<style scoped>
    .tmpl-hasFriend{
        width:90%;
        margin:20px auto;
        border:1px solid blue;
    }
    .has-span{
        position: relative;
        top:-20px;
        left:-20px;
    }
</style>
