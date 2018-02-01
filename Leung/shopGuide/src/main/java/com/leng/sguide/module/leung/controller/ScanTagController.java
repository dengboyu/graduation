package com.leng.sguide.module.leung.controller;

import com.leng.sguide.common.annotation.Result;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.leng.sguide.module.leung.service.ScanTagService;


/**
* scan_tag表对应实体类的控制层
*
* @author by@Deng
* @create 2018-02-01 08:39:14
*/
@RestController
@RequestMapping("scanTag")
@Result
public class ScanTagController{

    @Resource
    private ScanTagService scanTagService;



}