package com.tt.association.module.ass.serviceImpl;

import org.springframework.stereotype.Service;
import com.tt.association.module.ass.entity.CompanyEntity;
import com.tt.association.module.ass.service.CompanyService;
import com.tt.association.module.ass.dao.CompanyDao;
import com.tt.association.common.structure.serviceAbstract.BaseServiceAbstract;
import org.springframework.transaction.annotation.Transactional;


/**
* company表对应实体类的业务层的实现类
*
* @author by@Deng
* @create 2018-01-24 10:49:09
*/
@Service
@Transactional
public class CompanyServiceImpl extends BaseServiceAbstract<CompanyDao,CompanyEntity> implements CompanyService {




}