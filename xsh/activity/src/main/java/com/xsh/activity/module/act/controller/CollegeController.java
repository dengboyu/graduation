package com.xsh.activity.module.act.controller;

import com.xsh.activity.common.annotation.Result;
import com.xsh.activity.module.act.entity.CollegeEntity;
import com.xsh.activity.module.act.entity.ProfessionEntity;
import com.xsh.activity.module.act.service.ProfessionService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.xsh.activity.module.act.service.CollegeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
* college表对应实体类的控制层
*
* @author by@Deng
* @create 2018-02-25 02:08:39
*/
@RestController
@RequestMapping("college")
@Result
public class CollegeController{

    @Resource
    private CollegeService collegeService;
    @Resource
    private ProfessionService professionService;


    /**
     * 添加学院
     * @author by@Deng
     * @date 2018/2/25 下午2:22
     */
    @PostMapping("addCollege")
    public Object addCollege(@RequestBody CollegeEntity collegeEntity) throws Exception{
        return collegeService.insertEntity(collegeEntity);
    }


    /**
     * 获取学院和专业信息
     * @author by@Deng
     * @date 2018/2/25 下午2:24
     */
    @GetMapping("getCollegeProfession")
    public Object getCollegeProfession() throws Exception{

        List<Map<String,Object>> mapList = new ArrayList<>();

        List<CollegeEntity> collegeEntityList = collegeService.findEntityList(null);
        if(collegeEntityList.size()>0){

            for(CollegeEntity collegeEntity :collegeEntityList){
                Map<String,Object> map = new HashMap<>();
                map.put("collegeName",collegeEntity.getCollegeName());
                map.put("id",collegeEntity.getId());

                //查询专业
                ProfessionEntity professionEntity = new ProfessionEntity();
                professionEntity.setCollegeId(collegeEntity.getId());
                List<ProfessionEntity> professionEntityList= professionService.findEntityList(professionEntity);

                map.put("professionEntityList",professionEntityList);

                mapList.add(map);
            }
        }

        return mapList;
    }


}