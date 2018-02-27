<!-- 组件 -->
<template>
    <div class="tmpl-update">
        <p class="img-top"><img src="../../../assets/img/p1.png" height="50" width="50"><span>添加系统好友</span></p>
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="学号">
            <el-input v-model="number" type="number"  class="input-width" placeholder="请输入学号"></el-input>
            <el-button type="text" @click="getFriendInfo">查 询</el-button>
          </el-form-item>
          <div v-if="friend">
              <el-form-item label="姓名">
                <span v-text="form.name"></span>
              </el-form-item>
              <el-form-item label="邮箱">
                <span v-text="form.email"></span>
              </el-form-item>
              <el-form-item label="手机号">
                <span v-text="form.phone"></span>
              </el-form-item>
              <el-form-item label="分组">
                <el-select v-model="friendEntity.groupId" placeholder="请选择分组" @change="">
                  <el-option :label="item.groupName" :value="item.id" v-for="(item,index) in groupList" :key="index"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="学院">
                <span v-text="form.collegeName"></span>
              </el-form-item>
              <el-form-item label="专业">
                <span v-text="form.professionName"></span>
              </el-form-item>
              <el-form-item label="性别">
                <span v-text="form.sex"></span>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="addFriend">添 加</el-button>
              </el-form-item>
          </div>
          <div v-else class="not-friend">系统没有该用户</div>
        </el-form>
    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {
                friend:false,
                number:'',
                form: {},
                groupList:[],
                friendEntity:{
                    groupId:'',
                    friendId:'',
                }
            }
        },
        methods:{
            addFriend(){
                this.friendEntity.friendId = this.form.id;

                if(this.friendEntity.groupId=="" || this.friendEntity.frinendId==""){
                    return this.$message.warning("请选择分组");
                }

                this.$http.axios({
                    url:'/friend/addFriend',
                    method:'post',
                    data:this.friendEntity,
                    json:true
                }).then(resolve=>{

                    this.$router.push({path:'/index/hasFriend'});
                    this.$message.success("添加成功");

                }).catch(err=>{
                    console.log("失败了");
                })

            },
            getFriendInfo(number){

                if(this.number==''){
                    return this.$message.warning('请输入学号再查询');
                }

                this.$http.axios({
                    url:'/sysUser/getFriendInfo?number='+this.number,
                    method:'get',
                }).then(resolve=>{
                    if(resolve!=null){

                        //查询分组
                        this.getGroupList();

                        this.friend = true;
                        this.form = resolve;
                    }else{
                        this.friend = false;
                        this.form = {};
                    }

                }).catch(err=>{
                    console.log("失败了");
                })

            },
            getGroupList(){
                //获取分组

                this.$http.axios({
                    url:'/friendGroup/getGroupFriendList',
                    method:'get',
                }).then(resolve=>{

                    this.groupList = resolve;


                }).catch(err=>{
                    console.log("失败了")
                })

            },
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
    .tmpl-update{
        width:500px;
        margin:20px auto;
        border:1px solid #d2cece;
    }
    .img-top{
        height:60px;
        margin-top:10px;
        padding-left:20px;
    }
    .img-top span{
        position: relative;
        display: inline-block;
        top:-15px;
        left:10px;
    }
    .el-form{
        margin-top:20px;
    }
    .input-width{
        width:80%;
    }
    .el-select,.el-button--primary{
        width:336px;
    }
    .not-friend{
        width: 100%;
        height: 30px;
        line-height: 30px;
        padding: 0px 180px;
    }
</style>
