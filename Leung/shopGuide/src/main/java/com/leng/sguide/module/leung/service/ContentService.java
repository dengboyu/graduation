package com.leng.sguide.module.leung.service;

import com.leng.sguide.module.leung.entity.ContentEntity;
import com.leng.sguide.common.structure.service.BaseService;


/**
* content表对应实体类的业务层接口
*
* @author by@Deng
* @create 2018-01-29 01:47:45
*/
public interface ContentService extends BaseService<ContentEntity> {



    /**
     * 获取平均分
     * @author by@Deng
     * @date 2018/2/1 上午12:04
     */
    Double getContentScore(String productId) throws Exception;

}