package com.xsh.activity.module.act.controller;

import com.xsh.activity.common.annotation.Result;
import com.xsh.activity.common.exception.ByException;
import com.xsh.activity.module.act.entity.FriendEntity;
import com.xsh.activity.module.act.entity.SysUserEntity;
import com.xsh.activity.module.act.service.CollegeService;
import com.xsh.activity.module.act.service.FriendService;
import com.xsh.activity.module.act.service.ProfessionService;
import com.xsh.activity.utils.ResultDataUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.xsh.activity.module.act.service.SysUserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
* sys_user表对应实体类的控制层
*
* @author by@Deng
* @create 2018-02-25 09:29:52
*/
@RestController
@RequestMapping("sysUser")
@Result
public class SysUserController{

    @Resource
    private SysUserService sysUserService;
    @Resource
    private CollegeService collegeService;
    @Resource
    private ProfessionService professionService;
    @Resource
    private FriendService friendService;


    /**
     * 退出登录
     * @author by@Deng
     * @date 2018/2/25 上午11:29
     */
    @PostMapping("logout")
    public Object logout() throws Exception{
        Subject subject = SecurityUtils.getSubject();
        subject.getSession().removeAttribute("currentUser");
        return 1;
    }


    /**
     * 获取域里信息
     * @author by@Deng
     * @date 2018/2/25 上午11:30
     */
    @GetMapping("getUserInfo")
    public Object getUserInfo() throws Exception{
        return SecurityUtils.getSubject().getSession().getAttribute("currentUser");
    }


    /**
     * 注册用户
     * @author by@Deng
     * @date 2018/2/25 下午4:34
     */
    @PostMapping("addSysUser")
    public Object addSysUser(@RequestBody SysUserEntity sysUserEntity) throws Exception{

        SysUserEntity sysUserEntity1 = new SysUserEntity();
        sysUserEntity1.setNumber(sysUserEntity.getNumber());
        List<SysUserEntity> sysUserEntityList =sysUserService.findEntityList(sysUserEntity1);
        if(sysUserEntityList.size()>0){
            throw new ByException("该学号已经注册");
        }


        //注册用户
        sysUserService.insertEntity(sysUserEntity);

        //判断是否被别人加为朋友
        FriendEntity friendEntity = new FriendEntity();
        friendEntity.setNumber(sysUserEntity.getNumber());
        List<FriendEntity> friendEntityList = friendService.findEntityList(friendEntity);
        for(FriendEntity friendEntity1:friendEntityList){
            friendEntity1.setFriendId(sysUserEntity.getId());

            friendService.updateEntity(friendEntity1);
        }

        return 1;
    }


    /**
     * 根据用户id获取用户信息
     * @author by@Deng
     * @date 2018/2/25 下午4:46
     */
    @GetMapping("getSysUserInfo")
    public Object getSysUserInfo() throws Exception{
        Map<String,Object> map = new HashMap<>();

        SysUserEntity sysUserEntity1 = (SysUserEntity)SecurityUtils.getSubject().getSession().getAttribute("currentUser");

        SysUserEntity sysUserEntity = sysUserService.findEntityByMainId(sysUserEntity1.getId());

        map.put("id",sysUserEntity.getId());
        map.put("number",sysUserEntity.getNumber());
        map.put("name",sysUserEntity.getName());
        map.put("email",sysUserEntity.getEmail());
        map.put("phone",sysUserEntity.getPhone());
        map.put("collegeName",collegeService.findEntityByMainId(sysUserEntity.getCollegeId()).getCollegeName());
        map.put("professionName",professionService.findEntityByMainId(sysUserEntity.getProfessionId()).getProfessionName());
        map.put("sex",sysUserEntity.getSex());
        return map;
    }


    /**
     * 更新用户信息
     * @author by@Deng
     * @date 2018/2/25 下午5:03
     */
    @PostMapping("updateUserInfo")
    public Object updateUserInfo(@RequestBody SysUserEntity sysUserEntity) throws Exception{

        SysUserEntity sysUserEntity1 = new SysUserEntity();
        sysUserEntity1.setNumber(sysUserEntity.getNumber());

        List<SysUserEntity> sysUserEntityList =sysUserService.findEntityList(sysUserEntity1);
        if(sysUserEntityList.size()<1){
            throw new ByException("该学号未注册");
        }
        sysUserEntity.setId(sysUserEntityList.get(0).getId());
        return sysUserService.updateEntity(sysUserEntity);
    }


    /**
     * 根据学号查找信息
     * @author by@Deng
     * @date 2018/2/26 上午9:48
     */
    @GetMapping("getFriendInfo")
    public Object getFriendInfo(@RequestParam String number) throws Exception{

        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setNumber(number);

        sysUserEntity = sysUserService.findEntityByOne(sysUserEntity);

        if(sysUserEntity==null){
            return null;
        }

        Map<String,Object> map = new HashMap<>();
        map.put("number",sysUserEntity.getNumber());
        map.put("name",sysUserEntity.getName());
        map.put("email",sysUserEntity.getEmail());
        map.put("phone",sysUserEntity.getPhone());
        map.put("collegeName",collegeService.findEntityByMainId(sysUserEntity.getCollegeId()).getCollegeName());
        map.put("professionName",professionService.findEntityByMainId(sysUserEntity.getProfessionId()).getProfessionName());
        map.put("sex",sysUserEntity.getSex());
        map.put("id",sysUserEntity.getId());

        return map;
    }


}