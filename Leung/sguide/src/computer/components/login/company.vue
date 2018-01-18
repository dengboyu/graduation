<!-- 组件 -->
<template>
    <div class="company-tmpl">
        <el-container>
            <el-aside width="200px">
                <el-menu default-active="2" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" :unique-opened="true" :router='true'>
                    <el-submenu index="1">
                        <template slot="title">
                            <i class="el-icon-tickets"></i>
                            <span>产品信息</span>
                        </template>
                        <el-menu-item index="1-1" :route='{"path":"/company/addProduct"}'>
                            <span slot="title" >添加产品</span>
                        </el-menu-item>
                    </el-submenu>
                    <el-submenu index="2">
                        <template slot="title">
                            <i class="el-icon-tickets"></i>
                            <span>企业信息</span>
                        </template>
                        <el-menu-item index="2-1" :route='{"path":"/company/queryCompany"}'>
                            <span slot="title">公司信息</span>
                        </el-menu-item>
                    </el-submenu>
                </el-menu>
            </el-aside>

            <el-main>
                <div class="main-top">
                    <span>XXXXX淘宝店信息</span>
                    <router-link to="/login" class="logout">【退出】</router-link>
                </div>
                <router-view></router-view>
            </el-main>
        </el-container>
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
            handleOpen(key, keyPath) {
                console.log(key, keyPath);
            },
            handleClose(key, keyPath) {
                console.log(key, keyPath);
            }
        },
        components:{

        }
    }
</script>

<!-- 本组件样式 -->
<style scoped>
.company-tmpl{
    position: absolute;
    top:0;
    bottom: 0;
    width:100%;
    overflow: overlay;
    background-color: blue;
}
.el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    padding-top:20px;
}
.el-main {
    background-color: #E9EEF3;
    color: #333;
    padding:0;
}
.company-tmpl > .el-container {
    height:100%;
}
.el-aside .el-menu{
    background-color: #D3DCE6;
}
.main-top{
    height:40px;
    line-height:40px;
    letter-spacing: 1px;
    background-color: #dedede;
    text-align: center;
}
.logout{
    display: inline-block;
    position: absolute;
    right:25px;
    color:#666;
}
.main-top a:hover{
    cursor: pointer;
    color:red;
}
</style>
