<!-- 组件 -->
<template>
    <div class="tmpl-hasFriend">
        <p>
            <img src="../../../assets/img/friend.png" height="50" width="80">
            <span class="has-span">分组管理</span>
            <span class="addGroup"><el-button type="text" @click.stop="addGroupVisible=true">添加分组</el-button></span>
        </p>
        <div>
            <div class="group-friend" v-for="(item,index) in groupList" :key="index">
                <p class="group-name">
                    <span v-text="item.groupName"></span>
                    <span class="delGroup"><el-button type="text" @click.stop="delGroupId(item.id)">删除</el-button></span>
                </p>
            </div>
        </div>


        <!-- 添加分组dialog -->
        <el-dialog title="添加分组" :visible.sync="addGroupVisible" width="30%">
            <p>
                <el-input v-model="group.groupName" placeholder="请输入分组名称"></el-input>
            </p>
            <span slot="footer" class="dialog-footer">
                <el-button type="primary" @click="addGroup">确 定</el-button>
            </span>
        </el-dialog>

        <!-- 删除朋友dialog -->
        <el-dialog :visible.sync="delGroupVisible" width="30%">
            <span>确认删除该分组吗?</span>
            <span slot="footer" class="dialog-footer">
                <el-button type="primary" @click="delGroup()">确 定</el-button>
            </span>
        </el-dialog>

    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {
                addGroupVisible: false,
                delGroupVisible: false,
                delId:'',
                group:{
                    groupName:""
                },
                groupList:[]
            }
        },
        methods:{
            addGroup(){

                this.$http.axios({
                    url:'/friendGroup/addGroupByUserId',
                    method:'post',
                    data:this.group,
                    json:true
                }).then(resolve=>{
                    this.getGroupList();

                    this.addGroupVisible = !this.addGroupVisible;
                    this.$message.success("添加分组成功");
                    this.group.groupName='';


                }).catch(err=>{
                    console.log("失败了")
                })

            },
            delGroup(){
                //删除分组

                this.$http.axios({
                    url:'/friendGroup/delFriendGroup',
                    method:'post',
                    data:{id:this.delId},
                }).then(resolve=>{
                    this.getGroupList();

                    this.delGroupVisible = !this.delGroupVisible;
                    this.$message.success("删除成功");

                }).catch(err=>{
                    console.log("失败了")
                })

            },
            getGroupList(){
                //获取分组

                this.$http.axios({
                    url:'/friendGroup/getGroupFriendList',
                    method:'get',
                }).then(resolve=>{

                    this.groupList = resolve;


                }).catch(err=>{
                    console.log("失败了")
                })

            },
            delGroupId(id){
                this.delGroupVisible = !this.delGroupVisible;
                this.delId = id;
            }
        },
        computed:{

        },
        created(){
            this.getGroupList();
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
        width:40%;
        height:620px;
        margin:20px auto;
        border:1px solid #d2d2de;
        overflow: auto;
    }
    .has-span{
        position: relative;
        top:-20px;
        left:-20px;
    }
    .group-friend{
        border-top: 1px solid #e0d9d9;
    }
    .group-friend:last-child{
        border-bottom: 1px solid #e0d9d9;
    }
    .group-name{
        width:100%;
        box-sizing: border-box;
        height:40px;
        line-height: 40px;
        color: #000;
        background-color: #eaeaea;
        padding-left: 30px;
        font-size: 15px;
    }
    .group-name:hover{
        cursor: pointer;
    }
    .group li{
        height:30px;
        background-color: #e0e0e0;
        line-height: 30px;
        box-sizing: border-box;
        border-top:1px solid #d6d6e0;
        padding-left:50px;
        font-size: 14px;
    }
    .group li:last-child{
        border-bottom:1px solid #d6d6e0;
    }
    .group-right{
        float:right;
        margin-right:10px;
    }
    .group-ul{
        width:60%;
        margin:0 auto;
        text-align:left;
    }
    .group-ul li{
        height:30px;
        line-height: 30px;
    }
    .delGroup{
        float:right;
        margin-right:10px;
    }
    .delGroup .el-button{
        font-size:12px;
    }
    .addGroup{
        position: relative;
        top:-20px;
    }
</style>
