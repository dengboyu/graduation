package com.leng.sguide.module.leung.service;

import com.leng.sguide.module.leung.entity.ProductEntity;
import com.leng.sguide.common.structure.service.BaseService;

import java.util.Map;


/**
* product表对应实体类的业务层接口
*
* @author by@Deng
* @create 2018-01-29 01:47:55
*/
public interface ProductService extends BaseService<ProductEntity> {


    /**
     * 搜索产品算法
     * @author by@Deng
     * @date 2018/1/31 下午4:22
     */
    Map<String,Object> getProductList(Map<String,Object> map) throws Exception;


    /**
     * 查询产品详情
     * @author by@Deng
     * @date 2018/1/31 下午4:24
     */
    Map<String,Object> getProductDetail(String id,Integer userId) throws Exception;
}