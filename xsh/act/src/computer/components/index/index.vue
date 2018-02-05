<!-- 组件 -->
<template>
    <div class="tmpl">
        <el-container>
            <el-header>
                <p class="index-hd">校园活动推荐系统</p>
                <p class="index-lgout">
                    用户名:<span style="margin-left:5px" v-text="username"></span>
                    <span class="logout">[退出]</span>
                </p>
            </el-header>
            <el-container>
                <el-aside width="200px">
                    <el-menu default-active="2" class="el-menu-vertical-demo" background-color="#dae7fa" active-text-color="gray" :unique-opened="true" :router="true">
                        <el-submenu index="1">
                            <template slot="title">
                              <span>活动信息</span>
                            </template>
                            <el-menu-item index="1-1" :route='{"path":""}'>活动列表</el-menu-item>
                            <el-menu-item index="1-2" :route='{"path":""}'>活动收藏</el-menu-item>
                            </el-submenu>
                        </el-submenu>
                        <el-submenu index="2">
                            <template slot="title">
                              <span>好友管理</span>
                            </template>
                            <el-menu-item index="2-1" :route='{"path":"/index/hasFriend"}'>好友列表</el-menu-item>
                            <el-menu-item index="2-2" :route='{"path":"/index/addFriend"}'>添加好友</el-menu-item>
                            </el-submenu>
                        </el-submenu>
                        <el-submenu index="3">
                            <template slot="title">
                              <span>个人信息</span>
                            </template>
                            <el-menu-item index="3-1" :route='{"path":"/index/query"}'>查看信息</el-menu-item>
                            <el-menu-item index="3-2" :route='{"path":"/index/update"}'>修改信息</el-menu-item>
                            </el-submenu>
                        </el-submenu>
                    </el-menu>
                </el-aside>
                <el-main>
                    <router-view></router-view>
                </el-main>
            </el-container>
        </el-container>

    </div>
</template>

<!-- 组件导出 -->
<script>
    import example from '@/computer/components/example'         //示例

    export default{
        data(){
            return {
                username:'张雯',
            }
        },
        created(){

        },
        methods:{

        },
        components:{

        }
    }
</script>

<!-- 本组件样式 -->
<style scoped>
    .tmpl{
        position: absolute;
        top:0;
        bottom: 0;
        width:100%;
        overflow: overlay;
    }
    .el-container{
        height: 100%;
    }
    .el-header{
        color: #333;
        text-align: center;
        line-height: 60px;
    }
    .el-aside {
        background-color: rgb(218, 231, 250);
        color: #333;
        text-align: center;
        border-right: 1px solid #e8dddd;
    }
    .el-main {
        background-color: #E9EEF3;
        color: #333;
    }
    .index-hd{
        font-size:18px;
        letter-spacing: 1px;
    }
    .index-lgout{
        position: absolute;
        top:10px;
        right:20px;
    }
    .logout{
        margin-left:20px;
        font-size:14px;
    }
    .logout:hover{
        color:red;
        cursor: pointer;
    }

</style>
