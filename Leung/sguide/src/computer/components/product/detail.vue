<!-- 组件 -->
<template>
    <div class="tmpl">
        <div class="tmpl-main">
            <div class="detail-left">
                <p class="detail">产品详情</p>
                <!-- 左右 -->
                <img src="https://g-search1.alicdn.com/img/bao/uploaded/i4/imgextra/i1/118550965/TB2KBA3dQfb_uJkSne1XXbE4XXa_!!0-saturn_solar.jpg_460x460Q90.jpg_.webp">
                <p class="shopName">店铺:<span v-text="shopName" style="margin-left:10px"></span></p>
            </div>
            <div class="detail-right">
                <p class="detail-title" v-text="title"></p>
                <p class="detail-intro" v-text="intro"></p>
                <p class="detail-price">
                    价&nbsp;&nbsp;&nbsp;格<span style="margin-left:10px">￥<em style="text-decoration:line-through;" v-text="originPrice"></em></span><br>
                    促销价<span style="margin-left:10px">￥ <em style="color:red;font-size:20px;" v-text="price"></em><span style="margin-left:20px;">活动价</span></span>
                </p>
                <p class="account">
                    <span style="font-size:14px;">数量</span><span><i class="el-icon-minus" @click="creAccount"></i><em style="margin-left:10px" v-text="account"></em><i class="el-icon-plus" @click="addAccount"></i></span>
                    <span class="hasAccount">库存: <em v-text="hasAccount"></em></span>
                </p>
                <p style="height:70px">
                    <button class="detail-btn" @click="dialogVisible = true">立即购买</button>
                    <button class="detail-btn hasShop" v-text='hasShop==0?"加入购物车":"已添加至购物车"'></button>
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
            <p class="content-detail" v-for="(item,index) in contentList">
                <span>楼 主<em> {{index+1}} </em></span>
                <span class="detail-user"> {{item.username}} :</span>
                <span class="detail-content" v-text="item.content"></span>
            </p>
        </div>

        <el-dialog  :visible.sync="dialogVisible" width="30%" :before-close="handleClose">
            <p>确定买卖该产品吗?</p>
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<!-- 组件导出 -->
<script>

    export default{
        data(){
            return {
                shopName:'淘宝小店',
                title:'思尚口红持久保湿不脱色不沾杯防水南瓜色豆沙色滋润正品孕妇唇膏',
                intro:'天然孕妇可用 工商检测上电视彩妆节目',
                originPrice:20,
                price:40.00,
                account:0,
                hasAccount:40,
                hasShop:0,
                contentList:[
                    {
                        username:"人间旅途",
                        content:"评论内容评论内容评论内容评论内容评论内容评论内容评论内容评论内容评论内容评论内容评论内容评论内容评论内容评论内容评论内容评论内容评论内容",
                    },
                    {
                        username:"人间旅途",
                        content:"评论内容评论内容评论内容评论内容评论内容评论内容评论内容评论内容评论内容评论内容评论内容评论内容评论内容评论内容评论内容评论内容评论内容",
                    },
                ],
                dialogVisible: false
            }
        },
        methods:{
            creAccount(){
                if(this.account>0){
                    this.account--;
                }
            },
            addAccount(){
                if(this.account<=this.hasAccount){
                    this.account++;
                }
            },
            goShop(){

            },
            handleClose(done) {
                this.$confirm('确认关闭？')
                  .then(_ => {
                    done();
                  })
                  .catch(_ => {});
              }
        },
        components:{

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

</style>
