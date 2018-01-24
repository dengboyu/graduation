<!-- 组件 -->
<template>
    <div class="tmpl">
        <p class="sel-look">学院专业查看</p>
        <el-tree :data="data" :props="defaultProps" :accordion="true" @node-click="handleNodeClick"></el-tree>
    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {
                data: [],
                defaultProps: {
                    children: 'children',
                    label: 'label'
                }
            }
        },
        methods:{
            handleNodeClick(data) {
                //console.log(data);
            },
            getCollegeAndPro(){
                this.$http.axios({
                    url:'/college/getCollegeVoList',
                    method:'get'
                }).then(resolve=>{
                    if(resolve.length>0){
                        for(let i in resolve){
                            resolve[i].label = resolve[i].collegeName;
                            resolve[i].children = resolve[i].professionEntityList;
                            for(let m in resolve[i].children){
                                resolve[i].children[m].label = resolve[i].children[m].proName;
                            }
                        }
                        this.data = resolve;
                    }
                }).catch(err=>{
                    console.log("失败了")
                })
            }
        },
        created(){
            this.getCollegeAndPro();
        },
        components:{

        }
    }
</script>

<!-- 本组件样式 -->
<style scoped>
    .tmpl{
        position: relative;
        top: 30px;
        left: 50px;
    }
    .sel-look{
        margin-left: -10px;
        margin-bottom: 20px;
        color: #797474;
    }
</style>
