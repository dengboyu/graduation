package com.xsh.activity.module.act.controller;

import com.xsh.activity.common.annotation.Result;
import com.xsh.activity.module.act.entity.ActEntity;
import com.xsh.activity.module.act.entity.CollectEntity;
import com.xsh.activity.module.act.entity.SysUserEntity;
import com.xsh.activity.module.act.service.CollectService;
import com.xsh.activity.module.act.service.CommunityService;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.xsh.activity.module.act.service.ActService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
* act表对应实体类的控制层
*
* @author by@Deng
* @create 2018-02-26 02:55:32
*/
@RestController
@RequestMapping("act")
@Result
public class ActController{

    @Resource
    private ActService actService;
    @Resource
    private CommunityService communityService;
    @Resource
    private CollectService collectService;


    /**
     * 发布活动
     * @author by@Deng
     * @date 2018/2/26 下午2:59
     */
    @PostMapping("addActEntity")
    public Object addActEntity(@RequestBody ActEntity actEntity) throws Exception{
        return actService.insertEntity(actEntity);
    }


    /**
     * 获取活动列表
     * @author by@Deng
     * @date 2018/2/26 下午9:47
     */
    @GetMapping("getActList")
    public Object getActList() throws Exception{
        List<Map<String,Object>> mapList = new ArrayList<>();

        List<ActEntity> actEntityList = actService.findEntityList(null);

        for(ActEntity actEntity :actEntityList){
            Map<String,Object> map = new HashMap<>();

            map.put("actName",actEntity.getActName());
            map.put("id",actEntity.getId());
            map.put("actTime", DateFormatUtils.format(actEntity.getActTime(),"yyyy-MM-dd HH:mm:ss"));
            map.put("communityName",communityService.findEntityByMainId(actEntity.getCommunityId()).getCommunityName());

            mapList.add(map);
        }
        return mapList;
    }


    /**
     * 管理员查看活动详情
     * @author by@Deng
     * @date 2018/2/26 下午10:40
     */
    @GetMapping("getAdminActDetail")
    public Object getAdminActDetail(@RequestParam Integer id) throws Exception{

        Map<String,Object> map = new HashMap<>();

        ActEntity actEntity = actService.findEntityByMainId(id);
        map.put("actName",actEntity.getActName());
        map.put("actPerson",actEntity.getActPerson());
        map.put("communityName",communityService.findEntityByMainId(actEntity.getCommunityId()).getCommunityName());
        map.put("actTime",DateFormatUtils.format(actEntity.getActTime(),"yyyy-MM-dd HH:mm:ss"));
        map.put("actWhere",actEntity.getActWhere());
        map.put("actIntro",actEntity.getActIntro());
        map.put("actDetail",actEntity.getActDetail());
        map.put("createTime",DateFormatUtils.format(actEntity.getCreateTime(),"yyyy-MM-dd HH:mm:ss"));

        return map;
    }


    /**
     * 用户查看活动详情
     * @author by@Deng
     * @date 2018/2/26 下午10:40
     */
    @GetMapping("getActDetail")
    public Object getActDetail(@RequestParam Integer id) throws Exception{

        SysUserEntity sysUserEntity1 = (SysUserEntity) SecurityUtils.getSubject().getSession().getAttribute("currentUser");

        Map<String,Object> map = new HashMap<>();

        ActEntity actEntity = actService.findEntityByMainId(id);
        map.put("id",actEntity.getId());
        map.put("actName",actEntity.getActName());
        map.put("actPerson",actEntity.getActPerson());
        map.put("communityName",communityService.findEntityByMainId(actEntity.getCommunityId()).getCommunityName());
        map.put("actTime",DateFormatUtils.format(actEntity.getActTime(),"yyyy-MM-dd HH:mm:ss"));
        map.put("actWhere",actEntity.getActWhere());
        map.put("actIntro",actEntity.getActIntro());
        map.put("actDetail",actEntity.getActDetail());
        map.put("createTime",DateFormatUtils.format(actEntity.getCreateTime(),"yyyy-MM-dd HH:mm:ss"));

        map.put("isCollection",0);
        CollectEntity collectEntity = new CollectEntity();
        collectEntity.setUserId(sysUserEntity1.getId());
        collectEntity.setActId(actEntity.getId());

        if(collectService.findEntityByOne(collectEntity)!=null){
            map.put("isCollection",1);//收藏
        }

        return map;
    }


    /**
     * 用户的活动列表
     * @author by@Deng
     * @date 2018/2/27 上午9:59
     */
    @GetMapping("getUserActList")
    public Object getUserActList() throws Exception{

        SysUserEntity sysUserEntity1 = (SysUserEntity) SecurityUtils.getSubject().getSession().getAttribute("currentUser");

        List<Map<String,Object>> mapList = new ArrayList<>();

        List<ActEntity> actEntityList = actService.findEntityList(null);

        for(ActEntity actEntity :actEntityList){
            Map<String,Object> map = new HashMap<>();

            map.put("actName",actEntity.getActName());
            map.put("id",actEntity.getId());
            map.put("actTime", DateFormatUtils.format(actEntity.getActTime(),"yyyy-MM-dd HH:mm:ss"));
            map.put("communityName",communityService.findEntityByMainId(actEntity.getCommunityId()).getCommunityName());


            map.put("isCollection",0);
            CollectEntity collectEntity = new CollectEntity();
            collectEntity.setUserId(sysUserEntity1.getId());
            collectEntity.setActId(actEntity.getId());

            if(collectService.findEntityByOne(collectEntity)!=null){
               map.put("isCollection",1);//收藏
            }


            mapList.add(map);
        }
        return mapList;
    }



}