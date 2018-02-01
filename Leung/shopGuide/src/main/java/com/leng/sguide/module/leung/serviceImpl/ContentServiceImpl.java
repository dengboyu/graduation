package com.leng.sguide.module.leung.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.leng.sguide.module.leung.entity.ContentEntity;
import com.leng.sguide.module.leung.service.ContentService;
import com.leng.sguide.module.leung.dao.ContentDao;
import com.leng.sguide.common.structure.serviceAbstract.BaseServiceAbstract;


/**
* content表对应实体类的业务层的实现类
*
* @author by@Deng
* @create 2018-01-29 01:47:45
*/
@Service
@Transactional
public class ContentServiceImpl extends BaseServiceAbstract<ContentDao,ContentEntity> implements ContentService {


    /**
     * 获取平均分
     * @author by@Deng
     * @date 2018/2/1 上午12:06
     */
    @Override
    public Double getContentScore(String productId) throws Exception {
        return dao.getContentScore(productId);
    }
}