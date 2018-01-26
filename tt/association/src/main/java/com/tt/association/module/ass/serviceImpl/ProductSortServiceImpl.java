package com.tt.association.module.ass.serviceImpl;

import org.springframework.stereotype.Service;
import com.tt.association.module.ass.entity.ProductSortEntity;
import com.tt.association.module.ass.service.ProductSortService;
import com.tt.association.module.ass.dao.ProductSortDao;
import com.tt.association.common.structure.serviceAbstract.BaseServiceAbstract;
import org.springframework.transaction.annotation.Transactional;


/**
* product_sort表对应实体类的业务层的实现类
*
* @author by@Deng
* @create 2018-01-24 10:49:27
*/
@Service
@Transactional
public class ProductSortServiceImpl extends BaseServiceAbstract<ProductSortDao,ProductSortEntity> implements ProductSortService {




}