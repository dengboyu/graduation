package com.leng.sguide.module.leung.serviceImpl;

import com.leng.sguide.module.leung.entity.OrderBaseEntity;
import com.leng.sguide.module.leung.entity.ProductEntity;
import com.leng.sguide.module.leung.entity.UserInfoEntity;
import com.leng.sguide.module.leung.service.CurrencyService;
import com.leng.sguide.module.leung.service.ProductService;
import com.leng.sguide.module.leung.service.UserInfoService;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.leng.sguide.module.leung.entity.ShopEntity;
import com.leng.sguide.module.leung.service.ShopService;
import com.leng.sguide.module.leung.dao.ShopDao;
import com.leng.sguide.common.structure.serviceAbstract.BaseServiceAbstract;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
* shop表对应实体类的业务层的实现类
*
* @author by@Deng
* @create 2018-01-29 01:48:00
*/
@Service
@Transactional
public class ShopServiceImpl extends BaseServiceAbstract<ShopDao,ShopEntity> implements ShopService {

    @Resource
    private CurrencyService currencyService;
    @Resource
    private ProductService productService;
    @Resource
    private UserInfoService userInfoService;


    /**
     * 获取购车列表
     * @author by@Deng
     * @date 2018/1/30 上午2:43
     */
    @Override
    public Object getShopCarList(Map<String, Object> map) throws Exception {

        Map<String,Object> retFinalMap = new HashMap<>();
        Map<String,Integer> pageMap = currencyService.getPageParam(map);

        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("pageStart",pageMap.get("pageStart"));
        paramMap.put("pageSize",pageMap.get("pageSize"));
        paramMap.put("userId",map.get("userId"));
        List<ShopEntity> shopEntityList = findPageEntityList(paramMap);

        List<Map<String,Object>> mapList = new ArrayList<>();

        for(ShopEntity shopEntity:shopEntityList){
            Map<String,Object> retMap = new HashMap<>();
            retMap.put("id",shopEntity.getId());

            ProductEntity productEntity = productService.findEntityByMainId(shopEntity.getProductId());

            retMap.put("nick",userInfoService.findEntityByMainId(productEntity.getUserId()).getNick());
            retMap.put("productName",productEntity.getProductName());
            retMap.put("centPrice",productEntity.getCentPrice());
            retMap.put("tag",productEntity.getTag());
            retMap.put("productId",productEntity.getId());


            mapList.add(retMap);
        }

        retFinalMap.put("mapList",mapList);
        retFinalMap.put("totalAccount",this.findPageEntityCount(map));

        return retFinalMap;
    }
}