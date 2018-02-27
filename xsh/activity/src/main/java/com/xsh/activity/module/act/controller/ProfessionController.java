package com.xsh.activity.module.act.controller;

import com.xsh.activity.common.annotation.Result;
import com.xsh.activity.module.act.entity.ProfessionEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.xsh.activity.module.act.service.ProfessionService;


/**
* profession表对应实体类的控制层
*
* @author by@Deng
* @create 2018-02-25 02:08:52
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
     * @date 2018/2/25 下午3:23
     */
    @PostMapping("addProfession")
    public Object addProfession(@RequestBody ProfessionEntity professionEntity) throws Exception{
        return professionService.insertEntity(professionEntity);
    }


    /**
     * 根据学院id查找所有专业
     * @author by@Deng
     * @date 2018/2/25 下午4:21
     */
    @GetMapping("getProfessionList")
    public Object getProfessionList(@RequestParam Integer id) throws Exception{
        ProfessionEntity professionEntity = new ProfessionEntity();
        professionEntity.setCollegeId(id);
        return professionService.findEntityList(professionEntity);
    }

}