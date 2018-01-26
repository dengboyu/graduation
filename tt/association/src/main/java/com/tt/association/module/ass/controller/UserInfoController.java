package com.tt.association.module.ass.controller;

import com.tt.association.common.annotation.Result;
import com.tt.association.module.ass.entity.UserInfoEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.security.auth.Subject;
import javax.ws.rs.GET;

import com.tt.association.module.ass.service.UserInfoService;


/**
* user_info表对应实体类的控制层
*
* @author by@Deng
* @create 2018-01-24 10:49:47
*/
@RestController
@RequestMapping("userInfo")
@Result
public class UserInfoController{

    @Resource
    private UserInfoService userInfoService;


    /**
     * 添加学生
     * @author by@Deng
     * @date 2018/1/24 下午10:54
     */
    @PostMapping("insertUserInfoEntity")
    public Object insertUserInfoEntity(@RequestBody UserInfoEntity userInfoEntity) throws Exception{
        return userInfoService.insertEntity(userInfoEntity);
    }


    /**
     * 获取当前域或登录名信息
     * @author by@Deng
     * @date 2018/1/24 下午11:29
     */
    @GetMapping("getUserInfoEntity")
    public Object getUserInfoEntity() throws Exception{

        Session session= SecurityUtils.getSubject().getSession();
        UserInfoEntity userInfoEntity = (UserInfoEntity) session.getAttribute("currentUser");

        return userInfoEntity;
    }


}