package com.tt.association.module.ass.controller;

import com.tt.association.common.annotation.Result;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.tt.association.module.ass.service.QuoProductService;


/**
* quoProduct表对应实体类的控制层
*
* @author by@Deng
* @create 2018-01-24 10:49:32
*/
@RestController
@RequestMapping("quoProduct")
@Result
public class QuoProductController{

    @Resource
    private QuoProductService quoProductService;



}