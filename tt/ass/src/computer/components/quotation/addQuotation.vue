<!-- 组件 -->
<template>
    <div class="tmpl">
        <span style="margin-left:46%;margin-bottom:10px;display:inline-block">添加报价单</span>
        <div class="table">
            <table>
                <tr>
                    <td>公司名称</td>
                    <td>
                        <el-select v-model="quotationEntity.companyId" placeholder="请选择" style="width:70%;" @change="changeCompanyInfoList">
                            <el-option v-for="item in companylist" :key="item.id" :label="item.comName" :value="item.id"></el-option>
                        </el-select>
                    </td>
                    <td>联系人</td>
                    <td>
                        <el-input v-model="quotationEntity.linkName"></el-input>
                    </td>
                </tr>
                <tr>
                    <td>电话</td>
                    <td>
                        <el-input v-model="quotationEntity.phone"></el-input>
                    </td>
                    <td>传真</td>
                    <td>
                        <el-input v-model="quotationEntity.fax"></el-input>
                    </td>
                </tr>
                <tr>
                    <td>邮箱</td>
                    <td>
                        <el-input v-model="quotationEntity.email"></el-input>
                    </td>
                    <td>联系地址</td>
                    <td>
                        <el-input v-model="quotationEntity.address"></el-input>
                    </td>
                </tr>
                <tr>
                    <td>报价人</td>
                    <td>
                        <el-input  v-model="quotationEntity.quoName"></el-input>
                    </td>
                    <td>报价日期</td>
                    <td>
                        <el-input v-model="quotationEntity.quoTime"></el-input>
                    </td>
                </tr>
            </table>
            <table style="margin-top:15px" class="product">
                <thead>
                    <tr>
                        <th style="width:5%;"></el-checkbox></th>
                        <th style="width:28%;">产品名称</th>
                        <th style="width:16%;">规格</th>
                        <th style="width:8%;">数量</th>
                        <th style="width:8%;">单位</th>
                        <th style="width:10%;">单价</th>
                        <th style="width:10%;">金额</th>
                        <th style="width:10%;">备注</th>
                        <th style="width:9%;"><el-button @click="addTr" type="text" size="small">添加</el-button></th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="(item,index) in productList" :key="index">
                        <td><el-checkbox v-model="item.checked"></el-checkbox></td>
                        <td>
                            <el-select v-model="item.productId" placeholder="请选择" style="width:90%" @change="changeProduct(item)">
                                <el-option v-for="item1 in item.companyInfoList" :key="item1.id" :label="item1.proName" :value="item1.id"></el-option>
                            </el-select>
                        </td>
                        <td><el-input v-model="item.norm"></el-input></td>
                        <td><el-input v-model="item.num" type="number"></el-input></td>
                        <td><el-input v-model="item.cent"></el-input></td>
                        <td><el-input type="number" v-model="item.centPrice"></el-input></td>
                        <td><el-input v-model="item.totalPrice"></el-input></td>
                        <td><el-input v-model="item.remark"></el-input></td>
                        <td >
                            <el-button @click="delTr(index)" type="text" size="small">删除</el-button>
                        </td>
                    </tr>
                    <tr>
                        <td>合计</td>
                        <td></td>
                        <td></td>
                        <td v-text="accountNum"></td>
                        <td></td>
                        <td></td>
                        <td v-text="accountPrice"></td>
                        <td></td>
                        <td></td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="9" style="height: 45px;text-align:left;">
                            <span style="margin-left:20px;">运费: &nbsp;&nbsp;</span> &nbsp;&nbsp;<el-input type="number"  style="width:15%;margin-right:20px;" v-model="quotationEntity.transport"></el-input>
                            总计: &nbsp;&nbsp;<el-input type="number" style="width:15%" v-model="totalPrice"></el-input>
                            <span style="margin-left:40px;">单位: &nbsp;&nbsp;</span>
                            <el-select v-model="quotationEntity.cent" placeholder="请选择" style="width:10%;">
                                <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value"></el-option>
                            </el-select>
                        </td>
                    </tr>
                    <tr>
                        <td>备<br>注</td>
                        <td colspan="8" style="text-align:left;padding-left:20px;">
                            <el-input type="textarea" style="width:90%;margin:5px 0px" :rows="3" placeholder="请输入备注内容" v-model="quotationEntity.remark"></el-input>
                            <br>
                            <el-button type="text" @click="getRemarkList">选择更多备注</el-button>
                        </td>
                    </tr>
                    <el-dialog title="选择备注" :visible.sync="dialogVisible" width="50%">
                        <el-table ref="multipleTable" :data="remarKlist" tooltip-effect="dark" style="width: 100%"
                                                                            @selection-change="handleSelectionChange">
                            <el-table-column type="selection" width="55"></el-table-column>
                            <el-table-column label="序号" width="60">
                              <template slot-scope="scope">{{ scope.$index+1 }}</template>
                            </el-table-column>
                            <el-table-column prop="remark" label="备注" width="550"></el-table-column>
                        </el-table>
                        <span slot="footer" class="dialog-footer">
                            <el-button type="primary" @click="sureRemark">确 定</el-button>
                        </span>
                    </el-dialog>
                </tfoot>
            </table>
        </div>
        <table style="margin-top:15px">
            <tbody>
                <tr>
                    <td style="width:18%">报价单顶部预设模板</td>
                    <td colspan="8" style="text-align:left;padding-left:20px;">
                        <el-radio v-model="radio" label="1">简单模板</el-radio>
                    </td>
                </tr>
                <tr>
                    <td colspan="9" style="height:120px">
                        <div class="moban">
                            <p style="padding-left:20px">
                                电话:<el-input v-model="quotationEntity.quoPhone" type="tel" :maxlength="11" ></el-input>
                                传真:<el-input v-model="quotationEntity.quoFax" :maxlength="13"></el-input>
                            </p>
                            <p class="price">报价单</p>
                        </div>
                    </td>
                </tr>
            </tbody>
        </table>
        <table style="margin-top:15px">
            <thead>
                <tr>
                    <th style="width:140px;">选择客户信息模板</th>
                    <th colspan="8" style="text-align:left;padding-left:20px;">
                        <el-radio v-model="customerSelect" label="1">标准型</el-radio>
                        <el-radio v-model="customerSelect" label="2">简单型</el-radio>
                    </th>
                </tr>
            </thead>
            <tbody v-if="customerSelect==1?true:false">
                <tr>
                    <td>公&nbsp;&nbsp;&nbsp;司</td>
                    <td><span v-text="quotationEntity.comName"></span></td>
                    <td>联系人</td>
                    <td><span v-text="quotationEntity.linkName">黄先生</span></td>
                </tr>
                <tr>
                    <td>电&nbsp;&nbsp;&nbsp;话</td>
                    <td><span v-text="quotationEntity.phone"></span></td>
                    <td>传&nbsp;&nbsp;&nbsp;真</td>
                    <td><span v-text="quotationEntity.fax"></span></td>
                </tr>
                <tr>
                    <td>邮&nbsp;&nbsp;&nbsp;箱</td>
                    <td><span v-text="quotationEntity.email"></span></td>
                    <td>地&nbsp;&nbsp;&nbsp;址</td>
                    <td><span v-text="quotationEntity.address"></span></td>
                </tr>
                <tr>
                    <td>报价人</td>
                    <td><span v-text="quotationEntity.quoName"></span></td>
                    <td>报价日期</td>
                    <td>
                        <span v-text="quotationEntity.quoTime"></span>
                    </td>
                </tr>
            </tbody>
            <tfoot v-else>
                <tr>
                    <td>FROM</td>
                    <td><span v-text="quotationEntity.quoName"></span></td>
                    <td>TO</td>
                    <td v-text="quotationEntity.linkName"></td>
                </tr>
                <tr>
                    <td>COMPANY</td>
                    <td><span v-text="quotationEntity.comName"></span></td>
                    <td>DATE</td>
                    <td><span v-text="quotationEntity.quoTime"></span></td>
                </tr>
            </tfoot>
        </table>
        <div class="main-foot" style="margin-left:40%;">
            <el-button type="primary" @click="handleClick">预览报价单</el-button>
            <el-button type="primary" @click="insertQuation">确定</el-button>

            <el-dialog :visible.sync="detail" width="70%">
                <detail-quotation :quotationVo="quotationVo"></detail-quotation>
            </el-dialog>
        </div>

    </div>
</template>

<!-- 组件导出 -->
<script>
    import {mapState,mapActions} from 'vuex'
    import detailQuotation from '@/computer/components/quotation/detailQuotation'
    import Bus from '../public/bus'

    export default{
        data(){
            return {
                quotationEntity:{
                    companyId:null,
                    linkName:null,
                    phone:null,
                    fax:null,
                    email:null,
                    address:null,
                    quoName:null,
                    quoTime:this.$commonUtils.DateUtils.formatDate(new Date(),"yyyy-MM-dd"),
                    transport: 0,//运费
                    cent:'元',//单位
                    remark:'',//备注
                    quoPhone:'',//顶部电话
                    quoFax:'',//顶部传真
                },//报价单基本信息
                companylist:[], //公司
                remarKlist: null,
                multipleSelection: [],
                radio: '1',
                quotationVo:{},
                customerSelect:'1',
                companyInfoList:[],
                productList:[],
                detail:false,
                options: [{
                    value: '元',label: '元'}, {
                    value: '美元',label: '美元'}, {
                    value: '英镑',label: '英镑'}, {
                    value: '欧元',label: '欧元' }, {
                    value: '日元',label: '日元'},{
                    value: '港币',label: '港币'},{
                    value: '台币',label: '台币'},{
                    value: '泰铢',label: '泰铢'}
                ],
                dialogVisible:false,
            }
        },
        methods:{
            addTr(){
                this.insertRow();

            },
            delTr(index){
                this.productList.splice(index,1);
            },
            handleSelectionChange(val) {
                this.multipleSelection = val;
            },
            goDetail(){
                this.$router.push({path:"/index/detailQuotation"})
            },
            handleClick(){
                this.quotationVo.quotationEntity = this.quotationEntity;
                this.quotationVo.quotationEntity.totalPrice = this.totalPrice;
                this.quotationVo.quoProductEntityList = this.productList;
                this.quotationVo.comName = this.quotationEntity.comName;

                this.detail=true;
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
            changeCompanyInfoList(){
                for(let i in this.companylist){
                    if(this.quotationEntity.companyId==this.companylist[i].id){
                        this.quotationEntity.comName = this.companylist[i].comName;
                        this.quotationEntity.linkName = this.companylist[i].linkName;
                        this.quotationEntity.phone = this.companylist[i].linkPhone;
                        this.quotationEntity.fax = this.companylist[i].fax;
                        this.quotationEntity.email = this.companylist[i].email;
                        this.quotationEntity.address = this.companylist[i].address;
                        break;
                    }

                }
            },
            getCurrentUser(){
                this.$http.axios({
                    url:'/userInfo/getUserInfoEntity',
                    method:'get',
                }).then(resolve=>{
                    this.quotationEntity.quoName = resolve.username;
                }).catch(err=>{
                    console.log("失败了")
                })
            },
            getRemarkList(){

                this.$http.axios({
                    url:'/remark/getRemarkEntityList',
                    method:'get',
                }).then(resolve=>{
                    this.remarKlist = resolve;
                }).catch(err=>{
                    console.log("失败了")
                })

                this.dialogVisible = true;
            },
            sureRemark(){
                if(this.multipleSelection.length>0){
                    for(let m in this.multipleSelection){
                        this.quotationEntity.remark += (m*1+1) + '.' + this.multipleSelection[m].remark+'\n';
                    }
                }

                this.dialogVisible = false;
            },
            getProductList(){

                this.$http.axios({
                    url:'/product/getProductEntityList',
                    method:'get',
                }).then(resolve=>{
                    this.companyInfoList = resolve;
                }).catch(err=>{
                    console.log("失败了")
                }).then(resolve=>{
                    this.getInitProductList();
                })

            },
            changeProduct(row){

                for(let i  in row.companyInfoList){
                    if(row.companyInfoList[i].id == row.productId){

                        row.proName = row.companyInfoList[i].proName;
                        row.norm= row.companyInfoList[i].norm;
                        row.cent= row.companyInfoList[i].cent;
                        row.centPrice= row.companyInfoList[i].centPrice;
                        row.remark= row.companyInfoList[i].remark;
                        row.num= 0;
                        row.totalPrice=0;

                        break;
                    }
                }

            },
            insertQuation(){
                this.quotationEntity.totalPrice = this.totalPrice;   //获取总价


                let send_data = {};
                send_data.quotationEntity = this.quotationEntity;
                send_data.quoProductEntityList = this.productList;

                this.$http.axios({
                    url:'/quotation/insertQuotationEntity',
                    method:'post',
                    data:send_data,
                    json:true,
                }).then(resolve=>{

                    this.$message({
                        message: '添加报价单成功',
                        type: 'success'
                    });

                    this.$router.push({path:'/index/queryQuotation'});

                }).catch(err=>{
                    console.log("失败了")
                })


            },
            getInitProductList(){
                for(let i =0;i<3;i++){
                    this.insertRow();
                }
            },
            insertRow(){
                let initQuoEntity = {
                    checked:false,
                    productId:'',
                    proName:null,
                    norm:null,
                    num:null,
                    cent:null,
                    centPrice:null,
                    totalPrice:null,
                    remark:null,
                    companyInfoList:[]
                };
                initQuoEntity.companyInfoList = this.companyInfoList;
                this.productList.push(initQuoEntity);
            }
        },
        components:{
            detailQuotation,
        },
        computed:{
            ...mapState('userModule',['userInfo']),
            totalPrice(){
                let total=0;
                for(let i in this.productList){
                    total += this.productList[i].totalPrice*1;
                }
                total +=this.quotationEntity.transport*1;
                return total;
            },
            accountNum(){
                let total=0;
                for(let i in this.productList){
                    total += this.productList[i].num*1;
                }
                return total;
            },
            accountPrice(){
                let total=0;
                for(let i in this.productList){
                    total += this.productList[i].totalPrice*1;
                }
                return total;
            },
        },
        created(){
            this.getProductList();
            this.getCompanyList();
            this.getCurrentUser();

        },
        watch:{
            productList:{
                handler: function () {
                    for(let i in this.productList){
                        this.productList[i].totalPrice =this.productList[i].centPrice*1 *this.productList[i].num;
                    }

                },
                deep: true
            },
        }
    }
</script>

<!-- 本组件样式 -->
<style scoped>
.tmpl{
    position: absolute;
    padding-top: 20px;
    top: 10%;
    left: 10%;
    width: 80%;
    min-height: 680px;
    background: #65c0e8;
}
table {
    width: 840px;
    margin: 0 auto;
    text-align: center;
    margin-top: 13px;
    margin-bottom: 30px;
    border: 1px solid RGBA(223, 223, 223, 1);
    font-size: 15px;
    color: #666666;
}
table tr{
    width: 100%;
    height:35px;
}
table caption{
    text-align: left;
    height:30px;
    margin-bottom: 10px;
    margin-left: 20px;
}
table  tr td,table  tr th {
    border: 1px solid RGBA(223, 223, 223, 1);
    font-weight: normal;
}
.el-input{
    width:70%;
}
.product .el-input{
    width:80%;
}
.main-foot{
    margin-left:46%;
    margin-bottom: 30px;
}
.el-radio{
    font-weight: normal;
}
.moban{
    background:#fbf3f3;
    height:100%;
    padding-top:20px;
}
.moban .el-input{
    width:20%;
}
.moban .price{
    height: 40px;
    line-height: 40px;
    font-size: 20px;
    letter-spacing: 2px;
    margin-top: 20px;
}

</style>
