<!-- 组件 -->
<template>
    <div class="tmpl">
        <p class="header-pj">评教系统</p>
        <p class="header-identity">身份: <span v-text="identity===1?'管理员':(identity===2?'学生':'教师')"></span>&nbsp;&nbsp; | &nbsp;&nbsp;用户名: <span v-text="userName"></span> &nbsp;&nbsp;|&nbsp;&nbsp; <span @click="logout">退出</span></p>
    </div>
</template>

<!-- 组件导出 -->
<script>
    import { mapState,mapGetters,mapMutations,mapActions } from 'vuex'
    export default{
        data(){
            return {

            }
        },
        components:{

        },
        methods:{
            //退出
            logout(){
                this.$router.push({ path: '/login' });
            }
        },
        computed:{
            ...mapState("userModule",['identity','userName']),

        }
    }
</script>

<!-- 本组件样式 -->
<style scoped>
    .tmpl{
        width:100%;
        height:50px;
        background: #e8e5e5;
    }
    p{
        display: inline;
        height:50px;
    }
    .header-pj{
        position: absolute;
        top: 0px;
        bottom: 0px;
        left: 60px;
        line-height: 50px;
        font-size: 22px;
        color: #33776c;
        letter-spacing: 14px;
    }
    .header-identity{
        position: absolute;
        top:0px;
        bottom: 0px;
        right:20px;
        line-height:70px;
        font-size:14px;
    }
    .header-identity span:hover{
        color:red;
        cursor: pointer;
    }
    .header-identity{
        color:#6a6ada;
    }
</style>
