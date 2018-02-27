package com.xsh.activity.module.act.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xsh.activity.module.act.entity.ActEntity;
import com.xsh.activity.module.act.service.ActService;
import com.xsh.activity.module.act.dao.ActDao;
import com.xsh.activity.common.structure.serviceAbstract.BaseServiceAbstract;


/**
* act表对应实体类的业务层的实现类
*
* @author by@Deng
* @create 2018-02-26 02:55:32
*/
@Service
@Transactional
public class ActServiceImpl extends BaseServiceAbstract<ActDao,ActEntity> implements ActService {




}