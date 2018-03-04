package com.xsh.activity.module.act.controller;

import com.xsh.activity.common.annotation.Result;
import com.xsh.activity.module.act.entity.*;
import com.xsh.activity.module.act.service.*;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
* recommandAct表对应实体类的控制层
*
* @author by@Deng
* @create 2018-02-26 02:56:00
*/
@RestController
@RequestMapping("recommandAct")
@Result
public class RecommandActController{

    @Resource
    private RecommandActService recommandActService;
    @Resource
    private ActService actService;
    @Resource
    private CommunityService communityService;
    @Resource
    private FriendService friendService;
    @Resource
    private SysUserService sysUserService;


    /**
     * 向好友推荐活动
     * @author by@Deng
     * @date 2018/2/27 下午4:28
     */
    @PostMapping("recommandAct")
   public Object recommandAct(@RequestBody List<RecommandActEntity> recommandActEntityList) throws Exception{

        SysUserEntity sysUserEntity1 = (SysUserEntity) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        for(RecommandActEntity recommandActEntity:recommandActEntityList){

            FriendEntity friendEntity = friendService.findEntityByMainId(recommandActEntity.getFriendId());
            if(friendEntity.getFriendId()!=null){
                recommandActEntity.setRecommandUser(friendEntity.getFriendId());
            }

            recommandActEntity.setUserId(sysUserEntity1.getId());
        }

        return recommandActService.insertEntityByBatch(recommandActEntityList);
   }


    /**
     * 获取所有好友推荐活动
     * @author by@Deng
     * @date 2018/2/27 下午5:10
     */
    @GetMapping("getRecommandList")
    public Object getRecommandList() throws Exception{
        List<Map<String,Object>> mapList = new ArrayList<>();

        SysUserEntity sysUserEntity1 = (SysUserEntity) SecurityUtils.getSubject().getSession().getAttribute("currentUser");

        RecommandActEntity recommandActEntity = new RecommandActEntity();
        recommandActEntity.setRecommandUser(sysUserEntity1.getId());
        List<RecommandActEntity> recommandActEntityList = recommandActService.findEntityList(recommandActEntity);
        for(RecommandActEntity recommandActEntity1 :recommandActEntityList){
            Map<String,Object> map = new HashMap<>();

            ActEntity actEntity =actService.findEntityByMainId(recommandActEntity1.getActId());
            map.put("actName",actEntity.getActName());
            map.put("id",actEntity.getId());
            map.put("actTime", DateFormatUtils.format(actEntity.getActTime(),"yyyy-MM-dd HH:mm:ss"));
            map.put("communityName",communityService.findEntityByMainId(actEntity.getCommunityId()).getCommunityName());


            if(recommandActEntity1.getRecommandUser()!=null){
                FriendEntity friendEntity = friendService.findEntityByMainId(recommandActEntity1.getFriendId());
                map.put("recommandName",friendEntity.getName());
            }else{
                map.put("recommandName",sysUserService.findEntityByMainId(recommandActEntity1.getRecommandUser()));
            }

            mapList.add(map);
        }
        return mapList;
   }

}