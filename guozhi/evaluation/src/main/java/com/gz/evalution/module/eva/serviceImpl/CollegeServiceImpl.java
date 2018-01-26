package com.gz.evalution.module.eva.serviceImpl;

import com.gz.evalution.module.eva.entity.CollegeVo;
import org.springframework.stereotype.Service;
import com.gz.evalution.module.eva.entity.CollegeEntity;
import com.gz.evalution.module.eva.service.CollegeService;
import com.gz.evalution.module.eva.dao.CollegeDao;
import com.gz.evalution.common.structure.serviceAbstract.BaseServiceAbstract;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
* college表对应实体类的业务层的实现类
*
* @author by@Deng
* @create 2018-01-19 11:26:46
*/
@Service
@Transactional
public class CollegeServiceImpl extends BaseServiceAbstract<CollegeDao,CollegeEntity> implements CollegeService {


    /**
     * 获取学院和专业
     * @author by@Deng
     * @date 2018/1/19 下午10:03
     */
    @Override
    public List<CollegeVo> getCollegeVoList(Map<String,String> map) throws Exception {
        return dao.getCollegeVoList(map);
    }
}