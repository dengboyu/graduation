package com.tt.association.module.ass.serviceImpl;

import org.springframework.stereotype.Service;
import com.tt.association.module.ass.entity.CustomerEntity;
import com.tt.association.module.ass.service.CustomerService;
import com.tt.association.module.ass.dao.CustomerDao;
import com.tt.association.common.structure.serviceAbstract.BaseServiceAbstract;
import org.springframework.transaction.annotation.Transactional;


/**
* customer表对应实体类的业务层的实现类
*
* @author by@Deng
* @create 2018-01-24 10:49:15
*/
@Service
@Transactional
public class CustomerServiceImpl extends BaseServiceAbstract<CustomerDao,CustomerEntity> implements CustomerService {




}