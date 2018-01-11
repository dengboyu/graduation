<!-- 组件 -->
<template>
    <div class="tmpl">
        <ul>
            <li>1</li>
            <li>2</li>
            <li>3</li>
        </ul>
        第一个vue
        <p>当前登录信息是:姓名{{userInfo.name}},手机号:{{userInfo.phone}}</p>
        <p>登录状态1: {{isLogin?'是':'否'}}</p>
        <button @click="LOGIN">切换登录状态1</button>
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
        created(){
            // console.log(this.$store.state.userModule.userInfo.name);
            //请求后台的example
            this.$http.axios({
                url:this.$api.orderDetail,
                method:'get',
            }).then(resolve=>{
                console.log(resolve);
            }).catch(err=>{
                console.log("失败了")
            })

        },
        methods:{
            ...mapActions('userModule',[
                'LOGIN'
            ]),
        },
        computed:{
            ...mapState('userModule',[
                'userInfo',
                'isLogin',
            ]),
        },
        components:{

        }
    }
</script>

<!-- 本组件样式 -->
<style scoped>

</style>
