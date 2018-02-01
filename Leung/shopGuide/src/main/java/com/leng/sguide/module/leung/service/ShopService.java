package com.leng.sguide.module.leung.service;

import com.leng.sguide.module.leung.entity.ShopEntity;
import com.leng.sguide.common.structure.service.BaseService;

import java.util.Map;


/**
* shop表对应实体类的业务层接口
*
* @author by@Deng
* @create 2018-01-29 01:48:00
*/
public interface ShopService extends BaseService<ShopEntity> {


    /**
     * 获取购车列表
     * @author by@Deng
     * @date 2018/1/30 上午2:42
     */
    Object getShopCarList(Map<String,Object> map) throws Exception;


}