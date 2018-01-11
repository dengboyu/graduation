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
                        <td v-text="item.snumber"></td>
                        <td v-text="item.sname"></td>
                        <td v-text="item.score"></td>
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
                tableList:[
                    {
                        "snumber":1230322,
                        "sname":"市场营销",
                        "score":90,
                    },
                    {
                        "snumber":1230321,
                        "sname":"经济与管理",
                        "score":70,
                    },
                ]
            }
        },
        components:{

        },
        methods:{

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
