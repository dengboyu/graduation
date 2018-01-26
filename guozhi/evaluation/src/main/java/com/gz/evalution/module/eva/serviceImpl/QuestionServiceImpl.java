package com.gz.evalution.module.eva.serviceImpl;

import org.springframework.stereotype.Service;
import com.gz.evalution.module.eva.entity.QuestionEntity;
import com.gz.evalution.module.eva.service.QuestionService;
import com.gz.evalution.module.eva.dao.QuestionDao;
import com.gz.evalution.common.structure.serviceAbstract.BaseServiceAbstract;
import org.springframework.transaction.annotation.Transactional;


/**
* question表对应实体类的业务层的实现类
*
* @author by@Deng
* @create 2018-01-19 11:27:06
*/
@Service
@Transactional
public class QuestionServiceImpl extends BaseServiceAbstract<QuestionDao,QuestionEntity> implements QuestionService {




}