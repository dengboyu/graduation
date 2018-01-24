package com.gz.evalution.module.eva.controller;

import com.gz.evalution.common.annotation.Result;
import com.gz.evalution.module.eva.entity.CourseEntity;
import com.gz.evalution.module.eva.entity.UserInfoEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

import com.gz.evalution.module.eva.service.CourseService;


/**
* course表对应实体类的控制层
*
* @author by@Deng
* @create 2018-01-19 04:59:51
*/
@RestController
@RequestMapping("course")
@Result
public class CourseController{

    @Resource
    private CourseService courseService;


    /**
     * 添加课程
     * @author by@Deng
     * @date 2018/1/20 上午12:35
     */
    @PostMapping("addCourseEntity")
    public Object addCourseEntity(@RequestBody CourseEntity courseEntity) throws Exception{
        courseEntity.setStatu("1");
        return courseService.insertEntity(courseEntity);
    }


    /**
     * 获取课程项目
     * @author by@Deng
     * @date 2018/1/20 下午7:37
     */
    @GetMapping("getCourseEntityList")
    public Object getCourseEntityList() throws Exception{

        return courseService.getCourseEntityList();
    }


    /**
     * 删除课程
     * @author by@Deng
     * @date 2018/1/20 下午8:36
     */
    @PostMapping("deleteCourseEntity")
    public Object deleteCourseEntityById(@RequestParam String id) throws Exception{
        return courseService.deleteEntity(id);
    }


    /**
     * 更新课程信息
     * @author by@Deng
     * @date 2018/1/22 下午9:58
     */
    @PostMapping("updateCourseEntity")
    public Object updateCourseEntity(@RequestBody CourseEntity courseEntity)throws Exception{
        return courseService.updateEntity(courseEntity);
    }


    /**
     *
     * @author by@Deng
     * @date 2018/1/22 下午9:58
     */
    @GetMapping("getCourseListByStudent")
    public Object getCourseListByStudent() throws Exception{
        Subject subject = SecurityUtils.getSubject();
        UserInfoEntity userInfoEntity = (UserInfoEntity) subject.getSession().getAttribute("currentUser");
        return courseService.getCourseListByStudent(userInfoEntity.getId().toString());
    }






}