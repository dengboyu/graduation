package com.xsh.activity.module.act.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xsh.activity.module.act.entity.RecommandActEntity;
import com.xsh.activity.module.act.service.RecommandActService;
import com.xsh.activity.module.act.dao.RecommandActDao;
import com.xsh.activity.common.structure.serviceAbstract.BaseServiceAbstract;


/**
* recommandAct表对应实体类的业务层的实现类
*
* @author by@Deng
* @create 2018-02-26 02:56:00
*/
@Service
@Transactional
public class RecommandActServiceImpl extends BaseServiceAbstract<RecommandActDao,RecommandActEntity> implements RecommandActService {




}