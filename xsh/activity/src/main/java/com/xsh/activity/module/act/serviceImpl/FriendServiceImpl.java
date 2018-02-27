package com.xsh.activity.module.act.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xsh.activity.module.act.entity.FriendEntity;
import com.xsh.activity.module.act.service.FriendService;
import com.xsh.activity.module.act.dao.FriendDao;
import com.xsh.activity.common.structure.serviceAbstract.BaseServiceAbstract;


/**
* friend表对应实体类的业务层的实现类
*
* @author by@Deng
* @create 2018-02-26 08:54:36
*/
@Service
@Transactional
public class FriendServiceImpl extends BaseServiceAbstract<FriendDao,FriendEntity> implements FriendService {




}