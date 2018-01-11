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
                            <span>信息查询</span>
                        </template>
                        <el-menu-item index="1-1" :route='{"path":"/index/compareResult"}'>评比结果</el-menu-item>
                        <el-menu-item index="1-2" :route='{"path":"/index/infoTeacher"}'>个人信息</el-menu-item>
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
