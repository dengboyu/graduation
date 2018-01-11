<!-- 组件 -->
<template>
    <div class="tmpl">
        <el-row>
            <el-col>
                <el-menu default-active="1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" background-color="#545c64"
                    text-color="#fff" active-text-color="#ffd04b" :unique-opened="true" :router='true'>
                    <el-submenu index="1">
                        <template slot="title">
                            <i class="el-icon-menu"></i>
                            <span>评教</span>
                        </template>
                        <el-menu-item index="1-1" :route='{"path":"/index/compareStudent"}'>进行评教</el-menu-item>
                    </el-submenu>
                    <el-submenu index="2">
                        <template slot="title">
                            <i class="el-icon-menu"></i>
                            <span slot="title">个人信息</span>
                        </template>
                        <el-menu-item index="2-1" :route='{"path":"/index/infoStudent"}'>查看个人信息</el-menu-item>
                    </el-submenu>
                </el-menu>
            </el-col>
        </el-row>
    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {

            }
        },
        methods: {
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
    .el-submenu .el-menu-item{
        min-width: 0px;
    }
    .el-menu{
        border-right: none;
    }
</style>
