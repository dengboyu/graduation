package com.gz.evalution.module.eva.dao;

import org.springframework.stereotype.Repository;
import com.gz.evalution.common.structure.dao.BaseDao;
import com.gz.evalution.module.eva.entity.CourseEntity;

import java.util.List;
import java.util.Map;


/**
* course表对应实体类
*
* @author by@Deng
* @create 2018-01-19 11:26:52
*/
@Repository
public interface CourseDao extends BaseDao<CourseEntity> {



    /**
     * 查找课程信息
     * @author by@Deng
     * @date 2018/1/20 下午7:39
     */
    List<Map<String,Object>> getCourseEntityList() throws Exception;




    /**
     * 根据学生id查询专业课评选
     * @author by@Deng
     * @date 2018/1/22 下午9:51
     */
    List<Map<String,String>> getCourseListByStudent(String id) throws Exception;

}