package com.gz.evalution.module.eva.controller;

import com.gz.evalution.common.annotation.Result;
import com.gz.evalution.module.eva.entity.CollegeEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import com.gz.evalution.module.eva.service.CollegeService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
* college表对应实体类的控制层
*
* @author by@Deng
* @create 2018-01-19 11:26:46
*/
@RestController
@RequestMapping("college")
@Result
public class CollegeController{

    @Resource
    private CollegeService collegeService;


    /**
     * 增加学院信息
     * @author by@Deng
     * @date 2018/1/19 上午11:40
     */
    @PostMapping("addCollegeEntity")
    public Object addCollegeEntity(@RequestBody CollegeEntity collegeEntity) throws Exception{

        collegeEntity.setStatu("1");
        return collegeService.insertEntity(collegeEntity);
    }


    /**
     * 获取学院信息
     * @author by@Deng
     * @date 2018/1/19 下午10:04
     */
    @GetMapping("getCollegeList")
    public Object getCollegeList() throws Exception{
        CollegeEntity collegeEntity = new CollegeEntity();
        collegeEntity.setStatu("1");
        return collegeService.findEntityList(collegeEntity);
    }


    /**
     * 获取专业和学院
     * @author by@Deng
     * @date 2018/1/19 下午10:05
     */
    @GetMapping("getCollegeVoList")
    public Object getCollegeVoList(@RequestParam Map<String,String> map) throws Exception {
        System.out.println(map.get("id"));
        return collegeService.getCollegeVoList(map);
    }



}