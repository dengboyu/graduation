package com.tt.association.module.ass.serviceImpl;

import org.springframework.stereotype.Service;
import com.tt.association.module.ass.entity.QuoProductEntity;
import com.tt.association.module.ass.service.QuoProductService;
import com.tt.association.module.ass.dao.QuoProductDao;
import com.tt.association.common.structure.serviceAbstract.BaseServiceAbstract;
import org.springframework.transaction.annotation.Transactional;


/**
* quoProduct表对应实体类的业务层的实现类
*
* @author by@Deng
* @create 2018-01-24 10:49:32
*/
@Service
@Transactional
public class QuoProductServiceImpl extends BaseServiceAbstract<QuoProductDao,QuoProductEntity> implements QuoProductService {




}