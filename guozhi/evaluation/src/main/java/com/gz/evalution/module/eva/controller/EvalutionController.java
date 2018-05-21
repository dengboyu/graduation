package com.gz.evalution.module.eva.controller;

import com.gz.evalution.common.annotation.Result;
import com.gz.evalution.module.eva.entity.CourseEntity;
import com.gz.evalution.module.eva.entity.EvalutionEntity;
import com.gz.evalution.module.eva.entity.UserInfoEntity;
import com.gz.evalution.module.eva.service.CourseService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.gz.evalution.module.eva.service.EvalutionService;

import java.util.List;
import java.util.Map;


/**
* evalution表对应实体类的控制层
*
* @author by@Deng
* @create 2018-01-19 04:59:55
*/
@RestController
@RequestMapping("evalution")
@Result
public class EvalutionController{

    @Resource
    private EvalutionService evalutionService;
    @Resource
    private CourseService courseService;


    /**
     * 增加学生评论
     * @author by@Deng
     * @date 2018/1/24 下午4:05
     */
    @PostMapping("insertEvalutionEntity")
    public Object insertEvalutionEntity(@RequestBody EvalutionEntity evalutionEntity)throws Exception{

        Subject subject = SecurityUtils.getSubject();
        UserInfoEntity userInfoEntity = (UserInfoEntity) subject.getSession().getAttribute("currentUser");

        CourseEntity courseEntity = courseService.findEntityByMainId(evalutionEntity.getCouseId());
        evalutionEntity.setStudentId(userInfoEntity.getId().toString());
        evalutionEntity.setTeacherId(courseEntity.getTeacher());
        evalutionEntity.setStatu("1");

        return evalutionService.insertEntity(evalutionEntity);
    }


    /**
     * 查询某个课程被学生评教的结果
     * @author by@Deng
     * @date 2018/1/24 下午4:53
     */
    @GetMapping("getEvalutionList")
    public Object getEvalutionList(@RequestParam Map<String,String> map) throws Exception{
        return evalutionService.getCourseStudentList(map);
    }


    /**
     * 根据教师id查询课程及评选分数
     * @author by@Deng
     * @date 2018/1/24 下午5:43
     */
    @GetMapping("getCourseTeacher")
    public Object getCourseTeacher() throws Exception{

        Subject subject = SecurityUtils.getSubject();
        UserInfoEntity userInfoEntity = (UserInfoEntity) subject.getSession().getAttribute("currentUser");

        return evalutionService.getCourseTeacher(userInfoEntity.getId().toString());
    }



    /**
     * 查看详情
     * @author by@Deng
     * @date 2018/1/24 下午6:56
     */
    @GetMapping("getCourseListByStudent")
    public Object getCourseListByStudent(@RequestParam String evalutionId) throws Exception{
        return evalutionService.getCourseListByStudent(evalutionId);
    }


    /**
     * 删除学生回答
     * @author by@Deng
     * @date 2018/1/24 下午6:56
     */
    @GetMapping("deleteAnswer")
    public Object deleteAnswer(@RequestParam String evalutionId) throws Exception{
        return evalutionService.deleteEntity(evalutionId);
    }

}