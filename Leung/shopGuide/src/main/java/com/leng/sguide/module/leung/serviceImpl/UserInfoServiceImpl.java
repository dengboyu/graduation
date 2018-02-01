package com.leng.sguide.module.leung.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.leng.sguide.module.leung.entity.UserInfoEntity;
import com.leng.sguide.module.leung.service.UserInfoService;
import com.leng.sguide.module.leung.dao.UserInfoDao;
import com.leng.sguide.common.structure.serviceAbstract.BaseServiceAbstract;


/**
* user_info表对应实体类的业务层的实现类
*
* @author by@Deng
* @create 2018-01-29 01:48:05
*/
@Service
@Transactional
public class UserInfoServiceImpl extends BaseServiceAbstract<UserInfoDao,UserInfoEntity> implements UserInfoService {




}