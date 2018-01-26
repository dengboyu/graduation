<!-- 组件 -->
<template>
    <div class="tmpl">
        <div class="main-top">
            <span style="display:inline-block;margin-right:15px;">添加备注信息</span>
            <el-input type="textarea" style="width:60%;" :rows="2" placeholder="请输入备注信息" v-model="remark"></el-input>
            <el-button type="primary" style="margin-left:40px" @click="insertRemark">添加</el-button>
        </div>
        <hr>
        <div class="main-botton">
            <span class="has-sort">已有备注:</span>
            <p v-for="(item,index) in remarkList" :key="item.id">{{index+1}}. {{item.remark}}</p>
        </div>
    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {
                remarkList:null,
                remark:null,
            }
        },
        components:{

        },
        methods:{
            insertRemark(){

                if(this.remark==null){
                    this.$message({
                        type:'success',
                        message:'请添加备注信息'
                    })
                    return;
                }
                this.$http.axios({
                    url:'/remark/insertRemarkEntity',
                    method:'post',
                    data:{remark:this.remark},
                    json:true,
                }).then(resolve=>{
                    this.getRemarkEntityList();

                    this.$message({
                        type:'success',
                        message:'添加成功'
                    })

                    this.remark = null;
                }).catch(err=>{
                    console.log("失败了")
                })

            },
            getRemarkEntityList(){
                this.$http.axios({
                    url:'/remark/getRemarkEntityList',
                    method:'get',
                }).then(resolve=>{


                    this.remarkList = resolve;
                }).catch(err=>{
                    console.log("失败了")
                })
            }
        },
        created(){
            this.getRemarkEntityList();
        }
    }
</script>

<!-- 本组件样式 -->
<style scoped>
    .tmpl{
        position: absolute;
        padding-top: 20px;
        top: 20%;
        left: 25%;
        width: 680px;
        height: 380px;
        background: #65c0e8;
    }
    .main-top{
        height:70px;
        margin-left:30px;
    }
    .main-botton{
        height:50px;
        margin-top:20px;
        margin-left:30px;
    }
    .main-botton p{
        margin-left:20px;
        font-size: 14px;
        margin-top:10px;
    }
</style>
