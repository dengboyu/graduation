package com.xsh.activity.module.act.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xsh.activity.module.act.entity.CommunityEntity;
import com.xsh.activity.module.act.service.CommunityService;
import com.xsh.activity.module.act.dao.CommunityDao;
import com.xsh.activity.common.structure.serviceAbstract.BaseServiceAbstract;


/**
* community表对应实体类的业务层的实现类
*
* @author by@Deng
* @create 2018-02-25 04:00:47
*/
@Service
@Transactional
public class CommunityServiceImpl extends BaseServiceAbstract<CommunityDao,CommunityEntity> implements CommunityService {




}