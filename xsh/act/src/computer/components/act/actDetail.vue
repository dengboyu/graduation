<!-- 组件 -->
<template>
    <div class="detail-tmpl">
        <p>
            <img src="../../../assets/img/act.jpg" height="50px" width="50">
            <span class="act-span">活动详情</span>
        </p>
        <div>
            <p class="act-det">
                <span>活动名称:</span><span class="act-text" v-text="actDetail.actName"></span>
                <span class="act-right act-shop"><span>是否收藏:</span>
                    <span class="act-text">
                        <img :src="actDetail.isCollection==0?img.scing:img.sced" height="16" width="16" @click="goShop(actDetail.id)">
                    </span>
                </span>
            </p>
            <p class="act-det">
                <span>组织单位:</span><span class="act-text" v-text="actDetail.communityName"></span>
                <span class="act-right"><span>活动地点:</span><span class="act-text">大活动学生中心</span></span>
            </p>
            <p class="act-det">
                <span>活动时间:</span><span class="act-text" v-text="actDetail.actTime"></span>
                <span class="act-right"><span>发布于:</span><span class="act-text" v-text="actDetail.createTime"></span></span>
            </p class="act-det">
            <p class="act-det">
                <span>活动简介:</span><br>
                <span class="act-text" v-text="actDetail.actIntro"></span>
            </p>
            <p class="act-det">
                <span>活动详情:</span><br>
                <span class="act-text" v-text="actDetail.actDetail"></span>
            </p>
            <p class="act-det">
                <el-button type="primary" class="recommand" @click="pushFriend">推荐给好友</el-button>
            </p>
        </div>

        <el-dialog title="推荐给好友" :visible.sync="dialogVisible" width="30%">
            <div>
                <p class="dialog-friend" v-for="(item,index) in friendList">
                    <el-checkbox v-model="item.checked">{{item.name}}</el-checkbox>
                </p>
            </div>
            <span slot="footer" class="dialog-footer">
                <el-button type="primary" @click="recommandSure">确 定</el-button>
            </span>
        </el-dialog>

    </div>
</template>

<!-- 组件导出 -->
<script>
    import scing from '../../../assets/img/scing.png'
    import sced from '../../../assets/img/sced.png'

    export default{
        data(){
            return {
                img:{
                    scing:scing,
                    sced:sced
                },
                dialogVisible:false,
                actDetail:{},
                friendList:[],
            }
        },
        methods:{
            goShop(id){

                if(this.actDetail.isCollection==0){

                    this.$http.axios({
                        url:'/collect/addCollectEntity',
                        method:'post',
                        data:{id:id},
                    }).then(resolve=>{

                        this.actDetail.isCollection=1;
                        this.$message.success('已收藏');

                    }).catch(err=>{
                        console.log("失败了")
                    })

                }else{

                    this.$http.axios({
                        url:'/collect/delCollectEntity',
                        method:'post',
                        data:{id:id},
                    }).then(resolve=>{

                        this.actDetail.isCollection=0;
                        this.$message.success('取消收藏');

                    }).catch(err=>{
                        console.log("失败了")
                    })
                }

            },
            pushFriend(){
                //推荐好友
                this.$http.axios({
                    url:'/friend/getCommandFriend?actId='+this.actDetail.id,
                    method:'get',
                }).then(resolve=>{
                    this.dialogVisible=!this.dialogVisible;

                    for(let i in resolve){
                        resolve[i].checked = false;
                    }
                    this.friendList = resolve;

                }).catch(err=>{
                    console.log("失败了")
                })

            },
            recommandSure(){
                //推荐好友
                let recommandList = [];

                for(let i in this.friendList){
                    if(this.friendList[i].checked){
                        let recommandActEntity = {};
                        recommandActEntity.actId = this.actDetail.id;
                        recommandActEntity.recommandUser = this.friendList[i].id;

                        recommandList.push(recommandActEntity);
                    }
                }

                if(recommandList.length<1){
                    this.$message.warning("请选择好友");
                }else{

                    this.$http.axios({
                        url:'/recommandAct/recommandAct',
                        method:'post',
                        data:recommandList,
                        json:true,
                    }).then(resolve=>{
                        this.dialogVisible=!this.dialogVisible;
                        this.$message.success("推荐成功");

                    }).catch(err=>{
                        console.log("失败了")
                    })

                }
            },
            getActDetail(id){

                this.$http.axios({
                    url:'/act/getActDetail?id='+id,
                    method:'get',
                }).then(resolve=>{

                    this.actDetail = resolve;
                }).catch(err=>{
                    console.log("失败了")
                })

            }
        },
        computed:{

        },
        created(){
            this.getActDetail(this.$route.params.id);
        },
        mounted(){

        },
        components:{

        },
    }
</script>

<!-- 本组件样式 -->
<style scoped>
    .detail-tmpl{
        width:60%;
        margin:0 auto;
    }
    .act-det{
        margin-top:15px;
    }
    .act-right{
        float:right;
        margin-right:20px;
        width: 35%;
    }
    .act-text{
        margin-left:10px;
    }
    .recommand{
        width:20%;
        margin: 0 40%;
        margin-top:20px;
    }
    .act-span{
        position: relative;
        top:-20px;
    }
    .act-shop img:hover{
        cursor: pointer;
    }
    .dialog-friend{
        text-align: left;
        height:30px;
        line-height:30px;
    }
</style>
