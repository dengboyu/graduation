<!-- 组件 -->
<template>
    <div class="tmpl">
        <div class="sidebar">
            <side-bar-admin v-if="identity==='2'"></side-bar-admin>
            <side-bar-student v-else-if="identity==='0'"></side-bar-student>
            <side-bar-teacher v-else></side-bar-teacher>
        </div>
        <div class="main">
            <header-vue></header-vue>
            <div class="center">
                <router-view></router-view>
            </div>
        </div>
    </div>
</template>

<!-- 组件导出 -->
<script>
    import headerVue from './header'
    import sideBarAdmin from './sidebarAdmin'
    import sideBarStudent from './sidebarStudent'
    import sideBarTeacher from './sidebarTeacher'
    import { mapState,mapGetters,mapMutations,mapActions } from 'vuex'

    export default{
        data(){
            return {

            }
        },
        created(){
            this.getMainInfo();
        },
        methods:{
            getMainInfo(){
                this.$http.axios({
                    url:'/userInfo/getCurrentUserInfo',
                    method:'get',
                }).then(resolve=>{
                    this.$store.dispatch('userModule/changeIdentity',resolve.identity);
                    this.$store.dispatch('userModule/changeUserName',resolve.username);
                }).catch(err=>{
                    console.log("失败了")
                })
            }
        },
        computed:{
            ...mapState('userModule',['identity']),
        },
        components:{
            sideBarAdmin,
            sideBarStudent,
            sideBarTeacher,
            headerVue,
        }
    }
</script>

<!-- 本组件样式 -->
<style scoped>
    .sidebar{
        width:12%;
        position: absolute;
        top:0px;
        bottom: 0px;
        background-color: #545c64;
    }
    .main{
        width:88%;
        position: absolute;
        left:12%;
        top:0px;
        bottom:0px;
    }
    .center{
        width:100%;
        position: absolute;
        top:50px;
        bottom:0px;
    }
</style>
