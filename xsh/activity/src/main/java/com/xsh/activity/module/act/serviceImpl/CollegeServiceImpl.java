package com.xsh.activity.module.act.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xsh.activity.module.act.entity.CollegeEntity;
import com.xsh.activity.module.act.service.CollegeService;
import com.xsh.activity.module.act.dao.CollegeDao;
import com.xsh.activity.common.structure.serviceAbstract.BaseServiceAbstract;


/**
* college表对应实体类的业务层的实现类
*
* @author by@Deng
* @create 2018-02-25 02:08:39
*/
@Service
@Transactional
public class CollegeServiceImpl extends BaseServiceAbstract<CollegeDao,CollegeEntity> implements CollegeService {




}