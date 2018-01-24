<!-- 学院下拉框组件 -->
<template>
    <div class="professionSelect">
        <el-select v-model="value" placeholder="选择专业"  @change="changeProfession">
            <el-option v-for="item in profession"
                :key="item.id"
                :label="item.proName"
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
                profession:[],
                value:''
            }
        },
        created(){

        },
        mounted(){
            //清空专业值
            Bus.$on('resetProfessionSelect',()=>{
                this.value = '';
            }),
            //专业值
            Bus.$on('getProfessionSelect',param=>{
                this.profession = param[0].professionEntityList;
            })
        },
        components:{

        },
        methods:{
            //返回选的专业值
            changeProfession(){
                this.$emit('retProfessionValue',this.value);
            }
        }
    }
</script>

<!-- 本组件样式 -->
<style>
    .professionSelect{
        display: inline-block;
    }
    .professionSelect .el-input{
        width:100%;
    }
</style>
