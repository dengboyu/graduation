package com.tt.association.module.ass.serviceImpl;

import org.springframework.stereotype.Service;
import com.tt.association.module.ass.entity.UserInfoEntity;
import com.tt.association.module.ass.service.UserInfoService;
import com.tt.association.module.ass.dao.UserInfoDao;
import com.tt.association.common.structure.serviceAbstract.BaseServiceAbstract;
import org.springframework.transaction.annotation.Transactional;


/**
* user_i
 * nfo表对应实体类的业务层的实现类
*
* @author by@Deng
* @create 2018-01-24 10:49:47
*/
@Service
@Transactional
public class UserInfoServiceImpl extends BaseServiceAbstract<UserInfoDao,UserInfoEntity> implements UserInfoService {




}