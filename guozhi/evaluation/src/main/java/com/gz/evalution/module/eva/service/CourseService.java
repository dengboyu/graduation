package com.gz.evalution.module.eva.service;

import com.gz.evalution.module.eva.entity.CourseEntity;
import com.gz.evalution.common.structure.service.BaseService;

import java.util.List;
import java.util.Map;


/**
* course表对应实体类的业务层接口
*
* @author by@Deng
* @create 2018-01-19 11:26:52
*/
public interface CourseService extends BaseService<CourseEntity> {


    /**
     * 查找课程信息
     * @author by@Deng
     * @date 2018/1/20 下午7:39
     */
    List<Map<String,Object>>  getCourseEntityList() throws Exception;


    /**
     * 根据学生id查询专业课评选
     * @author by@Deng
     * @date 2018/1/22 下午9:51
     */
    List<Map<String,String>> getCourseListByStudent(String id) throws Exception;


}