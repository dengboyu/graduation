<!-- 组件 -->
<template>
    <div class="tmpl-hasFriend">
        <p>
            <img src="../../../assets/img/friend.png" height="50" width="80">
            <span class="has-span">社团管理</span>
            <span class="addGroup"><el-button type="text" @click.stop="addGroupVisible=true">添加社团</el-button></span>
        </p>
        <div>
            <div class="group-friend" v-for="(item,index) in groupList" :key="index">
                <p class="group-name">
                    <span v-text="item.communityName"></span>
                    <!-- <span class="delGroup"><el-button type="text" @click.stop="delGroup" class="">删除</el-button></span> -->
                </p>
            </div>
        </div>



        <!-- 添加分组dialog -->
        <el-dialog title="添加社团" :visible.sync="addGroupVisible" width="30%">
            <p>
                <el-input v-model="community.communityName" placeholder="请输入社团名称"></el-input>
            </p>
            <span slot="footer" class="dialog-footer">
                <el-button type="primary" @click="addCommunity">确 定</el-button>
            </span>
        </el-dialog>

        <!-- 删除朋友dialog -->
        <el-dialog :visible.sync="delGroupVisible" width="30%">
            <span>确认删除该社团吗?</span>
            <span slot="footer" class="dialog-footer">
                <el-button type="primary" @click="delGroupVisible = false">确 定</el-button>
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
                community:{
                    communityName:'',
                },
                groupList:[]
            }
        },
        methods:{
            addCommunity(){

                this.$http.axios({
                    url:'/community/addCommunity',
                    method:'post',
                    data:this.community,
                    json:true
                }).then(resolve=>{

                    this.getCommunityList();

                    this.addGroupVisible = !this.addGroupVisible;
                    this.community.communityName = '';

                    this.$message.success('添加社团成功');
                }).catch(err=>{
                    console.log("失败了")
                })


            },
            delGroup(){
                this.delGroupVisible = !this.delGroupVisible;
            },
            getCommunityList(){

                this.$http.axios({
                    url:'/community/getCommunityList',
                    method:'get',
                }).then(resolve=>{

                   this.groupList=resolve;

                }).catch(err=>{
                    console.log("失败了")
                })

            }
        },
        computed:{

        },
        created(){
            this.getCommunityList();
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
