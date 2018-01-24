package com.gz.evalution.module.eva.controller;

import com.gz.evalution.common.annotation.Result;
import com.gz.evalution.module.eva.entity.ProfessionEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.gz.evalution.module.eva.service.ProfessionService;


/**
* profession表对应实体类的控制层
*
* @author by@Deng
* @create 2018-01-19 11:27:01
*/
@RestController
@RequestMapping("profession")
@Result
public class ProfessionController{

    @Resource
    private ProfessionService professionService;


    /**
     * 添加专业
     * @author by@Deng
     * @date 2018/1/19 下午3:23
     */
    @PostMapping("addProfessionEntity")
    public Object addProfessionEntity(@RequestBody ProfessionEntity professionEntity) throws Exception{
        professionEntity.setStatu("1");
        return professionService.insertEntity(professionEntity);
    }

}