package com.gz.evalution.module.eva.serviceImpl;

import org.springframework.stereotype.Service;
import com.gz.evalution.module.eva.entity.CourseEntity;
import com.gz.evalution.module.eva.service.CourseService;
import com.gz.evalution.module.eva.dao.CourseDao;
import com.gz.evalution.common.structure.serviceAbstract.BaseServiceAbstract;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
* course表对应实体类的业务层的实现类
*
* @author by@Deng
* @create 2018-01-19 11:26:52
*/
@Service
@Transactional
public class CourseServiceImpl extends BaseServiceAbstract<CourseDao,CourseEntity> implements CourseService {





    /**
     * 查询课程信息
     * @author by@Deng
     * @date 2018/1/20 下午7:39
     */
    @Override
    public List<Map<String,Object>> getCourseEntityList() throws Exception {
        return dao.getCourseEntityList();
    }


    /**
     * 根据学生id查询专业课评选
     * @author by@Deng
     * @date 2018/1/22 下午9:52
     */
    @Override
    public List<Map<String,String>> getCourseListByStudent(String id) throws Exception {
        return dao.getCourseListByStudent(id);
    }


}