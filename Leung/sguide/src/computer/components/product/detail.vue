<!-- 组件 -->
<template>
    <div class="tmpl">
        <div class="tmpl-main">
            <div class="detail-left">
                <p class="detail">产品详情</p>
                <!-- 左右 -->
                <img :src="product.img">
                <p class="shopName">店铺:<span v-text="product.nick" style="margin-left:10px"></span></p>
            </div>
            <div class="detail-right">
                <p class="detail-title" v-text="product.productName"></p>
                <p class="detail-intro" v-text="product.productIntro"></p>
                <p class="detail-price">
                    价&nbsp;&nbsp;&nbsp;格<span style="margin-left:10px">￥<em style="text-decoration:line-through;" v-text="product.originPrice"></em></span><br>
                    促销价<span style="margin-left:10px">￥ <em style="color:red;font-size:20px;" v-text="product.activityPrice"></em><span style="margin-left:20px;">活动价</span></span>
                </p>
                <p class="account">
                    <span style="font-size:14px;">数量</span><span><i class="el-icon-minus" @click="creAccount"></i><em style="margin-left:10px" v-text="orderBase.account"></em><i class="el-icon-plus" @click="addAccount"></i></span>
                    <span class="hasAccount">库存: <em v-text="product.productAmount"></em></span>
                </p>
                <p style="height:70px">
                    <button class="detail-btn" @click="goShopNow">立即购买</button>
                    <button class="detail-btn hasShop" @click="goShop" v-text='product.isInShop==0?"加入购物车":"已添加至购物车"'></button>
                </p>
                <p class="scan">
                    <span class="scan-liang">浏览量:</span><span style="margin-left:10px;margin-right:8px" v-text="product.scanAmount"></span>次
                    <br>
                    <span class="scan-liang">销售量:</span><span style="margin-left:10px;margin-right:10px" v-text="product.saleAmount"></span>
                    <span style="margin-left:60px;margin-right:10px">客户评分:</span><span v-text="product.score"></span>
                </p>
                <p class="promoise">
                    <span>服务承诺</span>
                    <ul>
                        <li>破损包退</li>
                        <li>正品保证</li>
                        <li>急速退款</li>
                        <li>赠运费险</li>
                        <li>七天无理由退换货</li>
                    </ul>
                </p>
            </div>
        </div>
        <div class="tmpl-foot">
            <p class="content">累计评论:</p>
            <p class="content-detail" v-for="(item,index) in product.contentList">
                <span>楼 主<em> {{index+1}} </em></span><span class="detail-user"> {{item.nick}} </span>
                <span style="float:right;margin-right:10px"><span style="margin-right:10px;">评价结果:</span><span v-text="item.score"></span><span style="margin:20px;margin-right:10px">评论时间:</span><span v-text="item.createTime"></span></span>
                <span class="detail-content" v-text="item.content"></span>
            </p>
        </div>

        <el-dialog  :visible.sync="dialogVisible" width="40%" class="btnGoShop">
            <p style="margin-left:-380px;">总价格:<span style="margin:0 20px;" v-text="orderBase.totalMoney"></span>元</p>
            <el-form ref="form" label-width="90px">
                <el-form-item label="收获人:">
                    <el-input v-model="orderBase.linkName" v-if="shopInfo"></el-input>
                    <span v-text = "orderBase.linkName" v-else></span>
                </el-form-item>
                <el-form-item label="收获地址:">
                    <el-input v-model="orderBase.address" v-if="shopInfo"></el-input>
                    <span v-text = "orderBase.address" v-else></span>
                </el-form-item>
                <el-form-item label="手机号:">
                    <el-input v-model="orderBase.phone" v-if="shopInfo"></el-input>
                    <span v-text = "orderBase.phone" v-else></span>
                </el-form-item>
                <el-form-item class="goShopSure">
                    <el-button type="text" @click="xg" style="margin-left:180px;">修改</el-button>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button type="primary" @click="sureShop">确定购买</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {
                product:{},
                dialogVisible: false,
                orderBase:{
                    address:'',
                    linkName:'',
                    phone:'',
                    account:0,
                    totalMoney:0.0,
                },
                shopInfo:false,
            }
        },
        methods:{
            creAccount(){
                if(this.orderBase.account>0){
                    this.orderBase.account--;
                }
            },
            addAccount(){
                if(this.orderBase.account<=this.product.productAmount){
                    this.orderBase.account++;
                }
            },
            goShop(){

                if(this.product.isInShop=='0'){
                    this.$http.axios({
                        url:'/shop/insertShopEntity',
                        method:'post',
                        data:{productId:this.$route.params.id},
                    }).then(resolve=>{

                        this.product.isInShop=1;

                        this.$message.success("已添加至购物车");

                    }).catch(err=>{
                        console.log("失败了")
                    })
                }
            },
            xg(){
                this.shopInfo=!this.shopInfo;
            },
            goShopNow(){
                if(this.orderBase.account<1) return this.$message.warning("请选择购买产品个数");

                this.$http.axios({
                    url:'/product/getProductAddress',
                    method:'get',
                }).then(resolve=>{
                    this.orderBase.totalMoney = this.orderBase.account *1 *this.product.activityPrice;
                    this.orderBase.address=resolve.harvestAddress;
                    this.orderBase.linkName=resolve.harvestPeople;
                    this.orderBase.phone=resolve.phone;

                    this.dialogVisible = true;
                }).catch(err=>{
                    console.log("失败了")
                })
            },
            sureShop(){

                this.orderBase.productId=this.$route.params.id;


                this.$http.axios({
                    url:'/orderBase/insertOrderBaseEntity',
                    method:'post',
                    data:this.orderBase,
                    json:true,
                }).then(resolve=>{

                    this.$message.success('购买成功');
                    this.$router.push({path:'/index/orderList'});

                }).catch(err=>{
                    console.log("失败了")
                })

            },
            getProductDetail(id){

                this.$http.axios({
                    url:'/product/getProductDetail',
                    method:'get',
                    params:{id:id}
                }).then(resolve=>{

                    resolve.img = '/shopGuide/product/downLoadFile?fileName='+resolve.img;

                    if(resolve.contentList.length>0){
                        for(let i in resolve.contentList){
                            switch (resolve.contentList[i].score){
                                case "-1":   resolve.contentList[i].score="较差";
                                    break;
                                case "0":   resolve.contentList[i].score="差";
                                    break;
                                case "1":   resolve.contentList[i].score="一般";
                                    break;
                                case "3":   resolve.contentList[i].score="好";
                                    break;
                                case "5":   resolve.contentList[i].score="较好";
                                    break;
                            }
                        }
                    }

                    this.product = resolve;


                }).catch(err=>{
                    console.log("失败了")
                })
            },
            addScanAccount(){
                //浏览量

                this.$http.axios({
                    url:'/product/addScanAccount',
                    method:'post',
                    data:{productId:this.$route.params.id},
                }).then(resolve=>{

                }).catch(err=>{
                    console.log("失败了")
                })

            }
        },
        components:{

        },
        created(){
            this.getProductDetail(this.$route.params.id);
            this.addScanAccount();
        }
    }
</script>

<!-- 本组件样式 -->
<style scoped>
    .tmpl-main{
        width:80%;
        height:500px;
        border:1px solid #dedcdc;
        margin:30px auto;
        position: relative;
    }
    .tmpl-foot{
        width:77.5%;
        min-height:50px;
        border:1px solid #dedcdc;
        margin:0 auto;
        padding-left:30px;
    }
    .tmpl-foot .content{
        height:40px;
        line-height:40px;
        font-weight: bold;
    }
    .content-detail{
        min-height:40px;
        margin-left:20px;
        padding-top:5px;
        padding-bottom:5px;
        width:92%;
        background-color: #e6e6e6;
        margin-bottom: 15px;
    }
    .detail-user{
        display: inline-block;
        margin-left:10px;
        color:#8a3fd4
    }
    .detail-content{
        margin-left:20px;
        display: block;
        text-indent: 15px;
        margin-top:5px;
    }
    .detail-left{
        position: absolute;
        left:0;
        width:50%;
        height:100%;
    }
    .detail-right{
        position: absolute;
        right:0;
        width:50%;
        height:100%;
        padding-top:6%;
    }
    .detail-left img{
        width:60%;
        height:60%;
        margin:5% 20%;
    }
    .detail-left .detail{
        height: 40px;
        line-height: 40px;
        margin-left: 20%;
        font-size: 18px;
    }
    .detail-right p{
        height:30px;
        line-height: 30px;
    }
    .detail-title{
        font-size: 16px;
        color: #000;
        white-space: nowrap;
        text-overflow: ellipsis;
        overflow:hidden;
    }
    .detail-right .detail-intro{
        color: red;
        line-height: 14px;
    }
    .detail-right .detail-price{
        height: 60px;
        background-color: #d8d8d8;
        margin-left: -12px;
        padding-left: 12px;
    }
    .detail-right .account{
        margin-top: 14px;
        font-size: 16px;
    }
    .detail-right .account i{
        margin-left:10px;
    }
    .detail-right .account i:hover{
        cursor: pointer;
    }
    .detail-btn{
        height: 38px;
        width: 178px;
        border: 1px solid red;
        outline: 0 none;
        background-color: #ffeded;
        color: #FF0036;
        cursor: pointer;
        margin-top: 20px;
        border-radius: 0;
    }
    .hasShop{
        background-color:#ff0036;
        color:#fff;
        margin-left:10px;
    }
    .promoise{
        margin-top: 35px;
    }
    .promoise ul li{
        width: 25%;
        display: inline-block;
        padding-left: 20px;
    }
    .hasAccount{
        margin-left: 35px;
        font-size: 14px;
    }
    .shopName{
        position: relative;
        top: -14px;
        left: 20%;
    }
    .el-form span{
        color:#000;
    }
    .scan .scan-liang{
        display: inline-block;
        height:25px;
    }

</style>
