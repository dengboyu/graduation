package com.gz.evalution.module.eva.service;

import com.gz.evalution.module.eva.entity.CollegeEntity;
import com.gz.evalution.common.structure.service.BaseService;
import com.gz.evalution.module.eva.entity.CollegeVo;

import java.util.List;
import java.util.Map;


/**
* college表对应实体类的业务层接口
*
* @author by@Deng
* @create 2018-01-19 11:26:46
*/
public interface CollegeService extends BaseService<CollegeEntity> {


    /**
     * 获取学院和专业
     * @author by@Deng
     * @date 2018/1/19 下午10:03
     */
    List<CollegeVo>  getCollegeVoList(Map<String,String> map) throws Exception;


}