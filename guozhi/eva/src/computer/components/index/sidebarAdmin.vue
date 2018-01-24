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
                            <span>人员管理</span>
                        </template>
                        <el-menu-item index="1-1" :route='{"path":"/index/addStudent"}'>学生管理</el-menu-item>
                        <el-menu-item index="1-2" :route='{"path":"/index/addTeacher"}'>教师管理</el-menu-item>
                    </el-submenu>
                    <el-submenu index="2">
                        <template slot="title">
                            <i class="el-icon-menu"></i>
                            <span slot="title">课程信息管理</span>
                        </template>
                        <el-menu-item index="2-1" :route='{"path":"/index/addCourse"}'>添加课程信息</el-menu-item>
                        <el-menu-item index="2-2" :route='{"path":"/index/editCourse"}'>管理课程信息</el-menu-item>
                    </el-submenu>
                    <el-submenu index="3">
                        <template slot="title">
                            <i class="el-icon-menu"></i>
                            <span slot="title">院系管理</span>
                        </template>
                        <el-menu-item index="3-1" :route='{"path":"/index/college"}'>院系查询</el-menu-item>
                        <el-menu-item index="3-2" :route='{"path":"/index/addCollege"}'>添加学院信息</el-menu-item>
                        <el-menu-item index="3-3" :route='{"path":"/index/addPro"}'>添加专业信息</el-menu-item>
                    </el-submenu>
                    <el-submenu index="4">
                        <template slot="title">
                            <i class="el-icon-menu"></i>
                            <span slot="title">课程评比管理</span>
                        </template>
                        <el-menu-item index="4-1" :route='{"path":"/index/comparePro"}'>评比结果</el-menu-item>
                    </el-submenu>
                    <el-submenu index="5">
                        <template slot="title">
                            <i class="el-icon-menu"></i>
                            <span slot="title">系统管理</span>
                        </template>
                        <el-submenu index="5-1">
                            <template slot="title">评比项目管理</template>
                            <el-menu-item index="5-1-1" :route='{"path":"/index/addQuestion"}'>添加项目</el-menu-item>
                            <el-menu-item index="5-1-2" :route='{"path":"/index/questionShow"}'>项目信息</el-menu-item>
                        </el-submenu>
                        <el-submenu index="5-2">
                            <template slot="title">账户管理</template>
                            <el-menu-item index="5-2-1" :route='{"path":"/index/studentAccount"}'>学生账户管理</el-menu-item>
                            <el-menu-item index="5-2-2" :route='{"path":"/index/teacherAccount"}'>教师账户管理</el-menu-item>
                        </el-submenu>
                        <el-menu-item index="5-3" :route='{"path":"/index/config"}'>系统配置</el-menu-item>
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
