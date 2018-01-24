package com.gz.evalution.module.eva.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.gz.evalution.common.structure.dao.BaseDao;
import com.gz.evalution.module.eva.entity.EvalutionEntity;

import java.util.List;
import java.util.Map;


/**
* evalution表对应实体类
*
* @author by@Deng
* @create 2018-01-19 11:26:57
*/
@Repository
public interface EvalutionDao extends BaseDao<EvalutionEntity> {


    /**
     * 获取学生评论结果
     * @author by@Deng
     * @date 2018/1/24 下午5:00
     */
    List<Map<String,Object>> getCourseStudentList(String courseId) throws Exception;


    /**
     * 获取平均分
     * @author by@Deng
     * @date 2018/1/24 下午5:11
     */
    String getCourseStudentAvg(String courseId) throws Exception;


    /**
     * 根据教师id查询课程及评选分数
     * @author by@Deng
     * @date 2018/1/24 下午5:40
     */
    List<Map<String,Object>> getCourseTeacher(String id) throws Exception;


}