package com.tt.association.module.ass.serviceImpl;

import org.springframework.stereotype.Service;
import com.tt.association.module.ass.entity.ProductEntity;
import com.tt.association.module.ass.service.ProductService;
import com.tt.association.module.ass.dao.ProductDao;
import com.tt.association.common.structure.serviceAbstract.BaseServiceAbstract;
import org.springframework.transaction.annotation.Transactional;


/**
* product表对应实体类的业务层的实现类
*
* @author by@Deng
* @create 2018-01-24 10:49:22
*/
@Service
@Transactional
public class ProductServiceImpl extends BaseServiceAbstract<ProductDao,ProductEntity> implements ProductService {




}