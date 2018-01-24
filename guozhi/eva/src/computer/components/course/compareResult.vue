<!-- 组件 -->
<template>
    <div class="tmpl">
        <div class="table">
            <table>
                <thead>
                    <tr>
                        <th>序号</th>
                        <th>课程编号</th>
                        <th>课程名称</th>
                        <th>最终评分</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="(item,index) in tableList" :key="index">
                        <td v-text="index+1"></td>
                        <td v-text="item.courseNum"></td>
                        <td v-text="item.courseName"></td>
                        <td v-text="item.totalCore==null?'未评价':item.totalCore"></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {
                tableList:[]
            }
        },
        components:{

        },
        created(){
            this.getCourseTeacher();
        },
        methods:{
            getCourseTeacher(){
                this.$http.axios({
                    url:'/evalution/getCourseTeacher',
                    method:'get',
                }).then(resolve=>{
                    this.tableList = resolve;
                }).catch(err=>{
                    console.log("失败了")
                })
            }
        }
    }
</script>

<!-- 本组件样式 -->
<style  scoped>
.table {
    width: 800px;
    margin: 0 auto;
    text-align: center;
    margin-top: 30px;
}
.table table {
    width: 100%;
    border: 1px solid RGBA(223, 223, 223, 1);
    font-size: 15px;
    color: #666666;
}
.table table caption{
    text-align: left;
    height: 30px;
    line-height: 30px;
    font-size: 16px;
}
caption span{
    margin-right:65px;
}
.table table tr{
    height:40px;
}
.table table tr td{
    width: 200px;
}
.table table tr th,.table table tr td {
    border: 1px solid RGBA(223, 223, 223, 1);
}
tfoot tr td{
    text-align: right;
    padding-right: 10px;
}
</style>
