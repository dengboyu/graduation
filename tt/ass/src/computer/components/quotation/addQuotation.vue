<!-- 组件 -->
<template>
    <div class="tmpl">
        <span style="margin-left:46%;margin-bottom:10px;display:inline-block">添加报价单</span>
        <div class="table">
            <table>
                <tr>
                    <td>公司名称</td>
                    <td>
                        <el-select v-model="conpanyValue" placeholder="请选择" style="width:70%;">
                            <el-option v-for="item in company" :key="item.value" :label="item.label" :value="item.value"></el-option>
                        </el-select>
                    </td>
                    <td>联系人</td>
                    <td>
                        <el-input v-model="input"></el-input>
                    </td>
                </tr>
                <tr>
                    <td>电话</td>
                    <td>
                        <el-input v-model="input"></el-input>
                    </td>
                    <td>传真</td>
                    <td>
                        <el-input v-model="input"></el-input>
                    </td>
                </tr>
                <tr>
                    <td>邮箱</td>
                    <td>
                        <el-input v-model="input"></el-input>
                    </td>
                    <td>联系地址</td>
                    <td>
                        <el-input v-model="input"></el-input>
                    </td>
                </tr>
                <tr>
                    <td>报价人</td>
                    <td>
                        <el-input  v-model="name"></el-input>
                    </td>
                    <td>报价日期</td>
                    <td>
                        <el-input v-model="date"></el-input>
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
                            <el-select v-model="conpanyValue" placeholder="请选择" style="width:90%">
                                <el-option v-for="item in company" :key="item.value" :label="item.label" :value="item.value"></el-option>
                            </el-select>
                        </td>
                        <td><el-input v-model="item.standard"></el-input></td>
                        <td><el-input v-model="item.num"></el-input></td>
                        <td><el-input v-model="item.cent"></el-input></td>
                        <td><el-input type="number" v-model="item.price"></el-input></td>
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
                        <td>0</td>
                        <td></td>
                        <td></td>
                        <td>0</td>
                        <td></td>
                        <td></td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="9" style="height: 45px;text-align:left;">
                            &nbsp;&nbsp;总计: &nbsp;&nbsp;<el-input type="number" style="width:15%" v-model="input"></el-input>
                            <span style="margin-left:40px;">单位: &nbsp;&nbsp;</span>
                            <el-select v-model="value" placeholder="请选择" style="width:10%;">
                                <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value"></el-option>
                            </el-select>
                            <span style="margin-left:40px;">运费: &nbsp;&nbsp;</span> &nbsp;&nbsp;<el-input  style="width:15%" v-model="input"></el-input>
                        </td>
                    </tr>
                    <tr>
                        <td>备<br>注</td>
                        <td colspan="8" style="text-align:left;padding-left:20px;">
                            <el-input type="textarea" style="width:90%;margin:5px 0px" :rows="3" placeholder="请输入备注内容" v-model="textarea"></el-input>
                            <br>
                            <el-button type="text" @click="dialogVisible = true">选择更多备注</el-button>
                        </td>
                    </tr>
                    <el-dialog title="选择备注" :visible.sync="dialogVisible" width="30%">
                        <el-table ref="multipleTable" :data="tableData3"
                            tooltip-effect="dark" style="width: 100%" @selection-change="handleSelectionChange">
                            <el-table-column type="selection" width="55"></el-table-column>
                            <el-table-column label="序号" width="60">
                              <template slot-scope="scope">{{ scope.$index+1 }}</template>
                            </el-table-column>
                            <el-table-column prop="name" label="备注" width="300"></el-table-column>
                        </el-table>
                        <span slot="footer" class="dialog-footer">
                            <el-button @click="dialogVisible = false">取 消</el-button>
                            <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
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
                                电话:<el-input v-model="input"></el-input>
                                传真:<el-input v-model="input"></el-input>
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
                    <td><span>阿里巴巴科技有限公司</span></td>
                    <td>联系人</td>
                    <td><span>黄先生</span></td>
                </tr>
                <tr>
                    <td>电&nbsp;&nbsp;&nbsp;话</td>
                    <td><span>黄先生</span></td>
                    <td>传&nbsp;&nbsp;&nbsp;真</td>
                    <td><span>黄先生</span></td>
                </tr>
                <tr>
                    <td>邮&nbsp;&nbsp;&nbsp;箱</td>
                    <td><span>黄先生</span></td>
                    <td>地&nbsp;&nbsp;&nbsp;址</td>
                    <td><span>黄先生</span></td>
                </tr>
                <tr>
                    <td>报价人</td>
                    <td><span v-text="name"></span></td>
                    <td>报价日期</td>
                    <td>
                        <span v-text="date"></span>
                    </td>
                </tr>
            </tbody>
            <tfoot v-else>
                <tr>
                    <td>FROM</td>
                    <td><span v-text="name"></span></td>
                    <td>TO</td>
                    <td>联系人</td>
                </tr>
                <tr>
                    <td>COMPANY</td>
                    <td><span>阿里巴巴科技有限公司</span></td>
                    <td>DATE</td>
                    <td><span v-text="date"></span></td>
                </tr>
            </tfoot>
        </table>
        <div class="main-foot" style="margin-left:40%;">
            <el-button type="primary" @click="handleClick">预览报价单</el-button>
            <el-button type="primary" @click="">确定</el-button>

            <el-dialog :visible.sync="detail" width="70%">
                <detail-quotation></detail-quotation>
            </el-dialog>
        </div>

    </div>
</template>

<!-- 组件导出 -->
<script>
    import {mapState,mapActions} from 'vuex'
    import detailQuotation from '@/computer/components/quotation/detailQuotation'
    export default{
        data(){
            return {
                name:this.$store.state.userModule.userInfo.name,
                date:this.$commonUtils.DateUtils.formatDate(new Date(),"yyyy-MM-dd"),
                radio: '1',
                input: '',
                selectList:[],
                customerSelect:'1',
                dialogVisible:false,
                productList:[
                    {
                        checked:false,
                        name:null,
                        standard:null,
                        num:null,
                        cent:null,
                        price:null,
                        totalPrice:null,
                        remark:null
                    },
                    {
                        checked:false,
                        name:null,
                        standard:null,
                        num:null,
                        cent:null,
                        price:null,
                        totalPrice:null,
                        remark:null
                    },
                    {
                        checked:false,
                        name:null,
                        standard:null,
                        num:null,
                        cent:null,
                        price:null,
                        totalPrice:null,
                        remark:null
                    },
                    {
                        checked:false,
                        name:null,
                        standard:null,
                        num:null,
                        cent:null,
                        price:null,
                        totalPrice:null,
                        remark:null
                    }
                ],
                company: [{
                      value: '阿里巴巴公司',label: '阿里巴巴公司'}, {
                      value: '腾讯科技有限公司',label: '腾讯科技有限公司'}, {
                      value: '摩拜科技有限公司',label: '摩拜科技有限公司'}
                    ],
                conpanyValue:null,
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
                value: '元',
                textarea: '',
                tableData3: [
                    {
                      name: '非人为损坏，3年保修',
                    }, {
                      name: '以上产品单价均为含税单价，含税17',
                    }
                ],
                multipleSelection: []
            }
        },
        methods:{
            addTr(){
                this.productList.push(new Object());
            },
            delTr(index){
                this.productList.splice(index,1);
            },
            handleClose(done) {
                this.$confirm('确认关闭？')
                .then(_ => {
                    done();
                }).catch(_ => {});
            },
            handleSelectionChange(val) {
                this.multipleSelection = val;
            },
            goDetail(){
                this.$router.push({path:"/index/detailQuotation"})
            },
            handleClick(){
                this.detail=true;
            }
        },
        components:{
            detailQuotation,
        },
        computed:{
            ...mapState('userModule',['userInfo'])
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
