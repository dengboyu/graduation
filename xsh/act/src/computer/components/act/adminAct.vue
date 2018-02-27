<!-- 组件 -->
<template>
    <div class="act-tmpl">
        <p class="hasAct">
            <img src="../../../assets/img/act.jpg" height="50px" width="50">
            <span class="act-span">所有活动列表</span>
        </p>
        <el-table :data="tableData" border style="width: 100%">
            <el-table-column prop="actName" label="活动名称"></el-table-column>
            <el-table-column prop="actTime" label="活动时间" width="180"></el-table-column>
            <el-table-column prop="communityName" label="活动来源" width="180"></el-table-column>
            <el-table-column label="详情" width="120">
                <template slot-scope="scope">
                    <el-button type="text" size="small" @click="goDetail(scope.row.id)">查看详情</el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<!-- 组件导出 -->
<script>
    import scing from '../../../assets/img/scing.png'
    import sced from '../../../assets/img/sced.png'

    export default{
        data(){
            return {
                tableData: []
            }
        },
        methods:{
            goDetail(id){
                this.$router.push({name:'adminActDetail',params:{id:id}});
            },
            getActList(){

                this.$http.axios({
                    url:'/act/getActList',
                    method:'get',
                }).then(resolve=>{

                   this.tableData = resolve;

                }).catch(err=>{
                    console.log("失败了")
                })

            }
        },
        computed:{

        },
        created(){
            this.getActList();
        },
        mounted(){

        },
        components:{

        },
    }
</script>

<!-- 本组件样式 -->
<style scoped>
    .act-tmpl{
        width:70%;
        margin:auto;
        height:650px;
        overflow: auto;
    }
    .hasAct{
        height:50px;
        line-height: 30px;
        padding-left:30px;
        margin-bottom: 10px;
    }
    .act-span{
        position: relative;
        top:-20px;
    }
</style>
