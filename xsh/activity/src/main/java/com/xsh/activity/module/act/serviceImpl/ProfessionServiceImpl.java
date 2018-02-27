package com.xsh.activity.module.act.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xsh.activity.module.act.entity.ProfessionEntity;
import com.xsh.activity.module.act.service.ProfessionService;
import com.xsh.activity.module.act.dao.ProfessionDao;
import com.xsh.activity.common.structure.serviceAbstract.BaseServiceAbstract;


/**
* profession表对应实体类的业务层的实现类
*
* @author by@Deng
* @create 2018-02-25 02:08:52
*/
@Service
@Transactional
public class ProfessionServiceImpl extends BaseServiceAbstract<ProfessionDao,ProfessionEntity> implements ProfessionService {




}