<!-- 组件 -->
<template>
    <div class="tmpl">
        <p style="margin-left:10px">商品分类</p>
        <div class="food-sort">
            <ul v-for="(item,index) in tabDatas" @click="findProduct(item.sortName)">
                 <li>
                    <i class="iconfont" :class="item.className"></i>
                    <span v-text="item.sortName"></span>
                </li>
            </ul>
        </div>
    </div>
</template>

<!-- 组件导出 -->
<script>
    import Bus from '../public/bus.js'
    export default{
        data(){
            return {
                tabDatas:[
                    {
                        className:"icon-daocha",
                        sortName:"食品 / 酒 / 生鲜"
                    },
                    {
                        className:"icon-ziyuan1",
                        sortName:"母婴 / 玩具 / 童装"
                    },
                    {
                        className:"icon-chuweizhucai",
                        sortName:"宠物 / 纸巾 / 厨卫清洁"
                    },
                    {
                        className:"icon-jiaju",
                        sortName:"家居 / 家纺 / 家装"
                    },
                    {
                        className:"icon-ziyuan",
                        sortName:"美妆个人清洁"
                    },
                    {
                        className:"icon-yifu",
                        sortName:"女装 / 男装 / 内衣 / 珠宝"
                    },
                    {
                        className:"icon-xiangbao",
                        sortName:"鞋靴 / 箱包 / 运动户外"
                    },
                    {
                        className:"icon-shouji",
                        sortName:"手机 / 数码 / 电脑办公"
                    },
                    {
                        className:"icon-dianqi",
                        sortName:"家用电器 / 汽车用品"
                    },
                    {
                        className:"icon-yiyaoxiang",
                        sortName:"医药 / 保健滋补"
                    },
                    {
                        className:"icon-tushu",
                        sortName:"图书"
                    },
                ]
            }
        },
        methods:{
            findProduct(param){
                this.$router.push({path:'/index/queryProduct'});
                Bus.$emit('search',param);
            }
        },
        components:{

        }
    }
</script>

<!-- 本组件样式 -->
<style scoped>
    .food-sort{
        margin-top:20px;
        text-indent:15px;
    }
    .food-sort ul{
        height:30px;
        line-height: 30px;
    }
    .food-sort ul:hover{
        background-color:rgba(48,48,48,0.9);
    }
    .food-sort li:hover{
        cursor: pointer;
    }
    .food-sort span{
        margin-left:7px;
    }
</style>
