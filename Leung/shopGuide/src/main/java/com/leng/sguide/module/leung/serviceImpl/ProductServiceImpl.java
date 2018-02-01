package com.leng.sguide.module.leung.serviceImpl;

import com.leng.sguide.module.leung.entity.ContentEntity;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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



    /**
     * 搜索产品算法
     *  影响因素:
     *      购物车产品分类 *   0.3
     *      已浏览的产品分类 *   0.3
     *      产品广告竞价 *   0.1
     *      产品销量 *   0.1
     *      产品总浏览量 *   0.1
     *      产品评分 *   0.1
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

        if(map.get("saleAmount")==null || StringUtils.isEmpty(map.get("saleAmount").toString())){
            map.remove("saleAmount");
        }

        List<ProductEntity> productEntityList = dao.findPageEntityList(map);
        Long total = dao.findPageEntityCount(map);









        retMap.put("productList",productEntityList);
        retMap.put("total",total);

        return retMap;
    }


    /**
     * 查询产品详情
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
        retMap.put("nick",userInfoService.findEntityByMainId(productEntity.getUserId()).getNick());


        //判断是否在购物车中
        retMap.put("isInShop","0");
        ShopEntity shopEntity = new ShopEntity();
        shopEntity.setProductId(productEntity.getId());
        shopEntity.setUserId(userId);
        shopEntity = shopService.findEntityByOne(shopEntity);
        if(shopEntity!=null){
            retMap.put("isInShop","1");
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

        return retMap;
    }
}