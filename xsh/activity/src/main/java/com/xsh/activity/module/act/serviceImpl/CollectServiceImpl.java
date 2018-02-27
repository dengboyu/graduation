package com.xsh.activity.module.act.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xsh.activity.module.act.entity.CollectEntity;
import com.xsh.activity.module.act.service.CollectService;
import com.xsh.activity.module.act.dao.CollectDao;
import com.xsh.activity.common.structure.serviceAbstract.BaseServiceAbstract;


/**
* collect表对应实体类的业务层的实现类
*
* @author by@Deng
* @create 2018-02-26 02:55:46
*/
@Service
@Transactional
public class CollectServiceImpl extends BaseServiceAbstract<CollectDao,CollectEntity> implements CollectService {




}