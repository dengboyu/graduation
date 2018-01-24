<!-- 学院下拉框组件 -->
<template>
    <div class="collegeSelect">
        <el-select v-model="value" placeholder="选择学院"  @change="changeCollege">
            <el-option v-for="item in college"
                :key="item.id"
                :label="item.collegeName"
                :value="item.id">
            </el-option>
        </el-select>
    </div>
</template>

<!-- 组件导出 -->
<script>
    import Bus from '../public/bus'
    export default{
        data(){
            return {
                college:[],
                value:''
            }
        },
        created(){
            this.getCollege();
        },
        mounted(){
            Bus.$on('resetCollegeSelect',()=>{
                this.value = '';
            })
        },
        components:{

        },
        methods:{
            getCollege(){
                this.$http.axios({
                    url:'/college/getCollegeList',
                    method:'get'
                }).then(resolve=>{
                    this.college = resolve;
                }).catch(err=>{
                    console.log("失败了")
                })
            },
            changeCollege(){
                let id = this.value;

                //清空专业值
                Bus.$emit('resetProfessionSelect');

                this.$http.axios({
                    url:'/college/getCollegeVoList?id='+id,
                    method:'get'
                }).then(resolve=>{
                    Bus.$emit('getProfessionSelect',resolve);
                }).catch(err=>{
                    console.log("失败了")
                })


                //返回选的id
                this.$emit('retValue',id);
            }
        }
    }
</script>

<!-- 本组件样式 -->
<style>
    .collegeSelect{
        display: inline-block;
    }
    .collegeSelect .el-input{
        width:100%;
    }
</style>
