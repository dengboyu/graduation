<!-- 组件 -->
<template>
    <div class="tmpl">
        <el-table :data="tableData" stripe style="width: 100%">
            <el-table-column prop="number" label="学号" width="180"></el-table-column>
            <el-table-column label="姓名"  width="180">
                <template slot-scope="scope">
                    <span v-if="scope.row.flag" v-text="scope.row.username"></span>
                    <el-input v-else type="text" v-model="scope.row.username"  width="180"></el-input>
                </template>
            </el-table-column>
            <el-table-column prop="collegeName" label="学院"></el-table-column>
            <el-table-column prop="proName" label="专业"></el-table-column>
            <el-table-column label="邮箱" width="180">
                <template slot-scope="scope">
                    <span v-if="scope.row.flag" v-text="scope.row.email"></span>
                    <el-input v-else type="text" v-model="scope.row.email"  width="180"></el-input>
                </template>
            </el-table-column>
            <el-table-column label="手机" width="180">
                <template slot-scope="scope">
                    <span v-if="scope.row.flag" v-text="scope.row.phone"></span>
                    <el-input v-else type="text" v-model="scope.row.phone"  width="180"></el-input>
                </template>
            </el-table-column>
            <el-table-column  label="操作">
                <template slot-scope="scope">
                    <el-button @click="handleClick(scope.row)" type="text" size="small">{{scope.row.updateInfo}}</el-button>
                    <el-button @click="deleteClick(scope.row)" type="text" size="small">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {
                tableData: [

                ]
            }
        },
        created(){
            this.getUserInfoList();
        },
        methods: {
            handleClick(row) {
                console.log(row.flag);

                if(row.flag){
                    row.updateInfo = '确定';
                    row.flag = !row.flag;
                }else{
                    this.$http.axios({
                        url:'/userInfo/updateUserInfoEntity',
                        method:'post',
                        json:true,
                        data:row,
                    }).then(resolve=>{
                        this.$message({
                            type: 'success',
                            message: '修改成功!'
                        });

                        row.updateInfo = '修改';
                        row.flag = !row.flag;

                    }).catch(err=>{
                        console.log("失败了"+err)
                    })
                }
            },
            deleteClick(row){
                this.$confirm('是否将该学生删除?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {

                    this.$http.axios({
                        url:'/userInfo/deleteUserInfo',
                        method:'post',
                        data:{id:row.id},
                    }).then(resolve=>{
                        this.$message({
                            type: 'success',
                            message: '删除成功!'
                        });

                        this.tableData.splice(row.$index,1);

                    }).catch(err=>{
                        console.log("失败了"+err)
                    })
                }).catch(()=>{});
            },
            getUserInfoList(){
                //
                this.$http.axios({
                    url:'/userInfo/getUserInfoList?identity=0',
                    method:'get',
                }).then(resolve=>{
                    if(resolve.length>0){
                        for(let i in resolve){
                            resolve[i].flag =true;
                            resolve[i].updateInfo ='修改';
                        }
                    }

                    this.tableData = resolve;

                }).catch(err=>{
                    console.log("失败了"+err)
                })
            }
        },
        components:{

        }
    }
</script>

<!-- 本组件样式 -->
<style scoped>
    .el-input{
        width:100%;
    }
</style>
