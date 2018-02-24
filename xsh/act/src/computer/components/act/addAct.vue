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
                <el-input class="actName" v-model="input" placeholder="请输入活动名称"></el-input>
            </p>
            <p class="act-det">
                <span>活动负责人:</span>
                <el-input class="actName" style="width:48%" v-model="input" placeholder="请输入活动负责人"></el-input>
            </p>
            <p class="act-det">
                <span>组织单位:</span>
                <el-select v-model="value1" placeholder="请选择社团" style="width: 50%;">
                    <el-option label="社团一" value="shanghai"></el-option>
                    <el-option label="社团二" value="beijing"></el-option>
                </el-select>
            </p>
            <p class="act-det">
                <span>活动时间:</span>
                <el-date-picker style="width: 50%;" v-model="value1" type="datetime" placeholder="选择活动时间"></el-date-picker>
            </p>
            <p class="act-det">
                <span>活动地点:</span>
                <el-input class="actName" v-model="input" placeholder="请输入活动地点"></el-input>
            </p>
            <p class="act-det">
                <span>活动简介:</span>
                <el-input :autosize="{ minRows: 2}" type="textarea" v-model="input" placeholder="请输入活动简介"></el-input>
            </p>
            <p class="act-det">
                <span>活动详情:</span>
                <el-input :autosize="{ minRows: 5}" type="textarea" v-model="input" placeholder="请输入活动详情"></el-input>
            </p>
            <p class="act-det">
                <el-button type="primary" class="recommand" @click="">发布活动</el-button>
            </p>
        </div>


    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {
                isShop:true,
                dialogVisible:false,
                input:'',
                value1:'',
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
