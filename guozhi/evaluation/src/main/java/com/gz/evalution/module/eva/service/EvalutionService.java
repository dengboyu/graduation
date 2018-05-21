package com.gz.evalution.module.eva.service;

import com.gz.evalution.module.eva.entity.EvalutionEntity;
import com.gz.evalution.common.structure.service.BaseService;

import java.util.List;
import java.util.Map;


/**
* evalution表对应实体类的业务层接口
*
* @author by@Deng
* @create 2018-01-19 11:26:57
*/
public interface EvalutionService extends BaseService<EvalutionEntity> {


    /**
     * 获取学生评论结果
     * @author by@Deng
     * @date 2018/1/24 下午5:00
     */
    Map<String,Object> getCourseStudentList(Map<String,String> map) throws Exception;




    /**
     * 根据教师id查询课程及评选分数
     * @author by@Deng
     * @date 2018/1/24 下午5:40
     */
    List<Map<String,Object>> getCourseTeacher(String id) throws Exception;


    /**
     * 查看详情
     * @author by@Deng
     * @date 2018/1/24 下午6:56
     */
    Map<String,Object>  getCourseListByStudent(String evalutionId) throws Exception;

}