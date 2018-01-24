package com.gz.evalution.module.eva.serviceImpl;

import com.gz.evalution.module.eva.entity.CourseEntity;
import com.gz.evalution.module.eva.entity.QuestionEntity;
import com.gz.evalution.module.eva.service.CourseService;
import com.gz.evalution.module.eva.service.QuestionService;
import org.springframework.stereotype.Service;
import com.gz.evalution.module.eva.entity.EvalutionEntity;
import com.gz.evalution.module.eva.service.EvalutionService;
import com.gz.evalution.module.eva.dao.EvalutionDao;
import com.gz.evalution.common.structure.serviceAbstract.BaseServiceAbstract;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
* evalution表对应实体类的业务层的实现类
*
* @author by@Deng
* @create 2018-01-19 11:26:57
*/
@Service
public class EvalutionServiceImpl extends BaseServiceAbstract<EvalutionDao,EvalutionEntity> implements EvalutionService {


    @Resource
    private QuestionService questionService;


    /**
     * 获取学生评论结果
     * @author by@Deng
     * @date 2018/1/24 下午5:00
     */
    @Override
    public Map<String, Object> getCourseStudentList(String courseId) throws Exception {

        Map<String,Object> retMap = new HashMap<>();
        retMap.put("studentCourse",dao.getCourseStudentList(courseId));
        retMap.put("avg",dao.getCourseStudentAvg(courseId));


        return retMap;
    }


    /**
     * 根据教师id查询课程及评选分数
     * @author by@Deng
     * @date 2018/1/24 下午5:41
     */
    @Override
    public List<Map<String, Object>> getCourseTeacher(String id) throws Exception {
        return dao.getCourseTeacher(id);
    }


    /**
     * 查看详情
     * @author by@Deng
     * @date 2018/1/24 下午6:57
     */
    @Override
    public List<Map<String, Object>> getCourseListByStudent(String evalutionId) throws Exception {
        List<Map<String,Object>> list = new ArrayList<>();


        EvalutionEntity evalutionEntity = findEntityByMainId(evalutionId);
        String[] anwserArr = evalutionEntity.getAnswer().split(",");

        for(String anwser:anwserArr){
            String[] question = anwser.split("-");

            Map<String,Object> map = new HashMap<>();
            QuestionEntity questionEntity = questionService.findEntityByMainId(question[0]);
            map.put("question",questionEntity.getQuestion());
            map.put("score",question[1]);

            list.add(map);
        }

        return list;
    }
}