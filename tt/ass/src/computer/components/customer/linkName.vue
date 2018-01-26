<!-- 组件 -->
<template>
    <div class="tmpl editProduct">
        <span style="margin-left:290px;margin-bottom:10px;display:inline-block">添加客户信息</span>
        <el-form ref="form" :model="form" label-width="90px" :inline="true">
            <el-form-item label="公司名称" style="width:39.5%">
                <el-select v-model="form.companyId" placeholder="请选择">
                    <el-option v-for="item in companylist" :key="item.id" :label="item.comName" :value="item.id"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="联系人姓名">
                <el-input v-model="form.linkName"></el-input>
            </el-form-item>
            <el-form-item label="职务">
                <el-input v-model="form.post"></el-input>
            </el-form-item>
            <el-form-item label="性别" class="sex">
                <el-select v-model="form.sex" placeholder="请选择">
                    <el-option  label="男" value="男"></el-option>
                    <el-option  label="女" value="女"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="手机号码">
                <el-input v-model="form.phone" :maxlength="11"></el-input>
            </el-form-item>
            <el-form-item label="联系电话">
                <el-input v-model="form.tel"></el-input>
            </el-form-item>
            <el-form-item label="旺旺号码">
                <el-input v-model="form.wwTel"></el-input>
            </el-form-item>
            <el-form-item label="传真号码">
                <el-input v-model="form.fax"></el-input>
            </el-form-item>
            <el-form-item label="QQ">
                <el-input v-model="form.qq"></el-input>
            </el-form-item>
            <el-form-item label="MSN">
                <el-input v-model="form.msn"></el-input>
            </el-form-item>
            <el-form-item label="联系地址">
                <el-input v-model="form.address"></el-input>
            </el-form-item>
            <el-form-item label="Email">
                <el-input v-model="form.email"></el-input>
            </el-form-item>
            <el-form-item label="备注">
                <el-input type="textarea" v-model="form.remark" style="margin-top: 5px;width: 161px;"></el-input>
            </el-form-item>
            <el-form-item style='width:100%'>
                <el-button type="primary" @click="onSubmit" style="margin-top: 30px;margin-left: 220px;">保存</el-button>
                <el-button type="primary" @click="reset">取消</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<!-- 组件导出 -->
<script>
    import addCompanyCss from '../../../assets/css/addCompany.css'
    export default{
        data(){
            return {
                form: {
                    companyId:'',
                    linkName:'',
                    post:'',
                    sex:'',
                    tel:'',
                    wwTel:'',
                    phone:'',
                    fax:'',
                    qq:'',
                    address:'',
                    email:'',
                    remark:'',
                },
                companylist:[],
            }
        },
        methods:{
            onSubmit() {

                if(this.$fn.hasObjectNull(this.form)){
                    this.$message({
                        message: '请将信息填完整',
                        type: 'warning'
                    });
                    return;
                }


                this.$http.axios({
                    url:'/customer/addCustomerEntity',
                    method:'post',
                    data:this.form,
                    json:true,
                }).then(resolve=>{

                    for(let i in this.form){
                        this.form[i]=null;
                    }

                    this.$message({
                        message: '添加完毕',
                        type: 'success'
                    });

                }).catch(err=>{
                    console.log("失败了")
                })

            },
            reset(){
                for(let i in this.form){
                    this.form[i]=null;
                }
            },
            getCompanyList(){

                this.$http.axios({
                    url:'/company/getCompanyList',
                    method:'get',
                }).then(resolve=>{

                    this.companylist = resolve;

                }).catch(err=>{

                })

            },

        },
        components:{

        },
        created(){
            this.getCompanyList();
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
        height: 420px;
        background: #65c0e8;
    }

</style>
