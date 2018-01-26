<!-- 组件 -->
<template>
    <div class="tmpl">
        <div class="top">
            <el-menu  :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect" :router='true'>
                <el-submenu index="1">
                    <template slot="title">报价单</template>
                    <el-menu-item index="1-1" :route='{"path":"/index/addQuotation"}'>新建报价单</el-menu-item>
                    <el-menu-item index="1-2" :route='{"path":"/index/queryQuotation"}'>查询报价单</el-menu-item>
                    <el-menu-item index="1-3" :route='{"path":"/index/queryRemark"}'>备注信息</el-menu-item>
                </el-submenu>
                <el-submenu index="2">
                    <template slot="title">公司信息</template>
                    <el-menu-item index="2-1" :route='{"path":"/index/addCompany"}'>添加公司</el-menu-item>
                    <el-menu-item index="2-2" :route='{"path":"/index/queryCompany"}'>查询公司</el-menu-item>
                </el-submenu>
                <el-submenu index="3">
                    <template slot="title">客户信息</template>
                    <el-menu-item index="3-1" :route='{"path":"/index/linkName"}'>添加客户</el-menu-item>
                    <el-menu-item index="3-2" :route='{"path":"/index/addCustomer"}'>客户信息</el-menu-item>
                </el-submenu>
                <el-submenu index="4">
                    <template slot="title">产品信息</template>
                    <el-menu-item index="4-1" :route='{"path":"/index/sortProduct"}'>产品分类</el-menu-item>
                    <el-menu-item index="4-2" :route='{"path":"/index/product"}'>产品管理</el-menu-item>
                </el-submenu>
                <el-menu-item index="5" :route='{"path":"/index/link"}'>联系我们</el-menu-item>
            </el-menu>
            <div class="line"></div>
            <div class="top-center">
                外协企业智能报价单系统
            </div>
            <div class="top-right">
                您好: <span v-text="userInfo.username"></span> <span style="margin-left:20px">[<router-link to="/login">退出</router-link>]&nbsp;&nbsp;&nbsp;[切换]</span>
            </div>
        </div>
        <div>
            <router-view></router-view>
        </div>
    </div>
</template>

<!-- 组件导出 -->
<script>
    import {mapState,mapActions} from 'vuex'
    import Bus from '../public/bus'
    export default{
        data(){
            return {
                activeIndex: '1',
                activeIndex2: '1',
                userInfo:'',
            }
        },
        created(){

        },
        methods:{
            handleSelect(key, keyPath) {
                console.log(key, keyPath);
            },
            getCurrentUser(){
                this.$http.axios({
                    url:'/userInfo/getUserInfoEntity',
                    method:'get',
                }).then(resolve=>{
                    this.userInfo = resolve;
                }).catch(err=>{
                    console.log("失败了")
                })
            }
        },
        computed:{

        },
        components:{

        },
        created(){
            this.getCurrentUser();
        },
        mounted(){

        }
    }
</script>

<!-- 本组件样式 -->
<style scoped>
    .el-menu{
        width:100%;
        /*padding-left: 430px;*/
    }
    .top{
        height:60px;
    }
    .top-center{
        position: absolute;
        top: 0px;
        right: 17%;
        height: 60px;
        line-height: 39px;
        font-size: 20px;
        font-style: italic;
        letter-spacing: 6px;
    }
    .top-right{
        font-size: 14px;
        position: absolute;
        top:0px;
        right:0px;
        display: inline-block;
        height:60px;
        line-height: 88px;
        width:16%;
    }
    .el-menu .el-menu-item{
        font-size: 16px;
    }
    .el-submenu{
        width:10%;
    }
</style>
