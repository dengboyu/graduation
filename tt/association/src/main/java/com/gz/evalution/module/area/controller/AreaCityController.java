package com.gz.evalution.module.area.controller;

import javax.annotation.Resource;

import com.gz.evalution.common.annotation.Result;
import com.gz.evalution.common.exception.ByException;
import com.gz.evalution.common.exception.CodeEnum;
import com.gz.evalution.module.area.service.AreaCityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



/**
* area_city表对应实体类的控制层
*
* @author by@Deng
* @create 2018-01-07 11:36:46
*/
@RestController
@Result
public class AreaCityController{

    @Resource
    private AreaCityService areaCityService;


    @GetMapping("/getTest")
    public Object getTest() throws Exception {
        throw new ByException("错了");
//        return areaCityService.findEntityByMainId(1);
    }

}