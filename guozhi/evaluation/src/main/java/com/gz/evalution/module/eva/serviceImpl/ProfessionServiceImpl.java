package com.gz.evalution.module.eva.serviceImpl;

import org.springframework.stereotype.Service;
import com.gz.evalution.module.eva.entity.ProfessionEntity;
import com.gz.evalution.module.eva.service.ProfessionService;
import com.gz.evalution.module.eva.dao.ProfessionDao;
import com.gz.evalution.common.structure.serviceAbstract.BaseServiceAbstract;
import org.springframework.transaction.annotation.Transactional;


/**
* profession表对应实体类的业务层的实现类
*
* @author by@Deng
* @create 2018-01-19 11:27:01
*/
@Service
@Transactional
public class ProfessionServiceImpl extends BaseServiceAbstract<ProfessionDao,ProfessionEntity> implements ProfessionService {




}