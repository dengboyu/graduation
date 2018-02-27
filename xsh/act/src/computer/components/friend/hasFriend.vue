<!-- 组件 -->
<template>
    <div class="tmpl-hasFriend">
        <p><img src="../../../assets/img/friend.png" height="50" width="80"><span class="has-span">好友列表</span></p>
        <div>
            <div class="group-friend" v-for="(item,index) in groupList" :key="index">
                <p class="group-name" v-text="item.groupName" @click="zhedie(item.id)"></p>
                <ul class="group" v-for="(friend,index1) in item.friendMapList" :key="index1" v-show="item.boolean">
                    <li>
                        <span v-text="friend.name"></span>
                        <span class="group-right">
                            <!-- <span class="group-button group-info"><el-button type="text" @click.stop="relativeFriend">相关好友</el-button></span> -->
                            <span class="group-button group-info"><el-button type="text" @click.stop="findFriendDetail(friend.friendId)">好友信息</el-button></span>
                            <span class="group-button group-change"><el-button type="text" @click.stop="moveGroup(friend.friendId)">移动分组</el-button></span>
                            <span class="group-button group-del"><el-button type="text" @click.stop="delFriend(friend.friendId)">删除</el-button></span>
                        </span>
                    </li>
                </ul>
            </div>
        </div>

        <!-- 好友详情 -->
        <el-dialog title="好友信息" :visible.sync="detailFriendVisible" width="30%" class="friend-dialog">
            <el-form  ref="form" :model="form" label-width="80px">
                  <el-form-item label="学号:">
                    <span v-text="form.number"></span>
                  </el-form-item>
                  <el-form-item label="姓名:">
                    <span v-text="form.name"></span>
                  </el-form-item>
                  <el-form-item label="手机号:">
                    <span v-text="form.phone"></span>
                  </el-form-item>
                  <el-form-item label="学院:">
                    <span v-text="form.collegeName"></span>
                  </el-form-item>
                  <el-form-item label="专业:">
                    <span v-text="form.professionName"></span>
                  </el-form-item>
                  <el-form-item label="性别:">
                    <span v-text="form.sex"></span>
                  </el-form-item>
            </el-form>
        </el-dialog>

        <!-- 共同好友dialog -->
        <el-dialog title="可能认识的人" :visible.sync="commonFriendVisible" width="30%">
            <ul class="group-ul">
                <li v-for="(item,index) in commonFriend">
                    <span v-text="item.username"></span>
                    <el-button type="text" style="margin-left:60px;">添加为好友</el-button>
                </li>
            </ul>
        </el-dialog>

        <!-- 移动好友dialog -->
        <el-dialog title="请选择移动至分组" :visible.sync="moveFriendVisible" width="30%">
            <ul class="group-ul">
                <li v-for="(item,index) in groupList">
                    <el-radio v-model="move.groupId" :label="item.id">{{item.groupName}}</el-radio>
                </li>
            </ul>
            <span slot="footer" class="dialog-footer">
                <el-button type="primary" @click="moveGroupSure">确 定</el-button>
            </span>
        </el-dialog>

        <!-- 删除朋友dialog -->
        <el-dialog :visible.sync="delFriendVisible" width="30%">
            <span>确认删除该朋友吗?</span>
            <span slot="footer" class="dialog-footer">
                <el-button type="primary" @click="delFriendSure">确 定</el-button>
            </span>
        </el-dialog>

    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {
                form:{},
                commonFriend:[
                    {
                        username:"李飞",
                    },
                    {
                        username:"赵四",
                    }
                ],
                commonFriendVisible: false,
                delFriendVisible: false,
                moveFriendVisible: false,
                detailFriendVisible: false,
                groupList:[],
                move:{
                    groupId:'',
                    id:'',
                },
                delFriendId:'',
            }
        },
        methods:{
            zhedie(id){
                if(this.groupList.length>0){
                    for(let i in this.groupList){
                        if(id == this.groupList[i].id){
                            this.groupList[i].boolean=!this.groupList[i].boolean;
                        }else{
                            this.groupList[i].boolean=false;
                        }
                    }
                }
            },
            findFriendDetail(id){
                //获取详情
                this.$http.axios({
                    url:'/friend/getUserInfoMap?id='+id,
                    method:'get',
                }).then(resolve=>{
                     this.detailFriendVisible=!this.detailFriendVisible;
                     this.form = resolve;
                }).catch(err=>{
                    console.log("失败了")
                })
            },
            moveGroup(id){
                this.move.groupId = "";
                //移动分组
                this.move.id = id;
                this.moveFriendVisible=!this.moveFriendVisible;
            },
            moveGroupSure(){
                //移动分组
                if(this.move.groupId==''||this.move.id==''){
                    return this.$message.warning("请选择分组");
                }

                this.$http.axios({
                    url:'/friendGroup/updateFriendGroup',
                    method:'post',
                    data:this.move,
                    json:true
                }).then(resolve=>{
                     this.getGroupList();
                     this.moveFriendVisible=!this.moveFriendVisible;
                     this.$message.success("移动成功");
                }).catch(err=>{
                    console.log("失败了")
                })

            },
            delFriend(id){
                this.delFriendId=id;
                this.delFriendVisible = !this.delFriendVisible;
            },
            delFriendSure(){

                this.$http.axios({
                    url:'/friend/delFriend',
                    method:'post',
                    data:{id:this.delFriendId},
                }).then(resolve=>{
                     this.getGroupList();
                     this.delFriendVisible=!this.delFriendVisible;
                     this.$message.success("删除成功");
                }).catch(err=>{
                    console.log("失败了")
                })
            },
            relativeFriend(){
                this.commonFriendVisible = !this.commonFriendVisible;
            },
            getGroupList(){
                //获取分组

                this.$http.axios({
                    url:'/friendGroup/getGroupFriendList',
                    method:'get',
                }).then(resolve=>{
                    if(resolve.length>0){
                        for(let i in resolve){
                            resolve[i].boolean = false;
                        }
                    }
                    this.groupList = resolve;

                }).catch(err=>{
                    console.log("失败了")
                })

            },
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


</style>
