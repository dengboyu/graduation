package com.leng.sguide.module.leung.dao;

import org.springframework.stereotype.Repository;
import com.leng.sguide.common.structure.dao.BaseDao;
import com.leng.sguide.module.leung.entity.ContentEntity;


/**
* content表对应实体类
*
* @author by@Deng
* @create 2018-01-29 01:47:45
*/
@Repository
public interface ContentDao extends BaseDao<ContentEntity> {

    /**
     * 获取平均分
     * @author by@Deng
     * @date 2018/2/1 上午12:04
     */
    Double getContentScore(String productId) throws Exception;

}