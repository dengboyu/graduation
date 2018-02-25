package com.xsh.activity.module.act.controller;

import com.xsh.activity.common.annotation.Result;
import com.xsh.activity.module.act.entity.SysUserEntity;
import com.xsh.activity.utils.ResultDataUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.xsh.activity.module.act.service.SysUserService;


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



}