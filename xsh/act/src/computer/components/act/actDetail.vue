<!-- 组件 -->
<template>
    <div class="detail-tmpl">
        <p>
            <img src="../../../assets/img/act.jpg" height="50px" width="50">
            <span class="act-span">活动详情</span>
        </p>
        <div>
            <p class="act-det">
                <span>活动名称:</span><span class="act-text">XXXX活动</span>
                <span class="act-right act-shop"><span>是否收藏:</span>
                    <span class="act-text">
                        <img :src="isShop?img.scing:img.sced" height="16" width="16" @click="goShop">
                    </span>
                </span>
            </p>
            <p class="act-det">
                <span>组织单位:</span><span class="act-text">校学生学会</span>
                <span class="act-right"><span>是否已经参加:</span><span class="act-text">否</span></span>
            </p>
            <p class="act-det">
                <span>活动时间:</span><span class="act-text">2018-02-12</span>
                <span class="act-right"><span>活动地点:</span><span class="act-text">大活动学生中心</span></span>
            </p class="act-det">
            <p class="act-det">
                <span>活动简介:</span><span class="act-text">活动简介</span>
            </p>
            <p class="act-det">
                <span>活动详情:</span><span class="act-text">活动详情</span>
            </p>
            <p class="act-det">
                <el-button type="primary" class="recommand">推荐给好友</el-button>
            </p>
        </div>
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
                isShop:true,
            }
        },
        methods:{
            goShop(){
                if(this.isShop){
                    this.$message.success('已收藏');
                }else{
                    this.$message.success('取消收藏');
                }
                this.isShop=!this.isShop;
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
    .detail-tmpl{
        width:60%;
        margin:0 auto;
        /*border:1px solid red;*/
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
</style>
