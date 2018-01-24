package com.gz.evalution.module.eva.dao;

import com.gz.evalution.module.eva.entity.CollegeVo;
import org.springframework.stereotype.Repository;
import com.gz.evalution.common.structure.dao.BaseDao;
import com.gz.evalution.module.eva.entity.CollegeEntity;

import java.util.List;
import java.util.Map;


/**
* college表对应实体类
*
* @author by@Deng
* @create 2018-01-19 11:26:46
*/
@Repository
public interface CollegeDao extends BaseDao<CollegeEntity> {


    /**
     *  查询学院和专业
     * @author by@Deng
     * @date 2018/1/19 下午9:46
     */
    List<CollegeVo>  getCollegeVoList(Map<String,String> map) throws Exception;

}