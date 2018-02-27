package com.xsh.activity.module.act.controller;

import com.xsh.activity.common.annotation.Result;
import com.xsh.activity.common.exception.ByException;
import com.xsh.activity.module.act.entity.FriendEntity;
import com.xsh.activity.module.act.entity.FriendGroupEntity;
import com.xsh.activity.module.act.entity.SysUserEntity;
import com.xsh.activity.module.act.service.FriendService;
import com.xsh.activity.module.act.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.xsh.activity.module.act.service.FriendGroupService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
* friendGroup表对应实体类的控制层
*
* @author by@Deng
* @create 2018-02-26 08:42:33
*/
@RestController
@RequestMapping("friendGroup")
@Result
public class FriendGroupController{

    @Resource
    private FriendGroupService friendGroupService;
    @Resource
    private FriendService friendService;
    @Resource
    private SysUserService sysUserService;


    /**
     * 添加分组
     * @author by@Deng
     * @date 2018/2/26 上午8:31
     */
    @PostMapping("addGroupByUserId")
    public Object addGroupByUserId(@RequestBody FriendGroupEntity friendGroupEntity) throws Exception{

        SysUserEntity sysUserEntity = (SysUserEntity) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        friendGroupEntity.setUserId(sysUserEntity.getId());

        return friendGroupService.insertEntity(friendGroupEntity);
    }


    /**
     * 获取分组和好友信息
     * @author by@Deng
     * @date 2018/2/26 上午8:50
     */
    @GetMapping("getGroupFriendList")
    public Object getGroupFriendList() throws Exception{
        List<Map<String,Object>> mapList = new ArrayList<>();

        SysUserEntity sysUserEntity = (SysUserEntity) SecurityUtils.getSubject().getSession().getAttribute("currentUser");

        FriendGroupEntity friendGroupEntity = new FriendGroupEntity();
        friendGroupEntity.setUserId(sysUserEntity.getId());
        List<FriendGroupEntity> friendGroupEntityList = friendGroupService.findEntityList(friendGroupEntity);

        for(FriendGroupEntity friendGroupEntity1:friendGroupEntityList){
            Map<String,Object> map = new HashMap<>();

            map.put("groupName",friendGroupEntity1.getGroupName());
            map.put("id",friendGroupEntity1.getId());

            //获取分组中的所有好友
            List<Map<String,Object>> friendMapList = new ArrayList<>();

            FriendEntity friendEntity = new FriendEntity();
            friendEntity.setUserId(sysUserEntity.getId());
            friendEntity.setGroupId(friendGroupEntity1.getId());

            List<FriendEntity> friendEntityList = friendService.findEntityList(friendEntity);
            for(FriendEntity friendEntity1:friendEntityList){
                Map<String,Object> friendMap = new HashMap<>();
                friendMap.put("friendId",friendEntity1.getId());

                if(friendEntity1.getFriendId()==null){
                    friendMap.put("name",friendEntity1.getName());
                }else{
                    friendMap.put("name",sysUserService.findEntityByMainId(friendEntity1.getFriendId()).getName());
                }


                friendMapList.add(friendMap);
            }
            map.put("friendMapList",friendMapList);

            mapList.add(map);
        }

        return mapList;
    }


    /**
     * 删除分组
     * @author by@Deng
     * @date 2018/2/26 上午8:53
     */
    @PostMapping("delFriendGroup")
    public Object delFriendGroup(@RequestParam Integer id) throws Exception{

        //删除分组前判断有无好友
        FriendEntity friendEntity = new FriendEntity();
        friendEntity.setGroupId(id);
        List<FriendEntity> friendEntityList = friendService.findEntityList(friendEntity);
        if(friendEntityList.size()>0){
            throw new ByException("将该分组内好友移到到其他分组再删除");
        }

        return friendGroupService.deleteEntity(id);
    }


    /**
     * 更新分组
     * @author by@Deng
     * @date 2018/2/26 下午2:05
     */
    @PostMapping("updateFriendGroup")
    public Object updateFriendGroup(@RequestBody FriendEntity friendEntity) throws Exception{

        friendService.updateEntity(friendEntity);

        return 1;
    }

}