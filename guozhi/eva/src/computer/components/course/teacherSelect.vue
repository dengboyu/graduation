<!-- 学院下拉框组件 -->
<template>
    <div class="collegeSelect">
        <el-select v-model="value" placeholder="选择任课教师"  @change="changeTeacher">
            <el-option v-for="item in userInfo"
                :key="item.id"
                :label="item.username"
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
                userInfo:[],
                value:''
            }
        },
        created(){
            this.getCollege();
        },
        mounted(){
            Bus.$on('resetTeacherSelect',()=>{
                this.value = '';
            })
        },
        components:{

        },
        methods:{
            getCollege(){
                this.$http.axios({
                    url:'/userInfo/getUserInfoEntity?identity=1',
                    method:'get'
                }).then(resolve=>{
                    this.userInfo = resolve;
                }).catch(err=>{
                    console.log("失败了")
                })
            },
            changeTeacher(){
                let id = this.value;


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
