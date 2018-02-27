package com.xsh.activity.module.act.controller;

import com.xsh.activity.common.annotation.Result;
import com.xsh.activity.module.act.entity.FriendEntity;
import com.xsh.activity.module.act.entity.RecommandActEntity;
import com.xsh.activity.module.act.entity.SysUserEntity;
import com.xsh.activity.module.act.service.*;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;


/**
* friend表对应实体类的控制层
*
* @author by@Deng
* @create 2018-02-26 08:54:36
*/
@RestController
@RequestMapping("friend")
@Result
public class FriendController{

    @Resource
    private FriendService friendService;
    @Resource
    private CollegeService collegeService;
    @Resource
    private ProfessionService professionService;
    @Resource
    private SysUserService sysUserService;
    @Resource
    private RecommandActService recommandActService;



    /**
     * 添加好友
     * @author by@Deng
     * @date 2018/2/26 上午11:31
     */
    @PostMapping("addFriend")
    public Object addFriend(@RequestBody FriendEntity friendEntity) throws Exception{

        SysUserEntity sysUserEntity1 = (SysUserEntity) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        friendEntity.setUserId(sysUserEntity1.getId());

        return friendService.insertEntity(friendEntity);
    }


    /**
     * 删除好友
     * @author by@Deng
     * @date 2018/2/26 下午2:19
     */
    @PostMapping("delFriend")
    public Object delFriend(@RequestParam Integer id) throws Exception{
        return friendService.deleteEntity(id);
    }


    /**
     * 获取好友信息
     * @author by@Deng
     * @date 2018/2/26 下午2:28
     */
    @GetMapping("getUserInfoMap")
    public Object getUserInfoMap(@RequestParam Integer id) throws Exception{
        Map<String,Object> map = new HashMap<>();

        FriendEntity friendEntity = friendService.findEntityByMainId(id);

        if(friendEntity.getFriendId()==null){
            //非系统好友
            map.put("number",friendEntity.getNumber());
            map.put("name",friendEntity.getName());
            map.put("phone",friendEntity.getPhone());
            map.put("sex",friendEntity.getSex());

            map.put("collegeName",collegeService.findEntityByMainId(friendEntity.getCollegeId()).getCollegeName());
            map.put("professionName",professionService.findEntityByMainId(friendEntity.getProfessionId()).getProfessionName());
        }else{
            //系统好友
            SysUserEntity sysUserEntity = sysUserService.findEntityByMainId(friendEntity.getFriendId());

            map.put("number",sysUserEntity.getNumber());
            map.put("name",sysUserEntity.getName());
            map.put("phone",sysUserEntity.getPhone());
            map.put("sex",sysUserEntity.getSex());

            map.put("collegeName",collegeService.findEntityByMainId(sysUserEntity.getCollegeId()).getCollegeName());
            map.put("professionName",professionService.findEntityByMainId(sysUserEntity.getProfessionId()).getProfessionName());
        }

        return map;
    }


    /**
     * 获取向推荐的好友
     * @author by@Deng
     * @date 2018/2/27 下午4:10
     */
    @GetMapping("getCommandFriend")
    public Object getCommandFriend(@RequestParam String actId) throws Exception{

        SysUserEntity sysUserEntity1 = (SysUserEntity) SecurityUtils.getSubject().getSession().getAttribute("currentUser");

        FriendEntity friendEntity = new FriendEntity();
        friendEntity.setUserId(sysUserEntity1.getId());

        List<FriendEntity> friendEntityList = friendService.findEntityList(friendEntity);

        List<Map<String,Object>> mapList = new ArrayList<>();
        for(FriendEntity friendEntity1 :friendEntityList){

            Map<String,Object> map = new HashMap<>();

            //判断该活动是否已经推荐给了该好友
            RecommandActEntity recommandActEntity = new RecommandActEntity();
            recommandActEntity.setActId(actId);
            recommandActEntity.setUserId(sysUserEntity1.getId());
            recommandActEntity.setRecommandUser(friendEntity1.getId());

            if(recommandActService.findEntityByOne(recommandActEntity)==null){
                map.put("id",friendEntity1.getId());
                if(friendEntity1.getFriendId()==null){
                    //非系统好友
                    map.put("name",friendEntity1.getName());
                }else{
                    //系统好友
                    SysUserEntity sysUserEntity = sysUserService.findEntityByMainId(friendEntity1.getFriendId());
                    map.put("name",sysUserEntity.getName());
                }

                mapList.add(map);
            }
        }


        return mapList;
    }

}