package com.xsh.activity.module.act.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xsh.activity.module.act.entity.FriendGroupEntity;
import com.xsh.activity.module.act.service.FriendGroupService;
import com.xsh.activity.module.act.dao.FriendGroupDao;
import com.xsh.activity.common.structure.serviceAbstract.BaseServiceAbstract;


/**
* friendGroup表对应实体类的业务层的实现类
*
* @author by@Deng
* @create 2018-02-26 08:42:33
*/
@Service
@Transactional
public class FriendGroupServiceImpl extends BaseServiceAbstract<FriendGroupDao,FriendGroupEntity> implements FriendGroupService {




}