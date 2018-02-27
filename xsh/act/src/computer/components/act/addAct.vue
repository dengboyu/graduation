<!-- 组件 -->
<template>
    <div class="detail-tmpl addAct">
        <p>
            <img src="../../../assets/img/act.jpg" height="50px" width="50">
            <span class="act-span">活动添加</span>
        </p>
        <div>
            <p class="act-det">
                <span>活动名称:</span>
                <el-input class="actName" v-model="actEntity.actName" placeholder="请输入活动名称"></el-input>
            </p>
            <p class="act-det">
                <span>活动负责人:</span>
                <el-input class="actName" style="width:48%" v-model="actEntity.actPerson" placeholder="请输入活动负责人"></el-input>
            </p>
            <p class="act-det">
                <span>组织单位:</span>
                <el-select v-model="actEntity.communityId" placeholder="请选择社团" style="width: 50%;">
                    <el-option :label="item.communityName" :value="item.id" v-for="(item,index) in communityList" :key="index"></el-option>
                </el-select>
            </p>
            <p class="act-det">
                <span>活动时间:</span>
                <el-date-picker style="width: 50%;" v-model="actEntity.actTime" type="datetime" placeholder="选择活动时间"></el-date-picker>
            </p>
            <p class="act-det">
                <span>活动地点:</span>
                <el-input class="actName" v-model="actEntity.actWhere" placeholder="请输入活动地点"></el-input>
            </p>
            <p class="act-det">
                <span>活动简介:</span>
                <el-input :autosize="{ minRows: 2}" type="textarea" v-model="actEntity.actIntro" placeholder="请输入活动简介"></el-input>
            </p>
            <p class="act-det">
                <span>活动详情:</span>
                <el-input :autosize="{ minRows: 5}" type="textarea" v-model="actEntity.actDetail" placeholder="请输入活动详情"></el-input>
            </p>
            <p class="act-det">
                <el-button type="primary" class="recommand" @click="addAct">发布活动</el-button>
            </p>
        </div>


    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {
                actEntity:{
                    actName:"",
                    actPerson:"",
                    communityId:"",
                    actTime:"",
                    actWhere:"",
                    actIntro:"",
                    actDetail:"",
                },
                communityList:[]
            }
        },
        methods:{
            addAct(){
                if(this.$fn.hasObjectNull(this.actEntity)){
                    return this.$message.warning("请将活动信息填完整");
                }

                this.$http.axios({
                    url:'/act/addActEntity',
                    method:'post',
                    data:this.actEntity,
                    json:true,
                }).then(resolve=>{
                    this.$router.push({path:'/admin/adminAct'});
                    this.$message.success("活动已发布");

                }).catch(err=>{
                    console.log("失败了")
                })

            },
            getCommunityList(){

                this.$http.axios({
                    url:'/community/getCommunityList',
                    method:'get',
                }).then(resolve=>{

                   this.communityList=resolve;

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
        width: 30%;
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
    .actName{
        width:50%;
        height:30px;
    }
</style>
