<!-- 组件 -->
<template>
    <div class="tmpl-hasFriend">
        <p>
            <img src="../../../assets/img/friend.png" height="50" width="80">
            <span class="has-span">院系列表</span>
            <span class="addGroup"><el-button type="text" @click.stop="addCollege" >添加学院</el-button></span>
        </p>
        <div>
            <div class="group-friend" v-for="(item,index) in groupList" :key="index">
                <p class="group-name"  @click="zhedie(item.id)">
                    {{item.groupName}}
                    <span class="addProfession"><el-button type="text" @click.stop="" >添加专业</el-button></span>
                </p>

                <ul class="group" v-for="(friend,index1) in item.friendList" :key="index1" v-show="item.boolean">
                    <li>
                        <span v-text="friend.username"></span>
                        <span class="group-right">
                            <!-- <span class="group-button group-del"><el-button type="text" @click.stop="delFriend">删除</el-button></span> -->
                        </span>
                    </li>
                </ul>
            </div>
        </div>


         <!-- 添加学院dialog -->
        <el-dialog title="添加学院" :visible.sync="addGroupVisible" width="30%">
            <p>
                <el-input v-model="input" placeholder="请输入学院名称"></el-input>
            </p>
            <span slot="footer" class="dialog-footer">
                <el-button type="primary" @click="addGroupVisible = false">确 定</el-button>
            </span>
        </el-dialog>

    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {
                addGroupVisible:false,
                form:{
                    name: '姓名',
                    region: '',
                    date1: '',
                    date2: '',
                    delivery: false,
                    type: [],
                    resource: '',
                    desc: ''
                },
                commonFriend:[
                    {
                        username:"李飞",
                    },
                    {
                        username:"赵四",
                    }
                ],
                input:'',
                groupList:[
                    {
                        groupName:'自定义分组',
                        id:1,
                        friendList:[
                            {
                                username:'朋友一',
                            },
                            {
                                username:'张雯',
                            }
                        ],
                        boolean:false,
                    },
                    {
                        groupName:'分组一',
                        id:2,
                        friendList:[
                            {
                                username:'朋友二',
                            }
                        ],
                        boolean:false,
                    },
                    {
                        groupName:'分组二',
                        id:3,
                        friendList:[
                            {
                                username:'朋友三',
                            }
                        ],
                        boolean:false,
                    }
                ]
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
            findFriendDetail(){
                this.detailFriendVisible=!this.detailFriendVisible;
            },
            moveGroup(){
                this.moveFriendVisible=!this.moveFriendVisible;
            },
            delFriend(){
                this.delFriendVisible = !this.delFriendVisible;
            },
            relativeFriend(){
                this.commonFriendVisible = !this.commonFriendVisible;
            },
            addCollege(){
                this.addGroupVisible = !this.addGroupVisible;
            }
        },
        computed:{

        },
        created(){

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
        position: relative;
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
    .addGroup{
        position: relative;
        top:-20px;
    }
    .addProfession{
        position: absolute;
        top: 0px;
        right: 5%;
    }
</style>
