package com.xsh.activity.module.act.controller;

import com.xsh.activity.common.annotation.Result;
import com.xsh.activity.module.act.entity.ActEntity;
import com.xsh.activity.module.act.entity.CollectEntity;
import com.xsh.activity.module.act.entity.SysUserEntity;
import com.xsh.activity.module.act.service.ActService;
import com.xsh.activity.module.act.service.CommunityService;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.xsh.activity.module.act.service.CollectService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
* collect表对应实体类的控制层
*
* @author by@Deng
* @create 2018-02-26 02:55:46
*/
@RestController
@RequestMapping("collect")
@Result
public class CollectController{

    @Resource
    private CollectService collectService;
    @Resource
    private ActService actService;
    @Resource
    private CommunityService communityService;




    /**
     * 收藏活动
     * @author by@Deng
     * @date 2018/2/27 下午2:50
     */
    @PostMapping("addCollectEntity")
    public Object addCollectEntity(@RequestParam Integer id) throws Exception{

        SysUserEntity sysUserEntity1 = (SysUserEntity) SecurityUtils.getSubject().getSession().getAttribute("currentUser");

        CollectEntity collectEntity = new CollectEntity();
        collectEntity.setActId(id);
        collectEntity.setUserId(sysUserEntity1.getId());

        return collectService.insertEntity(collectEntity);
    }


    /**
     * 取消收藏活动
     * @author by@Deng
     * @date 2018/2/27 下午3:05
     */
    @PostMapping("delCollectEntity")
    public Object delCollectEntity(@RequestParam Integer id) throws Exception{

        SysUserEntity sysUserEntity1 = (SysUserEntity) SecurityUtils.getSubject().getSession().getAttribute("currentUser");

        CollectEntity collectEntity = new CollectEntity();
        collectEntity.setActId(id);
        collectEntity.setUserId(sysUserEntity1.getId());

        collectEntity = collectService.findEntityByOne(collectEntity);

        return collectService.deleteEntity(collectEntity.getId());

    }


    /**
     * 获取所有收藏活动列表
     * @author by@Deng
     * @date 2018/2/27 下午3:10
     */
    @GetMapping("getCollectList")
    public Object getCollectList() throws Exception{
        List<Map<String,Object>> mapList = new ArrayList<>();

        SysUserEntity sysUserEntity1 = (SysUserEntity) SecurityUtils.getSubject().getSession().getAttribute("currentUser");

        CollectEntity collectEntity = new CollectEntity();
        collectEntity.setUserId(sysUserEntity1.getId());

        List<CollectEntity> collectEntityList = collectService.findEntityList(collectEntity);
        for(CollectEntity collectEntity1 :collectEntityList){

            Map<String,Object> map = new HashMap<>();

            ActEntity actEntity = actService.findEntityByMainId(collectEntity1.getActId());

            map.put("actName",actEntity.getActName());
            map.put("id",actEntity.getId());
            map.put("actTime", DateFormatUtils.format(actEntity.getActTime(),"yyyy-MM-dd HH:mm:ss"));
            map.put("communityName",communityService.findEntityByMainId(actEntity.getCommunityId()).getCommunityName());

            map.put("isCollection",1);

            mapList.add(map);

        }

        return mapList;
    }


}