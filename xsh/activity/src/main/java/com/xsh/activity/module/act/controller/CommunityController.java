package com.xsh.activity.module.act.controller;

import com.xsh.activity.common.annotation.Result;
import com.xsh.activity.module.act.entity.CommunityEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.xsh.activity.module.act.service.CommunityService;


/**
* community表对应实体类的控制层
*
* @author by@Deng
* @create 2018-02-25 04:00:47
*/
@RestController
@RequestMapping("community")
@Result
public class CommunityController{

    @Resource
    private CommunityService communityService;


    /**
     * 添加社团
     * @author by@Deng
     * @date 2018/2/25 下午4:03
     */
    @PostMapping("addCommunity")
    public Object addCommunity(@RequestBody CommunityEntity communityEntity) throws Exception{
        return communityService.insertEntity(communityEntity);
    }


    /**
     * 查找所有社团
     * @author by@Deng
     * @date 2018/2/25 下午4:05
     */
    @GetMapping("getCommunityList")
    public Object getCommunityList() throws Exception{
        return communityService.findEntityList(null);
    }

}