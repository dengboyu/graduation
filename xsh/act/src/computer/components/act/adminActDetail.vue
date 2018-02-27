<!-- 组件 -->
<template>
    <div class="detail-tmpl">
        <p>
            <img src="../../../assets/img/act.jpg" height="50px" width="50">
            <span class="act-span">活动详情</span>
        </p>
        <div>
            <p class="act-det">
                <span>活动名称:</span><span class="act-text" v-text="act.actName"></span>
                <span class="act-right act-shop">
                    <span>负责人:</span>
                    <span class="act-text" v-text="act.actPerson"></span>
                </span>
            </p>
            <p class="act-det">
                <span>组织单位:</span><span class="act-text" v-text="act.communityName"></span>
                <span class="act-right"><span>活动地点:</span><span class="act-text" v-text="act.actWhere"></span></span>
            </p>
            <p class="act-det">
                <span>活动时间:</span><span class="act-text" v-text="act.actTime"></span>
                <span class="act-right">
                    <span>发布于:</span>
                    <span class="act-text" v-text="act.createTime"></span>
                </span>
            </p class="act-det">
            <p class="act-det">
                <span>活动简介:</span><br>
                <span class="act-text" v-text="act.actIntro"></span>
            </p>
            <p class="act-det">
                <span>活动详情:</span><br>
                <span class="act-text" v-text="act.actDetail"></span>
            </p>
        </div>



    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {
                act:{},
            }
        },
        methods:{
            getAdminActDetail(id){

                this.$http.axios({
                    url:'/act/getAdminActDetail?id='+id,
                    method:'get',
                }).then(resolve=>{

                    this.act = resolve;
                }).catch(err=>{
                    console.log("失败了")
                })

            }

        },
        computed:{

        },
        created(){
            this.getAdminActDetail(this.$route.params.id);
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
