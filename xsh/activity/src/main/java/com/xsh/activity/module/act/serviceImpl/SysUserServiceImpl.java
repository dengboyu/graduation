package com.xsh.activity.module.act.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.xsh.activity.module.act.entity.SysUserEntity;
import com.xsh.activity.module.act.service.SysUserService;
import com.xsh.activity.module.act.dao.SysUserDao;
import com.xsh.activity.common.structure.serviceAbstract.BaseServiceAbstract;


/**
* sys_user表对应实体类的业务层的实现类
*
* @author by@Deng
* @create 2018-02-25 09:29:52
*/
@Service
@Transactional
public class SysUserServiceImpl extends BaseServiceAbstract<SysUserDao,SysUserEntity> implements SysUserService {




}