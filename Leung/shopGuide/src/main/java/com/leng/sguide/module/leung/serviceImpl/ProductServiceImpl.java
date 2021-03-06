package com.leng.sguide.module.leung.serviceImpl;

import com.leng.sguide.module.leung.entity.ContentEntity;
import com.leng.sguide.module.leung.entity.ScanTagEntity;
import com.leng.sguide.module.leung.entity.ShopEntity;
import com.leng.sguide.module.leung.service.*;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.leng.sguide.module.leung.entity.ProductEntity;
import com.leng.sguide.module.leung.dao.ProductDao;
import com.leng.sguide.common.structure.serviceAbstract.BaseServiceAbstract;

import javax.annotation.Resource;
import java.util.*;


/**
* product表对应实体类的业务层的实现类
*
* @author by@Deng
* @create 2018-01-29 01:47:55
*/
@Service
@Transactional
public class ProductServiceImpl extends BaseServiceAbstract<ProductDao,ProductEntity> implements ProductService {

    @Resource
    private CurrencyService currencyService;
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private ContentService contentService;
    @Resource
    private ShopService shopService;
    @Resource
    private ScanTagService scanTagService;



    /**
     * 搜索产品算法
     *  影响因素:
     *      购物车产品分类
     *      已浏览的产品分类
     *      (在这两类中不同种类按照浏览和添加至购物车的种类比重进行排序推荐)
     *
     *  (附:同一类产品算法:
     *      产品广告竞价 *   0.4
     *      产品销量 *   0.2
     *      产品总浏览量 *   0.1
     *      产品评分 *   0.3
     *  )
     *
     * @author by@Deng
     * @date 2018/1/31 下午3:12
     */
    @Override
    public Map<String, Object> getProductList(Map<String, Object> map) throws Exception {
        Map<String,Object> retMap = new HashMap<>();

        Map<String,Integer> pageMap = currencyService.getPageParam(map);
        map.put("pageStart",pageMap.get("pageStart"));
        map.put("pageSize",pageMap.get("pageSize"));


        if(StringUtils.equals(map.get("intelSearch").toString(),"1")){
            //智能推荐购物

            //判断用户登陆
            if(map.get("userId")!=null){

                Integer userId = Integer.valueOf(map.get("userId").toString());

                ShopEntity shopEntity = new ShopEntity();
                shopEntity.setUserId(userId);
                //添加购物车种类
                List<ShopEntity> shopEntityList = shopService.findEntityList(shopEntity);


                //浏览标签种类
                List<Map<String,Object>> scanTagMapList = scanTagService.getScanTagEntityOrder(userId);

                //判断浏览产品种类与添加至购物车种类
                if(shopEntityList.size()<1 && scanTagMapList.size()<1){

                    //如果既没有浏览过产品，也没有添加种类到购物车使用全部产品分类搜索算法
                    map.put("asideSearchData",new String("全部".getBytes("UTF-8"),"iso-8859-1"));

                }else if(shopEntityList.size()<1 && scanTagMapList.size()>0){
                    //只浏览过产品，没有产品在购物车

                    //标记在sql中根据tag来查询
                    map.put("userId",userId);
                    map.put("tagList",1);

                }else{
                    //加至购物车

                    map.put("userId",userId);
                    map.put("tagList",2);
                }

            }else{
                //没有登录则使用全部产品分类搜索算法
                map.put("asideSearchData",new String("全部".getBytes("UTF-8"),"iso-8859-1"));
            }
        }


        //根据销量查询
        if(map.get("saleAmount")!=null && StringUtils.isNotEmpty(map.get("saleAmount").toString())){
            map.put("orderColumn","saleAmount");
        }
        map.remove("saleAmount");

        //根据产品名称查询
        if(map.get("productName")!=null && StringUtils.isNotEmpty(map.get("productName").toString())){
            map.put("productName",new String(map.get("productName").toString().getBytes("iso-8859-1"),"UTF-8"));
        }

        //根据产品分类搜索
        String asideSearchData = new String(map.get("asideSearchData").toString().getBytes("iso-8859-1"),"UTF-8");
        if(!StringUtils.equals(asideSearchData,"全部")){
            map.put("tag",asideSearchData);
        }


        List<ProductEntity> productEntityList = dao.findPageEntityList(map);
        Long total = dao.findPageEntityCount(map);

        retMap.put("productList",productEntityList);
        retMap.put("total",total);

        return retMap;
    }


    /**
     * 查询产品详情,增加浏览量
     * @author by@Deng
     * @date 2018/1/31 下午4:24
     */
    @Override
    public Map<String, Object> getProductDetail(String id,Integer userId) throws Exception {
        Map<String,Object> retMap = new HashMap<>();

        ProductEntity productEntity = findEntityByMainId(id);

        retMap.put("productName",productEntity.getProductName());
        retMap.put("productIntro",productEntity.getProductIntro());
        retMap.put("originPrice",productEntity.getOriginPrice());
        retMap.put("activityPrice",productEntity.getActivityPrice());
        retMap.put("productAmount",productEntity.getProductAmount());
        retMap.put("scanAmount",productEntity.getScanAmount());
        retMap.put("saleAmount",productEntity.getSaleAmount());
        retMap.put("img",productEntity.getImg());
        retMap.put("score",productEntity.getScore());
        retMap.put("tag",productEntity.getTag());
        retMap.put("nick",userInfoService.findEntityByMainId(productEntity.getUserId()).getNick());


        //判断是否在购物车中
        retMap.put("isInShop","0");
        if(userId!=null){
            ShopEntity shopEntity = new ShopEntity();
            shopEntity.setProductId(productEntity.getId());
            shopEntity.setUserId(userId);
            shopEntity = shopService.findEntityByOne(shopEntity);
            if(shopEntity!=null){
                retMap.put("isInShop","1");
            }
        }



        ContentEntity contentEntity = new ContentEntity();
        contentEntity.setProductId(productEntity.getId());
        List<ContentEntity> contentEntityList = contentService.findEntityList(contentEntity);

        List<Map<String,Object>> contentList = new ArrayList<>();
        for(ContentEntity contentEntity1:contentEntityList){
            Map<String,Object> contentMap = new HashMap<>();
            contentMap.put("nick",userInfoService.findEntityByMainId(contentEntity1.getUserId()).getNick());
            contentMap.put("content",contentEntity1.getContent());
            contentMap.put("createTime", DateFormatUtils.format(contentEntity1.getCreateTime(),"yyyy-MM-dd HH:mm:ss"));
            contentMap.put("score",contentEntity1.getScore());

            contentList.add((contentMap));
        }

        retMap.put("contentList",contentList);


        //把该产品的标签添加到个人浏览记录中，留搜索产品算法用
        if(userId!=null){
            ScanTagEntity scanTagEntity = new ScanTagEntity();
            scanTagEntity.setTag(productEntity.getTag());
            scanTagEntity.setUserId(userId);
            scanTagEntity = scanTagService.findEntityByOne(scanTagEntity);

            if(scanTagEntity==null){
                scanTagEntity = new ScanTagEntity();

                scanTagEntity.setAmount(1);
                scanTagEntity.setUserId(userId);
                scanTagEntity.setTag(productEntity.getTag());

                scanTagService.insertEntity(scanTagEntity);

            }else{
                scanTagEntity.setAmount(scanTagEntity.getAmount()+1);

                scanTagService.updateEntity(scanTagEntity);
            }

        }


        //增加浏览量
        productEntity.setScanAmount(productEntity.getScanAmount()+1);
        updateEntity(productEntity);


        return retMap;
    }
}