package com.tt.association.module.ass.serviceImpl;

import org.springframework.stereotype.Service;
import com.tt.association.module.ass.entity.RemarkEntity;
import com.tt.association.module.ass.service.RemarkService;
import com.tt.association.module.ass.dao.RemarkDao;
import com.tt.association.common.structure.serviceAbstract.BaseServiceAbstract;
import org.springframework.transaction.annotation.Transactional;


/**
* remark表对应实体类的业务层的实现类
*
* @author by@Deng
* @create 2018-01-24 10:49:41
*/
@Service
@Transactional
public class RemarkServiceImpl extends BaseServiceAbstract<RemarkDao,RemarkEntity> implements RemarkService {




}